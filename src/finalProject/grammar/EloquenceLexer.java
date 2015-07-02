// Generated from Eloquence.g4 by ANTLR 4.4
package finalProject.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EloquenceLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, ARRAY=2, BOOLEAN=3, CHAR=4, CONST=5, ELSE=6, EQ=7, FALSE=8, GE=9, 
		GT=10, IF=11, IN=12, INTEGER=13, LE=14, LT=15, NE=16, NOT=17, OR=18, OUT=19, 
		PROGRAM=20, REF=21, RETURN=22, TRUE=23, VAR=24, VOID=25, WHILE=26, ASSIGN=27, 
		COMMA=28, DIVIDE=29, DOT=30, LBRACE=31, LPAR=32, LSQBRACKET=33, MINUS=34, 
		MODULO=35, MULTIPLY=36, PLUS=37, QUOTE=38, RBRACE=39, RPAR=40, RSQBRACKET=41, 
		SEMI=42, SETARRAY=43, ID=44, NUM=45, CHARACTER=46, COMMENT=47, LINE_COMMENT=48, 
		WS=49;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'"
	};
	public static final String[] ruleNames = {
		"AND", "ARRAY", "BOOLEAN", "CHAR", "CONST", "ELSE", "EQ", "FALSE", "GE", 
		"GT", "IF", "IN", "INTEGER", "LE", "LT", "NE", "NOT", "OR", "OUT", "PROGRAM", 
		"REF", "RETURN", "TRUE", "VAR", "VOID", "WHILE", "ASSIGN", "COMMA", "DIVIDE", 
		"DOT", "LBRACE", "LPAR", "LSQBRACKET", "MINUS", "MODULO", "MULTIPLY", 
		"PLUS", "QUOTE", "RBRACE", "RPAR", "RSQBRACKET", "SEMI", "SETARRAY", "ID", 
		"NUM", "CHARACTER", "LETTER", "DIGIT", "COMMENT", "LINE_COMMENT", "WS", 
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
		"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};


	public EloquenceLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Eloquence.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\63\u023c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3"+
		",\3-\3-\3-\7-\u01d5\n-\f-\16-\u01d8\13-\3.\3.\7.\u01dc\n.\f.\16.\u01df"+
		"\13.\3/\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u01ed\n"+
		"\62\f\62\16\62\u01f0\13\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63"+
		"\7\63\u01fb\n\63\f\63\16\63\u01fe\13\63\3\63\3\63\3\64\6\64\u0203\n\64"+
		"\r\64\16\64\u0204\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39"+
		"\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E"+
		"\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3\u01ee\2O\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\2a\2c\61e\62g\63i\2k\2m\2o\2q\2"+
		"s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b"+
		"\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b\2\3\2"+
		" \4\2C\\c|\3\2\62;\4\2\f\f\17\17\5\2\13\f\17\17\"\"\4\2CCcc\4\2DDdd\4"+
		"\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMm"+
		"m\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2"+
		"VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\u0225\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3"+
		"\2\2\2\3\u009d\3\2\2\2\5\u00a1\3\2\2\2\7\u00ac\3\2\2\2\t\u00b3\3\2\2\2"+
		"\13\u00ce\3\2\2\2\r\u00d9\3\2\2\2\17\u00e6\3\2\2\2\21\u00ee\3\2\2\2\23"+
		"\u00f4\3\2\2\2\25\u0106\3\2\2\2\27\u0111\3\2\2\2\31\u011a\3\2\2\2\33\u0126"+
		"\3\2\2\2\35\u0135\3\2\2\2\37\u0147\3\2\2\2!\u0152\3\2\2\2#\u015d\3\2\2"+
		"\2%\u0161\3\2\2\2\'\u0164\3\2\2\2)\u016a\3\2\2\2+\u0172\3\2\2\2-\u0176"+
		"\3\2\2\2/\u0181\3\2\2\2\61\u018b\3\2\2\2\63\u0197\3\2\2\2\65\u01a3\3\2"+
		"\2\2\67\u01ae\3\2\2\29\u01b0\3\2\2\2;\u01b2\3\2\2\2=\u01b4\3\2\2\2?\u01b6"+
		"\3\2\2\2A\u01b8\3\2\2\2C\u01ba\3\2\2\2E\u01bc\3\2\2\2G\u01be\3\2\2\2I"+
		"\u01c0\3\2\2\2K\u01c2\3\2\2\2M\u01c4\3\2\2\2O\u01c6\3\2\2\2Q\u01c8\3\2"+
		"\2\2S\u01ca\3\2\2\2U\u01cc\3\2\2\2W\u01ce\3\2\2\2Y\u01d1\3\2\2\2[\u01d9"+
		"\3\2\2\2]\u01e0\3\2\2\2_\u01e4\3\2\2\2a\u01e6\3\2\2\2c\u01e8\3\2\2\2e"+
		"\u01f6\3\2\2\2g\u0202\3\2\2\2i\u0208\3\2\2\2k\u020a\3\2\2\2m\u020c\3\2"+
		"\2\2o\u020e\3\2\2\2q\u0210\3\2\2\2s\u0212\3\2\2\2u\u0214\3\2\2\2w\u0216"+
		"\3\2\2\2y\u0218\3\2\2\2{\u021a\3\2\2\2}\u021c\3\2\2\2\177\u021e\3\2\2"+
		"\2\u0081\u0220\3\2\2\2\u0083\u0222\3\2\2\2\u0085\u0224\3\2\2\2\u0087\u0226"+
		"\3\2\2\2\u0089\u0228\3\2\2\2\u008b\u022a\3\2\2\2\u008d\u022c\3\2\2\2\u008f"+
		"\u022e\3\2\2\2\u0091\u0230\3\2\2\2\u0093\u0232\3\2\2\2\u0095\u0234\3\2"+
		"\2\2\u0097\u0236\3\2\2\2\u0099\u0238\3\2\2\2\u009b\u023a\3\2\2\2\u009d"+
		"\u009e\5i\65\2\u009e\u009f\5\u0083B\2\u009f\u00a0\5o8\2\u00a0\4\3\2\2"+
		"\2\u00a1\u00a2\5w<\2\u00a2\u00a3\5\u0085C\2\u00a3\u00a4\5o8\2\u00a4\u00a5"+
		"\5u;\2\u00a5\u00a6\5q9\2\u00a6\u00a7\5\u0087D\2\u00a7\u00a8\5\u0085C\2"+
		"\u00a8\u00a9\5o8\2\u00a9\u00aa\5u;\2\u00aa\u00ab\5q9\2\u00ab\6\3\2\2\2"+
		"\u00ac\u00ad\5u;\2\u00ad\u00ae\5q9\2\u00ae\u00af\5\u0085C\2\u00af\u00b0"+
		"\5\u008bF\2\u00b0\u00b1\5u;\2\u00b1\u00b2\5q9\2\u00b2\b\3\2\2\2\u00b3"+
		"\u00b4\5\177@\2\u00b4\u00b5\5q9\2\u00b5\u00b6\5\u0097L\2\u00b6\u00b7\5"+
		"\u0085C\2\u00b7\u00b8\5u;\2\u00b8\u00b9\5\u008bF\2\u00b9\u00ba\5i\65\2"+
		"\u00ba\u00bb\5\u0087D\2\u00bb\u00bc\5w<\2\u00bc\u00bd\5y=\2\u00bd\u00be"+
		"\5m\67\2\u00be\u00bf\5y=\2\u00bf\u00c0\5o8\2\u00c0\u00c1\5q9\2\u00c1\u00c2"+
		"\5\u0083B\2\u00c2\u00c3\5\u008fH\2\u00c3\u00c4\5y=\2\u00c4\u00c5\5s:\2"+
		"\u00c5\u00c6\5\u0099M\2\u00c6\u00c7\5y=\2\u00c7\u00c8\5\u0083B\2\u00c8"+
		"\u00c9\5u;\2\u00c9\u00ca\5\u0091I\2\u00ca\u00cb\5\u0083B\2\u00cb\u00cc"+
		"\5y=\2\u00cc\u00cd\5\u008fH\2\u00cd\n\3\2\2\2\u00ce\u00cf\5\u008dG\2\u00cf"+
		"\u00d0\5i\65\2\u00d0\u00d1\5m\67\2\u00d1\u00d2\5\u008bF\2\u00d2\u00d3"+
		"\5\u0085C\2\u00d3\u00d4\5\u008dG\2\u00d4\u00d5\5i\65\2\u00d5\u00d6\5\u0083"+
		"B\2\u00d6\u00d7\5m\67\2\u00d7\u00d8\5\u008fH\2\u00d8\f\3\2\2\2\u00d9\u00da"+
		"\5m\67\2\u00da\u00db\5\u0085C\2\u00db\u00dc\5\u0083B\2\u00dc\u00dd\5\u008f"+
		"H\2\u00dd\u00de\5\u008bF\2\u00de\u00df\5i\65\2\u00df\u00e0\5\u008bF\2"+
		"\u00e0\u00e1\5y=\2\u00e1\u00e2\5\u0095K\2\u00e2\u00e3\5y=\2\u00e3\u00e4"+
		"\5\u008dG\2\u00e4\u00e5\5q9\2\u00e5\16\3\2\2\2\u00e6\u00e7\5q9\2\u00e7"+
		"\u00e8\5\u0089E\2\u00e8\u00e9\5\u0091I\2\u00e9\u00ea\5i\65\2\u00ea\u00eb"+
		"\5\177@\2\u00eb\u00ec\5\u008fH\2\u00ec\u00ed\5\u0085C\2\u00ed\20\3\2\2"+
		"\2\u00ee\u00ef\5k\66\2\u00ef\u00f0\5\u0085C\2\u00f0\u00f1\5u;\2\u00f1"+
		"\u00f2\5\u0091I\2\u00f2\u00f3\5\u008dG\2\u00f3\22\3\2\2\2\u00f4\u00f5"+
		"\5\u008dG\2\u00f5\u00f6\5\u0091I\2\u00f6\u00f7\5\u0087D\2\u00f7\u00f8"+
		"\5q9\2\u00f8\u00f9\5\u008bF\2\u00f9\u00fa\5y=\2\u00fa\u00fb\5\u0085C\2"+
		"\u00fb\u00fc\5\u008bF\2\u00fc\u00fd\5\u0085C\2\u00fd\u00fe\5\u008bF\2"+
		"\u00fe\u00ff\5q9\2\u00ff\u0100\5\u0089E\2\u0100\u0101\5\u0091I\2\u0101"+
		"\u0102\5i\65\2\u0102\u0103\5\177@\2\u0103\u0104\5\u008fH\2\u0104\u0105"+
		"\5\u0085C\2\u0105\24\3\2\2\2\u0106\u0107\5\u008dG\2\u0107\u0108\5\u0091"+
		"I\2\u0108\u0109\5\u0087D\2\u0109\u010a\5q9\2\u010a\u010b\5\u008bF\2\u010b"+
		"\u010c\5y=\2\u010c\u010d\5\u0085C\2\u010d\u010e\5\u008bF\2\u010e\u010f"+
		"\5\u008fH\2\u010f\u0110\5\u0085C\2\u0110\26\3\2\2\2\u0111\u0112\5i\65"+
		"\2\u0112\u0113\5\u008dG\2\u0113\u0114\5\u008dG\2\u0114\u0115\5\u0091I"+
		"\2\u0115\u0116\5\u0081A\2\u0116\u0117\5y=\2\u0117\u0118\5\u0083B\2\u0118"+
		"\u0119\5u;\2\u0119\30\3\2\2\2\u011a\u011b\5q9\2\u011b\u011c\5\u0097L\2"+
		"\u011c\u011d\5\u0087D\2\u011d\u011e\5\u008bF\2\u011e\u011f\5\u0085C\2"+
		"\u011f\u0120\5\u0087D\2\u0120\u0121\5\u008bF\2\u0121\u0122\5y=\2\u0122"+
		"\u0123\5i\65\2\u0123\u0124\5\u008fH\2\u0124\u0125\5q9\2\u0125\32\3\2\2"+
		"\2\u0126\u0127\5\u0083B\2\u0127\u0128\5\u0091I\2\u0128\u0129\5\u0081A"+
		"\2\u0129\u012a\5q9\2\u012a\u012b\5\u008bF\2\u012b\u012c\5y=\2\u012c\u012d"+
		"\5m\67\2\u012d\u012e\5i\65\2\u012e\u012f\5\177@\2\u012f\u0130\5o8\2\u0130"+
		"\u0131\5y=\2\u0131\u0132\5u;\2\u0132\u0133\5y=\2\u0133\u0134\5\u008fH"+
		"\2\u0134\34\3\2\2\2\u0135\u0136\5y=\2\u0136\u0137\5\u0083B\2\u0137\u0138"+
		"\5s:\2\u0138\u0139\5q9\2\u0139\u013a\5\u008bF\2\u013a\u013b\5y=\2\u013b"+
		"\u013c\5\u0085C\2\u013c\u013d\5\u008bF\2\u013d\u013e\5\u0085C\2\u013e"+
		"\u013f\5\u008bF\2\u013f\u0140\5q9\2\u0140\u0141\5\u0089E\2\u0141\u0142"+
		"\5\u0091I\2\u0142\u0143\5i\65\2\u0143\u0144\5\177@\2\u0144\u0145\5\u008f"+
		"H\2\u0145\u0146\5\u0085C\2\u0146\36\3\2\2\2\u0147\u0148\5y=\2\u0148\u0149"+
		"\5\u0083B\2\u0149\u014a\5s:\2\u014a\u014b\5q9\2\u014b\u014c\5\u008bF\2"+
		"\u014c\u014d\5y=\2\u014d\u014e\5\u0085C\2\u014e\u014f\5\u008bF\2\u014f"+
		"\u0150\5\u008fH\2\u0150\u0151\5\u0085C\2\u0151 \3\2\2\2\u0152\u0153\5"+
		"\u0083B\2\u0153\u0154\5\u0085C\2\u0154\u0155\5\u008fH\2\u0155\u0156\5"+
		"q9\2\u0156\u0157\5\u0089E\2\u0157\u0158\5\u0091I\2\u0158\u0159\5i\65\2"+
		"\u0159\u015a\5\177@\2\u015a\u015b\5\u008fH\2\u015b\u015c\5\u0085C\2\u015c"+
		"\"\3\2\2\2\u015d\u015e\5\u0083B\2\u015e\u015f\5\u0085C\2\u015f\u0160\5"+
		"\u008fH\2\u0160$\3\2\2\2\u0161\u0162\5\u0085C\2\u0162\u0163\5\u008bF\2"+
		"\u0163&\3\2\2\2\u0164\u0165\5q9\2\u0165\u0166\5\u0097L\2\u0166\u0167\5"+
		"\u0091I\2\u0167\u0168\5o8\2\u0168\u0169\5q9\2\u0169(\3\2\2\2\u016a\u016b"+
		"\5\u0087D\2\u016b\u016c\5\u008bF\2\u016c\u016d\5\u0085C\2\u016d\u016e"+
		"\5u;\2\u016e\u016f\5\u008bF\2\u016f\u0170\5i\65\2\u0170\u0171\5\u0081"+
		"A\2\u0171*\3\2\2\2\u0172\u0173\5\u008bF\2\u0173\u0174\5q9\2\u0174\u0175"+
		"\5s:\2\u0175,\3\2\2\2\u0176\u0177\5\u008bF\2\u0177\u0178\5q9\2\u0178\u0179"+
		"\5\177@\2\u0179\u017a\5y=\2\u017a\u017b\5\u0083B\2\u017b\u017c\5\u0089"+
		"E\2\u017c\u017d\5\u0091I\2\u017d\u017e\5y=\2\u017e\u017f\5\u008dG\2\u017f"+
		"\u0180\5w<\2\u0180.\3\2\2\2\u0181\u0182\5\u0091I\2\u0182\u0183\5\u0083"+
		"B\2\u0183\u0184\5s:\2\u0184\u0185\5q9\2\u0185\u0186\5y=\2\u0186\u0187"+
		"\5u;\2\u0187\u0188\5\u0083B\2\u0188\u0189\5q9\2\u0189\u018a\5o8\2\u018a"+
		"\60\3\2\2\2\u018b\u018c\5w<\2\u018c\u018d\5y=\2\u018d\u018e\5u;\2\u018e"+
		"\u018f\5w<\2\u018f\u0190\5\u0087D\2\u0190\u0191\5\u0085C\2\u0191\u0192"+
		"\5\u0095K\2\u0192\u0193\5q9\2\u0193\u0194\5\u008bF\2\u0194\u0195\5q9\2"+
		"\u0195\u0196\5o8\2\u0196\62\3\2\2\2\u0197\u0198\5u;\2\u0198\u0199\5\u0085"+
		"C\2\u0199\u019a\5o8\2\u019a\u019b\5s:\2\u019b\u019c\5\u0085C\2\u019c\u019d"+
		"\5\u008bF\2\u019d\u019e\5\u008dG\2\u019e\u019f\5i\65\2\u019f\u01a0\5}"+
		"?\2\u01a0\u01a1\5q9\2\u01a1\u01a2\5\u0083B\2\u01a2\64\3\2\2\2\u01a3\u01a4"+
		"\5\u008fH\2\u01a4\u01a5\5w<\2\u01a5\u01a6\5\u008bF\2\u01a6\u01a7\5\u0085"+
		"C\2\u01a7\u01a8\5\u0091I\2\u01a8\u01a9\5u;\2\u01a9\u01aa\5w<\2\u01aa\u01ab"+
		"\5\u0085C\2\u01ab\u01ac\5\u0091I\2\u01ac\u01ad\5\u008fH\2\u01ad\66\3\2"+
		"\2\2\u01ae\u01af\7?\2\2\u01af8\3\2\2\2\u01b0\u01b1\7.\2\2\u01b1:\3\2\2"+
		"\2\u01b2\u01b3\7\61\2\2\u01b3<\3\2\2\2\u01b4\u01b5\7\60\2\2\u01b5>\3\2"+
		"\2\2\u01b6\u01b7\7}\2\2\u01b7@\3\2\2\2\u01b8\u01b9\7*\2\2\u01b9B\3\2\2"+
		"\2\u01ba\u01bb\7]\2\2\u01bbD\3\2\2\2\u01bc\u01bd\7/\2\2\u01bdF\3\2\2\2"+
		"\u01be\u01bf\7\'\2\2\u01bfH\3\2\2\2\u01c0\u01c1\7,\2\2\u01c1J\3\2\2\2"+
		"\u01c2\u01c3\7-\2\2\u01c3L\3\2\2\2\u01c4\u01c5\7)\2\2\u01c5N\3\2\2\2\u01c6"+
		"\u01c7\7\177\2\2\u01c7P\3\2\2\2\u01c8\u01c9\7+\2\2\u01c9R\3\2\2\2\u01ca"+
		"\u01cb\7_\2\2\u01cbT\3\2\2\2\u01cc\u01cd\7=\2\2\u01cdV\3\2\2\2\u01ce\u01cf"+
		"\7>\2\2\u01cf\u01d0\7>\2\2\u01d0X\3\2\2\2\u01d1\u01d6\5_\60\2\u01d2\u01d5"+
		"\5_\60\2\u01d3\u01d5\5a\61\2\u01d4\u01d2\3\2\2\2\u01d4\u01d3\3\2\2\2\u01d5"+
		"\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7Z\3\2\2\2"+
		"\u01d8\u01d6\3\2\2\2\u01d9\u01dd\5a\61\2\u01da\u01dc\5a\61\2\u01db\u01da"+
		"\3\2\2\2\u01dc\u01df\3\2\2\2\u01dd\u01db\3\2\2\2\u01dd\u01de\3\2\2\2\u01de"+
		"\\\3\2\2\2\u01df\u01dd\3\2\2\2\u01e0\u01e1\5M\'\2\u01e1\u01e2\5_\60\2"+
		"\u01e2\u01e3\5M\'\2\u01e3^\3\2\2\2\u01e4\u01e5\t\2\2\2\u01e5`\3\2\2\2"+
		"\u01e6\u01e7\t\3\2\2\u01e7b\3\2\2\2\u01e8\u01e9\7\61\2\2\u01e9\u01ea\7"+
		",\2\2\u01ea\u01ee\3\2\2\2\u01eb\u01ed\13\2\2\2\u01ec\u01eb\3\2\2\2\u01ed"+
		"\u01f0\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ef\u01f1\3\2"+
		"\2\2\u01f0\u01ee\3\2\2\2\u01f1\u01f2\7,\2\2\u01f2\u01f3\7\61\2\2\u01f3"+
		"\u01f4\3\2\2\2\u01f4\u01f5\b\62\2\2\u01f5d\3\2\2\2\u01f6\u01f7\7\61\2"+
		"\2\u01f7\u01f8\7\61\2\2\u01f8\u01fc\3\2\2\2\u01f9\u01fb\n\4\2\2\u01fa"+
		"\u01f9\3\2\2\2\u01fb\u01fe\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fc\u01fd\3\2"+
		"\2\2\u01fd\u01ff\3\2\2\2\u01fe\u01fc\3\2\2\2\u01ff\u0200\b\63\2\2\u0200"+
		"f\3\2\2\2\u0201\u0203\t\5\2\2\u0202\u0201\3\2\2\2\u0203\u0204\3\2\2\2"+
		"\u0204\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0207"+
		"\b\64\2\2\u0207h\3\2\2\2\u0208\u0209\t\6\2\2\u0209j\3\2\2\2\u020a\u020b"+
		"\t\7\2\2\u020bl\3\2\2\2\u020c\u020d\t\b\2\2\u020dn\3\2\2\2\u020e\u020f"+
		"\t\t\2\2\u020fp\3\2\2\2\u0210\u0211\t\n\2\2\u0211r\3\2\2\2\u0212\u0213"+
		"\t\13\2\2\u0213t\3\2\2\2\u0214\u0215\t\f\2\2\u0215v\3\2\2\2\u0216\u0217"+
		"\t\r\2\2\u0217x\3\2\2\2\u0218\u0219\t\16\2\2\u0219z\3\2\2\2\u021a\u021b"+
		"\t\17\2\2\u021b|\3\2\2\2\u021c\u021d\t\20\2\2\u021d~\3\2\2\2\u021e\u021f"+
		"\t\21\2\2\u021f\u0080\3\2\2\2\u0220\u0221\t\22\2\2\u0221\u0082\3\2\2\2"+
		"\u0222\u0223\t\23\2\2\u0223\u0084\3\2\2\2\u0224\u0225\t\24\2\2\u0225\u0086"+
		"\3\2\2\2\u0226\u0227\t\25\2\2\u0227\u0088\3\2\2\2\u0228\u0229\t\26\2\2"+
		"\u0229\u008a\3\2\2\2\u022a\u022b\t\27\2\2\u022b\u008c\3\2\2\2\u022c\u022d"+
		"\t\30\2\2\u022d\u008e\3\2\2\2\u022e\u022f\t\31\2\2\u022f\u0090\3\2\2\2"+
		"\u0230\u0231\t\32\2\2\u0231\u0092\3\2\2\2\u0232\u0233\t\33\2\2\u0233\u0094"+
		"\3\2\2\2\u0234\u0235\t\34\2\2\u0235\u0096\3\2\2\2\u0236\u0237\t\35\2\2"+
		"\u0237\u0098\3\2\2\2\u0238\u0239\t\36\2\2\u0239\u009a\3\2\2\2\u023a\u023b"+
		"\t\37\2\2\u023b\u009c\3\2\2\2\t\2\u01d4\u01d6\u01dd\u01ee\u01fc\u0204"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}