package pp.block2.cc.antlr;

import org.antlr.v4.runtime.Lexer;

import pp.block2.cc.AST;
import pp.block2.cc.Parser;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.ll.Sentence;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import pp.block2.cc.AST;
import pp.block2.cc.NonTerm;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;
import pp.block2.cc.antlr.SentenceParser.ModifierContext;
import pp.block2.cc.antlr.SentenceParser.ObjectContext;
import pp.block2.cc.antlr.SentenceParser.SentenceContext;
import pp.block2.cc.antlr.SentenceParser.SubjectContext;

public class SentenceConverter //
		extends SentenceBaseListener implements Parser {
	public SentenceConverter() {
		this.fact = new SymbolFactory(Sentence.class);
		
	}

	/** Factory needed to create terminals of the {@link Sentence}
	 * grammar. See {@link pp.block2.cc.ll.SentenceParser} for
	 * example usage. */
	private final SymbolFactory fact;

	@Override
	public AST parse(Lexer lexer) {
		SentenceParser parser = new SentenceParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.sentence();
		new ParseTreeWalker().walk(this, tree);
		result = new AST(SENT);
		// Fill in
		return result;
	}
	
	@Override
	public void exitSentence(SentenceContext ctx) {
		AST ast = new AST(SENT);
		
	}

	@Override
	public void exitSubject(SubjectContext ctx) {
		AST ast = new AST(SUBJ);
	}

	@Override
	public void exitModifier(ModifierContext ctx) {
		AST ast = new AST(MOD);
	}

	@Override
	public void exitObject(ObjectContext ctx) {
		AST ast = new AST(OBJ);
	}

	@Override
	public void visitTerminal(TerminalNode node) {
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
	}
	
	private static final NonTerm SENT = new NonTerm("sentence");
	private static final NonTerm SUBJ = new NonTerm("subject");
	private static final NonTerm MOD = new NonTerm("modifier");
	private static final NonTerm OBJ = new NonTerm("object");
	
	
	private AST result; 
	
	// From here on overwrite the listener methods
	// Use an appropriate ParseTreeProperty to
	// store the correspondence from nodes to ASTs
}
