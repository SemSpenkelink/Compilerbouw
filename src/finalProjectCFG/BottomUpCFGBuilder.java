package finalProjectCFG;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import finalProject.checker.ErrorListener;
import finalProject.grammar.EloquenceBaseListener;
import finalProject.grammar.EloquenceLexer;
import finalProject.grammar.EloquenceParser;

/** Template bottom-up CFG builder. */
public class BottomUpCFGBuilder extends EloquenceBaseListener {
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
			Lexer lexer = new EloquenceLexer(chars);
			lexer.removeErrorListeners();
			lexer.addErrorListener(listener);
			TokenStream tokens = new CommonTokenStream(lexer);
			EloquenceParser parser = new EloquenceParser(tokens);
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
	

	//TODO on assigning a value, enter the expression because a function can be called.
	//TODO go from a function call to the declaration of that function. (And especially going back!)
	 
	 
	 
	/**
	 * Create initial node and last node of program.
	 * Connect the initial node to entry of body.
	 * Connect the exit of body to the last node.
	 * @param ctx
	 */
	@Override public void exitProgram(EloquenceParser.ProgramContext ctx) {
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.body()));
		exit.get(ctx.body()).addEdge(exit.get(ctx));
	}
	
	/**
	 * Create entry and exit node of body.
	 * If body has children, connect entry to
	 * entry node of first child and exit node
	 * of last child to own exit node. Connect the
	 * exit node of all children to the entry node
	 * of the next child, the last child is connected
	 * to the exit node of body. If body does not have
	 * children, connect the entry node to the exit node.
	 * @param ctx
	 */
	@Override public void exitBody(EloquenceParser.BodyContext ctx) {
		constructNodes(ctx);
		List<ParserContext> 
		
		
		
		constructNodes(ctx);
		if(ctx.getChildCount() >= 1){
			entry.get(ctx).addEdge(entry.get(ctx.getChild(0)));
			exit.get(ctx.getChild(ctx.getChildCount()-1)).addEdge(exit.get(ctx));
		}else
			entry.get(ctx).addEdge(exit.get(ctx));
		for(int index = 1; index < ctx.getChildCount()-1; index++){
			exit.get(ctx.getChild(index-1)).addEdge(entry.get(ctx.getChild(index)));
		}
	}

	/**
	 * Create entry and exit node of variable declaration.
	 * Connect own entry node to own exit node.
	 * @param ctx
	 */
	@Override public void exitDeclVar(EloquenceParser.DeclVarContext ctx) {
		constructNodes(ctx);
		entry.get(ctx).addEdge(exit.get(ctx));
	}

	/**
	 * Create entry and exit node of constant declaration.
	 * Connect own entry node to own exit node.
	 * @param ctx
	 */
	@Override public void exitDeclConstVar(EloquenceParser.DeclConstVarContext ctx) { 
		constructNodes(ctx);
		entry.get(ctx).addEdge(exit.get(ctx));
		
	}
	
	/**
	 * Create entry and exit node of array declaration.
	 * Connect own entry node to own exit node.
	 * @param ctx
	 */
	@Override public void exitDeclArray(EloquenceParser.DeclArrayContext ctx) { 
		constructNodes(ctx);
		entry.get(ctx).addEdge(exit.get(ctx));
	}
	
	/**
	 * Create entry and exit node of array type declaration.
	 * Connect own entry node to own exit node.
	 * @param ctx
	 */
	@Override public void exitArrayTypeDecl(EloquenceParser.ArrayTypeDeclContext ctx) { 
		constructNodes(ctx);
		entry.get(ctx).addEdge(exit.get(ctx));
	}

	/**
	 * Create entry and exit node of if statement.
	 * Connect own entry node to entry node of if statement.
	 * Connect exit node of if statement to own exit node.
	 * When the if statement contains an else statement,
	 * connect own entry node to entry node of else statement.
	 * Connect exit node of else statement to own exit node.
	 * @param ctx
	 */
	@Override public void exitStatIf(EloquenceParser.StatIfContext ctx) {
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.stat(0)));
		exit.get(ctx.stat(0)).addEdge(exit.get(ctx));
		if(ctx.stat().size() > 1){
			entry.get(ctx).addEdge(entry.get(ctx.stat(1)));
			exit.get(ctx.stat(1)).addEdge(exit.get(ctx));			
		}
	}

	/**
	 * Create entry and exit node of while statement.
	 * Connect own entry node to own exit node.
	 * Connect own entry node to entry node of statement.
	 * Connect exit node of statement to own exit node.
	 * @param ctx
	 */
	@Override public void exitStatWhile(EloquenceParser.StatWhileContext ctx) {
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.stat()));
		entry.get(ctx).addEdge(exit.get(ctx));
		exit.get(ctx.stat()).addEdge(exit.get(ctx));
	}

	@Override public void exitStatAssign(EloquenceParser.StatAssignContext ctx) {
		constructNodes(ctx);
		entry.get(ctx).addEdge(exit.get(ctx));
	}

	@Override public void exitStatAssignArray(EloquenceParser.StatAssignArrayContext ctx) {
		constructNodes(ctx);
		entry.get(ctx).addEdge(exit.get(ctx));
	}

	@Override public void exitStatAssignArrayMult(EloquenceParser.StatAssignArrayMultContext ctx) { }

	@Override public void exitStatBlock(EloquenceParser.StatBlockContext ctx) { }

	@Override public void exitStatReturn(EloquenceParser.StatReturnContext ctx) { }
	
	@Override public void exitStatIn(EloquenceParser.StatInContext ctx) { }

	@Override public void exitStatOut(EloquenceParser.StatOutContext ctx) { }
	
	@Override public void exitStatVoid(finalProject.grammar.EloquenceParser.StatVoidContext ctx) { }

	@Override public void exitStatBlockBody(EloquenceParser.StatBlockBodyContext ctx) { }
	
	@Override public void exitTargetId(EloquenceParser.TargetIdContext ctx) { }

	@Override public void exitNewID(EloquenceParser.NewIDContext ctx) { }

	@Override public void exitReturnStat(EloquenceParser.ReturnStatContext ctx) { }

	@Override public void exitExprComp(EloquenceParser.ExprCompContext ctx) { }

	@Override public void exitExprCompound(EloquenceParser.ExprCompoundContext ctx) { }

	@Override public void exitExprMult(EloquenceParser.ExprMultContext ctx) { }

	@Override public void exitExprUnary(EloquenceParser.ExprUnaryContext ctx) { }

	@Override public void exitExprNum(EloquenceParser.ExprNumContext ctx) { }

	@Override public void exitExprTrue(EloquenceParser.ExprTrueContext ctx) { }
	
	@Override public void exitExprChar(EloquenceParser.ExprCharContext ctx) { }

	@Override public void exitExprFunc(EloquenceParser.ExprFuncContext ctx) { }
	
	@Override public void exitExprOr(EloquenceParser.ExprOrContext ctx) { }

	@Override public void exitExprPar(EloquenceParser.ExprParContext ctx) { }

	@Override public void exitExprAdd(EloquenceParser.ExprAddContext ctx) { }

	@Override public void exitExprAnd(EloquenceParser.ExprAndContext ctx) { }
	
	@Override public void exitExprId(EloquenceParser.ExprIdContext ctx) { }

	@Override public void exitExprFalse(EloquenceParser.ExprFalseContext ctx) { }
	 
	@Override public void exitExprArray(EloquenceParser.ExprArrayContext ctx) { }

	@Override public void exitArrayMulExpr(EloquenceParser.ArrayMulExprContext ctx) { }

	@Override public void exitArraySingleExpr(EloquenceParser.ArraySingleExprContext ctx) { }

	@Override public void exitUnary(EloquenceParser.UnaryContext ctx) { }
	
	@Override public void exitMultiply(EloquenceParser.MultiplyContext ctx) { }
	 
	@Override public void exitAddition(EloquenceParser.AdditionContext ctx) { }

	@Override public void exitCompare(EloquenceParser.CompareContext ctx) { }

	@Override public void exitAnd(EloquenceParser.AndContext ctx) { }

	@Override public void exitOr(EloquenceParser.OrContext ctx) { }
	
	@Override public void exitTypeInt(EloquenceParser.TypeIntContext ctx) { }

	@Override public void exitTypeBool(EloquenceParser.TypeBoolContext ctx) { }

	@Override public void exitTypeChar(EloquenceParser.TypeCharContext ctx) { }
	
	@Override public void exitFuncVoid(EloquenceParser.FuncVoidContext ctx) { }
	
	@Override public void exitFuncReturn(EloquenceParser.FuncReturnContext ctx) { }
	
	@Override public void exitFunctionID(EloquenceParser.FunctionIDContext ctx) { }
 
	@Override public void exitVoidFunc(EloquenceParser.VoidFuncContext ctx) { }
	
	@Override public void exitReturnFunc(EloquenceParser.ReturnFuncContext ctx) { }
	
	@Override public void exitParameters(EloquenceParser.ParametersContext ctx) { }

	@Override public void visitTerminal(TerminalNode node) { }

	@Override public void visitErrorNode(ErrorNode node) { }
	
	public void constructNodes(ParserRuleContext ctx){
		String enterMessage = "enter[%s]";
		enterMessage = String.format(enterMessage, ctx.getText());
		String exitMessage = "exit[%s]";
		exitMessage = String.format(exitMessage, ctx.getText());
		entry.put(ctx, addNode(ctx, enterMessage));
		exit.put(ctx, addNode(ctx, exitMessage));		
	}
}
