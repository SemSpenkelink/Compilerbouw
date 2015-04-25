// Generated from Example.g4 by ANTLR 4.5
package pp.block1.cc.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Example extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHILE=1, DO=2, WS=3, TOKENA=4, TOKENB=5, TOKENC=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WHILE", "DO", "WS", "TOKENA", "TOKENB", "TOKENC"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'while'", "'do'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WHILE", "DO", "WS", "TOKENA", "TOKENB", "TOKENC"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public Example(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Example.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\bo\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\4\6\4\32\n\4\r\4\16\4\33\3\4\3\4\3\5\3\5\6\5\"\n\5\r\5\16\5#\3"+
		"\5\7\5\'\n\5\f\5\16\5*\13\5\3\6\3\6\6\6.\n\6\r\6\16\6/\3\6\7\6\63\n\6"+
		"\f\6\16\6\66\13\6\3\6\3\6\6\6:\n\6\r\6\16\6;\3\6\7\6?\n\6\f\6\16\6B\13"+
		"\6\3\7\3\7\6\7F\n\7\r\7\16\7G\3\7\7\7K\n\7\f\7\16\7N\13\7\3\7\3\7\6\7"+
		"R\n\7\r\7\16\7S\3\7\7\7W\n\7\f\7\16\7Z\13\7\3\7\3\7\6\7^\n\7\r\7\16\7"+
		"_\3\7\7\7c\n\7\f\7\16\7f\13\7\3\7\3\7\3\7\7\7k\n\7\f\7\16\7n\13\7\2\2"+
		"\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\3\5\2\13\f\17\17\"\"|\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2"+
		"\5\25\3\2\2\2\7\31\3\2\2\2\t\37\3\2\2\2\13+\3\2\2\2\rC\3\2\2\2\17\20\7"+
		"y\2\2\20\21\7j\2\2\21\22\7k\2\2\22\23\7n\2\2\23\24\7g\2\2\24\4\3\2\2\2"+
		"\25\26\7f\2\2\26\27\7q\2\2\27\6\3\2\2\2\30\32\t\2\2\2\31\30\3\2\2\2\32"+
		"\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\b\4\2\2\36"+
		"\b\3\2\2\2\37!\7N\2\2 \"\7c\2\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2"+
		"\2$(\3\2\2\2%\'\7\"\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\n\3"+
		"\2\2\2*(\3\2\2\2+-\7N\2\2,.\7c\2\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3"+
		"\2\2\2\60\64\3\2\2\2\61\63\7\"\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3"+
		"\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\679\7N\2\28:\7c\2\29"+
		"8\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<@\3\2\2\2=?\7\"\2\2>=\3\2\2\2"+
		"?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\f\3\2\2\2B@\3\2\2\2CE\7N\2\2DF\7c\2\2"+
		"ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2HL\3\2\2\2IK\7\"\2\2JI\3\2\2\2"+
		"KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2\2\2OQ\7N\2\2PR\7c\2\2Q"+
		"P\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TX\3\2\2\2UW\7\"\2\2VU\3\2\2\2"+
		"WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[]\7N\2\2\\^\7c\2\2"+
		"]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`d\3\2\2\2ac\7\"\2\2ba\3\2\2"+
		"\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7N\2\2hl\7k\2\2"+
		"ik\7\"\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\16\3\2\2\2nl\3\2\2"+
		"\2\21\2\33#(/\64;@GLSX_dl\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}