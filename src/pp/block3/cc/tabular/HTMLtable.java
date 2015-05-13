package pp.block3.cc.tabular;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class HTMLtable extends HTMLtableBaseListener{
	
	@Override public void enterEntry(@NotNull HTMLtableParser.EntryContext ctx) { }
	
	@Override public void exitEntry(@NotNull HTMLtableParser.EntryContext ctx) { }
	
	@Override public void enterDoc(@NotNull HTMLtableParser.DocContext ctx) { }
	
	@Override public void exitDoc(@NotNull HTMLtableParser.DocContext ctx) { }
	
	@Override public void enterRow(@NotNull HTMLtableParser.RowContext ctx) { }
	
	@Override public void exitRow(@NotNull HTMLtableParser.RowContext ctx) { }
	
	@Override public void enterTable(@NotNull HTMLtableParser.TableContext ctx) { }
	
	@Override public void exitTable(@NotNull HTMLtableParser.TableContext ctx) { }

	
	@Override public void enterEveryRule(@NotNull ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(@NotNull ParserRuleContext ctx) { }
	
	@Override public void visitTerminal(@NotNull TerminalNode node) { }
	
	@Override public void visitErrorNode(@NotNull ErrorNode node) { }
	
	public static void  main(String args[]){
		HTMLtable myTable = new HTMLtable();
		
		
		ParseTreeWalker walker = new ParseTreeWalker();
		ParseTree tree = myTable.init("myFile.txt");
		if(tree != null){
			walker.walk(myTable, tree);
		}
	}

	private ParseTree init(String text) {
		CharStream chars;
		try {
			chars = new ANTLRInputStream(new FileReader(text));
			
	////////////////////////////////////////////////////////////////	
		//Create a tabular Lexer and check for errors
		Lexer tabLexer = new TabularLexer(chars);
		tabLexer.removeErrorListeners();
		
		MyListener listener = new MyListener();
		tabLexer.addErrorListener(listener);
		TokenStream tokens2 = new CommonTokenStream(tabLexer);
		TabularParser parser2 = new TabularParser(tokens2);
		ParseTree tree;
		tree = parser2.latex();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(new HTMLtable(), tree);
		
		if(listener.getErrorMessages().size()>0){return null;}
	////////////////////////////////////////////////////////////////
		//Else create a HTMLtableLexer and return parser.doc();
		Lexer lexer = new HTMLtableLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		HTMLtableParser parser = new HTMLtableParser(tokens);
		return parser.doc();
		
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
