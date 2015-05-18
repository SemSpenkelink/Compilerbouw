package pp.huiswerk;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.Lexer;

public class Grammar3 extends grammar3BaseListener{
	
	
	private ParseTreeProperty<Integer> depths;
	
	public void init(String text){
		depths = new ParseTreeProperty<Integer>();
		Lexer lexer = new grammar3Lexer(new ANTLRInputStream(text));
		grammar3Parser parser = new grammar3Parser(new CommonTokenStream(lexer)); 
		ParseTree tree = parser.e();
		new ParseTreeWalker().walk(this, tree);
	}
	
	@Override public void enterR(@NotNull grammar3Parser.RContext ctx) {computeDepth(ctx);
	}
	
	@Override public void exitR(@NotNull grammar3Parser.RContext ctx) {computeDepth(ctx); }

	
	@Override public void enterEveryRule(@NotNull ParserRuleContext ctx) {computeDepth(ctx); }
	
	@Override public void exitEveryRule(@NotNull ParserRuleContext ctx) {computeDepth(ctx); }
	
	@Override public void visitTerminal(@NotNull TerminalNode node) {setDepth(node, 1);
		
	}
	
	@Override public void visitErrorNode(@NotNull ErrorNode node) {setDepth(node, 1); }
	
	private void computeDepth(ParseTree tree) {
		int depth = 1;
		for (int i = 0; i < tree.getChildCount(); i++) {
			depth = Math.max(depth, getDepth(tree.getChild(i)) + 1);
		}
		setDepth(tree, depth);
	}

	/** Returns the stored depth of a given Antlr parse tree. */
	private Integer getDepth(ParseTree node) {
		return depths.get(node);
	}

	/** Stores the depth of a given Antlr parse tree. */
	private void setDepth(ParseTree node, Integer ast) {
		depths.put(node, ast);
	}
	
	public static void main(String args[]){
		Grammar3 myGram = new Grammar3();
	
	}
}
