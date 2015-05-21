package pp.block4.cc.cfg;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

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
	
	private Stack<List<EnterExitGraph>> nodeStack;
	private int counter;
	
	public BottomUpCFGBuilder(){
		nodeStack = new Stack<List<EnterExitGraph>>();
		nodeStack.push(new ArrayList<EnterExitGraph>());
		counter = 0;
	}
	
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
		List<EnterExitGraph> tmpList = nodeStack.pop();
		EnterExitGraph tmpGraph = tmpList.get(0);
		for(int index = 1; index < tmpList.size(); index++){
			tmpGraph.addGraph(tmpList.get(index));
		}
		this.graph = tmpGraph;
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
	
	private void simpleAddNode(ParserRuleContext ctx, String msg){
		EnterExitGraph tmpGraph = new EnterExitGraph();		
		tmpGraph.exitNode = tmpGraph.addEnterNode(counter + ": " + msg);
		counter++;
		nodeStack.peek().add(tmpGraph);
	}
	
	@Override public void enterBlockStat(@NotNull FragmentParser.BlockStatContext ctx) {
		nodeStack.push(new ArrayList<EnterExitGraph>());
	}
	
	@Override public void exitBlockStat(@NotNull FragmentParser.BlockStatContext ctx) {
		if(nodeStack.size() >= 2){
			List<EnterExitGraph> graphs = nodeStack.pop();
			if(!graphs.isEmpty()){
				EnterExitGraph tmpGraph = graphs.get(0);
				for(int index = 1; index < graphs.size(); index++){
					tmpGraph.addGraph(graphs.get(index));
				}
				nodeStack.peek().add(tmpGraph);
			}
		}
	}
	
	@Override public void exitContStat(@NotNull FragmentParser.ContStatContext ctx) {
		simpleAddNode(ctx, "exitContStat");
	}	
	
	@Override public void exitDecl(@NotNull FragmentParser.DeclContext ctx) {
		simpleAddNode(ctx, "exitDecl");
	}
	
	@Override public void exitPrintStat(@NotNull FragmentParser.PrintStatContext ctx) {
		simpleAddNode(ctx, "exitPrintStat");
	}
	
	@Override public void exitWhileStat(@NotNull FragmentParser.WhileStatContext ctx) {
		EnterExitGraph tmpGraph = new EnterExitGraph();		
		tmpGraph.exitNode = tmpGraph.addEnterNode(counter + ": exitWhileStat");
		counter++;
		EnterExitGraph body = nodeStack.peek().get(nodeStack.peek().size()-1);
		tmpGraph.addGraph(body);
		tmpGraph.exitNode.addEdge(tmpGraph.enterNode);
		tmpGraph.exitNode = tmpGraph.enterNode;
		nodeStack.peek().set(nodeStack.peek().size()-1, tmpGraph);
	}
	
	@Override public void exitIfStat(@NotNull FragmentParser.IfStatContext ctx) {
		EnterExitGraph enterTmpGraph = new EnterExitGraph();
		EnterExitGraph exitTmpGraph = new EnterExitGraph();
		enterTmpGraph.exitNode = enterTmpGraph.addEnterNode(counter + ": enterIfStat");
		counter++;
		exitTmpGraph.exitNode = exitTmpGraph.addEnterNode(counter + ": exitIfStat");
		counter++;
		EnterExitGraph ifBody = null;
		EnterExitGraph ElseBody = null;
		if(ctx.ELSE() != null){
			ifBody = nodeStack.peek().get(nodeStack.peek().size()-2);
			ElseBody = nodeStack.peek().get(nodeStack.peek().size()-1);
			nodeStack.peek().remove(ifBody);
			nodeStack.peek().remove(ElseBody);
		}else{
			ifBody = nodeStack.peek().get(nodeStack.peek().size()-1);
			nodeStack.peek().remove(ifBody);
		}
			
		enterTmpGraph = enterTmpGraph.addGraph(ifBody);
		enterTmpGraph.exitNode.addEdge(exitTmpGraph.enterNode);
		
		if(ElseBody != null){			
			enterTmpGraph = enterTmpGraph.addGraph(ElseBody);
			enterTmpGraph.exitNode.addEdge(exitTmpGraph.enterNode);	
		}else{
			enterTmpGraph.enterNode.addEdge(exitTmpGraph.enterNode);
		}	
		nodeStack.peek().add(enterTmpGraph);
	}
	
	@Override public void exitBreakStat(@NotNull FragmentParser.BreakStatContext ctx) {
		simpleAddNode(ctx, "exitBreakStat");
	}
	
	@Override public void exitAssignStat(@NotNull FragmentParser.AssignStatContext ctx) {
		simpleAddNode(ctx, "exitAssignStat");
	}
	
	private class EnterExitGraph extends Graph{
		public Node enterNode;
		public Node exitNode;
		
		public Node addEnterNode(){
			this.enterNode = addNode();
			return this.enterNode;
		}
		
		public Node addEnterNode(String id){
			this.enterNode = addNode(id);
			return this.enterNode;
		}
		
		public Node addExitNode(){
			this.exitNode = addNode();
			return this.exitNode;
		}
		
		public Node addExitNode(String id){
			this.exitNode = addNode(id);
			return this.exitNode;
		}
		
		public EnterExitGraph addGraph(EnterExitGraph graph){
			nodes.addAll(graph.getNodes());
			this.exitNode.addEdge(graph.enterNode);
			this.exitNode = graph.exitNode;
			return this;
		}
	}
}
