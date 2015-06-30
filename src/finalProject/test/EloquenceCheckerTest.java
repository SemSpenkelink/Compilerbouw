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
import finalProject.checker.Type;

@SuppressWarnings("javadoc")
public class EloquenceCheckerTest {
	private final static String BASE_DIR = "src/finalProject/typeCheckingTestFiles";
	private final static String EXT = ".eloq";
	private final EloquenceCompiler compiler = EloquenceCompiler
			.instance();

	@Test
	public void testArray() throws IOException, ParseException {
		check(parse("testCorrectArray"));
	}
	
	@Test
	public void testArrayFail() throws IOException, ParseException {
		checkFail("testFailArray");
		checkFail("testFailArray2");
		checkFail("testFailArray3");
	}

	@Test
	public void testArithmeticExpression() throws IOException, ParseException {
		check(parse("testCorrectArithmeticExpr"));
	}
	
	@Test
	public void testArithmethicExpressionFail() throws IOException, ParseException {
		checkFail("testFailArithmeticExpr");
	}
	
	@Test
	public void testDeclarations() throws IOException, ParseException{
		check(parse("testCorrectDeclarations"));
	}
	
	@Test
	public void testDeclarationsFail() throws IOException, ParseException{
		checkFail("testFailDeclarations");
		checkFail("testFailDeclarations2");
	}
	
	@Test
	public void testFunction() throws IOException, ParseException{
		check(parse("testCorrectFunction"));
	}
	
	@Test
	public void testFunctionFail() throws IOException, ParseException{
		checkFail("testFailFunc");
		checkFail("testFailFunc2");
		checkFail("testFailFunc3");
		checkFail("testFailFunc4");
		checkFail("testFailFunc5");
		checkFail("testFailFunc6");
		checkFail("testFailFunc7");
		checkFail("testFailFunc8");
		checkFail("testFailFunc9");
	}
	
	@Test
	public void testMutable() throws IOException, ParseException{
		check(parse("testCorrectMutable"));		
	}
	
	@Test
	public void testMutableFail() throws IOException, ParseException{
		checkFail("testFailMutable");		
	}
	
	@Test
	public void testWhile() throws IOException, ParseException{
		check(parse("testCorrectWhileStat"));
	}
	
	@Test
	public void testWhileFail() throws IOException, ParseException{
		checkFail("testFailWhileStat");
		checkFail("testFailWhileStat2");
		checkFail("testFailWhileStat3");
	}
	
	@Test
	public void testIf() throws IOException, ParseException{
		check(parse("testCorrectIf"));
	}
	
	@Test
	public void testIfFail() throws IOException, ParseException{
		checkFail("testFailIf");
		checkFail("testFailIf2");
	}
	
	@Test
	public void testScope() throws IOException, ParseException{
		check(parse("testCorrectScope"));
	}
	
	@Test
	public void testScopeFail() throws IOException, ParseException{
		checkFail("testFailScope");
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
