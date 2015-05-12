package pp.block3.cc.symbol;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block3.cc.symbol.DeclUseParser.DeclContext;
import pp.block3.cc.symbol.SymbolTableImpl;


public class DeclUse extends DeclUseBaseListener{
	
	ParseTreeProperty<String> errors = new ParseTreeProperty<String>();
	List<String> errorStrings = new ArrayList<String>();
	
	SymbolTableImpl sti;
	
	public void init(){
		sti = new SymbolTableImpl();
	}
	
	public boolean contains(String id){
		return sti.contains(id);
	}
	
	@Override public void enterUs(@NotNull DeclUseParser.UsContext ctx) {
		
	}
	
	@Override public void exitUs(@NotNull DeclUseParser.UsContext ctx) {
		
	}
	
	@Override public void enterDec(@NotNull DeclUseParser.DecContext ctx) { }

	@Override public void enterSer(@NotNull DeclUseParser.SerContext ctx) {
		sti.openScope();
	}
	
	@Override public void exitSer(@NotNull DeclUseParser.SerContext ctx) {
		sti.closeScope();
	}
	 
	@Override public void exitDec(@NotNull DeclUseParser.DecContext ctx) { }
	
	@Override public void enterDecl(@NotNull DeclUseParser.DeclContext ctx) {
		
	}
	
	@Override public void exitDecl(@NotNull DeclUseParser.DeclContext ctx) {
		if(!sti.add(getMessage(ctx))){
			System.out.println(createErrorMessage(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
			errors.put(ctx, createErrorMessage(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
			errorStrings.add(createErrorMessage(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
		}
	}

	@Override public void enterSeries(@NotNull DeclUseParser.SeriesContext ctx) { }

	@Override public void exitSeries(@NotNull DeclUseParser.SeriesContext ctx) { }

	@Override public void enterUse(@NotNull DeclUseParser.UseContext ctx) {
		System.out.println(getMessage(ctx));
		if(!sti.contains(getMessage(ctx))){
			System.out.println(createErrorMessage(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
			errors.put(ctx, createErrorMessage(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
			errorStrings.add(createErrorMessage(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
		}else{
			sti.add(getMessage(ctx));
		}
	}

	@Override public void exitUse(@NotNull DeclUseParser.UseContext ctx) {  }

	@Override public void enterProgram(@NotNull DeclUseParser.ProgramContext ctx) {
		sti.openScope();
	}

	@Override public void exitProgram(@NotNull DeclUseParser.ProgramContext ctx) {
		sti.closeScope();
	}

	@Override public void enterEveryRule(@NotNull ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(@NotNull ParserRuleContext ctx) { }
	
	@Override public void visitTerminal(@NotNull TerminalNode node) { }

	@Override public void visitErrorNode(@NotNull ErrorNode node) { }
	
	private String createErrorMessage(int line, int charPos){
		return "Found error at line " + line + ", position " + charPos + ".";
	}
	
	private String getMessage(ParseTree ctx){
		String text = ctx.getText();
		if(text.startsWith("D:") || text.startsWith("U:"))
			return text.substring(2);
		else
			return text;
	}
}

