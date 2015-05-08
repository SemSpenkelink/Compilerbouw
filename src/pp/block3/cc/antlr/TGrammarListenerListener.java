// Generated from TGrammarListener.g4 by ANTLR 4.5
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TGrammarListenerParser}.
 */
public interface TGrammarListenerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code par}
	 * labeled alternative in {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterPar(TGrammarListenerParser.ParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code par}
	 * labeled alternative in {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitPar(TGrammarListenerParser.ParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code str}
	 * labeled alternative in {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterStr(TGrammarListenerParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code str}
	 * labeled alternative in {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitStr(TGrammarListenerParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterBool(TGrammarListenerParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitBool(TGrammarListenerParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code num}
	 * labeled alternative in {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterNum(TGrammarListenerParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code num}
	 * labeled alternative in {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitNum(TGrammarListenerParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equals}
	 * labeled alternative in {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterEquals(TGrammarListenerParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equals}
	 * labeled alternative in {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitEquals(TGrammarListenerParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hat}
	 * labeled alternative in {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterHat(TGrammarListenerParser.HatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hat}
	 * labeled alternative in {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitHat(TGrammarListenerParser.HatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void enterPlus(TGrammarListenerParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link TGrammarListenerParser#t}.
	 * @param ctx the parse tree
	 */
	void exitPlus(TGrammarListenerParser.PlusContext ctx);
}