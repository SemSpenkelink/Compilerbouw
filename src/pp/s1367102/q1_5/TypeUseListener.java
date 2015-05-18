// Generated from TypeUse.g4 by ANTLR 4.5
package pp.s1367102.q1_5;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TypeUseParser}.
 */
public interface TypeUseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TypeUseParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TypeUseParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeUseParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TypeUseParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeUseParser#series}.
	 * @param ctx the parse tree
	 */
	void enterSeries(TypeUseParser.SeriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeUseParser#series}.
	 * @param ctx the parse tree
	 */
	void exitSeries(TypeUseParser.SeriesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dec}
	 * labeled alternative in {@link TypeUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterDec(TypeUseParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dec}
	 * labeled alternative in {@link TypeUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitDec(TypeUseParser.DecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ass}
	 * labeled alternative in {@link TypeUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterAss(TypeUseParser.AssContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ass}
	 * labeled alternative in {@link TypeUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitAss(TypeUseParser.AssContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ser}
	 * labeled alternative in {@link TypeUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterSer(TypeUseParser.SerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ser}
	 * labeled alternative in {@link TypeUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitSer(TypeUseParser.SerContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeUseParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(TypeUseParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeUseParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(TypeUseParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeUseParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(TypeUseParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeUseParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(TypeUseParser.AssignContext ctx);
}