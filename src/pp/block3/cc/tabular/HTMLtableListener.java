// Generated from HTMLtable.g4 by ANTLR 4.4
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HTMLtableParser}.
 */
public interface HTMLtableListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HTMLtableParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(@NotNull HTMLtableParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLtableParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(@NotNull HTMLtableParser.EntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLtableParser#doc}.
	 * @param ctx the parse tree
	 */
	void enterDoc(@NotNull HTMLtableParser.DocContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLtableParser#doc}.
	 * @param ctx the parse tree
	 */
	void exitDoc(@NotNull HTMLtableParser.DocContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLtableParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(@NotNull HTMLtableParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLtableParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(@NotNull HTMLtableParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLtableParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(@NotNull HTMLtableParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLtableParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(@NotNull HTMLtableParser.TableContext ctx);
}