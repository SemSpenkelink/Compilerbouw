package pp.s1367102.q1_4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import pp.s1367102.q1_4.SBNLexer;
import pp.s1367102.q1_4.SBNParser;
import pp.s1367102.q1_4.SBNParser.NumberContext;

public class SBNTest {
	
	private final ParseTreeWalker walker = new ParseTreeWalker();
	private final SBN2 gram = new SBN2();
	
	@Test
	public void init(){
		test(41,"+101001");
		test(-41,"-0101001");
		test(21,"+0010101");
		test(-15,"-1111");
		test(111,"+01101111");
		test(83,"+01010011");
		test(83,"+1010011");
	}
	
	
	public void test(int expected, String expr){
		//System.out.println("Expected: " + expected + " Parse: " + parseSBNAttr(expr).value);
		//assertEquals(expected, parseSBNAttr(expr).value);
		ParseTree tree = parseSBN(expr);
		gram.init();
		walker.walk(gram, tree);
		assertEquals(expected, gram.res(tree));
	}
	
	 private ParseTree parseSBN(String text){
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new SBN2Lexer(chars);
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
