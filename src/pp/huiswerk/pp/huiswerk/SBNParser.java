// Generated from SBN.g4 by ANTLR 4.5
package pp.huiswerk;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SBNParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, WS=5;
	public static final int
		RULE_number = 0, RULE_sign = 1, RULE_list = 2, RULE_bit = 3;
	public static final String[] ruleNames = {
		"number", "sign", "list", "bit"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'+'", "'-'", "'1'", "'0'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "WS"
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
	public String getGrammarFileName() { return "SBN.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SBNParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class NumberContext extends ParserRuleContext {
		public int val;
		public int pos;
		public boolean neg;
		public SignContext s0;
		public ListContext l0;
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SBNListener ) ((SBNListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SBNListener ) ((SBNListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			((NumberContext)_localctx).s0 = sign();
			setState(9);
			((NumberContext)_localctx).l0 = list(0);
			 ((NumberContext)_localctx).l0.pos = 0;	((NumberContext)_localctx).val = (((NumberContext)_localctx).s0.neg) ? -((NumberContext)_localctx).l0.val : ((NumberContext)_localctx).l0.val;
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

	public static class SignContext extends ParserRuleContext {
		public boolean neg;
		public Token s0;
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SBNListener ) ((SBNListener)listener).enterSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SBNListener ) ((SBNListener)listener).exitSign(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sign);
		try {
			setState(16);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(12);
				((SignContext)_localctx).s0 = match(T__0);
				 ((SignContext)_localctx).neg = false; 
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(14);
				((SignContext)_localctx).s0 = match(T__1);
				 ((SignContext)_localctx).neg = true;  
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

	public static class ListContext extends ParserRuleContext {
		public int pos;
		public int val;
		public ListContext l0;
		public BitContext b0;
		public BitContext bit() {
			return getRuleContext(BitContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SBNListener ) ((SBNListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SBNListener ) ((SBNListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		return list(0);
	}

	private ListContext list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ListContext _localctx = new ListContext(_ctx, _parentState);
		ListContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(19);
			((ListContext)_localctx).b0 = bit();
			 ((ListContext)_localctx).b0.pos=_localctx.pos; ((ListContext)_localctx).val = ((ListContext)_localctx).b0.val; 
			}
			_ctx.stop = _input.LT(-1);
			setState(28);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ListContext(_parentctx, _parentState);
					_localctx.l0 = _prevctx;
					_localctx.l0 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_list);
					setState(22);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(23);
					((ListContext)_localctx).b0 = bit();
					 ((ListContext)_localctx).l0.pos=_localctx.pos+1; ((ListContext)_localctx).b0.pos=_localctx.pos; ((ListContext)_localctx).val = ((ListContext)_localctx).l0.val+((ListContext)_localctx).b0.val; 
					}
					} 
				}
				setState(30);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BitContext extends ParserRuleContext {
		public int pos;
		public int val;
		public Token b0;
		public BitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SBNListener ) ((SBNListener)listener).enterBit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SBNListener ) ((SBNListener)listener).exitBit(this);
		}
	}

	public final BitContext bit() throws RecognitionException {
		BitContext _localctx = new BitContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bit);
		try {
			setState(35);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				((BitContext)_localctx).b0 = match(T__2);
				 ((BitContext)_localctx).val =  (1 << _localctx.pos); 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				((BitContext)_localctx).b0 = match(T__3);
				 ((BitContext)_localctx).val = 0; 
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return list_sempred((ListContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean list_sempred(ListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\7(\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3\23\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\7\4\35\n\4\f\4\16\4 \13\4\3\5\3\5\3\5\3\5\5\5"+
		"&\n\5\3\5\2\3\6\6\2\4\6\b\2\2&\2\n\3\2\2\2\4\22\3\2\2\2\6\24\3\2\2\2\b"+
		"%\3\2\2\2\n\13\5\4\3\2\13\f\5\6\4\2\f\r\b\2\1\2\r\3\3\2\2\2\16\17\7\3"+
		"\2\2\17\23\b\3\1\2\20\21\7\4\2\2\21\23\b\3\1\2\22\16\3\2\2\2\22\20\3\2"+
		"\2\2\23\5\3\2\2\2\24\25\b\4\1\2\25\26\5\b\5\2\26\27\b\4\1\2\27\36\3\2"+
		"\2\2\30\31\f\4\2\2\31\32\5\b\5\2\32\33\b\4\1\2\33\35\3\2\2\2\34\30\3\2"+
		"\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\7\3\2\2\2 \36\3\2\2\2"+
		"!\"\7\5\2\2\"&\b\5\1\2#$\7\6\2\2$&\b\5\1\2%!\3\2\2\2%#\3\2\2\2&\t\3\2"+
		"\2\2\5\22\36%";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}