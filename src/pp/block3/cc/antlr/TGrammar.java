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

	
	@Override public void enterPar(TGrammarListenerParser.ParContext ctx) {
		
	}
	
	@Override public void exitPar(TGrammarListenerParser.ParContext ctx) {
		
	}

	@Override public void enterStr(TGrammarListenerParser.StrContext ctx) {
		typeVal.put(ctx.STR(), Type.STR);
	}

	@Override public void exitStr(TGrammarListenerParser.StrContext ctx) {
		strVal.put(ctx, strVal.get(ctx.STR()));
	}
	
	@Override public void enterBool(TGrammarListenerParser.BoolContext ctx) {
		typeVal.put(ctx.BOOL(), Type.BOOL);
	}
	
	@Override public void exitBool(TGrammarListenerParser.BoolContext ctx) {
		boolVal.put(ctx, boolVal.get(ctx.BOOL()));
	}
	
	@Override public void enterNum(TGrammarListenerParser.NumContext ctx) {
		typeVal.put(ctx.NUMBER(), Type.NUM);
	}
	
	@Override public void exitNum(TGrammarListenerParser.NumContext ctx) {
		intVal.put(ctx, intVal.get(ctx.NUMBER()));
	}
	
	@Override public void enterEquals(TGrammarListenerParser.EqualsContext ctx) { }
	
	@Override public void exitEquals(TGrammarListenerParser.EqualsContext ctx) {
		if(typeVal.get(ctx.t(1)) == typeVal.get(ctx.t(0))){
			if(typeVal.get(ctx.t(1)) == Type.STR){
				boolVal.put(ctx, strVal.get(ctx.t(1)).equals(strVal.get(ctx.t(0))));
			} else
				
			if(typeVal.get(ctx.t(1)) == Type.NUM){
				boolVal.put(ctx, intVal.get(ctx.t(1))==(intVal.get(ctx.t(0))));
			} else
				
			if(typeVal.get(ctx.t(1)) == Type.BOOL){
				boolVal.put(ctx, boolVal.get(ctx.t(1))==(boolVal.get(ctx.t(0))));
			}
		}
	}
	
	@Override public void enterHat(TGrammarListenerParser.HatContext ctx) {	
	}
	
	@Override public void exitHat(TGrammarListenerParser.HatContext ctx) {
		System.out.println(typeVal.get(ctx.t(1)));
		System.out.println(Type.NUM);
		if(typeVal.get(ctx.t(1)) == Type.NUM){
		
			if(typeVal.get(ctx.t(0)) == Type.STR){
				String tmp = "";
				for(int i = 0; i < intVal.get(ctx.t(1)) ; i++){
					tmp += strVal.get(ctx.t(0));
				}
				strVal.put(ctx, tmp);
			} else
			
			if(typeVal.get(ctx.t(0)) == Type.NUM){
				intVal.put(ctx, (int)Math.pow(intVal.get(ctx.t(0)), intVal.get(ctx.t(1))));
			}
		}
	}
	
	@Override public void enterPlus(TGrammarListenerParser.PlusContext ctx) {
		
	}
	
	@Override public void exitPlus(TGrammarListenerParser.PlusContext ctx) {
		if(typeVal.get(ctx.t(1)) == Type.NUM && typeVal.get(ctx.t(0)) == Type.NUM){
			intVal.put(ctx, intVal.get(ctx.t(0))+intVal.get(ctx.t(1)));
		} else if(typeVal.get(ctx.t(1)) == Type.STR && typeVal.get(ctx.t(0)) == Type.STR){
			strVal.put(ctx, strVal.get(ctx.t(0))+strVal.get(ctx.t(1)));
		}
	}

	
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	
	@Override public void visitTerminal(TerminalNode node) {
		if(typeVal.get(node) == Type.STR){
			strVal.put(node, node.getText());
		} else if(typeVal.get(node) == Type.BOOL){
			boolVal.put(node, node.getText().equals("true"));
		}else if(typeVal.get(node) == Type.NUM){
			intVal.put(node, Integer.parseInt(node.getSymbol().getText()));
		}
	}
	
	@Override public void visitErrorNode(ErrorNode node) { }
	
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
