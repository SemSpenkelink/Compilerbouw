// Generated from Tabular.g4 by ANTLR 4.5
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TabularParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, TEXT=13, WS=14;
	public static final int
		RULE_latex = 0, RULE_comment = 1, RULE_begin = 2, RULE_begType = 3, RULE_arg = 4, 
		RULE_argType = 5, RULE_tabLine = 6, RULE_end = 7, RULE_endType = 8;
	public static final String[] ruleNames = {
		"latex", "comment", "begin", "begType", "arg", "argType", "tabLine", "end", 
		"endType"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'%'", "'\\begin{'", "'}'", "'tabular'", "'{'", "'l'", "'c'", "'r'", 
		"'&'", "''", "'\\\\'", "'\\end{'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "TEXT", "WS"
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

	@Override
	public String getGrammarFileName() { return "Tabular.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TabularParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LatexContext extends ParserRuleContext {
		public BeginContext begin() {
			return getRuleContext(BeginContext.class,0);
		}
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public List<TabLineContext> tabLine() {
			return getRuleContexts(TabLineContext.class);
		}
		public TabLineContext tabLine(int i) {
			return getRuleContext(TabLineContext.class,i);
		}
		public LatexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_latex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterLatex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitLatex(this);
		}
	}

	public final LatexContext latex() throws RecognitionException {
		LatexContext _localctx = new LatexContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_latex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			begin();
			setState(19);
			arg();
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9 || _la==TEXT) {
				{
				{
				setState(20);
				tabLine();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26);
			end();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(TabularParser.TEXT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitComment(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BeginContext extends ParserRuleContext {
		public BegTypeContext begType() {
			return getRuleContext(BegTypeContext.class,0);
		}
		public BeginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_begin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterBegin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitBegin(this);
		}
	}

	public final BeginContext begin() throws RecognitionException {
		BeginContext _localctx = new BeginContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_begin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(T__1);
			setState(32);
			begType();
			setState(33);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BegTypeContext extends ParserRuleContext {
		public BegTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_begType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterBegType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitBegType(this);
		}
	}

	public final BegTypeContext begType() throws RecognitionException {
		BegTypeContext _localctx = new BegTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_begType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgContext extends ParserRuleContext {
		public List<ArgTypeContext> argType() {
			return getRuleContexts(ArgTypeContext.class);
		}
		public ArgTypeContext argType(int i) {
			return getRuleContext(ArgTypeContext.class,i);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitArg(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(T__4);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) {
				{
				{
				setState(38);
				argType();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgTypeContext extends ParserRuleContext {
		public ArgTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterArgType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitArgType(this);
		}
	}

	public final ArgTypeContext argType() throws RecognitionException {
		ArgTypeContext _localctx = new ArgTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_argType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TabLineContext extends ParserRuleContext {
		public List<TerminalNode> TEXT() { return getTokens(TabularParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(TabularParser.TEXT, i);
		}
		public TabLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tabLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterTabLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitTabLine(this);
		}
	}

	public final TabLineContext tabLine() throws RecognitionException {
		TabLineContext _localctx = new TabLineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tabLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			switch (_input.LA(1)) {
			case TEXT:
				{
				{
				setState(48);
				match(TEXT);
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(49);
					match(T__8);
					setState(50);
					match(TEXT);
					}
					}
					setState(55);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case T__9:
				{
				setState(56);
				match(T__9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(59);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EndContext extends ParserRuleContext {
		public EndTypeContext endType() {
			return getRuleContext(EndTypeContext.class,0);
		}
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitEnd(this);
		}
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__11);
			setState(62);
			endType();
			setState(63);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EndTypeContext extends ParserRuleContext {
		public EndTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).enterEndType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TabularListener ) ((TabularListener)listener).exitEndType(this);
		}
	}

	public final EndTypeContext endType() throws RecognitionException {
		EndTypeContext _localctx = new EndTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_endType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20F\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\7\6*\n\6\f\6\16\6-\13\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\7\b\66"+
		"\n\b\f\b\16\b9\13\b\3\b\5\b<\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\2"+
		"\2\13\2\4\6\b\n\f\16\20\22\2\3\3\2\b\n@\2\24\3\2\2\2\4\36\3\2\2\2\6!\3"+
		"\2\2\2\b%\3\2\2\2\n\'\3\2\2\2\f\60\3\2\2\2\16;\3\2\2\2\20?\3\2\2\2\22"+
		"C\3\2\2\2\24\25\5\6\4\2\25\31\5\n\6\2\26\30\5\16\b\2\27\26\3\2\2\2\30"+
		"\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33\31\3\2\2\2\34"+
		"\35\5\20\t\2\35\3\3\2\2\2\36\37\7\3\2\2\37 \7\17\2\2 \5\3\2\2\2!\"\7\4"+
		"\2\2\"#\5\b\5\2#$\7\5\2\2$\7\3\2\2\2%&\7\6\2\2&\t\3\2\2\2\'+\7\7\2\2("+
		"*\5\f\7\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2"+
		"./\7\5\2\2/\13\3\2\2\2\60\61\t\2\2\2\61\r\3\2\2\2\62\67\7\17\2\2\63\64"+
		"\7\13\2\2\64\66\7\17\2\2\65\63\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3"+
		"\2\2\28<\3\2\2\29\67\3\2\2\2:<\7\f\2\2;\62\3\2\2\2;:\3\2\2\2<=\3\2\2\2"+
		"=>\7\r\2\2>\17\3\2\2\2?@\7\16\2\2@A\5\22\n\2AB\7\5\2\2B\21\3\2\2\2CD\7"+
		"\6\2\2D\23\3\2\2\2\6\31+\67;";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}