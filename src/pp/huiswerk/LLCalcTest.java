package pp.huiswerk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import pp.block2.cc.NonTerm;
import pp.block2.cc.Symbol;
import pp.block2.cc.Term;
import pp.block2.cc.ll.Grammar;
import pp.block2.cc.ll.Grammars;
import pp.block2.cc.ll.L;
import pp.block2.cc.ll.LLCalc;
import pp.block2.cc.ll.MyLLCalc;
import pp.block2.cc.ll.Sentence;
import pp.block2.cc.ll.If;

public class LLCalcTest {
	
	
	@Test
	public void testGrammar(){
		Grammar g = Grammars.ifGrammar();
		LLCalc calc = createCalc(g);
		
		//First Sets
		NonTerm stat = g.getNonterminal("Stat");
		NonTerm elsepart = g.getNonterminal("ElsePart");
		
		Term iff = g.getTerminal(If.IF);
		Term els = g.getTerminal(If.ELSE);
		Term assign = g.getTerminal(If.ASSIGN);
		
		assertEquals(set(iff, assign), calc.getFirst().get(stat));
		assertEquals(set(els, Symbol.EMPTY), calc.getFirst().get(elsepart));
		
		assertEquals(set(Symbol.EOF, els), calc.getFollow().get(stat));
		assertEquals(set(Symbol.EOF, els), calc.getFollow().get(elsepart));	
		
		assertFalse(calc.isLL1());
	}
	
	@Test
	public void testLGrammar(){
		Grammar g = Grammars.LGrammar();
		LLCalc calc = createCalc(g);
		
		//First Sets
		NonTerm start = g.getNonterminal("L");
		NonTerm R = g.getNonterminal("R");
		NonTerm S = g.getNonterminal("S");
		NonTerm Q = g.getNonterminal("Q");
		NonTerm U = g.getNonterminal("U");

		Term A = g.getTerminal(L.A);
		Term B = g.getTerminal(L.B);
		Term C = g.getTerminal(L.C);

		assertEquals(set(A, C, B), calc.getFirst().get(start));
		assertEquals(set(A, C), calc.getFirst().get(R));
		assertEquals(set(B, Symbol.EMPTY), calc.getFirst().get(S));
		assertEquals(set(B), calc.getFirst().get(Q));
		assertEquals(set(B, C), calc.getFirst().get(U));

		assertEquals(set(Symbol.EOF), calc.getFollow().get(start));
		assertEquals(set(A), calc.getFollow().get(R));
		assertEquals(set(A), calc.getFollow().get(S));
		assertEquals(set(B), calc.getFollow().get(Q));
		assertEquals(set(B), calc.getFollow().get(U));
		
		assertTrue(calc.isLL1());
	}
	

	/** Creates an LL1-calculator for a given grammar. */
	private LLCalc createCalc(Grammar g) {
		return new MyLLCalc(g); // your implementation of LLCalc
	}

	@SuppressWarnings("unchecked")
	private <T> Set<T> set(T... elements) {
		return new HashSet<>(Arrays.asList(elements));
	}
}
