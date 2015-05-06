package pp.block2.cc.antlr;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block2.cc.AST;
import pp.block2.cc.NonTerm;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;
import pp.block2.cc.antlr.*;
import pp.block2.cc.ll.Sentence;

public class Calculator extends ArithmeticBaseListener{
	
	private ParseTreeProperty<BigInteger> solutions = new ParseTreeProperty<BigInteger>();
	private boolean foundError = false;

	public BigInteger calculate(Lexer lexer){
		SentenceParser parser = new SentenceParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.sentence();
		new ParseTreeWalker().walk(this, tree);
		return null;
	}


	@Override public void exitExpr(ArithmeticParser.ExprContext ctx) { }


	@Override public void exitMult(ArithmeticParser.MultContext ctx) { }


	@Override public void exitDiv(ArithmeticParser.DivContext ctx) { }


	@Override public void exitAdd(ArithmeticParser.AddContext ctx) { }


	@Override public void exitSub(ArithmeticParser.SubContext ctx) { }


	@Override public void exitRightOp(ArithmeticParser.RightOpContext ctx) {
		solutions.put(ctx, solutions.get(ctx.getChild(0)).pow(solutions.get(ctx.getChild(2)).intValue()));
	}


	@Override public void visitTerminal(TerminalNode node) {
		System.out.println("visitTerminal");
		solutions.put(node, (BigInteger)node.getPayload());
	}


	@Override public void visitErrorNode(ErrorNode node) {
		solutions.put(node, (BigInteger)node.getPayload());
		foundError = true;
	}
}
