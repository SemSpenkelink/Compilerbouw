package pp.block2.cc.ll;

import static pp.block2.cc.ll.If.IF;
import static pp.block2.cc.ll.If.THEN;
import static pp.block2.cc.ll.If.COND;
import static pp.block2.cc.ll.If.ELSE;
import static pp.block2.cc.ll.If.ASSIGN;
import static pp.block2.cc.ll.If.WS;
import static pp.block2.cc.ll.If.TYPO;
import static pp.block2.cc.ll.Sentence.NOUN;

import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

import pp.block2.cc.AST;
import pp.block2.cc.SymbolFactory;
import pp.block2.cc.NonTerm;
import pp.block2.cc.ParseException;
import pp.block2.cc.Parser;

public class IfParser implements Parser {
	public IfParser() {
		this.fact = new SymbolFactory(If.class);
	}

	private final SymbolFactory fact;

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		this.tokens = lexer.getAllTokens();
		this.index = 0;
		return parseSentence();
	}

	private List<? extends Token> tokens;

	private AST parseStat() throws ParseException {
		AST result = new AST(STAT);
		Token next = peek();
		
		switch(next.getType()){
		case ASSIGN: 
			result.addChild(parseToken(ASSIGN));
			break;
		case IF:
			result.addChild(parseToken(IF));
			result.addChild(parseToken(COND));
			result.addChild(parseStat());
			result.addChild(parseElsePart());
			break;
		}
		
		
		return result;
	}

	private AST parseElsePart() throws ParseException {
		AST result = new AST(OBJ);
		Token next = peek();
		// choose between rules based on the lookahead
		switch (next.getType()) {
		case ELSE:
			result.addChild(parseToken(ELSE));
			result.addChild(parseStat());
			break;
		default:
			throw unparsable(OBJ);
		}
		return result;
	}

	private ParseException unparsable(NonTerm nt) {
		try {
			Token next = peek();
			return new ParseException(String.format(
					"Line %d:%d - could not parse '%s' at token '%s'",
					next.getLine(), next.getCharPositionInLine(), nt.getName(),
					fact.get(next.getType())));
		} catch (ParseException e) {
			return e;
		}
	}

	/** Creates an AST based on the expected token type. */
	private AST parseToken(int tokenType) throws ParseException {
		Token next = next();
		if (next.getType() != tokenType) {
			throw new ParseException(String.format(
					"Line %d:%d - expected token '%s' but found '%s'",
					next.getLine(), next.getCharPositionInLine(),
					fact.get(tokenType), fact.get(next.getType())));
		}
		return new AST(fact.getTerminal(tokenType), next);
	}

	/** Returns the next token, without moving the token index. */
	private Token peek() throws ParseException {
		if (index >= tokens.size()) {
			throw new ParseException("Reading beyond end of input");
		}
		return tokens.get(index);
	}

	/** Returns the next token and moves up the token index. */
	private Token next() throws ParseException {
		Token result = peek();
		index++;
		return result;
	}

	private int index;

	private static final NonTerm STAT = new NonTerm("Stat");
	private static final NonTerm ELSEPART = new NonTerm("ElsePart");

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [text]+");
		} else {
			for (String text : args) {
				CharStream stream = new ANTLRInputStream(text);
				Lexer lexer = new Sentence(stream);
				try {
					System.out.printf("Parse tree: %n%s%n",
							new SentenceParser().parse(lexer));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
