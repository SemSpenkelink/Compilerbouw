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

import pp.block3.cc.antlr.TGrammar;
import pp.block3.cc.antlr.TGrammarListenerLexer;
import pp.block3.cc.antlr.TGrammarListenerParser;
import pp.huiswerk.SBNBaseListener;
import pp.huiswerk.SBNLexer;
import pp.huiswerk.SBNParser;
import pp.huiswerk.SBNParser.NumberContext;
import pp.huiswerk42.SBN2;
import pp.huiswerk42.SBN2Lexer;
import pp.huiswerk42.SBN2Parser;

public class SBNTest {
	
	private final ParseTreeWalker walker = new ParseTreeWalker();
	private final SBN2 gram = new SBN2();
	
	@Test
	public void init(){
		test(41,"+101001");
	}
	
	
	public void test(int expected, String expr){
		System.out.println("Expected: " + expected + " Parse: " + parseSBNAttr(expr).val);
		assertEquals(expected, parseSBNAttr(expr).val);
		
		ParseTree tree = parseSBN(expr);
		gram.init();
		walker.walk(gram, tree);
		
	}
	
	 private ParseTree parseSBN(String text){
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new SBNLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		SBN2Parser parser = new SBN2Parser(tokens);
		return parser.number();
	}
	
	
	private NumberContext parseSBNAttr(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new SBNLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		SBNParser parser = new SBNParser(tokens);
		return parser.number();
	}
	
}
