// Generated from TGram.g4 by ANTLR 4.5
package pp.block3.cc.antlr;
package pp.block3.cc.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TGramParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HAT=1, PLUS=2, EQUALS=3, LPAR=4, RPAR=5, NUMBER=6, BOOL=7, STR=8, WS=9;
	public static final int
		RULE_t = 0;
	public static final String[] ruleNames = {
		"t"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'^'", "'+'", "'='", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HAT", "PLUS", "EQUALS", "LPAR", "RPAR", "NUMBER", "BOOL", "STR", 
		"WS"
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
	public String getGrammarFileName() { return "TGram.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private int getValue(String text) {
	        return Integer.parseInt(text);
	    }
	    
	    private boolean getBoolValue(String text){
	    	if(text.equals("true"))
	    		return true;
	    	return false;
	    }
	    
	    private String hat(String text, int number){
	    	String output = "";
	    	for(int index = 0; index < number; index++)
	    		output += text;
	    	return output;    	
	    }

	public TGramParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TContext extends ParserRuleContext {
		public Type type;
		public int intVal;
		public boolean boolVal;
		public String strVal;
		public TContext t0;
		public Token NUMBER;
		public Token BOOL;
		public Token STR;
		public TContext t1;
		public TerminalNode LPAR() { return getToken(TGramParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(TGramParser.RPAR, 0); }
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public TerminalNode NUMBER() { return getToken(TGramParser.NUMBER, 0); }
		public TerminalNode BOOL() { return getToken(TGramParser.BOOL, 0); }
		public TerminalNode STR() { return getToken(TGramParser.STR, 0); }
		public TerminalNode HAT() { return getToken(TGramParser.HAT, 0); }
		public TerminalNode PLUS() { return getToken(TGramParser.PLUS, 0); }
		public TerminalNode EQUALS() { return getToken(TGramParser.EQUALS, 0); }
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TGramListener ) ((TGramListener)listener).enterT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TGramListener ) ((TGramListener)listener).exitT(this);
		}
	}

	public final TContext t() throws RecognitionException {
		return t(0);
	}

	private TContext t(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TContext _localctx = new TContext(_ctx, _parentState);
		TContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_t, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(3);
				match(LPAR);
				setState(4);
				((TContext)_localctx).t0 = t(0);
				setState(5);
				match(RPAR);
				((TContext)_localctx).type =  ((TContext)_localctx).t0.type;  if(((TContext)_localctx).t0.type == Type.NUM)
																((TContext)_localctx).intVal =  ((TContext)_localctx).t0.intVal;
															else if(((TContext)_localctx).t0.type == Type.BOOL)
																((TContext)_localctx).boolVal =  ((TContext)_localctx).t0.boolVal;
															else
																((TContext)_localctx).strVal =  '(' + ((TContext)_localctx).t0.strVal + ')';
															
				}
				break;
			case NUMBER:
				{
				setState(8);
				((TContext)_localctx).NUMBER = match(NUMBER);
				((TContext)_localctx).type =  Type.NUM;  ((TContext)_localctx).intVal =  getValue((((TContext)_localctx).NUMBER!=null?((TContext)_localctx).NUMBER.getText():null));
				}
				break;
			case BOOL:
				{
				setState(10);
				((TContext)_localctx).BOOL = match(BOOL);
				((TContext)_localctx).type =  Type.BOOL; ((TContext)_localctx).boolVal =  getBoolValue((((TContext)_localctx).BOOL!=null?((TContext)_localctx).BOOL.getText():null));
				}
				break;
			case STR:
				{
				setState(12);
				((TContext)_localctx).STR = match(STR);
				((TContext)_localctx).type =  Type.STR;  ((TContext)_localctx).strVal =  (((TContext)_localctx).STR!=null?((TContext)_localctx).STR.getText():null);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(31);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new TContext(_parentctx, _parentState);
						_localctx.t0 = _prevctx;
						_localctx.t0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_t);
						setState(16);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(17);
						match(HAT);
						setState(18);
						((TContext)_localctx).t1 = t(8);
						((TContext)_localctx).type =  ((TContext)_localctx).t0.type;  if(((TContext)_localctx).t0.type == Type.NUM && ((TContext)_localctx).t1.type == Type.NUM)
						          												((TContext)_localctx).intVal =  (int) Math.pow(((TContext)_localctx).t0.intVal, ((TContext)_localctx).t1.intVal);
						          											else if(((TContext)_localctx).t0.type == Type.STR && ((TContext)_localctx).t1.type == Type.NUM)
						          												((TContext)_localctx).strVal =  hat(((TContext)_localctx).t0.strVal, ((TContext)_localctx).t1.intVal);
						          	
						}
						break;
					case 2:
						{
						_localctx = new TContext(_parentctx, _parentState);
						_localctx.t0 = _prevctx;
						_localctx.t0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_t);
						setState(21);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(22);
						match(PLUS);
						setState(23);
						((TContext)_localctx).t1 = t(7);
						((TContext)_localctx).type =  ((TContext)_localctx).t0.type;  if(((TContext)_localctx).t0.type == Type.NUM)
						          												((TContext)_localctx).intVal =  ((TContext)_localctx).t0.intVal + ((TContext)_localctx).t1.intVal;
						          											else if(((TContext)_localctx).t0.type == Type.BOOL)
						          												((TContext)_localctx).boolVal =  ((TContext)_localctx).t0.boolVal | ((TContext)_localctx).t1.boolVal;
						          											else
						          												((TContext)_localctx).strVal =  ((TContext)_localctx).t0.strVal + ((TContext)_localctx).t1.strVal;
						          											
						}
						break;
					case 3:
						{
						_localctx = new TContext(_parentctx, _parentState);
						_localctx.t0 = _prevctx;
						_localctx.t0 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_t);
						setState(26);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(27);
						match(EQUALS);
						setState(28);
						((TContext)_localctx).t1 = t(6);
						((TContext)_localctx).type =  Type.BOOL; if(((TContext)_localctx).t0.type == ((TContext)_localctx).t1.type){
						          												if(((TContext)_localctx).t0.type == Type.NUM)
						          													((TContext)_localctx).boolVal =  ((TContext)_localctx).t0.intVal == ((TContext)_localctx).t1.intVal;
						          												else if(((TContext)_localctx).t0.type == Type.BOOL)
						          													((TContext)_localctx).boolVal =  ((TContext)_localctx).t0.boolVal == ((TContext)_localctx).t1.boolVal;
						          												else
						          													((TContext)_localctx).boolVal =  ((TContext)_localctx).t0.strVal.equals(((TContext)_localctx).t1.strVal);
						          											}else
						          												((TContext)_localctx).boolVal =  false;
						          											
						}
						break;
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return t_sempred((TContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean t_sempred(TContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13\'\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\21\n\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\"\n\2\f\2\16\2%\13"+
		"\2\3\2\2\3\2\3\2\2\2+\2\20\3\2\2\2\4\5\b\2\1\2\5\6\7\6\2\2\6\7\5\2\2\2"+
		"\7\b\7\7\2\2\b\t\b\2\1\2\t\21\3\2\2\2\n\13\7\b\2\2\13\21\b\2\1\2\f\r\7"+
		"\t\2\2\r\21\b\2\1\2\16\17\7\n\2\2\17\21\b\2\1\2\20\4\3\2\2\2\20\n\3\2"+
		"\2\2\20\f\3\2\2\2\20\16\3\2\2\2\21#\3\2\2\2\22\23\f\t\2\2\23\24\7\3\2"+
		"\2\24\25\5\2\2\n\25\26\b\2\1\2\26\"\3\2\2\2\27\30\f\b\2\2\30\31\7\4\2"+
		"\2\31\32\5\2\2\t\32\33\b\2\1\2\33\"\3\2\2\2\34\35\f\7\2\2\35\36\7\5\2"+
		"\2\36\37\5\2\2\b\37 \b\2\1\2 \"\3\2\2\2!\22\3\2\2\2!\27\3\2\2\2!\34\3"+
		"\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\3\3\2\2\2%#\3\2\2\2\5\20!#";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}