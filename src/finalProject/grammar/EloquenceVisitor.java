// Generated from Eloquence.g4 by ANTLR 4.5
package finalProject.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EloquenceParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EloquenceVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(EloquenceParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(EloquenceParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declVar}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclVar(EloquenceParser.DeclVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declConstVar}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclConstVar(EloquenceParser.DeclConstVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declArray}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclArray(EloquenceParser.DeclArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(EloquenceParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#arrayTypeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypeDecl(EloquenceParser.ArrayTypeDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#arrayElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElem(EloquenceParser.ArrayElemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varArrayDecl}
	 * labeled alternative in {@link EloquenceParser#arrayDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarArrayDecl(EloquenceParser.VarArrayDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constArrayDecl}
	 * labeled alternative in {@link EloquenceParser#arrayDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstArrayDecl(EloquenceParser.ConstArrayDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statIf}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatIf(EloquenceParser.StatIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statWhile}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatWhile(EloquenceParser.StatWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssign(EloquenceParser.StatAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statAssignArray}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssignArray(EloquenceParser.StatAssignArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statAssignArrayMult}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssignArrayMult(EloquenceParser.StatAssignArrayMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statBlock}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatBlock(EloquenceParser.StatBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statReturn}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatReturn(EloquenceParser.StatReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statIn}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatIn(EloquenceParser.StatInContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statOut}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatOut(EloquenceParser.StatOutContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statVoid}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatVoid(EloquenceParser.StatVoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#statBlockBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatBlockBody(EloquenceParser.StatBlockBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code targetId}
	 * labeled alternative in {@link EloquenceParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetId(EloquenceParser.TargetIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#newID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewID(EloquenceParser.NewIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#returnStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(EloquenceParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprComp}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprComp(EloquenceParser.ExprCompContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprCompound}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCompound(EloquenceParser.ExprCompoundContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMult}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMult(EloquenceParser.ExprMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprUnary}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnary(EloquenceParser.ExprUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNum}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNum(EloquenceParser.ExprNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprTrue}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTrue(EloquenceParser.ExprTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprChar}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprChar(EloquenceParser.ExprCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFunc}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFunc(EloquenceParser.ExprFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(EloquenceParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprPar}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPar(EloquenceParser.ExprParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAdd}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAdd(EloquenceParser.ExprAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(EloquenceParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprId}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprId(EloquenceParser.ExprIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFalse}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFalse(EloquenceParser.ExprFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprArray}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprArray(EloquenceParser.ExprArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayMulExpr}
	 * labeled alternative in {@link EloquenceParser#arrayExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayMulExpr(EloquenceParser.ArrayMulExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arraySingleExpr}
	 * labeled alternative in {@link EloquenceParser#arrayExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySingleExpr(EloquenceParser.ArraySingleExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(EloquenceParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#multiply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(EloquenceParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#addition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(EloquenceParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(EloquenceParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(EloquenceParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(EloquenceParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(EloquenceParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBool(EloquenceParser.TypeBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeChar}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeChar(EloquenceParser.TypeCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcVoid}
	 * labeled alternative in {@link EloquenceParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncVoid(EloquenceParser.FuncVoidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcReturn}
	 * labeled alternative in {@link EloquenceParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncReturn(EloquenceParser.FuncReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#functionID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionID(EloquenceParser.FunctionIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#voidFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidFunc(EloquenceParser.VoidFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#returnFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnFunc(EloquenceParser.ReturnFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(EloquenceParser.ParametersContext ctx);
}