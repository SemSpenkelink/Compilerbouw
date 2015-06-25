package finalProject.checker;

import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.ir.SetSplitState;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import finalProject.grammar.EloquenceBaseListener;
import finalProject.grammar.EloquenceParser;
import finalProject.grammar.EloquenceParser.ArrayExpressionContext;
import finalProject.grammar.EloquenceParser.ExpressionContext;
import finalProject.grammar.EloquenceParser.NewIDContext;
/** Class to type check and calculate flow entries and variable offsets. */
public class Checker extends EloquenceBaseListener {
	/** Result of the latest call of {@link #check}. */
	private Result result;
	/** Variable scope for the latest call of {@link #check}. */
	private Scope scope;
	/** SymbolTable for detecting if a variable is reachable {@link #check}.*/
	private SymbolTable symbolTable;
	/** List of errors collected in the latest call of {@link #check}. */
	private List<String> errors;

	/** Runs this checker on a given parse tree,
	 * and returns the checker result.
	 * @throws ParseException if an error was found during checking.
	 */
	public Result check(ParseTree tree) throws ParseException {
		this.scope = new Scope();
		this.symbolTable = new SymbolTable();
		this.result = new Result();
		this.errors = new ArrayList<>();
		new ParseTreeWalker().walk(this, tree);
		if (hasErrors()) {
			throw new ParseException(getErrors());
		}
		return this.result;
	}
	
	
	@Override public void exitBody(finalProject.grammar.EloquenceParser.BodyContext ctx) {
		setType(ctx, getType(ctx.getChild(ctx.getChildCount()-1)));
	}
	
	@Override public void exitDeclVar(EloquenceParser.DeclVarContext ctx) {
		if(ctx.expression() != null)
			checkType(ctx.variable(), getType(ctx.expression()));
		setEntry(ctx, entry(ctx.variable()));
	}
	
	@Override public void exitVariable(EloquenceParser.VariableContext ctx){
		for(NewIDContext id : ctx.newID()){
			setType(id, getType(ctx.type()));
			this.scope.put(id.getText(), getType(ctx.type()));
			setOffset(id, scope.offset(id.getText()));
		}
		setType(ctx, getType(ctx.type()));
		setEntry(ctx, ctx);
	}
	
	@Override public void exitArrayTypeDecl(finalProject.grammar.EloquenceParser.ArrayTypeDeclContext ctx) {
		setType(ctx, new Type.Array(Integer.parseInt(ctx.NUM(0).getText()), Integer.parseInt(ctx.NUM(1).getText()), getType(ctx.type())));
		this.scope.put(ctx.newID().getText(), getType(ctx));
		setOffset(ctx.newID(), scope.offset(ctx.newID().getText()));
		setEntry(ctx, ctx);
	}

	@Override public void exitVarArrayDecl(finalProject.grammar.EloquenceParser.VarArrayDeclContext ctx) {
		for(NewIDContext id : ctx.newID()){
			setType(id, this.scope.type(ctx.target().getText()));
			this.scope.put(id.getText(), getType(id));
			setOffset(id, scope.offset(id.getText()));
		}
		setType(ctx, this.scope.type(ctx.target().getText()));
		setEntry(ctx, ctx);
	}
	
	@Override public void exitConstArrayDecl(finalProject.grammar.EloquenceParser.ConstArrayDeclContext ctx) {
		for(ArrayExpressionContext array : ctx.arrayExpression()){
			checkType(array, ((Type.Array)getType(ctx.target())).getElemType());
		}
		for(NewIDContext id : ctx.newID()){
			setType(id, this.scope.type(ctx.target().getText()));
			this.scope.put(id.getText(), getType(id));
			setOffset(id, scope.offset(id.getText()));
		}
		setType(ctx, this.scope.type(ctx.target().getText()));
		setEntry(ctx, ctx);
	}
	
	@Override public void exitDeclConstVar(EloquenceParser.DeclConstVarContext ctx) {
		setEntry(ctx, entry(ctx.variable()));
	}
	
	@Override public void exitDeclArray(EloquenceParser.DeclArrayContext ctx) {
		setType(ctx, getType(ctx.arrayDecl()));
	}
	
	@Override public void exitStatReturn(EloquenceParser.StatReturnContext ctx) {
		setType(ctx, getType(ctx.returnStat()));
		if(getType(ctx.returnStat()) != null)
			setEntry(ctx, ctx.returnStat());
	}
	
	@Override public void enterStatIf(finalProject.grammar.EloquenceParser.StatIfContext ctx) {
		symbolTable.openScope();
	}
	
	@Override public void exitStatIf(EloquenceParser.StatIfContext ctx) {
		checkType(ctx.expression(), Type.BOOL);
		if(ctx.ELSE() != null && getType(ctx.stat(0)).equals(getType(ctx.stat(1))))
			setType(ctx, getType(ctx.stat(0)));
		else
			setType(ctx, null);
		symbolTable.closeScope();
	}
	
	@Override public void enterStatWhile(finalProject.grammar.EloquenceParser.StatWhileContext ctx) {
		symbolTable.openScope();
	}
	
	@Override public void exitStatWhile(EloquenceParser.StatWhileContext ctx) {
		checkType(ctx.expression(), Type.BOOL);
		setType(ctx, null);
		symbolTable.closeScope();
	}
	
	@Override public void exitStatAssign(EloquenceParser.StatAssignContext ctx) {
		checkType(ctx.target(), getType(ctx.expression()));
		setType(ctx, this.scope.type(ctx.target().getText()));
		//setEntry(ctx, entry(ctx.expression()));
		setOffset(ctx, scope.offset(ctx.target().getText()));
	}
	
	@Override public void exitStatAssignArray(EloquenceParser.StatAssignArrayContext ctx) {
		for(ExpressionContext expr : ctx.expression()){
			if(expr.equals(ctx.getChild(ctx.getChildCount()-2)))
				continue;
			checkType(expr, Type.INT);
		}
		checkType(ctx.expression(ctx.expression().size()-1), ((Type.Array)getType(ctx.target())).getElemType());
		setType(ctx, getType(ctx.target()));
		setEntry(ctx, entry(ctx.target()));
	}
	
	@Override public void exitStatAssignArrayMult(finalProject.grammar.EloquenceParser.StatAssignArrayMultContext ctx) {
		for(ArrayExpressionContext array : ctx.arrayExpression()){
			checkType(array, ((Type.Array)getType(ctx.target())).getElemType());
		}
		setType(ctx, getType(ctx.target()));
		setEntry(ctx, entry(ctx.target()));
	}
	
	@Override public void exitStatBlock(EloquenceParser.StatBlockContext ctx) {
		setType(ctx, getType(ctx.statBlockBody()));
		//setEntry(ctx, entry(ctx.body().stat(0)));
	}
	
	@Override public void exitStatIn(EloquenceParser.StatInContext ctx){
		if(ctx.target().size() == 1){
			setType(ctx, this.scope.type(ctx.target(0).getText()));
			setEntry(ctx, entry(ctx.target(0)));
		}else{
			setType(ctx, null);
		}
	}
	
	@Override public void exitStatOut(EloquenceParser.StatOutContext ctx){
		for(ExpressionContext expr : ctx.expression())
			checkNotNull(expr);
		if(ctx.expression().size() == 1){
			setType(ctx, this.scope.type(ctx.expression(0).getText()));
			setEntry(ctx, entry(ctx.expression(0)));	
		}else
			setType(ctx, null);
	}
	
	@Override public void enterStatBlockBody(finalProject.grammar.EloquenceParser.StatBlockBodyContext ctx) {
		symbolTable.openScope();
	}
	
	@Override public void exitStatBlockBody(finalProject.grammar.EloquenceParser.StatBlockBodyContext ctx) {
		setType(ctx, getType(ctx.body()));
		symbolTable.closeScope();
	}
	
	@Override public void exitReturnStat(EloquenceParser.ReturnStatContext ctx) {
		if(ctx.expression() != null){
			setType(ctx, getType(ctx.expression()));
			setEntry(ctx, ctx.expression());
		}else
			setType(ctx, null);
	}
	
	@Override public void exitTargetId(finalProject.grammar.EloquenceParser.TargetIdContext ctx) {
		checkScope(ctx);
		if(scope.contains(ctx.getText())){
			setOffset(ctx, this.scope.offset(ctx.getText()));
			setOffset(ctx.getChild(0), this.scope.offset(ctx.getText()));
			setEntry(ctx, ctx);
			setEntry(ctx.getChild(0), ctx);
		}	
		setType(ctx, this.scope.type(ctx.ID().getText()));
	}
	
	@Override public void exitNewID(NewIDContext ctx) {
		addSymbol(ctx);
	}
	
	@Override public void exitExprComp(EloquenceParser.ExprCompContext ctx) {
		if(ctx.compare().LT() != null || ctx.compare().LE() != null || ctx.compare().GE() != null || ctx.compare().GT() != null){
			checkType(ctx.expression(0), Type.INT);
			checkType(ctx.expression(1), Type.INT);
		}else{
			checkType(ctx.expression(0), getType(ctx.expression(1)));
		}		
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
		setType(ctx, Type.CHAR);
		setEntry(ctx, ctx);
	}
	
	@Override public void exitExprFunc(EloquenceParser.ExprFuncContext ctx) {
		setType(ctx, getType(ctx.functionID()));
		setEntry(ctx, entry(ctx.functionID()));
	}
	
	@Override public void exitExprCompound(finalProject.grammar.EloquenceParser.ExprCompoundContext ctx) {
		setType(ctx, getType(ctx.expression()));
		setEntry(ctx, entry(ctx.expression()));
	}
	
	@Override public void exitExprOr(EloquenceParser.ExprOrContext ctx) {
		checkType(ctx.expression(0), Type.BOOL);
		checkType(ctx.expression(1), Type.BOOL);
		setType(ctx, Type.BOOL);
		setEntry(ctx, entry(ctx.expression(0)));
	}
	
	@Override public void exitExprArray(finalProject.grammar.EloquenceParser.ExprArrayContext ctx) {
		for(ExpressionContext expr : ctx.expression()){
			checkType(expr, Type.INT);
		}
		setType(ctx, ((Type.Array)getType(ctx.target())).getElemType());
		setEntry(ctx, ctx);
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
		String id = ctx.target().getText();
		Type type = this.scope.type(id);
		if (type == null) {
			addError(ctx, "Variable '%s' not declared", id);
		} else {
			setType(ctx, type);
			setOffset(ctx, this.scope.offset(id));
			setOffset(ctx.target(), this.scope.offset(id));
			setEntry(ctx, ctx);
		}
	}
	
	@Override public void exitExprFalse(EloquenceParser.ExprFalseContext ctx) {
		setType(ctx, Type.BOOL);
		setEntry(ctx, ctx);
	}
	
	@Override public void exitExprPar(finalProject.grammar.EloquenceParser.ExprParContext ctx) {
		setType(ctx, getType(ctx.expression()));
		setEntry(ctx, entry(ctx.expression()));
	}
	
	@Override public void exitArrayMulExpr(finalProject.grammar.EloquenceParser.ArrayMulExprContext ctx) {
		Type type = getType(ctx.expression(0));
		for(ExpressionContext expr : ctx.expression()){
			if(expr.equals(ctx.expression(0)))
				continue;
			checkType(expr, type);
		}
		setType(ctx, type);
		setEntry(ctx, ctx);
	}
	
	@Override public void exitArraySingleExpr(finalProject.grammar.EloquenceParser.ArraySingleExprContext ctx) {
		setType(ctx, getType(ctx.expression()));
	}
	
	@Override public void exitTypeInt(EloquenceParser.TypeIntContext ctx) {
		setType(ctx, Type.INT);
	}
	
	@Override public void exitTypeBool(EloquenceParser.TypeBoolContext ctx) {
		setType(ctx, Type.BOOL);		
	}
	
	@Override public void exitTypeChar(EloquenceParser.TypeCharContext ctx) {
		setType(ctx, Type.CHAR);
	}
	
	@Override public void exitFuncVoid(EloquenceParser.FuncVoidContext ctx) {
		setType(ctx, null);
	}

	@Override public void exitFuncReturn(EloquenceParser.FuncReturnContext ctx) {
		setType(ctx, getType(ctx.returnFunc()));
		setEntry(ctx, entry(ctx.returnFunc()));
	}

	//TODO maybe set entry?
	@Override public void exitFunctionID(EloquenceParser.FunctionIDContext ctx) {
		setType(ctx, this.scope.type(ctx.ID().getText()));
	}
	
	@Override public void enterVoidFunc(finalProject.grammar.EloquenceParser.VoidFuncContext ctx) {
		symbolTable.openScope();
	}
	
	//TODO
	@Override public void exitVoidFunc(EloquenceParser.VoidFuncContext ctx) {
		setType(ctx, null);
		symbolTable.closeScope();
	}

	@Override public void enterReturnFunc(finalProject.grammar.EloquenceParser.ReturnFuncContext ctx) {
		symbolTable.openScope();
	}
	
	//TODO
	@Override public void exitReturnFunc(EloquenceParser.ReturnFuncContext ctx) {
		setType(ctx, getType(ctx.type()));
		setEntry(ctx, entry(ctx.returnStat()));
		symbolTable.closeScope();
	}
	
	@Override public void exitParameters(finalProject.grammar.EloquenceParser.ParametersContext ctx) {
		this.scope.put(ctx.newID().getText(), getType(ctx.type()));
		setOffset(ctx.newID(), scope.offset(ctx.newID().getText()));
	}
	
	
	
	
	
	
	
	
	
	
	
	

	/** Indicates if any errors were encountered in this tree listener. */
	public boolean hasErrors() {
		return !getErrors().isEmpty();
	}

	/** Returns the list of errors collected in this tree listener. */
	public List<String> getErrors() {
		return this.errors;
	}

	private void checkScope(ParserRuleContext node){
		if(!symbolTable.contains(node.getText()))
			addError(node, "'%s' not defined in scope", node.getText());
	}
	
	private void addSymbol(ParserRuleContext node){
		if(!symbolTable.add(node.getText()))
			addError(node, "'%s' already defined within the scope", node.getText());
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
	
	/** Checks if node is not of type null.
	 * @param node;
	 */
	private void checkNotNull(ParserRuleContext node){
		Type actual = getType(node);
		if(actual.equals(null))
			addError(node, "Expected type not null but found '%s'", actual);
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
