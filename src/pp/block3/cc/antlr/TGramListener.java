// Generated from TGram.g4 by ANTLR 4.5
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TGramParser}.
 */
public interface TGramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TGramParser#t}.
	 * @param ctx the parse tree
	 */
	void enterT(TGramParser.TContext ctx);
	/**
	 * Exit a parse tree produced by {@link TGramParser#t}.
	 * @param ctx the parse tree
	 */
	void exitT(TGramParser.TContext ctx);
}