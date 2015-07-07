package finalProject.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;
import finalProject.checker.Checker;
import finalProject.checker.ParseException;

@SuppressWarnings("javadoc")
public class EloquenceTest {
	private final static String BASE_DIR = "src/finalProject/test/files";
	private final static String EXT = ".eloq";
	private final EloquenceCompiler compiler = EloquenceCompiler
			.instance();

	@Test
	/**
	 * Testing the basic expressions.
	 * Testing:
	 * - A correct sample program.
	 * - A sample program containing spelling and context free errors.
	 * - A sample program containing context errors.
	 * - A sample program containing runtime errors.
	 * 
	 * @throws ParseException
	 * @throws IOException
	 */
	public void basicExprTest() throws ParseException, IOException{
		/** Check expected output against expected input for correct program.*/
		int[] input = {0, 1, 0, 99, 2, 1, 2, 0, 0, 99};
		int[] output = {1, 0, -1, 0, 1, -1, 0, 99, 97, -1, 2, 1, 2, 0, -1, 0, 1, 0, -1, 97, -1, 2, -1, 98};
		checkRuntime("basicExprCorrect", input, output);
		
		/** Check whether a program contains syntax errors. */
		checkFail("basicExprSpellingContextFreeSyntaxError");
		
		/** Check whether a program contains the given errors. */
		Set<String> errors = new HashSet<String>();
		errors.add("Line 10:1 - Variable 'z' is immutable.");
		errors.add("Line 13:3 - Expected type 'Integer' but found 'Boolean'");
		errors.add("Line 15:5 - Expected type 'Boolean' but found 'Char'");
		errors.add("Line 17:10 - Expected type 'Integer' but found 'Char'");
		errors.add("Line 17:1 - Expected type 'Integer' but found 'Boolean'");
		errors.add("Line 18:1 - Expected type 'Integer' but found 'Char'");
		errors.add("Line 18:16 - Expected type 'Integer' but found 'Char'");
		errors.add("Line 19:7 - Expected type 'Boolean' but found 'Integer'");
		errors.add("Line 19:13 - Expected type 'Boolean' but found 'Char'");
		errors.add("Line 22:1 - Expected type 'Integer' but found 'Boolean'");		
		errors.add("Line 23:1 - Expected type 'Char' but found 'Integer'");
		errors.add("Line 26:5 - Expected type 'Char' but found 'Integer'");
		errors.add("Line 27:5 - Expected type 'Boolean' but found 'Integer'");
		errors.add("Line 30:1 - 'p' not defined in scope");
		errors.add("Line 30:1 - Variable 'p' not declared");
		errors.add("Line 30:4 - 'q' not defined in scope");
		errors.add("Line 30:4 - Variable 'q' not declared");
		errors.add("Line 37:1 - Expected type 'null' but found 'Char'");
		errors.add("Line 38:58 - Expected type not null but found 'null'");
		checkContextFail("basicExprContextError", errors);
		
		/** Check whether a program gives a runtime error. */
		checkRuntimeFail("basicExprRuntimeError");
	}
	
	@Test
	/**
	 * Testing the conditional statements.
	 * Testing:
	 * - A correct sample program.
	 * - A sample program containing spelling and context free errors.
	 * - A sample program containing context errors.
	 * - A sample program containing runtime errors.
	 * 
	 * @throws ParseException
	 * @throws IOException
	 */
	public void conditionalTest() throws ParseException, IOException{
		/** Check expected output against expected input for correct program.*/
		int[] input = {5, 4, 10, 6, 99};
		int[] output = {1, -1, 5, 5, 99, 5, -1, 99};
		checkRuntime("conditionalCorrect", input, output);
		
		/** Check whether a program contains syntax errors. */
		checkFail("conditionalSpellingContextFreeSyntaxError");
		
		/** Check whether a program contains the given errors. */
		Set<String> errors = new HashSet<String>();
		errors.add("Line 36:24 - Expected type 'Boolean' but found 'Char'");
		errors.add("Line 34:10 - Expected type 'Boolean' but found 'Integer'");
		errors.add("Line 39:9 - Expected type not null but found 'null'");
		errors.add("Line 44:10 - Expected type not null but found 'null'");
		errors.add("Line 58:10 - 'ivar4' not defined in scope");
		errors.add("Line 61:9 - 'ivar3' not defined in scope");
		errors.add("Line 65:1 - Expected type 'Boolean' but found 'Integer'");
		errors.add("Line 103:1 - Expected type 'Char' but found 'Boolean'");
		errors.add("Line 132:1 - Expected type 'Integer' but found 'Char'");
		checkContextFail("conditionalContextError", errors);
		
		/** Check whether a program gives a runtime error. */
		checkRuntimeFail("conditionalRuntimeError", 1);
	}
	
	@Test
	/**
	 * Testing the while statements.
	 * Testing:
	 * - A correct sample program.
	 * - A sample program containing spelling and context free errors.
	 * - A sample program containing context errors.
	 * - A sample program containing runtime errors.
	 * 
	 * @throws ParseException
	 * @throws IOException
	 */
	public void whileTest() throws ParseException, IOException{
		/** Check expected output against expected input for correct program.*/
		int[] input = {};
		int[] output = {-1, 0, 0, 9, 10, 10, 9, 8, 7, 6};
		checkRuntime("whileCorrect", input, output);

		/** Check whether a program contains syntax errors. */
		checkFail("whileSpellingContextFreeSyntaxError");
		
		/** Check whether a program contains the given errors. */
		Set<String> errors = new HashSet<String>();
		errors.add("Line 14:12 - Expected type 'Boolean' but found 'Integer'");
		errors.add("Line 17:12 - Expected type 'Boolean' but found 'Char'");
		errors.add("Line 20:12 - Expected type not null but found 'null'");
		errors.add("Line 20:12 - Expected type not null but found 'null'");
		checkContextFail("whileContextError", errors);
		
		/** Check whether a program gives a runtime error. */
		checkRuntimeFail("whileRuntimeError", -1);
	}
	
	@Test
	/**
	 * Testing the functions and procedures.
	 * Testing:
	 * - A correct sample program.
	 * - A sample program containing spelling and context free errors.
	 * - A sample program containing context errors.
	 * - A sample program containing runtime errors.
	 * 
	 * @throws ParseException
	 * @throws IOException
	 */
	public void functionTest() throws ParseException, IOException{
		/** Check expected output against expected input for correct program.*/
		int[] input = {13};
		int[] output = {10, 0, 589, 233};
		checkRuntime("functionCorrect", input, output);
		
		/** Check whether a program contains syntax errors. */
		checkFail("functionSpellingContextFreeSyntaxError");
		
		/** Check whether a program contains the given errors. */
		Set<String> errors = new HashSet<String>();
		errors.add("Line 6:1 - No return statements are allowed.");
		errors.add("Line 28:31 - 'ivar2' not defined in scope");
		errors.add("Line 38:27 - Expected type 'Boolean' but found 'Integer'");
		errors.add("Line 39:47 - Expected type 'Char' but found 'Integer'");
		errors.add("Line 46:35 - Expected type not null but found 'null'");
		errors.add("Line 48:28 - 'ivar3' already defined within the scope");
		errors.add("Line 48:36 - 'function5' not defined in scope");
		errors.add("");	//Because "Line 48:36 - 'function5' not defined in scope" is noticed twice
		errors.add("Line 48:36 - Expected type not null but found 'null'");
		checkContextFail("functionContextError", errors);
		
		/** Check whether a program gives a runtime error. */
		checkRuntimeFail("functionRuntimeError");
	}
	
	@Test
	/**
	 * Testing the arrays.
	 * Testing:
	 * - A correct sample program.
	 * - A sample program containing spelling and context free errors.
	 * - A sample program containing context errors.
	 * - A sample program containing runtime errors.
	 * 
	 * @throws ParseException
	 * @throws IOException
	 */
	public void arrayTest() throws ParseException, IOException{
		/** Check expected output against expected input for correct program.*/
		int[] input = {};
		int[] output = {0, -1, -1, -1, -1};
		checkRuntime("arrayCorrect", input, output);
		
		/** Check whether a program contains syntax errors. */
		checkFail("arraySpellingContextFreeSyntaxError");
		
		/** Check whether a program contains the given errors. */
		Set<String> errors = new HashSet<String>();
		errors.add("Line 8:16 - Expected type 'Array [0..4] of Integer' but found 'Integer'");
		errors.add("Line 11:26 - Expected type 'Integer' but found 'Boolean'");
		errors.add("Line 14:36 - Expected type 'Integer' but found 'Array [0..4] of Integer'");
		errors.add("Line 16:10 - Expected type 'Integer' but found 'Array [0..4] of Integer'");
		errors.add("Line 16:34 - Expected type 'Integer' but found 'Array [0..4] of Integer'");
		errors.add("Line 21:7 - Expected type 'Integer' but found 'Array [0..4] of Integer'");
		errors.add("Line 21:38 - Expected type 'Integer' but found 'Array [0..4] of Integer'");
		errors.add("Line 22:7 - Expected type 'Integer' but found 'Array [0..4] of Integer'");	
		errors.add("Line 22:38 - Expected type 'Integer' but found 'Array [0..4] of Integer'");		
		errors.add("Line 23:7 - Expected type 'Integer' but found 'Array [0..4] of Integer'");
		errors.add("Line 23:31 - Expected type 'Integer' but found 'Array [0..4] of Integer'");
		errors.add("Line 25:19 - Expected type 'Integer' but found 'Char'");
		errors.add("Line 26:19 - Expected type 'Integer' but found 'Boolean'");
		checkContextFail("arrayContextError", errors);
		
		/** Check whether a program gives a runtime error. */
		checkRuntimeFail("arrayRuntimeError");
	}
	
	@Test
	/**
	 * Testing a sample of a fibonacci program, using recursion.
	 * Evaluate the first 20 fibonacci numers, after that the program becomes slow.
	 * @throws ParseException
	 * @throws IOException
	 */
	public void fibonacciTest() throws ParseException, IOException{
		int[] input = new int[1];
		int[] output = new int[1];
		int a = 0;
		int b = 1;
		for(int i = 1; i <= 20; i++){
			a = a+b;
			b = a-b;
			input[0] = i;
			output[0] = a;
			checkRuntime("fib", input, output);
		}
	}
	
	@Test
	/**
	 * Testing a sample of a prefixsum program, using recursion.
	 * Evaluate the first 100 prefixsum numbers.
	 * @throws ParseException
	 * @throws IOException
	 */
	public void prefixSumTest() throws ParseException, IOException{
		int[] input = {0};
		int[] output = {0};
		for(int i = 1; i < 100; i++){
			input[0] = i;
			output[0] = i + output[0];
			checkRuntime("prefixSum", input, output);
		}
	}
	
	/**
	 * Automatically executes a given file with the input and compares the actual output to the given expected output.
	 * @param filename: Name of executed file;
	 * @param input:	Input for program;
	 * @param output:	Expected output of program;
	 * @throws ParseException
	 * @throws IOException
	 */
	private void checkRuntime(String filename, int[] input, int[] output) throws ParseException, IOException{		
		
		String inputString = createInput(input);
		
		Program prog = compiler.compile(new File(BASE_DIR, filename + EXT));
		Machine vm = new Machine();
		Simulator sim = new Simulator(prog, vm);
		vm.clear();
		sim.setIn(new ByteArrayInputStream(inputString.getBytes()));
		PipedInputStream in = new PipedInputStream();
		OutputStream out;
		out = new PipedOutputStream(in);
		sim.setOut(out);
		sim.run();
		
		String outputString = "";
		for(int index = 0; index < output.length; index++)
			outputString += "Output: " + output[index] + "\r\n";

		assertEquals(outputString.length(), in.available());
		int max = in.available();
		for(int index = 0; index < max; index++)
			assertEquals(outputString.charAt(index), (char)in.read());
		
		out.close();
		in.close();
	}
	
	/**
	 * Create input string in correct format from given input.
	 * @param input
	 * @return
	 */
	private String createInput(int[] input){
		String inputString = "";
		for(int index = 0; index < input.length; index++)
			inputString += input[index] + "\n";
		return inputString;
	}
	
	/**
	 * Executes program and succeeds when there is a runtime fail.
	 * @param filename
	 * @param input
	 */
	private void checkRuntimeFail(String filename, int... input){
		String inputString = createInput(input);
		
		Program prog;
		Simulator sim = null;
		Machine vm = null;
		PipedInputStream in = null;
		try {
			prog = compiler.compile(new File(BASE_DIR, filename + EXT));
			vm = new Machine();
			sim = new Simulator(prog, vm);
			vm.clear();
			sim.setIn(new ByteArrayInputStream(inputString.getBytes()));
			in = new PipedInputStream();
			OutputStream out;
			out = new PipedOutputStream(in);
			sim.setOut(out);
		} catch (ParseException e) {fail(filename + " did not generate");
		} catch (IOException e) {	fail(filename + " did not generate");}
		
		try{
			sim.run();
			String output = "";
			int max = in.available();
			for(int index = 0; index < max; index++)
				output += (char)in.read();
			/** Check whether there was an error outputted. */
			if(!output.toLowerCase().contains("error: "))
				fail(filename + " shouldn't check but did");
		} catch (Exception e) {
			// this is the expected behaviour
		}
	}
	
	/**
	 * Succeeds when a all expectedErrors are detected.
	 * @param filename
	 * @param expectedErrors
	 * @throws IOException
	 */
	private void checkContextFail(String filename, Set<String> expectedErrors) throws IOException{
		Checker checker = new Checker();
		try {
			this.compiler.check(parse(filename));
			checker.check(parse(filename));
			fail(filename + " did not contain any context errors but should");
		} catch (ParseException exc) {
			System.out.println(exc.getMessages());
			if(exc.getMessages().size() != expectedErrors.size())
				fail(filename + " did not notice all errors that were expected");
			else
				for(String error : exc.getMessages())
					if(!expectedErrors.contains(error))
						fail(filename + " had an unexpected error: " + error);
		}
	}
	
	/**
	 * Succeeds when the program cannot be parsed.
	 * @param filename
	 * @throws IOException
	 */
	private void checkFail(String filename) throws IOException {
		Checker checker = new Checker();
		try {
			this.compiler.check(parse(filename));
			checker.check(parse(filename));
			fail(filename + " shouldn't check but did");
		} catch (ParseException exc) {
			// this is the expected behaviour
		}
	}

	private ParseTree parse(String filename) throws IOException, ParseException {
		return this.compiler.parse(new File(BASE_DIR, filename + EXT));
	}
}
