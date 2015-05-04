package pp.block2.cc.ll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.Lexer;

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
				List<Rule> tmp = new ArrayList<Rule>(g.getTerminals().size());
				table.put(A, tmp);
				for(Rule p : g.getRules()){
					for(Term w : firstp.get(p)){
						table.get(A).set(w.getTokenType(), p);
					}
					if(firstp.get(p).contains(Symbol.EOF)){
						
					}
				}
			}
		return table;
	}

	/** Map from non-terminals to lists of rules indexed by token type. */
	private Map<NonTerm, List<Rule>> ll1Table;

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args){
		GenericLLParser tmp = new GenericLLParser(Grammars.makeSentence());
		Map<NonTerm, List<Rule>> table = tmp.getLL1Table();
		System.out.println(table);
	}
}
