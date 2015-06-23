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
	
	
	
	@Override public void exitDeclVar(EloquenceParser.DeclVarContext ctx) {
		setEntry(ctx, entry(ctx.variable()));
	}
	
	@Override public void exitVariable(EloquenceParser.VariableContext ctx){
		for(TerminalNode id : ctx.ID()){
			setType(id, getType(ctx.type()));
			this.scope.put(id.getText(), getType(ctx.type()));
			setOffset(id, scope.offset(id.getText()));
		}
		setType(ctx, getType(ctx.type()));
		setEntry(ctx, ctx);
	}
	
	//TODO
	@Override public void exitDeclConstVar(EloquenceParser.DeclConstVarContext ctx) { }
	
	//TODO
	@Override public void exitDeclArray(EloquenceParser.DeclArrayContext ctx) { }
	
	//TODO
	@Override public void exitDeclConstArray(EloquenceParser.DeclConstArrayContext ctx) { }
	
	//TODO
	@Override public void exitArrayDecl(EloquenceParser.ArrayDeclContext ctx) { }
	
	//TODO
	@Override public void exitStatReturn(EloquenceParser.StatReturnContext ctx) { }
	
	@Override public void exitStatIf(EloquenceParser.StatIfContext ctx) {
		checkType(ctx.expression(), Type.BOOL);
		setEntry(ctx, entry(ctx.stat(0)));
	}
	
	@Override public void exitStatWhile(EloquenceParser.StatWhileContext ctx) {
		checkType(ctx.expression(), Type.BOOL);
		setEntry(ctx, entry(ctx.stat()));
	}
	
	@Override public void exitStatAssign(EloquenceParser.StatAssignContext ctx) {
		setType(ctx.target(), this.scope.type(ctx.target().getText()));
		checkType(ctx.target(), getType(ctx.expression()));
		setEntry(ctx, entry(ctx.expression()));
		setOffset(ctx.target(), scope.offset(ctx.target().getText()));
	}
	
	//TODO
	@Override public void exitStatAssignArray(EloquenceParser.StatAssignArrayContext ctx) { }
	
	@Override public void exitStatBlock(EloquenceParser.StatBlockContext ctx) {
		setEntry(ctx, entry(ctx.body().stat(0)));
	}
	
	//TODO
	@Override public void exitReturnStat(EloquenceParser.ReturnStatContext ctx) { }
	
	@Override public void exitExprComp(EloquenceParser.ExprCompContext ctx) {
		checkType(ctx.expression(0), Type.INT);
		checkType(ctx.expression(1), Type.INT);
		setType(ctx, Type.BOOL);
		setEntry(ctx, entry(ctx.expression(0)));
	}
	
	@Override public void exitExprMult(EloquenceParser.ExprMultContext ctx) {
		checkType(ctx.expression(0), Type.INT);
		checkType(ctx.expression(1), Type.INT);
		setType(ctx, Type.INT);
		setEntry(ctx, entry(ctx.expression(0)));
	}
	
	@Override public void exitExprUnary(EloquenceParser.ExprUnaryContext ctx) {
		Type type;
		if (ctx.unary().MINUS() != null || ctx.unary().PLUS() != null) {
			type = Type.INT;
		} else {
			assert ctx.unary().NOT() != null;
			type = Type.BOOL;
		}
		checkType(ctx.expression(), type);
		setType(ctx, type);
		setEntry(ctx, entry(ctx.expression()));
	}
	
	@Override public void exitExprNum(EloquenceParser.ExprNumContext ctx) {
		setType(ctx, Type.INT);
		setEntry(ctx, ctx);
	}
	
	@Override public void exitExprTrue(EloquenceParser.ExprTrueContext ctx) {
		setType(ctx, Type.BOOL);
		setEntry(ctx, ctx);
	}
	
	@Override public void exitExprChar(EloquenceParser.ExprCharContext ctx) {
		String id = ctx.CHAR().getText();
		Type type = this.scope.type(id);
		if (type == null) {
			addError(ctx, "Variable '%s' not declared", id);
		} else {
			setType(ctx, type);
			setOffset(ctx, this.scope.offset(id));
			setOffset(ctx.CHAR(), this.scope.offset(id));
			setEntry(ctx, ctx);
		}
	}
	
	//TODO
	@Override public void exitExprFunc(EloquenceParser.ExprFuncContext ctx) { }
	
	@Override public void exitExprOr(EloquenceParser.ExprOrContext ctx) {
		checkType(ctx.expression(0), Type.BOOL);
		checkType(ctx.expression(1), Type.BOOL);
		setType(ctx, Type.BOOL);
		setEntry(ctx, entry(ctx.expression(0)));
	}
	
	@Override public void exitExprAdd(EloquenceParser.ExprAddContext ctx) {
		checkType(ctx.expression(0), Type.INT);
		checkType(ctx.expression(1), Type.INT);
		setType(ctx, Type.INT);
		setEntry(ctx, entry(ctx.expression(0)));
	}
	
	@Override public void exitExprAnd(EloquenceParser.ExprAndContext ctx) {
		checkType(ctx.expression(0), Type.BOOL);
		checkType(ctx.expression(1), Type.BOOL);
		setType(ctx, Type.BOOL);
		setEntry(ctx, entry(ctx.expression(0)));
	}
	
	@Override public void exitExprId(EloquenceParser.ExprIdContext ctx) {
		String id = ctx.ID().getText();
		Type type = this.scope.type(id);
		if (type == null) {
			addError(ctx, "Variable '%s' not declared", id);
		} else {
			setType(ctx, type);
			setOffset(ctx, this.scope.offset(id));
			setOffset(ctx.ID(), this.scope.offset(id));
			setEntry(ctx, ctx);
		}
	}
	
	@Override public void exitExprFalse(EloquenceParser.ExprFalseContext ctx) {
		setType(ctx, Type.BOOL);
		setEntry(ctx, ctx);
	}
	
	//TODO
	@Override public void exitExprArray(EloquenceParser.ExprArrayContext ctx) { }
	
	@Override public void exitTypeInt(EloquenceParser.TypeIntContext ctx) {
		setType(ctx, Type.INT);
	}
	
	@Override public void exitTypeBool(EloquenceParser.TypeBoolContext ctx) {
		setType(ctx, Type.BOOL);		
	}
	
	@Override public void exitTypeChar(EloquenceParser.TypeCharContext ctx) {
		setType(ctx, Type.CHAR);
	}
	
	//TODO
	@Override public void exitFuncVoid(EloquenceParser.FuncVoidContext ctx) { }

	//TODO
	@Override public void exitFuncReturn(EloquenceParser.FuncReturnContext ctx) { }

	//TODO
	@Override public void exitFunctionID(EloquenceParser.FunctionIDContext ctx) { }

	//TODO
	@Override public void exitVoidFunc(EloquenceParser.VoidFuncContext ctx) { }

	//TODO
	@Override public void exitReturnFunc(EloquenceParser.ReturnFuncContext ctx) { }
	
	
	
	
	
	
	
	
	
	
	
	

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
