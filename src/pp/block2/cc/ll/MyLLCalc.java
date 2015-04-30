package pp.block2.cc.ll;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;

public class MyLLCalc implements LLCalc{
	
	private Grammar grammar;
	
	public MyLLCalc(Grammar grammar){
		this.grammar = grammar;
	}

	@Override
	public Map<Symbol, Set<Term>> getFirst() {
		Map<Symbol, Set<Term>> first = new LinkedHashMap<Symbol, Set<Term>>();
		
		//for each a elem (T u eof u e) add to firstT
		//Add all T
		Set<Term> terminals = grammar.getTerminals();
		Set<Term> tmpSet;
		for(Term term : terminals){
			tmpSet = new HashSet<Term>();
			tmpSet.add(term);
			first.put(term, tmpSet);
		}
		//Add e
		tmpSet = new HashSet<Term>();
		tmpSet.add(Term.EMPTY);
		first.put(Term.EMPTY, tmpSet);
		//Add eof
		tmpSet = new HashSet<Term>();
		tmpSet.add(Term.EOF);
		first.put(Term.EOF, tmpSet);
		
		//for each A elem NT add to firstNT
		Set<NonTerm> nonTerminals = grammar.getNonterminals();
		for(NonTerm nonTerm : nonTerminals){
			Set<Term> emptySet = new HashSet<Term>();
			first.put(nonTerm, emptySet);
		}
		
		//While First sets are still changing
		boolean hasChanged = true;
		while(hasChanged){
			hasChanged = false;
			//For each p elem P where p has form A --> beta
			List<Rule> rules = grammar.getRules();
			for(Rule rule : rules){
				//Beta
				List<Symbol> beta = rule.getRHS();
				Set<Term> rhs = new HashSet<Term>();
				int i = 1;
				if(!beta.isEmpty()){
					//rhs <-- First(b) - {Empty}
					tmpSet = first.get(beta.get(0));			
					tmpSet.remove(Symbol.EMPTY);
					rhs = tmpSet;
					
					while(first.get(beta.get(i)).contains(Symbol.EMPTY) && i <= beta.size()-2 /*Omdat Anirudh dit mooier vindt.*/){
						tmpSet = first.get(beta.get(i+1));
						tmpSet.remove(Symbol.EMPTY);
						rhs.addAll(tmpSet);
						i++;
					}
				}
				
				if(i == beta.size()-1 && first.get(beta.get(i)).contains(Symbol.EMPTY)){
					rhs.add(Symbol.EMPTY);
				}
				Set<Term> oldValue = first.get(rule.getLHS());
				if(!oldValue.equals(rhs)){
					first.put(rule.getLHS(), rhs);
					hasChanged = true;
				}
			}
		}
		return first;
	}

	@Override
	public Map<NonTerm, Set<Term>> getFollow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Rule, Set<Term>> getFirstp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLL1() {
		// TODO Auto-generated method stub
		return true;
	}

}
