package pp.s1367102.q1_3_3;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.Term;
import pp.s1367102.q1_3_6.Grammar;
import pp.s1367102.q1_3_6.grammar3_ll1Lexer;

public class Grammar3_NOLR {

	public static Grammar makeGrammar3_NOLR() {
		// Define the non-terminals
		NonTerm e = new NonTerm("e");
		NonTerm ep = new NonTerm("ep");
		NonTerm f = new NonTerm("f");
		NonTerm fp = new NonTerm("fp");
		NonTerm g = new NonTerm("g");
		NonTerm gp = new NonTerm("gp");
		NonTerm a = new NonTerm("a");
		NonTerm ap = new NonTerm("ap");
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
		gram.addRule(f, lbrace, fp);
		gram.addRule(f, g);
		gram.addRule(fp, id, rbrace, f);
		gram.addRule(fp, ap, gp);
		gram.addRule(g, a, gp);
		gram.addRule(gp, Symbol.EMPTY);
		gram.addRule(gp, lbr, e, rbr, gp);
		gram.addRule(gp, point, id, gp);
		gram.addRule(a, num);
		gram.addRule(a, id);
		gram.addRule(ap, e, rbrace);
		return gram;
	}
}
