package pp.block1.cc.antlr;

import org.junit.Test;

public class CC13Test {
	private static LexerTester tester = new LexerTester(CC13.class);

	@Test
	public void succeedingTest() {
		tester.correct("\"Test zonder quotes\"");
		tester.correct("\"Test met \"\"quotes\"\"\"");
		tester.yields("\"Test zonder quotes\"\"Test met \"\"quotes\"\"\"", CC13.STRING);
		tester.wrong("Test met één \"quote");
	}

	/*
	@Test
	public void failingAcceptanceTest() {
		// spaces in keywords are not in the rules, so claiming it's correct
		// will fail
		tester.correct("whi le do");
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
}
