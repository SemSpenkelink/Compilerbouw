package finalProject.checker;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import finalProject.grammar.EloquenceBaseVisitor;
import finalProject.grammar.EloquenceParser;
import finalProject.grammar.EloquenceParser.ArrayElemContext;
import finalProject.grammar.EloquenceParser.ExpressionContext;
import finalProject.grammar.EloquenceParser.NewIDContext;
import finalProject.grammar.EloquenceParser.TargetContext;
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

	public Program generate(ParseTree tree, Result checkResult) {
		this.prog = new Program();
		this.checkResult = checkResult;
		this.regs = new ParseTreeProperty<>();
		this.labels = new ParseTreeProperty<>();
		this.regCount = 0;
		this.cfg = new BottomUpCFGBuilder().build(tree);
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
	
	@Override public Op visitProgram(EloquenceParser.ProgramContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitBody(EloquenceParser.BodyContext ctx) { return visitChildren(ctx); }
	
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
		
		emit(OpCode.storeAI,reg1,arp, offset(ctx.newID().ID()));
		emit(OpCode.loadI, offset(ctx.newID().ID()), reg3);
		emit(OpCode.addI, reg3, new Num(4), reg3);
		emit(OpCode.storeAI,reg2,arp, reg3);
		
		return null; }
	
	@Override public Op visitArrayElem(EloquenceParser.ArrayElemContext ctx) {
		visitChildren(ctx);
		emit(OpCode.loadI, new Num(Integer.parseInt(ctx.NUM(0).getText())), reg1);
		emit(OpCode.loadI, new Num(Integer.parseInt(ctx.NUM(1).getText())), reg2);
		return null; }
	
	@Override public Op visitVarArrayDecl(EloquenceParser.VarArrayDeclContext ctx) { 
		System.out.println("visitVarArrayDecl");
		visitChildren(ctx);
		System.out.println("\n");
		for(NewIDContext newId : ctx.newID()){
			emit(OpCode.storeAI, reg(ctx.target()), arp, offset(newId.ID()));
			
			emit(OpCode.loadI, offset(ctx.target()),reg1);	//load offset in reg1
			emit(OpCode.addI, reg1, new Num(4), reg1);		//add 4 to the offset
			emit(OpCode.loadAI, arp, reg1, reg1); //Load the ending value in reg1
			
			emit(OpCode.loadI, offset(newId.ID()), reg2);
			emit(OpCode.addI, reg2, new Num(4), reg2);
			emit(OpCode.storeAI, reg1, arp,reg2);
		}
		return null; }
	
	@Override public Op visitConstArrayDecl(EloquenceParser.ConstArrayDeclContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatIf(EloquenceParser.StatIfContext ctx) { //TODO if stat
		
		
		/*
		Label body = createLabel(ctx, "ifBody");
		Label ifContinue = createLabel(ctx, "continue");
		labels.put(ctx.stat(0), body);
		//visitChildren(ctx);
		visit(ctx.expression());
		
		if(ctx.ELSE() == null){ //There is no else
			emit(OpCode.cbr, reg(ctx.expression()), body, ifContinue);
			visit(ctx.stat(0));
			emit(OpCode.jumpI, ifContinue);
		} else {			
			Label elseBody = createLabel(ctx, "elseBody");
			labels.put(ctx.stat(1), elseBody);
			emit(OpCode.cbr, reg(ctx.expression()), body, elseBody);
			visit(ctx.stat(0));
			emit(OpCode.jumpI, ifContinue);
			visit(ctx.stat(1));
		}
		
		emit(ifContinue, OpCode.nop);
		*/
		return null; }
	
	@Override public Op visitStatWhile(EloquenceParser.StatWhileContext ctx) { //TODO while stat
		if(labels.get(ctx) != null){
			emit(labels.get(ctx),OpCode.nop);
		}	else{
			Label whileLoop = createLabel(ctx, "whileLoop");
			labels.put(ctx, whileLoop);
			emit(whileLoop, OpCode.nop);
		}
		
		Label whileBody = createLabel(ctx, "whileBody");
		labels.put(ctx.stat(), whileBody);
		Label whileContinue = createLabel(ctx, "whileContinue");
		
		visit(ctx.expression());
		emit(OpCode.cbr, reg(ctx.expression()), whileBody, whileContinue);
		visit(ctx.stat());
		emit(OpCode.jumpI, labels.get(ctx));
		emit(whileContinue, OpCode.nop);
		
		return null; }
	
	@Override public Op visitStatAssign(EloquenceParser.StatAssignContext ctx) { 
		visitChildren(ctx);
		
			if(checkResult.getType(ctx.expression()).equals(Type.CHAR)){
				emit(OpCode.c2c, reg(ctx.expression()),reg(ctx.target()));
				emit(OpCode.storeAI, reg(ctx.target()), arp, offset(ctx.target()));
			}
			else{
				emit(OpCode.i2i, reg(ctx.expression()),reg(ctx.target()));
				emit(OpCode.storeAI, reg(ctx.target()), arp, offset(ctx.target())); //TODO offset of ID
			}
		
		return null; }
	
	@Override public Op visitStatAssignArray(EloquenceParser.StatAssignArrayContext ctx) {
		visitChildren(ctx);
		
		System.out.println("stat assign array \n");
		
			//Start by computing the begin value of the array. We'll store that in reg1
			emit(OpCode.loadAI, arp, offset(ctx.target()), reg1);
			//Now we need the index value. This is stored in expression(0). We'll store it in reg2
			emit(OpCode.loadI, new Num(Integer.parseInt(ctx.expression(0).getText())),reg2);
			//Subtract the index by the begin value.
			emit(OpCode.sub, reg2, reg1, reg1);
			//Multiply by four to get the offset
			emit(OpCode.multI, reg1, new Num(4), reg1);
			//Add 8
			emit(OpCode.addI, reg1, new Num(8),reg1); //This is the address where the value needs to be stored.
			
			//The the target value
		//	emit(OpCode.loadI, new Num(Integer.parseInt(ctx.expression(2).getText())), reg2);
			 emit(OpCode.storeAI, reg(ctx.expression(1)), arp,reg1);
			
		return null; }
	
	@Override public Op visitStatAssignArrayMult(EloquenceParser.StatAssignArrayMultContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatBlock(EloquenceParser.StatBlockContext ctx) {
		if(labels.get(ctx) != null)
			emit(labels.get(ctx), OpCode.nop);
		
		return visitChildren(ctx); }
	
	@Override public Op visitStatReturn(EloquenceParser.StatReturnContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatIn(EloquenceParser.StatInContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatOut(EloquenceParser.StatOutContext ctx) { 
		for(ExpressionContext out : ctx.expression()){
			emit(OpCode.out, new Str("Output: ") , reg(out));
		}
		
		return visitChildren(ctx); }
	
	@Override public Op visitStatVoid(finalProject.grammar.EloquenceParser.StatVoidContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatBlockBody(EloquenceParser.StatBlockBodyContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitTargetId(EloquenceParser.TargetIdContext ctx) {
		System.out.println("Target ID");
			emit(OpCode.loadAI, arp, offset(ctx.ID()), reg(ctx));
		
			return null;  }
	
	@Override public Op visitNewID(EloquenceParser.NewIDContext ctx) { 
		System.out.println("visit New ID");
			emit(OpCode.loadAI, arp, offset(ctx.ID()), reg(ctx.ID()));
		//	emit(OpCode.storeAI, reg(ctx.ID()), arp, offset(ctx.ID()));
		return visitChildren(ctx); }
	
	@Override public Op visitReturnStat(EloquenceParser.ReturnStatContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprComp(EloquenceParser.ExprCompContext ctx) { 
		visitChildren(ctx);
		if(ctx.compare().LT() != null){
			emit(OpCode.cmp_LT, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
		} else if(ctx.compare().LE() != null){
			emit(OpCode.cmp_LE, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
		} else if(ctx.compare().GE() != null){
			emit(OpCode.cmp_GE, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
		} else if(ctx.compare().GT() != null){
			emit(OpCode.cmp_GT, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
		} else if(ctx.compare().EQ() != null){
			emit(OpCode.cmp_EQ, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
		} else if(ctx.compare().NE() != null){
			emit(OpCode.cmp_NE, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
		} 
		
		return null; }
	
	@Override public Op visitExprCompound(EloquenceParser.ExprCompoundContext ctx) { 
		visitChildren(ctx);
		
		if(checkResult.getType(ctx.expression()).equals(Type.CHAR))
			emit(OpCode.c2c, reg(ctx.expression()),reg(ctx));
		else 
			emit(OpCode.i2i, reg(ctx.expression()),reg(ctx));
		
		return null; 
		
	}
	
	@Override public Op visitExprMult(EloquenceParser.ExprMultContext ctx) { 
		visitChildren(ctx);
		
		if(ctx.multiply().MULTIPLY() != null){
			emit(OpCode.mult, reg(ctx.expression(0)),reg(ctx.expression(1)),reg(ctx));
		} else if(ctx.multiply().DIVIDE() != null){
			emit(OpCode.div, reg(ctx.expression(0)),reg(ctx.expression(1)),reg(ctx));
		} else if(ctx.multiply().MODULO() != null){
			emit(OpCode.div, reg(ctx.expression(0)),reg(ctx.expression(1)),reg1);
			emit(OpCode.mult, reg1,reg(ctx.expression(1)),reg1);
			emit(OpCode.sub, reg(ctx.expression(0)),reg1,reg(ctx));
		}
		
		return visitChildren(ctx); }
	
	@Override public Op visitExprUnary(EloquenceParser.ExprUnaryContext ctx) { 
		
		visitChildren(ctx);
		if(ctx.unary().PLUS() != null){
			emit(OpCode.i2i, reg(ctx.expression()), reg(ctx));
		} else if(ctx.unary().MINUS() != null){
			emit(OpCode.rsubI, reg(ctx.expression()) ,new Num(0), reg(ctx));
		} else if(ctx.unary().NOT() != null){
			emit(OpCode.xorI, reg(ctx.expression()), new Num(1),reg(ctx));
		}
		
		return visitChildren(ctx); }
	
	@Override public Op visitExprNum(EloquenceParser.ExprNumContext ctx) { 
		emit(OpCode.loadI, new Num(Integer.parseInt(ctx.getText())), reg(ctx));
		return visitChildren(ctx); }
	
	@Override public Op visitExprTrue(EloquenceParser.ExprTrueContext ctx) { 
		emit(OpCode.loadI, new Num(1), reg(ctx));
		return visitChildren(ctx); }
	
	//TODO check whether this is correct
	@Override public Op visitExprChar(EloquenceParser.ExprCharContext ctx) { 
		emit(OpCode.loadI, new Num((int)ctx.getText().charAt(1)), reg1);
		emit(OpCode.i2c, reg1, reg(ctx));
		return visitChildren(ctx); }
	
	@Override public Op visitExprFunc(EloquenceParser.ExprFuncContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprOr(EloquenceParser.ExprOrContext ctx) {
		visitChildren(ctx);
		emit(OpCode.or, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
	return null; }
	
	@Override public Op visitExprPar(EloquenceParser.ExprParContext ctx) { 
		visitChildren(ctx);
		
		if(checkResult.getType(ctx.expression()).equals(Type.CHAR))
			emit(OpCode.c2c, reg(ctx.expression()),reg(ctx));
		else 
			emit(OpCode.i2i, reg(ctx.expression()),reg(ctx));
		
		return null; }
	
	@Override public Op visitExprAdd(EloquenceParser.ExprAddContext ctx) {
		visitChildren(ctx);
		
		if(ctx.addition().PLUS() != null){
			emit(OpCode.add,reg(ctx.expression(0)), reg(ctx.expression(1)),reg(ctx));
		} else if(ctx.addition().MINUS() != null){
			emit(OpCode.sub,reg(ctx.expression(0)), reg(ctx.expression(1)),reg(ctx));
		}
		
		return null; }
	
	@Override public Op visitExprAnd(EloquenceParser.ExprAndContext ctx) {
		visitChildren(ctx);
			emit(OpCode.and, reg(ctx.expression(0)), reg(ctx.expression(1)), reg(ctx));
		return null; }
	
	@Override public Op visitExprId(EloquenceParser.ExprIdContext ctx) { 
		visitChildren(ctx);
		emit(OpCode.i2i, reg(ctx.target()),reg(ctx));
		return null; }
	
	@Override public Op visitExprFalse(EloquenceParser.ExprFalseContext ctx) {
		emit(OpCode.loadI, new Num(0), reg(ctx));
		return null; }
	
	@Override public Op visitExprArray(EloquenceParser.ExprArrayContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitArrayMulExpr(EloquenceParser.ArrayMulExprContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitArraySingleExpr(EloquenceParser.ArraySingleExprContext ctx) { return visitChildren(ctx); }
	
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
	
	@Override public Op visitFunctionID(EloquenceParser.FunctionIDContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitVoidFunc(EloquenceParser.VoidFuncContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitReturnFunc(EloquenceParser.ReturnFuncContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitParameters(EloquenceParser.ParametersContext ctx) { return visitChildren(ctx); }
}
