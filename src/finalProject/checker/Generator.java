package finalProject.checker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import finalProject.grammar.EloquenceBaseVisitor;
import finalProject.grammar.EloquenceParser;
import finalProject.grammar.EloquenceParser.ExprFuncContext;
import finalProject.grammar.EloquenceParser.ExpressionContext;
import finalProject.grammar.EloquenceParser.NewIDContext;
import finalProject.grammar.EloquenceParser.ParamValContext;
import finalProject.grammar.EloquenceParser.ParametersContext;
import finalProject.grammar.EloquenceParser.ReturnFuncContext;
import finalProject.grammar.EloquenceParser.TargetContext;
import finalProject.grammar.EloquenceParser.VoidFuncContext;
import finalProjectCFG.BottomUpCFGBuilder;
import pp.iloc.*;
import pp.iloc.eval.*;
import pp.iloc.model.*;
import pp.iloc.parse.*;

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
	/** Several registers. */
	private Graph cfg;
	
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
	 * the runtime error node, the progrom outputs the error and jumps to the end. The rest of the ILOC code
	 * is then not created. 
	 * 
	 * */
	@Override public Op visitProgram(EloquenceParser.ProgramContext ctx) { 
		Label indexOutOfBounds = createLabel(ctx, "indexOutOfBounds");
		runtimeErrors.put("indexOutOfBounds", indexOutOfBounds);
		visitChildren(ctx);
		Label programEnd = createLabel(ctx, "programEnd");
		emit(OpCode.jumpI, programEnd);
		
	
		emit(indexOutOfBounds, OpCode.nop);
		emit(OpCode.out, new Str("Error: Array index out of bounds "), reg_error);
		emit(OpCode.jumpI, programEnd);
		
		emit(programEnd,OpCode.nop);
		return null; }
	
	/** After entering the program, the body is visited. Initially all the children of the body are visited
	 * The body can contain statements, in such case the body can be part of a compound statement and can thus
	 * be assigned. The body must hold the value of the last statement of a compound expression. That value
	 * is stored in the register of the ctx of visitBody.
	 * 
	 */
	@Override public Op visitBody(EloquenceParser.BodyContext ctx) { 
		if(labels.get(ctx) != null)
			emit(labels.get(ctx), OpCode.nop);
		
		visitChildren(ctx);
		if(ctx.stat().size()>0){
			if(checkResult.getType(ctx) != null){
				if(checkResult.getType(ctx).equals(Type.CHAR)){
					emit(OpCode.c2c, reg(ctx.stat(ctx.stat().size()-1)), reg(ctx));
				}else if(checkResult.getType(ctx) != null){
					emit(OpCode.i2i, reg(ctx.stat(ctx.stat().size()-1)), reg(ctx));
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
		for(NewIDContext newId : ctx.variable().newID()){
				if(ctx.expression() != null){
					emit(OpCode.i2i, reg(ctx.expression()), reg(newId.ID()));
				} else{
					emit(OpCode.loadI, new Num(0), reg(newId.ID()));
				}
				emit(OpCode.storeAI,reg(newId.ID()),arp, offset(newId.ID()));
		}
		
		return null; 
	
	}
	
	@Override public Op visitDeclConstVar(EloquenceParser.DeclConstVarContext ctx) {
		visitChildren(ctx);
		for(NewIDContext newId : ctx.variable().newID()){
				if(ctx.expression() != null){
					emit(OpCode.i2i, reg(ctx.expression()), reg1);
				} else{
					emit(OpCode.loadI, new Num(0), reg1);
				}
				emit(OpCode.storeAI,reg1,arp, offset(newId.ID()));
		}
		
		return null;   }
	
	@Override public Op visitDeclArray(EloquenceParser.DeclArrayContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitVariable(EloquenceParser.VariableContext ctx) {
		
		return visitChildren(ctx); }
	
	@Override public Op visitArrayTypeDecl(EloquenceParser.ArrayTypeDeclContext ctx) {
		visitChildren(ctx);
		
		
		//reg1 the left bound, reg2 contains the right bound
		emit(OpCode.storeAI,reg1,arp, offset(ctx.newID().ID()));
		emit(OpCode.loadI, offset(ctx.newID().ID()), reg3);
		emit(OpCode.addI, reg3, new Num(4), reg3);
		emit(OpCode.storeAO,reg2,arp, reg3);
		
		
		return null; }
	
	@Override public Op visitArrayElem(EloquenceParser.ArrayElemContext ctx) {
		visitChildren(ctx);
		emit(OpCode.loadI, new Num(Integer.parseInt(ctx.NUM(0).getText())), reg1);
		emit(OpCode.loadI, new Num(Integer.parseInt(ctx.NUM(1).getText())), reg2);
		return null; }
	
	@Override public Op visitVarArrayDecl(EloquenceParser.VarArrayDeclContext ctx) { 
		visitChildren(ctx);
		
		
		for(NewIDContext newId : ctx.newID()){
			emit(OpCode.storeAI, reg(ctx.target()), arp, offset(newId.ID()));
			
			emit(OpCode.loadI, offset(ctx.target()),reg1);	//load offset in reg1
			emit(OpCode.addI, reg1, new Num(4), reg1);		//add 4 to the offset
			emit(OpCode.loadAO, arp, reg1, reg1); //Load the ending value in reg1
			
			emit(OpCode.loadI, offset(newId.ID()), reg2);
			emit(OpCode.addI, reg2, new Num(4), reg2);
			emit(OpCode.storeAO, reg1, arp,reg2);
			
			if(ctx.SETARRAY() != null){
				for(ExpressionContext c : ctx.expression()){
					emit(OpCode.addI, reg2, new Num(4), reg2);
					emit(OpCode.storeAO, reg(c), arp,reg2);
				}
				
			}
			
		}
		return null; }
	
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
	
	@Override public Op visitStatIf(EloquenceParser.StatIfContext ctx) { 
		System.out.println("\n\nStatIF");
		
		Label body = createLabel(ctx, "ifBody");
		Label ifContinue = createLabel(ctx, "continue");
	//	labels.put(ctx.stat(0), body);
		//visitChildren(ctx);
		visit(ctx.expression());

		if(ctx.expression() instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression()));
		
		System.out.println("\n\n"); 
		if(ctx.ELSE() == null){ //There is no else
			emit(OpCode.cbr, reg(ctx.expression()), body, ifContinue);
			emit(body, OpCode.nop);
			visit(ctx.stat(0));
			if(checkResult.getType(ctx.stat(0)) != null){
				System.out.println("Only IF stat(0) != null reg ctx: " + reg(ctx));
				if(checkResult.getType(ctx.stat(0)).equals(Type.CHAR)){
					emit(OpCode.c2c, reg(ctx.stat(0)), reg(ctx));
				}else if(checkResult.getType(ctx.stat(0)) != null){
					emit(OpCode.i2i, reg(ctx.stat(0)), reg(ctx));
				}
			}
			emit(OpCode.jumpI, ifContinue);
		} else {			
			Label elseBody = createLabel(ctx, "elseBody");
		//	labels.put(ctx.stat(1), elseBody);
			emit(OpCode.cbr, reg(ctx.expression()), body, elseBody);
			emit(body, OpCode.nop);
			visit(ctx.stat(0));
			if(checkResult.getType(ctx.stat(0)) != null){
				System.out.println("stat(0) != null reg ctx: " + reg(ctx));
				if(checkResult.getType(ctx.stat(0)).equals(Type.CHAR)){
					emit(OpCode.c2c, reg(ctx.stat(0)), reg(ctx));
				}else if(checkResult.getType(ctx.stat(0)) != null){
					emit(OpCode.i2i, reg(ctx.stat(0)), reg(ctx));
				}
			}
			emit(OpCode.jumpI, ifContinue);
			emit(elseBody, OpCode.nop);
			visit(ctx.stat(1));
			if(checkResult.getType(ctx.stat(1)) != null){
				System.out.println("stat(1) != null reg ctx: " + reg(ctx));
				if(checkResult.getType(ctx.stat(1)).equals(Type.CHAR)){
					emit(OpCode.c2c, reg(ctx.stat(1)), reg(ctx));
				}else if(checkResult.getType(ctx.stat(1)) != null){
					emit(OpCode.i2i, reg(ctx.stat(1)), reg(ctx));
				}
			}
		}
		
		emit(ifContinue, OpCode.nop);
		return null; }
	
	@Override public Op visitStatWhile(EloquenceParser.StatWhileContext ctx) { 
		if(labels.get(ctx) != null){
			emit(labels.get(ctx),OpCode.nop);
		}	else{
			Label whileLoop = createLabel(ctx, "whileLoop");
			labels.put(ctx, whileLoop);
			emit(whileLoop, OpCode.nop);
		}
		
		Label whileBody = createLabel(ctx.stat(), "whileBody");
	//	labels.put(ctx.stat(), whileBody);
		Label whileContinue = createLabel(ctx, "whileContinue");
		
		visit(ctx.expression());

		if(ctx.expression() instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression()));
		
		emit(OpCode.cbr, reg(ctx.expression()), whileBody, whileContinue);
		emit(whileBody, OpCode.nop);
		visit(ctx.stat());
		emit(OpCode.jumpI, labels.get(ctx));
		emit(whileContinue, OpCode.nop);
		
		return null; }
	
	@Override public Op visitStatAssign(EloquenceParser.StatAssignContext ctx) { 
		if(labels.get(ctx) != null){
			emit(labels.get(ctx), OpCode.nop);
		}
		visitChildren(ctx);
		if(checkResult.getType(ctx.expression()) != null){
			if(checkResult.getType(ctx.expression()).equals(Type.CHAR)){
				emit(OpCode.c2c, reg(ctx.expression()),reg(ctx));
				emit(OpCode.storeAI, reg(ctx), arp, offset(ctx));
				
				for(TargetContext target : ctx.target()){
					emit(OpCode.c2c, reg(ctx.expression()),reg(target));
					emit(OpCode.storeAI, reg(target), arp, offset(target)); //TODO offset of ID
				}
			}
			else if(checkResult.getType(ctx.expression()).equals(Type.INT) || checkResult.getType(ctx.expression()).equals(Type.BOOL)){
				
				emit(OpCode.i2i, reg(ctx.expression()),reg(ctx));
				emit(OpCode.storeAI, reg(ctx), arp, offset(ctx)); 
				
				for(TargetContext target : ctx.target()){
					emit(OpCode.i2i, reg(ctx.expression()),reg(target));
					emit(OpCode.storeAI, reg(target), arp, offset(target)); //TODO offset of ID
				}
				
			} else if(!checkResult.getType(ctx.target(0)).equals(Type.INT) &&
					!checkResult.getType(ctx.target(0)).equals(Type.BOOL) &&
					!checkResult.getType(ctx.target(0)).equals(Type.CHAR)
					){
				
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
	
	@Override public Op visitStatAssignArray(EloquenceParser.StatAssignArrayContext ctx) {
		if(labels.get(ctx) != null)
			emit(labels.get(ctx), OpCode.nop);
		visitChildren(ctx);
	for(TargetContext target : ctx.target()){
			//Start by computing the begin value of the array. We'll store that in reg1
			emit(OpCode.loadAI, arp, offset(target), reg1);
			//Now we need the index value. This is stored in expression(0). We'll store it in reg2
	//		emit(OpCode.loadI, new Num(Integer.parseInt(ctx.expression(0).getText())),reg2);
			emit(OpCode.i2i, reg(ctx.expression(0)), reg2);
			//Subtract the index by the begin value.
			emit(OpCode.sub, reg2, reg1, reg1);
			//Multiply by four to get the offset
			emit(OpCode.multI, reg1, new Num(4), reg1);
			//Add 8
			emit(OpCode.addI, reg1, new Num(8),reg1); //This is the address where the value needs to be stored.
			emit(OpCode.addI, reg1, offset(target),reg1);
			//The the target value
		//	emit(OpCode.loadI, new Num(Integer.parseInt(ctx.expression(2).getText())), reg2);
			 emit(OpCode.storeAO, reg(ctx.expression(1)), arp,reg1);
			//Debug
			//	emit(OpCode.out, new Str("test"), reg1);
	}
		return null; }
	
	@Override public Op visitStatAssignArrayMult(EloquenceParser.StatAssignArrayMultContext ctx) {
		if(labels.get(ctx) != null)
			emit(labels.get(ctx), OpCode.nop);
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
	
	@Override public Op visitStatBlock(EloquenceParser.StatBlockContext ctx) {
		
		if(labels.get(ctx) != null)
			emit(labels.get(ctx), OpCode.nop);
		visitChildren(ctx);
		
		if(checkResult.getType(ctx) != null){
			if(checkResult.getType(ctx).equals(Type.CHAR)){
				emit(OpCode.c2c, reg(ctx.statBlockBody()), reg(ctx));
			}else if(checkResult.getType(ctx) != null){
				emit(OpCode.i2i, reg(ctx.statBlockBody()), reg(ctx));
			}
		}
		
		return null; }
	
	@Override public Op visitStatExpr(EloquenceParser.StatExprContext ctx) {
		
		if(labels.get(ctx) != null)
			emit(labels.get(ctx), OpCode.nop);
		visitChildren(ctx);

		if(ctx.expression() instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression()));
		
		System.out.println("Type of " + ctx.getText() + " = " + checkResult.getType(ctx));
		if(checkResult.getType(ctx) != null){
			if(checkResult.getType(ctx).equals(Type.CHAR)){
				emit(OpCode.c2c, reg(ctx.expression()), reg(ctx));
			}else if(checkResult.getType(ctx) != null){
				emit(OpCode.i2i, reg(ctx.expression()), reg(ctx));
			}
		
		}
		return null;
	}
	
	@Override public Op visitStatReturn(EloquenceParser.StatReturnContext ctx) { 
		
		
		if(labels.get(ctx) != null)
			emit(labels.get(ctx), OpCode.nop);
		visitChildren(ctx);
		return null; }
	
	@Override public Op visitStatIn(EloquenceParser.StatInContext ctx) { 
		
		if(labels.get(ctx) != null)
			emit(labels.get(ctx), OpCode.nop);
		visitChildren(ctx);
		for(TargetContext target : ctx.target()){
			emit(OpCode.in,new Str(target.getText() + "?") ,reg(target));
			emit(OpCode.storeAI, reg(target), arp, offset(target));
			emit(OpCode.i2i, reg(target), reg(ctx));
		}
		
		return null; }
	
	@Override public Op visitStatOut(EloquenceParser.StatOutContext ctx) { 
		if(labels.get(ctx) != null)
			emit(labels.get(ctx), OpCode.nop);
		
		visitChildren(ctx);
		
		for(ExpressionContext out : ctx.expression()){
			emit(OpCode.out, new Str("Output: ") , reg(out));
			emit(OpCode.i2i, reg(out), reg(ctx));
			if(out instanceof ExprFuncContext)
				emit(OpCode.pop, reg(out));
		}
		
		return null; }
	
	@Override public Op visitStatVoid(finalProject.grammar.EloquenceParser.StatVoidContext ctx) {
		if(labels.get(ctx) != null)
			emit(labels.get(ctx), OpCode.nop);
		
		visitChildren(ctx);
		
		/*
		if(checkResult.getType(ctx).equals(Type.CHAR)){
			emit(OpCode.c2c, reg(ctx.functionID()), reg(ctx));
		}else if(checkResult.getType(ctx) != null){
			emit(OpCode.i2i, reg(ctx.functionID()), reg(ctx));
		}
		*/
		
		
		return null; }
	
	@Override public Op visitStatBlockBody(EloquenceParser.StatBlockBodyContext ctx) { 
		if(labels.get(ctx) != null){
			emit(labels.get(ctx), OpCode.nop);
		}
		
		visitChildren(ctx);
		if(checkResult.getType(ctx) != null){
			if(checkResult.getType(ctx).equals(Type.CHAR)){
				emit(OpCode.c2c, reg(ctx.body()), reg(ctx));
			}else if(checkResult.getType(ctx) != null){
				emit(OpCode.i2i, reg(ctx.body()), reg(ctx));
			}
		}
		return null; }
	
	@Override public Op visitTargetId(EloquenceParser.TargetIdContext ctx) {
		visitChildren(ctx);
		emit(OpCode.loadAI, arp, offset(ctx.ID()), reg(ctx));
			return null;  }
	
	@Override public Op visitNewID(EloquenceParser.NewIDContext ctx) {
		visitChildren(ctx);
		emit(OpCode.loadAI, arp, offset(ctx.ID()), reg(ctx.ID()));
		return null; }
	
	@Override public Op visitReturnStat(EloquenceParser.ReturnStatContext ctx) { 
		if(labels.get(ctx) != null)
			emit(labels.get(ctx), OpCode.nop);
		visitChildren(ctx);
		
		if(ctx.expression() != null){
			if(ctx.expression() instanceof ExprFuncContext)
				emit(OpCode.pop, reg(ctx.expression()));
			
			System.out.println("\nReturnStat");
			emit(OpCode.pop, reg3);						//Pop return label
			emit(OpCode.pop,reg1);						//Pop return value of 0
			emit(OpCode.push, reg(ctx.expression()));	//Push actual return value
			emit(OpCode.jump, reg3);					//Jump to return label
			System.out.println("");
			
			
		} else{
			
			emit(OpCode.pop, reg3);
			emit(OpCode.jump, reg3);
		}
		
		return null; }
	
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
	
	@Override public Op visitExprNum(EloquenceParser.ExprNumContext ctx) { 
		visitChildren(ctx);
		emit(OpCode.loadI, new Num(Integer.parseInt(ctx.getText())), reg(ctx));
		return null; }
	
	@Override public Op visitExprTrue(EloquenceParser.ExprTrueContext ctx) { 
		emit(OpCode.loadI, new Num(-1), reg(ctx));
		return visitChildren(ctx); }
	
	//TODO check whether this is correct
	@Override public Op visitExprChar(EloquenceParser.ExprCharContext ctx) { 
		emit(OpCode.loadI, new Num((int)ctx.getText().charAt(1)), reg1);
		emit(OpCode.i2c, reg1, reg(ctx));
		return visitChildren(ctx); }
	
	@Override public Op visitExprFunc(EloquenceParser.ExprFuncContext ctx) { 
		visitChildren(ctx);
		if(checkResult.getType(ctx.functionID()).equals(Type.CHAR))
			emit(OpCode.c2c, reg(ctx.functionID()), reg(ctx));
		else
			emit(OpCode.i2i, reg(ctx.functionID()), reg(ctx));
		
		return null; }
	
	@Override public Op visitExprOr(EloquenceParser.ExprOrContext ctx) {
		visitChildren(ctx);

		if(ctx.expression(1) instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression(1)));
		if(ctx.expression(0) instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression(0)));
		
		emit(OpCode.or, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
	return null; }
	
	@Override public Op visitExprPar(EloquenceParser.ExprParContext ctx) { 
		visitChildren(ctx);

		if(ctx.expression() instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression()));
		
		if(checkResult.getType(ctx.expression()).equals(Type.CHAR))
			emit(OpCode.c2c, reg(ctx.expression()),reg(ctx));
		else 
			emit(OpCode.i2i, reg(ctx.expression()),reg(ctx));
		
		return null; }
	
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
	
	@Override public Op visitExprAnd(EloquenceParser.ExprAndContext ctx) {
		visitChildren(ctx);

		if(ctx.expression(1) instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression(1)));
		if(ctx.expression(0) instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression(0)));
		
			emit(OpCode.and, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
		return null; }
	
	@Override public Op visitExprId(EloquenceParser.ExprIdContext ctx) { 
		visitChildren(ctx);
		
		if(checkResult.getType(ctx.target()).equals(Type.CHAR))
			emit(OpCode.c2c, reg(ctx.target()),reg(ctx));
		else
			emit(OpCode.i2i, reg(ctx.target()),reg(ctx));
		return null; }
	
	@Override public Op visitExprFalse(EloquenceParser.ExprFalseContext ctx) {
		emit(OpCode.loadI, new Num(0), reg(ctx));
		return null; }
	
	@Override public Op visitExprArray(EloquenceParser.ExprArrayContext ctx) { 
		visitChildren(ctx);

		if(ctx.expression() instanceof ExprFuncContext)
			emit(OpCode.pop, reg(ctx.expression()));
		//Check for index out of bounds exception
	//	emit(OpCode.loadI, new Num(Integer.parseInt(ctx.expression().getText())),reg1); //reg1: index
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
	//	emit(OpCode.jumpI, label(ctx.target()));
		System.out.println("\nFunction");
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
		
		//TODO ?
		emit(OpCode.push, reg(ctx));
		
		return null; }
	
	@Override public Op visitVoidFunc(EloquenceParser.VoidFuncContext ctx) {
	//	label(ctx.newID());
		funcAddr.put(ctx.newID().ID().getText(), createLabel(ctx,"function"));//Label for starting the function
		
		visit(ctx.newID());
		
		Label funcEnd = createLabel(ctx, "funcEnd");
		emit(OpCode.jumpI, funcEnd);
		emit(funcAddr.get(ctx.newID().ID().getText()),OpCode.nop);
		
		for(ParametersContext p : ctx.parameters()){
			visit(p);
		}
		visitChildren(ctx.statBlockBody());
		
		emit(OpCode.pop, reg3);
		emit(OpCode.jump, reg3);
		emit(funcEnd, OpCode.nop);
		return null; }
	
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
		visit(ctx.returnStat());
		emit(funcEnd, OpCode.nop);
		return null;
		}
	
	@Override public Op visitParamVal(EloquenceParser.ParamValContext ctx) { 
		visitChildren(ctx);
		emit(OpCode.pop, reg(ctx.newID().ID()));
		emit(OpCode.storeAI, reg(ctx.newID().ID()),arp, offset(ctx.newID().ID()));
		return null; }

	@Override public Op visitParamRef(EloquenceParser.ParamRefContext ctx) { 
		visitChildren(ctx);
		emit(OpCode.pop, reg(ctx.newID()));
		return null; }
}
