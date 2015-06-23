package pp.s1366432.q2_5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

@SuppressWarnings("javadoc")
public class ConvertTest {
	private Assembler assembler = Assembler.instance();
	private final static boolean SHOW = true;
	
	@Test(timeout = 1000)
	public void tmpTest(){
		Program p = assemble("src/pp/s1366432/q2_5/Convert");
		if(SHOW) {
			//System.out.println(p.prettyPrint());
		}
		Machine vm = new Machine();
		Simulator sim = new Simulator(p, vm);
		run(sim, 64, 2, 7);
		run(sim, 32, 2, 6);
		run(sim, 16, 2, 5);
	}
	
	private void run(Simulator sim, int number, int base, int output){
		Machine vm = sim.getVM();
		vm.clear();
		sim.setIn(new ByteArrayInputStream(("" + number + "\n" + base).getBytes()));
		sim.run();
		if (SHOW) {
			System.out.println(vm);
		}
		assertEquals(output, vm.getReg("r_function_convert"));
	}
	
	private Program assemble(String filename) {
		File file = new File(filename + ".iloc");
		try {
			return this.assembler.assemble(file);
		} catch (FormatException | IOException e) {
			fail(e.getMessage());
			return null;
		}
	}
}
