package pp.block2.cc.antlr;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.junit.Test;

import pp.block2.cc.AST;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;
import pp.block2.cc.antlr.*;

public class CalculatorTest {
	private Calculator calc;
	
	
	@Test
	public void testCalculator(){
		lexerType = ArithmeticLexer.class;
		calc = new Calculator();
		
		assertEquals(calc.calculate(scan("2 + 3")), new BigInteger("5"));
		assertEquals(calc.calculate(scan("2 + 3 * 3")), new BigInteger("11"));
		assertEquals(calc.calculate(scan("2^2^3")), new BigInteger("256"));
		assertEquals(calc.calculate(scan("5 + -2")), new BigInteger("3"));
		assertEquals(calc.calculate(scan("5 + 2 * 3^2 - -5")), new BigInteger("28"));
	}
	
	
	/** Converts a text into a token stream, using the preset lexer type. */
	private Lexer scan(String text) {
		Lexer result = null;
		CharStream stream = new ANTLRInputStream(text);
		try {
			Constructor<? extends Lexer> lexerConstr = lexerType
					.getConstructor(CharStream.class);
			result = lexerConstr.newInstance(stream);
		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| InvocationTargetException e) {
			// should never occur, as all Antlr-generated lexers are
			// well-behaved
			e.printStackTrace();
		}
		return result;
	}

	private Class<? extends Lexer> lexerType;
}
