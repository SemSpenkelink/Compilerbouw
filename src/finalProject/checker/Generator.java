package finalProject.checker;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import finalProject.grammar.EloquenceBaseVisitor;
import finalProject.grammar.EloquenceParser;
import pp.block5.cc.simple.Result;
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
	
	@Override public Op visitProgram(EloquenceParser.ProgramContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitBody(EloquenceParser.BodyContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitDeclVar(EloquenceParser.DeclVarContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitDeclConstVar(EloquenceParser.DeclConstVarContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitDeclArray(EloquenceParser.DeclArrayContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitVariable(EloquenceParser.VariableContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitArrayTypeDecl(EloquenceParser.ArrayTypeDeclContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitArrayElem(EloquenceParser.ArrayElemContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitVarArrayDecl(EloquenceParser.VarArrayDeclContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitConstArrayDecl(EloquenceParser.ConstArrayDeclContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatIf(EloquenceParser.StatIfContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatWhile(EloquenceParser.StatWhileContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatAssign(EloquenceParser.StatAssignContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatAssignArray(EloquenceParser.StatAssignArrayContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatAssignArrayMult(EloquenceParser.StatAssignArrayMultContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatBlock(EloquenceParser.StatBlockContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatReturn(EloquenceParser.StatReturnContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatIn(EloquenceParser.StatInContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatOut(EloquenceParser.StatOutContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitStatBlockBody(EloquenceParser.StatBlockBodyContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitTargetId(EloquenceParser.TargetIdContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitNewID(EloquenceParser.NewIDContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitReturnStat(EloquenceParser.ReturnStatContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprComp(EloquenceParser.ExprCompContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprCompound(EloquenceParser.ExprCompoundContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprMult(EloquenceParser.ExprMultContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprUnary(EloquenceParser.ExprUnaryContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprNum(EloquenceParser.ExprNumContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprTrue(EloquenceParser.ExprTrueContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprChar(EloquenceParser.ExprCharContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprFunc(EloquenceParser.ExprFuncContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprOr(EloquenceParser.ExprOrContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprPar(EloquenceParser.ExprParContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprAdd(EloquenceParser.ExprAddContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprAnd(EloquenceParser.ExprAndContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprId(EloquenceParser.ExprIdContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitExprFalse(EloquenceParser.ExprFalseContext ctx) { return visitChildren(ctx); }
	
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
