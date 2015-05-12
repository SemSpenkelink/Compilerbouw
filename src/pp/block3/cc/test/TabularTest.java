package pp.block3.cc.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import pp.block3.cc.antlr.TGrammarListenerLexer;
import pp.block3.cc.antlr.TGrammarListenerParser;
import pp.block3.cc.symbol.DeclUse;
import pp.block3.cc.symbol.DeclUseLexer;
import pp.block3.cc.symbol.DeclUseParser;
import pp.block3.cc.symbol.SymbolTable;
import pp.block3.cc.symbol.SymbolTableImpl;


public class TabularTest {
	
	@Test
	public void tabTest(){
		test(null, "tabular-1.tex");
	}
	
	
	public void test(List<String> expected, String fileName){
		ParseTree tree = parseTab(fileName);
	}
	
	private ParseTree parseTab(String text){
		CharStream chars;
		try {
			chars = new ANTLRInputStream(new FileReader(text));
	
		Lexer lexer = new DeclUseLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		DeclUseParser parser = new DeclUseParser(tokens);
		
			return parser.program();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
