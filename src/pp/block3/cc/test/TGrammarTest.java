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


import pp.block3.cc.antlr.TGram.Lexer;
import pp.block3.cc.antlr.TGram.Parser;
import pp.block3.cc.antlr.TGram.ParserTContext;


import pp.block3.cc.antlr.CalcAttrLexer;
import pp.block3.cc.antlr.CalcAttrParser;
import pp.block3.cc.antlr.TGrammarListenerLexer;
import pp.block3.cc.antlr.TGrammarListenerParser;
import pp.block3.cc.antlr.TGrammar;
import pp.block3.cc.antlr.CalcAttrParser.ExprContext;

public class TGrammarTest {
	
	private final ParseTreeWalker walker = new ParseTreeWalker();
	private final TGrammar gram = new TGrammar();
	
	
	@Test
	public void test(){
		
	}
	
	private ParseTree parseTGram(String text){
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new TGrammarListenerLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		TGrammarListenerParser parser = new TGrammarListenerParser(tokens);
		return parser.t();
	}
	
	private ExprContext parseTGramAttr(String text) {
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new TGramLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		TGramParser parser = new TGramParser(tokens);
		return parser.t();
	}
	
}
