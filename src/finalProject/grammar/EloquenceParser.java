// Generated from Eloquence.g4 by ANTLR 4.4
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
	public static final String[] tokenNames = {
		"<INVALID>", "AND", "ARRAY", "BOOLEAN", "CHAR", "CONST", "ELSE", "EQ", 
		"FALSE", "GE", "GT", "IF", "IN", "INTEGER", "LE", "LT", "NE", "NOT", "OR", 
		"OUT", "PROGRAM", "REF", "RETURN", "TRUE", "VAR", "VOID", "WHILE", "'='", 
		"','", "'/'", "'.'", "'{'", "'('", "'['", "'-'", "'%'", "'*'", "'+'", 
		"'''", "'}'", "')'", "']'", "';'", "'<<'", "ID", "NUM", "CHARACTER", "COMMENT", 
		"LINE_COMMENT", "WS"
	};
	public static final int
		RULE_program = 0, RULE_body = 1, RULE_decl = 2, RULE_variable = 3, RULE_arrayTypeDecl = 4, 
		RULE_arrayElem = 5, RULE_arrayDecl = 6, RULE_stat = 7, RULE_statBlockBody = 8, 
		RULE_target = 9, RULE_newID = 10, RULE_returnStat = 11, RULE_expression = 12, 
		RULE_unary = 13, RULE_multiply = 14, RULE_addition = 15, RULE_compare = 16, 
		RULE_and = 17, RULE_or = 18, RULE_type = 19, RULE_func = 20, RULE_functionID = 21, 
		RULE_voidFunc = 22, RULE_returnFunc = 23, RULE_parameters = 24;
	public static final String[] ruleNames = {
		"program", "body", "decl", "variable", "arrayTypeDecl", "arrayElem", "arrayDecl", 
		"stat", "statBlockBody", "target", "newID", "returnStat", "expression", 
		"unary", "multiply", "addition", "compare", "and", "or", "type", "func", 
		"functionID", "voidFunc", "returnFunc", "parameters"
	};

	@Override
	public String getGrammarFileName() { return "Eloquence.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public TerminalNode ID() { return getToken(EloquenceParser.ID, 0); }
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode PROGRAM() { return getToken(EloquenceParser.PROGRAM, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50); match(PROGRAM);
			setState(51); match(ID);
			setState(52); match(LBRACE);
			setState(53); body();
			setState(54); match(RBRACE);
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
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public ArrayTypeDeclContext arrayTypeDecl(int i) {
			return getRuleContext(ArrayTypeDeclContext.class,i);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
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
						setState(56); arrayTypeDecl();
						}
						break;
					case CONST:
					case VAR:
						{
						setState(57); decl();
						}
						break;
					case FALSE:
					case IF:
					case IN:
					case NOT:
					case OUT:
					case RETURN:
					case TRUE:
					case WHILE:
					case LBRACE:
					case LPAR:
					case MINUS:
					case PLUS:
					case ID:
					case NUM:
					case CHARACTER:
						{
						setState(58); stat();
						}
						break;
					case BOOLEAN:
					case CHAR:
					case INTEGER:
					case VOID:
						{
						setState(59); func();
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
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public ArrayDeclContext arrayDecl() {
			return getRuleContext(ArrayDeclContext.class,0);
		}
		public DeclArrayContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterDeclArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitDeclArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitDeclArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclVarContext extends DeclContext {
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public TerminalNode VAR() { return getToken(EloquenceParser.VAR, 0); }
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitDeclVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclConstVarContext extends DeclContext {
		public TerminalNode CONST() { return getToken(EloquenceParser.CONST, 0); }
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public DeclConstVarContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterDeclConstVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitDeclConstVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitDeclConstVar(this);
			else return visitor.visitChildren(this);
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
				setState(65); match(VAR);
				setState(66); variable();
				setState(69);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(67); match(ASSIGN);
					setState(68); expression(0);
					}
				}

				setState(71); match(SEMI);
				}
				break;
			case 2:
				_localctx = new DeclConstVarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73); match(CONST);
				setState(74); variable();
				setState(75); match(ASSIGN);
				setState(76); expression(0);
				setState(77); match(SEMI);
				}
				break;
			case 3:
				_localctx = new DeclArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(79); arrayDecl();
				setState(80); match(SEMI);
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
		public NewIDContext newID(int i) {
			return getRuleContext(NewIDContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<NewIDContext> newID() {
			return getRuleContexts(NewIDContext.class);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); type();
			setState(85); newID();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(86); match(COMMA);
				setState(87); newID();
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
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RSQBRACKET() { return getToken(EloquenceParser.RSQBRACKET, 0); }
		public NewIDContext newID() {
			return getRuleContext(NewIDContext.class,0);
		}
		public TerminalNode LSQBRACKET() { return getToken(EloquenceParser.LSQBRACKET, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitArrayTypeDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeDeclContext arrayTypeDecl() throws RecognitionException {
		ArrayTypeDeclContext _localctx = new ArrayTypeDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arrayTypeDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93); match(ARRAY);
			setState(94); newID();
			setState(95); match(ASSIGN);
			setState(96); type();
			setState(97); match(LSQBRACKET);
			setState(98); arrayElem();
			setState(99); match(RSQBRACKET);
			setState(100); match(SEMI);
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

	public static class ArrayElemContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(EloquenceParser.DOT); }
		public List<TerminalNode> NUM() { return getTokens(EloquenceParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(EloquenceParser.NUM, i);
		}
		public TerminalNode DOT(int i) {
			return getToken(EloquenceParser.DOT, i);
		}
		public ArrayElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterArrayElem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitArrayElem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitArrayElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayElemContext arrayElem() throws RecognitionException {
		ArrayElemContext _localctx = new ArrayElemContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arrayElem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); match(NUM);
			setState(103); match(DOT);
			setState(104); match(DOT);
			setState(105); match(NUM);
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
		public NewIDContext newID(int i) {
			return getRuleContext(NewIDContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public TerminalNode VAR() { return getToken(EloquenceParser.VAR, 0); }
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SETARRAY() { return getToken(EloquenceParser.SETARRAY, 0); }
		public List<NewIDContext> newID() {
			return getRuleContexts(NewIDContext.class);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitVarArrayDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstArrayDeclContext extends ArrayDeclContext {
		public TerminalNode CONST() { return getToken(EloquenceParser.CONST, 0); }
		public NewIDContext newID(int i) {
			return getRuleContext(NewIDContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SETARRAY() { return getToken(EloquenceParser.SETARRAY, 0); }
		public List<NewIDContext> newID() {
			return getRuleContexts(NewIDContext.class);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitConstArrayDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arrayDecl);
		int _la;
		try {
			setState(155);
			switch (_input.LA(1)) {
			case VAR:
				_localctx = new VarArrayDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(107); match(VAR);
				setState(108); newID();
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(109); match(COMMA);
					setState(110); newID();
					}
					}
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(116); match(ASSIGN);
				setState(117); target();
				setState(130);
				_la = _input.LA(1);
				if (_la==SETARRAY) {
					{
					setState(118); match(SETARRAY);
					setState(119); match(LBRACE);
					setState(120); expression(0);
					setState(125);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(121); match(COMMA);
						setState(122); expression(0);
						}
						}
						setState(127);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(128); match(RBRACE);
					}
				}

				}
				break;
			case CONST:
				_localctx = new ConstArrayDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(132); match(CONST);
				setState(133); newID();
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(134); match(COMMA);
					setState(135); newID();
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(141); match(ASSIGN);
				setState(142); target();
				setState(143); match(SETARRAY);
				setState(144); match(LBRACE);
				setState(145); expression(0);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(146); match(COMMA);
					setState(147); expression(0);
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(153); match(RBRACE);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitStatBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatVoidContext extends StatContext {
		public FunctionIDContext functionID() {
			return getRuleContext(FunctionIDContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public StatVoidContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatVoid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitStatVoid(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatAssignContext extends StatContext {
		public List<TargetContext> target() {
			return getRuleContexts(TargetContext.class);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(EloquenceParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(EloquenceParser.ASSIGN, i);
		}
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TargetContext target(int i) {
			return getRuleContext(TargetContext.class,i);
		}
		public StatAssignContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitStatAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatExprContext extends StatContext {
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatExprContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitStatExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatAssignArrayContext extends StatContext {
		public List<TargetContext> target() {
			return getRuleContexts(TargetContext.class);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(EloquenceParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(EloquenceParser.ASSIGN, i);
		}
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RSQBRACKET() { return getTokens(EloquenceParser.RSQBRACKET); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TargetContext target(int i) {
			return getRuleContext(TargetContext.class,i);
		}
		public TerminalNode RSQBRACKET(int i) {
			return getToken(EloquenceParser.RSQBRACKET, i);
		}
		public List<TerminalNode> LSQBRACKET() { return getTokens(EloquenceParser.LSQBRACKET); }
		public TerminalNode LSQBRACKET(int i) {
			return getToken(EloquenceParser.LSQBRACKET, i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitStatAssignArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatAssignArrayMultContext extends StatContext {
		public List<TargetContext> target() {
			return getRuleContexts(TargetContext.class);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(EloquenceParser.ASSIGN); }
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public TerminalNode ASSIGN(int i) {
			return getToken(EloquenceParser.ASSIGN, i);
		}
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TargetContext target(int i) {
			return getRuleContext(TargetContext.class,i);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitStatAssignArrayMult(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitStatReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stat);
		int _la;
		try {
			int _alt;
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new StatAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(160); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(157); target();
						setState(158); match(ASSIGN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(162); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(164); expression(0);
				setState(165); match(SEMI);
				}
				break;
			case 2:
				_localctx = new StatAssignArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(173); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(167); target();
						setState(168); match(LSQBRACKET);
						setState(169); expression(0);
						setState(170); match(RSQBRACKET);
						setState(171); match(ASSIGN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(175); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(177); expression(0);
				setState(178); match(SEMI);
				}
				break;
			case 3:
				_localctx = new StatAssignArrayMultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(183); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(180); target();
					setState(181); match(ASSIGN);
					}
					}
					setState(185); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(187); match(LBRACE);
				setState(188); expression(0);
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(189); match(COMMA);
					setState(190); expression(0);
					}
					}
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(196); match(RBRACE);
				setState(197); match(SEMI);
				}
				break;
			case 4:
				_localctx = new StatBlockContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(199); statBlockBody();
				}
				break;
			case 5:
				_localctx = new StatReturnContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(200); returnStat();
				}
				break;
			case 6:
				_localctx = new StatVoidContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(201); functionID();
				setState(202); match(SEMI);
				}
				break;
			case 7:
				_localctx = new StatExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(204); expression(0);
				setState(205); match(SEMI);
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
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitStatBlockBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatBlockBodyContext statBlockBody() throws RecognitionException {
		StatBlockBodyContext _localctx = new StatBlockBodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statBlockBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209); match(LBRACE);
			setState(210); body();
			setState(211); match(RBRACE);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitTargetId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_target);
		try {
			_localctx = new TargetIdContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(213); match(ID);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitNewID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewIDContext newID() throws RecognitionException {
		NewIDContext _localctx = new NewIDContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_newID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); match(ID);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217); match(RETURN);
			setState(219);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << IF) | (1L << IN) | (1L << NOT) | (1L << OUT) | (1L << TRUE) | (1L << WHILE) | (1L << LBRACE) | (1L << LPAR) | (1L << MINUS) | (1L << PLUS) | (1L << ID) | (1L << NUM) | (1L << CHARACTER))) != 0)) {
				{
				setState(218); expression(0);
				}
			}

			setState(221); match(SEMI);
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprComp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCompoundContext extends ExpressionContext {
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprCompoundContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprCompound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprCompound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprCompound(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMultContext extends ExpressionContext {
		public MultiplyContext multiply() {
			return getRuleContext(MultiplyContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprMult(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprUnary(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprNum(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprTrue(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprChar(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprFunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatOutContext extends ExpressionContext {
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public TerminalNode OUT() { return getToken(EloquenceParser.OUT, 0); }
		public StatOutContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatOut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatOut(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitStatOut(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprOrContext extends ExpressionContext {
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatWhileContext extends ExpressionContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public TerminalNode WHILE() { return getToken(EloquenceParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatWhileContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitStatWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatInContext extends ExpressionContext {
		public List<TargetContext> target() {
			return getRuleContexts(TargetContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public TargetContext target(int i) {
			return getRuleContext(TargetContext.class,i);
		}
		public TerminalNode IN() { return getToken(EloquenceParser.IN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public StatInContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatIn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitStatIn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprParContext extends ExpressionContext {
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprParContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprPar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprPar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAddContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AdditionContext addition() {
			return getRuleContext(AdditionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAndContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprAnd(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprId(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatIfContext extends ExpressionContext {
		public TerminalNode ELSE() { return getToken(EloquenceParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(EloquenceParser.IF, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatIfContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterStatIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitStatIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitStatIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprArrayContext extends ExpressionContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode RSQBRACKET() { return getToken(EloquenceParser.RSQBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LSQBRACKET() { return getToken(EloquenceParser.LSQBRACKET, 0); }
		public ExprArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterExprArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitExprArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitExprArray(this);
			else return visitor.visitChildren(this);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				_localctx = new ExprUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(224); unary();
				setState(225); expression(13);
				}
				break;
			case 2:
				{
				_localctx = new ExprFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227); functionID();
				}
				break;
			case 3:
				{
				_localctx = new StatInContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228); match(IN);
				setState(229); match(LPAR);
				setState(230); target();
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(231); match(COMMA);
					setState(232); target();
					}
					}
					setState(237);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(238); match(RPAR);
				}
				break;
			case 4:
				{
				_localctx = new StatOutContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240); match(OUT);
				setState(241); match(LPAR);
				setState(242); expression(0);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(243); match(COMMA);
					setState(244); expression(0);
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(250); match(RPAR);
				}
				break;
			case 5:
				{
				_localctx = new StatIfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252); match(IF);
				setState(253); match(LPAR);
				setState(254); expression(0);
				setState(255); match(RPAR);
				setState(256); stat();
				setState(259);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(257); match(ELSE);
					setState(258); stat();
					}
					break;
				}
				}
				break;
			case 6:
				{
				_localctx = new StatWhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(261); match(WHILE);
				setState(262); match(LPAR);
				setState(263); expression(0);
				setState(264); match(RPAR);
				setState(265); stat();
				}
				break;
			case 7:
				{
				_localctx = new ExprCompoundContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(267); match(LBRACE);
				setState(268); body();
				setState(269); expression(0);
				setState(270); match(SEMI);
				setState(271); match(RBRACE);
				}
				break;
			case 8:
				{
				_localctx = new ExprArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273); target();
				setState(274); match(LSQBRACKET);
				setState(275); expression(0);
				setState(276); match(RSQBRACKET);
				}
				break;
			case 9:
				{
				_localctx = new ExprParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278); match(LPAR);
				setState(279); expression(0);
				setState(280); match(RPAR);
				}
				break;
			case 10:
				{
				_localctx = new ExprIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282); target();
				}
				break;
			case 11:
				{
				_localctx = new ExprNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(283); match(NUM);
				}
				break;
			case 12:
				{
				_localctx = new ExprTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(284); match(TRUE);
				}
				break;
			case 13:
				{
				_localctx = new ExprFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285); match(FALSE);
				}
				break;
			case 14:
				{
				_localctx = new ExprCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(286); match(CHARACTER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(311);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(309);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(289);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(290); multiply();
						setState(291); expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(293);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(294); addition();
						setState(295); expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExprCompContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(297);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(298); compare();
						setState(299); expression(11);
						}
						break;
					case 4:
						{
						_localctx = new ExprAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(301);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(302); and();
						setState(303); expression(10);
						}
						break;
					case 5:
						{
						_localctx = new ExprOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(305);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(306); or();
						setState(307); expression(9);
						}
						break;
					}
					} 
				}
				setState(313);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		public TerminalNode NOT() { return getToken(EloquenceParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(EloquenceParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(EloquenceParser.PLUS, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << MINUS) | (1L << PLUS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		public TerminalNode DIVIDE() { return getToken(EloquenceParser.DIVIDE, 0); }
		public TerminalNode MODULO() { return getToken(EloquenceParser.MODULO, 0); }
		public TerminalNode MULTIPLY() { return getToken(EloquenceParser.MULTIPLY, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitMultiply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplyContext multiply() throws RecognitionException {
		MultiplyContext _localctx = new MultiplyContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_multiply);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIVIDE) | (1L << MODULO) | (1L << MULTIPLY))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitAddition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditionContext addition() throws RecognitionException {
		AdditionContext _localctx = new AdditionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_addition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			_la = _input.LA(1);
			if ( !(_la==MINUS || _la==PLUS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		public TerminalNode GE() { return getToken(EloquenceParser.GE, 0); }
		public TerminalNode LT() { return getToken(EloquenceParser.LT, 0); }
		public TerminalNode GT() { return getToken(EloquenceParser.GT, 0); }
		public TerminalNode LE() { return getToken(EloquenceParser.LE, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareContext compare() throws RecognitionException {
		CompareContext _localctx = new CompareContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_compare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GE) | (1L << GT) | (1L << LE) | (1L << LT) | (1L << NE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322); match(AND);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324); match(OR);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitTypeInt(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitTypeChar(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitTypeBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_type);
		try {
			setState(329);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new TypeIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(326); match(INTEGER);
				}
				break;
			case BOOLEAN:
				_localctx = new TypeBoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(327); match(BOOLEAN);
				}
				break;
			case CHAR:
				_localctx = new TypeCharContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(328); match(CHAR);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitFuncReturn(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitFuncVoid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_func);
		try {
			setState(333);
			switch (_input.LA(1)) {
			case VOID:
				_localctx = new FuncVoidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(331); voidFunc();
				}
				break;
			case BOOLEAN:
			case CHAR:
			case INTEGER:
				_localctx = new FuncReturnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(332); returnFunc();
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
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitFunctionID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionIDContext functionID() throws RecognitionException {
		FunctionIDContext _localctx = new FunctionIDContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_functionID);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335); target();
			setState(336); match(LPAR);
			setState(345);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << IF) | (1L << IN) | (1L << NOT) | (1L << OUT) | (1L << TRUE) | (1L << WHILE) | (1L << LBRACE) | (1L << LPAR) | (1L << MINUS) | (1L << PLUS) | (1L << ID) | (1L << NUM) | (1L << CHARACTER))) != 0)) {
				{
				setState(337); expression(0);
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(338); match(COMMA);
					setState(339); expression(0);
					}
					}
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(347); match(RPAR);
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
		public ParametersContext parameters(int i) {
			return getRuleContext(ParametersContext.class,i);
		}
		public List<ParametersContext> parameters() {
			return getRuleContexts(ParametersContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode VOID() { return getToken(EloquenceParser.VOID, 0); }
		public NewIDContext newID() {
			return getRuleContext(NewIDContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public StatBlockBodyContext statBlockBody() {
			return getRuleContext(StatBlockBodyContext.class,0);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitVoidFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoidFuncContext voidFunc() throws RecognitionException {
		VoidFuncContext _localctx = new VoidFuncContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_voidFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349); match(VOID);
			setState(350); newID();
			setState(351); match(LPAR);
			setState(360);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INTEGER) | (1L << REF))) != 0)) {
				{
				setState(352); parameters();
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(353); match(COMMA);
					setState(354); parameters();
					}
					}
					setState(359);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(362); match(RPAR);
			setState(363); statBlockBody();
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
		public ParametersContext parameters(int i) {
			return getRuleContext(ParametersContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public List<ParametersContext> parameters() {
			return getRuleContexts(ParametersContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NewIDContext newID() {
			return getRuleContext(NewIDContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitReturnFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnFuncContext returnFunc() throws RecognitionException {
		ReturnFuncContext _localctx = new ReturnFuncContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_returnFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365); type();
			setState(366); newID();
			setState(367); match(LPAR);
			setState(376);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INTEGER) | (1L << REF))) != 0)) {
				{
				setState(368); parameters();
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(369); match(COMMA);
					setState(370); parameters();
					}
					}
					setState(375);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(378); match(RPAR);
			setState(379); match(LBRACE);
			setState(380); body();
			setState(381); returnStat();
			setState(382); match(RBRACE);
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
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	 
		public ParametersContext() { }
		public void copyFrom(ParametersContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParamRefContext extends ParametersContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode REF() { return getToken(EloquenceParser.REF, 0); }
		public ParamRefContext(ParametersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterParamRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitParamRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitParamRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParamValContext extends ParametersContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NewIDContext newID() {
			return getRuleContext(NewIDContext.class,0);
		}
		public ParamValContext(ParametersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).enterParamVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EloquenceListener ) ((EloquenceListener)listener).exitParamVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitParamVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_parameters);
		try {
			setState(389);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case CHAR:
			case INTEGER:
				_localctx = new ParamValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(384); type();
				setState(385); newID();
				}
				break;
			case REF:
				_localctx = new ParamRefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(387); match(REF);
				setState(388); target();
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
		case 12: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 12);
		case 1: return precpred(_ctx, 11);
		case 2: return precpred(_ctx, 10);
		case 3: return precpred(_ctx, 9);
		case 4: return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63\u018a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3?\n\3\f\3\16\3B"+
		"\13\3\3\4\3\4\3\4\3\4\5\4H\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4U\n\4\3\5\3\5\3\5\3\5\7\5[\n\5\f\5\16\5^\13\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\br\n\b\f\b"+
		"\16\bu\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b~\n\b\f\b\16\b\u0081\13\b\3"+
		"\b\3\b\5\b\u0085\n\b\3\b\3\b\3\b\3\b\7\b\u008b\n\b\f\b\16\b\u008e\13\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0097\n\b\f\b\16\b\u009a\13\b\3\b\3\b"+
		"\5\b\u009e\n\b\3\t\3\t\3\t\6\t\u00a3\n\t\r\t\16\t\u00a4\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\6\t\u00b0\n\t\r\t\16\t\u00b1\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\6\t\u00ba\n\t\r\t\16\t\u00bb\3\t\3\t\3\t\3\t\7\t\u00c2\n\t\f\t"+
		"\16\t\u00c5\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00d2"+
		"\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\5\r\u00de\n\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00ec\n\16\f\16"+
		"\16\16\u00ef\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00f8\n\16"+
		"\f\16\16\16\u00fb\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5"+
		"\16\u0106\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u0122\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0138\n\16\f\16"+
		"\16\16\u013b\13\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\25\5\25\u014c\n\25\3\26\3\26\5\26\u0150\n\26\3\27"+
		"\3\27\3\27\3\27\3\27\7\27\u0157\n\27\f\27\16\27\u015a\13\27\5\27\u015c"+
		"\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0166\n\30\f\30\16"+
		"\30\u0169\13\30\5\30\u016b\n\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\7\31\u0176\n\31\f\31\16\31\u0179\13\31\5\31\u017b\n\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u0188\n\32\3\32\2\3"+
		"\32\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\6\5\2\23"+
		"\23$$\'\'\4\2\37\37%&\4\2$$\'\'\5\2\t\t\13\f\20\22\u01a8\2\64\3\2\2\2"+
		"\4@\3\2\2\2\6T\3\2\2\2\bV\3\2\2\2\n_\3\2\2\2\fh\3\2\2\2\16\u009d\3\2\2"+
		"\2\20\u00d1\3\2\2\2\22\u00d3\3\2\2\2\24\u00d7\3\2\2\2\26\u00d9\3\2\2\2"+
		"\30\u00db\3\2\2\2\32\u0121\3\2\2\2\34\u013c\3\2\2\2\36\u013e\3\2\2\2 "+
		"\u0140\3\2\2\2\"\u0142\3\2\2\2$\u0144\3\2\2\2&\u0146\3\2\2\2(\u014b\3"+
		"\2\2\2*\u014f\3\2\2\2,\u0151\3\2\2\2.\u015f\3\2\2\2\60\u016f\3\2\2\2\62"+
		"\u0187\3\2\2\2\64\65\7\26\2\2\65\66\7.\2\2\66\67\7!\2\2\678\5\4\3\289"+
		"\7)\2\29\3\3\2\2\2:?\5\n\6\2;?\5\6\4\2<?\5\20\t\2=?\5*\26\2>:\3\2\2\2"+
		">;\3\2\2\2><\3\2\2\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\5\3\2\2"+
		"\2B@\3\2\2\2CD\7\32\2\2DG\5\b\5\2EF\7\35\2\2FH\5\32\16\2GE\3\2\2\2GH\3"+
		"\2\2\2HI\3\2\2\2IJ\7,\2\2JU\3\2\2\2KL\7\7\2\2LM\5\b\5\2MN\7\35\2\2NO\5"+
		"\32\16\2OP\7,\2\2PU\3\2\2\2QR\5\16\b\2RS\7,\2\2SU\3\2\2\2TC\3\2\2\2TK"+
		"\3\2\2\2TQ\3\2\2\2U\7\3\2\2\2VW\5(\25\2W\\\5\26\f\2XY\7\36\2\2Y[\5\26"+
		"\f\2ZX\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\t\3\2\2\2^\\\3\2\2\2_"+
		"`\7\4\2\2`a\5\26\f\2ab\7\35\2\2bc\5(\25\2cd\7#\2\2de\5\f\7\2ef\7+\2\2"+
		"fg\7,\2\2g\13\3\2\2\2hi\7/\2\2ij\7 \2\2jk\7 \2\2kl\7/\2\2l\r\3\2\2\2m"+
		"n\7\32\2\2ns\5\26\f\2op\7\36\2\2pr\5\26\f\2qo\3\2\2\2ru\3\2\2\2sq\3\2"+
		"\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\7\35\2\2w\u0084\5\24\13\2xy\7-\2"+
		"\2yz\7!\2\2z\177\5\32\16\2{|\7\36\2\2|~\5\32\16\2}{\3\2\2\2~\u0081\3\2"+
		"\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2"+
		"\2\2\u0082\u0083\7)\2\2\u0083\u0085\3\2\2\2\u0084x\3\2\2\2\u0084\u0085"+
		"\3\2\2\2\u0085\u009e\3\2\2\2\u0086\u0087\7\7\2\2\u0087\u008c\5\26\f\2"+
		"\u0088\u0089\7\36\2\2\u0089\u008b\5\26\f\2\u008a\u0088\3\2\2\2\u008b\u008e"+
		"\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008f\u0090\7\35\2\2\u0090\u0091\5\24\13\2\u0091\u0092"+
		"\7-\2\2\u0092\u0093\7!\2\2\u0093\u0098\5\32\16\2\u0094\u0095\7\36\2\2"+
		"\u0095\u0097\5\32\16\2\u0096\u0094\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009c\7)\2\2\u009c\u009e\3\2\2\2\u009dm\3\2\2\2\u009d\u0086\3\2\2\2\u009e"+
		"\17\3\2\2\2\u009f\u00a0\5\24\13\2\u00a0\u00a1\7\35\2\2\u00a1\u00a3\3\2"+
		"\2\2\u00a2\u009f\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\5\32\16\2\u00a7\u00a8\7"+
		",\2\2\u00a8\u00d2\3\2\2\2\u00a9\u00aa\5\24\13\2\u00aa\u00ab\7#\2\2\u00ab"+
		"\u00ac\5\32\16\2\u00ac\u00ad\7+\2\2\u00ad\u00ae\7\35\2\2\u00ae\u00b0\3"+
		"\2\2\2\u00af\u00a9\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\5\32\16\2\u00b4\u00b5\7"+
		",\2\2\u00b5\u00d2\3\2\2\2\u00b6\u00b7\5\24\13\2\u00b7\u00b8\7\35\2\2\u00b8"+
		"\u00ba\3\2\2\2\u00b9\u00b6\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2"+
		"\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\7!\2\2\u00be"+
		"\u00c3\5\32\16\2\u00bf\u00c0\7\36\2\2\u00c0\u00c2\5\32\16\2\u00c1\u00bf"+
		"\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\7)\2\2\u00c7\u00c8\7,\2"+
		"\2\u00c8\u00d2\3\2\2\2\u00c9\u00d2\5\22\n\2\u00ca\u00d2\5\30\r\2\u00cb"+
		"\u00cc\5,\27\2\u00cc\u00cd\7,\2\2\u00cd\u00d2\3\2\2\2\u00ce\u00cf\5\32"+
		"\16\2\u00cf\u00d0\7,\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00a2\3\2\2\2\u00d1"+
		"\u00af\3\2\2\2\u00d1\u00b9\3\2\2\2\u00d1\u00c9\3\2\2\2\u00d1\u00ca\3\2"+
		"\2\2\u00d1\u00cb\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d2\21\3\2\2\2\u00d3\u00d4"+
		"\7!\2\2\u00d4\u00d5\5\4\3\2\u00d5\u00d6\7)\2\2\u00d6\23\3\2\2\2\u00d7"+
		"\u00d8\7.\2\2\u00d8\25\3\2\2\2\u00d9\u00da\7.\2\2\u00da\27\3\2\2\2\u00db"+
		"\u00dd\7\30\2\2\u00dc\u00de\5\32\16\2\u00dd\u00dc\3\2\2\2\u00dd\u00de"+
		"\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\7,\2\2\u00e0\31\3\2\2\2\u00e1"+
		"\u00e2\b\16\1\2\u00e2\u00e3\5\34\17\2\u00e3\u00e4\5\32\16\17\u00e4\u0122"+
		"\3\2\2\2\u00e5\u0122\5,\27\2\u00e6\u00e7\7\16\2\2\u00e7\u00e8\7\"\2\2"+
		"\u00e8\u00ed\5\24\13\2\u00e9\u00ea\7\36\2\2\u00ea\u00ec\5\24\13\2\u00eb"+
		"\u00e9\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2"+
		"\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\7*\2\2\u00f1"+
		"\u0122\3\2\2\2\u00f2\u00f3\7\25\2\2\u00f3\u00f4\7\"\2\2\u00f4\u00f9\5"+
		"\32\16\2\u00f5\u00f6\7\36\2\2\u00f6\u00f8\5\32\16\2\u00f7\u00f5\3\2\2"+
		"\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc"+
		"\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\7*\2\2\u00fd\u0122\3\2\2\2\u00fe"+
		"\u00ff\7\r\2\2\u00ff\u0100\7\"\2\2\u0100\u0101\5\32\16\2\u0101\u0102\7"+
		"*\2\2\u0102\u0105\5\20\t\2\u0103\u0104\7\b\2\2\u0104\u0106\5\20\t\2\u0105"+
		"\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0122\3\2\2\2\u0107\u0108\7\34"+
		"\2\2\u0108\u0109\7\"\2\2\u0109\u010a\5\32\16\2\u010a\u010b\7*\2\2\u010b"+
		"\u010c\5\20\t\2\u010c\u0122\3\2\2\2\u010d\u010e\7!\2\2\u010e\u010f\5\4"+
		"\3\2\u010f\u0110\5\32\16\2\u0110\u0111\7,\2\2\u0111\u0112\7)\2\2\u0112"+
		"\u0122\3\2\2\2\u0113\u0114\5\24\13\2\u0114\u0115\7#\2\2\u0115\u0116\5"+
		"\32\16\2\u0116\u0117\7+\2\2\u0117\u0122\3\2\2\2\u0118\u0119\7\"\2\2\u0119"+
		"\u011a\5\32\16\2\u011a\u011b\7*\2\2\u011b\u0122\3\2\2\2\u011c\u0122\5"+
		"\24\13\2\u011d\u0122\7/\2\2\u011e\u0122\7\31\2\2\u011f\u0122\7\n\2\2\u0120"+
		"\u0122\7\60\2\2\u0121\u00e1\3\2\2\2\u0121\u00e5\3\2\2\2\u0121\u00e6\3"+
		"\2\2\2\u0121\u00f2\3\2\2\2\u0121\u00fe\3\2\2\2\u0121\u0107\3\2\2\2\u0121"+
		"\u010d\3\2\2\2\u0121\u0113\3\2\2\2\u0121\u0118\3\2\2\2\u0121\u011c\3\2"+
		"\2\2\u0121\u011d\3\2\2\2\u0121\u011e\3\2\2\2\u0121\u011f\3\2\2\2\u0121"+
		"\u0120\3\2\2\2\u0122\u0139\3\2\2\2\u0123\u0124\f\16\2\2\u0124\u0125\5"+
		"\36\20\2\u0125\u0126\5\32\16\17\u0126\u0138\3\2\2\2\u0127\u0128\f\r\2"+
		"\2\u0128\u0129\5 \21\2\u0129\u012a\5\32\16\16\u012a\u0138\3\2\2\2\u012b"+
		"\u012c\f\f\2\2\u012c\u012d\5\"\22\2\u012d\u012e\5\32\16\r\u012e\u0138"+
		"\3\2\2\2\u012f\u0130\f\13\2\2\u0130\u0131\5$\23\2\u0131\u0132\5\32\16"+
		"\f\u0132\u0138\3\2\2\2\u0133\u0134\f\n\2\2\u0134\u0135\5&\24\2\u0135\u0136"+
		"\5\32\16\13\u0136\u0138\3\2\2\2\u0137\u0123\3\2\2\2\u0137\u0127\3\2\2"+
		"\2\u0137\u012b\3\2\2\2\u0137\u012f\3\2\2\2\u0137\u0133\3\2\2\2\u0138\u013b"+
		"\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\33\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013c\u013d\t\2\2\2\u013d\35\3\2\2\2\u013e\u013f\t\3\2"+
		"\2\u013f\37\3\2\2\2\u0140\u0141\t\4\2\2\u0141!\3\2\2\2\u0142\u0143\t\5"+
		"\2\2\u0143#\3\2\2\2\u0144\u0145\7\3\2\2\u0145%\3\2\2\2\u0146\u0147\7\24"+
		"\2\2\u0147\'\3\2\2\2\u0148\u014c\7\17\2\2\u0149\u014c\7\5\2\2\u014a\u014c"+
		"\7\6\2\2\u014b\u0148\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014a\3\2\2\2\u014c"+
		")\3\2\2\2\u014d\u0150\5.\30\2\u014e\u0150\5\60\31\2\u014f\u014d\3\2\2"+
		"\2\u014f\u014e\3\2\2\2\u0150+\3\2\2\2\u0151\u0152\5\24\13\2\u0152\u015b"+
		"\7\"\2\2\u0153\u0158\5\32\16\2\u0154\u0155\7\36\2\2\u0155\u0157\5\32\16"+
		"\2\u0156\u0154\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159"+
		"\3\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u0153\3\2\2\2\u015b"+
		"\u015c\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\7*\2\2\u015e-\3\2\2\2\u015f"+
		"\u0160\7\33\2\2\u0160\u0161\5\26\f\2\u0161\u016a\7\"\2\2\u0162\u0167\5"+
		"\62\32\2\u0163\u0164\7\36\2\2\u0164\u0166\5\62\32\2\u0165\u0163\3\2\2"+
		"\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016b"+
		"\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u0162\3\2\2\2\u016a\u016b\3\2\2\2\u016b"+
		"\u016c\3\2\2\2\u016c\u016d\7*\2\2\u016d\u016e\5\22\n\2\u016e/\3\2\2\2"+
		"\u016f\u0170\5(\25\2\u0170\u0171\5\26\f\2\u0171\u017a\7\"\2\2\u0172\u0177"+
		"\5\62\32\2\u0173\u0174\7\36\2\2\u0174\u0176\5\62\32\2\u0175\u0173\3\2"+
		"\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178"+
		"\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u0172\3\2\2\2\u017a\u017b\3\2"+
		"\2\2\u017b\u017c\3\2\2\2\u017c\u017d\7*\2\2\u017d\u017e\7!\2\2\u017e\u017f"+
		"\5\4\3\2\u017f\u0180\5\30\r\2\u0180\u0181\7)\2\2\u0181\61\3\2\2\2\u0182"+
		"\u0183\5(\25\2\u0183\u0184\5\26\f\2\u0184\u0188\3\2\2\2\u0185\u0186\7"+
		"\27\2\2\u0186\u0188\5\24\13\2\u0187\u0182\3\2\2\2\u0187\u0185\3\2\2\2"+
		"\u0188\63\3\2\2\2\">@GT\\s\177\u0084\u008c\u0098\u009d\u00a4\u00b1\u00bb"+
		"\u00c3\u00d1\u00dd\u00ed\u00f9\u0105\u0121\u0137\u0139\u014b\u014f\u0158"+
		"\u015b\u0167\u016a\u0177\u017a\u0187";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}