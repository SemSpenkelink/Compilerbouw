// Generated from Arithmetic.g4 by ANTLR 4.5
package pp.block2.cc.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArithmeticParser}.
 */
public interface ArithmeticListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ArithmeticParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ArithmeticParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mult}
	 * labeled alternative in {@link ArithmeticParser#md}.
	 * @param ctx the parse tree
	 */
	void enterMult(ArithmeticParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mult}
	 * labeled alternative in {@link ArithmeticParser#md}.
	 * @param ctx the parse tree
	 */
	void exitMult(ArithmeticParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code div}
	 * labeled alternative in {@link ArithmeticParser#md}.
	 * @param ctx the parse tree
	 */
	void enterDiv(ArithmeticParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code div}
	 * labeled alternative in {@link ArithmeticParser#md}.
	 * @param ctx the parse tree
	 */
	void exitDiv(ArithmeticParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code add}
	 * labeled alternative in {@link ArithmeticParser#as}.
	 * @param ctx the parse tree
	 */
	void enterAdd(ArithmeticParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code add}
	 * labeled alternative in {@link ArithmeticParser#as}.
	 * @param ctx the parse tree
	 */
	void exitAdd(ArithmeticParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sub}
	 * labeled alternative in {@link ArithmeticParser#as}.
	 * @param ctx the parse tree
	 */
	void enterSub(ArithmeticParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sub}
	 * labeled alternative in {@link ArithmeticParser#as}.
	 * @param ctx the parse tree
	 */
	void exitSub(ArithmeticParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#rightOp}.
	 * @param ctx the parse tree
	 */
	void enterRightOp(ArithmeticParser.RightOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#rightOp}.
	 * @param ctx the parse tree
	 */
	void exitRightOp(ArithmeticParser.RightOpContext ctx);
}