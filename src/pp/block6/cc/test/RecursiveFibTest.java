package pp.block6.cc.test;

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
public class RecursiveFibTest {
	private Assembler assembler = Assembler.instance();
	private final static boolean SHOW = false;
	
	@Test(timeout = 10000)
	public void tmpTest(){
		Program p = assemble("src/pp/block6/cc/iloc/fib");
		if(SHOW) {
			System.out.println(p.prettyPrint());
		}
		Machine vm = new Machine();
		Simulator sim = new Simulator(p, vm);
		run(sim, 1, 1);
		run(sim, 2, 2);
		run(sim, 3, 3);
		run(sim, 4, 5);
		run(sim, 5, 8);
		run(sim, 6, 13);
		run(sim, 7, 21);
		run(sim, 8, 34);
		run(sim, 9, 55);
		run(sim, 10, 89);
		run(sim, 20, 10946);
	}
	
	private void run(Simulator sim, int input, int output){
		Machine vm = sim.getVM();
		vm.clear();
		sim.setIn(new ByteArrayInputStream(("" + input).getBytes()));
		sim.run();
		if (SHOW) {
			System.out.println(vm);
		}
		assertEquals(output, vm.getReg("r_ret"));
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
