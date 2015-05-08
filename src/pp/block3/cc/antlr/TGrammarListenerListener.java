// Generated from TGrammarListener.g4 by ANTLR 4.4
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TGrammarListenerParser}.
 */
public interface TGrammarListenerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterT(@NotNull TGrammarListenerParser.TContext ctx);
	/**
	 * Exit a parse tree produced by {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitT(@NotNull TGrammarListenerParser.TContext ctx);
}