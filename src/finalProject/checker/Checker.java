package finalProject.checker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdk.nashorn.internal.ir.SetSplitState;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import finalProject.grammar.EloquenceBaseListener;
import finalProject.grammar.EloquenceParser;
import finalProject.grammar.EloquenceParser.ExpressionContext;
import finalProject.grammar.EloquenceParser.NewIDContext;
import finalProject.grammar.EloquenceParser.StatContext;
import finalProject.grammar.EloquenceParser.TargetContext;
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
	
	/** Control flow graph. */
	private Graph cfg;
	/** Entry node of context. */
	ParseTreeProperty<Node> entry = new ParseTreeProperty<Node>();
	/** Exit node of context. */
	ParseTreeProperty<Node> exit = new ParseTreeProperty<Node>();
	/** Entry node of function */
	Map<String, Node> entryFunc = new HashMap<String, Node>();
	/** Exit node of function. */
	Map<String, Node> exitFunc = new HashMap<String, Node>();

	/** Runs this checker on a given parse tree,
	 * and returns the checker result.
	 * @throws ParseException if an error was found during checking.
	 */
	public Result check(ParseTree tree) throws ParseException {
		this.scope = new Scope();
		this.symbolTable = new SymbolTable();
		this.result = new Result();
		this.errors = new ArrayList<>();
		this.cfg = new Graph();
		new ParseTreeWalker().walk(this, tree);
		if (hasErrors()) {
			throw new ParseException(getErrors());
		}
		System.out.println(cfg);
		return this.result;
	}
	
	/**
	 * This is only used for the construction of the CFG.
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
	 * Set type of body to type of last child, used for compound expressions.
	 * 
	 * CFG creation:
	 * Create entry and exit node of body. All children of body that are not
	 * functions are linked sequentially, or a function declaration should
	 * not execute the function itself. The last child that is not a function
	 * is linked to the exit node of the body.
	 */
	@Override public void exitBody(finalProject.grammar.EloquenceParser.BodyContext ctx) {
		setType(ctx, getType(ctx.getChild(ctx.getChildCount()-1)));
		
		/** CFG creation. */
		constructNodes(ctx);
		List<ParseTree> notFunctionChildren = new ArrayList<ParseTree>();
		for(int index = 0; index < ctx.getChildCount(); index++)
			if(!ctx.func().contains(ctx.getChild(index)))
				notFunctionChildren.add(ctx.getChild(index));
		
		if(notFunctionChildren.size() >= 1){
			entry.get(ctx).addEdge(entry.get(notFunctionChildren.get(0)));
			exit.get(notFunctionChildren.get(notFunctionChildren.size()-1)).addEdge(exit.get(ctx));
		}else
			entry.get(ctx).addEdge(exit.get(ctx));
		for(int index = 1; index < notFunctionChildren.size(); index++){
			exit.get(notFunctionChildren.get(index-1)).addEdge(entry.get(notFunctionChildren.get(index)));
		}
	}
	
	/**
	 * If the declaration contains an expression, it checks whether the expression
	 * has the same type as the variable it is assigned to. The type is set to the
	 * type of variable.
	 * The entry is set to the entry of the variable.
	 * 
	 * CFG creation:
	 * Create entry and exit node of variable declaration. If it contains an
	 * expression the next node is set to that expression, which exits to this exit
	 * node. If it does not contain an expression, the entry node is linked to the
	 * exit node of this variable declaration.
	 */
	@Override public void exitDeclVar(EloquenceParser.DeclVarContext ctx) {
		if(ctx.expression() != null){
			checkType(ctx.expression(), getType(ctx.variable()));
		}
		setType(ctx, getType(ctx.variable()));
		setEntry(ctx, entry(ctx.variable()));
		
		/** CFG creation. */
		constructNodes(ctx);
		if(ctx.expression() != null){
			entry.get(ctx).addEdge(entry.get(ctx.expression()));
			exit.get(ctx.expression()).addEdge(exit.get(ctx));
		}else
			entry.get(ctx).addEdge(exit.get(ctx));
	}
	
	/**
	 * Set the type of all newIDs to that of the declared type.
	 * Put this in the scope, together with its type and whether the variable
	 * is constant or not. The offset is set to that of the scope.
	 * The own type of variable is set to that of the declared type,
	 * the entry is its own node.
	 */
	@Override public void exitVariable(EloquenceParser.VariableContext ctx){
		for(NewIDContext id : ctx.newID()){
			setType(id.ID(), getType(ctx.type()));
			this.scope.put(id.getText(), getType(ctx.type()), ctx.getParent().getChild(0).getText().toLowerCase().equals("highpowered"));
			setOffset(id.ID(), scope.offset(id.getText()));
		}
		setType(ctx, getType(ctx.type()));
		setEntry(ctx, ctx);
	}
	
	/**
	 * 
	 */
	@Override public void exitArrayTypeDecl(finalProject.grammar.EloquenceParser.ArrayTypeDeclContext ctx) {
		setType(ctx, new Type.Array(Integer.parseInt(ctx.arrayElem().NUM(0).getText()), Integer.parseInt(ctx.arrayElem().NUM(1).getText()), getType(ctx.type())));
		this.scope.put(ctx.newID().ID().getText(), getType(ctx), false);
		setOffset(ctx.newID().ID(), scope.offset(ctx.newID().getText()));
		setEntry(ctx, ctx);
		
		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(exit.get(ctx));
	}

	@Override public void exitVarArrayDecl(finalProject.grammar.EloquenceParser.VarArrayDeclContext ctx) {
		for(NewIDContext id : ctx.newID()){
			setType(id.ID(), this.scope.type(ctx.target().getText()));
			this.scope.put(id.getText(), getType(id), true);
			setOffset(id.ID(), scope.offset(id.getText()));
		}
		setType(ctx, this.scope.type(ctx.target().getText()));
		setEntry(ctx, ctx);
		
		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(exit.get(ctx));
	}

	@Override public void exitConstArrayDecl(finalProject.grammar.EloquenceParser.ConstArrayDeclContext ctx) {
		checkType(ctx.arrayExpression(), ((Type.Array)getType(ctx.target())).getElemType());
		for(NewIDContext id : ctx.newID()){
			setType(id, this.scope.type(ctx.target().getText()));
			this.scope.put(id.getText(), getType(id), false);
			setOffset(id, scope.offset(id.getText()));
		}
		setType(ctx, this.scope.type(ctx.target().getText()));
		setEntry(ctx, ctx);

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.arrayExpression()));
		exit.get(ctx.arrayExpression()).addEdge(exit.get(ctx));
	}
	
	@Override public void exitDeclConstVar(EloquenceParser.DeclConstVarContext ctx) {
		setEntry(ctx, entry(ctx.variable()));
		
		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression()));
		exit.get(ctx.expression()).addEdge(exit.get(ctx));	
	}
	
	@Override public void exitDeclArray(EloquenceParser.DeclArrayContext ctx) {
		setType(ctx, getType(ctx.arrayDecl()));
		
		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.arrayDecl()));
		exit.get(ctx.arrayDecl()).addEdge(exit.get(ctx));
	}
	
	@Override public void exitStatReturn(EloquenceParser.StatReturnContext ctx) {
		setType(ctx, getType(ctx.returnStat()));
		if(getType(ctx.returnStat()) != null)
			setEntry(ctx, ctx.returnStat());
		
		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.returnStat()));
		exit.get(ctx.returnStat()).addEdge(exit.get(ctx));	
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
		
		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression()));
		exit.get(ctx.expression()).addEdge(entry.get(ctx.stat(0)));
		exit.get(ctx.stat(0)).addEdge(exit.get(ctx));
		if(ctx.stat().size() > 1){
			exit.get(ctx.expression()).addEdge(entry.get(ctx.stat(1)));
			exit.get(ctx.stat(1)).addEdge(exit.get(ctx));			
		}else{
			entry.get(ctx.expression()).addEdge(exit.get(ctx));
		}
	}
	
	@Override public void enterStatWhile(finalProject.grammar.EloquenceParser.StatWhileContext ctx) {
		symbolTable.openScope();
	}
	
	@Override public void exitStatWhile(EloquenceParser.StatWhileContext ctx) {
		checkType(ctx.expression(), Type.BOOL);
		setType(ctx, null);
		symbolTable.closeScope();

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression()));
		exit.get(ctx.expression()).addEdge(exit.get(ctx));
		exit.get(ctx.expression()).addEdge(entry.get(ctx.stat()));
		exit.get(ctx.stat()).addEdge(exit.get(ctx));
	}
	
	@Override public void exitStatAssign(EloquenceParser.StatAssignContext ctx) {
		if(checkScope(ctx.target())){
			checkType(ctx.target(), getType(ctx.expression()));
			checkMutable(ctx.target());
		}
		setType(ctx, this.scope.type(ctx.target().getText()));
		setOffset(ctx, scope.offset(ctx.target().getText()));
		
		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression()));
		exit.get(ctx.expression()).addEdge(exit.get(ctx));
	}

	@Override public void exitStatAssignArray(EloquenceParser.StatAssignArrayContext ctx) {
		if(checkScope(ctx.target())){
			checkType(ctx.expression(0), Type.INT);
			checkType(ctx.expression(1), ((Type.Array)getType(ctx.target())).getElemType());
			checkMutable(ctx.target());
		}
		setType(ctx, getType(ctx.target()));
		setEntry(ctx, entry(ctx.target()));

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression(0)));
		exit.get(ctx.expression(0)).addEdge(entry.get(ctx.expression(1)));
		exit.get(ctx.expression(1)).addEdge(exit.get(ctx));
	}

	@Override public void exitStatAssignArrayMult(finalProject.grammar.EloquenceParser.StatAssignArrayMultContext ctx) {
		if(checkScope(ctx.target())){
			checkType(ctx.arrayExpression(), ((Type.Array)getType(ctx.target())).getElemType());
			checkMutable(ctx.target());
		}
		setType(ctx, getType(ctx.target()));
		setEntry(ctx, entry(ctx.target()));

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.arrayExpression()));
		exit.get(ctx.arrayExpression()).addEdge(exit.get(ctx));
	}
	
	@Override public void exitStatBlock(EloquenceParser.StatBlockContext ctx) {
		setType(ctx, getType(ctx.statBlockBody()));
		//setEntry(ctx, entry(ctx.body().stat(0)));

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.statBlockBody()));
		exit.get(ctx.statBlockBody()).addEdge(exit.get(ctx));
	}
	
	@Override public void exitStatIn(EloquenceParser.StatInContext ctx){
		for(TargetContext target : ctx.target())
			if(checkScope(target))
				checkMutable(target);
		if(ctx.target().size() == 1){
			setType(ctx, this.scope.type(ctx.target(0).getText()));
			setEntry(ctx, entry(ctx.target(0)));
		}else{
			setType(ctx, null);
		}

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(exit.get(ctx));
	}
	
	@Override public void exitStatOut(EloquenceParser.StatOutContext ctx){
		for(ExpressionContext expr : ctx.expression())
			checkNotNull(expr);
		if(ctx.expression().size() == 1){
			setType(ctx, this.scope.type(ctx.expression(0).getText()));
			setEntry(ctx, entry(ctx.expression(0)));	
		}else
			setType(ctx, null);
		
		/** CFG creation. */
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
	
	@Override public void exitStatVoid(finalProject.grammar.EloquenceParser.StatVoidContext ctx) {
		checkNull(ctx.functionID());
		setType(ctx, null);

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.functionID()));
		exit.get(ctx.functionID()).addEdge(exit.get(ctx));
	}
	
	@Override public void enterStatBlockBody(finalProject.grammar.EloquenceParser.StatBlockBodyContext ctx) {
		symbolTable.openScope();
	}
	
	@Override public void exitStatBlockBody(finalProject.grammar.EloquenceParser.StatBlockBodyContext ctx) {
		setType(ctx, getType(ctx.body()));
		symbolTable.closeScope();

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.body()));
		exit.get(ctx.body()).addEdge(exit.get(ctx));
	}
	
	@Override public void exitReturnStat(EloquenceParser.ReturnStatContext ctx) {
		if(ctx.expression() != null){
			setType(ctx, getType(ctx.expression()));
			setEntry(ctx, ctx.expression());
		}else
			setType(ctx, null);

		/** CFG creation. */
		constructNodes(ctx);
		if(ctx.expression() != null){
			entry.get(ctx).addEdge(entry.get(ctx.expression()));
			exit.get(ctx.expression()).addEdge(exit.get(ctx));
		}else
			entry.get(ctx).addEdge(exit.get(ctx));
	}
	
	@Override public void exitTargetId(finalProject.grammar.EloquenceParser.TargetIdContext ctx) {
		if(checkScope(ctx)){
			setOffset(ctx, this.scope.offset(ctx.getText()));
			setOffset(ctx.getChild(0), this.scope.offset(ctx.getText()));
			setEntry(ctx, ctx);
			setEntry(ctx.getChild(0), ctx);
			setType(ctx, this.scope.type(ctx.ID().getText()));
		}
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
		
		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression(0)));
		exit.get(ctx.expression(0)).addEdge(entry.get(ctx.expression(1)));
		exit.get(ctx.expression(1)).addEdge(exit.get(ctx));
	}
	
	@Override public void exitExprMult(EloquenceParser.ExprMultContext ctx) {
		checkType(ctx.expression(0), Type.INT);
		checkType(ctx.expression(1), Type.INT);
		setType(ctx, Type.INT);
		setEntry(ctx, entry(ctx.expression(0)));

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression(0)));
		exit.get(ctx.expression(0)).addEdge(entry.get(ctx.expression(1)));
		exit.get(ctx.expression(1)).addEdge(exit.get(ctx));
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

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression()));
		exit.get(ctx.expression()).addEdge(exit.get(ctx));
	}
	
	@Override public void exitExprNum(EloquenceParser.ExprNumContext ctx) {
		setType(ctx, Type.INT);
		setEntry(ctx, ctx);

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(exit.get(ctx));
	}
	
	@Override public void exitExprTrue(EloquenceParser.ExprTrueContext ctx) {
		setType(ctx, Type.BOOL);
		setEntry(ctx, ctx);

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(exit.get(ctx));
	}
	
	@Override public void exitExprChar(EloquenceParser.ExprCharContext ctx) {
		setType(ctx, Type.CHAR);
		setEntry(ctx, ctx);

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(exit.get(ctx));
	}
	
	@Override public void exitExprFunc(EloquenceParser.ExprFuncContext ctx) {
		checkNotNull(ctx.functionID());
		setType(ctx, getType(ctx.functionID()));
		//setEntry(ctx, entry(ctx.functionID()));

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.functionID()));
		exit.get(ctx.functionID()).addEdge(exit.get(ctx));
	}
	
	@Override public void exitExprCompound(finalProject.grammar.EloquenceParser.ExprCompoundContext ctx) {
		setType(ctx, getType(ctx.expression()));
		setEntry(ctx, entry(ctx.expression()));
		
		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.body()));
		exit.get(ctx.body()).addEdge(entry.get(ctx.expression()));
		exit.get(ctx.expression()).addEdge(exit.get(ctx));
	}
	
	@Override public void exitExprOr(EloquenceParser.ExprOrContext ctx) {
		checkType(ctx.expression(0), Type.BOOL);
		checkType(ctx.expression(1), Type.BOOL);
		setType(ctx, Type.BOOL);
		setEntry(ctx, entry(ctx.expression(0)));

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression(0)));
		exit.get(ctx.expression(0)).addEdge(entry.get(ctx.expression(1)));
		exit.get(ctx.expression(1)).addEdge(exit.get(ctx));
	}

	@Override public void exitExprArray(finalProject.grammar.EloquenceParser.ExprArrayContext ctx) {
		checkType(ctx.expression(), Type.INT);
		setType(ctx, ((Type.Array)getType(ctx.target())).getElemType());
		setEntry(ctx, ctx);

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression()));
		exit.get(ctx.expression()).addEdge(exit.get(ctx));
	}
	
	@Override public void exitExprAdd(EloquenceParser.ExprAddContext ctx) {
		checkType(ctx.expression(0), Type.INT);
		checkType(ctx.expression(1), Type.INT);
		setType(ctx, Type.INT);
		setEntry(ctx, entry(ctx.expression(0)));

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression(0)));
		exit.get(ctx.expression(0)).addEdge(entry.get(ctx.expression(1)));
		exit.get(ctx.expression(1)).addEdge(exit.get(ctx));
	}
	
	@Override public void exitExprAnd(EloquenceParser.ExprAndContext ctx) {
		checkType(ctx.expression(0), Type.BOOL);
		checkType(ctx.expression(1), Type.BOOL);
		setType(ctx, Type.BOOL);
		setEntry(ctx, entry(ctx.expression(0)));

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression(0)));
		exit.get(ctx.expression(0)).addEdge(entry.get(ctx.expression(1)));
		exit.get(ctx.expression(1)).addEdge(exit.get(ctx));
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

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(exit.get(ctx));
	}
	
	@Override public void exitExprFalse(EloquenceParser.ExprFalseContext ctx) {
		setType(ctx, Type.BOOL);
		setEntry(ctx, ctx);

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(exit.get(ctx));
	}
	
	@Override public void exitExprPar(finalProject.grammar.EloquenceParser.ExprParContext ctx) {
		setType(ctx, getType(ctx.expression()));
		setEntry(ctx, entry(ctx.expression()));
		
		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression()));
		exit.get(ctx.expression()).addEdge(exit.get(ctx));
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

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression(0)));
		exit.get(ctx.expression(ctx.expression().size()-1)).addEdge(exit.get(ctx));
		for(int index = 1; index < ctx.expression().size(); index++)
			exit.get(ctx.expression(index-1)).addEdge(entry.get(ctx.expression(index)));
	}
	
	@Override public void exitArraySingleExpr(finalProject.grammar.EloquenceParser.ArraySingleExprContext ctx) {
		setType(ctx, getType(ctx.expression()));

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression()));
		exit.get(ctx.expression()).addEdge(exit.get(ctx));
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

	@Override public void exitFunctionID(EloquenceParser.FunctionIDContext ctx) {
		checkScope(ctx.expression(0));
		setType(ctx, this.scope.type(ctx.expression(0).getText()));

		/** CFG creation. */
		constructNodes(ctx);
		entry.get(ctx).addEdge(entry.get(ctx.expression(0)));
		for(int index = 1; index < ctx.expression().size(); index++)
			exit.get(ctx.expression(index-1)).addEdge(entry.get(ctx.expression(index)));
		exit.get(ctx.expression(ctx.expression().size()-1)).addEdge(entryFunc.get(ctx.target().getText()));
		exitFunc.get(ctx.target().getText()).addEdge(exit.get(ctx));
	}
	
	@Override public void enterVoidFunc(finalProject.grammar.EloquenceParser.VoidFuncContext ctx) {
		symbolTable.openScope();
	}
	
	//TODO
	@Override public void exitVoidFunc(EloquenceParser.VoidFuncContext ctx) {
		setType(ctx.newID(), null);
		this.scope.put(ctx.newID().getText(), null, ctx.getParent().getChild(0).getText().toLowerCase().equals("highpowered"));
		setOffset(ctx.newID(), scope.offset(ctx.newID().getText()));
		for(StatContext stat : ctx.statBlockBody().body().stat())
			if(stat.getText().toLowerCase().contains("relinquish"))
				addError(ctx, "No return statements are allowed.");
		setType(ctx, null);
		symbolTable.closeScope();

		/** CFG creation. */
		constructNodes(ctx);
		entryFunc.put(ctx.newID().getText(), entry.get(ctx));
		exitFunc.put(ctx.newID().getText(), exit.get(ctx));
		entry.get(ctx).addEdge(entry.get(ctx.statBlockBody()));
		exit.get(ctx.statBlockBody()).addEdge(exit.get(ctx));
	}

	@Override public void enterReturnFunc(finalProject.grammar.EloquenceParser.ReturnFuncContext ctx) {
		symbolTable.openScope();
	}

	//TODO
	@Override public void exitReturnFunc(EloquenceParser.ReturnFuncContext ctx) {	
		setType(ctx, getType(ctx.type()));
		setEntry(ctx, entry(ctx.returnStat()));
		symbolTable.closeScope();

		/** CFG creation. */
		constructNodes(ctx);
		entryFunc.put(ctx.newID().getText(), entry.get(ctx));
		exitFunc.put(ctx.newID().getText(), exit.get(ctx));
		entry.get(ctx).addEdge(entry.get(ctx.body()));
		exit.get(ctx.body()).addEdge(entry.get(ctx.returnStat()));
		exit.get(ctx.returnStat()).addEdge(exit.get(ctx));
	}
	
	@Override public void exitParameters(finalProject.grammar.EloquenceParser.ParametersContext ctx) {
		this.scope.put(ctx.newID().getText(), getType(ctx.type()), true);
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
	
	private void checkMutable(ParserRuleContext node){
		if(!scope.mutable(node.getText()))
			addError(node, "Variable '%s' is immutable.", node.getText());
	}

	private boolean checkScope(ParserRuleContext node){
		if(!symbolTable.contains(node.getText())){
			addError(node, "'%s' not defined in scope", node.getText());
			return false;
		}
		return true;
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
			System.out.println(errors);
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
		if(actual == null)
			addError(node, "Expected type not null but found '%s'", actual);
	}
	
	private void checkNull(ParserRuleContext node){
		Type actual = getType(node);
		if(actual != null)
			addError(node, "Expected type to be void, but found '%s'", actual);
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
	
	/** Adds a node to he CGF, based on a given parse tree node.
	 * Gives the CFG node a meaningful ID, consisting of line number and 
	 * a further indicator.
	 */
	private Node addNode(ParserRuleContext node, String text) {
		return this.cfg.addNode(node.getStart().getLine() + ": " + text);
	}
	
	/**
	 * Construct an entry and exit node for ParserRuleContext.
	 * Put them in entry and exit respectively.
	 * @param ctx
	 */
	public void constructNodes(ParserRuleContext ctx){
		String enterMessage = "enter[%s]";
		enterMessage = String.format(enterMessage, ctx.getText());
		String exitMessage = "exit[%s]";
		exitMessage = String.format(exitMessage, ctx.getText());
		entry.put(ctx, addNode(ctx, enterMessage));
		exit.put(ctx, addNode(ctx, exitMessage));		
	}
}
