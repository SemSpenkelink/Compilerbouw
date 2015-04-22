package pp.block1.cc.dfa;

import static pp.block1.cc.dfa.State.ID6_DFA;

import org.junit.Assert;
import org.junit.Test;

/** Test class for Checker implementation. */
public class CheckerTest {
	private Checker myChecker = new CheckerImplementation();// instantiate your Checker implementation

	@Test
	public void testID6() {
		dfa = ID6_DFA;
		accepts("a12345");
		rejects("");
		rejects("a12 45");
		rejects("a12 456");
		rejects("a123456");
		rejects("123456");
	}

	@Test
	public void DFA_LALA() {
		dfa = DFA_LALA;
		accepts("LaaaaLaLaa Laaaa   LaLiLaa");
		rejects("");
		rejects("La La La La Li");
		rejects("La La Li");
		rejects("LA");
		accepts("La La La Li");
	}

	private void accepts(String word) {
		if (!myChecker.accepts(dfa, word)) {
			Assert.fail(String.format(
					"Word '%s' is erroneously rejected by %s", word, dfa));
		}
	}

	private void rejects(String word) {
		if (myChecker.accepts(dfa, word)) {
			Assert.fail(String.format(
					"Word '%s' is erroneously accepted by %s", word, dfa));
		}
	}

	private State dfa;
}
