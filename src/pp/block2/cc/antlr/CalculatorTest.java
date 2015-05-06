package pp.block2.cc.antlr;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
		lexerType = Calculator.class;
		calc = new Calculator();
		calc.calculate(scan("2+3"));
	}
	
	
	/** Converts a text into a token stream, using the preset lexer type. */
	private Calculator scan(String text) {
		Calculator result = null;
		CharStream stream = new ANTLRInputStream(text);
		try {
			Constructor<Calculator> lexerConstr = lexerType
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

	private Class<Calculator> lexerType;
}
