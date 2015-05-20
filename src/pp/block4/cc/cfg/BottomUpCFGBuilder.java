package pp.block4.cc.cfg;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

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
	
	@Override public void exitBlockStat(@NotNull FragmentParser.BlockStatContext ctx) {
		System.out.println("exitBlockStat");
	}
	@Override public void exitContStat(@NotNull FragmentParser.ContStatContext ctx) {
		System.out.println("exitContStat");
	}	
	
	@Override public void exitDecl(@NotNull FragmentParser.DeclContext ctx) {
		System.out.println("exitDecl");
	}
	
	@Override public void exitPrintStat(@NotNull FragmentParser.PrintStatContext ctx) {
		System.out.println("exitPrintStat");
	}
	
	@Override public void exitWhileStat(@NotNull FragmentParser.WhileStatContext ctx) {
		System.out.println("exitWhileStat");
	}
	
	@Override public void exitIfStat(@NotNull FragmentParser.IfStatContext ctx) {
		System.out.println("exitIfStat");
	}
	
	@Override public void exitBreakStat(@NotNull FragmentParser.BreakStatContext ctx) {
		System.out.println("exitBreakStat");
	}
	
	@Override public void exitAssignStat(@NotNull FragmentParser.AssignStatContext ctx) {
		System.out.println("exitAssignStat");
	}
}
