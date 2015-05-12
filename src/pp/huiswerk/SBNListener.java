// Generated from SBN.g4 by ANTLR 4.4
package pp.huiswerk;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SBNParser}.
 */
public interface SBNListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SBNParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull SBNParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBNParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull SBNParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SBNParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(@NotNull SBNParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBNParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(@NotNull SBNParser.SignContext ctx);
	/**
	 * Enter a parse tree produced by {@link SBNParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(@NotNull SBNParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBNParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(@NotNull SBNParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SBNParser#bit}.
	 * @param ctx the parse tree
	 */
	void enterBit(@NotNull SBNParser.BitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBNParser#bit}.
	 * @param ctx the parse tree
	 */
	void exitBit(@NotNull SBNParser.BitContext ctx);
}