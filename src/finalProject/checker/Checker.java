package finalProject.checker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import finalProject.grammar.EloquenceBaseListener;
import finalProject.grammar.EloquenceParser;
import finalProject.grammar.EloquenceParser.ExpressionContext;
import finalProject.grammar.EloquenceParser.NewIDContext;
import finalProject.grammar.EloquenceParser.ParametersContext;
import finalProject.grammar.EloquenceParser.ReturnFuncContext;
import finalProject.grammar.EloquenceParser.VoidFuncContext;
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
	
	/** Int indicating whether the treewalker is in a function or not, 0 is not in a function */
	private Stack<List<ParseTree>> functionDeclarations;

	/** Runs this checker on a given parse tree,
	 * and returns the checker result.
	 * @throws ParseException if an error was found during checking.
	 */
	public Result check(ParseTree tree) throws ParseException {
		this.scope = new Scope();
		this.symbolTable = new SymbolTable();
		this.result = new Result();
		this.errors = new ArrayList<>();
		this.functionDeclarations = new Stack<>();
		new ParseTreeWalker().walk(this, tree);
		if (hasErrors()) {
			throw new ParseException(getErrors());
		}
		this.result.setFunctionArguments(scope.getFunctionArguments());
		this.result.setFunctionDeclarations(scope.getFunctionDeclarations());
		return this.result;
	}
	
	/**
	 * Set type of body to type of last child, used for compound expressions.
	 */
	@Override public void exitBody(finalProject.grammar.EloquenceParser.BodyContext ctx) {
		setType(ctx, getType(ctx.getChild(ctx.getChildCount()-1)));
	}
	
	/**
	 * If the declaration contains an expression, it checks whether the expression
	 * has the same type as the variable it is assigned to. The type is set to the
	 * type of variable.
	 * The entry is set to the entry of the variable.
	 */
	@Override public void exitDeclVar(EloquenceParser.DeclVarContext ctx) {
		if(ctx.expression() != null){
			checkType(ctx.expression(), getType(ctx.variable()));
		}
		setType(ctx, getType(ctx.variable()));
		//setEntry(ctx, entry(ctx.variable()));
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
			this.scope.put(id.getText(), getType(ctx.type()), ctx.getParent().getChild(0).getText().toLowerCase().equals("highpowered"), null, null);
			setOffset(id.ID(), scope.offset(id.getText()));
			if(!functionDeclarations.isEmpty()){
				List<ParseTree> declarations = functionDeclarations.pop();
				declarations.add(id.ID());
				functionDeclarations.push(declarations);
			}
		}
		setType(ctx, getType(ctx.type()));
		//setEntry(ctx, ctx);
	}
	
	/**
	 * Set the type of the array to an array ranging from [NUM(0)..NUM(1)] with the type of ctx.type().
	 * Add this ID into the scope and set the offset accordingly.
	 * Set the entry to itself.
	 */
	@Override public void exitArrayTypeDecl(finalProject.grammar.EloquenceParser.ArrayTypeDeclContext ctx) {
		setType(ctx, new Type.Array(Integer.parseInt(ctx.arrayElem().NUM(0).getText()), Integer.parseInt(ctx.arrayElem().NUM(1).getText()), getType(ctx.type())));
		this.scope.put(ctx.newID().ID().getText(), getType(ctx), false, null, null);
		setOffset(ctx.newID().ID(), scope.offset(ctx.newID().getText()));
		//setEntry(ctx, ctx);
	}

	/**
	 * Set the type of each id to the type of the target.
	 * Add each id to the scope and set the offset accordingly.
	 * Set the type of varArrayDecl to that of its target.
	 * Set the entry to itself.
	 */
	@Override public void exitVarArrayDecl(finalProject.grammar.EloquenceParser.VarArrayDeclContext ctx) {
		for(NewIDContext id : ctx.newID()){
			setType(id, this.scope.type(ctx.target().getText()));
			setType(id.ID(), this.scope.type(ctx.target().getText()));
			this.scope.put(id.getText(), getType(id), true, null, null);
			setOffset(id.ID(), scope.offset(id.getText()));
			if(!functionDeclarations.isEmpty()){
				List<ParseTree> declarations = functionDeclarations.pop();
				declarations.add(id.ID());
				functionDeclarations.push(declarations);
			}
		}
		setType(ctx, this.scope.type(ctx.target().getText()));
		//setEntry(ctx, ctx)
	}

	/**
	 * Check for each expression, whether the types are equal and
	 * whether the types correspond to the element type of the target array.
	 * For each ID, set the type to that of the target array.
	 * Add the ID to the scope and set the offset accordingly.
	 * Set the type of this declaration to that of the target.
	 * Set the entry to itself.
	 */
	@Override public void exitConstArrayDecl(finalProject.grammar.EloquenceParser.ConstArrayDeclContext ctx) {
		Type type = getType(ctx.expression(0));
		for(ExpressionContext expr : ctx.expression()){
			if(expr.equals(ctx.expression(0)))
				continue;
			checkType(expr, type);
		}		
		checkType(ctx.expression(0), ((Type.Array)getType(ctx.target())).getElemType());
		
		for(NewIDContext id : ctx.newID()){
			setType(id, this.scope.type(ctx.target().getText()));
			setType(id, this.scope.type(ctx.target().getText()));
			this.scope.put(id.ID().getText(), getType(id), false, null, null);
			setOffset(id.ID(), scope.offset(id.getText()));
			if(!functionDeclarations.isEmpty()){
				List<ParseTree> declarations = functionDeclarations.pop();
				declarations.add(id.ID());
				functionDeclarations.push(declarations);
			}
		}
		setType(ctx, this.scope.type(ctx.target().getText()));
		//setEntry(ctx, ctx);
	}
	
	/**
	 * Set the entry of the declaration to the entry of its variable.
	 */
	@Override public void exitDeclConstVar(EloquenceParser.DeclConstVarContext ctx) {
		//setEntry(ctx, entry(ctx.variable()));
	}
	
	/**
	 * Set the type of the array declaration to that of its array declaration.
	 */
	@Override public void exitDeclArray(EloquenceParser.DeclArrayContext ctx) {
		setType(ctx, getType(ctx.arrayDecl()));
	}
	
	/**
	 * Set the type of return stat to that of its returnStat.
	 * If its returnStat is not a void, set the entry to the value of its returnStat.
	 */
	@Override public void exitStatReturn(EloquenceParser.StatReturnContext ctx) {
		setType(ctx, getType(ctx.returnStat()));
		//if(getType(ctx.returnStat()) != null)
			//setEntry(ctx, ctx.returnStat());
	}
	
	/**
	 * Open a new scope for the variables declared within the comparison expression of the if statement.
	 */
	@Override public void enterStatIf(finalProject.grammar.EloquenceParser.StatIfContext ctx) {
		symbolTable.openScope();
	}
	
	/**
	 * Check whether the expression of the if statement is a boolean expression.
	 * If there is an no else part, or if the if and else have the same type set the type to the type of if.
	 * If there is an else part but it does not return the same type as the if part, set the type to null.
	 * Close the scope that was opened at the enterStatIf to ensure inner variables cannot be used again.
	 */
	@Override public void exitStatIf(EloquenceParser.StatIfContext ctx) {
		checkType(ctx.expression(), Type.BOOL);
		if(ctx.ELSE() != null && getType(ctx.stat(0)).equals(getType(ctx.stat(1))))
			setType(ctx, getType(ctx.stat(0)));
		else
			setType(ctx, null);
		//setEntry(ctx, ctx);
		symbolTable.closeScope();
	}
	
	/**
	 * Open a new scope for the variables declared within the comparison expression of the while statement.
	 */
	@Override public void enterStatWhile(finalProject.grammar.EloquenceParser.StatWhileContext ctx) {
		symbolTable.openScope();
	}
	
	/**
	 * Check whether the expression type is a boolean, set the type of the while statement
	 * to void. Finally, close the scope that was opened at the enterStatIf to ensure inner
	 * variables cannot be used again.
	 */
	@Override public void exitStatWhile(EloquenceParser.StatWhileContext ctx) {
		checkType(ctx.expression(), Type.BOOL);
		setType(ctx, null);
		//setEntry(ctx, ctx);
		symbolTable.closeScope();
	}
	
	/**
	 * Check if the target is in the scope. If this is the case, check if the type of expression
	 * is equal to that of the target. Also check whether the target is mutable, i.e. not constant.
	 * Set the type of the assignment to that of its target, set the offset to that of its target.
	 */
	@Override public void exitStatAssign(EloquenceParser.StatAssignContext ctx) {
		for(TargetContext target : ctx.target()){
			if(checkScope(target) && checkNotNull(ctx.expression())){
				checkType(ctx.expression(), getType(target));
				checkMutable(target);
				setType(ctx, this.scope.type(ctx.target(0).getText()));
				setOffset(ctx, scope.offset(ctx.target(0).getText()));
			}
		}
	}

	/**
	 * Check if the target is in the scope. If this is the case, check if the type of the first
	 * expression is an integer and the second expression is equal to the type of the array elements.
	 * Check if the target is mutable. Then set the type to that of the target en the entry to that
	 * of its target.
	 */
	@Override public void exitStatAssignArray(EloquenceParser.StatAssignArrayContext ctx) {
		for(TargetContext target : ctx.target())
			if(checkScope(target)){
				checkType(ctx.expression(0), Type.INT);
				checkType(ctx.expression(ctx.expression().size()-1), ((Type.Array)getType(target)).getElemType());
				checkMutable(target);
			}
		for(int index = 0; index < ctx.target().size(); index++){
			if(checkScope(ctx.target(index))){
				checkType(ctx.expression(index), Type.INT);
				checkType(ctx.expression(ctx.expression().size()-1), ((Type.Array)getType(ctx.target(index))).getElemType());
				checkMutable(ctx.target(index));
			}
		}
		setType(ctx, getType(ctx.target(0)));
		//setEntry(ctx, entry(ctx.target(0)));
	}

	/**
	 * Check if the target is in the scope. If this is the case, check
	 * for each expression if they are of the same type and if they are of the type of  the target array elements.
	 * is equal to that of the type of the array elements. Check if the target is mutable.
	 * Set the type to that of the target and the entry also to the type of the target.
	 */
	@Override public void exitStatAssignArrayMult(finalProject.grammar.EloquenceParser.StatAssignArrayMultContext ctx) {
		for(TargetContext target : ctx.target())
			if(checkScope(target)){
				if(ctx.expression().size() > ((Type.Array)getType(target)).getUpper() - ((Type.Array)getType(target)).getLower()+1)
					addError(ctx, "Number of elements to assign is too high, maximum number of elements = '%d', tried to add '%d' elements.",
							((Type.Array)getType(target)).getUpper() - ((Type.Array)getType(target)).getLower()+1, ctx.expression().size());
				Type type = getType(ctx.expression(0));
				for(ExpressionContext expr : ctx.expression()){
					if(expr.equals(ctx.expression(0)))
						continue;
					checkType(expr, type);
				}
				
				checkType(ctx.expression(0), ((Type.Array)getType(target)).getElemType());
				checkMutable(target);
			}
		setType(ctx, getType(ctx.target(0)));
		//setEntry(ctx, entry(ctx.target(0)));
	}
	
	/**
	 * Set the type of the block to that of its body.
	 */
	@Override public void exitStatBlock(EloquenceParser.StatBlockContext ctx) {
		setType(ctx, getType(ctx.statBlockBody()));
		////setEntry(ctx, entry(ctx.body().stat(0)));
	}
	
	/**
	 * For each target from statIn check whether it is contained in the scope and whether it is mutable.
	 * If there is only one target, the type of in is set to the type of the target. The entry is also
	 * set to the target. If there are multiple targets, the type is set to null, i.e. void.
	 */
	@Override public void exitStatIn(EloquenceParser.StatInContext ctx){
		for(TargetContext target : ctx.target())
			if(checkScope(target))
				checkMutable(target);
		if(ctx.target().size() == 1){
			setType(ctx, this.scope.type(ctx.target(0).getText()));
			//setEntry(ctx, entry(ctx.target(0)));
		}else{
			setType(ctx, null);
		}
	}
	
	/**
	 * For each expression from statOut check whether the expression is not null. If there is one
	 * expression, set the type to that of its expression and set the entry to that of its expression.
	 * If there are multiple expressions, set the type to null, i.e. void.
	 */
	@Override public void exitStatOut(EloquenceParser.StatOutContext ctx){
		for(ExpressionContext expr : ctx.expression())
			checkNotNull(expr);
		if(ctx.expression().size() == 1){
			setType(ctx, getType(ctx.expression(0)));
//			//setEntry(ctx, entry(ctx.expression(0)));	
		}else
			setType(ctx, null);
	}
	
	/**
	 * Set the type to void.
	 */
	@Override public void exitStatVoid(finalProject.grammar.EloquenceParser.StatVoidContext ctx) {
		setType(ctx, this.scope.type(ctx.functionID().target().getText()));
		setType(ctx.functionID(), this.scope.type(ctx.functionID().target().getText()));
	}
	
	/**
	 * Set type of statExpr to that of its child expression.
	 * Set entry to itself.
	 */
	@Override public void exitStatExpr(finalProject.grammar.EloquenceParser.StatExprContext ctx) {
		setType(ctx, getType(ctx.expression()));
		//setEntry(ctx, ctx);
	}
	
	/**
	 * Open a new scope for the variables declared within the comparison expression of the block statement.
	 */
	@Override public void enterStatBlockBody(finalProject.grammar.EloquenceParser.StatBlockBodyContext ctx) {
		symbolTable.openScope();
	}
	
	/**
	 * Set the type of statBlockBody to that of its body.
	 * Close the scope that was opened at the enterStatBlockBody to ensure inner variables cannot be used again.
	 */
	@Override public void exitStatBlockBody(finalProject.grammar.EloquenceParser.StatBlockBodyContext ctx) {
		setType(ctx, getType(ctx.body()));
		symbolTable.closeScope();
	}
	
	/**
	 * Check whether the return statement has an expression.
	 * If it does, set the type to the type of the expression and the entry to the entry of expression.
	 * If it does not have an expression, i.e. is of type void, set the type to null, i.e. void.
	 */
	@Override public void exitReturnStat(EloquenceParser.ReturnStatContext ctx) {
		if(ctx.expression() != null){
			setType(ctx, getType(ctx.expression()));
			//setEntry(ctx, ctx.expression());
		}else
			setType(ctx, null);
	}
	
	/**
	 * Check whether the targetID is in the scope.
	 * If this is the case, set the offset of target to the offset of the scope.
	 * Set the offset of the child to the offset in the scope.
	 * Set the entry to itself, and the entry of the child to this.
	 * Set the type to the type as declared in the scope.
	 */
	@Override public void exitTargetId(finalProject.grammar.EloquenceParser.TargetIdContext ctx) {
		if(checkScope(ctx)){
			setOffset(ctx, this.scope.offset(ctx.getText()));
			setOffset(ctx.getChild(0), this.scope.offset(ctx.getText()));
			//setEntry(ctx, ctx);
			//setEntry(ctx.getChild(0), ctx);
			setType(ctx, this.scope.type(ctx.ID().getText()));
		}
	}
	
	/**
	 * Add the symbol of ctx in the symbolTable.
	 */
	@Override public void exitNewID(NewIDContext ctx) {
		addSymbol(ctx);
	}
	
	/**
	 * Check the type of expression, if they are <, <=, >=, or > check if both expressions are integers.
	 * Otherwise check if the types are equal.
	 * Set the resulting type to a boolean and set the entry to the entry of the first expression.
	 */
	@Override public void exitExprComp(EloquenceParser.ExprCompContext ctx) {
		if(ctx.compare().LT() != null || ctx.compare().LE() != null || ctx.compare().GE() != null || ctx.compare().GT() != null){
			checkType(ctx.expression(0), Type.INT);
			checkType(ctx.expression(1), Type.INT);
		}else{
			checkType(ctx.expression(0), getType(ctx.expression(1)));
		}		
		setType(ctx, Type.BOOL);
		//setEntry(ctx, entry(ctx.expression(0)));
	}
	
	/**
	 * Check whether the types of both expressions are integers.
	 * Set the resulting type to integer.
	 * Set the entry to that of the first expression.
	 */
	@Override public void exitExprMult(EloquenceParser.ExprMultContext ctx) {
		checkType(ctx.expression(0), Type.INT);
		checkType(ctx.expression(1), Type.INT);
		setType(ctx, Type.INT);
		//setEntry(ctx, entry(ctx.expression(0)));
	}
	
	/**
	 * If the unary sign is a plus or minus, check whether the type is integer.
	 * If the unary sign is a not, check whether the type is boolean.
	 * Set the type to that of the expression.
	 * Set the entry to that of the expression.
	 */
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
		//setEntry(ctx, entry(ctx.expression()));
	}
	
	/**
	 * Set the type of this expression to integer.
	 * Set the entry of this expression to itself.
	 */
	@Override public void exitExprNum(EloquenceParser.ExprNumContext ctx) {
		setType(ctx, Type.INT);
		//setEntry(ctx, ctx);
	}
	
	/**
	 * Set the type of this expression to boolean.
	 * Set the entry of this expression to itself.
	 */
	@Override public void exitExprTrue(EloquenceParser.ExprTrueContext ctx) {
		setType(ctx, Type.BOOL);
		//setEntry(ctx, ctx);
	}
	
	/**
	 * Set the type of this expression to character.
	 * Set the entry of this expression to itself.
	 */
	@Override public void exitExprChar(EloquenceParser.ExprCharContext ctx) {
		setType(ctx, Type.CHAR);
		//setEntry(ctx, ctx);
	}
	
	/**
	 * Check if the function is not a void function.
	 * Set the type to the type of functionID
	 */
	@Override public void exitExprFunc(EloquenceParser.ExprFuncContext ctx) {
		if(checkNotNull(ctx.functionID())){
			checkScope(ctx.functionID().target());
			setType(ctx, getType(ctx.functionID()));
		}else{
			setType(ctx, Type.INT);
		}
	}
	
	/**
	 * Set the type to that of the expression.
	 * Set the entry to that of its expression.
	 */
	@Override public void exitExprCompound(finalProject.grammar.EloquenceParser.ExprCompoundContext ctx) {
		if(checkNotNull(ctx.expression())){
			setType(ctx, getType(ctx.expression()));
			//setEntry(ctx, entry(ctx.expression()));
		}else{
			setType(ctx, Type.INT); //Default type.
			//setEntry(ctx, ctx);
		}
	}
	
	/**
	 * Check if both expression are of type boolean.
	 * Set the resulting type to boolean.
	 * Set the entry to the entry of the first expression.
	 */
	@Override public void exitExprOr(EloquenceParser.ExprOrContext ctx) {
		checkType(ctx.expression(0), Type.BOOL);
		checkType(ctx.expression(1), Type.BOOL);
		setType(ctx, Type.BOOL);
		//setEntry(ctx, entry(ctx.expression(0)));
	}

	/**
	 * Check if the type of expression is an integer.
	 * Set the type to that of the element type of the array.
	 * Set the entry to itself.
	 */
	@Override public void exitExprArray(finalProject.grammar.EloquenceParser.ExprArrayContext ctx) {
		checkType(ctx.expression(), Type.INT);
		setType(ctx, ((Type.Array)getType(ctx.target())).getElemType());
		//setEntry(ctx, ctx);
	}
	
	/**
	 * Check if both expressions are of type integer.
	 * Set the resulting type to integer.
	 * Set the entry to the entry of the first expression.
	 */
	@Override public void exitExprAdd(EloquenceParser.ExprAddContext ctx) {
		checkType(ctx.expression(0), Type.INT);
		checkType(ctx.expression(1), Type.INT);
		setType(ctx, Type.INT);
		//setEntry(ctx, entry(ctx.expression(0)));
	}
	
	/**
	 * Check if both expressions are of type boolean.
	 * Set the resulting type to boolean.
	 * Set the entry to the entry of first expression.
	 */
	@Override public void exitExprAnd(EloquenceParser.ExprAndContext ctx) {
		checkType(ctx.expression(0), Type.BOOL);
		checkType(ctx.expression(1), Type.BOOL);
		setType(ctx, Type.BOOL);
		//setEntry(ctx, entry(ctx.expression(0)));
	}
	
	/**
	 * Check if the target is declared. If this is the case, set the type
	 * to the type of target. Set the offsets of this and target according
	 * to the scope and set the entry to itself.
	 */
	@Override public void exitExprId(EloquenceParser.ExprIdContext ctx) {
		String id = ctx.target().getText();
		Type type = this.scope.type(id);
		if (type == null) {
			addError(ctx, "Variable '%s' not declared", id);
		} else {
			setType(ctx, type);
			setOffset(ctx, this.scope.offset(id));
			setOffset(ctx.target(), this.scope.offset(id));
			//setEntry(ctx, ctx);
		}
	}
	
	/**
	 * Set type of expression to boolean.
	 * Set entry to itself. 
	 */
	@Override public void exitExprFalse(EloquenceParser.ExprFalseContext ctx) {
		setType(ctx, Type.BOOL);
		//setEntry(ctx, ctx);
	}
	
	/**
	 * Set type of exprPar to type of expression.
	 * Set entry to entry of expression. 
	 */
	@Override public void exitExprPar(finalProject.grammar.EloquenceParser.ExprParContext ctx) {
		setType(ctx, getType(ctx.expression()));
		//setEntry(ctx, entry(ctx.expression()));
	}
	
	/**
	 * Set the type to integer.
	 */
	@Override public void exitTypeInt(EloquenceParser.TypeIntContext ctx) {
		setType(ctx, Type.INT);
	}
	
	/**
	 * Set the type to boolean.
	 */
	@Override public void exitTypeBool(EloquenceParser.TypeBoolContext ctx) {
		setType(ctx, Type.BOOL);		
	}
	
	/**
	 * Set the type to character.
	 */
	@Override public void exitTypeChar(EloquenceParser.TypeCharContext ctx) {
		setType(ctx, Type.CHAR);
	}
	
	/**
	 * Set the type to null, i.e. void.
	 */
	@Override public void exitFuncVoid(EloquenceParser.FuncVoidContext ctx) {
		setType(ctx, null);
	}

	/**
	 * Set type to the type of return function.
	 * Set the entry to the entry of return function.
	 */
	@Override public void exitFuncReturn(EloquenceParser.FuncReturnContext ctx) {
		setType(ctx, getType(ctx.returnFunc()));
		//setEntry(ctx, entry(ctx.returnFunc()));
	}

	//TODO explain
	@Override public void enterFunctionID(finalProject.grammar.EloquenceParser.FunctionIDContext ctx) {
		/** Only push parameters of enclosing function if there is an enclosing function. */
		if(!functionDeclarations.isEmpty()){
			List<Type> arguments = new ArrayList<Type>();
			ParseTree enclParent = ctx;
			/** Retrieve function in which enterFunctionID is called, i.e. enclosing function. */
			while(!(enclParent instanceof VoidFuncContext)	&& !(enclParent instanceof ReturnFuncContext))
				enclParent = enclParent.getParent();
			/** Retrieve list of parameters from enclosing function. */
			List<ParametersContext> params = (enclParent instanceof VoidFuncContext) ? ((VoidFuncContext)enclParent).parameters() : ((ReturnFuncContext)enclParent).parameters() ;
			/** Add type to list of parameters. */
			for(ParametersContext param : params)
				arguments.add(getType(param));
			/** Set type if it is a return function. */
			Type type = (enclParent instanceof ReturnFuncContext) ? getType(((ReturnFuncContext)enclParent).type()) : null;
			/** Set type of parent to correct return type. */
			setType(enclParent, type);
			/** Put the entry of the parent in the scope. */
			this.scope.put(enclParent.getChild(1).getChild(0).getText(), type, false, arguments, functionDeclarations.peek());
		}
	}
	
	/**
	 * Check if the function is defined.
	 * Check if the number of parameters given matches the number of parameters required.
	 * Check if the type of parameters match the type of parameters required.
	 * Set type to that of target.
	 * Set entry to itself.
	 */
	@Override public void exitFunctionID(EloquenceParser.FunctionIDContext ctx) {
		checkScope(ctx.target());
		List<Type> argumentTypes = scope.arguments(ctx.target().getText());
		if(argumentTypes != null && ctx.expression().size() != 0){
			if(argumentTypes.size() != ctx.expression().size())
				addError(ctx, "Number of arguments do not match, expected '%d' arguments but got '%d' arguments.",
						argumentTypes.size(), ctx.expression().size());
			for(int index = 0; index < ctx.expression().size() && index < argumentTypes.size(); index++){
				checkType(ctx.expression(index), argumentTypes.get(index));
			}
		}
		setType(ctx, this.scope.type(ctx.target().getText()));
		//setEntry(ctx, ctx);
	}
	
	/**
	 * Open a new scope for the variables declared within the comparison expression of the void function.
	 */
	@Override public void enterVoidFunc(finalProject.grammar.EloquenceParser.VoidFuncContext ctx) {
		symbolTable.openScope();
		functionDeclarations.push(new ArrayList<ParseTree>());
	}
	
	/**
	 * Close scope to remove unnecessary variables.
	 * Set return type of ID to null, i.e. void.
	 * Add arguments to the list of arguments.
	 * Add symbol to symboltable.
	 * Put function in scope, which is of type void, immutable and with the given argumentlist.
	 * Set offset accordingly.
	 * Check if the body contains a return statement, which is not allowed.
	 * Set return type to null, i.e. void.
	 */
	@Override public void exitVoidFunc(EloquenceParser.VoidFuncContext ctx) {
		symbolTable.closeScope();
		setType(ctx.newID(), null);
		List<Type> arguments = new ArrayList<Type>();
		for(ParametersContext param : ctx.parameters()){
			arguments.add(getType(param));
		}
		addSymbol(ctx.newID());
		this.scope.put(ctx.newID().ID().getText(), null, false, arguments, functionDeclarations.pop());
		setOffset(ctx.newID().ID(), scope.offset(ctx.newID().ID().getText()));
		for(StatContext stat : ctx.statBlockBody().body().stat())
			if(stat.getText().toLowerCase().contains("relinquish"))
				addError(ctx, "No return statements are allowed.");
		setType(ctx, null);
	}

	/**
	 * Open a new scope for the variables declared within the comparison expression of the return function.
	 */
	@Override public void enterReturnFunc(finalProject.grammar.EloquenceParser.ReturnFuncContext ctx) {
		symbolTable.openScope();
		functionDeclarations.push(new ArrayList<ParseTree>());
	}

	/**
	 * Close scope to remove unnecessary variables.
	 * Set return type of ID to given type.
	 * Set return type to given type.
	 * Add arguments to the list of arguments.
	 * Add symbol to symboltable.
	 * Put function in scope, which is of type type, immutable and with the given argumentlist.
	 * Set offset accordingly.
	 * Set entry to entry of return statement.
	 */
	@Override public void exitReturnFunc(EloquenceParser.ReturnFuncContext ctx) {
		symbolTable.closeScope();
		setType(ctx.newID(), getType(ctx.type()));
		setType(ctx, getType(ctx.type()));
		List<Type> arguments = new ArrayList<Type>();
		for(ParametersContext param : ctx.parameters()){
			arguments.add(getType(param));
		}
		addSymbol(ctx.newID());
		this.scope.put(ctx.newID().ID().getText(), getType(ctx.type()), false, arguments, functionDeclarations.pop());
		setOffset(ctx.newID().ID(), scope.offset(ctx.newID().ID().getText()));
		//setEntry(ctx, entry(ctx.returnStat()));
	}
	
	/**
	 * Put the parameters in the scope and set the offset accordingly.
	 * @param ctx
	 */
	@Override public void exitParamVal(finalProject.grammar.EloquenceParser.ParamValContext ctx) {
		setType(ctx, getType(ctx.type()));
		this.scope.put(ctx.newID().ID().getText(), getType(ctx.type()), true, null, null);
		setOffset(ctx.newID().ID(), scope.offset(ctx.newID().ID().getText()));
		
	}
	
	/**
	 * Put the parameters in the scope and set the offset accordingly.
	 * @param ctx
	 */
	@Override public void exitParamRef(finalProject.grammar.EloquenceParser.ParamRefContext ctx) {
		setType(ctx, getType(ctx.type()));
		this.scope.put(ctx.newID().ID().getText(), getType(ctx.type()), true, null, null);
		setOffset(ctx.newID().ID(), scope.offset(ctx.newID().ID().getText()));
	}
	
	
	
	
	
	
	
	
	
	
	
	

	/** Indicates if any errors were encountered in this tree listener. */
	public boolean hasErrors() {
		return !getErrors().isEmpty();
	}

	/** Returns the list of errors collected in this tree listener. */
	public List<String> getErrors() {
		return this.errors;
	}
	
	/** Checks if a variable is mutable. */
	private void checkMutable(ParserRuleContext node){
		if(!scope.mutable(node.getText()))
			addError(node, "Variable '%s' is immutable.", node.getText());
	}

	/** Checks if a variable is contained in the scope. */
	private boolean checkScope(ParserRuleContext node){
		if(!symbolTable.contains(node.getText())){
			addError(node, "'%s' not defined in scope", node.getText());
			return false;
		}
		return true;
	}

	/** Add a symbol to the scope. */
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
	private boolean checkNotNull(ParserRuleContext node){
		Type actual = getType(node);
		if(actual == null){
			addError(node, "Expected type not null but found '%s'", actual);
			return false;
		}
		return true;
	}
	
	/** Check if a variable is null. */
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
}
