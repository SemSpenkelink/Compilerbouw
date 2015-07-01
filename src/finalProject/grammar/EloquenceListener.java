// Generated from Eloquence.g4 by ANTLR 4.4
package finalProject.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EloquenceParser}.
 */
public interface EloquenceListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#arrayElem}.
	 * @param ctx the parse tree
	 */
	void enterArrayElem(@NotNull EloquenceParser.ArrayElemContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#arrayElem}.
	 * @param ctx the parse tree
	 */
	void exitArrayElem(@NotNull EloquenceParser.ArrayElemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statVoid}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatVoid(@NotNull EloquenceParser.StatVoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statVoid}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatVoid(@NotNull EloquenceParser.StatVoidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varArrayDecl}
	 * labeled alternative in {@link EloquenceParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarArrayDecl(@NotNull EloquenceParser.VarArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varArrayDecl}
	 * labeled alternative in {@link EloquenceParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarArrayDecl(@NotNull EloquenceParser.VarArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#newID}.
	 * @param ctx the parse tree
	 */
	void enterNewID(@NotNull EloquenceParser.NewIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#newID}.
	 * @param ctx the parse tree
	 */
	void exitNewID(@NotNull EloquenceParser.NewIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMult}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMult(@NotNull EloquenceParser.ExprMultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMult}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMult(@NotNull EloquenceParser.ExprMultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprUnary}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprUnary(@NotNull EloquenceParser.ExprUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprUnary}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprUnary(@NotNull EloquenceParser.ExprUnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull EloquenceParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull EloquenceParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(@NotNull EloquenceParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(@NotNull EloquenceParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull EloquenceParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull EloquenceParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFunc}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprFunc(@NotNull EloquenceParser.ExprFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFunc}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprFunc(@NotNull EloquenceParser.ExprFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(@NotNull EloquenceParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(@NotNull EloquenceParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcReturn}
	 * labeled alternative in {@link EloquenceParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFuncReturn(@NotNull EloquenceParser.FuncReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcReturn}
	 * labeled alternative in {@link EloquenceParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFuncReturn(@NotNull EloquenceParser.FuncReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#voidFunc}.
	 * @param ctx the parse tree
	 */
	void enterVoidFunc(@NotNull EloquenceParser.VoidFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#voidFunc}.
	 * @param ctx the parse tree
	 */
	void exitVoidFunc(@NotNull EloquenceParser.VoidFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPar}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprPar(@NotNull EloquenceParser.ExprParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPar}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprPar(@NotNull EloquenceParser.ExprParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAdd}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAdd(@NotNull EloquenceParser.ExprAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAdd}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAdd(@NotNull EloquenceParser.ExprAddContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(@NotNull EloquenceParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(@NotNull EloquenceParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeChar}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeChar(@NotNull EloquenceParser.TypeCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeChar}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeChar(@NotNull EloquenceParser.TypeCharContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#addition}.
	 * @param ctx the parse tree
	 */
	void enterAddition(@NotNull EloquenceParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitAddition(@NotNull EloquenceParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code targetId}
	 * labeled alternative in {@link EloquenceParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTargetId(@NotNull EloquenceParser.TargetIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code targetId}
	 * labeled alternative in {@link EloquenceParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTargetId(@NotNull EloquenceParser.TargetIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNum}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprNum(@NotNull EloquenceParser.ExprNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNum}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprNum(@NotNull EloquenceParser.ExprNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprChar}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprChar(@NotNull EloquenceParser.ExprCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprChar}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprChar(@NotNull EloquenceParser.ExprCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statOut}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStatOut(@NotNull EloquenceParser.StatOutContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statOut}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStatOut(@NotNull EloquenceParser.StatOutContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#functionID}.
	 * @param ctx the parse tree
	 */
	void enterFunctionID(@NotNull EloquenceParser.FunctionIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#functionID}.
	 * @param ctx the parse tree
	 */
	void exitFunctionID(@NotNull EloquenceParser.FunctionIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#arrayTypeDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayTypeDecl(@NotNull EloquenceParser.ArrayTypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#arrayTypeDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayTypeDecl(@NotNull EloquenceParser.ArrayTypeDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcVoid}
	 * labeled alternative in {@link EloquenceParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFuncVoid(@NotNull EloquenceParser.FuncVoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcVoid}
	 * labeled alternative in {@link EloquenceParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFuncVoid(@NotNull EloquenceParser.FuncVoidContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#returnFunc}.
	 * @param ctx the parse tree
	 */
	void enterReturnFunc(@NotNull EloquenceParser.ReturnFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#returnFunc}.
	 * @param ctx the parse tree
	 */
	void exitReturnFunc(@NotNull EloquenceParser.ReturnFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statAssignArrayMult}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssignArrayMult(@NotNull EloquenceParser.StatAssignArrayMultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statAssignArrayMult}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssignArrayMult(@NotNull EloquenceParser.StatAssignArrayMultContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(@NotNull EloquenceParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(@NotNull EloquenceParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompare(@NotNull EloquenceParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompare(@NotNull EloquenceParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprCompound}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprCompound(@NotNull EloquenceParser.ExprCompoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprCompound}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprCompound(@NotNull EloquenceParser.ExprCompoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statAssignArray}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssignArray(@NotNull EloquenceParser.StatAssignArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statAssignArray}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssignArray(@NotNull EloquenceParser.StatAssignArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statBlock}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatBlock(@NotNull EloquenceParser.StatBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statBlock}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatBlock(@NotNull EloquenceParser.StatBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statWhile}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStatWhile(@NotNull EloquenceParser.StatWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statWhile}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStatWhile(@NotNull EloquenceParser.StatWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statIn}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStatIn(@NotNull EloquenceParser.StatInContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statIn}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStatIn(@NotNull EloquenceParser.StatInContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull EloquenceParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull EloquenceParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(@NotNull EloquenceParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(@NotNull EloquenceParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprId}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprId(@NotNull EloquenceParser.ExprIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprId}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprId(@NotNull EloquenceParser.ExprIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statIf}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStatIf(@NotNull EloquenceParser.StatIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statIf}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStatIf(@NotNull EloquenceParser.StatIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#multiply}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(@NotNull EloquenceParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#multiply}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(@NotNull EloquenceParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declArray}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclArray(@NotNull EloquenceParser.DeclArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declArray}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclArray(@NotNull EloquenceParser.DeclArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprComp}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprComp(@NotNull EloquenceParser.ExprCompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprComp}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprComp(@NotNull EloquenceParser.ExprCompContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull EloquenceParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull EloquenceParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declConstVar}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclConstVar(@NotNull EloquenceParser.DeclConstVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declConstVar}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclConstVar(@NotNull EloquenceParser.DeclConstVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constArrayDecl}
	 * labeled alternative in {@link EloquenceParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstArrayDecl(@NotNull EloquenceParser.ConstArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constArrayDecl}
	 * labeled alternative in {@link EloquenceParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstArrayDecl(@NotNull EloquenceParser.ConstArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statExpr}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatExpr(@NotNull EloquenceParser.StatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statExpr}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatExpr(@NotNull EloquenceParser.StatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprTrue}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprTrue(@NotNull EloquenceParser.ExprTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprTrue}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprTrue(@NotNull EloquenceParser.ExprTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeBool(@NotNull EloquenceParser.TypeBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeBool(@NotNull EloquenceParser.TypeBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#statBlockBody}.
	 * @param ctx the parse tree
	 */
	void enterStatBlockBody(@NotNull EloquenceParser.StatBlockBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#statBlockBody}.
	 * @param ctx the parse tree
	 */
	void exitStatBlockBody(@NotNull EloquenceParser.StatBlockBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declVar}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclVar(@NotNull EloquenceParser.DeclVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declVar}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclVar(@NotNull EloquenceParser.DeclVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeInt(@NotNull EloquenceParser.TypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeInt(@NotNull EloquenceParser.TypeIntContext ctx);
	/**
	 * Enter a parse tree produced by {@link EloquenceParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull EloquenceParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull EloquenceParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssign(@NotNull EloquenceParser.StatAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssign(@NotNull EloquenceParser.StatAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFalse}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprFalse(@NotNull EloquenceParser.ExprFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFalse}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprFalse(@NotNull EloquenceParser.ExprFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statReturn}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatReturn(@NotNull EloquenceParser.StatReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statReturn}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatReturn(@NotNull EloquenceParser.StatReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprArray}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprArray(@NotNull EloquenceParser.ExprArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprArray}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprArray(@NotNull EloquenceParser.ExprArrayContext ctx);
}