package pp.huiswerk;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.huiswerk.SymbolTableImplHW;

public class TypeChecker extends TypeUseBaseListener{
	SymbolTableImplHW myImpl;
	
	public void init(){
		myImpl = new SymbolTableImplHW();
	}
	
	@Override public void enterProgram(TypeUseParser.ProgramContext ctx) { }
	
	@Override public void exitProgram(TypeUseParser.ProgramContext ctx) { }
	
	@Override public void enterSeries(TypeUseParser.SeriesContext ctx) { }
	
	@Override public void exitSeries(TypeUseParser.SeriesContext ctx) { }
	
	@Override public void enterDec(TypeUseParser.DecContext ctx) { }
	
	@Override public void exitDec(TypeUseParser.DecContext ctx) { }
	
	@Override public void enterAss(TypeUseParser.AssContext ctx) { }
	
	@Override public void exitAss(TypeUseParser.AssContext ctx) { }
	
	@Override public void enterSer(TypeUseParser.SerContext ctx) { }
	
	@Override public void exitSer(TypeUseParser.SerContext ctx) { }
	
	@Override public void enterDecl(TypeUseParser.DeclContext ctx) { }
	
	@Override public void exitDecl(TypeUseParser.DeclContext ctx) { }
	
	@Override public void enterAssign(TypeUseParser.AssignContext ctx) { }
	
	@Override public void exitAssign(TypeUseParser.AssignContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(ParserRuleContext ctx) { }

	@Override public void visitTerminal(TerminalNode node) { }
	
	@Override public void visitErrorNode(ErrorNode node) { }
}
