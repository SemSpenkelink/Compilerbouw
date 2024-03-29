/**
 * 
 */
package pp.block2.cc.ll;

import pp.block2.cc.Symbol;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.NonTerm;
import pp.block2.cc.Term;

/**
 * Class containing some example grammars.
 * @author Arend Rensink
 *
 */
public class Grammars {
	/** Returns a grammar for simple English sentences. */
	public static Grammar makeSentence() {
		// Define the non-terminals
		NonTerm sent = new NonTerm("Sentence");
		NonTerm subj = new NonTerm("Subject");
		NonTerm obj = new NonTerm("Object");
		NonTerm mod = new NonTerm("Modifier");
		// Define the terminals, using the Sentence.g4 lexer grammar
		SymbolFactory fact = new SymbolFactory(Sentence.class);
		Term noun = fact.getTerminal(Sentence.NOUN);
		Term verb = fact.getTerminal(Sentence.VERB);
		Term adj = fact.getTerminal(Sentence.ADJECTIVE);
		Term end = fact.getTerminal(Sentence.ENDMARK);
		// Build the context free grammar
		Grammar g = new Grammar(sent);
		g.addRule(sent, subj, verb, obj, end);
		g.addRule(subj, noun);
		g.addRule(subj, mod, subj);
		g.addRule(obj, noun);
		g.addRule(obj, mod, obj);
		g.addRule(mod, adj);
		return g;
	}
	
	public static Grammar ifGrammar(){
		//Define Non Terminals
		NonTerm stat = new NonTerm("Stat");
		NonTerm elsepart = new NonTerm("ElsePart");
		
		//Define terminals
		SymbolFactory fact = new SymbolFactory(If.class);
		Term assign = fact.getTerminal(If.ASSIGN);
		Term iff = fact.getTerminal(If.IF);
		Term then = fact.getTerminal(If.THEN);
		Term els = fact.getTerminal(If.ELSE);
		Term cond = fact.getTerminal(If.COND);
		Term ws = fact.getTerminal(If.WS);
		Term typo = fact.getTerminal(If.TYPO);
		
		Grammar g = new Grammar(stat);
		g.addRule(stat, assign);
		g.addRule(stat, iff, cond, then, stat, elsepart);
		g.addRule(elsepart, els, stat);
		g.addRule(elsepart, Symbol.EMPTY);
		
		return g; 
	}
	
	public static Grammar LGrammar(){
		//Define Non Terminals
		NonTerm start = new NonTerm("L");
		NonTerm R = new NonTerm("R");
		NonTerm S = new NonTerm("S");
		NonTerm Q = new NonTerm("Q");
		NonTerm U = new NonTerm("U");
				
		//Define terminals
		SymbolFactory fact = new SymbolFactory(L.class);
		Term a = fact.getTerminal(L.A);
		Term b = fact.getTerminal(L.B);
		Term c = fact.getTerminal(L.C);
				
		Grammar g = new Grammar(start);
		g.addRule(start, R, a);
		g.addRule(start, Q, b, a);
		g.addRule(R, a, b, a, S);
		g.addRule(R, c, a, b, a, S);
		g.addRule(S, b, c, S);
		g.addRule(S, Symbol.EMPTY);
		g.addRule(Q, b, U);
		g.addRule(U, b, c);
		g.addRule(U, c);
				
		return g; 
	}
}
