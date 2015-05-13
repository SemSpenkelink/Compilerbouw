package pp.block3.cc.tabular;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
		result.concat("</td></tr>");
	}
	
	
	@Override public void enterText(TabularParser.TextContext ctx) {
		result.concat(ctx.getText()); //nog ff checkke 
		System.out.println(ctx.getText());
	}
	
	@Override public void exitText(TabularParser.TextContext ctx) { }
	
	@Override public void enterAnd(TabularParser.AndContext ctx) {
		result.concat("</td><td>"); 
		}

	@Override public void exitAnd(TabularParser.AndContext ctx) { }
	

	@Override public void enterEnd(TabularParser.EndContext ctx) { }

	@Override public void exitEnd(TabularParser.EndContext ctx) {
	//	result.concat("");
	}
	
	@Override public void enterEndType(TabularParser.EndTypeContext ctx) { }

	@Override public void exitEndType(TabularParser.EndTypeContext ctx) { }

	
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(ParserRuleContext ctx) { }

	@Override public void visitTerminal(TerminalNode node) { }
	
	@Override public void visitErrorNode(ErrorNode node) { }
	
	public void writeFile(){
		PrintWriter writer;
		try {
			writer = new PrintWriter("output.html", "UTF-8");
		
		writer.println(result);
		writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		Tabular myTabular = new Tabular();
		if(args.length >0){
			if(myTabular.init(args[0])){
				myTabular.writeFile();
				}
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
