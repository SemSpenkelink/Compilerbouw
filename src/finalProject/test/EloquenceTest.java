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
import finalProject.checker.Result;

@SuppressWarnings("javadoc")
public class EloquenceTest {
	private final static String BASE_DIR = "src/finalProject/test/files";
	private final static String EXT = ".eloq";
	private final EloquenceCompiler compiler = EloquenceCompiler
			.instance();

//	@Test
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
		errors.add("Line 16:3 - Expected type 'Integer' but found 'Boolean'");
		errors.add("Line 18:5 - Expected type 'Boolean' but found 'Char'");
		errors.add("Line 20:10 - Expected type 'Integer' but found 'Char'");
		errors.add("Line 20:1 - Expected type 'Integer' but found 'Boolean'");
		errors.add("Line 21:1 - Expected type 'Integer' but found 'Char'");
		errors.add("Line 21:16 - Expected type 'Integer' but found 'Char'");
		errors.add("Line 22:7 - Expected type 'Boolean' but found 'Integer'");
		errors.add("Line 22:13 - Expected type 'Boolean' but found 'Char'");
		errors.add("Line 26:1 - Expected type 'Integer' but found 'Boolean'");		
		errors.add("Line 27:1 - Expected type 'Char' but found 'Integer'");
		errors.add("Line 30:5 - Expected type 'Char' but found 'Integer'");
		errors.add("Line 31:5 - Expected type 'Boolean' but found 'Integer'");
		errors.add("Line 34:1 - 'p' not defined in scope");
		errors.add("Line 34:1 - Variable 'p' not declared");
		errors.add("Line 34:4 - 'q' not defined in scope");
		errors.add("Line 34:4 - Variable 'q' not declared");
		errors.add("Line 42:1 - Expected type 'null' but found 'Char'");
		errors.add("Line 43:58 - Expected type not null but found 'null'");
		checkContextFail("basicExprContextError", errors);
		
		/** Check whether a program gives a runtime error. */
		checkRuntimeFail("basicExprRuntimeError");
	}
	
//	@Test
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
	
//	@Test
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
	
//	@Test
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
	public void arrayTest() throws ParseException, IOException{
		check(parse("arrayCorrect"));
	}
	
//	@Test
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
	
//	@Test
	public void prefixSumTest() throws ParseException, IOException{
		int[] input = {0};
		int[] output = {0};
		for(int i = 1; i < 100; i++){
			input[0] = i;
			output[0] = i + output[0];
			checkRuntime("prefixSum", input, output);
		}
	}
	
	//TODO
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
		for(int index = 0; index < in.available(); index++)
			assertEquals(outputString.charAt(index), (char)in.read());
		
		out.close();
		in.close();
	}
	
	private String createInput(int[] input){
		String inputString = "";
		for(int index = 0; index < input.length; index++)
			inputString += input[index] + "\n";
		return inputString;
	}
	
	private void checkRuntimeFail(String filename, int... input){
		String inputString = createInput(input);
		
		Program prog;
		Simulator sim = null;
		try {
			prog = compiler.compile(new File(BASE_DIR, filename + EXT));
			Machine vm = new Machine();
			sim = new Simulator(prog, vm);
			vm.clear();
			sim.setIn(new ByteArrayInputStream(inputString.getBytes()));
			PipedInputStream in = new PipedInputStream();
			OutputStream out;
			out = new PipedOutputStream(in);
			sim.setOut(out);
		} catch (ParseException e) {fail(filename + " did not generate");
		} catch (IOException e) {	fail(filename + " did not generate");}
		
		try{
			sim.run();
			fail(filename + " shouldn't check but did");			
		} catch (Exception e) {
			// this is the expected behaviour
		}
	}
	
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

	private Result check(ParseTree tree) throws ParseException {
		return this.compiler.check(tree);
	}
}
