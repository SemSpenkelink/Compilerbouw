package finalProject.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

import finalProject.checker.ParseException;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;

@SuppressWarnings("javadoc")
public class EloquenceGeneratorTest {
	private final static String BASE_DIR = "src/finalProject/test/files";
	private final static String EXT = ".eloq";
	private final EloquenceCompiler compiler = EloquenceCompiler
			.instance();

	@Test
	public void testPrime() throws IOException, ParseException {
		Program prog = compile("arrayRuntimeIndexOutOfBounds");
		
		Machine vm = new Machine();
		Simulator sim = new Simulator(prog, vm);
		
		run(sim,1,1);
		
	}

	private void run(Simulator sim, int input, int output){
		Machine vm = sim.getVM();
		vm.clear();
		//sim.setIn(new ByteArrayInputStream(("" + input).getBytes()));
		sim.run();
		//assertEquals(output, vm.getReg("r_ret"));
		System.out.println(vm);
	}
	private Program compile(String filename) throws IOException, ParseException {
		return this.compiler.compile(new File(BASE_DIR, filename + EXT));
	}

	private String sim(Program prog, String input) {
		Simulator sim = new Simulator(prog);
		sim.setIn(new ByteArrayInputStream(input.getBytes()));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		sim.setOut(out);
		sim.run();
		return out.toString();
	}
}
