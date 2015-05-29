package pp.block5.cc.simple;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block5.cc.pascal.SimplePascalBaseVisitor;
import pp.block5.cc.pascal.SimplePascalParser;
import pp.block5.cc.pascal.SimplePascalParser.VarContext;
import pp.iloc.Simulator;
import pp.iloc.model.Label;
import pp.iloc.model.Num;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Operand;
import pp.iloc.model.Program;
import pp.iloc.model.Reg;
/** Class to generate ILOC code for Simple Pascal. */
public class Generator extends SimplePascalBaseVisitor<Op> {
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
	
	@Override public Op visitProgram(SimplePascalParser.ProgramContext ctx) {
		reg(ctx);
		return visitChildren(ctx);
	}
	
	@Override public Op visitBody(SimplePascalParser.BodyContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitVarDecl(SimplePascalParser.VarDeclContext ctx) {
		for(VarContext var : ctx.var())
			visitVar(var);
		return null;
	}
	
	@Override public Op visitVar(SimplePascalParser.VarContext ctx) {
		for(TerminalNode id : ctx.ID())
			this.prog.addInstr(emit(OpCode.loadAI, arp, offset(id), reg(ctx)));
		return null;
	}
	
	@Override public Op visitBlock(SimplePascalParser.BlockContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitAssStat(SimplePascalParser.AssStatContext ctx) {
		return emit(OpCode.i2i, reg(ctx.expr()), reg(ctx.target()));
	}
	
	@Override public Op visitIfStat(SimplePascalParser.IfStatContext ctx) {
		Op expressionOp = visit(ctx.expr());
		this.prog.addInstr(expressionOp);
		if(ctx.ELSE() != null){
			Op ifPart = visit(ctx.stat(0));
			Op elsePart = visit(ctx.stat(0));
			//Heeft wel else
		}else{
			//Heeft geen else
		}
		return visitChildren(ctx);
	}
	
	@Override public Op visitWhileStat(SimplePascalParser.WhileStatContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitBlockStat(SimplePascalParser.BlockStatContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitInStat(SimplePascalParser.InStatContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitOutStat(SimplePascalParser.OutStatContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitIdTarget(SimplePascalParser.IdTargetContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitParExpr(SimplePascalParser.ParExprContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitTrueExpr(SimplePascalParser.TrueExprContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitCompExpr(SimplePascalParser.CompExprContext ctx) {
		visitChildren(ctx);
		if(ctx.compOp().LE() != null){
			return emit(OpCode.cmp_LE, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		}else if(ctx.compOp().LT() != null){
			return emit(OpCode.cmp_LT, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));			
		}else if(ctx.compOp().GE() != null){
			return emit(OpCode.cmp_GE, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		}else if(ctx.compOp().GT() != null){
			return emit(OpCode.cmp_GT, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		}else if(ctx.compOp().EQ() != null){
			return emit(OpCode.cmp_EQ, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		}else if(ctx.compOp().NE() != null){
			return emit(OpCode.cmp_NE, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		}
		return null;
	}
	
	@Override public Op visitPrfExpr(SimplePascalParser.PrfExprContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitFalseExpr(SimplePascalParser.FalseExprContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitBoolExpr(SimplePascalParser.BoolExprContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitMultExpr(SimplePascalParser.MultExprContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitNumExpr(SimplePascalParser.NumExprContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitPlusExpr(SimplePascalParser.PlusExprContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitIdExpr(SimplePascalParser.IdExprContext ctx) {	return visitChildren(ctx); }
	
	@Override public Op visitPrfOp(SimplePascalParser.PrfOpContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitMultOp(SimplePascalParser.MultOpContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitPlusOp(SimplePascalParser.PlusOpContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitBoolOp(SimplePascalParser.BoolOpContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitCompOp(SimplePascalParser.CompOpContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitIntType(SimplePascalParser.IntTypeContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitBoolType(SimplePascalParser.BoolTypeContext ctx) { return visitChildren(ctx); }
}
