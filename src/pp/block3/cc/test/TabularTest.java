package pp.block3.cc.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

import pp.block3.cc.tabular.*;


public class TabularTest {
	
	@Test
	public void tabTest(){
		test(null, "tabular-1.tex");
		test(null, "tabular-2.tex");
		test(null, "tabular-3.tex");
	}
	
	
	public void test(List<String> expected, String fileName){
		ParseTree tree = parseTab(fileName);
	}
	
	private ParseTree parseTab(String text){
		CharStream chars;
		try {
			chars = new ANTLRInputStream(new FileReader(text));
	
		Lexer lexer = new TabularLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		TabularParser parser = new TabularParser(tokens);
		
			return parser.latex();
			
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
