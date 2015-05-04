package pp.block2.cc.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block2.cc.AST;
import pp.block2.cc.NonTerm;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;
import pp.block2.cc.antlr.SentenceParser.ModifierContext;
import pp.block2.cc.antlr.SentenceParser.ObjectContext;
import pp.block2.cc.antlr.SentenceParser.SentenceContext;
import pp.block2.cc.antlr.SentenceParser.SubjectContext;

public class SentenceConverter extends SentenceBaseListener implements Parser{

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		SentenceParser parser = new SentenceParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.sentence();
		System.out.println(tree.toStringTree(parser));
		return null;
	}
	
	@Override
	public void exitSentence(SentenceContext ctx) {
		AST ast = new AST(SENT);
		
	}

	@Override
	public void exitSubject(SubjectContext ctx) {
	}

	@Override
	public void exitModifier(ModifierContext ctx) {
	}

	@Override
	public void exitObject(ObjectContext ctx) {
	}

	@Override
	public void visitTerminal(TerminalNode node) {
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
	}
	
	private static final NonTerm SENT = new NonTerm("sentence");
	
}
