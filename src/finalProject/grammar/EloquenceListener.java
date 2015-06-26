// Generated from Eloquence.g4 by ANTLR 4.5
package finalProject.grammar;
package finalProject.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EloquenceParser}.
 */
public interface EloquenceListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(EloquenceParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(EloquenceParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(EloquenceParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(EloquenceParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declVar}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclVar(EloquenceParser.DeclVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declVar}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclVar(EloquenceParser.DeclVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declConstVar}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclConstVar(EloquenceParser.DeclConstVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declConstVar}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclConstVar(EloquenceParser.DeclConstVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declArray}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclArray(EloquenceParser.DeclArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declArray}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclArray(EloquenceParser.DeclArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(EloquenceParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(EloquenceParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#arrayTypeDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayTypeDecl(EloquenceParser.ArrayTypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#arrayTypeDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayTypeDecl(EloquenceParser.ArrayTypeDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#arrayElem}.
	 * @param ctx the parse tree
	 */
	void enterArrayElem(EloquenceParser.ArrayElemContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#arrayElem}.
	 * @param ctx the parse tree
	 */
	void exitArrayElem(EloquenceParser.ArrayElemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varArrayDecl}
	 * labeled alternative in {@link EloquenceParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarArrayDecl(EloquenceParser.VarArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varArrayDecl}
	 * labeled alternative in {@link EloquenceParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarArrayDecl(EloquenceParser.VarArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constArrayDecl}
	 * labeled alternative in {@link EloquenceParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstArrayDecl(EloquenceParser.ConstArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constArrayDecl}
	 * labeled alternative in {@link EloquenceParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstArrayDecl(EloquenceParser.ConstArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statIf}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatIf(EloquenceParser.StatIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statIf}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatIf(EloquenceParser.StatIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statWhile}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatWhile(EloquenceParser.StatWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statWhile}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatWhile(EloquenceParser.StatWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssign(EloquenceParser.StatAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssign(EloquenceParser.StatAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statAssignArray}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssignArray(EloquenceParser.StatAssignArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statAssignArray}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssignArray(EloquenceParser.StatAssignArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statAssignArrayMult}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssignArrayMult(EloquenceParser.StatAssignArrayMultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statAssignArrayMult}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssignArrayMult(EloquenceParser.StatAssignArrayMultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statBlock}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatBlock(EloquenceParser.StatBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statBlock}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatBlock(EloquenceParser.StatBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statReturn}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatReturn(EloquenceParser.StatReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statReturn}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatReturn(EloquenceParser.StatReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statIn}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatIn(EloquenceParser.StatInContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statIn}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatIn(EloquenceParser.StatInContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statOut}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatOut(EloquenceParser.StatOutContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statOut}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatOut(EloquenceParser.StatOutContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#statBlockBody}.
	 * @param ctx the parse tree
	 */
	void enterStatBlockBody(EloquenceParser.StatBlockBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#statBlockBody}.
	 * @param ctx the parse tree
	 */
	void exitStatBlockBody(EloquenceParser.StatBlockBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code targetId}
	 * labeled alternative in {@link EloquenceParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTargetId(EloquenceParser.TargetIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code targetId}
	 * labeled alternative in {@link EloquenceParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTargetId(EloquenceParser.TargetIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#newID}.
	 * @param ctx the parse tree
	 */
	void enterNewID(EloquenceParser.NewIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#newID}.
	 * @param ctx the parse tree
	 */
	void exitNewID(EloquenceParser.NewIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(EloquenceParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(EloquenceParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprComp}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprComp(EloquenceParser.ExprCompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprComp}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprComp(EloquenceParser.ExprCompContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprCompound}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprCompound(EloquenceParser.ExprCompoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprCompound}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprCompound(EloquenceParser.ExprCompoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMult}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMult(EloquenceParser.ExprMultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMult}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMult(EloquenceParser.ExprMultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprUnary}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprUnary(EloquenceParser.ExprUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprUnary}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprUnary(EloquenceParser.ExprUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNum}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprNum(EloquenceParser.ExprNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNum}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprNum(EloquenceParser.ExprNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprTrue}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprTrue(EloquenceParser.ExprTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprTrue}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprTrue(EloquenceParser.ExprTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprChar}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprChar(EloquenceParser.ExprCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprChar}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprChar(EloquenceParser.ExprCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFunc}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprFunc(EloquenceParser.ExprFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFunc}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprFunc(EloquenceParser.ExprFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(EloquenceParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(EloquenceParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPar}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprPar(EloquenceParser.ExprParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPar}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprPar(EloquenceParser.ExprParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAdd}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAdd(EloquenceParser.ExprAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAdd}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAdd(EloquenceParser.ExprAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(EloquenceParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(EloquenceParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprId}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprId(EloquenceParser.ExprIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprId}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprId(EloquenceParser.ExprIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFalse}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprFalse(EloquenceParser.ExprFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFalse}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprFalse(EloquenceParser.ExprFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprArray}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprArray(EloquenceParser.ExprArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprArray}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprArray(EloquenceParser.ExprArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayMulExpr}
	 * labeled alternative in {@link EloquenceParser#arrayExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayMulExpr(EloquenceParser.ArrayMulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayMulExpr}
	 * labeled alternative in {@link EloquenceParser#arrayExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayMulExpr(EloquenceParser.ArrayMulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arraySingleExpr}
	 * labeled alternative in {@link EloquenceParser#arrayExpression}.
	 * @param ctx the parse tree
	 */
	void enterArraySingleExpr(EloquenceParser.ArraySingleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arraySingleExpr}
	 * labeled alternative in {@link EloquenceParser#arrayExpression}.
	 * @param ctx the parse tree
	 */
	void exitArraySingleExpr(EloquenceParser.ArraySingleExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(EloquenceParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(EloquenceParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#multiply}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(EloquenceParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#multiply}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(EloquenceParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#addition}.
	 * @param ctx the parse tree
	 */
	void enterAddition(EloquenceParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitAddition(EloquenceParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompare(EloquenceParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompare(EloquenceParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(EloquenceParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(EloquenceParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(EloquenceParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(EloquenceParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeInt(EloquenceParser.TypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeInt(EloquenceParser.TypeIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeBool(EloquenceParser.TypeBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeBool(EloquenceParser.TypeBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeChar}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeChar(EloquenceParser.TypeCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeChar}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeChar(EloquenceParser.TypeCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcVoid}
	 * labeled alternative in {@link EloquenceParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFuncVoid(EloquenceParser.FuncVoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcVoid}
	 * labeled alternative in {@link EloquenceParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFuncVoid(EloquenceParser.FuncVoidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcReturn}
	 * labeled alternative in {@link EloquenceParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFuncReturn(EloquenceParser.FuncReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcReturn}
	 * labeled alternative in {@link EloquenceParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFuncReturn(EloquenceParser.FuncReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#functionID}.
	 * @param ctx the parse tree
	 */
	void enterFunctionID(EloquenceParser.FunctionIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#functionID}.
	 * @param ctx the parse tree
	 */
	void exitFunctionID(EloquenceParser.FunctionIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#voidFunc}.
	 * @param ctx the parse tree
	 */
	void enterVoidFunc(EloquenceParser.VoidFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#voidFunc}.
	 * @param ctx the parse tree
	 */
	void exitVoidFunc(EloquenceParser.VoidFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#returnFunc}.
	 * @param ctx the parse tree
	 */
	void enterReturnFunc(EloquenceParser.ReturnFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#returnFunc}.
	 * @param ctx the parse tree
	 */
	void exitReturnFunc(EloquenceParser.ReturnFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(EloquenceParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(EloquenceParser.ParametersContext ctx);
}