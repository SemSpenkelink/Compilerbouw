package pp.huiswerk;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.Lexer;

import pp.huiswerk.SymbolTableImplHW;
import pp.huiswerk.TypeUseParser.ProgramContext;

public class TypeChecker extends TypeUseBaseListener{
	SymbolTableImplHW myImpl;
	ParseTreeProperty<String> errors = new ParseTreeProperty<String>();
	public List<String> errorStrings = new ArrayList<String>();
	
	public void init(){
		myImpl = new SymbolTableImplHW();
	}
	
	@Override public void enterProgram(TypeUseParser.ProgramContext ctx) {}
	
	@Override public void exitProgram(TypeUseParser.ProgramContext ctx) { }
	
	@Override public void enterSeries(TypeUseParser.SeriesContext ctx) {
		myImpl.openScope();
	}
	
	@Override public void exitSeries(TypeUseParser.SeriesContext ctx) { 
		myImpl.closeScope();
	}
	
	@Override public void enterDec(TypeUseParser.DecContext ctx) {
		
	}
	
	@Override public void exitDec(TypeUseParser.DecContext ctx) { }
	
	@Override public void enterAss(TypeUseParser.AssContext ctx) { }
	
	@Override public void exitAss(TypeUseParser.AssContext ctx) { }
	
	@Override public void enterSer(TypeUseParser.SerContext ctx) { }
	
	@Override public void exitSer(TypeUseParser.SerContext ctx) { }
	
	@Override public void enterDecl(TypeUseParser.DeclContext ctx) {
		if(!myImpl.add(ctx.ID(0).getText()+ ":" +ctx.ID(1).getText())){
			System.out.println(createErrorMessage(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
			errors.put(ctx, createErrorMessage(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
			errorStrings.add(createErrorMessage(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
		}
	}
	
	@Override public void exitDecl(TypeUseParser.DeclContext ctx) { }
	
	@Override public void enterAssign(TypeUseParser.AssignContext ctx) { }
	
	@Override public void exitAssign(TypeUseParser.AssignContext ctx) {
		if(!myImpl.contains(ctx.ID(0).getText()) && !myImpl.contains(ctx.ID(1).getText()) && !(myImpl.getType(ctx.ID(0).getText()).equals(myImpl.getType(ctx.ID(1).getText())))){
			System.out.println(createErrorMessage(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
			errors.put(ctx, createErrorMessage(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
			errorStrings.add(createErrorMessage(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
		}
	}

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(ParserRuleContext ctx) { }

	@Override public void visitTerminal(TerminalNode node) { }
	
	@Override public void visitErrorNode(ErrorNode node) { }
	
	public String createErrorMessage(int line, int charPos){
		return "Found error at line " + line + ", position " + charPos + ".";
	}
	
	private String getMessage(ParseTree ctx){
		String text = ctx.getText();
		if(text.startsWith("ID:ID"))
			return text.substring(2);
		else
			return text;
	}
	
	public static void main(String args[]){
		String text = "";
		ParseTreeWalker walker = new ParseTreeWalker();
		TypeChecker gram = new TypeChecker();
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new TypeUseLexer(chars);
		TokenStream tokens = new CommonTokenStream(lexer);
		TypeUseParser parser = new TypeUseParser(tokens);
		
		ParseTree tree= parser.program();
		gram.init();
		walker.walk(gram, tree);
	}
	
}
