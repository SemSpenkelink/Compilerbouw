// Generated from TypeUse.g4 by ANTLR 4.5
package pp.huiswerk;
import org.antlr.v4.runtime.misc.NotNull;
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
	 * Enter a parse tree produced by {@link TypeUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(TypeUseParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeUseParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(TypeUseParser.UnitContext ctx);
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