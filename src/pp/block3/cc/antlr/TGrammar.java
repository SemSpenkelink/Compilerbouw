package pp.block3.cc.antlr;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block3.cc.antlr.TGrammarListenerParser.TContext;

public class TGrammar extends TGrammarListenerBaseListener{
	
	public void init(){
		
	}

	@Override public void enterT(@NotNull TGrammarListenerParser.TContext ctx) { }

	@Override public void exitT(@NotNull TGrammarListenerParser.TContext ctx) { }


	@Override public void enterEveryRule(@NotNull ParserRuleContext ctx) { }

	@Override public void exitEveryRule(@NotNull ParserRuleContext ctx) { }

	@Override public void visitTerminal(@NotNull TerminalNode node) { }

	@Override public void visitErrorNode(@NotNull ErrorNode node) { }
}
