package pp.block3.cc.antlr;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block3.cc.antlr.TGrammarListenerParser.TContext;

public class TGrammar extends TGrammarListenerBaseListener{
	
	/** Map storing the val attribute for all parse tree nodes. */
	private ParseTreeProperty<Integer> intVal;
	private ParseTreeProperty<Boolean> boolVal;
	private ParseTreeProperty<Type> typeVal;
	private ParseTreeProperty<String> strVal;
	
	
	public void init(){
		intVal = new ParseTreeProperty<Integer>();
		boolVal = new ParseTreeProperty<Boolean>();
		typeVal = new ParseTreeProperty<Type>();
		strVal = new ParseTreeProperty<String>();
		
	}

	@Override public void enterT(@NotNull TGrammarListenerParser.TContext ctx) {
		if(true){
			
		}
	}

	@Override public void exitT(@NotNull TGrammarListenerParser.TContext ctx) { 
		
	}


	@Override public void enterEveryRule(@NotNull ParserRuleContext ctx) {
		
	}

	@Override public void exitEveryRule(@NotNull ParserRuleContext ctx) {
		
	}

	@Override public void visitTerminal(@NotNull TerminalNode node) {
		
	}

	@Override public void visitErrorNode(@NotNull ErrorNode node) {
		
	}
	
	public int intVal(ParseTree node){
		return intVal.get(node);
	}
	
	public String strVal(ParseTree node){
		return strVal.get(node);
	}
	
	public Boolean boolVal(ParseTree node){
		return boolVal.get(node);
	}
	
	public Type typeVal(ParseTree node){
		return typeVal.get(node);
	}
}
