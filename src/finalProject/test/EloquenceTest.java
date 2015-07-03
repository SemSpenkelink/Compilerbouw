package finalProject.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;

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

	@Test
	public void basicExprTest() throws ParseException, IOException{
//		check(parse("basicExprCorrect"));
//		checkFail("basicExprSpellingContextFreeSyntaxError");
//		checkFail("basicExprContextError");
//		check(parse("basicExprRuntimeError"));					//TODO should fail on runtime
		
		int[] input = {0, 1, 0, 99, 2, 1, 2, 0, 0, 99};
		int[] output = {1, 0, -1, 0, 1, -1, 0, 99, 97, -1, 2, 1, 2, 0, -1, 0, 1, 0, -1, 97, -1, 2, -1, 98};
		checkRuntime("basicExprCorrect", input, output);
	}
	
//	@Test
	public void conditionalTest() throws ParseException, IOException{
		check(parse("conditionalCorrect"));
		checkFail("conditionalSpellingContextFreeSyntaxError");
		checkFail("conditionalContextError");
		check(parse("conditionalRuntimeError"));
	}
	
	//TODO
	private void checkRuntime(String filename, int[] input, int[] output) throws ParseException, IOException{		
		
		String inputString = "";
		for(int index = 0; index < input.length; index++)
			inputString += input[index] + "\n";
		
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
			outputString += "Output: " + output[index] + "\n\n";
		
		assertEquals(outputString.length(), in.available());
		
		for(int index = 0; index < in.available(); index++){
			char tmp = (char)in.read();
			System.out.println(outputString.charAt(index) + " = " + tmp);
		}
	}
	
	private void checkFail(String filename) throws IOException {
		Checker checker = new Checker();
		try {
			this.compiler.check(parse(filename));
			checker.check(parse(filename));
			if(!checker.hasErrors())
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
