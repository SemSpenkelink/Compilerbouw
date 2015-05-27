package pp.block4.cc.iloc;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block4.cc.ErrorListener;
import pp.iloc.Simulator;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Operand;
import pp.iloc.model.Program;

public class CalcCompiler extends CalcBaseListener {
	/** Program under construction. */
	private Program prog;
	// Attribute maps and other fields

	/** Compiles a given expression string into an ILOC program. */
	public Program compile(String text) {
		Program result = null;
		ErrorListener listener = new ErrorListener();
		CharStream chars = new ANTLRInputStream(text);
		Lexer lexer = new CalcLexer(chars);
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		TokenStream tokens = new CommonTokenStream(lexer);
		CalcParser parser = new CalcParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTree tree = parser.expr();
		if (listener.hasErrors()) {
			System.out.printf("Parse errors in %s:%n", text);
			for (String error : listener.getErrors()) {
				System.err.println(error);
			}
		} else {
			result = compile(tree);
		}
		return result;
	}

	/** Compiles a given Calc-parse tree into an ILOC program. */
	public Program compile(ParseTree tree) {
		// Fill in
	}
	
	
	@Override public void enterPar(CalcParser.ParContext ctx) { }
	
	@Override public void exitPar(CalcParser.ParContext ctx) { }
	
	@Override public void enterMinus(CalcParser.MinusContext ctx) { }
	
	@Override public void exitMinus(CalcParser.MinusContext ctx) { }
	
	@Override public void enterNumber(CalcParser.NumberContext ctx) { }
	
	@Override public void exitNumber(CalcParser.NumberContext ctx) { }
	
	@Override public void enterTimes(CalcParser.TimesContext ctx) { }
	
	@Override public void exitTimes(CalcParser.TimesContext ctx) { }
	
	@Override public void enterPlus(CalcParser.PlusContext ctx) { }
	
	@Override public void exitPlus(CalcParser.PlusContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	
	@Override public void visitTerminal(TerminalNode node) { }
	
	@Override public void visitErrorNode(ErrorNode node) { }

	/** Constructs an operation from the parameters 
	 * and adds it to the program under construction. */
	private void emit(OpCode opCode, Operand... args) {
		this.prog.addInstr(new Op(opCode, args));
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [expr]+");
			return;
		}
		CalcCompiler compiler = new CalcCompiler();
		for (String expr : args) {
			System.out.println("Processing " + expr);
			Program prog = compiler.compile(expr);
			new Simulator(prog).run();
			System.out.println(prog.prettyPrint());
		}
	}
}
