package pp.huiswerk42;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.huiswerk42.SBN2Parser.NumberContext;

public class SBN2 extends SBN2BaseListener
{
	ParseTreeProperty<Integer> result;
	
	public void init(){
		result  = new ParseTreeProperty<Integer>();
	}
	
	@Override public void enterZero(@NotNull SBN2Parser.ZeroContext ctx) { }
	
	@Override public void exitZero(@NotNull SBN2Parser.ZeroContext ctx) { }
	
	@Override public void enterNumber(@NotNull SBN2Parser.NumberContext ctx) { }

	@Override public void exitNumber(@NotNull SBN2Parser.NumberContext ctx) { }

	@Override public void enterMin(@NotNull SBN2Parser.MinContext ctx) { }

	@Override public void exitMin(@NotNull SBN2Parser.MinContext ctx) { }

	@Override public void enterOnlyBit(@NotNull SBN2Parser.OnlyBitContext ctx) { }
	
	@Override public void exitOnlyBit(@NotNull SBN2Parser.OnlyBitContext ctx) { }
	
	@Override public void enterListBit(@NotNull SBN2Parser.ListBitContext ctx) { }
	
	@Override public void exitListBit(@NotNull SBN2Parser.ListBitContext ctx) { }
	
	@Override public void enterOne(@NotNull SBN2Parser.OneContext ctx) { }
	
	@Override public void exitOne(@NotNull SBN2Parser.OneContext ctx) { }
	
	@Override public void enterPlus(@NotNull SBN2Parser.PlusContext ctx) { }
	
	@Override public void exitPlus(@NotNull SBN2Parser.PlusContext ctx) { }

	
	@Override public void enterEveryRule(@NotNull ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(@NotNull ParserRuleContext ctx) { }
	
	@Override public void visitTerminal(@NotNull TerminalNode node) { }
	
	@Override public void visitErrorNode(@NotNull ErrorNode node) { }
	
	public int res(){
		return 0;
	}
}
