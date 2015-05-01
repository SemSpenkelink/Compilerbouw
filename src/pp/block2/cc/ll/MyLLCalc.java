package pp.block2.cc.ll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
		Set<Term> terminals = grammar.getTerminals();
		Set<NonTerm> nonTerminals = grammar.getNonterminals();
		Set<Term> tmpSet;
		List<Rule> rules = grammar.getRules();
		boolean hasChanged = true;
		
		//Add Terms
		for(Term term : terminals){
			tmpSet = new HashSet<Term>();
			tmpSet.add(term);
			first.put(term, tmpSet);
		}
		tmpSet = new HashSet<Term>();
		tmpSet.add(Term.EMPTY);
		first.put(Term.EMPTY, tmpSet);
		tmpSet = new HashSet<Term>();
		tmpSet.add(Term.EOF);
		first.put(Term.EOF, tmpSet);
		
		//Add nonTerms
		for(NonTerm nonTerm : nonTerminals){
			first.put(nonTerm, new HashSet<Term>());
		}
		
		//While First sets are still changing
		while(hasChanged){
			hasChanged = false;
			
			//For each p elem P where p has form A --> beta
			for(Rule rule : rules){
				Symbol left = rule.getLHS();
				List<Symbol> beta = rule.getRHS();
				List<Term> rhs = new ArrayList<Term>();
				rhs.addAll(first.get(beta.get(0)));
				rhs.remove(Symbol.EMPTY);
				
				int i;
				for(i = 0; i < beta.size()-1 && first.get(beta.get(i)).contains(Symbol.EMPTY); i++){
					rhs.addAll(first.get(beta.get(i)));
					rhs.remove(Symbol.EMPTY);
				}
				
				if(i == beta.size()-1 && first.get(beta.get(i)).contains(Symbol.EMPTY))
					rhs.add(Symbol.EMPTY);
				
				for(Term term : rhs)
					if(!first.get(left).contains(term)){
						hasChanged = true;
						first.get(left).add(term);
					}
			}
		}
		return first;
	}

	@Override
	public Map<NonTerm, Set<Term>> getFollow() {
		Map<NonTerm, Set<Term>> follow = new LinkedHashMap<NonTerm, Set<Term>>();
		Map<NonTerm, Set<Term>> oldFollow= new LinkedHashMap<NonTerm, Set<Term>>();
		Map<Symbol, Set<Term>> first = getFirst();
		Set<NonTerm> nonTerminals = grammar.getNonterminals();
		List<Rule> rules = grammar.getRules();
		
		for(NonTerm nonTerm : nonTerminals){
			follow.put(nonTerm, new HashSet<Term>());
		}

		NonTerm start = rules.get(0).getLHS();
		follow.get(start).add(Symbol.EOF);
		
		while(!follow.equals(oldFollow)){
			oldFollow.clear();
			for(Entry<NonTerm, Set<Term>> entry : follow.entrySet())
				oldFollow.put(entry.getKey(), new HashSet<Term>(entry.getValue()));
			
			for(Rule rule : rules){
				NonTerm A = rule.getLHS();
				List<Symbol> beta = rule.getRHS();
				Set<Term> trailer = follow.get(A);
				
				for(int i = beta.size()-1; i >= 0; i--){
					Set<Term> firstBeta = first.get(beta.get(i));
					
					if(nonTerminals.contains(beta.get(i))){
						follow.get(beta.get(i)).addAll(trailer);
						if(firstBeta.contains(Symbol.EMPTY)){
							firstBeta.remove(Symbol.EMPTY);
							trailer.addAll(follow.get(beta.get(i)));
						}else{
							trailer = firstBeta;
						}
					}else{
						trailer = firstBeta;
					}
				}
			}
		}
		return follow;
	}

	@Override
	public Map<Rule, Set<Term>> getFirstp() {
		Map<Symbol, Set<Term>>  first  = getFirst();
		Map<NonTerm, Set<Term>> follow = getFollow();
		Map<Rule, Set<Term>>	firstp = new LinkedHashMap<Rule, Set<Term>>();
		List<Rule> 				rules = grammar.getRules();
		
		for(Rule rule : rules){
			firstp.put(rule,  new HashSet<Term>());
			List<Symbol> rhs = rule.getRHS();
			for(Symbol s : rhs) {
	   			if(first.get(s).contains(Symbol.EMPTY)) {
	   				firstp.get(rule).addAll(first.get(s));
	   				firstp.get(rule).addAll(follow.get(rule.getLHS()));
	   			}
	   			else{
	   				firstp.get(rule).addAll(first.get(s));
	   				break;
	   			}
	   		 }

		}
		return firstp;
	}

	@Override
	public boolean isLL1() {
	   	Map<Rule, Set<Term>> firstp = getFirstp();
	   	Set<Entry<Rule, Set<Term>>> entrySet = firstp.entrySet();   	 
	   	 
	   	for(Entry<Rule, Set<Term>> entry : entrySet){
	   		NonTerm tmp = entry.getKey().getLHS();
	   		List<Set<Term>> terms = new ArrayList<Set<Term>>();
	   		for(Entry<Rule, Set<Term>> entry_b : entrySet){
	   			if(entry_b.getKey().getLHS().equals(tmp)){
	   				terms.add(entry_b.getValue());
	   			}
	   		}
	   		
	   		for(int index = 0; index < terms.size(); index++){
	   			for(int index_b = index + 1; index_b < terms.size(); index_b++){
	   				for(Term term : terms.get(index)){
	   					if(terms.get(index_b).contains(term))
	   						return false;
	   				}
	   			}
	   		}
	   	}
	   	return true;
	}
}
