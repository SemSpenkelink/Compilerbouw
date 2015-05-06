package pp.block2.cc.antlr;

import java.math.BigInteger;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block2.cc.AST;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;

public class Calculator extends ArithmeticBaseListener{
	
	private ParseTreeProperty<Integer> solutions = new ParseTreeProperty<Integer>();

	public BigInteger calculate(){
		
		return null;
	}


	@Override public void exitExpr(ArithmeticParser.ExprContext ctx) { }


	@Override public void exitMult(ArithmeticParser.MultContext ctx) { }


	@Override public void exitDiv(ArithmeticParser.DivContext ctx) { }


	@Override public void exitAdd(ArithmeticParser.AddContext ctx) { }


	@Override public void exitSub(ArithmeticParser.SubContext ctx) { }


	@Override public void exitRightOp(ArithmeticParser.RightOpContext ctx) { }


	@Override public void exitEveryRule(ParserRuleContext ctx) { }


	@Override public void visitTerminal(TerminalNode node) { }


	@Override public void visitErrorNode(ErrorNode node) { }
	
}
