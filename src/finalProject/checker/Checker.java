package finalProject.checker;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import finalProject.grammar.EloquenceBaseListener;
import finalProject.grammar.EloquenceParser;
/** Class to type check and calculate flow entries and variable offsets. */
public class Checker extends EloquenceBaseListener {
	/** Result of the latest call of {@link #check}. */
	private Result result;
	/** Variable scope for the latest call of {@link #check}. */
	private Scope scope;
	/** List of errors collected in the latest call of {@link #check}. */
	private List<String> errors;

	/** Runs this checker on a given parse tree,
	 * and returns the checker result.
	 * @throws ParseException if an error was found during checking.
	 */
	public Result check(ParseTree tree) throws ParseException {
		this.scope = new Scope();
		this.result = new Result();
		this.errors = new ArrayList<>();
		new ParseTreeWalker().walk(this, tree);
		if (hasErrors()) {
			throw new ParseException(getErrors());
		}
		return this.result;
	}
	
	
	
	
	
	@Override public void exitProgram(EloquenceParser.ProgramContext ctx) { }
	
	@Override public void exitBody(EloquenceParser.BodyContext ctx) { }
	
	@Override public void exitDeclVar(EloquenceParser.DeclVarContext ctx) { }
	
	@Override public void exitDeclConstVar(EloquenceParser.DeclConstVarContext ctx) { }
	
	@Override public void exitDeclArray(EloquenceParser.DeclArrayContext ctx) { }
	
	@Override public void exitDeclConstArray(EloquenceParser.DeclConstArrayContext ctx) { }
	
	@Override public void exitVariable(EloquenceParser.VariableContext ctx) { }
	
	@Override public void exitArrayDecl(EloquenceParser.ArrayDeclContext ctx) { }
	
	@Override public void exitStatReturn(EloquenceParser.StatReturnContext ctx) { }
	
	@Override public void exitStatIf(EloquenceParser.StatIfContext ctx) { }
	
	@Override public void exitStatWhile(EloquenceParser.StatWhileContext ctx) { }
	
	@Override public void exitStatAssign(EloquenceParser.StatAssignContext ctx) { }
	
	@Override public void exitStatAssignArray(EloquenceParser.StatAssignArrayContext ctx) { }
	
	@Override public void exitStatBlock(EloquenceParser.StatBlockContext ctx) { }
	
	@Override public void exitReturnStat(EloquenceParser.ReturnStatContext ctx) { }
	
	@Override public void exitExprComp(EloquenceParser.ExprCompContext ctx) { }
	
	@Override public void exitExprMult(EloquenceParser.ExprMultContext ctx) { }
	
	@Override public void exitExprUnary(EloquenceParser.ExprUnaryContext ctx) { }
	
	@Override public void exitExprNum(EloquenceParser.ExprNumContext ctx) { }
	
	@Override public void exitExprTrue(EloquenceParser.ExprTrueContext ctx) { }
	
	@Override public void exitExprChar(EloquenceParser.ExprCharContext ctx) { }
	
	@Override public void exitExprFunc(EloquenceParser.ExprFuncContext ctx) { }
	
	@Override public void exitExprOr(EloquenceParser.ExprOrContext ctx) { }
	
	@Override public void exitExprAdd(EloquenceParser.ExprAddContext ctx) { }
	
	@Override public void exitExprAnd(EloquenceParser.ExprAndContext ctx) { }
	
	@Override public void exitExprId(EloquenceParser.ExprIdContext ctx) { }
	
	@Override public void exitExprFalse(EloquenceParser.ExprFalseContext ctx) { }
	
	@Override public void exitExprArray(EloquenceParser.ExprArrayContext ctx) { }
	
	@Override public void exitTypeInt(EloquenceParser.TypeIntContext ctx) {
		setType(ctx, Type.INT);
	}
	
	@Override public void exitTypeBool(EloquenceParser.TypeBoolContext ctx) {
		setType(ctx, Type.BOOL);		
	}
	
	@Override public void exitTypeChar(EloquenceParser.TypeCharContext ctx) { }
	
	@Override public void exitFuncVoid(EloquenceParser.FuncVoidContext ctx) { }
	
	@Override public void exitFuncReturn(EloquenceParser.FuncReturnContext ctx) { }
	
	@Override public void exitFunctionID(EloquenceParser.FunctionIDContext ctx) { }
	
	@Override public void exitVoidFunc(EloquenceParser.VoidFuncContext ctx) { }
	
	@Override public void exitReturnFunc(EloquenceParser.ReturnFuncContext ctx) { }

	
	
	
	
	
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	
	@Override public void visitTerminal(TerminalNode node) { }
	
	@Override public void visitErrorNode(ErrorNode node) { }
	
	
	
	
	
	
	
	
	
	
	
	

	/** Indicates if any errors were encountered in this tree listener. */
	public boolean hasErrors() {
		return !getErrors().isEmpty();
	}

	/** Returns the list of errors collected in this tree listener. */
	public List<String> getErrors() {
		return this.errors;
	}

	/** Checks the inferred type of a given parse tree,
	 * and adds an error if it does not correspond to the expected type.
	 */
	private void checkType(ParserRuleContext node, Type expected) {
		Type actual = getType(node);
		if (actual == null) {
			throw new IllegalArgumentException("Missing inferred type of "
					+ node.getText());
		}
		if (!actual.equals(expected)) {
			addError(node, "Expected type '%s' but found '%s'", expected,
					actual);
		}
	}

	/** Records an error at a given parse tree node.
	 * @param ctx the parse tree node at which the error occurred
	 * @param message the error message
	 * @param args arguments for the message, see {@link String#format}
	 */
	private void addError(ParserRuleContext node, String message,
			Object... args) {
		addError(node.getStart(), message, args);
	}

	/** Records an error at a given token.
	 * @param token the token at which the error occurred
	 * @param message the error message
	 * @param args arguments for the message, see {@link String#format}
	 */
	private void addError(Token token, String message, Object... args) {
		int line = token.getLine();
		int column = token.getCharPositionInLine();
		message = String.format(message, args);
		message = String.format("Line %d:%d - %s", line, column, message);
		this.errors.add(message);
	}

	/** Convenience method to add an offset to the result. */
	private void setOffset(ParseTree node, Integer offset) {
		this.result.setOffset(node, offset);
	}

	/** Convenience method to add a type to the result. */
	private void setType(ParseTree node, Type type) {
		this.result.setType(node, type);
	}

	/** Returns the type of a given expression or type node. */
	private Type getType(ParseTree node) {
		return this.result.getType(node);
	}

	/** Convenience method to add a flow graph entry to the result. */
	private void setEntry(ParseTree node, ParserRuleContext entry) {
		if (entry == null) {
			throw new IllegalArgumentException("Null flow graph entry");
		}
		this.result.setEntry(node, entry);
	}

	/** Returns the flow graph entry of a given expression or statement. */
	private ParserRuleContext entry(ParseTree node) {
		return this.result.getEntry(node);
	}
}
