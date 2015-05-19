package pp.block4.cc.cfg;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block4.cc.ErrorListener;

/** Template bottom-up CFG builder. */
public class BottomUpCFGBuilder extends FragmentBaseListener {
	/** The CFG being built. */
	private Graph graph;
	
	ParseTreeProperty<Node> entry = new ParseTreeProperty<Node>();
	ParseTreeProperty<Node> exit = new ParseTreeProperty<Node>();
	
	/** Builds the CFG for a program contained in a given file. */
	public Graph build(File file) {
		Graph result = null;
		ErrorListener listener = new ErrorListener();
		try {
			CharStream chars = new ANTLRInputStream(new FileReader(file));
			Lexer lexer = new FragmentLexer(chars);
			lexer.removeErrorListeners();
			lexer.addErrorListener(listener);
			TokenStream tokens = new CommonTokenStream(lexer);
			FragmentParser parser = new FragmentParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(listener);
			ParseTree tree = parser.program();
			if (listener.hasErrors()) {
				System.out.printf("Parse errors in %s:%n", file.getPath());
				for (String error : listener.getErrors()) {
					System.err.println(error);
				}
			} else {
				result = build(tree);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** Builds the CFG for a program given as an ANTLR parse tree. */
	public Graph build(ParseTree tree) {
		this.graph = new Graph();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(this, tree);
		return graph;
	}

	/** Adds a node to he CGF, based on a given parse tree node.
	 * Gives the CFG node a meaningful ID, consisting of line number and 
	 * a further indicator.
	 */
	private Node addNode(ParserRuleContext node, String text) {
		return this.graph.addNode(node.getStart().getLine() + ": " + text);
	}

	/** Main method to build and print the CFG of a simple Java program. */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [filename]+");
			return;
		}
		BottomUpCFGBuilder builder = new BottomUpCFGBuilder();
		for (String filename : args) {
			File file = new File(filename);
			System.out.println(filename);
			System.out.println(builder.build(file));
		}
	}
	
	public void awesomeMethod(ParserRuleContext ctx){
		Node entryNode = addNode(ctx, "");
		Node exitNode = addNode(ctx, "");
		for(int i = 0; i < ctx.getChildCount(); i++){
			entryNode.addEdge(entry.get(ctx.getChild(i)));
			exit.get(ctx.getChild(i)).addEdge(exitNode);
		}
		entry.put(ctx, entryNode);
		exit.put(ctx, exitNode);
	}
	
	@Override public void exitBlockStat(@NotNull FragmentParser.BlockStatContext ctx) {
		awesomeMethod(ctx);
	}

	@Override public void exitContStat(@NotNull FragmentParser.ContStatContext ctx) {awesomeMethod(ctx); }
	
	@Override public void exitDecl(@NotNull FragmentParser.DeclContext ctx) {awesomeMethod(ctx); }

	@Override public void exitPrintStat(@NotNull FragmentParser.PrintStatContext ctx) {awesomeMethod(ctx); }
	
	@Override public void exitProgram(@NotNull FragmentParser.ProgramContext ctx) {awesomeMethod(ctx); }
	
	@Override public void exitType(@NotNull FragmentParser.TypeContext ctx) { awesomeMethod(ctx);}

	@Override public void exitParExpr(@NotNull FragmentParser.ParExprContext ctx) { awesomeMethod(ctx);}
	
	@Override public void exitArrayTarget(@NotNull FragmentParser.ArrayTargetContext ctx) { awesomeMethod(ctx);}
	
	@Override public void exitCompExpr(@NotNull FragmentParser.CompExprContext ctx) { awesomeMethod(ctx);}
	
	@Override public void exitBitAndExpr(@NotNull FragmentParser.BitAndExprContext ctx) { awesomeMethod(ctx);}

	@Override public void exitWhileStat(@NotNull FragmentParser.WhileStatContext ctx) { awesomeMethod(ctx);}

	@Override public void exitIfStat(@NotNull FragmentParser.IfStatContext ctx) { awesomeMethod(ctx);}
	
	@Override public void exitIdTarget(@NotNull FragmentParser.IdTargetContext ctx) { awesomeMethod(ctx);}
	
	@Override public void exitArrayExpr(@NotNull FragmentParser.ArrayExprContext ctx) { awesomeMethod(ctx);}

	@Override public void exitInExpr(@NotNull FragmentParser.InExprContext ctx) { awesomeMethod(ctx);}

	@Override public void exitOrExpr(@NotNull FragmentParser.OrExprContext ctx) { awesomeMethod(ctx);}
	
	@Override public void exitBreakStat(@NotNull FragmentParser.BreakStatContext ctx) { awesomeMethod(ctx);}
	
	@Override public void exitFieldExpr(@NotNull FragmentParser.FieldExprContext ctx) { awesomeMethod(ctx);}
	
	@Override public void exitBitOrExpr(@NotNull FragmentParser.BitOrExprContext ctx) { awesomeMethod(ctx);}
	
	@Override public void exitNotExpr(@NotNull FragmentParser.NotExprContext ctx) { awesomeMethod(ctx);}
	
	@Override public void exitAddExpr(@NotNull FragmentParser.AddExprContext ctx) { awesomeMethod(ctx);}
	
	@Override public void exitAssignStat(@NotNull FragmentParser.AssignStatContext ctx) { awesomeMethod(ctx);}
	
	@Override public void exitConstExpr(@NotNull FragmentParser.ConstExprContext ctx) { awesomeMethod(ctx);}
	
	@Override public void exitIdExpr(@NotNull FragmentParser.IdExprContext ctx) { awesomeMethod(ctx);}
	
	@Override public void exitAndExpr(@NotNull FragmentParser.AndExprContext ctx) { awesomeMethod(ctx);}

	@Override public void visitTerminal(@NotNull TerminalNode node) {
		Node tmp = this.graph.addNode(node.getSymbol().getLine() + ": " + node.getText());
		entry.put(node, tmp);
		exit.put(node, tmp);
	}

	@Override public void visitErrorNode(@NotNull ErrorNode node) { }
}
