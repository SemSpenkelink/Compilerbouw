// Generated from CC14.g4 by ANTLR 4.5
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
public class CC14 extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TOKENA=1, TOKENB=2, TOKENC=3;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TOKENA", "TOKENB", "TOKENC"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TOKENA", "TOKENB", "TOKENC"
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


	public CC14(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CC14.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\5Y\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\3\2\3\2\6\2\f\n\2\r\2\16\2\r\3\2\7\2\21\n\2\f\2\16\2\24"+
		"\13\2\3\3\3\3\6\3\30\n\3\r\3\16\3\31\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\3"+
		"\3\3\6\3$\n\3\r\3\16\3%\3\3\7\3)\n\3\f\3\16\3,\13\3\3\4\3\4\6\4\60\n\4"+
		"\r\4\16\4\61\3\4\7\4\65\n\4\f\4\16\48\13\4\3\4\3\4\6\4<\n\4\r\4\16\4="+
		"\3\4\7\4A\n\4\f\4\16\4D\13\4\3\4\3\4\6\4H\n\4\r\4\16\4I\3\4\7\4M\n\4\f"+
		"\4\16\4P\13\4\3\4\3\4\3\4\7\4U\n\4\f\4\16\4X\13\4\2\2\5\3\3\5\4\7\5\3"+
		"\2\2e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\3\t\3\2\2\2\5\25\3\2\2\2\7-"+
		"\3\2\2\2\t\13\7N\2\2\n\f\7c\2\2\13\n\3\2\2\2\f\r\3\2\2\2\r\13\3\2\2\2"+
		"\r\16\3\2\2\2\16\22\3\2\2\2\17\21\7\"\2\2\20\17\3\2\2\2\21\24\3\2\2\2"+
		"\22\20\3\2\2\2\22\23\3\2\2\2\23\4\3\2\2\2\24\22\3\2\2\2\25\27\7N\2\2\26"+
		"\30\7c\2\2\27\26\3\2\2\2\30\31\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32"+
		"\36\3\2\2\2\33\35\7\"\2\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37"+
		"\3\2\2\2\37!\3\2\2\2 \36\3\2\2\2!#\7N\2\2\"$\7c\2\2#\"\3\2\2\2$%\3\2\2"+
		"\2%#\3\2\2\2%&\3\2\2\2&*\3\2\2\2\')\7\"\2\2(\'\3\2\2\2),\3\2\2\2*(\3\2"+
		"\2\2*+\3\2\2\2+\6\3\2\2\2,*\3\2\2\2-/\7N\2\2.\60\7c\2\2/.\3\2\2\2\60\61"+
		"\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\66\3\2\2\2\63\65\7\"\2\2\64\63\3"+
		"\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3\2\2\2"+
		"9;\7N\2\2:<\7c\2\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>B\3\2\2\2?"+
		"A\7\"\2\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2"+
		"EG\7N\2\2FH\7c\2\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JN\3\2\2\2K"+
		"M\7\"\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2"+
		"QR\7N\2\2RV\7k\2\2SU\7\"\2\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W"+
		"\b\3\2\2\2XV\3\2\2\2\20\2\r\22\31\36%*\61\66=BINV\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}