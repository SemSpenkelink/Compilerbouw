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

import pp.block3.cc.symbol.DeclUse;
import pp.block3.cc.symbol.DeclUseLexer;
import pp.block3.cc.symbol.DeclUseParser;
import pp.block3.cc.symbol.SymbolTable;
import pp.block3.cc.symbol.SymbolTableImpl;


public class SymbolTableTest {
	private SymbolTable table;
	private DeclUse declUse;
	private final ParseTreeWalker walker = new ParseTreeWalker();
	
	@Before
	public void initTable() {
		table = new SymbolTableImpl();// construct an instance of your implementation
		declUse = new DeclUse();
	}
	
	@Test
	public void testListener(){
		List<String> expected = new ArrayList<String>();
		expected.add(declUse.createErrorMessage(1, 7));
		expected.add(declUse.createErrorMessage(1, 14));
		expected.add(declUse.createErrorMessage(1, 36));
		test(expected, "myFile.txt");
	}
	
	public void test(List<String> expected, String fileName){
		ParseTree tree = parseDecl(fileName);
		declUse.init();
		walker.walk(declUse, tree);
		assertEquals(expected, declUse.errorStrings);
	}
	
	private ParseTree parseDecl(String text){
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
	
	@Test
	public void testEmpty() {
		try {
			table.contains("aap");
		} catch (RuntimeException e) {
			Assert.fail("Using an empty table should not fail");
			// this is the expected behaviour
		}
		try {
			table.closeScope();
			Assert.fail("Closing the top-level scope should fail");
		} catch (RuntimeException e) {
			// this is the expected behaviour
		}
		table.openScope();
		table.closeScope();
		try {
			table.closeScope();
			Assert.fail("Closing the top-level scope should fail");
		} catch (RuntimeException e) {
			// this is the expected behaviour
		}
	}

	@Test
	public void testLookup() {
		assertFalse(table.contains("aap"));
		assertTrue(table.add("aap"));
		assertTrue(table.contains("aap"));
		assertFalse(table.add("aap"));
		assertFalse(table.contains("noot"));
		table.openScope();
		assertTrue(table.contains("aap"));
		assertFalse(table.contains("noot"));
		assertTrue(table.add("aap"));
		assertTrue(table.add("noot"));
		table.closeScope();
		assertTrue(table.contains("aap"));
		assertFalse(table.contains("noot"));
	}

	@Test
	public void testNesting() {
		table.openScope();
		assertTrue(table.add("aap"));
		table.openScope();
		assertTrue(table.add("aap"));
		table.openScope();
		assertTrue(table.contains("aap"));
		assertTrue(table.add("noot"));
		assertTrue(table.contains("noot"));
		table.closeScope();
		assertFalse(table.contains("noot"));
		table.openScope();
		assertFalse(table.contains("noot"));
		assertTrue(table.add("noot"));
		assertTrue(table.contains("noot"));
		table.closeScope();
		assertFalse(table.contains("noot"));
		table.closeScope();
		table.closeScope();
		assertFalse(table.contains("aap"));
		assertFalse(table.contains("noot"));
	}
}
