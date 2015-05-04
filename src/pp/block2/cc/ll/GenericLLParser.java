package pp.block2.cc.ll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

import pp.block2.cc.AST;
import pp.block2.cc.NonTerm;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

/** Generic table-driven LL(1)-parser. */
public class GenericLLParser implements Parser {
	public GenericLLParser(Grammar g) {
		this.g = g;
		this.calc = new MyLLCalc(g); // here use your own class
	}

	private final Grammar g;
	private final LLCalc calc;

	// fill in

	private Map<NonTerm, List<Rule>> getLL1Table() {
		if (ll1Table == null) {
			ll1Table = calcLL1Table();
		}
		return ll1Table;
	}

	/** Constructs the {@link #ll1Table}. */
	private Map<NonTerm, List<Rule>> calcLL1Table() {
		Map<NonTerm, List<Rule>> table = new HashMap<NonTerm, List<Rule>>();
		Map<Rule, Set<Term>> firstp = calc.getFirstp();
			for(NonTerm A : g.getNonterminals()){
				List<Rule> tmp = new ArrayList<Rule>();
				for(Term w : g.getTerminals())
					//Add error column
					tmp.add(null);
				//Add EOF column
				tmp.add(null);
				table.put(A, tmp);
				List<Rule> tmpRules = new ArrayList<Rule>();
				for(Rule p : g.getRules()){
					if(p.getLHS().equals(A))
						tmpRules.add(p);
				}
				for(Rule p : tmpRules){
					for(Term w : firstp.get(p)){
						table.get(A).set(w.getTokenType(), p);
					}
					if(firstp.get(p).contains(Symbol.EOF)){
						table.get(A).set(table.get(A).size()-1, p);
					}
				}
			}
		return table;
	}

	/** Map from non-terminals to lists of rules indexed by token type. */
	private Map<NonTerm, List<Rule>> ll1Table;

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		Map<NonTerm, List<Rule>> table = getLL1Table();
		AST result = new AST(g.getStart());
		Token word = lexer.nextToken();
		Stack<Symbol> stack = new Stack<Symbol>();
		stack.push(Symbol.EOF);
		stack.push(g.getStart());
		Symbol focus = stack.peek();
		while(true){
			if(focus.equals(Symbol.EOF) && word.getText().equals("<"+Symbol.EOF.getName()+">")){
				return result;
			}else if(g.getTerminals().contains(focus) || focus.equals((Symbol.EOF))){
				if(g.getTerminal(word.getType()).equals(focus)){
					stack.pop();
					focus = stack.peek();
					Token oldToken = word;
					Term oldWord = g.getTerminal(word.getType());
					word = lexer.nextToken();
					result.addChild(new AST(oldWord, oldToken));
				}else{
					throw new ParseException("looking for symbol at top of stack.");
				}
			}else{
				if(table.get(focus).get(word.getType()) instanceof Rule){
					AST tmp = new AST(g.getNonterminal(focus.getName()));
					Rule rule = table.get(focus).get(word.getType());
					List<Symbol> rhs = rule.getRHS();
					stack.pop();
					focus = stack.peek();
					for(int i = rhs.size()-1; i >= 0; i--){
						if(!rhs.get(i).equals(Symbol.EMPTY))
							stack.push(rhs.get(i));
					}
				}else
					throw new ParseException("expanding focus");
			}
			focus = stack.peek();
		}
	}
	
	public static void main(String[] args){
		GenericLLParser tmp = new GenericLLParser(Grammars.makeSentence());
		Map<NonTerm, List<Rule>> table = tmp.getLL1Table();
		System.out.println(table);
	}
}
