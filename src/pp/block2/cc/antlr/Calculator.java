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
	
	private ParseTreeProperty<String> solutions;
	private boolean foundError = false;

	public BigInteger calculate(Lexer lexer){
		solutions = new ParseTreeProperty<String>();
		ArithmeticParser parser = new ArithmeticParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.expr();
		new ParseTreeWalker().walk(this, tree);
		return new BigInteger(solutions.get(tree));
	}
	
	@Override public void exitDiv(ArithmeticParser.DivContext ctx) {
		BigInteger value = new BigInteger(solutions.get(ctx.getChild(0))).divide(new BigInteger(solutions.get(ctx.getChild(2))));
		solutions.put(ctx, value.toString());
	}
	
	@Override public void exitAdd(ArithmeticParser.AddContext ctx) {
		BigInteger value = new BigInteger(solutions.get(ctx.getChild(0))).add(new BigInteger(solutions.get(ctx.getChild(2))));
		solutions.put(ctx, value.toString());
	}
	
	@Override public void exitSub(ArithmeticParser.SubContext ctx) {
		BigInteger value = new BigInteger(solutions.get(ctx.getChild(0))).subtract(new BigInteger(solutions.get(ctx.getChild(2))));
		solutions.put(ctx, value.toString());
	}

	@Override public void exitMul(ArithmeticParser.MulContext ctx) {
		BigInteger value = new BigInteger(solutions.get(ctx.getChild(0))).multiply(new BigInteger(solutions.get(ctx.getChild(2))));
		solutions.put(ctx, value.toString());
	}
	
	@Override public void exitName(ArithmeticParser.NameContext ctx) {
		solutions.put(ctx, solutions.get(ctx.getChild(0)));
	}
	
	@Override public void exitPow(ArithmeticParser.PowContext ctx) {
		BigInteger value = new BigInteger(solutions.get(ctx.getChild(0))).pow(Integer.parseInt(solutions.get(ctx.getChild(2))));
		solutions.put(ctx, value.toString());
		
	}	
	
	@Override public void visitTerminal(TerminalNode node) {
		solutions.put(node, node.getSymbol().getText());
	}


	@Override public void visitErrorNode(ErrorNode node) {
		solutions.put(node, null);
		foundError = true;
	}
}
