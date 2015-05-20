/**
 * 
 */
package pp.s1367102.q1_3_6;

import pp.block2.cc.Symbol;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.NonTerm;
import pp.block2.cc.Term;

/**
 * Class containing some example grammars.
 * @author Arend Rensink
 *
 */
public class Grammar3_LL1 {
	
	public static Grammar makeGrammar3LL1() {
		// Define the non-terminals
		NonTerm e = new NonTerm("e");
		NonTerm ep = new NonTerm("ep");
		NonTerm f = new NonTerm("f");
		NonTerm g = new NonTerm("g");
		NonTerm gp = new NonTerm("gp");
		NonTerm a = new NonTerm("a");
		// Define the terminals, using the Sentence.g4 lexer grammar
		SymbolFactory fact = new SymbolFactory(grammar3_ll1Lexer.class);
		Term num = fact.getTerminal(grammar3_ll1Lexer.NUM);
		Term id = fact.getTerminal(grammar3_ll1Lexer.ID);
		Term plus = new Term("+");
		Term minus = new Term("-");
		Term lbrace = new Term("(");
		Term rbrace = new Term(")");
		Term lbr = new Term("[");
		Term rbr = new Term("]");
		Term point = new Term(".");
		
		Grammar gram = new Grammar(e);		
		gram.addRule(e, f, ep);
		gram.addRule(ep, Symbol.EMPTY);
		gram.addRule(ep, plus, f, ep);
		gram.addRule(ep, minus, f, ep);
		gram.addRule(f, lbrace, id, rbrace, f);
		gram.addRule(f, g);
		gram.addRule(g, a, gp);
		gram.addRule(gp, Symbol.EMPTY);
		gram.addRule(gp, lbr, e, rbr, gp);
		gram.addRule(gp, point, id, gp);
		gram.addRule(a, num);
		gram.addRule(a, id);
		gram.addRule(a, lbrace, e, rbrace);
		return gram;
	}
}
