// Generated from DeclUse.g4 by ANTLR 4.4
package pp.block3.cc.symbol;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DeclUseParser}.
 */
public interface DeclUseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ser}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterSer(@NotNull DeclUseParser.SerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ser}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitSer(@NotNull DeclUseParser.SerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dec}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterDec(@NotNull DeclUseParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dec}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitDec(@NotNull DeclUseParser.DecContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeclUseParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull DeclUseParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeclUseParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull DeclUseParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeclUseParser#series}.
	 * @param ctx the parse tree
	 */
	void enterSeries(@NotNull DeclUseParser.SeriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeclUseParser#series}.
	 * @param ctx the parse tree
	 */
	void exitSeries(@NotNull DeclUseParser.SeriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeclUseParser#use}.
	 * @param ctx the parse tree
	 */
	void enterUse(@NotNull DeclUseParser.UseContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeclUseParser#use}.
	 * @param ctx the parse tree
	 */
	void exitUse(@NotNull DeclUseParser.UseContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeclUseParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull DeclUseParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeclUseParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull DeclUseParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code us}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUs(@NotNull DeclUseParser.UsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code us}
	 * labeled alternative in {@link DeclUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUs(@NotNull DeclUseParser.UsContext ctx);
}