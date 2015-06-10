package pp.block5.cc.simple;

import java.math.BigInteger;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block5.cc.pascal.SimplePascalBaseVisitor;
import pp.block5.cc.pascal.SimplePascalParser;
import pp.block5.cc.pascal.SimplePascalParser.StatContext;
import pp.block5.cc.pascal.SimplePascalParser.VarContext;
import pp.iloc.Simulator;
import pp.iloc.model.Label;
import pp.iloc.model.Num;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Operand;
import pp.iloc.model.Program;
import pp.iloc.model.Reg;
import pp.iloc.model.Str;
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
	
	@Override public Op visitProgram(SimplePascalParser.ProgramContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override public Op visitBody(SimplePascalParser.BodyContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitVarDecl(SimplePascalParser.VarDeclContext ctx) {
		//for(VarContext var : ctx.var())
			//visitVar(var);
		return null;
	}
	
	@Override public Op visitVar(SimplePascalParser.VarContext ctx) {
		for(TerminalNode id : ctx.ID())
			emit(OpCode.loadAI, arp, offset(id), reg(id));
		return null;
	}
	
	@Override public Op visitBlock(SimplePascalParser.BlockContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitAssStat(SimplePascalParser.AssStatContext ctx) {
		if(labels.get(ctx) != null)
			labels.put(ctx.expr(), labels.get(ctx));
		visitChildren(ctx);
			emit(OpCode.i2i, reg(ctx.expr()), reg(ctx.target()));
		return emit(OpCode.storeAI, reg(ctx.target()), arp, offset(ctx.target()));
	}
	
	@Override public Op visitIfStat(SimplePascalParser.IfStatContext ctx) {
		if(labels.get(ctx) != null)
			labels.put(ctx.expr(), label(ctx));
		visit(ctx.expr());
		Label continueLabel;
		if(labels.get(getSibling(ctx)) == null && getWhileParent(ctx) == null){
			continueLabel = createLabel(ctx, "continue");
			labels.put(getSibling(ctx), continueLabel);
			labels.put(getSibling(ctx.getParent()), continueLabel);
		}else if(getWhileParent(ctx) == null){
			continueLabel = labels.get(getSibling(ctx));
			labels.put(getSibling(ctx.getParent()), continueLabel);
		}else{
			continueLabel = labels.get(getWhileParent(ctx));
		}
		Label ifLabel = createLabel(ctx, "if");
		labels.put(ctx.stat(0), ifLabel);
		if(ctx.ELSE() != null){
			Label elseLabel = createLabel(ctx, "else");
			labels.put(ctx.stat(1), elseLabel);
			emit(OpCode.cbr, reg(ctx.expr()), ifLabel, elseLabel);
			for(StatContext stat : ctx.stat()){
				visit(stat);
				emit(OpCode.jumpI, continueLabel);
			}
		}else{
			emit(OpCode.cbr, reg(ctx.expr()), ifLabel, continueLabel);
			visit(ctx.stat(0));
			emit(OpCode.jumpI, continueLabel);
		}
		if(getSibling(ctx.getParent()) == null)
			emit(continueLabel, OpCode.i2i, arp, arp);
		return null;
	}
	
	@Override public Op visitWhileStat(SimplePascalParser.WhileStatContext ctx) {
		labels.put(ctx, createLabel(ctx, "while"));
		labels.put(ctx.expr(), label(ctx));
		labels.put(ctx.stat(), createLabel(ctx, "whileBody"));
		Label continueLabel;
		if(labels.get(getSibling(ctx)) == null){
			continueLabel = createLabel(ctx, "continue");
			labels.put(getSibling(ctx), continueLabel);
		}else
			continueLabel = labels.get(getSibling(ctx));
		visit(ctx.expr());
		emit(OpCode.cbr, reg(ctx.expr()), label(ctx.stat()), continueLabel);
		visit(ctx.stat());
		emit(OpCode.jumpI, label(ctx));
		return null;
	}
	
	@Override public Op visitBlockStat(SimplePascalParser.BlockStatContext ctx) {
		if(labels.get(ctx) != null){
			labels.put(ctx.block().stat(0), label(ctx));
		}
		return visitChildren(ctx);
	}
	
	@Override public Op visitInStat(SimplePascalParser.InStatContext ctx) {
		if(labels.get(ctx) != null)
			labels.put(ctx.target(), labels.get(ctx));
		visit(ctx.target());
		emit(OpCode.in, new Str("agruments? "), reg(ctx.target()));
		return emit(OpCode.storeAI, reg(ctx.target()), arp, offset(ctx.target()));
	}
	
	@Override public Op visitOutStat(SimplePascalParser.OutStatContext ctx) {
		if(labels.get(ctx) != null)
			labels.put(ctx.expr(), labels.get(ctx));
		visit(ctx.expr());
		return emit(OpCode.out, new Str(ctx.STR().getText().substring(1, ctx.STR().getText().length()-1)), reg(ctx.expr()));
	}
	
	@Override public Op visitIdTarget(SimplePascalParser.IdTargetContext ctx) {
		if(labels.get(ctx) != null)
			labels.put(ctx.getChild(0), label(ctx));
		if(labels.get(ctx) != null)
			emit(label(ctx), OpCode.loadAI, arp, offset(ctx.ID()), reg(ctx));
		else
			emit(OpCode.loadAI, arp, offset(ctx.ID()), reg(ctx));
		return null;
	}
	
	@Override public Op visitParExpr(SimplePascalParser.ParExprContext ctx) {
		if(labels.get(ctx) != null)
			labels.put(ctx.getChild(0), label(ctx));
		visitChildren(ctx);
		return emit(OpCode.i2i, reg(ctx.expr()), reg(ctx));
	}
	
	@Override public Op visitTrueExpr(SimplePascalParser.TrueExprContext ctx) {
		if(labels.get(ctx) != null)
			emit(label(ctx), OpCode.loadI, new Num(-1), reg(ctx));
		else
			emit(OpCode.loadI, new Num(-1), reg(ctx));
		return null;
	}
	
	@Override public Op visitCompExpr(SimplePascalParser.CompExprContext ctx) {
		if(labels.get(ctx) != null)
			labels.put(ctx.expr(0), label(ctx));
		visitChildren(ctx);
		if(ctx.compOp().LE() != null){
				emit(OpCode.cmp_LE, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		}else if(ctx.compOp().LT() != null){
				emit(OpCode.cmp_LT, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));			
		}else if(ctx.compOp().GE() != null){
				emit(OpCode.cmp_GE, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		}else if(ctx.compOp().GT() != null){
				emit(OpCode.cmp_GT, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		}else if(ctx.compOp().EQ() != null){
				emit(OpCode.cmp_EQ, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		}else if(ctx.compOp().NE() != null){
				emit(OpCode.cmp_NE, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		}
		return null;
	}
	
	@Override public Op visitPrfExpr(SimplePascalParser.PrfExprContext ctx) {
		if(labels.get(ctx) != null)
			labels.put(ctx.expr(), label(ctx));
		visitChildren(ctx);
		if(ctx.prfOp().MINUS() != null)
				emit(OpCode.multI, reg(ctx.expr()), new Num(-1), reg(ctx));
		else
				emit(OpCode.xorI, reg(ctx.expr()), new Num(-1), reg(ctx));			
		return null;
	}
	
	@Override public Op visitFalseExpr(SimplePascalParser.FalseExprContext ctx) {
		if(labels.get(ctx) != null)
			emit(label(ctx), OpCode.loadI, new Num(0), reg(ctx));
		else
			emit(OpCode.loadI, new Num(0), reg(ctx));
		return null;
	}
	
	@Override public Op visitBoolExpr(SimplePascalParser.BoolExprContext ctx) {
		if(labels.get(ctx) != null)
			labels.put(ctx.expr(0), labels.get(ctx));
		visitChildren(ctx);
		if(ctx.boolOp().AND() != null)
				emit(OpCode.and, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		else
				emit(OpCode.or, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));			
		return null;
	}
	
	@Override public Op visitMultExpr(SimplePascalParser.MultExprContext ctx) {
		if(labels.get(ctx) != null)
			labels.put(ctx.expr(0), labels.get(ctx));
		visitChildren(ctx);
		if(ctx.multOp().STAR() != null)
				emit(OpCode.mult, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		else
				emit(OpCode.div, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));			
		return null;
	}
	
	@Override public Op visitNumExpr(SimplePascalParser.NumExprContext ctx) {
		if(labels.get(ctx) != null)
			emit(label(ctx), OpCode.loadI, new Num(Integer.parseInt(ctx.NUM().toString())), reg(ctx));
		else
			emit(OpCode.loadI, new Num(Integer.parseInt(ctx.NUM().toString())), reg(ctx));			
		return null;
	}
	
	@Override public Op visitPlusExpr(SimplePascalParser.PlusExprContext ctx) {
		if(labels.get(ctx) != null)
			labels.put(ctx.expr(0), labels.get(ctx));
		visitChildren(ctx);
		if(ctx.plusOp().PLUS() != null){
				emit(OpCode.add, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
		}else{
				emit(OpCode.sub, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));			
		}
		return null;
	}
	
	@Override public Op visitIdExpr(SimplePascalParser.IdExprContext ctx) {
		if(labels.get(ctx) != null)
			emit(label(ctx), OpCode.loadAI, arp, offset(ctx.ID()), reg(ctx));
		else
			emit(OpCode.loadAI, arp, offset(ctx.ID()), reg(ctx));			
		return null;
	}
	
	@Override public Op visitPrfOp(SimplePascalParser.PrfOpContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitMultOp(SimplePascalParser.MultOpContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitPlusOp(SimplePascalParser.PlusOpContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitBoolOp(SimplePascalParser.BoolOpContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitCompOp(SimplePascalParser.CompOpContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitIntType(SimplePascalParser.IntTypeContext ctx) { return visitChildren(ctx); }
	
	@Override public Op visitBoolType(SimplePascalParser.BoolTypeContext ctx) { return visitChildren(ctx); }
	
	private ParseTree getSibling(ParseTree ctx){
		ParseTree parent = ctx.getParent();
		if(parent != null){
			for(int index = 0; index < parent.getChildCount(); index++)
				if(parent.getChild(index).equals(ctx))
					for(int index_b = index+1; index_b < parent.getChildCount(); index_b++)
						if(!(parent.getChild(index_b) instanceof TerminalNode)){
							return parent.getChild(index_b);
						}
			return getSibling(parent);
		}
		return null;
	}
	
	private ParseTree getWhileParent(ParseTree ctx){
		ParseTree parent = ctx.getParent();
		if(parent != null){
			if(parent.getText().toLowerCase().startsWith("while"))
				return parent;
			return getWhileParent(parent);
		}
		return null;
	}
}
