package pp.block3.cc.tabular;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
public class Tabular extends TabularBaseListener{
	
	String result= "";
	
	@Override public void enterLatex(TabularParser.LatexContext ctx) {
		result.concat("<html><body><table border=\"1\">");
	}
	
	@Override public void exitLatex(TabularParser.LatexContext ctx) {
		result.concat("</table></body></body>");
	}
	
	@Override public void enterBegin(TabularParser.BeginContext ctx) { }
	
	@Override public void exitBegin(TabularParser.BeginContext ctx) { }
	
	@Override public void enterBegType(TabularParser.BegTypeContext ctx) { }
	
	@Override public void exitBegType(TabularParser.BegTypeContext ctx) { }
	
	@Override public void enterArg(TabularParser.ArgContext ctx) { }
	
	@Override public void exitArg(TabularParser.ArgContext ctx) { }
	
	@Override public void enterTabLine(TabularParser.TabLineContext ctx) {
		result.concat("<tr><td>");
	}
	
	@Override public void exitTabLine(TabularParser.TabLineContext ctx) {
		result.concat("</tr>");
	}

	@Override public void enterEnd(TabularParser.EndContext ctx) { }

	@Override public void exitEnd(TabularParser.EndContext ctx) { }
	
	@Override public void enterEndType(TabularParser.EndTypeContext ctx) { }

	@Override public void exitEndType(TabularParser.EndTypeContext ctx) { }

	
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(ParserRuleContext ctx) { }

	@Override public void visitTerminal(TerminalNode node) { }
	
	@Override public void visitErrorNode(ErrorNode node) { }
	
	
	public static void main(String args[]){
		if(args.length >0){
			new Tabular().init(args[0]);
		}else{System.out.println("No file was specified.");}
	}
	
	private boolean init(String text) {
		CharStream chars;
		try {
			chars = new ANTLRInputStream(new FileReader(text));
		
		Lexer tabLexer = new TabularLexer(chars);
		
		tabLexer.removeErrorListeners();			//
		MyListener listener = new MyListener();		//	Adding custom error listener
		tabLexer.addErrorListener(listener);		//
		
		TokenStream tokens2 = new CommonTokenStream(tabLexer);	//
		TabularParser parser2 = new TabularParser(tokens2);		//
		ParseTree tree=parser2.latex();							// 
		ParseTreeWalker walker = new ParseTreeWalker();			//
		walker.walk(new Tabular(), tree);						// Walking the tree
		
		if(listener.getErrorMessages().size()>0){return false;}
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true; 
	}
}
