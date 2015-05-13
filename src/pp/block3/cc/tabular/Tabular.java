package pp.block3.cc.tabular;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
public class Tabular extends TabularBaseListener{
	
	String result= "";
	
	@Override public void enterLatex(TabularParser.LatexContext ctx) {
		result += ("<html><body><table border=\"1\">");
	}
	
	@Override public void exitLatex(TabularParser.LatexContext ctx) {
		result += ("</table></body></body>");
	}
	
	@Override public void enterTabLine(TabularParser.TabLineContext ctx) {
		result += ("<tr><td>");
	}
	
	@Override public void exitTabLine(TabularParser.TabLineContext ctx) {
		result += ("</td></tr>");
	}
	
	@Override public void enterText(TabularParser.TextContext ctx) {
		result += (ctx.getText());
	}
	
	@Override public void enterAnd(TabularParser.AndContext ctx) {
		result += ("</td><td>"); 
	}
	
	public void writeFile(){
		try {
			Writer writer = new FileWriter("output.html");
			writer.write(result);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		walker.walk(this, tree);								// Walking the tree
		
		if(listener.getErrorMessages().size()>0){
			System.out.println(listener.getErrorMessages());
			return false;}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true; 
	}
	

	public static void main(String args[]){
		Tabular myTabular = new Tabular();
		if(args.length >0){
			if(myTabular.init(args[0])){
				myTabular.writeFile();
			}
		}else{System.out.println("No file was specified.");}
	}
}
