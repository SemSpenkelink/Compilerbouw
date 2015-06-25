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
		AND=1, ARRAY=2, BOOLEAN=3, CHAR=4, CONST=5, ELSE=6, EQ=7, FALSE=8, GE=9, 
		GT=10, IF=11, IN=12, INTEGER=13, LE=14, LT=15, NE=16, NOT=17, OR=18, OUT=19, 
		PROGRAM=20, RETURN=21, TRUE=22, VAR=23, VOID=24, WHILE=25, ASSIGN=26, 
		COMMA=27, DIVIDE=28, DOT=29, LBRACE=30, LPAR=31, LSQBRACKET=32, MINUS=33, 
		MODULO=34, MULTIPLY=35, PLUS=36, QUOTE=37, RBRACE=38, RPAR=39, RSQBRACKET=40, 
		SEMI=41, SETARRAY=42, ID=43, NUM=44, CHARACTER=45, COMMENT=46, LINE_COMMENT=47, 
		WS=48;
	public static final int
		RULE_program = 0, RULE_body = 1, RULE_decl = 2, RULE_variable = 3, RULE_arrayTypeDecl = 4, 
		RULE_arrayDecl = 5, RULE_stat = 6, RULE_statBlockBody = 7, RULE_target = 8, 
		RULE_newID = 9, RULE_returnStat = 10, RULE_expression = 11, RULE_arrayExpression = 12, 
		RULE_unary = 13, RULE_multiply = 14, RULE_addition = 15, RULE_compare = 16, 
		RULE_and = 17, RULE_or = 18, RULE_type = 19, RULE_func = 20, RULE_functionID = 21, 
		RULE_voidFunc = 22, RULE_returnFunc = 23, RULE_parameters = 24;
	public static final String[] ruleNames = {
		"program", "body", "decl", "variable", "arrayTypeDecl", "arrayDecl", "stat", 
		"statBlockBody", "target", "newID", "returnStat", "expression", "arrayExpression", 
		"unary", "multiply", "addition", "compare", "and", "or", "type", "func", 
		"functionID", "voidFunc", "returnFunc", "parameters"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "'='", "','", "'/'", "'.'", "'{'", "'('", "'['", "'-'", "'%'", 
		"'*'", "'+'", "'''", "'}'", "')'", "']'", "';'", "'<<'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "AND", "ARRAY", "BOOLEAN", "CHAR", "CONST", "ELSE", "EQ", "FALSE", 
		"GE", "GT", "IF", "IN", "INTEGER", "LE", "LT", "NE", "NOT", "OR", "OUT", 
		"PROGRAM", "RETURN", "TRUE", "VAR", "VOID", "WHILE", "ASSIGN", "COMMA", 
		"DIVIDE", "DOT", "LBRACE", "LPAR", "LSQBRACKET", "MINUS", "MODULO", "MULTIPLY", 
		"PLUS", "QUOTE", "RBRACE", "RPAR", "RSQBRACKET", "SEMI", "SETARRAY", "ID", 
		"NUM", "CHARACTER", "COMMENT", "LINE_COMMENT", "WS"
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
			setState(50);
			match(PROGRAM);
			setState(51);
			match(ID);
			setState(52);
			match(LBRACE);
			setState(53);
			body();
			setState(54);
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
		public List<ArrayTypeDeclContext> arrayTypeDecl() {
			return getRuleContexts(ArrayTypeDeclContext.class);
		}
		public ArrayTypeDeclContext arrayTypeDecl(int i) {
			return getRuleContext(ArrayTypeDeclContext.class,i);
		}
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
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(60);
					switch (_input.LA(1)) {
					case ARRAY:
						{
						setState(56);
						arrayTypeDecl();
						}
						break;
					case CONST:
					case VAR:
						{
						setState(57);
						decl();
						}
						break;
					case IF:
					case IN:
					case OUT:
					case RETURN:
					case WHILE:
					case LBRACE:
					case ID:
						{
						setState(58);
						stat();
						}
						break;
					case BOOLEAN:
					case CHAR:
					case INTEGER:
					case VOID:
						{
						setState(59);
						func();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(64);
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
			setState(82);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new DeclVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(VAR);
				setState(66);
				variable();
				setState(69);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(67);
					match(ASSIGN);
					setState(68);
					expression(0);
					}
				}

				setState(71);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new DeclConstVarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(CONST);
				setState(74);
				variable();
				setState(75);
				match(ASSIGN);
				setState(76);
				expression(0);
				setState(77);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new DeclArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				arrayDecl();
				setState(80);
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
		public List<NewIDContext> newID() {
			return getRuleContexts(NewIDContext.class);
		}
		public NewIDContext newID(int i) {
			return getRuleContext(NewIDContext.class,i);
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
			setState(84);
			type();
			setState(85);
			newID();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(86);
				match(COMMA);
				setState(87);
				newID();
				}
				}
				setState(92);
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

	public static class ArrayTypeDeclContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(EloquenceParser.ARRAY, 0); }
		public NewIDContext newID() {
			return getRuleContext(NewIDContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LSQBRACKET() { return getToken(EloquenceParser.LSQBRACKET, 0); }
		public List<TerminalNode> NUM() { return getTokens(EloquenceParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(EloquenceParser.NUM, i);
		}
		public List<TerminalNode> DOT() { return getTokens(EloquenceParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(EloquenceParser.DOT, i);
		}
		public TerminalNode RSQBRACKET() { return getToken(EloquenceParser.RSQBRACKET, 0); }
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public ArrayTypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayTypeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterArrayTypeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitArrayTypeDecl(this);
		}
	}

	public final ArrayTypeDeclContext arrayTypeDecl() throws RecognitionException {
		ArrayTypeDeclContext _localctx = new ArrayTypeDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arrayTypeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(ARRAY);
			setState(94);
			newID();
			setState(95);
			match(ASSIGN);
			setState(96);
			type();
			setState(97);
			match(LSQBRACKET);
			setState(98);
			match(NUM);
			setState(99);
			match(DOT);
			setState(100);
			match(DOT);
			setState(101);
			match(NUM);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(102);
				match(COMMA);
				setState(103);
				match(NUM);
				setState(104);
				match(DOT);
				setState(105);
				match(DOT);
				setState(106);
				match(NUM);
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
			match(RSQBRACKET);
			setState(113);
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

	public static class ArrayDeclContext extends ParserRuleContext {
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
	 
		public ArrayDeclContext() { }
		public void copyFrom(ArrayDeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarArrayDeclContext extends ArrayDeclContext {
		public TerminalNode VAR() { return getToken(EloquenceParser.VAR, 0); }
		public List<NewIDContext> newID() {
			return getRuleContexts(NewIDContext.class);
		}
		public NewIDContext newID(int i) {
			return getRuleContext(NewIDContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public VarArrayDeclContext(ArrayDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterVarArrayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitVarArrayDecl(this);
		}
	}
	public static class ConstArrayDeclContext extends ArrayDeclContext {
		public TerminalNode CONST() { return getToken(EloquenceParser.CONST, 0); }
		public TerminalNode ARRAY() { return getToken(EloquenceParser.ARRAY, 0); }
		public List<NewIDContext> newID() {
			return getRuleContexts(NewIDContext.class);
		}
		public NewIDContext newID(int i) {
			return getRuleContext(NewIDContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode SETARRAY() { return getToken(EloquenceParser.SETARRAY, 0); }
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public List<ArrayExpressionContext> arrayExpression() {
			return getRuleContexts(ArrayExpressionContext.class);
		}
		public ArrayExpressionContext arrayExpression(int i) {
			return getRuleContext(ArrayExpressionContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public ConstArrayDeclContext(ArrayDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterConstArrayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitConstArrayDecl(this);
		}
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arrayDecl);
		int _la;
		try {
			setState(151);
			switch (_input.LA(1)) {
			case VAR:
				_localctx = new VarArrayDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(VAR);
				setState(116);
				newID();
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(117);
					match(COMMA);
					setState(118);
					newID();
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(124);
				match(ASSIGN);
				setState(125);
				target();
				}
				break;
			case CONST:
				_localctx = new ConstArrayDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				match(CONST);
				setState(128);
				match(ARRAY);
				setState(129);
				newID();
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(130);
					match(COMMA);
					setState(131);
					newID();
					}
					}
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(137);
				match(ASSIGN);
				setState(138);
				target();
				setState(139);
				match(SETARRAY);
				setState(140);
				match(LBRACE);
				setState(141);
				arrayExpression();
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(142);
					match(COMMA);
					setState(143);
					arrayExpression();
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(149);
				match(RBRACE);
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
		public StatBlockBodyContext statBlockBody() {
			return getRuleContext(StatBlockBodyContext.class,0);
		}
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
	public static class StatOutContext extends StatContext {
		public TerminalNode OUT() { return getToken(EloquenceParser.OUT, 0); }
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public StatOutContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatOut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatOut(this);
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
	public static class StatInContext extends StatContext {
		public TerminalNode IN() { return getToken(EloquenceParser.IN, 0); }
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public List<TargetContext> target() {
			return getRuleContexts(TargetContext.class);
		}
		public TargetContext target(int i) {
			return getRuleContext(TargetContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public StatInContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatIn(this);
		}
	}
	public static class StatAssignContext extends StatContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
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
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
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
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
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
	public static class StatAssignArrayMultContext extends StatContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public List<ArrayExpressionContext> arrayExpression() {
			return getRuleContexts(ArrayExpressionContext.class);
		}
		public ArrayExpressionContext arrayExpression(int i) {
			return getRuleContext(ArrayExpressionContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public StatAssignArrayMultContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatAssignArrayMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatAssignArrayMult(this);
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

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stat);
		int _la;
		try {
			setState(230);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new StatIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				match(IF);
				setState(154);
				match(LPAR);
				setState(155);
				expression(0);
				setState(156);
				match(RPAR);
				setState(157);
				stat();
				setState(160);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(158);
					match(ELSE);
					setState(159);
					stat();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new StatWhileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				match(WHILE);
				setState(163);
				match(LPAR);
				setState(164);
				expression(0);
				setState(165);
				match(RPAR);
				setState(166);
				stat();
				}
				break;
			case 3:
				_localctx = new StatAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				target();
				setState(169);
				match(ASSIGN);
				setState(170);
				expression(0);
				setState(171);
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new StatAssignArrayContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(173);
				target();
				setState(174);
				match(LSQBRACKET);
				setState(175);
				expression(0);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(176);
					match(COMMA);
					setState(177);
					expression(0);
					}
					}
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(183);
				match(RSQBRACKET);
				setState(184);
				match(ASSIGN);
				setState(185);
				expression(0);
				setState(186);
				match(SEMI);
				}
				break;
			case 5:
				_localctx = new StatAssignArrayMultContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(188);
				target();
				setState(189);
				match(ASSIGN);
				setState(190);
				match(LBRACE);
				setState(191);
				arrayExpression();
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(192);
					match(COMMA);
					setState(193);
					arrayExpression();
					}
					}
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(199);
				match(RBRACE);
				setState(200);
				match(SEMI);
				}
				break;
			case 6:
				_localctx = new StatBlockContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(202);
				statBlockBody();
				}
				break;
			case 7:
				_localctx = new StatReturnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(203);
				returnStat();
				}
				break;
			case 8:
				_localctx = new StatInContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(204);
				match(IN);
				setState(205);
				match(LPAR);
				setState(206);
				target();
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(207);
					match(COMMA);
					setState(208);
					target();
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(214);
				match(RPAR);
				setState(215);
				match(SEMI);
				}
				break;
			case 9:
				_localctx = new StatOutContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(217);
				match(OUT);
				setState(218);
				match(LPAR);
				setState(219);
				expression(0);
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(220);
					match(COMMA);
					setState(221);
					expression(0);
					}
					}
					setState(226);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(227);
				match(RPAR);
				setState(228);
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

	public static class StatBlockBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public StatBlockBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statBlockBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatBlockBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatBlockBody(this);
		}
	}

	public final StatBlockBodyContext statBlockBody() throws RecognitionException {
		StatBlockBodyContext _localctx = new StatBlockBodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statBlockBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(LBRACE);
			setState(233);
			body();
			setState(234);
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

	public static class TargetContext extends ParserRuleContext {
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }
	 
		public TargetContext() { }
		public void copyFrom(TargetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TargetIdContext extends TargetContext {
		public TerminalNode ID() { return getToken(EloquenceParser.ID, 0); }
		public TargetIdContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterTargetId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitTargetId(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_target);
		try {
			_localctx = new TargetIdContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(ID);
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

	public static class NewIDContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EloquenceParser.ID, 0); }
		public NewIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterNewID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitNewID(this);
		}
	}

	public final NewIDContext newID() throws RecognitionException {
		NewIDContext _localctx = new NewIDContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_newID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(ID);
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
		enterRule(_localctx, 20, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(RETURN);
			setState(242);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << NOT) | (1L << TRUE) | (1L << LBRACE) | (1L << LPAR) | (1L << MINUS) | (1L << PLUS) | (1L << ID) | (1L << NUM) | (1L << CHARACTER))) != 0)) {
				{
				setState(241);
				expression(0);
				}
			}

			setState(244);
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
	public static class ExprCompoundContext extends ExpressionContext {
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public ExprCompoundContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprCompound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprCompound(this);
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
		public TerminalNode CHARACTER() { return getToken(EloquenceParser.CHARACTER, 0); }
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
	public static class ExprParContext extends ExpressionContext {
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public ExprParContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprPar(this);
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
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
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
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode LSQBRACKET() { return getToken(EloquenceParser.LSQBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RSQBRACKET() { return getToken(EloquenceParser.RSQBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new ExprUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(247);
				unary();
				setState(248);
				expression(13);
				}
				break;
			case 2:
				{
				_localctx = new ExprFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(250);
				functionID();
				}
				break;
			case 3:
				{
				_localctx = new ExprCompoundContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				match(LBRACE);
				setState(252);
				body();
				setState(253);
				expression(0);
				setState(254);
				match(SEMI);
				setState(255);
				match(RBRACE);
				}
				break;
			case 4:
				{
				_localctx = new ExprArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(257);
				target();
				setState(258);
				match(LSQBRACKET);
				setState(259);
				expression(0);
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(260);
					match(COMMA);
					setState(261);
					expression(0);
					}
					}
					setState(266);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(267);
				match(RSQBRACKET);
				}
				break;
			case 5:
				{
				_localctx = new ExprParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(269);
				match(LPAR);
				setState(270);
				expression(0);
				setState(271);
				match(RPAR);
				}
				break;
			case 6:
				{
				_localctx = new ExprIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273);
				target();
				}
				break;
			case 7:
				{
				_localctx = new ExprNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(274);
				match(NUM);
				}
				break;
			case 8:
				{
				_localctx = new ExprTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275);
				match(TRUE);
				}
				break;
			case 9:
				{
				_localctx = new ExprFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(276);
				match(FALSE);
				}
				break;
			case 10:
				{
				_localctx = new ExprCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(277);
				match(CHARACTER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(302);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(300);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(280);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(281);
						multiply();
						setState(282);
						expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(284);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(285);
						addition();
						setState(286);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExprCompContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(288);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(289);
						compare();
						setState(290);
						expression(11);
						}
						break;
					case 4:
						{
						_localctx = new ExprAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(292);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(293);
						and();
						setState(294);
						expression(10);
						}
						break;
					case 5:
						{
						_localctx = new ExprOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(296);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(297);
						or();
						setState(298);
						expression(9);
						}
						break;
					}
					} 
				}
				setState(304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class ArrayExpressionContext extends ParserRuleContext {
		public ArrayExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayExpression; }
	 
		public ArrayExpressionContext() { }
		public void copyFrom(ArrayExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayMulExprContext extends ArrayExpressionContext {
		public TerminalNode LSQBRACKET() { return getToken(EloquenceParser.LSQBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RSQBRACKET() { return getToken(EloquenceParser.RSQBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public ArrayMulExprContext(ArrayExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterArrayMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitArrayMulExpr(this);
		}
	}
	public static class ArraySingleExprContext extends ArrayExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArraySingleExprContext(ArrayExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterArraySingleExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitArraySingleExpr(this);
		}
	}

	public final ArrayExpressionContext arrayExpression() throws RecognitionException {
		ArrayExpressionContext _localctx = new ArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arrayExpression);
		int _la;
		try {
			setState(317);
			switch (_input.LA(1)) {
			case LSQBRACKET:
				_localctx = new ArrayMulExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				match(LSQBRACKET);
				setState(306);
				expression(0);
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(307);
					match(COMMA);
					setState(308);
					expression(0);
					}
					}
					setState(313);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(314);
				match(RSQBRACKET);
				}
				break;
			case FALSE:
			case NOT:
			case TRUE:
			case LBRACE:
			case LPAR:
			case MINUS:
			case PLUS:
			case ID:
			case NUM:
			case CHARACTER:
				_localctx = new ArraySingleExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
				expression(0);
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

	public static class UnaryContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(EloquenceParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(EloquenceParser.PLUS, 0); }
		public TerminalNode NOT() { return getToken(EloquenceParser.NOT, 0); }
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitUnary(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << MINUS) | (1L << PLUS))) != 0)) ) {
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

	public static class MultiplyContext extends ParserRuleContext {
		public TerminalNode MULTIPLY() { return getToken(EloquenceParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(EloquenceParser.DIVIDE, 0); }
		public TerminalNode MODULO() { return getToken(EloquenceParser.MODULO, 0); }
		public MultiplyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiply; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterMultiply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitMultiply(this);
		}
	}

	public final MultiplyContext multiply() throws RecognitionException {
		MultiplyContext _localctx = new MultiplyContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_multiply);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIVIDE) | (1L << MODULO) | (1L << MULTIPLY))) != 0)) ) {
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

	public static class AdditionContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(EloquenceParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(EloquenceParser.MINUS, 0); }
		public AdditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitAddition(this);
		}
	}

	public final AdditionContext addition() throws RecognitionException {
		AdditionContext _localctx = new AdditionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_addition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			_la = _input.LA(1);
			if ( !(_la==MINUS || _la==PLUS) ) {
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

	public static class CompareContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(EloquenceParser.LT, 0); }
		public TerminalNode LE() { return getToken(EloquenceParser.LE, 0); }
		public TerminalNode GE() { return getToken(EloquenceParser.GE, 0); }
		public TerminalNode GT() { return getToken(EloquenceParser.GT, 0); }
		public TerminalNode EQ() { return getToken(EloquenceParser.EQ, 0); }
		public TerminalNode NE() { return getToken(EloquenceParser.NE, 0); }
		public CompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitCompare(this);
		}
	}

	public final CompareContext compare() throws RecognitionException {
		CompareContext _localctx = new CompareContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_compare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GE) | (1L << GT) | (1L << LE) | (1L << LT) | (1L << NE))) != 0)) ) {
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
		enterRule(_localctx, 34, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
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
		enterRule(_localctx, 36, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
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
		enterRule(_localctx, 38, RULE_type);
		try {
			setState(334);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new TypeIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				match(INTEGER);
				}
				break;
			case BOOLEAN:
				_localctx = new TypeBoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				match(BOOLEAN);
				}
				break;
			case CHAR:
				_localctx = new TypeCharContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(333);
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
		enterRule(_localctx, 40, RULE_func);
		try {
			setState(338);
			switch (_input.LA(1)) {
			case VOID:
				_localctx = new FuncVoidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				voidFunc();
				}
				break;
			case BOOLEAN:
			case CHAR:
			case INTEGER:
				_localctx = new FuncReturnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
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
		public TerminalNode ID() { return getToken(EloquenceParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public List<TargetContext> target() {
			return getRuleContexts(TargetContext.class);
		}
		public TargetContext target(int i) {
			return getRuleContext(TargetContext.class,i);
		}
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
		enterRule(_localctx, 42, RULE_functionID);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(ID);
			setState(341);
			match(LPAR);
			setState(350);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(342);
				target();
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(343);
					match(COMMA);
					setState(344);
					target();
					}
					}
					setState(349);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(352);
			match(RPAR);
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
		public TerminalNode ID() { return getToken(EloquenceParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public StatBlockBodyContext statBlockBody() {
			return getRuleContext(StatBlockBodyContext.class,0);
		}
		public List<ParametersContext> parameters() {
			return getRuleContexts(ParametersContext.class);
		}
		public ParametersContext parameters(int i) {
			return getRuleContext(ParametersContext.class,i);
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
		enterRule(_localctx, 44, RULE_voidFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(VOID);
			setState(355);
			match(ID);
			setState(356);
			match(LPAR);
			setState(365);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INTEGER))) != 0)) {
				{
				setState(357);
				parameters();
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(358);
					match(COMMA);
					setState(359);
					parameters();
					}
					}
					setState(364);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(367);
			match(RPAR);
			setState(368);
			statBlockBody();
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(EloquenceParser.ID, 0); }
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
		public List<ParametersContext> parameters() {
			return getRuleContexts(ParametersContext.class);
		}
		public ParametersContext parameters(int i) {
			return getRuleContext(ParametersContext.class,i);
		}
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
		enterRule(_localctx, 46, RULE_returnFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			type();
			setState(371);
			match(ID);
			setState(372);
			match(LPAR);
			setState(381);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INTEGER))) != 0)) {
				{
				setState(373);
				parameters();
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(374);
					match(COMMA);
					setState(375);
					parameters();
					}
					}
					setState(380);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(383);
			match(RPAR);
			setState(384);
			match(LBRACE);
			setState(385);
			body();
			setState(386);
			returnStat();
			setState(387);
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

	public static class ParametersContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NewIDContext newID() {
			return getRuleContext(NewIDContext.class,0);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_parameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			type();
			setState(390);
			newID();
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
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u018b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3?\n\3\f\3\16\3B"+
		"\13\3\3\4\3\4\3\4\3\4\5\4H\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4U\n\4\3\5\3\5\3\5\3\5\7\5[\n\5\f\5\16\5^\13\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6n\n\6\f\6\16\6q\13\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\7\7z\n\7\f\7\16\7}\13\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\7\7\u0087\n\7\f\7\16\7\u008a\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\7\7\u0093\n\7\f\7\16\7\u0096\13\7\3\7\3\7\5\7\u009a\n\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u00a3\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\7\b\u00b5\n\b\f\b\16\b\u00b8\13\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00c5\n\b\f\b\16\b\u00c8\13\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00d4\n\b\f\b\16\b\u00d7\13\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00e1\n\b\f\b\16\b\u00e4\13\b\3\b\3"+
		"\b\3\b\5\b\u00e9\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\5\f\u00f5"+
		"\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\7\r\u0109\n\r\f\r\16\r\u010c\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u0119\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u012f\n\r\f\r\16\r\u0132\13"+
		"\r\3\16\3\16\3\16\3\16\7\16\u0138\n\16\f\16\16\16\u013b\13\16\3\16\3\16"+
		"\3\16\5\16\u0140\n\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\25\5\25\u0151\n\25\3\26\3\26\5\26\u0155\n\26\3"+
		"\27\3\27\3\27\3\27\3\27\7\27\u015c\n\27\f\27\16\27\u015f\13\27\5\27\u0161"+
		"\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u016b\n\30\f\30\16"+
		"\30\u016e\13\30\5\30\u0170\n\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\7\31\u017b\n\31\f\31\16\31\u017e\13\31\5\31\u0180\n\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\2\3\30\33\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\2\6\5\2\23\23##&&\4\2\36\36$%\4\2##"+
		"&&\5\2\t\t\13\f\20\22\u01a6\2\64\3\2\2\2\4@\3\2\2\2\6T\3\2\2\2\bV\3\2"+
		"\2\2\n_\3\2\2\2\f\u0099\3\2\2\2\16\u00e8\3\2\2\2\20\u00ea\3\2\2\2\22\u00ee"+
		"\3\2\2\2\24\u00f0\3\2\2\2\26\u00f2\3\2\2\2\30\u0118\3\2\2\2\32\u013f\3"+
		"\2\2\2\34\u0141\3\2\2\2\36\u0143\3\2\2\2 \u0145\3\2\2\2\"\u0147\3\2\2"+
		"\2$\u0149\3\2\2\2&\u014b\3\2\2\2(\u0150\3\2\2\2*\u0154\3\2\2\2,\u0156"+
		"\3\2\2\2.\u0164\3\2\2\2\60\u0174\3\2\2\2\62\u0187\3\2\2\2\64\65\7\26\2"+
		"\2\65\66\7-\2\2\66\67\7 \2\2\678\5\4\3\289\7(\2\29\3\3\2\2\2:?\5\n\6\2"+
		";?\5\6\4\2<?\5\16\b\2=?\5*\26\2>:\3\2\2\2>;\3\2\2\2><\3\2\2\2>=\3\2\2"+
		"\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\5\3\2\2\2B@\3\2\2\2CD\7\31\2\2DG\5\b"+
		"\5\2EF\7\34\2\2FH\5\30\r\2GE\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7+\2\2JU\3"+
		"\2\2\2KL\7\7\2\2LM\5\b\5\2MN\7\34\2\2NO\5\30\r\2OP\7+\2\2PU\3\2\2\2QR"+
		"\5\f\7\2RS\7+\2\2SU\3\2\2\2TC\3\2\2\2TK\3\2\2\2TQ\3\2\2\2U\7\3\2\2\2V"+
		"W\5(\25\2W\\\5\24\13\2XY\7\35\2\2Y[\5\24\13\2ZX\3\2\2\2[^\3\2\2\2\\Z\3"+
		"\2\2\2\\]\3\2\2\2]\t\3\2\2\2^\\\3\2\2\2_`\7\4\2\2`a\5\24\13\2ab\7\34\2"+
		"\2bc\5(\25\2cd\7\"\2\2de\7.\2\2ef\7\37\2\2fg\7\37\2\2go\7.\2\2hi\7\35"+
		"\2\2ij\7.\2\2jk\7\37\2\2kl\7\37\2\2ln\7.\2\2mh\3\2\2\2nq\3\2\2\2om\3\2"+
		"\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7*\2\2st\7+\2\2t\13\3\2\2\2uv\7\31"+
		"\2\2v{\5\24\13\2wx\7\35\2\2xz\5\24\13\2yw\3\2\2\2z}\3\2\2\2{y\3\2\2\2"+
		"{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2~\177\7\34\2\2\177\u0080\5\22\n\2\u0080"+
		"\u009a\3\2\2\2\u0081\u0082\7\7\2\2\u0082\u0083\7\4\2\2\u0083\u0088\5\24"+
		"\13\2\u0084\u0085\7\35\2\2\u0085\u0087\5\24\13\2\u0086\u0084\3\2\2\2\u0087"+
		"\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2"+
		"\2\2\u008a\u0088\3\2\2\2\u008b\u008c\7\34\2\2\u008c\u008d\5\22\n\2\u008d"+
		"\u008e\7,\2\2\u008e\u008f\7 \2\2\u008f\u0094\5\32\16\2\u0090\u0091\7\35"+
		"\2\2\u0091\u0093\5\32\16\2\u0092\u0090\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0097\u0098\7(\2\2\u0098\u009a\3\2\2\2\u0099u\3\2\2\2\u0099\u0081"+
		"\3\2\2\2\u009a\r\3\2\2\2\u009b\u009c\7\r\2\2\u009c\u009d\7!\2\2\u009d"+
		"\u009e\5\30\r\2\u009e\u009f\7)\2\2\u009f\u00a2\5\16\b\2\u00a0\u00a1\7"+
		"\b\2\2\u00a1\u00a3\5\16\b\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00e9\3\2\2\2\u00a4\u00a5\7\33\2\2\u00a5\u00a6\7!\2\2\u00a6\u00a7\5\30"+
		"\r\2\u00a7\u00a8\7)\2\2\u00a8\u00a9\5\16\b\2\u00a9\u00e9\3\2\2\2\u00aa"+
		"\u00ab\5\22\n\2\u00ab\u00ac\7\34\2\2\u00ac\u00ad\5\30\r\2\u00ad\u00ae"+
		"\7+\2\2\u00ae\u00e9\3\2\2\2\u00af\u00b0\5\22\n\2\u00b0\u00b1\7\"\2\2\u00b1"+
		"\u00b6\5\30\r\2\u00b2\u00b3\7\35\2\2\u00b3\u00b5\5\30\r\2\u00b4\u00b2"+
		"\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7*\2\2\u00ba\u00bb\7\34"+
		"\2\2\u00bb\u00bc\5\30\r\2\u00bc\u00bd\7+\2\2\u00bd\u00e9\3\2\2\2\u00be"+
		"\u00bf\5\22\n\2\u00bf\u00c0\7\34\2\2\u00c0\u00c1\7 \2\2\u00c1\u00c6\5"+
		"\32\16\2\u00c2\u00c3\7\35\2\2\u00c3\u00c5\5\32\16\2\u00c4\u00c2\3\2\2"+
		"\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9"+
		"\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca\7(\2\2\u00ca\u00cb\7+\2\2\u00cb"+
		"\u00e9\3\2\2\2\u00cc\u00e9\5\20\t\2\u00cd\u00e9\5\26\f\2\u00ce\u00cf\7"+
		"\16\2\2\u00cf\u00d0\7!\2\2\u00d0\u00d5\5\22\n\2\u00d1\u00d2\7\35\2\2\u00d2"+
		"\u00d4\5\22\n\2\u00d3\u00d1\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3"+
		"\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8"+
		"\u00d9\7)\2\2\u00d9\u00da\7+\2\2\u00da\u00e9\3\2\2\2\u00db\u00dc\7\25"+
		"\2\2\u00dc\u00dd\7!\2\2\u00dd\u00e2\5\30\r\2\u00de\u00df\7\35\2\2\u00df"+
		"\u00e1\5\30\r\2\u00e0\u00de\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3"+
		"\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5"+
		"\u00e6\7)\2\2\u00e6\u00e7\7+\2\2\u00e7\u00e9\3\2\2\2\u00e8\u009b\3\2\2"+
		"\2\u00e8\u00a4\3\2\2\2\u00e8\u00aa\3\2\2\2\u00e8\u00af\3\2\2\2\u00e8\u00be"+
		"\3\2\2\2\u00e8\u00cc\3\2\2\2\u00e8\u00cd\3\2\2\2\u00e8\u00ce\3\2\2\2\u00e8"+
		"\u00db\3\2\2\2\u00e9\17\3\2\2\2\u00ea\u00eb\7 \2\2\u00eb\u00ec\5\4\3\2"+
		"\u00ec\u00ed\7(\2\2\u00ed\21\3\2\2\2\u00ee\u00ef\7-\2\2\u00ef\23\3\2\2"+
		"\2\u00f0\u00f1\7-\2\2\u00f1\25\3\2\2\2\u00f2\u00f4\7\27\2\2\u00f3\u00f5"+
		"\5\30\r\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2"+
		"\u00f6\u00f7\7+\2\2\u00f7\27\3\2\2\2\u00f8\u00f9\b\r\1\2\u00f9\u00fa\5"+
		"\34\17\2\u00fa\u00fb\5\30\r\17\u00fb\u0119\3\2\2\2\u00fc\u0119\5,\27\2"+
		"\u00fd\u00fe\7 \2\2\u00fe\u00ff\5\4\3\2\u00ff\u0100\5\30\r\2\u0100\u0101"+
		"\7+\2\2\u0101\u0102\7(\2\2\u0102\u0119\3\2\2\2\u0103\u0104\5\22\n\2\u0104"+
		"\u0105\7\"\2\2\u0105\u010a\5\30\r\2\u0106\u0107\7\35\2\2\u0107\u0109\5"+
		"\30\r\2\u0108\u0106\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u010d\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010e\7*"+
		"\2\2\u010e\u0119\3\2\2\2\u010f\u0110\7!\2\2\u0110\u0111\5\30\r\2\u0111"+
		"\u0112\7)\2\2\u0112\u0119\3\2\2\2\u0113\u0119\5\22\n\2\u0114\u0119\7."+
		"\2\2\u0115\u0119\7\30\2\2\u0116\u0119\7\n\2\2\u0117\u0119\7/\2\2\u0118"+
		"\u00f8\3\2\2\2\u0118\u00fc\3\2\2\2\u0118\u00fd\3\2\2\2\u0118\u0103\3\2"+
		"\2\2\u0118\u010f\3\2\2\2\u0118\u0113\3\2\2\2\u0118\u0114\3\2\2\2\u0118"+
		"\u0115\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0117\3\2\2\2\u0119\u0130\3\2"+
		"\2\2\u011a\u011b\f\16\2\2\u011b\u011c\5\36\20\2\u011c\u011d\5\30\r\17"+
		"\u011d\u012f\3\2\2\2\u011e\u011f\f\r\2\2\u011f\u0120\5 \21\2\u0120\u0121"+
		"\5\30\r\16\u0121\u012f\3\2\2\2\u0122\u0123\f\f\2\2\u0123\u0124\5\"\22"+
		"\2\u0124\u0125\5\30\r\r\u0125\u012f\3\2\2\2\u0126\u0127\f\13\2\2\u0127"+
		"\u0128\5$\23\2\u0128\u0129\5\30\r\f\u0129\u012f\3\2\2\2\u012a\u012b\f"+
		"\n\2\2\u012b\u012c\5&\24\2\u012c\u012d\5\30\r\13\u012d\u012f\3\2\2\2\u012e"+
		"\u011a\3\2\2\2\u012e\u011e\3\2\2\2\u012e\u0122\3\2\2\2\u012e\u0126\3\2"+
		"\2\2\u012e\u012a\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\31\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0134\7\"\2"+
		"\2\u0134\u0139\5\30\r\2\u0135\u0136\7\35\2\2\u0136\u0138\5\30\r\2\u0137"+
		"\u0135\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2"+
		"\2\2\u013a\u013c\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013d\7*\2\2\u013d"+
		"\u0140\3\2\2\2\u013e\u0140\5\30\r\2\u013f\u0133\3\2\2\2\u013f\u013e\3"+
		"\2\2\2\u0140\33\3\2\2\2\u0141\u0142\t\2\2\2\u0142\35\3\2\2\2\u0143\u0144"+
		"\t\3\2\2\u0144\37\3\2\2\2\u0145\u0146\t\4\2\2\u0146!\3\2\2\2\u0147\u0148"+
		"\t\5\2\2\u0148#\3\2\2\2\u0149\u014a\7\3\2\2\u014a%\3\2\2\2\u014b\u014c"+
		"\7\24\2\2\u014c\'\3\2\2\2\u014d\u0151\7\17\2\2\u014e\u0151\7\5\2\2\u014f"+
		"\u0151\7\6\2\2\u0150\u014d\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u014f\3\2"+
		"\2\2\u0151)\3\2\2\2\u0152\u0155\5.\30\2\u0153\u0155\5\60\31\2\u0154\u0152"+
		"\3\2\2\2\u0154\u0153\3\2\2\2\u0155+\3\2\2\2\u0156\u0157\7-\2\2\u0157\u0160"+
		"\7!\2\2\u0158\u015d\5\22\n\2\u0159\u015a\7\35\2\2\u015a\u015c\5\22\n\2"+
		"\u015b\u0159\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e"+
		"\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0158\3\2\2\2\u0160"+
		"\u0161\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\7)\2\2\u0163-\3\2\2\2\u0164"+
		"\u0165\7\32\2\2\u0165\u0166\7-\2\2\u0166\u016f\7!\2\2\u0167\u016c\5\62"+
		"\32\2\u0168\u0169\7\35\2\2\u0169\u016b\5\62\32\2\u016a\u0168\3\2\2\2\u016b"+
		"\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u0170\3\2"+
		"\2\2\u016e\u016c\3\2\2\2\u016f\u0167\3\2\2\2\u016f\u0170\3\2\2\2\u0170"+
		"\u0171\3\2\2\2\u0171\u0172\7)\2\2\u0172\u0173\5\20\t\2\u0173/\3\2\2\2"+
		"\u0174\u0175\5(\25\2\u0175\u0176\7-\2\2\u0176\u017f\7!\2\2\u0177\u017c"+
		"\5\62\32\2\u0178\u0179\7\35\2\2\u0179\u017b\5\62\32\2\u017a\u0178\3\2"+
		"\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d"+
		"\u0180\3\2\2\2\u017e\u017c\3\2\2\2\u017f\u0177\3\2\2\2\u017f\u0180\3\2"+
		"\2\2\u0180\u0181\3\2\2\2\u0181\u0182\7)\2\2\u0182\u0183\7 \2\2\u0183\u0184"+
		"\5\4\3\2\u0184\u0185\5\26\f\2\u0185\u0186\7(\2\2\u0186\61\3\2\2\2\u0187"+
		"\u0188\5(\25\2\u0188\u0189\5\24\13\2\u0189\63\3\2\2\2!>@GT\\o{\u0088\u0094"+
		"\u0099\u00a2\u00b6\u00c6\u00d5\u00e2\u00e8\u00f4\u010a\u0118\u012e\u0130"+
		"\u0139\u013f\u0150\u0154\u015d\u0160\u016c\u016f\u017c\u017f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}