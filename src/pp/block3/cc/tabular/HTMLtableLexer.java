// Generated from HTMLtable.g4 by ANTLR 4.4
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HTMLtableLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, TEXT=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'"
	};
	public static final String[] ruleNames = {
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "TEXT"
	};


	public HTMLtableLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "HTMLtable.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13o\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\6\nl\n\n\r\n"+
		"\16\nm\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\3\b\2\13\13"+
		"\"\"\60\60\62;C\\c|o\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3"+
		"\2\2\2\5\32\3\2\2\2\7\37\3\2\2\2\t&\3\2\2\2\13-\3\2\2\2\r\67\3\2\2\2\17"+
		"E\3\2\2\2\21X\3\2\2\2\23k\3\2\2\2\25\26\7>\2\2\26\27\7v\2\2\27\30\7f\2"+
		"\2\30\31\7@\2\2\31\4\3\2\2\2\32\33\7>\2\2\33\34\7v\2\2\34\35\7t\2\2\35"+
		"\36\7@\2\2\36\6\3\2\2\2\37 \7>\2\2 !\7\61\2\2!\"\7\61\2\2\"#\7v\2\2#$"+
		"\7f\2\2$%\7@\2\2%\b\3\2\2\2&\'\7>\2\2\'(\7\61\2\2()\7\61\2\2)*\7v\2\2"+
		"*+\7t\2\2+,\7@\2\2,\n\3\2\2\2-.\7>\2\2./\7\61\2\2/\60\7\61\2\2\60\61\7"+
		"v\2\2\61\62\7c\2\2\62\63\7d\2\2\63\64\7n\2\2\64\65\7g\2\2\65\66\7@\2\2"+
		"\66\f\3\2\2\2\678\7>\2\289\7j\2\29:\7v\2\2:;\7o\2\2;<\7n\2\2<=\7@\2\2"+
		"=>\7\"\2\2>?\7>\2\2?@\7d\2\2@A\7q\2\2AB\7f\2\2BC\7{\2\2CD\7@\2\2D\16\3"+
		"\2\2\2EF\7>\2\2FG\7v\2\2GH\7c\2\2HI\7d\2\2IJ\7n\2\2JK\7g\2\2KL\7\"\2\2"+
		"LM\7d\2\2MN\7q\2\2NO\7t\2\2OP\7f\2\2PQ\7g\2\2QR\7t\2\2RS\7?\2\2ST\7\""+
		"\2\2TU\7$\2\2UV\7\63\2\2VW\7$\2\2W\20\3\2\2\2XY\7>\2\2YZ\7\61\2\2Z[\7"+
		"\61\2\2[\\\7d\2\2\\]\7q\2\2]^\7f\2\2^_\7{\2\2_`\7@\2\2`a\7>\2\2ab\7\61"+
		"\2\2bc\7\61\2\2cd\7j\2\2de\7v\2\2ef\7o\2\2fg\7n\2\2gh\7@\2\2h\22\3\2\2"+
		"\2il\t\2\2\2ki\3\2\2\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\24\3\2"+
		"\2\2\5\2km\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}