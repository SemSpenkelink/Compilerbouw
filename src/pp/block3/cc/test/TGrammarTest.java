package pp.block3.cc.test;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


import pp.block3.cc.antlr.TGramLexer;
import pp.block3.cc.antlr.TGramParser;
import pp.block3.cc.antlr.TGramParser.TContext;


import pp.block3.cc.antlr.CalcAttrLexer;
import pp.block3.cc.antlr.CalcAttrParser;
import pp.block3.cc.antlr.TGrammarListenerLexer;
import pp.block3.cc.antlr.TGrammarListenerParser;
import pp.block3.cc.antlr.TGrammar;

public class TGrammarTest {
	
	private final ParseTreeWalker walker = new ParseTreeWalker();
	private final TGrammar gram = new TGrammar();
	
	@Test
	public void test(){
		test(9, "3^2");
		test(5, "3+2");
		test(true, "3=3");
		test(false, "3=2");
		test("hahahahaha", "ha^5");
		test("haha", "ha+ha");
		test(true, "ha=ha");
		test(false, "ha=hi");
		test(true, "true+false");
		test(false, "false+false");
		test(true, "true+true");
		test(true, "true=true");
		test(false, "TRUE=true");
		test(false, "1=true");
	}
	
	public void test(int expected, String expr){
		assertEquals(expected, parseTGramAttr(expr).intVal);
		ParseTree tree = parseTGram(expr);
		gram.init();
		walker.walk(gram, tree);
		assertEquals(expected, gram.intVal(tree));
	}
	
	
	public void test(String expected, String expr){
		assertEquals(expected, parseTGramAttr(expr).strVal);
		ParseTree tree = parseTGram(expr);
		gram.init();
		walker.walk(gram, tree);
		assertEquals(expected, gram.strVal(tree));
	}
	
	
	public void test(boolean expected, String expr){
		assertEquals(expected, parseTGramAttr(expr).boolVal);
		ParseTree tree = parseTGram(expr);
		gram.init();
		walker.walk(gram, tree);
		assertEquals(expected, gram.boolVal(tree));
	}
	
	private ParseTree parseTGram(String text){
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new TGrammarListenerLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		TGrammarListenerParser parser = new TGrammarListenerParser(tokens);
		return parser.t();
	}
	
	private TContext parseTGramAttr(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new TGramLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		TGramParser parser = new TGramParser(tokens);
		return parser.t();
	}
	
}
