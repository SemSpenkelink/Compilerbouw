// Generated from Eloquence.g4 by ANTLR 4.4
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
	 * Visit a parse tree produced by {@link EloquenceParser#arrayElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElem(@NotNull EloquenceParser.ArrayElemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statVoid}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatVoid(@NotNull EloquenceParser.StatVoidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varArrayDecl}
	 * labeled alternative in {@link EloquenceParser#arrayDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarArrayDecl(@NotNull EloquenceParser.VarArrayDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#newID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewID(@NotNull EloquenceParser.NewIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paramVal}
	 * labeled alternative in {@link EloquenceParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamVal(@NotNull EloquenceParser.ParamValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMult}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMult(@NotNull EloquenceParser.ExprMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprUnary}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnary(@NotNull EloquenceParser.ExprUnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull EloquenceParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(@NotNull EloquenceParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(@NotNull EloquenceParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFunc}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFunc(@NotNull EloquenceParser.ExprFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(@NotNull EloquenceParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcReturn}
	 * labeled alternative in {@link EloquenceParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncReturn(@NotNull EloquenceParser.FuncReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paramRef}
	 * labeled alternative in {@link EloquenceParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamRef(@NotNull EloquenceParser.ParamRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#voidFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidFunc(@NotNull EloquenceParser.VoidFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprPar}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPar(@NotNull EloquenceParser.ExprParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAdd}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAdd(@NotNull EloquenceParser.ExprAddContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#returnStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(@NotNull EloquenceParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeChar}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeChar(@NotNull EloquenceParser.TypeCharContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#addition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(@NotNull EloquenceParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code targetId}
	 * labeled alternative in {@link EloquenceParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetId(@NotNull EloquenceParser.TargetIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNum}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNum(@NotNull EloquenceParser.ExprNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprChar}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprChar(@NotNull EloquenceParser.ExprCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statOut}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatOut(@NotNull EloquenceParser.StatOutContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#functionID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionID(@NotNull EloquenceParser.FunctionIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#arrayTypeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypeDecl(@NotNull EloquenceParser.ArrayTypeDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcVoid}
	 * labeled alternative in {@link EloquenceParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncVoid(@NotNull EloquenceParser.FuncVoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#returnFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnFunc(@NotNull EloquenceParser.ReturnFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statAssignArrayMult}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssignArrayMult(@NotNull EloquenceParser.StatAssignArrayMultContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(@NotNull EloquenceParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprCompound}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCompound(@NotNull EloquenceParser.ExprCompoundContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statAssignArray}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssignArray(@NotNull EloquenceParser.StatAssignArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statBlock}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatBlock(@NotNull EloquenceParser.StatBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statWhile}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatWhile(@NotNull EloquenceParser.StatWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statIn}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatIn(@NotNull EloquenceParser.StatInContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull EloquenceParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(@NotNull EloquenceParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprId}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprId(@NotNull EloquenceParser.ExprIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statIf}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatIf(@NotNull EloquenceParser.StatIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#multiply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(@NotNull EloquenceParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declArray}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclArray(@NotNull EloquenceParser.DeclArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprComp}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprComp(@NotNull EloquenceParser.ExprCompContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull EloquenceParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declConstVar}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclConstVar(@NotNull EloquenceParser.DeclConstVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constArrayDecl}
	 * labeled alternative in {@link EloquenceParser#arrayDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstArrayDecl(@NotNull EloquenceParser.ConstArrayDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statExpr}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatExpr(@NotNull EloquenceParser.StatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprTrue}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTrue(@NotNull EloquenceParser.ExprTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBool(@NotNull EloquenceParser.TypeBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#statBlockBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatBlockBody(@NotNull EloquenceParser.StatBlockBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declVar}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclVar(@NotNull EloquenceParser.DeclVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link EloquenceParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(@NotNull EloquenceParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link EloquenceParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull EloquenceParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssign(@NotNull EloquenceParser.StatAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFalse}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFalse(@NotNull EloquenceParser.ExprFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statReturn}
	 * labeled alternative in {@link EloquenceParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatReturn(@NotNull EloquenceParser.StatReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprArray}
	 * labeled alternative in {@link EloquenceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprArray(@NotNull EloquenceParser.ExprArrayContext ctx);
}