package finalProject.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import finalProject.checker.ParseException;
import finalProject.checker.Result;
import finalProject.checker.Type;

@SuppressWarnings("javadoc")
public class EloquenceCheckerTest {
	private final static String BASE_DIR = "src/finalProject/sample";
	private final static String EXT = ".eloq";
	private final EloquenceCompiler compiler = EloquenceCompiler
			.instance();
	
	public void testBasic() throws IOException, ParseException {
		ParseTree tree = parse("basic");
		Result result = check(tree);
		ParseTree body = tree.getChild(3).getChild(1);
		ParseTree assX = body.getChild(1);
		assertEquals(assX.getChild(2), result.getEntry(body));
		assertEquals(assX.getChild(2), result.getEntry(assX));
		assertEquals(Type.INT, result.getType(assX.getChild(0)));
		assertEquals(Type.INT, result.getType(assX.getChild(2)));
		assertEquals(0, result.getOffset(assX.getChild(0)));
	}

	@Test
	public void testArray() throws IOException, ParseException {
		check(parse("array"));
	}
	
	//@Test
	public void testArrayFail() throws IOException, ParseException {
		check(parse("arrayFault"));
	}

	@Test
	public void testExpression() throws IOException, ParseException {
		check(parse("expression"));
	}
	
	@Test
	public void testExpressionFail() throws IOException, ParseException {
		check(parse("expressionFault"));
	}

	private void checkFail(String filename) throws IOException {
		try {
			check(parse(filename));
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
