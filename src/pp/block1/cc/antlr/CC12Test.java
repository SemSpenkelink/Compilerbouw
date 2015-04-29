package pp.block1.cc.antlr;

import org.junit.Test;

public class CC12Test {
	private static LexerTester tester = new LexerTester(CC12.class);

	@Test
	public void succeedingTest() {
		tester.correct("s12335");
		tester.correct("a23Ab9");
		tester.yields("a23ab9 s12345", CC12.VALUE, CC12.VALUE);
		tester.wrong("0AAAAA");
	}
}
/*
	@Test
	public void failingAcceptanceTest() {
		// spaces in keywords are not in the rules, so claiming it's correct
		// will fail
		tester.correct("B12 23 A");
	}

	@Test
	public void failingYieldCount() {
		// the sequence consists of three dos, not two
		tester.yields("do dodo", Example.DO, Example.DO);
	}

	@Test
	public void failingYieldToken() {
		// the second token is a DO not a WHILE
		tester.yields("do dodo", Example.DO, Example.WHILE, Example.DO);
	}

	@Test
	public void failingRejectionTest() {
		// the following is perfectly fine, so claiming it's wrong will fail
		tester.wrong("whilewhiledodo");
	}
	
	*/

