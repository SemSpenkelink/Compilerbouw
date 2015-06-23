// Generated from Eloquence.g4 by ANTLR 4.5
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
	 * Enter a parse tree produced by the {@code declConstArray}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclConstArray(EloquenceParser.DeclConstArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declConstArray}
	 * labeled alternative in {@link EloquenceParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclConstArray(EloquenceParser.DeclConstArrayContext ctx);
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
	 * Enter a parse tree produced by {@link EloquenceParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayDecl(EloquenceParser.ArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayDecl(EloquenceParser.ArrayDeclContext ctx);
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
	 * Enter a parse tree produced by the {@code unaryMin}
	 * labeled alternative in {@link EloquenceParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMin(EloquenceParser.UnaryMinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMin}
	 * labeled alternative in {@link EloquenceParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMin(EloquenceParser.UnaryMinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryPlus}
	 * labeled alternative in {@link EloquenceParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPlus(EloquenceParser.UnaryPlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryPlus}
	 * labeled alternative in {@link EloquenceParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPlus(EloquenceParser.UnaryPlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryNot}
	 * labeled alternative in {@link EloquenceParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnaryNot(EloquenceParser.UnaryNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryNot}
	 * labeled alternative in {@link EloquenceParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnaryNot(EloquenceParser.UnaryNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMult}
	 * labeled alternative in {@link EloquenceParser#multiply}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMult(EloquenceParser.UnaryMultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMult}
	 * labeled alternative in {@link EloquenceParser#multiply}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMult(EloquenceParser.UnaryMultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryDiv}
	 * labeled alternative in {@link EloquenceParser#multiply}.
	 * @param ctx the parse tree
	 */
	void enterUnaryDiv(EloquenceParser.UnaryDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryDiv}
	 * labeled alternative in {@link EloquenceParser#multiply}.
	 * @param ctx the parse tree
	 */
	void exitUnaryDiv(EloquenceParser.UnaryDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMod}
	 * labeled alternative in {@link EloquenceParser#multiply}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMod(EloquenceParser.UnaryModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMod}
	 * labeled alternative in {@link EloquenceParser#multiply}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMod(EloquenceParser.UnaryModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addPlus}
	 * labeled alternative in {@link EloquenceParser#addition}.
	 * @param ctx the parse tree
	 */
	void enterAddPlus(EloquenceParser.AddPlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addPlus}
	 * labeled alternative in {@link EloquenceParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitAddPlus(EloquenceParser.AddPlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addMin}
	 * labeled alternative in {@link EloquenceParser#addition}.
	 * @param ctx the parse tree
	 */
	void enterAddMin(EloquenceParser.AddMinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addMin}
	 * labeled alternative in {@link EloquenceParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitAddMin(EloquenceParser.AddMinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compLess}
	 * labeled alternative in {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompLess(EloquenceParser.CompLessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compLess}
	 * labeled alternative in {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompLess(EloquenceParser.CompLessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compLessEq}
	 * labeled alternative in {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompLessEq(EloquenceParser.CompLessEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compLessEq}
	 * labeled alternative in {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompLessEq(EloquenceParser.CompLessEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compGreatEq}
	 * labeled alternative in {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompGreatEq(EloquenceParser.CompGreatEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compGreatEq}
	 * labeled alternative in {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompGreatEq(EloquenceParser.CompGreatEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compGreat}
	 * labeled alternative in {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompGreat(EloquenceParser.CompGreatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compGreat}
	 * labeled alternative in {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompGreat(EloquenceParser.CompGreatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compEq}
	 * labeled alternative in {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompEq(EloquenceParser.CompEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compEq}
	 * labeled alternative in {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompEq(EloquenceParser.CompEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compNotEq}
	 * labeled alternative in {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompNotEq(EloquenceParser.CompNotEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compNotEq}
	 * labeled alternative in {@link EloquenceParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompNotEq(EloquenceParser.CompNotEqContext ctx);
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
	 * Enter a parse tree produced by {@link EloquenceParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(EloquenceParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link EloquenceParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(EloquenceParser.FuncContext ctx);
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
}