// Generated from Eloquence.g4 by ANTLR 4.5
package finalProject.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EloquenceParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, BOOLEAN=2, CHAR=3, CONST=4, ELSE=5, EQ=6, FALSE=7, GE=8, GT=9, 
		IF=10, INTEGER=11, LE=12, LT=13, NE=14, NOT=15, OR=16, PROGRAM=17, RETURN=18, 
		TRUE=19, VAR=20, VOID=21, WHILE=22, ASSIGN=23, COMMA=24, DIVIDE=25, LBRACE=26, 
		LPAR=27, LSQBRACKET=28, MINUS=29, MODULO=30, MULTIPLY=31, PLUS=32, RBRACE=33, 
		RPAR=34, RSQBRACKET=35, SEMI=36, ID=37, NUM=38, COMMENT=39, LINE_COMMENT=40, 
		WS=41;
	public static final int
		RULE_program = 0, RULE_body = 1, RULE_decl = 2, RULE_variable = 3, RULE_arrayDecl = 4, 
		RULE_stat = 5, RULE_returnStat = 6, RULE_expression = 7, RULE_unary = 8, 
		RULE_multiply = 9, RULE_addition = 10, RULE_compare = 11, RULE_and = 12, 
		RULE_or = 13, RULE_type = 14, RULE_func = 15, RULE_functionID = 16, RULE_voidFunc = 17, 
		RULE_returnFunc = 18;
	public static final String[] ruleNames = {
		"program", "body", "decl", "variable", "arrayDecl", "stat", "returnStat", 
		"expression", "unary", "multiply", "addition", "compare", "and", "or", 
		"type", "func", "functionID", "voidFunc", "returnFunc"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "'='", 
		"','", "'/'", "'{'", "'('", "'['", "'-'", "'%'", "'*'", "'+'", "'}'", 
		"')'", "']'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "AND", "BOOLEAN", "CHAR", "CONST", "ELSE", "EQ", "FALSE", "GE", 
		"GT", "IF", "INTEGER", "LE", "LT", "NE", "NOT", "OR", "PROGRAM", "RETURN", 
		"TRUE", "VAR", "VOID", "WHILE", "ASSIGN", "COMMA", "DIVIDE", "LBRACE", 
		"LPAR", "LSQBRACKET", "MINUS", "MODULO", "MULTIPLY", "PLUS", "RBRACE", 
		"RPAR", "RSQBRACKET", "SEMI", "ID", "NUM", "COMMENT", "LINE_COMMENT", 
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
	public String getGrammarFileName() { return "Eloquence.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EloquenceParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(EloquenceParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(EloquenceParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(PROGRAM);
			setState(39);
			match(ID);
			setState(40);
			match(LBRACE);
			setState(41);
			body();
			setState(42);
			match(RBRACE);
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

	public static class BodyContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(47);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(44);
						decl();
						}
						break;
					case 2:
						{
						setState(45);
						stat();
						}
						break;
					case 3:
						{
						setState(46);
						func();
						}
						break;
					}
					} 
				}
				setState(51);
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
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	 
		public DeclContext() { }
		public void copyFrom(DeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclArrayContext extends DeclContext {
		public ArrayDeclContext arrayDecl() {
			return getRuleContext(ArrayDeclContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public DeclArrayContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterDeclArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitDeclArray(this);
		}
	}
	public static class DeclConstArrayContext extends DeclContext {
		public TerminalNode CONST() { return getToken(EloquenceParser.CONST, 0); }
		public ArrayDeclContext arrayDecl() {
			return getRuleContext(ArrayDeclContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public DeclConstArrayContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterDeclConstArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitDeclConstArray(this);
		}
	}
	public static class DeclVarContext extends DeclContext {
		public TerminalNode VAR() { return getToken(EloquenceParser.VAR, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclVarContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterDeclVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitDeclVar(this);
		}
	}
	public static class DeclConstVarContext extends DeclContext {
		public TerminalNode CONST() { return getToken(EloquenceParser.CONST, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public DeclConstVarContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterDeclConstVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitDeclConstVar(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		int _la;
		try {
			setState(73);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new DeclVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(VAR);
				setState(53);
				variable();
				setState(56);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(54);
					match(ASSIGN);
					setState(55);
					expression(0);
					}
				}

				setState(58);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new DeclConstVarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(CONST);
				setState(61);
				variable();
				setState(62);
				match(ASSIGN);
				setState(63);
				expression(0);
				setState(64);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new DeclArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				arrayDecl();
				setState(67);
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new DeclConstArrayContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				match(CONST);
				setState(70);
				arrayDecl();
				setState(71);
				match(SEMI);
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

	public static class VariableContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(EloquenceParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EloquenceParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			type();
			setState(76);
			match(ID);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(77);
				match(COMMA);
				setState(78);
				match(ID);
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ArrayDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(EloquenceParser.ID, 0); }
		public TerminalNode LSQBRACKET() { return getToken(EloquenceParser.LSQBRACKET, 0); }
		public TerminalNode NUM() { return getToken(EloquenceParser.NUM, 0); }
		public TerminalNode RSQBRACKET() { return getToken(EloquenceParser.RSQBRACKET, 0); }
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterArrayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitArrayDecl(this);
		}
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arrayDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			type();
			setState(85);
			match(ID);
			setState(86);
			match(LSQBRACKET);
			setState(87);
			match(NUM);
			setState(88);
			match(RSQBRACKET);
			setState(101);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(89);
				match(ASSIGN);
				setState(90);
				match(LBRACE);
				setState(91);
				expression(0);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(92);
					match(COMMA);
					setState(93);
					expression(0);
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(99);
				match(RBRACE);
				}
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatBlockContext extends StatContext {
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public StatBlockContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatBlock(this);
		}
	}
	public static class StatWhileContext extends StatContext {
		public TerminalNode WHILE() { return getToken(EloquenceParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public StatWhileContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatWhile(this);
		}
	}
	public static class StatAssignContext extends StatContext {
		public TerminalNode ID() { return getToken(EloquenceParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public StatAssignContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatAssign(this);
		}
	}
	public static class StatAssignArrayContext extends StatContext {
		public TerminalNode ID() { return getToken(EloquenceParser.ID, 0); }
		public TerminalNode LSQBRACKET() { return getToken(EloquenceParser.LSQBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RSQBRACKET() { return getToken(EloquenceParser.RSQBRACKET, 0); }
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public StatAssignArrayContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatAssignArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatAssignArray(this);
		}
	}
	public static class StatReturnContext extends StatContext {
		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class,0);
		}
		public StatReturnContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatReturn(this);
		}
	}
	public static class StatIfContext extends StatContext {
		public TerminalNode IF() { return getToken(EloquenceParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(EloquenceParser.ELSE, 0); }
		public StatIfContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatIf(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stat);
		try {
			setState(136);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new StatReturnContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				returnStat();
				}
				break;
			case 2:
				_localctx = new StatIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(IF);
				setState(105);
				match(LPAR);
				setState(106);
				expression(0);
				setState(107);
				match(RPAR);
				setState(108);
				stat();
				setState(111);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(109);
					match(ELSE);
					setState(110);
					stat();
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new StatWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(WHILE);
				setState(114);
				match(LPAR);
				setState(115);
				expression(0);
				setState(116);
				match(RPAR);
				setState(117);
				stat();
				}
				break;
			case 4:
				_localctx = new StatAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				match(ID);
				setState(120);
				match(ASSIGN);
				setState(121);
				expression(0);
				setState(122);
				match(SEMI);
				}
				break;
			case 5:
				_localctx = new StatAssignArrayContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				match(ID);
				setState(125);
				match(LSQBRACKET);
				setState(126);
				expression(0);
				setState(127);
				match(RSQBRACKET);
				setState(128);
				match(ASSIGN);
				setState(129);
				expression(0);
				setState(130);
				match(SEMI);
				}
				break;
			case 6:
				_localctx = new StatBlockContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(132);
				match(LBRACE);
				setState(133);
				body();
				setState(134);
				match(RBRACE);
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

	public static class ReturnStatContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(EloquenceParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitReturnStat(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(RETURN);
			setState(140);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << FALSE) | (1L << NOT) | (1L << TRUE) | (1L << MINUS) | (1L << PLUS) | (1L << ID) | (1L << NUM))) != 0)) {
				{
				setState(139);
				expression(0);
				}
			}

			setState(142);
			match(SEMI);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprCompContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public ExprCompContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprComp(this);
		}
	}
	public static class ExprMultContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultiplyContext multiply() {
			return getRuleContext(MultiplyContext.class,0);
		}
		public ExprMultContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprMult(this);
		}
	}
	public static class ExprUnaryContext extends ExpressionContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprUnaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprUnary(this);
		}
	}
	public static class ExprNumContext extends ExpressionContext {
		public TerminalNode NUM() { return getToken(EloquenceParser.NUM, 0); }
		public ExprNumContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprNum(this);
		}
	}
	public static class ExprTrueContext extends ExpressionContext {
		public TerminalNode TRUE() { return getToken(EloquenceParser.TRUE, 0); }
		public ExprTrueContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprTrue(this);
		}
	}
	public static class ExprCharContext extends ExpressionContext {
		public TerminalNode CHAR() { return getToken(EloquenceParser.CHAR, 0); }
		public ExprCharContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprChar(this);
		}
	}
	public static class ExprFuncContext extends ExpressionContext {
		public FunctionIDContext functionID() {
			return getRuleContext(FunctionIDContext.class,0);
		}
		public ExprFuncContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprFunc(this);
		}
	}
	public static class ExprOrContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public ExprOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprOr(this);
		}
	}
	public static class ExprAddContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AdditionContext addition() {
			return getRuleContext(AdditionContext.class,0);
		}
		public ExprAddContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprAdd(this);
		}
	}
	public static class ExprAndContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public ExprAndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprAnd(this);
		}
	}
	public static class ExprIdContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(EloquenceParser.ID, 0); }
		public ExprIdContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprId(this);
		}
	}
	public static class ExprFalseContext extends ExpressionContext {
		public TerminalNode FALSE() { return getToken(EloquenceParser.FALSE, 0); }
		public ExprFalseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprFalse(this);
		}
	}
	public static class ExprArrayContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(EloquenceParser.ID, 0); }
		public TerminalNode LSQBRACKET() { return getToken(EloquenceParser.LSQBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RSQBRACKET() { return getToken(EloquenceParser.RSQBRACKET, 0); }
		public ExprArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprArray(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new ExprUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(145);
				unary();
				setState(146);
				expression(12);
				}
				break;
			case 2:
				{
				_localctx = new ExprFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				functionID();
				}
				break;
			case 3:
				{
				_localctx = new ExprArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				match(ID);
				setState(150);
				match(LSQBRACKET);
				setState(151);
				expression(0);
				setState(152);
				match(RSQBRACKET);
				}
				break;
			case 4:
				{
				_localctx = new ExprIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ExprNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				match(NUM);
				}
				break;
			case 6:
				{
				_localctx = new ExprTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				match(TRUE);
				}
				break;
			case 7:
				{
				_localctx = new ExprFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				match(FALSE);
				}
				break;
			case 8:
				{
				_localctx = new ExprCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158);
				match(CHAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(183);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(181);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(161);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(162);
						multiply();
						setState(163);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(165);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(166);
						addition();
						setState(167);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new ExprCompContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(169);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(170);
						compare();
						setState(171);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new ExprAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(173);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(174);
						and();
						setState(175);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new ExprOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(177);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(178);
						or();
						setState(179);
						expression(8);
						}
						break;
					}
					} 
				}
				setState(185);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class UnaryContext extends ParserRuleContext {
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	 
		public UnaryContext() { }
		public void copyFrom(UnaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaryPlusContext extends UnaryContext {
		public TerminalNode PLUS() { return getToken(EloquenceParser.PLUS, 0); }
		public UnaryPlusContext(UnaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterUnaryPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitUnaryPlus(this);
		}
	}
	public static class UnaryMinContext extends UnaryContext {
		public TerminalNode MINUS() { return getToken(EloquenceParser.MINUS, 0); }
		public UnaryMinContext(UnaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterUnaryMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitUnaryMin(this);
		}
	}
	public static class UnaryNotContext extends UnaryContext {
		public TerminalNode NOT() { return getToken(EloquenceParser.NOT, 0); }
		public UnaryNotContext(UnaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterUnaryNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitUnaryNot(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_unary);
		try {
			setState(189);
			switch (_input.LA(1)) {
			case MINUS:
				_localctx = new UnaryMinContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(MINUS);
				}
				break;
			case PLUS:
				_localctx = new UnaryPlusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(PLUS);
				}
				break;
			case NOT:
				_localctx = new UnaryNotContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(188);
				match(NOT);
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

	public static class MultiplyContext extends ParserRuleContext {
		public MultiplyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiply; }
	 
		public MultiplyContext() { }
		public void copyFrom(MultiplyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultDivContext extends MultiplyContext {
		public TerminalNode DIVIDE() { return getToken(EloquenceParser.DIVIDE, 0); }
		public MultDivContext(MultiplyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterMultDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitMultDiv(this);
		}
	}
	public static class MultModContext extends MultiplyContext {
		public TerminalNode MODULO() { return getToken(EloquenceParser.MODULO, 0); }
		public MultModContext(MultiplyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterMultMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitMultMod(this);
		}
	}
	public static class MultMultContext extends MultiplyContext {
		public TerminalNode MULTIPLY() { return getToken(EloquenceParser.MULTIPLY, 0); }
		public MultMultContext(MultiplyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterMultMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitMultMult(this);
		}
	}

	public final MultiplyContext multiply() throws RecognitionException {
		MultiplyContext _localctx = new MultiplyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_multiply);
		try {
			setState(194);
			switch (_input.LA(1)) {
			case MULTIPLY:
				_localctx = new MultMultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(MULTIPLY);
				}
				break;
			case DIVIDE:
				_localctx = new MultDivContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(DIVIDE);
				}
				break;
			case MODULO:
				_localctx = new MultModContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
				match(MODULO);
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

	public static class AdditionContext extends ParserRuleContext {
		public AdditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addition; }
	 
		public AdditionContext() { }
		public void copyFrom(AdditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddPlusContext extends AdditionContext {
		public TerminalNode PLUS() { return getToken(EloquenceParser.PLUS, 0); }
		public AddPlusContext(AdditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterAddPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitAddPlus(this);
		}
	}
	public static class AddMinContext extends AdditionContext {
		public TerminalNode MINUS() { return getToken(EloquenceParser.MINUS, 0); }
		public AddMinContext(AdditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterAddMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitAddMin(this);
		}
	}

	public final AdditionContext addition() throws RecognitionException {
		AdditionContext _localctx = new AdditionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_addition);
		try {
			setState(198);
			switch (_input.LA(1)) {
			case PLUS:
				_localctx = new AddPlusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(PLUS);
				}
				break;
			case MINUS:
				_localctx = new AddMinContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(MINUS);
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

	public static class CompareContext extends ParserRuleContext {
		public CompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare; }
	 
		public CompareContext() { }
		public void copyFrom(CompareContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CompGreatContext extends CompareContext {
		public TerminalNode GT() { return getToken(EloquenceParser.GT, 0); }
		public CompGreatContext(CompareContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterCompGreat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitCompGreat(this);
		}
	}
	public static class CompEqContext extends CompareContext {
		public TerminalNode EQ() { return getToken(EloquenceParser.EQ, 0); }
		public CompEqContext(CompareContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterCompEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitCompEq(this);
		}
	}
	public static class CompLessEqContext extends CompareContext {
		public TerminalNode LE() { return getToken(EloquenceParser.LE, 0); }
		public CompLessEqContext(CompareContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterCompLessEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitCompLessEq(this);
		}
	}
	public static class CompGreatEqContext extends CompareContext {
		public TerminalNode GE() { return getToken(EloquenceParser.GE, 0); }
		public CompGreatEqContext(CompareContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterCompGreatEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitCompGreatEq(this);
		}
	}
	public static class CompLessContext extends CompareContext {
		public TerminalNode LT() { return getToken(EloquenceParser.LT, 0); }
		public CompLessContext(CompareContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterCompLess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitCompLess(this);
		}
	}
	public static class CompNotEqContext extends CompareContext {
		public TerminalNode NE() { return getToken(EloquenceParser.NE, 0); }
		public CompNotEqContext(CompareContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterCompNotEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitCompNotEq(this);
		}
	}

	public final CompareContext compare() throws RecognitionException {
		CompareContext _localctx = new CompareContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_compare);
		try {
			setState(206);
			switch (_input.LA(1)) {
			case LT:
				_localctx = new CompLessContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				match(LT);
				}
				break;
			case LE:
				_localctx = new CompLessEqContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(LE);
				}
				break;
			case GE:
				_localctx = new CompGreatEqContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
				match(GE);
				}
				break;
			case GT:
				_localctx = new CompGreatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(203);
				match(GT);
				}
				break;
			case EQ:
				_localctx = new CompEqContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				match(EQ);
				}
				break;
			case NE:
				_localctx = new CompNotEqContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(205);
				match(NE);
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

	public static class AndContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(EloquenceParser.AND, 0); }
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitAnd(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(AND);
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

	public static class OrContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(EloquenceParser.OR, 0); }
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitOr(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(OR);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeIntContext extends TypeContext {
		public TerminalNode INTEGER() { return getToken(EloquenceParser.INTEGER, 0); }
		public TypeIntContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterTypeInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitTypeInt(this);
		}
	}
	public static class TypeCharContext extends TypeContext {
		public TerminalNode CHAR() { return getToken(EloquenceParser.CHAR, 0); }
		public TypeCharContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterTypeChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitTypeChar(this);
		}
	}
	public static class TypeBoolContext extends TypeContext {
		public TerminalNode BOOLEAN() { return getToken(EloquenceParser.BOOLEAN, 0); }
		public TypeBoolContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterTypeBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitTypeBool(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_type);
		try {
			setState(215);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new TypeIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				match(INTEGER);
				}
				break;
			case BOOLEAN:
				_localctx = new TypeBoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(BOOLEAN);
				}
				break;
			case CHAR:
				_localctx = new TypeCharContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				match(CHAR);
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

	public static class FuncContext extends ParserRuleContext {
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	 
		public FuncContext() { }
		public void copyFrom(FuncContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncReturnContext extends FuncContext {
		public ReturnFuncContext returnFunc() {
			return getRuleContext(ReturnFuncContext.class,0);
		}
		public FuncReturnContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterFuncReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitFuncReturn(this);
		}
	}
	public static class FuncVoidContext extends FuncContext {
		public VoidFuncContext voidFunc() {
			return getRuleContext(VoidFuncContext.class,0);
		}
		public FuncVoidContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterFuncVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitFuncVoid(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_func);
		try {
			setState(219);
			switch (_input.LA(1)) {
			case VOID:
				_localctx = new FuncVoidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				voidFunc();
				}
				break;
			case BOOLEAN:
			case CHAR:
			case INTEGER:
				_localctx = new FuncReturnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				returnFunc();
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

	public static class FunctionIDContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(EloquenceParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EloquenceParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public FunctionIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterFunctionID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitFunctionID(this);
		}
	}

	public final FunctionIDContext functionID() throws RecognitionException {
		FunctionIDContext _localctx = new FunctionIDContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_functionID);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(ID);
			setState(222);
			match(LPAR);
			setState(231);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(223);
				match(ID);
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(224);
					match(COMMA);
					setState(225);
					match(ID);
					}
					}
					setState(230);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(233);
			match(RPAR);
			setState(234);
			match(LBRACE);
			setState(235);
			body();
			setState(236);
			match(RBRACE);
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

	public static class VoidFuncContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(EloquenceParser.VOID, 0); }
		public List<TerminalNode> ID() { return getTokens(EloquenceParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EloquenceParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public VoidFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterVoidFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitVoidFunc(this);
		}
	}

	public final VoidFuncContext voidFunc() throws RecognitionException {
		VoidFuncContext _localctx = new VoidFuncContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_voidFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(VOID);
			setState(239);
			match(ID);
			setState(240);
			match(LPAR);
			setState(252);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INTEGER))) != 0)) {
				{
				setState(241);
				type();
				setState(242);
				match(ID);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(243);
					match(COMMA);
					setState(244);
					type();
					setState(245);
					match(ID);
					}
					}
					setState(251);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(254);
			match(RPAR);
			setState(255);
			match(LBRACE);
			setState(256);
			body();
			setState(257);
			match(RBRACE);
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

	public static class ReturnFuncContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(EloquenceParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EloquenceParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public ReturnFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterReturnFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitReturnFunc(this);
		}
	}

	public final ReturnFuncContext returnFunc() throws RecognitionException {
		ReturnFuncContext _localctx = new ReturnFuncContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_returnFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			type();
			setState(260);
			match(ID);
			setState(261);
			match(LPAR);
			setState(273);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INTEGER))) != 0)) {
				{
				setState(262);
				type();
				setState(263);
				match(ID);
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(264);
					match(COMMA);
					setState(265);
					type();
					setState(266);
					match(ID);
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(275);
			match(RPAR);
			setState(276);
			match(LBRACE);
			setState(277);
			body();
			setState(278);
			returnStat();
			setState(279);
			match(RBRACE);
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
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u011c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3\62\n\3\f"+
		"\3\16\3\65\13\3\3\4\3\4\3\4\3\4\5\4;\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4L\n\4\3\5\3\5\3\5\3\5\7\5R\n\5\f\5\16"+
		"\5U\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6a\n\6\f\6\16\6d\13"+
		"\6\3\6\3\6\5\6h\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7r\n\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7\u008b\n\7\3\b\3\b\5\b\u008f\n\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a2\n\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\7\t\u00b8\n\t\f\t\16\t\u00bb\13\t\3\n\3\n\3\n\5\n\u00c0\n\n\3\13\3\13"+
		"\3\13\5\13\u00c5\n\13\3\f\3\f\5\f\u00c9\n\f\3\r\3\r\3\r\3\r\3\r\3\r\5"+
		"\r\u00d1\n\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\5\20\u00da\n\20\3\21\3"+
		"\21\5\21\u00de\n\21\3\22\3\22\3\22\3\22\3\22\7\22\u00e5\n\22\f\22\16\22"+
		"\u00e8\13\22\5\22\u00ea\n\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\7\23\u00fa\n\23\f\23\16\23\u00fd\13\23\5"+
		"\23\u00ff\n\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\7\24\u010f\n\24\f\24\16\24\u0112\13\24\5\24\u0114\n\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\2\3\20\25\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&\2\2\u0138\2(\3\2\2\2\4\63\3\2\2\2\6K\3\2\2\2\bM\3"+
		"\2\2\2\nV\3\2\2\2\f\u008a\3\2\2\2\16\u008c\3\2\2\2\20\u00a1\3\2\2\2\22"+
		"\u00bf\3\2\2\2\24\u00c4\3\2\2\2\26\u00c8\3\2\2\2\30\u00d0\3\2\2\2\32\u00d2"+
		"\3\2\2\2\34\u00d4\3\2\2\2\36\u00d9\3\2\2\2 \u00dd\3\2\2\2\"\u00df\3\2"+
		"\2\2$\u00f0\3\2\2\2&\u0105\3\2\2\2()\7\23\2\2)*\7\'\2\2*+\7\34\2\2+,\5"+
		"\4\3\2,-\7#\2\2-\3\3\2\2\2.\62\5\6\4\2/\62\5\f\7\2\60\62\5 \21\2\61.\3"+
		"\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2"+
		"\2\2\64\5\3\2\2\2\65\63\3\2\2\2\66\67\7\26\2\2\67:\5\b\5\289\7\31\2\2"+
		"9;\5\20\t\2:8\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7&\2\2=L\3\2\2\2>?\7\6\2\2"+
		"?@\5\b\5\2@A\7\31\2\2AB\5\20\t\2BC\7&\2\2CL\3\2\2\2DE\5\n\6\2EF\7&\2\2"+
		"FL\3\2\2\2GH\7\6\2\2HI\5\n\6\2IJ\7&\2\2JL\3\2\2\2K\66\3\2\2\2K>\3\2\2"+
		"\2KD\3\2\2\2KG\3\2\2\2L\7\3\2\2\2MN\5\36\20\2NS\7\'\2\2OP\7\32\2\2PR\7"+
		"\'\2\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\t\3\2\2\2US\3\2\2\2VW"+
		"\5\36\20\2WX\7\'\2\2XY\7\36\2\2YZ\7(\2\2Zg\7%\2\2[\\\7\31\2\2\\]\7\34"+
		"\2\2]b\5\20\t\2^_\7\32\2\2_a\5\20\t\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc"+
		"\3\2\2\2ce\3\2\2\2db\3\2\2\2ef\7#\2\2fh\3\2\2\2g[\3\2\2\2gh\3\2\2\2h\13"+
		"\3\2\2\2i\u008b\5\16\b\2jk\7\f\2\2kl\7\35\2\2lm\5\20\t\2mn\7$\2\2nq\5"+
		"\f\7\2op\7\7\2\2pr\5\f\7\2qo\3\2\2\2qr\3\2\2\2r\u008b\3\2\2\2st\7\30\2"+
		"\2tu\7\35\2\2uv\5\20\t\2vw\7$\2\2wx\5\f\7\2x\u008b\3\2\2\2yz\7\'\2\2z"+
		"{\7\31\2\2{|\5\20\t\2|}\7&\2\2}\u008b\3\2\2\2~\177\7\'\2\2\177\u0080\7"+
		"\36\2\2\u0080\u0081\5\20\t\2\u0081\u0082\7%\2\2\u0082\u0083\7\31\2\2\u0083"+
		"\u0084\5\20\t\2\u0084\u0085\7&\2\2\u0085\u008b\3\2\2\2\u0086\u0087\7\34"+
		"\2\2\u0087\u0088\5\4\3\2\u0088\u0089\7#\2\2\u0089\u008b\3\2\2\2\u008a"+
		"i\3\2\2\2\u008aj\3\2\2\2\u008as\3\2\2\2\u008ay\3\2\2\2\u008a~\3\2\2\2"+
		"\u008a\u0086\3\2\2\2\u008b\r\3\2\2\2\u008c\u008e\7\24\2\2\u008d\u008f"+
		"\5\20\t\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2"+
		"\u0090\u0091\7&\2\2\u0091\17\3\2\2\2\u0092\u0093\b\t\1\2\u0093\u0094\5"+
		"\22\n\2\u0094\u0095\5\20\t\16\u0095\u00a2\3\2\2\2\u0096\u00a2\5\"\22\2"+
		"\u0097\u0098\7\'\2\2\u0098\u0099\7\36\2\2\u0099\u009a\5\20\t\2\u009a\u009b"+
		"\7%\2\2\u009b\u00a2\3\2\2\2\u009c\u00a2\7\'\2\2\u009d\u00a2\7(\2\2\u009e"+
		"\u00a2\7\25\2\2\u009f\u00a2\7\t\2\2\u00a0\u00a2\7\5\2\2\u00a1\u0092\3"+
		"\2\2\2\u00a1\u0096\3\2\2\2\u00a1\u0097\3\2\2\2\u00a1\u009c\3\2\2\2\u00a1"+
		"\u009d\3\2\2\2\u00a1\u009e\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2"+
		"\2\2\u00a2\u00b9\3\2\2\2\u00a3\u00a4\f\r\2\2\u00a4\u00a5\5\24\13\2\u00a5"+
		"\u00a6\5\20\t\16\u00a6\u00b8\3\2\2\2\u00a7\u00a8\f\f\2\2\u00a8\u00a9\5"+
		"\26\f\2\u00a9\u00aa\5\20\t\r\u00aa\u00b8\3\2\2\2\u00ab\u00ac\f\13\2\2"+
		"\u00ac\u00ad\5\30\r\2\u00ad\u00ae\5\20\t\f\u00ae\u00b8\3\2\2\2\u00af\u00b0"+
		"\f\n\2\2\u00b0\u00b1\5\32\16\2\u00b1\u00b2\5\20\t\13\u00b2\u00b8\3\2\2"+
		"\2\u00b3\u00b4\f\t\2\2\u00b4\u00b5\5\34\17\2\u00b5\u00b6\5\20\t\n\u00b6"+
		"\u00b8\3\2\2\2\u00b7\u00a3\3\2\2\2\u00b7\u00a7\3\2\2\2\u00b7\u00ab\3\2"+
		"\2\2\u00b7\u00af\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\21\3\2\2\2\u00bb\u00b9\3\2\2"+
		"\2\u00bc\u00c0\7\37\2\2\u00bd\u00c0\7\"\2\2\u00be\u00c0\7\21\2\2\u00bf"+
		"\u00bc\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0\23\3\2\2"+
		"\2\u00c1\u00c5\7!\2\2\u00c2\u00c5\7\33\2\2\u00c3\u00c5\7 \2\2\u00c4\u00c1"+
		"\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\25\3\2\2\2\u00c6"+
		"\u00c9\7\"\2\2\u00c7\u00c9\7\37\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3"+
		"\2\2\2\u00c9\27\3\2\2\2\u00ca\u00d1\7\17\2\2\u00cb\u00d1\7\16\2\2\u00cc"+
		"\u00d1\7\n\2\2\u00cd\u00d1\7\13\2\2\u00ce\u00d1\7\b\2\2\u00cf\u00d1\7"+
		"\20\2\2\u00d0\u00ca\3\2\2\2\u00d0\u00cb\3\2\2\2\u00d0\u00cc\3\2\2\2\u00d0"+
		"\u00cd\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\31\3\2\2"+
		"\2\u00d2\u00d3\7\3\2\2\u00d3\33\3\2\2\2\u00d4\u00d5\7\22\2\2\u00d5\35"+
		"\3\2\2\2\u00d6\u00da\7\r\2\2\u00d7\u00da\7\4\2\2\u00d8\u00da\7\5\2\2\u00d9"+
		"\u00d6\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\37\3\2\2"+
		"\2\u00db\u00de\5$\23\2\u00dc\u00de\5&\24\2\u00dd\u00db\3\2\2\2\u00dd\u00dc"+
		"\3\2\2\2\u00de!\3\2\2\2\u00df\u00e0\7\'\2\2\u00e0\u00e9\7\35\2\2\u00e1"+
		"\u00e6\7\'\2\2\u00e2\u00e3\7\32\2\2\u00e3\u00e5\7\'\2\2\u00e4\u00e2\3"+
		"\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00e1\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\7$\2\2\u00ec\u00ed\7\34\2\2\u00ed"+
		"\u00ee\5\4\3\2\u00ee\u00ef\7#\2\2\u00ef#\3\2\2\2\u00f0\u00f1\7\27\2\2"+
		"\u00f1\u00f2\7\'\2\2\u00f2\u00fe\7\35\2\2\u00f3\u00f4\5\36\20\2\u00f4"+
		"\u00fb\7\'\2\2\u00f5\u00f6\7\32\2\2\u00f6\u00f7\5\36\20\2\u00f7\u00f8"+
		"\7\'\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f5\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2"+
		"\2\2\u00fe\u00f3\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\3\2\2\2\u0100"+
		"\u0101\7$\2\2\u0101\u0102\7\34\2\2\u0102\u0103\5\4\3\2\u0103\u0104\7#"+
		"\2\2\u0104%\3\2\2\2\u0105\u0106\5\36\20\2\u0106\u0107\7\'\2\2\u0107\u0113"+
		"\7\35\2\2\u0108\u0109\5\36\20\2\u0109\u0110\7\'\2\2\u010a\u010b\7\32\2"+
		"\2\u010b\u010c\5\36\20\2\u010c\u010d\7\'\2\2\u010d\u010f\3\2\2\2\u010e"+
		"\u010a\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2"+
		"\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0108\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\7$\2\2\u0116\u0117\7\34"+
		"\2\2\u0117\u0118\5\4\3\2\u0118\u0119\5\16\b\2\u0119\u011a\7#\2\2\u011a"+
		"\'\3\2\2\2\33\61\63:KSbgq\u008a\u008e\u00a1\u00b7\u00b9\u00bf\u00c4\u00c8"+
		"\u00d0\u00d9\u00dd\u00e6\u00e9\u00fb\u00fe\u0110\u0113";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}