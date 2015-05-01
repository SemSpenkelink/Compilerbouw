package pp.block2.cc.ll;

import static pp.block2.cc.ll.L.A;
import static pp.block2.cc.ll.L.B;
import static pp.block2.cc.ll.L.C;

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

public class LParser implements Parser {
	public LParser() {
		this.fact = new SymbolFactory(L.class);
	}

	private final SymbolFactory fact;

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		this.tokens = lexer.getAllTokens();
		this.index = 0;
		return parseL();
	}

	private List<? extends Token> tokens;

	private AST parseL() throws ParseException {
		AST result = new AST(L);
		Token next = peek();
		
		switch(next.getType()){
		case A | C: 
			result.addChild(parseR());
			result.addChild(parseToken(A));
			break;
		case B:
			result.addChild(parseQ());
			result.addChild(parseToken(B));
			result.addChild(parseToken(A));
			break;
		}
		
		return result;
	}

	private AST parseR() throws ParseException {
		AST result = new AST(R);
		Token next = peek();
		switch (next.getType()) {
		case A:
			result.addChild(parseToken(A));
			result.addChild(parseToken(B));
			result.addChild(parseToken(A));
			result.addChild(parseS());
			break;
		case C:
			result.addChild(parseToken(C));
			result.addChild(parseToken(A));
			result.addChild(parseToken(B));
			result.addChild(parseToken(A));
			result.addChild(parseS());
			break;
		}
		return result;
	}
	
	private AST parseS() throws ParseException{
		AST result = new AST(S);
		Token next = peek();
		switch (next.getType()){
		case B:
			result.addChild(parseToken(B));
			result.addChild(parseToken(C));
			result.addChild(parseS());
			break;
		case Symbol.EMPTY: 		//TODO parse empty symbol
			result.addChild();
			break;
		}
		return result;
	}
	
	private AST parseQ() throws ParseException{
		AST result = new AST(Q);
		result.addChild(parseToken(B));
		result.addChild(parseU());
		
		return result;
	}
	
	private AST parseU() throws ParseException{
		AST result = new AST(U);
		Token next = peek();
		switch (next.getType()){
		case B:
			result.addChild(parseToken(B));
			result.addChild(parseToken(C));
			break;
		case C:
			result.addChild(parseToken(C));
			break;
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

	private static final NonTerm L = new NonTerm("L");
	private static final NonTerm R = new NonTerm("R");
	private static final NonTerm S = new NonTerm("S");
	private static final NonTerm Q = new NonTerm("Q");
	private static final NonTerm U = new NonTerm("U");

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
