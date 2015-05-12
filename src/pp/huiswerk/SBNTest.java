package pp.huiswerk;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pp.huiswerk.SBNBaseListener;
import pp.huiswerk.SBNLexer;
import pp.huiswerk.SBNParser;

import pp.huiswerk.SBNParser.NumberContext;

public class SBNTest {
	
	public void init(){
		
	}
	
	
	public void test(int expected, String expr){
		assertEquals(expected, parseSBNAttr(expr));
	}
	
	private NumberContext parseSBNAttr(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new SBNLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		SBNParser parser = new SBNParser(tokens);
		return parser.number();
	}
	
}
