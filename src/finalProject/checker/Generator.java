package finalProject.checker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import finalProject.grammar.EloquenceBaseVisitor;
import finalProject.grammar.EloquenceParser;
import finalProject.grammar.EloquenceParser.ExprCompoundContext;
import finalProject.grammar.EloquenceParser.ExprFuncContext;
import finalProject.grammar.EloquenceParser.ExpressionContext;
import finalProject.grammar.EloquenceParser.NewIDContext;
import finalProject.grammar.EloquenceParser.ParamRefContext;
import finalProject.grammar.EloquenceParser.ParamValContext;
import finalProject.grammar.EloquenceParser.ParametersContext;
import finalProject.grammar.EloquenceParser.ReturnFuncContext;
import finalProject.grammar.EloquenceParser.TargetContext;
import finalProject.grammar.EloquenceParser.VoidFuncContext;
import pp.iloc.*;
import pp.iloc.model.*;

public class Generator extends EloquenceBaseVisitor<Op>{
	/** The representation of the boolean value <code>false</code>. */
	public final static Num FALSE_VALUE = new Num(Simulator.FALSE);
	/** The representation of the boolean value <code>true</code>. */
	public final static Num TRUE_VALUE = new Num(Simulator.TRUE);

	/** The base register. */
	private Reg arp = new Reg("r_arp");
	/** The outcome of the checker phase. */
	private Result checkResult;
	/** Association of statement nodes to labels. */
	private ParseTreeProperty<Label> labels;
	/** The program being built. */
	private Program prog;
	/** Register count, used to generate fresh registers. */
	private int regCount;
	/** Association of expression and target nodes to registers. */
	private ParseTreeProperty<Reg> regs;
	
	private final Reg reg1 = new Reg("r1");
	private final Reg reg2 = new Reg("r2");
	private final Reg reg3 = new Reg("r3");
	private final Reg reg4 = new Reg("r4");
	private final Reg reg5 = new Reg("r5");
	private final Reg reg6 = new Reg("r6");
	private final Reg reg_error = new Reg("reg_error");
	
	/** A mapping from function Ids to their labels*/
	Map<String, Label> funcAddr = new HashMap<String,Label>();
	
	Map<String, Label> runtimeErrors = new HashMap<String,Label>();

	public Program generate(ParseTree tree, Result checkResult) {
		this.prog = new Program();
		this.checkResult = checkResult;
		this.regs = new ParseTreeProperty<>();
		this.labels = new ParseTreeProperty<>();
		this.regCount = 0;
		tree.accept(this);
		return this.prog;
	}

	// Override the visitor methods
	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private Op emit(Label label, OpCode opCode, Operand... args) {
		Op result = new Op(label, opCode, args);
		System.out.println(result.toString());
		this.prog.addInstr(result);
		return result;
	}

	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private Op emit(OpCode opCode, Operand... args) {
		return emit((Label) null, opCode, args);
	}

	/** 
	 * Looks up the label for a given parse tree node,
	 * creating it if none has been created before.
	 * The label is actually constructed from the entry node
	 * in the flow graph, as stored in the checker result.
	 */
	private Label label(ParserRuleContext node) {
		Label result = this.labels.get(node);
		if (result == null) {
			ParserRuleContext entry = this.checkResult.getEntry(node);
			result = createLabel(entry, "n");
			this.labels.put(node, result);
		}
		return result;
	}

	/** Creates a label for a given parse tree node and prefix. */
	private Label createLabel(ParserRuleContext node, String prefix) {
		Token token = node.getStart();
		int line = token.getLine();
		int column = token.getCharPositionInLine();
		String result = prefix + "_" + line + "_" + column;
		return new Label(result);
	}

	/** Retrieves the offset of a variable node from the checker result,
	 * wrapped in a {@link Num} operand. */
	private Num offset(ParseTree node) {
		return new Num(this.checkResult.getOffset(node));
	}

	/** Returns a register for a given parse tree node,
	 * creating a fresh register if there is none for that node. */
	private Reg reg(ParseTree node) {
		Reg result = this.regs.get(node);
		if (result == null) {
			result = new Reg("r_" + this.regCount);
			this.regs.put(node, result);
			this.regCount++;
		}
		return result;
	}

	/** Assigns a register to a given parse tree node. */
	private void setReg(ParseTree node, Reg reg) {
		this.regs.put(node, reg);
	}
	
	/**	When a program is visited it initially has to visit all its children. All runtime errors are
	 * handled here as well. A label is created for every type of runtime error, and a value is assigned
	 * to reg_error. In case of a runtime error, the program jumps to this label. In this case has a label
	 * indexOutOfBounds, which corresponds to a user indexing an array out of bounds. After jumping to
	 * the runtime error node, the program outputs the error and jumps to the end. The rest of the ILOC code
	 * is then not created. 
	 * 
	 * */
	@Override public Op visitProgram(EloquenceParser.ProgramContext ctx) { 
		//Label to be jumped to in case of Index out of bounds
		Label indexOutOfBounds = createLabel(ctx, "indexOutOfBounds");	
		runtimeErrors.put("indexOutOfBounds", indexOutOfBounds);
		visitChildren(ctx);
		Label programEnd = createLabel(ctx, "programEnd");	//Label for end of the program
		emit(OpCode.jumpI, programEnd);						//Jump to program end in case of no error.
		
	
		emit(indexOutOfBounds, OpCode.nop);			//Start of section index out of bounds
		emit(OpCode.out, new Str("Error: Array index out of bounds "), reg_error);	//Output the error
		emit(OpCode.jumpI, programEnd);				//Jump to program end
		
		emit(programEnd,OpCode.nop);				//Program end
		return null; }
	
	/** After entering the program, the body is visited. Initially all the children of the body are visited
	 * The body can contain statements, in such case the body can be part of a compound statement and can thus
	 * be assigned. The body must hold the value of the last statement of a compound expression. That value
	 * is stored in the register of the ctx of visitBody.
	 * 
	 */
	@Override public Op visitBody(EloquenceParser.BodyContext ctx) {
		
		visitChildren(ctx);
		if(ctx.stat().size()>0){		//If the body has statements
			if(checkResult.getType(ctx) != null){		//If the type of the stat is not null.
				if(checkResult.getType(ctx).equals(Type.CHAR)){
					emit(OpCode.c2c, reg(ctx.stat(ctx.stat().size()-1)), reg(ctx));	//c2c in case of char
				}else if(checkResult.getType(ctx) != null){
					emit(OpCode.i2i, reg(ctx.stat(ctx.stat().size()-1)), reg(ctx)); //i2i in case of bool or int
				}
			}
		}
		return null; }
	
	/**
	 * Visit variable declarations. This is not declarations of arrays or constants. Since it is possible to
	 * declare multiple new IDs, the function loops over every new ID and checks if immediately an expression
	 * is assigned. In case there is no immediate assignment, the it simply loads the value 0 into the reg
	 * of that ID. Otherwise - there is an assignment - the register of the 
	 */
	@Override public Op visitDeclVar(EloquenceParser.DeclVarContext ctx) { 
		visitChildren(ctx);
		for(NewIDContext newId : ctx.variable().newID()){	//For every new ID do the following.
				if(ctx.expression() != null){
					emit(OpCode.i2i, reg(ctx.expression()), reg(newId.ID())); //Copy the expression to the reg(ID)
				} else{
					emit(OpCode.loadI, new Num(0), reg(newId.ID()));	// In case there is no assignment, load 0
				}
				emit(OpCode.storeAI,reg(newId.ID()),arp, offset(newId.ID()));
		}
		
		return null; 
	
	}
	/**
	 * Declaration of constants. Initially this functions visits the underlying expressions and (new) IDs.
	 * For every ID the value of the register of the Expression is stored at the memory offset of the ID.
	 * If there is no assignment of a value, then the value 0 is stored at the memory location.
	 * 
	 * @require ctx.newID().ID() != null
	 * @ensure value of ID != null
	 */
	@Override public Op visitDeclConstVar(EloquenceParser.DeclConstVarContext ctx) {
		visitChildren(ctx);
		for(NewIDContext newId : ctx.variable().newID()){	//For every new ID do the following.
				if(ctx.expression() != null){
					emit(OpCode.i2i, reg(ctx.expression()), reg1); //Copy the expression to the reg(ID)
				} else{
					emit(OpCode.loadI, new Num(0), reg1); // In case there is no assignment, load 0
				}
				emit(OpCode.storeAI,reg1,arp, offset(newId.ID()));
		}
		
		return null;   }
	/**
	 * Visit the children. The children of this context allow for either a variable declaration of an array
	 * or a constant declaration.
	 * @require ctx != null
	 * @ensure new array is declared
	 */
	@Override public Op visitDeclArray(EloquenceParser.DeclArrayContext ctx) { return visitChildren(ctx); }
	
	/**
	 * Creates a new upon visiting its children.
	 * @require ctx != null && ctx.children() != null
	 * @ensure create new ID
	 */
	@Override public Op visitVariable(EloquenceParser.VariableContext ctx) {
		
		return visitChildren(ctx); }

	/**
	 * Creates a given array type. This type has an ID, type and upper and lower bound. This function
	 * must initially visit its children so that the ID, upper and lower bounds can be determined.
	 * Afterwards, the lower bound is stored in the offset of the ID. The upper bound is stored at 
	 * the offset + 4. 
	 * 
	 * @require ctx != null && ctx.children() != null && offset(ctx.newID().ID()) != null
	 * @ensure offset(ctx.newID().ID()) == lower bound && offset(ctx.newID().ID()) + 4 == upper bound
	 */
	@Override public Op visitArrayTypeDecl(EloquenceParser.ArrayTypeDeclContext ctx) {
		visitChildren(ctx);
		
		
		//reg1 contains the left bound, reg2 contains the right bound
		emit(OpCode.storeAI,reg1,arp, offset(ctx.newID().ID()));	//Store the left bound of the array 
		emit(OpCode.loadI, offset(ctx.newID().ID()), reg3);
		emit(OpCode.addI, reg3, new Num(4), reg3);					//Add four to the offset to get higher bound
		emit(OpCode.storeAO,reg2,arp, reg3);						//Store the upper bound
		
		
		return null; }
	
	/**
	 * Sets the lower and upper bound of an arrayTypeDeclaration. The two values are stored in local
	 * register. The parent then uses these registers to set their upper and lower bound.
	 * 
	 * @require ctx != null && ctx.children() != null
	 * @ensure reg1 == lower bound && reg2 == upper bound
	 */
	@Override public Op visitArrayElem(EloquenceParser.ArrayElemContext ctx) {
		visitChildren(ctx);
		emit(OpCode.loadI, new Num(Integer.parseInt(ctx.NUM(0).getText())), reg1);	//Load lower bound in reg1
		emit(OpCode.loadI, new Num(Integer.parseInt(ctx.NUM(1).getText())), reg2);	//Load upper bound in reg2
		return null; }
	
	/**
	 * Creates an array based on an array type. The lower and upper bounds are copied from the array type
	 * and stored at positions offset(ID) and offset(ID) + 4 respectively. 
	 * Every expression is then stored at offset + 4 for every ID declared. 
	 * 
	 * @require ctx != null && ctx.children() != null && offset(ctx.target)  != null && offset(ID) != null
	 * @ensure offset(ID) == lower bound offset(ID) + 4 == upper bound
	 */
	@Override public Op visitVarArrayDecl(EloquenceParser.VarArrayDeclContext ctx) { 
		visitChildren(ctx);
		
		
		for(NewIDContext newId : ctx.newID()){	//For every new  ID do the following
			emit(OpCode.storeAI, reg(ctx.target()), arp, offset(newId.ID()));
			
			emit(OpCode.loadI, offset(ctx.target()),reg1);	//load offset in reg1
			emit(OpCode.addI, reg1, new Num(4), reg1);		//add 4 to the offset
			emit(OpCode.loadAO, arp, reg1, reg1); 			//Load the ending value in reg1
			
			emit(OpCode.loadI, offset(newId.ID()), reg2);	
			emit(OpCode.addI, reg2, new Num(4), reg2);
			emit(OpCode.storeAO, reg1, arp,reg2);			
			
			if(ctx.SETARRAY() != null){
				for(ExpressionContext c : ctx.expression()){		//For every expression
					emit(OpCode.addI, reg2, new Num(4), reg2);		//Set the correct offset
					emit(OpCode.storeAO, reg(c), arp,reg2);	//Store the value of the expression at the correct place
				}
				
			}
			
		}
		return null; }
	
	/**
	 * Creates an array based on an array type. The lower and upper bounds are copied from the array type
	 * and stored at positions offset(ID) and offset(ID) + 4 respectively. 
	 * Every expression is then stored at offset + 4 for every ID declared. 
	 * 
	 * @require ctx != null && ctx.children() != null && offset(ctx.target)  != null && offset(ID) != null
	 * @ensure offset(ID) == lower bound offset(ID) + 4 == upper bound
	 */
	@Override public Op visitConstArrayDecl(EloquenceParser.ConstArrayDeclContext ctx) {
		visitChildren(ctx);
		
		for(NewIDContext newId : ctx.newID()){
			emit(OpCode.storeAI, reg(ctx.target()), arp, offset(newId.ID()));
			
			emit(OpCode.loadI, offset(ctx.target()),reg1);	//load offset in reg1
			emit(OpCode.addI, reg1, new Num(4), reg1);		//add 4 to the offset
			emit(OpCode.loadAO, arp, reg1, reg1); //Load the ending value in reg1
			
			emit(OpCode.loadI, offset(newId.ID()), reg2);
			emit(OpCode.addI, reg2, new Num(4), reg2);
			emit(OpCode.storeAO, reg1, arp,reg2);
			

			for(ExpressionContext c : ctx.expression()){
				emit(OpCode.addI, reg2, new Num(4), reg2);
				emit(OpCode.storeAO, reg(c), arp,reg2);
			}
		}
		return null;  }
	
	/**
	 * The if statement. After visiting the expression (or condition) a label is placed in front of the body.
	 * A label is also placed at the end of the If. In case the condition is false, the program jumps
	 * to the end of the IF. 
	 * 
	 * @require ctx != null && ctx.children() != null && ctx.stat() != null
	 * @ensure reg(ctx) = reg(ctx.stat(0)) || reg(ctx) = reg(ctx.stat(1))
	 */
	@Override public Op visitStatIf(EloquenceParser.StatIfContext ctx) { 
		
		Label body = createLabel(ctx, "ifBody");			//Label for the body
		Label ifContinue = createLabel(ctx, "continue");	//Label for end of the if
		visit(ctx.expression());

		if(ctx.expression() instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression()));
		 
		if(ctx.ELSE() == null){ //There is no else
			emit(OpCode.cbr, reg(ctx.expression()), body, ifContinue);
			emit(body, OpCode.nop);
			visit(ctx.stat(0));
			if(checkResult.getType(ctx.stat(0)) != null){	//Place the value of the statement in reg(ctx)
				if(checkResult.getType(ctx.stat(0)).equals(Type.CHAR)){
					emit(OpCode.c2c, reg(ctx.stat(0)), reg(ctx));
				}else if(checkResult.getType(ctx.stat(0)) != null){
					emit(OpCode.i2i, reg(ctx.stat(0)), reg(ctx));
				}
			}
			emit(OpCode.jumpI, ifContinue);
		} else {				//There is an else part
			Label elseBody = createLabel(ctx, "elseBody");
			emit(OpCode.cbr, reg(ctx.expression()), body, elseBody);
			emit(body, OpCode.nop);
			visit(ctx.stat(0));
			if(checkResult.getType(ctx.stat(0)) != null){
				if(checkResult.getType(ctx.stat(0)).equals(Type.CHAR)){
					emit(OpCode.c2c, reg(ctx.stat(0)), reg(ctx));
				}else if(checkResult.getType(ctx.stat(0)) != null){
					emit(OpCode.i2i, reg(ctx.stat(0)), reg(ctx));
				}
			}
			emit(OpCode.jumpI, ifContinue);
			emit(elseBody, OpCode.nop);
			visit(ctx.stat(1));
			if(checkResult.getType(ctx.stat(1)) != null){//Place the value of the statement in reg(ctx)
				if(checkResult.getType(ctx.stat(1)).equals(Type.CHAR)){
					emit(OpCode.c2c, reg(ctx.stat(1)), reg(ctx));
				}else if(checkResult.getType(ctx.stat(1)) != null){
					emit(OpCode.i2i, reg(ctx.stat(1)), reg(ctx));
				}
			}
		}
		
		emit(ifContinue, OpCode.nop);
		return null; }
	
	/**
	 * After visiting the condition, ctx.expression, a label is placed in front of the body of the while.
	 * A label is also placed at the end of the while. Depending on the condition, the program will 
	 * either jump to the end or the while body again. After it reaches the end of the body, the program
	 * jumps back to the condition. At the end of the body the program jumps back the condition. 
	 * 
	 * @require ctx != null && ctx.children != null. 
	 * @ensure reg(ctx)  == null
	 */
	@Override public Op visitStatWhile(EloquenceParser.StatWhileContext ctx) { 
		if(ctx.expression() instanceof ExprCompoundContext)
			visit(((ExprCompoundContext)ctx.expression()).body());
		
		if(labels.get(ctx) != null){
			emit(labels.get(ctx),OpCode.nop);
		}	else{
			Label whileLoop = createLabel(ctx, "whileLoop");
			labels.put(ctx, whileLoop);
			emit(whileLoop, OpCode.nop);
		}
		
		Label whileBody = createLabel(ctx.stat(), "whileBody");	//Label for the body of the while
		Label whileContinue = createLabel(ctx, "whileContinue");	//Label for the end of the while
		
		if(ctx.expression() instanceof ExprCompoundContext)
			visit(((ExprCompoundContext)ctx.expression()).expression());
		else
			visit(ctx.expression());

		if(ctx.expression() instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression()));
		
		if(ctx.expression() instanceof ExprCompoundContext)
			emit(OpCode.cbr, reg(((ExprCompoundContext)ctx.expression()).expression()), whileBody, whileContinue);
		else
			emit(OpCode.cbr, reg(ctx.expression()), whileBody, whileContinue);
		
		emit(OpCode.cbr, reg(ctx.expression()), whileBody, whileContinue);	//Branch to end or to the body
		emit(whileBody, OpCode.nop);
		visit(ctx.stat());
		emit(OpCode.jumpI, labels.get(ctx));
		emit(whileContinue, OpCode.nop);
		
		return null; }
	
	/**
	 * For every ID the expression is copied to the register of the ctx.target. In case the type of
	 * the expression is not int, char or bool, then it is type array. In that case, two arrays are 
	 * being assigned to each other. For every value of one array, the value needs to be assigned to
	 * the other. So all the offsets are computed and the values are then assigned. 
	 * 
	 * @require ctx != null && ctx.children != null
	 * @ensure ctx.target == ctx.expression
	 */
	@Override public Op visitStatAssign(EloquenceParser.StatAssignContext ctx) { 
		visitChildren(ctx);
		if(checkResult.getType(ctx.expression()) != null){
			if(checkResult.getType(ctx.expression()).equals(Type.CHAR)){
				emit(OpCode.c2c, reg(ctx.expression()),reg(ctx));
				emit(OpCode.storeAI, reg(ctx), arp, offset(ctx));
				
				for(TargetContext target : ctx.target()){
					emit(OpCode.c2c, reg(ctx.expression()),reg(target));
					emit(OpCode.storeAI, reg(target), arp, offset(target));
				}
			}
			else if(checkResult.getType(ctx.expression()).equals(Type.INT) || checkResult.getType(ctx.expression()).equals(Type.BOOL)){
				
				emit(OpCode.i2i, reg(ctx.expression()),reg(ctx));
				emit(OpCode.storeAI, reg(ctx), arp, offset(ctx)); 
				
				for(TargetContext target : ctx.target()){
					emit(OpCode.i2i, reg(ctx.expression()),reg(target));
					emit(OpCode.storeAI, reg(target), arp, offset(target));
				}
				
			} else if(!checkResult.getType(ctx.target(0)).equals(Type.INT) &&
					!checkResult.getType(ctx.target(0)).equals(Type.BOOL) &&
					!checkResult.getType(ctx.target(0)).equals(Type.CHAR)
					){										//Target is an array
				
				for(TargetContext target : ctx.target()){
					emit(OpCode.loadAI, arp, offset(target), reg1);	//Reg1 now contains lower bound
					emit(OpCode.loadI, new Num(4), reg2);
					emit(OpCode.loadI, offset(target), reg3);
					emit(OpCode.add, reg2,reg3,reg2);
					emit(OpCode.loadAO, arp, reg2, reg2); //Reg2 now contains the upper bound
					emit(OpCode.sub, reg2,reg1,reg1); //Reg1 contains the length of the array
					emit(OpCode.addI, reg1, new Num(1), reg1); //Reg1 now contains the length of the array
					emit(OpCode.loadI, new Num(0), reg2);	//Reg2: A counter to iterate over the array
					
					//Offset of target + 8
					emit(OpCode.loadI, offset(target),reg3);
					emit(OpCode.addI,reg3, new Num(8),reg3);	//reg3 contains the offset of target + 8
					
					emit(OpCode.loadI, offset(ctx.expression()),reg4);
					emit(OpCode.addI,reg4, new Num(8),reg4); //Offset of expression + 8
					
					
					Label arrayLoop = createLabel(target, "arrayLoop");
					Label arrayLoopEnd = createLabel(target, "arrayLoopEnd");
					
					emit(arrayLoop, OpCode.nop);	//Start of the array	
				
					emit(OpCode.loadAO,arp,reg4,reg5);//Load the expression value into reg5
					emit(OpCode.storeAO,reg5,arp,reg3);
					
					emit(OpCode.addI,reg3,new Num(4),reg3);	//Update the offsets
					emit(OpCode.addI,reg4,new Num(4),reg4);
					
					emit(OpCode.addI, reg2,new Num(1),reg2);	//Update the counter
					
					emit(OpCode.cmp_LT,reg2,reg1,reg6);
					emit(OpCode.cbr, reg6, arrayLoop,arrayLoopEnd);
					
					emit(arrayLoopEnd, OpCode.nop);
				
			
				}
				
				
			}
		}
		return null; }
	
	/**
	 * Assign one indexed array or multiple arrays bearing the same index to a given expression.
	 * 
	 * @require ctx != null && ctx.children != null
	 * @ensure ctx.target == ctx.expression || ctx.target[index] == ctx.expression
	 */
	@Override public Op visitStatAssignArray(EloquenceParser.StatAssignArrayContext ctx) {
		visitChildren(ctx);
		System.out.println("Stat assign array");
		emit(OpCode.i2i, reg(ctx.expression(ctx.expression().size()-1)),reg(ctx));
	for(TargetContext target : ctx.target()){
			//Start by computing the begin value of the array. We'll store that in reg1
			emit(OpCode.loadAI, arp, offset(target), reg1);
			//Now we need the index value. This is stored in expression(0). We'll store it in reg2
			emit(OpCode.loadI, new Num(Integer.parseInt(ctx.expression(0).getText())),reg2);
			emit(OpCode.i2i, reg(ctx.expression(0)), reg2);
			//Subtract the index by the begin value.
			emit(OpCode.sub, reg2, reg1, reg1);
			//Multiply by four to get the offset
			emit(OpCode.multI, reg1, new Num(4), reg1);
			//Add 8
			emit(OpCode.addI, reg1, new Num(8),reg1); //This is the address where the value needs to be stored.
			emit(OpCode.addI, reg1, offset(target),reg1);
			//The the target value
			emit(OpCode.storeAO, reg(ctx.expression(1)), arp,reg1);
	}
		return null; }
	/**
	 * Assign multiple values to an array. The function iterates over all the offset values and assigns
	 * the corresponding expression to it.
	 * 
	 * @require ctx != null && ctx.children != null
	 * @ensure ctx.target == ctx.expressions
	 */
	@Override public Op visitStatAssignArrayMult(EloquenceParser.StatAssignArrayMultContext ctx) {
		visitChildren(ctx);
		for(TargetContext target : ctx.target()){
			//Start by computing the begin value of the array. We'll store that in reg1
			emit(OpCode.loadI, offset(target), reg1);
			//Add 8 to not overwrite the starting and ending value
			emit(OpCode.addI, reg1, new Num(4),reg1); //This is the address where the value needs to be stored.
		
			//The the target value
			 for(int i = 0; i < ctx.expression().size();i++){
				 emit(OpCode.addI, reg1, new Num(4),reg1);
				 emit(OpCode.storeAO, reg(ctx.expression(i)), arp,reg1);
			 }
		}
		return null; }
	
	/**
	 * Create a blocked statement. The value of the blocked statement, in case of a compound
	 * expression is stored in reg(ctx)
	 * @require ctx != null && ctx.children != null
	 * @ensure reg(ctx) == reg(ctx.statBlockBody)
	 */
	@Override public Op visitStatBlock(EloquenceParser.StatBlockContext ctx) {
		visitChildren(ctx);
		
		if(checkResult.getType(ctx) != null){
			if(checkResult.getType(ctx).equals(Type.CHAR)){
				emit(OpCode.c2c, reg(ctx.statBlockBody()), reg(ctx));
			}else if(checkResult.getType(ctx) != null){
				emit(OpCode.i2i, reg(ctx.statBlockBody()), reg(ctx));
			}
		}
		
		return null; }
	/**
	 * Copies the value of the underlying expression to the current reg(ctx)
	 * @require ctx != null && ctx.children != null
	 * @ensure ret(ctx) == reg(ctx.expression)
	 */
	@Override public Op visitStatExpr(EloquenceParser.StatExprContext ctx) {
		visitChildren(ctx);

		if(ctx.expression() instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression()));
		
		if(checkResult.getType(ctx) != null){
			if(checkResult.getType(ctx).equals(Type.CHAR)){
				emit(OpCode.c2c, reg(ctx.expression()), reg(ctx));
			}else if(checkResult.getType(ctx) != null){
				emit(OpCode.i2i, reg(ctx.expression()), reg(ctx));
			}
		
		}
		return null;
	}
	/**
	 * Visits the children which make it possible to return from a function. 
	 * 
	 * @require ctx != null && ctx.children != null
	 */
	@Override public Op visitStatReturn(EloquenceParser.StatReturnContext ctx) { 
		visitChildren(ctx);
		return null; }
	/**
	 * Stores every input from the input stream in a target ID.
	 * 
	 * @require ctx != null && ctx.children != null
	 * @ensure regt(ctx) == reg(target)
	 */
	@Override public Op visitStatIn(EloquenceParser.StatInContext ctx) { 
		visitChildren(ctx);
		for(TargetContext target : ctx.target()){
			emit(OpCode.in,new Str(target.getText() + "?") ,reg(target));
			emit(OpCode.storeAI, reg(target), arp, offset(target));
			emit(OpCode.i2i, reg(target), reg(ctx));
		}
		
		return null; }
	/**
	 * Outputs for all the target its IDs. 
	 * @require ctx != null && ctx.children != null
	 */
	@Override public Op visitStatOut(EloquenceParser.StatOutContext ctx) { 
		
		visitChildren(ctx);
		
		for(ExpressionContext out : ctx.expression()){	//For every expression
			emit(OpCode.out, new Str("Output: ") , reg(out));	//Output the result
			emit(OpCode.i2i, reg(out), reg(ctx));
			if(out instanceof ExprFuncContext)
				emit(OpCode.pop, reg(out));
		}
		
		return null; }
	/**
	 * Calls a void funtcion. Since it is void, the reg of this ctx holds no value.
	 * @require ctx != null && ctx.children != null
	 */
	@Override public Op visitStatVoid(finalProject.grammar.EloquenceParser.StatVoidContext ctx) {
		
		visitChildren(ctx);
				
		return null; }
	/**
	 * The body of a blocked statement. The value of the body is stored in the reg(ctx)
	 * @require ctx != null && ctx.children != null
	 * @ensure reg(ctx) == reg(ctx.body)
	 */
	@Override public Op visitStatBlockBody(EloquenceParser.StatBlockBodyContext ctx) { 
		
		visitChildren(ctx);
		if(checkResult.getType(ctx) != null){
			if(checkResult.getType(ctx).equals(Type.CHAR)){
				emit(OpCode.c2c, reg(ctx.body()), reg(ctx));
			}else if(checkResult.getType(ctx) != null){
				emit(OpCode.i2i, reg(ctx.body()), reg(ctx));
			}
		}
		return null; }
	/**
	 * Load the value of an ID to its target register. 
	 * 
	 * @require ctx != null && ctx.children != null
	 * @ensure reg(ctx) == value of ID. 
	 */
	@Override public Op visitTargetId(EloquenceParser.TargetIdContext ctx) {
		visitChildren(ctx);
		emit(OpCode.loadAI, arp, offset(ctx.ID()), reg(ctx));
			return null;  }
	/**
	 * Creates a new ID.
	 * @require ctx != null && ctx.ID != null
	 * @ensure new ID is created
	 */
	@Override public Op visitNewID(EloquenceParser.NewIDContext ctx) {
		visitChildren(ctx);
		emit(OpCode.loadAI, arp, offset(ctx.ID()), reg(ctx.ID()));
		return null; }
	
	/**
	 * Returns from a function. Initially the return label is popped from the stack. 
	 * Then a dummy return value of 0 is popped. The real return value is pushed back on the stack.
	 * And then a jump is made to the return label.
	 * 
	 * @require ctx != null && ctx.children != null
	 * @ensure Return value is pushed on stack.
	 */
	@Override public Op visitReturnStat(EloquenceParser.ReturnStatContext ctx) { 
		visitChildren(ctx);
		
		if(ctx.expression() != null){
			if(ctx.expression() instanceof ExprFuncContext)
				emit(OpCode.pop, reg(ctx.expression()));
			
			emit(OpCode.pop, reg3);						//Pop return label
			emit(OpCode.pop,reg1);						//Pop return value of 0
			emit(OpCode.push, reg(ctx.expression()));	//Push actual return value
			emit(OpCode.jump, reg3);					//Jump to return label
			
			
		} else{
			
			emit(OpCode.pop, reg3);
			emit(OpCode.jump, reg3);
		}
		
		return null; }
	
	/**
	 * For every type of expression the resulting value of the expression is stored in reg(ctx). 
	 * The equals and not equals comparisons are different. For these two it is possible to compare
	 * entire arrays. In that case for both arrays the every offset is computed and compared. 
	 * 
	 * @require ctx != null && ctx.children != null
	 * @ensure reg(ctx) == comparison value
	 */
	@Override public Op visitExprComp(EloquenceParser.ExprCompContext ctx) { 
		visitChildren(ctx);

		if(ctx.expression(1) instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression(1)));
		if(ctx.expression(0) instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression(0)));
		
		if(ctx.compare().LT() != null){
			emit(OpCode.cmp_LT, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
		} else if(ctx.compare().LE() != null){
			emit(OpCode.cmp_LE, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
		} else if(ctx.compare().GE() != null){
			emit(OpCode.cmp_GE, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
		} else if(ctx.compare().GT() != null){
			emit(OpCode.cmp_GT, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
		} else if(ctx.compare().EQ() != null){
			
			if(!checkResult.getType(ctx.expression(0)).equals(Type.INT) &&
					!checkResult.getType(ctx.expression(0)).equals(Type.BOOL) &&
					!checkResult.getType(ctx.expression(0)).equals(Type.CHAR)
					){
				emit(OpCode.loadAI, arp, offset(ctx.expression(0)), reg1);	//Reg1 now contains lower bound
				emit(OpCode.loadI, new Num(4), reg2);
				emit(OpCode.loadI, offset(ctx.expression(0)), reg3);
				
				emit(OpCode.add, reg2,reg3,reg2);
				emit(OpCode.loadAO, arp, reg2, reg2); //Reg2 now contains the upper bound
				emit(OpCode.sub, reg2,reg1,reg1); //Reg1 contains the length of the array
				emit(OpCode.addI, reg1, new Num(1), reg1); //Reg1 now contains the length of the array1
				
				emit(OpCode.loadAI, arp, offset(ctx.expression(1)), reg2);	//Reg2 now contains lower bound of array2
				emit(OpCode.loadI, new Num(4), reg3);
				emit(OpCode.loadI, offset(ctx.expression(1)), reg4);
				
				emit(OpCode.add, reg3,reg4,reg3);
				emit(OpCode.loadAO, arp, reg3, reg3); //Reg3 now contains the upper bound
				emit(OpCode.sub, reg3,reg2,reg2); //Reg2 contains the length of the array
				emit(OpCode.addI, reg2, new Num(1), reg2); //Reg2 now contains the length of the array2
				
				
				Label equalLength = createLabel(ctx,"equalLength");
				Label arrayLoop = createLabel(ctx, "arrayLoop");
				Label arrayLoopEnd = createLabel(ctx, "arrayLoopEnd");
				Label equalValue = createLabel(ctx,"equalValue");
				
				emit(OpCode.cmp_EQ, reg1, reg2, reg(ctx));			//Are the arrays of equal length?
				
				emit(OpCode.cbr,reg(ctx),equalLength,arrayLoopEnd);
				emit(equalLength,OpCode.nop);
				
				emit(OpCode.loadI, new Num(0), reg2);	//Reg2: A counter to iterate over the array
				
				//Offset of target + 8
				emit(OpCode.loadI, offset(ctx.expression(0)),reg3);
				emit(OpCode.addI,reg3, new Num(8),reg3);	//reg3 contains the offset of array1 + 8
				
				emit(OpCode.loadI, offset(ctx.expression(1)),reg4);
				emit(OpCode.addI,reg4, new Num(8),reg4); //Offset of array2 + 8
				
				
				emit(arrayLoop, OpCode.nop);	//Start of the array loop
			
				emit(OpCode.loadAO,arp,reg4,reg5);//Load the array2 value into reg5
				emit(OpCode.loadAO,arp,reg3,reg6);
				emit(OpCode.cmp_EQ, reg5, reg6, reg(ctx));			//Are the arrays of equal length?
				emit(OpCode.cbr,reg(ctx),equalValue,arrayLoopEnd);
				emit(equalValue,OpCode.nop);
				
				emit(OpCode.addI,reg3,new Num(4),reg3);	//Update the offsets
				emit(OpCode.addI,reg4,new Num(4),reg4);
				
				emit(OpCode.addI, reg2,new Num(1),reg2);	//Update the counter
				
				emit(OpCode.cmp_LT,reg2,reg1,reg6);
				emit(OpCode.cbr, reg6, arrayLoop,arrayLoopEnd);
				
				emit(arrayLoopEnd, OpCode.nop);
				
				
				
			}else{
				emit(OpCode.cmp_EQ, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
			}
		} else if(ctx.compare().NE() != null){

			if(!checkResult.getType(ctx.expression(0)).equals(Type.INT) &&
					!checkResult.getType(ctx.expression(0)).equals(Type.BOOL) &&
					!checkResult.getType(ctx.expression(0)).equals(Type.CHAR)
					){
				emit(OpCode.loadAI, arp, offset(ctx.expression(0)), reg1);	//Reg1 now contains lower bound
				emit(OpCode.loadI, new Num(4), reg2);
				emit(OpCode.loadI, offset(ctx.expression(0)), reg3);
				
				emit(OpCode.add, reg2,reg3,reg2);
				emit(OpCode.loadAO, arp, reg2, reg2); //Reg2 now contains the upper bound
				emit(OpCode.sub, reg2,reg1,reg1); //Reg1 contains the length of the array
				emit(OpCode.addI, reg1, new Num(1), reg1); //Reg1 now contains the length of the array1
				
				emit(OpCode.loadAI, arp, offset(ctx.expression(1)), reg2);	//Reg2 now contains lower bound of array2
				emit(OpCode.loadI, new Num(4), reg3);
				emit(OpCode.loadI, offset(ctx.expression(1)), reg4);
				
				emit(OpCode.add, reg3,reg4,reg3);
				emit(OpCode.loadAO, arp, reg3, reg3); //Reg3 now contains the upper bound
				emit(OpCode.sub, reg3,reg2,reg2); //Reg2 contains the length of the array
				emit(OpCode.addI, reg2, new Num(1), reg2); //Reg2 now contains the length of the array2
				
				
				Label equalLength = createLabel(ctx,"equalLength");
				Label arrayLoop = createLabel(ctx, "arrayLoop");
				Label arrayLoopEnd = createLabel(ctx, "arrayLoopEnd");
				Label equalValue = createLabel(ctx,"equalValue");
				
				emit(OpCode.cmp_NE, reg1, reg2, reg(ctx));			//Are the arrays of equal length?
				
				emit(OpCode.cbr,reg(ctx),arrayLoopEnd ,equalLength);
				emit(equalLength,OpCode.nop);
				
				emit(OpCode.loadI, new Num(0), reg2);	//Reg2: A counter to iterate over the array
				
				//Offset of target + 8
				emit(OpCode.loadI, offset(ctx.expression(0)),reg3);
				emit(OpCode.addI,reg3, new Num(8),reg3);	//reg3 contains the offset of array1 + 8
				
				emit(OpCode.loadI, offset(ctx.expression(1)),reg4);
				emit(OpCode.addI,reg4, new Num(8),reg4); //Offset of array2 + 8
				
				
				emit(arrayLoop, OpCode.nop);	//Start of the array loop
			
				emit(OpCode.loadAO,arp,reg4,reg5);//Load the array2 value into reg5
				emit(OpCode.loadAO,arp,reg3,reg6);
				emit(OpCode.cmp_NE, reg5, reg6, reg(ctx));			//Are the arrays of equal value?
				emit(OpCode.cbr,reg(ctx),arrayLoopEnd ,equalValue);
				emit(equalValue,OpCode.nop);
				
				emit(OpCode.addI,reg3,new Num(4),reg3);	//Update the offsets
				emit(OpCode.addI,reg4,new Num(4),reg4);
				
				emit(OpCode.addI, reg2,new Num(1),reg2);	//Update the counter
				
				emit(OpCode.cmp_LT,reg2,reg1,reg6);
				emit(OpCode.cbr, reg6, arrayLoop,arrayLoopEnd);
				
				emit(arrayLoopEnd, OpCode.nop);
				
				
				
			}else{
				emit(OpCode.cmp_NE, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
			
			}
		}
		
		return null; }
	/**
	 * Compound expression. Sets the reg(ctx) to the value of the compound expression
	 * @require ctx != null && ctx.children != null
	 * @ensure  reg(ctx) == reg(ctx.expression()
	 */
	@Override public Op visitExprCompound(EloquenceParser.ExprCompoundContext ctx) { 
		visitChildren(ctx);

		if(ctx.expression() instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression()));
		
		if(checkResult.getType(ctx.expression()).equals(Type.CHAR))
			emit(OpCode.c2c, reg(ctx.expression()),reg(ctx));
		else 
			emit(OpCode.i2i, reg(ctx.expression()),reg(ctx));
		
		return null; 
		
	}
	/**
	 * Multiplies to registers and stores the result in reg(ctx). 
	 * @require ctx != null && ctx.children != null
	 * @ensure reg(ctx) == ctx.expression(0) * ctx.expression(1)
	 */
	@Override public Op visitExprMult(EloquenceParser.ExprMultContext ctx) { 
		visitChildren(ctx);
		
		if(ctx.expression(1) instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression(1)));
		if(ctx.expression(0) instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression(0)));
		
		if(ctx.multiply().MULTIPLY() != null){
			emit(OpCode.mult, reg(ctx.expression(0)),reg(ctx.expression(1)),reg(ctx));
		} else if(ctx.multiply().DIVIDE() != null){
			emit(OpCode.div, reg(ctx.expression(0)),reg(ctx.expression(1)),reg(ctx));
		} else if(ctx.multiply().MODULO() != null){
			emit(OpCode.div, reg(ctx.expression(0)),reg(ctx.expression(1)),reg1);
			emit(OpCode.mult, reg1,reg(ctx.expression(1)),reg1);
			emit(OpCode.sub, reg(ctx.expression(0)),reg1,reg(ctx));
		}
		
		return null; }
	/**
	 * Unary expression. Inverts the value of the expression and stores it in reg(ctx)
	 * 
	 * @require ctx != null && ctx.children != null
	 * @ensure reg(ctx) == inverse reg(ctx.expression)
	 */
	@Override public Op visitExprUnary(EloquenceParser.ExprUnaryContext ctx) { 
		
		visitChildren(ctx);

		if(ctx.expression() instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression()));
		
		if(ctx.unary().PLUS() != null){
			emit(OpCode.i2i, reg(ctx.expression()), reg(ctx));
		} else if(ctx.unary().MINUS() != null){
			emit(OpCode.rsubI, reg(ctx.expression()) ,new Num(0), reg(ctx));
		} else if(ctx.unary().NOT() != null){
			emit(OpCode.xorI, reg(ctx.expression()), new Num(1),reg(ctx));
		}
		
		return null; }
	
	/**
	 * Loads a number into reg(ctx)
	 * @require ctx != null && ctx.children != null
	 * @ensure reg(ctx) contains number
	 */
	@Override public Op visitExprNum(EloquenceParser.ExprNumContext ctx) { 
		visitChildren(ctx);
		emit(OpCode.loadI, new Num(Integer.parseInt(ctx.getText())), reg(ctx));
		return null; }
	/**
	 * Loads the value true or false into reg(ctx)
	 * @require ctx != null && ctx.children != null 
	 * @ensure reg(ctx) contains true or false
	 */
	@Override public Op visitExprTrue(EloquenceParser.ExprTrueContext ctx) { 
		emit(OpCode.loadI, new Num(-1), reg(ctx));
		return visitChildren(ctx); }
	
	/**
	 * Loads a character into reg(ctx)
	 * @require ctx != null && ctx.children != null 
	 * @ensure reg(ctx) != null
	 */
	@Override public Op visitExprChar(EloquenceParser.ExprCharContext ctx) { 
		emit(OpCode.loadI, new Num((int)ctx.getText().charAt(1)), reg1);
		emit(OpCode.i2c, reg1, reg(ctx));
		return visitChildren(ctx); }
	/**
	 * Loads the (return) value of a function ID into the current reg(ctx). 
	 * @require ctx != null && ctx.children != null 
	 * @ensure reg(ctx) != null
	 */
	@Override public Op visitExprFunc(EloquenceParser.ExprFuncContext ctx) { 
		visitChildren(ctx);
		if(checkResult.getType(ctx.functionID()).equals(Type.CHAR))
			emit(OpCode.c2c, reg(ctx.functionID()), reg(ctx));
		else
			emit(OpCode.i2i, reg(ctx.functionID()), reg(ctx));
		
		return null; }
	/**
	 * Performs a logical or on expression(0) and expression(1)
	 * @require ctx != null && ctx.children != null 
	 * @ensure reg(ctx) != null
	 */
	@Override public Op visitExprOr(EloquenceParser.ExprOrContext ctx) {
		visitChildren(ctx);

		if(ctx.expression(1) instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression(1)));
		if(ctx.expression(0) instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression(0)));
		
		emit(OpCode.or, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
	return null; }
	
	/** 
	 * An epxression within parentheses. The expressions are visited and the result is stored 
	 * in reg(ctx)
	 * @require ctx != null && ctx.children != null 
	 * @ensure reg(ctx) != null
	 */
	@Override public Op visitExprPar(EloquenceParser.ExprParContext ctx) { 
		visitChildren(ctx);

		if(ctx.expression() instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression()));
		
		if(checkResult.getType(ctx.expression()).equals(Type.CHAR))
			emit(OpCode.c2c, reg(ctx.expression()),reg(ctx));
		else 
			emit(OpCode.i2i, reg(ctx.expression()),reg(ctx));
		
		return null; }
	/**
	 * Adds expression(0) and expression(1) and stores the result in reg(ctx)
	 * @require ctx != null && ctx.children != null 
	 * @ensure reg(ctx) != null
	 */
	@Override public Op visitExprAdd(EloquenceParser.ExprAddContext ctx) {
		visitChildren(ctx);
		
		if(ctx.expression(1) instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression(1)));
		if(ctx.expression(0) instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression(0)));
		
		if(ctx.addition().PLUS() != null){
			emit(OpCode.add,reg(ctx.expression(0)), reg(ctx.expression(1)),reg(ctx));
		} else if(ctx.addition().MINUS() != null){
			emit(OpCode.sub,reg(ctx.expression(0)), reg(ctx.expression(1)),reg(ctx));
		}
		
		return null; }
	/**
	 * Performs a logical and on Expression(0) and expression(1)
	 * @require ctx != null && ctx.children != null 
	 * @ensure reg(ctx) != null
	 */
	@Override public Op visitExprAnd(EloquenceParser.ExprAndContext ctx) {
		visitChildren(ctx);

		if(ctx.expression(1) instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression(1)));
		if(ctx.expression(0) instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression(0)));
		
			emit(OpCode.and, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
		return null; }
	/**
	 * Sets the value of the targetId on the reg(ctx)
	 * @require ctx != null && ctx.children != null 
	 * @ensure reg(ctx) != null
	 */
	@Override public Op visitExprId(EloquenceParser.ExprIdContext ctx) { 
		visitChildren(ctx);
		
		if(checkResult.getType(ctx.target()).equals(Type.CHAR))
			emit(OpCode.c2c, reg(ctx.target()),reg(ctx));
		else
			emit(OpCode.i2i, reg(ctx.target()),reg(ctx));
		return null; }
	/**
	 * Loads the value of false in reg(ctx)
	 * @require ctx != null && ctx.children != null 
	 * @ensure reg(ctx) != null
	 */
	@Override public Op visitExprFalse(EloquenceParser.ExprFalseContext ctx) {
		emit(OpCode.loadI, new Num(0), reg(ctx));
		return null; }
	/**
	 * Retrieves the value of an array at a certain index. In case the index is not within the bounds
	 * of an array, the program ends and gives an array index out of bounds exception. 
	 * @require ctx != null && ctx.children != null 
	 * @ensure reg(ctx) != null
	 */
	@Override public Op visitExprArray(EloquenceParser.ExprArrayContext ctx) { 
		visitChildren(ctx);

		if(ctx.expression() instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression()));
		//Check for index out of bounds exception
		emit(OpCode.i2i, reg(ctx.expression()),reg1);
		
		emit(OpCode.i2i,reg1,reg_error);
		emit(OpCode.loadAI, arp, offset(ctx.target()),reg2); //reg2: lower bound
		emit(OpCode.loadI, offset(ctx.target()),reg3);
		emit(OpCode.addI, reg3, new Num(4),reg3);
		emit(OpCode.loadAO,arp,reg3,reg3);//reg3: upper bound
		
		Label indexOutOfBounds = runtimeErrors.get("indexOutOfBounds");
			
		
		Label geCont = createLabel(ctx, "greaterThanLowerBound");
		Label leCont = createLabel(ctx, "lessThanUpperBound");
		emit(OpCode.cmp_GE, reg1,reg2,reg4);
		emit(OpCode.cbr,reg4, geCont,indexOutOfBounds);
		emit(geCont, OpCode.nop);
		
		emit(OpCode.cmp_LE, reg1,reg3,reg4);
		emit(OpCode.cbr, reg4,leCont,indexOutOfBounds);
		emit(leCont, OpCode.nop);
		
		//We need the index, this is in expression. We'll store the index in reg1
//		emit(OpCode.loadI, new Num(Integer.parseInt(ctx.expression().getText())),reg1);
		emit(OpCode.i2i, reg(ctx.expression()),reg1);
		
		//We also need the starting value of the array. We'll put this in reg2
		emit(OpCode.loadAI, arp, offset(ctx.target()),reg2);
		emit(OpCode.sub, reg1,reg2,reg1);
		emit(OpCode.multI,reg1,new Num(4),reg1);
		emit(OpCode.addI,reg1,new Num(8),reg1); //reg1 now contains the address of the index
		emit(OpCode.addI,reg1,offset(ctx.target()),reg1);
		
		emit(OpCode.loadAO,arp,reg1,reg(ctx));
		return null; }
	/**
	 * The following functions do not have to emit any ILOC instructions. The following requirement
	 * holds for all of them.
	 * @require ctx != null && ctx.children != null 
	 */
	@Override public Op visitUnary(EloquenceParser.UnaryContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitMultiply(EloquenceParser.MultiplyContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitAddition(EloquenceParser.AdditionContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitCompare(EloquenceParser.CompareContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitAnd(EloquenceParser.AndContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitOr(EloquenceParser.OrContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitTypeInt(EloquenceParser.TypeIntContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitTypeBool(EloquenceParser.TypeBoolContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitTypeChar(EloquenceParser.TypeCharContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitFuncVoid(EloquenceParser.FuncVoidContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitFuncReturn(EloquenceParser.FuncReturnContext ctx) { return visitChildren(ctx); }
	/**
	 * Calls a function. It starts by pushing its currect activation record on the stack.
	 * A return label is placed at the end of the function. The return addres is pushed on the stack,
	 * together with return value placeholder and parameters. After function is finished, the 
	 * activation record is restored and the return value is stored in reg(ctx). 
	 * 
	 * @require ctx != null && ctx.children != null 
	 * @ensure reg(ctx) != null
	 */
	@Override public Op visitFunctionID(EloquenceParser.FunctionIDContext ctx) {	
		
		ParseTree enclParent = ctx;
		while(!(enclParent instanceof VoidFuncContext) && !(enclParent instanceof ReturnFuncContext)){
			if(enclParent == null)
				break;
			enclParent = enclParent.getParent();
		}
		
		if(enclParent != null){
			List<ParametersContext> parameters = (enclParent instanceof VoidFuncContext) ? ((VoidFuncContext)enclParent).parameters() : ((ReturnFuncContext)enclParent).parameters();
			for(ParametersContext paramCtx : parameters)
				if(paramCtx instanceof ParamValContext)
					emit(OpCode.push, reg(((ParamValContext)paramCtx).newID().ID()));
		}
		
		visitChildren(ctx);
		
		List<ParseTree> vars = checkResult.getFunctionDeclarations().get(ctx.target().getText());
		for(int i = 0; i < vars.size();i++){
			emit(OpCode.loadAI, arp, offset(vars.get(i)), reg1);
			emit(OpCode.push, reg1);
		}
		
		emit(OpCode.loadI, new Num(0),reg1);
		emit(OpCode.push, reg1);
		
		Label funcContinue = createLabel(ctx, "funcContinue" + ctx.getText());
		emit(OpCode.loadI, new Num(funcContinue), reg1);
		emit(OpCode.push, reg1);
		
		for(ExpressionContext e : ctx.expression()){
			emit(OpCode.push, reg(e));			//Push the paramaters
		}
		
		emit(OpCode.jumpI, funcAddr.get(ctx.target().getText())); 
		emit(funcContinue, OpCode.nop);
		emit(OpCode.pop, reg(ctx));
		
		for(int i = vars.size()-1; i >= 0;i--){
			emit(OpCode.pop, reg(vars.get(i)));
			emit(OpCode.storeAI, reg(vars.get(i)), arp, offset(vars.get(i)));
		}
		
		if(enclParent != null){
			List<ParametersContext> parameters = (enclParent instanceof VoidFuncContext) ? ((VoidFuncContext)enclParent).parameters() : ((ReturnFuncContext)enclParent).parameters();
			for(ParametersContext paramCtx : parameters)
				if(paramCtx instanceof ParamValContext){
					emit(OpCode.pop, reg(((ParamValContext)paramCtx).newID().ID()));
					emit(OpCode.storeAI, reg(((ParamValContext)paramCtx).newID().ID()), arp, offset(((ParamValContext)paramCtx).newID().ID()));
				}
		}
		emit(OpCode.push, reg(ctx));
		
		return null; }
	
	/**
	 * Visits a void function. A label is placed at the end of the function and also at the beginning
	 * of the body. After the code for this function is placed, the program jumps to the end of the 
	 * of the function. It is only when this function is called, a jump is made to the body.
	 * 
	 * @require ctx != null && ctx.children != null 
	 */
	@Override public Op visitVoidFunc(EloquenceParser.VoidFuncContext ctx) {
		funcAddr.put(ctx.newID().ID().getText(), createLabel(ctx,"function"));//Label for starting the function
		
		visit(ctx.newID());
		
		Label funcEnd = createLabel(ctx, "funcEnd");	//Label for the end of the function
		emit(OpCode.jumpI, funcEnd);					
		emit(funcAddr.get(ctx.newID().ID().getText()),OpCode.nop);
		
		for(ParametersContext p : ctx.parameters()){
			visit(p);
		}
		visitChildren(ctx.statBlockBody());
		
		emit(OpCode.pop, reg3);				//Pop the return address
		emit(OpCode.jump, reg3);			//And jump to the return address
		emit(funcEnd, OpCode.nop);
		return null; }
	
	/**
	 * Visits a function which takes a return value. The return value is not popped here from the stack.
	 * That happens in the returnStat. 
	 * @require ctx != null && ctx.children != null 
	 * @ensure reg(ctx) != null
	 */
	@Override public Op visitReturnFunc(EloquenceParser.ReturnFuncContext ctx) {
		
		funcAddr.put(ctx.newID().ID().getText(), createLabel(ctx,"function"));
		
		visit(ctx.newID());
		
		Label funcEnd = createLabel(ctx, "funcEnd");
		emit(OpCode.jumpI, funcEnd);
		emit(funcAddr.get(ctx.newID().ID().getText()),OpCode.nop);
		
		for(ParametersContext p : ctx.parameters()){
			visit(p);
		}
		
		
		visit(ctx.body());
		visit(ctx.returnStat());		//The return stat will jump to the return address.
		emit(funcEnd, OpCode.nop);
		return null;
		}
	/**
	 * Visits a parameter in case of call by value. The parameter value is popped in the register
	 * of new ID. This value is then stored at the place of the offset of the Id.
	 * @require ctx != null && ctx.children != null 
	 * @ensure reg(ctx) != null
	 */
	@Override public Op visitParamVal(EloquenceParser.ParamValContext ctx) { 
		visitChildren(ctx);
		emit(OpCode.pop, reg(ctx.newID().ID()));
		emit(OpCode.storeAI, reg(ctx.newID().ID()),arp, offset(ctx.newID().ID()));
		return null; }
	/**
	 * Visits a parameter in case of call by reference. The value of the parameter is popped in the 
	 * reg(new ID)
	 * @require ctx != null && ctx.children != null 
	 * @ensure reg(ctx) != null
	 */
	@Override public Op visitParamRef(EloquenceParser.ParamRefContext ctx) { 
		visitChildren(ctx);
		emit(OpCode.pop, reg(ctx.newID()));
		return null; }
}
