package pp.s1367102.q1_3_6;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LLTest {
	
	LLCalc calc = new MyLLCalc(Grammar3_LL1.makeGrammar3LL1());
	
	@Test
	public void testLL(){
		assertEquals(calc.isLL1(), true);
	}
	
	
	
}
