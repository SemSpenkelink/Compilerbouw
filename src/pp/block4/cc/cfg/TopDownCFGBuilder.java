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
	public void simpleAdd(ParserRuleContext node, String text){
		Node myNode = addNode(node, text);
		entry.get(node.getParent()).addEdge(myNode);
		entry.put(node.getParent(), myNode);
		if(node.getParent().getChild(node.getParent().getChildCount()-1).equals(node))
			myNode.addEdge(exit.get(node.getParent()));
	}
	
	public void aLittleBitMoreComplicatedAdd(ParserRuleContext node, String text){
		Node enterNode = addNode(node, "enter" + text);
		Node exitNode = addNode(node, "exit" + text);
		entry.put(node, enterNode);
		exit.put(node, exitNode);	
		entry.get(node.getParent()).addEdge(enterNode);
		entry.put(node.getParent(), exitNode);
		if(node.getParent().getChild(node.getParent().getChildCount()-1).equals(node))
			exitNode.addEdge(exit.get(node.getParent()));	
	}
	
	@Override public void enterProgram(@NotNull FragmentParser.ProgramContext ctx) {
		System.out.println("Enter Program");
		entry.put(ctx, addNode(ctx, "Enter Program"));
		exit.put(ctx, addNode(ctx, "Exit Program"));
	}
	
	@Override public void enterBlockStat(@NotNull FragmentParser.BlockStatContext ctx) {
		aLittleBitMoreComplicatedAdd(ctx, "BlockStat");
	}

	@Override public void enterContStat(@NotNull FragmentParser.ContStatContext ctx) {simpleAdd(ctx, "enterContStat"); }
	
	@Override public void enterDecl(@NotNull FragmentParser.DeclContext ctx) {simpleAdd(ctx, "enterDecl"); }

	@Override public void enterPrintStat(@NotNull FragmentParser.PrintStatContext ctx) {simpleAdd(ctx, "enterPrintStat"); }
	
	@Override public void enterWhileStat(@NotNull FragmentParser.WhileStatContext ctx) {
		Node whileNode = addNode(ctx, "While");
		entry.put(ctx, whileNode);
		exit.put(ctx, whileNode);
		
		entry.get(ctx.getParent()).addEdge(whileNode);
		entry.put(ctx.getParent(), whileNode);
		
		if(ctx.getParent().getChild(ctx.getParent().getChildCount()-1).equals(ctx))
			whileNode.addEdge(exit.get(ctx.getParent()));
	}

	@Override public void enterIfStat(@NotNull FragmentParser.IfStatContext ctx) {
		Node ifEnter= addNode(ctx, "enterIf");
		Node ifExit= addNode(ctx, "exitIf");
		entry.put(ctx, ifEnter);
		exit.put(ctx, ifExit);
		
		entry.get(ctx.getParent()).addEdge(ifEnter);
		entry.put(ctx.getParent(), ifExit);
		
		if(ctx.getParent().getChild(ctx.getParent().getChildCount()-1).equals(ctx))
			ifExit.addEdge(exit.get(ctx.getParent()));
	}
	
	@Override public void enterBreakStat(@NotNull FragmentParser.BreakStatContext ctx) {simpleAdd(ctx, "enterBreakStat");}

	@Override public void enterAssignStat(@NotNull FragmentParser.AssignStatContext ctx) { simpleAdd(ctx, "enterAssignStat");}
	
}
