// Generated from grammar3_ll1.g4 by ANTLR 4.5
package pp.s1367102.q1_3_6;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class grammar3_ll1Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NUM=9, 
		ID=10, WS=11;
	public static final int
		RULE_e = 0, RULE_ep = 1, RULE_f = 2, RULE_fp = 3, RULE_g = 4, RULE_gp = 5, 
		RULE_a = 6, RULE_ap = 7;
	public static final String[] ruleNames = {
		"e", "ep", "f", "fp", "g", "gp", "a", "ap"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "''", "'+'", "'-'", "'('", "')'", "'['", "']'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "NUM", "ID", "WS"
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
	public String getGrammarFileName() { return "grammar3_ll1.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public grammar3_ll1Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EContext extends ParserRuleContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public EpContext ep() {
			return getRuleContext(EpContext.class,0);
		}
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).exitE(this);
		}
	}

	public final EContext e() throws RecognitionException {
		EContext _localctx = new EContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_e);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			f();
			setState(17);
			ep();
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

	public static class EpContext extends ParserRuleContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public EpContext ep() {
			return getRuleContext(EpContext.class,0);
		}
		public EpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).enterEp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).exitEp(this);
		}
	}

	public final EpContext ep() throws RecognitionException {
		EpContext _localctx = new EpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ep);
		int _la;
		try {
			setState(24);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				match(T__0);
				}
				break;
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(21);
				f();
				setState(22);
				ep();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FContext extends ParserRuleContext {
		public FpContext fp() {
			return getRuleContext(FpContext.class,0);
		}
		public GContext g() {
			return getRuleContext(GContext.class,0);
		}
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).enterF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).exitF(this);
		}
	}

	public final FContext f() throws RecognitionException {
		FContext _localctx = new FContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_f);
		try {
			setState(29);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				match(T__3);
				setState(27);
				fp();
				}
				break;
			case NUM:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				g();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FpContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(grammar3_ll1Parser.ID, 0); }
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public GpContext gp() {
			return getRuleContext(GpContext.class,0);
		}
		public FpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).enterFp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).exitFp(this);
		}
	}

	public final FpContext fp() throws RecognitionException {
		FpContext _localctx = new FpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fp);
		try {
			setState(37);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				match(ID);
				setState(32);
				match(T__4);
				setState(33);
				f();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				ap();
				setState(35);
				gp();
				}
				break;
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

	public static class GContext extends ParserRuleContext {
		public AContext a() {
			return getRuleContext(AContext.class,0);
		}
		public GpContext gp() {
			return getRuleContext(GpContext.class,0);
		}
		public GContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).enterG(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).exitG(this);
		}
	}

	public final GContext g() throws RecognitionException {
		GContext _localctx = new GContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_g);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			a();
			setState(40);
			gp();
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

	public static class GpContext extends ParserRuleContext {
		public GpContext gp() {
			return getRuleContext(GpContext.class,0);
		}
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode ID() { return getToken(grammar3_ll1Parser.ID, 0); }
		public GpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).enterGp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).exitGp(this);
		}
	}

	public final GpContext gp() throws RecognitionException {
		GpContext _localctx = new GpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_gp);
		try {
			setState(52);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				match(T__0);
				}
				break;
			case T__5:
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				switch (_input.LA(1)) {
				case T__5:
					{
					setState(43);
					match(T__5);
					setState(44);
					e();
					setState(45);
					match(T__6);
					}
					break;
				case T__7:
					{
					setState(47);
					match(T__7);
					setState(48);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(51);
				gp();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(grammar3_ll1Parser.NUM, 0); }
		public TerminalNode ID() { return getToken(grammar3_ll1Parser.ID, 0); }
		public AContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_a; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).enterA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).exitA(this);
		}
	}

	public final AContext a() throws RecognitionException {
		AContext _localctx = new AContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_a);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_la = _input.LA(1);
			if ( !(_la==NUM || _la==ID) ) {
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

	public static class ApContext extends ParserRuleContext {
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).enterAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar3_ll1Listener ) ((grammar3_ll1Listener)listener).exitAp(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ap);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			e();
			setState(57);
			match(T__4);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\r>\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\5\3\33\n\3\3\4\3\4\3\4\5\4 \n\4\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5(\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\64\n\7\3\7\5\7\67"+
		"\n\7\3\b\3\b\3\t\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\4\3\2\4\5\3\2\13"+
		"\f:\2\22\3\2\2\2\4\32\3\2\2\2\6\37\3\2\2\2\b\'\3\2\2\2\n)\3\2\2\2\f\66"+
		"\3\2\2\2\168\3\2\2\2\20:\3\2\2\2\22\23\5\6\4\2\23\24\5\4\3\2\24\3\3\2"+
		"\2\2\25\33\7\3\2\2\26\27\t\2\2\2\27\30\5\6\4\2\30\31\5\4\3\2\31\33\3\2"+
		"\2\2\32\25\3\2\2\2\32\26\3\2\2\2\33\5\3\2\2\2\34\35\7\6\2\2\35 \5\b\5"+
		"\2\36 \5\n\6\2\37\34\3\2\2\2\37\36\3\2\2\2 \7\3\2\2\2!\"\7\f\2\2\"#\7"+
		"\7\2\2#(\5\6\4\2$%\5\20\t\2%&\5\f\7\2&(\3\2\2\2\'!\3\2\2\2\'$\3\2\2\2"+
		"(\t\3\2\2\2)*\5\16\b\2*+\5\f\7\2+\13\3\2\2\2,\67\7\3\2\2-.\7\b\2\2./\5"+
		"\2\2\2/\60\7\t\2\2\60\64\3\2\2\2\61\62\7\n\2\2\62\64\7\f\2\2\63-\3\2\2"+
		"\2\63\61\3\2\2\2\64\65\3\2\2\2\65\67\5\f\7\2\66,\3\2\2\2\66\63\3\2\2\2"+
		"\67\r\3\2\2\289\t\3\2\29\17\3\2\2\2:;\5\2\2\2;<\7\7\2\2<\21\3\2\2\2\7"+
		"\32\37\'\63\66";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}