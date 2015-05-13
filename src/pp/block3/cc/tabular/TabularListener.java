// Generated from Tabular.g4 by ANTLR 4.5
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TabularParser}.
 */
public interface TabularListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TabularParser#latex}.
	 * @param ctx the parse tree
	 */
	void enterLatex(TabularParser.LatexContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#latex}.
	 * @param ctx the parse tree
	 */
	void exitLatex(TabularParser.LatexContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#begin}.
	 * @param ctx the parse tree
	 */
	void enterBegin(TabularParser.BeginContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#begin}.
	 * @param ctx the parse tree
	 */
	void exitBegin(TabularParser.BeginContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#begType}.
	 * @param ctx the parse tree
	 */
	void enterBegType(TabularParser.BegTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#begType}.
	 * @param ctx the parse tree
	 */
	void exitBegType(TabularParser.BegTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(TabularParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(TabularParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code onlyEntry}
	 * labeled alternative in {@link TabularParser#tabLine}.
	 * @param ctx the parse tree
	 */
	void enterOnlyEntry(TabularParser.OnlyEntryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code onlyEntry}
	 * labeled alternative in {@link TabularParser#tabLine}.
	 * @param ctx the parse tree
	 */
	void exitOnlyEntry(TabularParser.OnlyEntryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andEntry}
	 * labeled alternative in {@link TabularParser#tabLine}.
	 * @param ctx the parse tree
	 */
	void enterAndEntry(TabularParser.AndEntryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andEntry}
	 * labeled alternative in {@link TabularParser#tabLine}.
	 * @param ctx the parse tree
	 */
	void exitAndEntry(TabularParser.AndEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#tabEntry}.
	 * @param ctx the parse tree
	 */
	void enterTabEntry(TabularParser.TabEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#tabEntry}.
	 * @param ctx the parse tree
	 */
	void exitTabEntry(TabularParser.TabEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(TabularParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(TabularParser.EndContext ctx);
	/**
	 * Enter a parse tree produced by {@link TabularParser#endType}.
	 * @param ctx the parse tree
	 */
	void enterEndType(TabularParser.EndTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TabularParser#endType}.
	 * @param ctx the parse tree
	 */
	void exitEndType(TabularParser.EndTypeContext ctx);
}