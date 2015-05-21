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
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import pp.block4.cc.ErrorListener;
import pp.block4.cc.cfg.FragmentParser.ProgramContext;

/** Template top-down CFG builder. */
public class TopDownCFGBuilder extends FragmentBaseListener {
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
			ProgramContext tree = parser.program();
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
	public Graph build(ProgramContext tree) {
		this.graph = new Graph();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(this,tree);
		return this.graph;
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
		TopDownCFGBuilder builder = new TopDownCFGBuilder();
		for (String filename : args) {
			File file = new File(filename);
			System.out.println(filename);
			System.out.println(builder.build(file));
		}
	}
	
/*	public void awesomeMethod(ParserRuleContext ctx){
		/**
		entry.put(ctx, addNode(ctx, ctx.getText()));
		exit.put(ctx, addNode(ctx, ctx.getText()));
		
		entry.put(ctx, addNode(ctx, ""));
		exit.put(ctx, addNode(ctx, ""));
		
		if(ctx.getParent() != null){
			entry.get(ctx.getParent()).addEdge(entry.get(ctx));
			exit.get(ctx).addEdge(exit.get(ctx.getParent()));
		}
		
	}

*/
	
	@Override public void enterBlockStat(@NotNull FragmentParser.BlockStatContext ctx) { System.out.println("Enter Bock stat");
	}

	@Override public void enterContStat(@NotNull FragmentParser.ContStatContext ctx) {System.out.println("Enter ContStat"); }
	
	@Override public void enterDecl(@NotNull FragmentParser.DeclContext ctx) {System.out.println("Enter Decl"); }

	@Override public void enterPrintStat(@NotNull FragmentParser.PrintStatContext ctx) {System.out.println("Enter PrintStat"); }
	
	@Override public void enterWhileStat(@NotNull FragmentParser.WhileStatContext ctx) { System.out.println("Enter Whilestat");}

	@Override public void enterIfStat(@NotNull FragmentParser.IfStatContext ctx) { System.out.println("Enter IfStat");}
	
	@Override public void enterBreakStat(@NotNull FragmentParser.BreakStatContext ctx) {System.out.println("Enter BreakStat");}

	@Override public void enterAssignStat(@NotNull FragmentParser.AssignStatContext ctx) { System.out.println("Enter AssignStat");}
	
}
