// Generated from SBN.g4 by ANTLR 4.5
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
	void enterNumber(SBNParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBNParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(SBNParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SBNParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(SBNParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBNParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(SBNParser.SignContext ctx);
	/**
	 * Enter a parse tree produced by {@link SBNParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(SBNParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBNParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(SBNParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SBNParser#bit}.
	 * @param ctx the parse tree
	 */
	void enterBit(SBNParser.BitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBNParser#bit}.
	 * @param ctx the parse tree
	 */
	void exitBit(SBNParser.BitContext ctx);
}