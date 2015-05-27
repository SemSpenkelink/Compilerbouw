package pp.iloc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import pp.iloc.Assembler;
import pp.iloc.Simulator;
import pp.iloc.eval.Machine;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

@SuppressWarnings("javadoc")
public class SimulatorTest {
	
	@Test
	public void testFib(){
		System.out.println("Test Fib");
		Program p = parse("fib1");
		Simulator s = new Simulator(p);
		Machine c = s.getVM();
		
		c.init("n", 5); //45 is max
		c.setReg("r_arp", 0);
		
		s.run();
		
		
		Program q = parse("fib2");
		Simulator t = new Simulator(q);
		Machine d = t.getVM();

		d.init("x", 0);
		d.init("y", 0);
		d.init("z", 0);
		d.init("n", 5);
		d.setReg("r_arp",0);
		t.run();
		
		System.out.println("r_z fib1" + c.getReg("r_z") + "r_z fib2" + d.getReg("r_1"));
		assertEquals(c.getReg("r_z"),d.getReg("r_1"));
		
	}
	
//	@Test
	public void testMax(){
		System.out.println("Test Max");
		Program p = parse("src/pp/block4/cc/iloc/max");
		Simulator s = new Simulator(p); 
		Machine c = s.getVM();
		
		
		c.init("a", 2);
		c.init("b", 6);
		c.init("c", 4);
		c.init("alength", 3);
		c.setReg("r_arp", 0);
		
		s.run();
		if (SHOW) {
			System.out.println(c);
		}
		assertEquals(6,c.getReg("r_max"));
	}
	
//	@Test(timeout = 1000)
	public void testFig13() {
		System.out.println("Test Figure 123");
		Program p = parse("fig1-3");
		Machine c = new Machine();
		int a = c.init("a", 2);
		c.init("b", 3);
		c.init("c", 4);
		c.init("d", 5);
		c.setReg("r_arp", 0);
		new Simulator(p, c).run();
		if (SHOW) {
			System.out.println(c);
		}
		assertEquals(240, c.load(a));
	}

	Program parse(String filename) {
		File file = new File(filename + ".iloc");
		if (!file.exists()) {
			file = new File(BASE_DIR + filename + ".iloc");
		}
		try {
			return Assembler.instance().assemble(file);
		} catch (FormatException | IOException e) {
			fail(e.getMessage());
			return null;
		}
	}

	private final static String BASE_DIR = "pp/iloc/sample/";
	private final static boolean SHOW = true;
}
