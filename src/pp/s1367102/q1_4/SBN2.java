package pp.s1367102.q1_4;

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

import pp.s1367102.q1_4.SBN2Parser.NumberContext;

public class SBN2 extends SBN2BaseListener
{
	ParseTreeProperty<Integer> num;
	ParseTreeProperty<Boolean> sign;
	ParseTreeProperty<Integer> pos;
 	
	public void init(){
		num  = new ParseTreeProperty<Integer>();
		sign  = new ParseTreeProperty<Boolean>();
		pos  = new ParseTreeProperty<Integer>();
	}
	
	@Override public void enterZero(@NotNull SBN2Parser.ZeroContext ctx) {
		pos.put(ctx, pos.get(ctx.getParent()));
	}
	
	@Override public void exitZero(@NotNull SBN2Parser.ZeroContext ctx) {
		num.put(ctx, 0);
		
	}
	
	@Override public void enterNumber(@NotNull SBN2Parser.NumberContext ctx) {
		pos.put(ctx.list(), 0);
	}

	@Override public void exitNumber(@NotNull SBN2Parser.NumberContext ctx) {
		int tmp = (sign.get(ctx.sign()) ) ? -1*num.get(ctx.list()) : num.get(ctx.list()); 
			
		num.put(ctx, tmp);
		
	}

	@Override public void enterMin(@NotNull SBN2Parser.MinContext ctx) { }

	@Override public void exitMin(@NotNull SBN2Parser.MinContext ctx) {
		sign.put(ctx, true);
	}

	@Override public void enterOnlyBit(@NotNull SBN2Parser.OnlyBitContext ctx) {
		pos.put(ctx.bit(),pos.get(ctx));
	}
	
	@Override public void exitOnlyBit(@NotNull SBN2Parser.OnlyBitContext ctx) {
		num.put(ctx, num.get(ctx.bit()));
	}
	
	@Override public void enterListBit(@NotNull SBN2Parser.ListBitContext ctx) {
		pos.put(ctx.list(), pos.get(ctx) + 1);
	}
	
	@Override public void exitListBit(@NotNull SBN2Parser.ListBitContext ctx) {
		num.put(ctx, num.get(ctx.bit()) + num.get(ctx.list()));
	}
	
	@Override public void enterOne(@NotNull SBN2Parser.OneContext ctx) {
		pos.put(ctx, pos.get(ctx.getParent()));
	}
	
	@Override public void exitOne(@NotNull SBN2Parser.OneContext ctx) {
		num.put(ctx, 1<<pos.get(ctx));
		
	}
	
	@Override public void enterPlus(@NotNull SBN2Parser.PlusContext ctx) { }
	
	@Override public void exitPlus(@NotNull SBN2Parser.PlusContext ctx) {
		sign.put(ctx, false);
	}

	
	@Override public void enterEveryRule(@NotNull ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(@NotNull ParserRuleContext ctx) { }
	
	@Override public void visitTerminal(@NotNull TerminalNode node) { }
	
	@Override public void visitErrorNode(@NotNull ErrorNode node) { }
	
	public int res(ParseTree tree){
		return num.get(tree);
	}
}
