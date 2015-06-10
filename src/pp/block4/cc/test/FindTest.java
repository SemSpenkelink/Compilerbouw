package pp.block4.cc.test;

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
public class FindTest {
	private Assembler assembler = Assembler.instance();
	private final static boolean SHOW = false;

	//@Test(timeout = 1000)
	public void simulate() {
		Program p = assemble("src/pp/block4/cc/iloc/find");
		if (SHOW) {
			System.out.println(p.prettyPrint());
		}
		Machine vm = new Machine();
		Simulator sim = new Simulator(p, vm);
		run(sim, 15, 2);
		run(sim, 5, 0);
		run(sim, 10, 3);
	}
	
	@Test(timeout = 10000)
	public void tmpTest(){
		Program p = assemble("fib");
		if(SHOW) {
			System.out.println(p.prettyPrint());
		}
		Machine vm = new Machine();
		Simulator sim = new Simulator(p, vm);
		run2(sim, 1, 1);
		run2(sim, 2, 2);
		run2(sim, 3, 3);
		run2(sim, 4, 5);
		run2(sim, 5, 8);
		run2(sim, 6, 13);
		run2(sim, 7, 21);
		run2(sim, 8, 34);
		run2(sim, 9, 55);
		run2(sim, 10, 89);
		run2(sim, 20, 10946);
		run2(sim, 30, 1346269);
	}
	
	private void run2(Simulator sim, int input, int output){
		Machine vm = sim.getVM();
		vm.clear();
		sim.setIn(new ByteArrayInputStream(("" + input).getBytes()));
		sim.run();
		if (SHOW) {
			System.out.println(vm);
		}
		assertEquals(output, vm.getReg("r_ret"));
	}

	private void run(Simulator sim, int input, int output) {
		Machine vm = sim.getVM();
		vm.clear();
		vm.setNum("alength", 3);
		vm.setReg("r_arp", vm.init("a", 5, 2, 15));
		sim.setIn(new ByteArrayInputStream(("" + input).getBytes()));
		sim.run();
		if (SHOW) {
			System.out.println(vm);
		}
		assertEquals(output, vm.getReg("r_i"));
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
