// Generated from SBN2.g4 by ANTLR 4.4
package pp.s1367102.q1_4;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SBN2Parser}.
 */
public interface SBN2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code zero}
	 * labeled alternative in {@link SBN2Parser#bit}.
	 * @param ctx the parse tree
	 */
	void enterZero(@NotNull SBN2Parser.ZeroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code zero}
	 * labeled alternative in {@link SBN2Parser#bit}.
	 * @param ctx the parse tree
	 */
	void exitZero(@NotNull SBN2Parser.ZeroContext ctx);
	/**
	 * Enter a parse tree produced by {@link SBN2Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull SBN2Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBN2Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull SBN2Parser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code min}
	 * labeled alternative in {@link SBN2Parser#sign}.
	 * @param ctx the parse tree
	 */
	void enterMin(@NotNull SBN2Parser.MinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code min}
	 * labeled alternative in {@link SBN2Parser#sign}.
	 * @param ctx the parse tree
	 */
	void exitMin(@NotNull SBN2Parser.MinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code onlyBit}
	 * labeled alternative in {@link SBN2Parser#list}.
	 * @param ctx the parse tree
	 */
	void enterOnlyBit(@NotNull SBN2Parser.OnlyBitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code onlyBit}
	 * labeled alternative in {@link SBN2Parser#list}.
	 * @param ctx the parse tree
	 */
	void exitOnlyBit(@NotNull SBN2Parser.OnlyBitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listBit}
	 * labeled alternative in {@link SBN2Parser#list}.
	 * @param ctx the parse tree
	 */
	void enterListBit(@NotNull SBN2Parser.ListBitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listBit}
	 * labeled alternative in {@link SBN2Parser#list}.
	 * @param ctx the parse tree
	 */
	void exitListBit(@NotNull SBN2Parser.ListBitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code one}
	 * labeled alternative in {@link SBN2Parser#bit}.
	 * @param ctx the parse tree
	 */
	void enterOne(@NotNull SBN2Parser.OneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code one}
	 * labeled alternative in {@link SBN2Parser#bit}.
	 * @param ctx the parse tree
	 */
	void exitOne(@NotNull SBN2Parser.OneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link SBN2Parser#sign}.
	 * @param ctx the parse tree
	 */
	void enterPlus(@NotNull SBN2Parser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link SBN2Parser#sign}.
	 * @param ctx the parse tree
	 */
	void exitPlus(@NotNull SBN2Parser.PlusContext ctx);
}