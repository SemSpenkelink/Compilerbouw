package finalProject.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

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
		check(parse("basicExprCorrect"));
		checkFail("basicExprSpellingContextFreeSyntaxError");
		checkFail("basicExprContextError");
		check(parse("basicExprRuntimeError"));					//TODO should fail on runtime
	}
	
	@Test
	public void conditionalTest() throws ParseException, IOException{
		check(parse("conditionalCorrect"));
		checkFail("conditionalSpellingContextFreeSyntaxError");
		checkFail("conditionalContextError");
		check(parse("conditionalRuntimeError"));
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
