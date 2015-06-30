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
		PROGRAM=20, RETURN=21, TRUE=22, VAR=23, VOID=24, WHILE=25, ASSIGN=26, 
		COMMA=27, DIVIDE=28, DOT=29, LBRACE=30, LPAR=31, LSQBRACKET=32, MINUS=33, 
		MODULO=34, MULTIPLY=35, PLUS=36, QUOTE=37, RBRACE=38, RPAR=39, RSQBRACKET=40, 
		SEMI=41, SETARRAY=42, ID=43, NUM=44, CHARACTER=45, COMMENT=46, LINE_COMMENT=47, 
		WS=48;
	public static final String[] tokenNames = {
		"<INVALID>", "AND", "ARRAY", "BOOLEAN", "CHAR", "CONST", "ELSE", "EQ", 
		"FALSE", "GE", "GT", "IF", "IN", "INTEGER", "LE", "LT", "NE", "NOT", "OR", 
		"OUT", "PROGRAM", "RETURN", "TRUE", "VAR", "VOID", "WHILE", "'='", "','", 
		"'/'", "'.'", "'{'", "'('", "'['", "'-'", "'%'", "'*'", "'+'", "'''", 
		"'}'", "')'", "']'", "';'", "'<<'", "ID", "NUM", "CHARACTER", "COMMENT", 
		"LINE_COMMENT", "WS"
	};
	public static final int
		RULE_program = 0, RULE_body = 1, RULE_decl = 2, RULE_variable = 3, RULE_arrayTypeDecl = 4, 
		RULE_arrayElem = 5, RULE_arrayDecl = 6, RULE_stat = 7, RULE_statBlockBody = 8, 
		RULE_target = 9, RULE_newID = 10, RULE_returnStat = 11, RULE_expression = 12, 
		RULE_arrayExpression = 13, RULE_unary = 14, RULE_multiply = 15, RULE_addition = 16, 
		RULE_compare = 17, RULE_and = 18, RULE_or = 19, RULE_type = 20, RULE_func = 21, 
		RULE_functionID = 22, RULE_voidFunc = 23, RULE_returnFunc = 24, RULE_parameters = 25;
	public static final String[] ruleNames = {
		"program", "body", "decl", "variable", "arrayTypeDecl", "arrayElem", "arrayDecl", 
		"stat", "statBlockBody", "target", "newID", "returnStat", "expression", 
		"arrayExpression", "unary", "multiply", "addition", "compare", "and", 
		"or", "type", "func", "functionID", "voidFunc", "returnFunc", "parameters"
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
			setState(52); match(PROGRAM);
			setState(53); match(ID);
			setState(54); match(LBRACE);
			setState(55); body();
			setState(56); match(RBRACE);
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
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(62);
					switch (_input.LA(1)) {
					case ARRAY:
						{
						setState(58); arrayTypeDecl();
						}
						break;
					case CONST:
					case VAR:
						{
						setState(59); decl();
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
						setState(60); stat();
						}
						break;
					case BOOLEAN:
					case CHAR:
					case INTEGER:
					case VOID:
						{
						setState(61); func();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(66);
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
			setState(84);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new DeclVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67); match(VAR);
				setState(68); variable();
				setState(71);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(69); match(ASSIGN);
					setState(70); expression(0);
					}
				}

				setState(73); match(SEMI);
				}
				break;
			case 2:
				_localctx = new DeclConstVarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75); match(CONST);
				setState(76); variable();
				setState(77); match(ASSIGN);
				setState(78); expression(0);
				setState(79); match(SEMI);
				}
				break;
			case 3:
				_localctx = new DeclArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(81); arrayDecl();
				setState(82); match(SEMI);
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
			setState(86); type();
			setState(87); newID();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(88); match(COMMA);
				setState(89); newID();
				}
				}
				setState(94);
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
			setState(95); match(ARRAY);
			setState(96); newID();
			setState(97); match(ASSIGN);
			setState(98); type();
			setState(99); match(LSQBRACKET);
			setState(100); arrayElem();
			setState(101); match(RSQBRACKET);
			setState(102); match(SEMI);
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
			setState(104); match(NUM);
			setState(105); match(DOT);
			setState(106); match(DOT);
			setState(107); match(NUM);
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
		public TerminalNode VAR() { return getToken(EloquenceParser.VAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public List<NewIDContext> newID() {
			return getRuleContexts(NewIDContext.class);
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
		public TerminalNode ARRAY() { return getToken(EloquenceParser.ARRAY, 0); }
		public NewIDContext newID(int i) {
			return getRuleContext(NewIDContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<NewIDContext> newID() {
			return getRuleContexts(NewIDContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(EloquenceParser.COMMA, i);
		}
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public TerminalNode SETARRAY() { return getToken(EloquenceParser.SETARRAY, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
			setState(145);
			switch (_input.LA(1)) {
			case VAR:
				_localctx = new VarArrayDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(109); match(VAR);
				setState(110); newID();
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(111); match(COMMA);
					setState(112); newID();
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(118); match(ASSIGN);
				setState(119); target();
				}
				break;
			case CONST:
				_localctx = new ConstArrayDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121); match(CONST);
				setState(122); match(ARRAY);
				setState(123); newID();
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(124); match(COMMA);
					setState(125); newID();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(131); match(ASSIGN);
				setState(132); target();
				setState(133); match(SETARRAY);
				setState(134); match(LBRACE);
				setState(135); expression(0);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(136); match(COMMA);
					setState(137); expression(0);
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(143); match(RBRACE);
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
	public static class StatOutContext extends StatContext {
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
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
		public StatOutContext(StatContext ctx) { copyFrom(ctx); }
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
	public static class StatWhileContext extends StatContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(EloquenceParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(EloquenceParser.RPAR, 0); }
		public TerminalNode WHILE() { return getToken(EloquenceParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitStatWhile(this);
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
	public static class StatInContext extends StatContext {
		public List<TargetContext> target() {
			return getRuleContexts(TargetContext.class);
		}
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
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
		public StatInContext(StatContext ctx) { copyFrom(ctx); }
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
	public static class StatAssignContext extends StatContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
	public static class StatAssignArrayContext extends StatContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RSQBRACKET() { return getToken(EloquenceParser.RSQBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode LSQBRACKET() { return getToken(EloquenceParser.LSQBRACKET, 0); }
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
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(EloquenceParser.ASSIGN, 0); }
		public TerminalNode RBRACE() { return getToken(EloquenceParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(EloquenceParser.LBRACE, 0); }
		public TerminalNode SEMI() { return getToken(EloquenceParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
	public static class StatIfContext extends StatContext {
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
		public StatIfContext(StatContext ctx) { copyFrom(ctx); }
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
			setState(220);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new StatIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(147); match(IF);
				setState(148); match(LPAR);
				setState(149); expression(0);
				setState(150); match(RPAR);
				setState(151); stat();
				setState(154);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(152); match(ELSE);
					setState(153); stat();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new StatWhileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(156); match(WHILE);
				setState(157); match(LPAR);
				setState(158); expression(0);
				setState(159); match(RPAR);
				setState(160); stat();
				}
				break;
			case 3:
				_localctx = new StatAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(162); target();
				setState(163); match(ASSIGN);
				setState(164); expression(0);
				setState(165); match(SEMI);
				}
				break;
			case 4:
				_localctx = new StatAssignArrayContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(167); target();
				setState(168); match(LSQBRACKET);
				setState(169); expression(0);
				setState(170); match(RSQBRACKET);
				setState(171); match(ASSIGN);
				setState(172); expression(0);
				setState(173); match(SEMI);
				}
				break;
			case 5:
				_localctx = new StatAssignArrayMultContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(175); target();
				setState(176); match(ASSIGN);
				setState(177); match(LBRACE);
				setState(178); expression(0);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(179); match(COMMA);
					setState(180); expression(0);
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(186); match(RBRACE);
				setState(187); match(SEMI);
				}
				break;
			case 6:
				_localctx = new StatBlockContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(189); statBlockBody();
				}
				break;
			case 7:
				_localctx = new StatReturnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(190); returnStat();
				}
				break;
			case 8:
				_localctx = new StatInContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(191); match(IN);
				setState(192); match(LPAR);
				setState(193); target();
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(194); match(COMMA);
					setState(195); target();
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(201); match(RPAR);
				setState(202); match(SEMI);
				}
				break;
			case 9:
				_localctx = new StatOutContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(204); match(OUT);
				setState(205); match(LPAR);
				setState(206); expression(0);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(207); match(COMMA);
					setState(208); expression(0);
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(214); match(RPAR);
				setState(215); match(SEMI);
				}
				break;
			case 10:
				_localctx = new StatVoidContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(217); functionID();
				setState(218); match(SEMI);
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
			setState(222); match(LBRACE);
			setState(223); body();
			setState(224); match(RBRACE);
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
			setState(226); match(ID);
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
			setState(228); match(ID);
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
			setState(230); match(RETURN);
			setState(232);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << NOT) | (1L << TRUE) | (1L << LBRACE) | (1L << LPAR) | (1L << MINUS) | (1L << PLUS) | (1L << ID) | (1L << NUM) | (1L << CHARACTER))) != 0)) {
				{
				setState(231); expression(0);
				}
			}

			setState(234); match(SEMI);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new ExprUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(237); unary();
				setState(238); expression(13);
				}
				break;
			case 2:
				{
				_localctx = new ExprFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240); functionID();
				}
				break;
			case 3:
				{
				_localctx = new ExprCompoundContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241); match(LBRACE);
				setState(242); body();
				setState(243); expression(0);
				setState(244); match(SEMI);
				setState(245); match(RBRACE);
				}
				break;
			case 4:
				{
				_localctx = new ExprArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(247); target();
				setState(248); match(LSQBRACKET);
				setState(249); expression(0);
				setState(250); match(RSQBRACKET);
				}
				break;
			case 5:
				{
				_localctx = new ExprParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252); match(LPAR);
				setState(253); expression(0);
				setState(254); match(RPAR);
				}
				break;
			case 6:
				{
				_localctx = new ExprIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256); target();
				}
				break;
			case 7:
				{
				_localctx = new ExprNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(257); match(NUM);
				}
				break;
			case 8:
				{
				_localctx = new ExprTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258); match(TRUE);
				}
				break;
			case 9:
				{
				_localctx = new ExprFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(259); match(FALSE);
				}
				break;
			case 10:
				{
				_localctx = new ExprCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(260); match(CHARACTER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(285);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(283);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(263);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(264); multiply();
						setState(265); expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(268); addition();
						setState(269); expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExprCompContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(271);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(272); compare();
						setState(273); expression(11);
						}
						break;
					case 4:
						{
						_localctx = new ExprAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(275);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(276); and();
						setState(277); expression(10);
						}
						break;
					case 5:
						{
						_localctx = new ExprOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(279);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(280); or();
						setState(281); expression(9);
						}
						break;
					}
					} 
				}
				setState(287);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		public List<TerminalNode> COMMA() { return getTokens(EloquenceParser.COMMA); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RSQBRACKET() { return getToken(EloquenceParser.RSQBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode LSQBRACKET() { return getToken(EloquenceParser.LSQBRACKET, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitArrayMulExpr(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitArraySingleExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayExpressionContext arrayExpression() throws RecognitionException {
		ArrayExpressionContext _localctx = new ArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arrayExpression);
		int _la;
		try {
			setState(300);
			switch (_input.LA(1)) {
			case LSQBRACKET:
				_localctx = new ArrayMulExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(288); match(LSQBRACKET);
				setState(289); expression(0);
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(290); match(COMMA);
					setState(291); expression(0);
					}
					}
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(297); match(RSQBRACKET);
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
				setState(299); expression(0);
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
		enterRule(_localctx, 28, RULE_unary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
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
		enterRule(_localctx, 30, RULE_multiply);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
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
		enterRule(_localctx, 32, RULE_addition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
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
		enterRule(_localctx, 34, RULE_compare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
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
		enterRule(_localctx, 36, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310); match(AND);
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
		enterRule(_localctx, 38, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312); match(OR);
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
		enterRule(_localctx, 40, RULE_type);
		try {
			setState(317);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new TypeIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(314); match(INTEGER);
				}
				break;
			case BOOLEAN:
				_localctx = new TypeBoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(315); match(BOOLEAN);
				}
				break;
			case CHAR:
				_localctx = new TypeCharContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(316); match(CHAR);
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
		enterRule(_localctx, 42, RULE_func);
		try {
			setState(321);
			switch (_input.LA(1)) {
			case VOID:
				_localctx = new FuncVoidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(319); voidFunc();
				}
				break;
			case BOOLEAN:
			case CHAR:
			case INTEGER:
				_localctx = new FuncReturnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(320); returnFunc();
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
		enterRule(_localctx, 44, RULE_functionID);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323); target();
			setState(324); match(LPAR);
			setState(333);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << NOT) | (1L << TRUE) | (1L << LBRACE) | (1L << LPAR) | (1L << MINUS) | (1L << PLUS) | (1L << ID) | (1L << NUM) | (1L << CHARACTER))) != 0)) {
				{
				setState(325); expression(0);
				setState(330);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(326); match(COMMA);
					setState(327); expression(0);
					}
					}
					setState(332);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(335); match(RPAR);
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
		enterRule(_localctx, 46, RULE_voidFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337); match(VOID);
			setState(338); newID();
			setState(339); match(LPAR);
			setState(348);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INTEGER))) != 0)) {
				{
				setState(340); parameters();
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(341); match(COMMA);
					setState(342); parameters();
					}
					}
					setState(347);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(350); match(RPAR);
			setState(351); statBlockBody();
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
		enterRule(_localctx, 48, RULE_returnFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353); type();
			setState(354); newID();
			setState(355); match(LPAR);
			setState(364);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INTEGER))) != 0)) {
				{
				setState(356); parameters();
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(357); match(COMMA);
					setState(358); parameters();
					}
					}
					setState(363);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(366); match(RPAR);
			setState(367); match(LBRACE);
			setState(368); body();
			setState(369); returnStat();
			setState(370); match(RBRACE);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EloquenceVisitor ) return ((EloquenceVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_parameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372); type();
			setState(373); newID();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u017a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3A\n\3"+
		"\f\3\16\3D\13\3\3\4\3\4\3\4\3\4\5\4J\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4W\n\4\3\5\3\5\3\5\3\5\7\5]\n\5\f\5\16\5`\13\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b"+
		"t\n\b\f\b\16\bw\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0081\n\b\f\b"+
		"\16\b\u0084\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u008d\n\b\f\b\16\b\u0090"+
		"\13\b\3\b\3\b\5\b\u0094\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u009d\n\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00b8\n\t\f\t\16\t\u00bb\13\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00c7\n\t\f\t\16\t\u00ca\13\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00d4\n\t\f\t\16\t\u00d7\13\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u00df\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\5\r\u00eb\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u0108\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u011e\n\16"+
		"\f\16\16\16\u0121\13\16\3\17\3\17\3\17\3\17\7\17\u0127\n\17\f\17\16\17"+
		"\u012a\13\17\3\17\3\17\3\17\5\17\u012f\n\17\3\20\3\20\3\21\3\21\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\5\26\u0140\n\26\3\27"+
		"\3\27\5\27\u0144\n\27\3\30\3\30\3\30\3\30\3\30\7\30\u014b\n\30\f\30\16"+
		"\30\u014e\13\30\5\30\u0150\n\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\7\31\u015a\n\31\f\31\16\31\u015d\13\31\5\31\u015f\n\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u016a\n\32\f\32\16\32\u016d\13\32"+
		"\5\32\u016f\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\2\3"+
		"\32\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\6\5"+
		"\2\23\23##&&\4\2\36\36$%\4\2##&&\5\2\t\t\13\f\20\22\u0192\2\66\3\2\2\2"+
		"\4B\3\2\2\2\6V\3\2\2\2\bX\3\2\2\2\na\3\2\2\2\fj\3\2\2\2\16\u0093\3\2\2"+
		"\2\20\u00de\3\2\2\2\22\u00e0\3\2\2\2\24\u00e4\3\2\2\2\26\u00e6\3\2\2\2"+
		"\30\u00e8\3\2\2\2\32\u0107\3\2\2\2\34\u012e\3\2\2\2\36\u0130\3\2\2\2 "+
		"\u0132\3\2\2\2\"\u0134\3\2\2\2$\u0136\3\2\2\2&\u0138\3\2\2\2(\u013a\3"+
		"\2\2\2*\u013f\3\2\2\2,\u0143\3\2\2\2.\u0145\3\2\2\2\60\u0153\3\2\2\2\62"+
		"\u0163\3\2\2\2\64\u0176\3\2\2\2\66\67\7\26\2\2\678\7-\2\289\7 \2\29:\5"+
		"\4\3\2:;\7(\2\2;\3\3\2\2\2<A\5\n\6\2=A\5\6\4\2>A\5\20\t\2?A\5,\27\2@<"+
		"\3\2\2\2@=\3\2\2\2@>\3\2\2\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C"+
		"\5\3\2\2\2DB\3\2\2\2EF\7\31\2\2FI\5\b\5\2GH\7\34\2\2HJ\5\32\16\2IG\3\2"+
		"\2\2IJ\3\2\2\2JK\3\2\2\2KL\7+\2\2LW\3\2\2\2MN\7\7\2\2NO\5\b\5\2OP\7\34"+
		"\2\2PQ\5\32\16\2QR\7+\2\2RW\3\2\2\2ST\5\16\b\2TU\7+\2\2UW\3\2\2\2VE\3"+
		"\2\2\2VM\3\2\2\2VS\3\2\2\2W\7\3\2\2\2XY\5*\26\2Y^\5\26\f\2Z[\7\35\2\2"+
		"[]\5\26\f\2\\Z\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\t\3\2\2\2`^\3\2"+
		"\2\2ab\7\4\2\2bc\5\26\f\2cd\7\34\2\2de\5*\26\2ef\7\"\2\2fg\5\f\7\2gh\7"+
		"*\2\2hi\7+\2\2i\13\3\2\2\2jk\7.\2\2kl\7\37\2\2lm\7\37\2\2mn\7.\2\2n\r"+
		"\3\2\2\2op\7\31\2\2pu\5\26\f\2qr\7\35\2\2rt\5\26\f\2sq\3\2\2\2tw\3\2\2"+
		"\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2xy\7\34\2\2yz\5\24\13\2z\u0094"+
		"\3\2\2\2{|\7\7\2\2|}\7\4\2\2}\u0082\5\26\f\2~\177\7\35\2\2\177\u0081\5"+
		"\26\f\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\34\2\2"+
		"\u0086\u0087\5\24\13\2\u0087\u0088\7,\2\2\u0088\u0089\7 \2\2\u0089\u008e"+
		"\5\32\16\2\u008a\u008b\7\35\2\2\u008b\u008d\5\32\16\2\u008c\u008a\3\2"+
		"\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7(\2\2\u0092\u0094\3\2"+
		"\2\2\u0093o\3\2\2\2\u0093{\3\2\2\2\u0094\17\3\2\2\2\u0095\u0096\7\r\2"+
		"\2\u0096\u0097\7!\2\2\u0097\u0098\5\32\16\2\u0098\u0099\7)\2\2\u0099\u009c"+
		"\5\20\t\2\u009a\u009b\7\b\2\2\u009b\u009d\5\20\t\2\u009c\u009a\3\2\2\2"+
		"\u009c\u009d\3\2\2\2\u009d\u00df\3\2\2\2\u009e\u009f\7\33\2\2\u009f\u00a0"+
		"\7!\2\2\u00a0\u00a1\5\32\16\2\u00a1\u00a2\7)\2\2\u00a2\u00a3\5\20\t\2"+
		"\u00a3\u00df\3\2\2\2\u00a4\u00a5\5\24\13\2\u00a5\u00a6\7\34\2\2\u00a6"+
		"\u00a7\5\32\16\2\u00a7\u00a8\7+\2\2\u00a8\u00df\3\2\2\2\u00a9\u00aa\5"+
		"\24\13\2\u00aa\u00ab\7\"\2\2\u00ab\u00ac\5\32\16\2\u00ac\u00ad\7*\2\2"+
		"\u00ad\u00ae\7\34\2\2\u00ae\u00af\5\32\16\2\u00af\u00b0\7+\2\2\u00b0\u00df"+
		"\3\2\2\2\u00b1\u00b2\5\24\13\2\u00b2\u00b3\7\34\2\2\u00b3\u00b4\7 \2\2"+
		"\u00b4\u00b9\5\32\16\2\u00b5\u00b6\7\35\2\2\u00b6\u00b8\5\32\16\2\u00b7"+
		"\u00b5\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7(\2\2\u00bd"+
		"\u00be\7+\2\2\u00be\u00df\3\2\2\2\u00bf\u00df\5\22\n\2\u00c0\u00df\5\30"+
		"\r\2\u00c1\u00c2\7\16\2\2\u00c2\u00c3\7!\2\2\u00c3\u00c8\5\24\13\2\u00c4"+
		"\u00c5\7\35\2\2\u00c5\u00c7\5\24\13\2\u00c6\u00c4\3\2\2\2\u00c7\u00ca"+
		"\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00cb\u00cc\7)\2\2\u00cc\u00cd\7+\2\2\u00cd\u00df\3\2\2"+
		"\2\u00ce\u00cf\7\25\2\2\u00cf\u00d0\7!\2\2\u00d0\u00d5\5\32\16\2\u00d1"+
		"\u00d2\7\35\2\2\u00d2\u00d4\5\32\16\2\u00d3\u00d1\3\2\2\2\u00d4\u00d7"+
		"\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8\u00d9\7)\2\2\u00d9\u00da\7+\2\2\u00da\u00df\3\2\2"+
		"\2\u00db\u00dc\5.\30\2\u00dc\u00dd\7+\2\2\u00dd\u00df\3\2\2\2\u00de\u0095"+
		"\3\2\2\2\u00de\u009e\3\2\2\2\u00de\u00a4\3\2\2\2\u00de\u00a9\3\2\2\2\u00de"+
		"\u00b1\3\2\2\2\u00de\u00bf\3\2\2\2\u00de\u00c0\3\2\2\2\u00de\u00c1\3\2"+
		"\2\2\u00de\u00ce\3\2\2\2\u00de\u00db\3\2\2\2\u00df\21\3\2\2\2\u00e0\u00e1"+
		"\7 \2\2\u00e1\u00e2\5\4\3\2\u00e2\u00e3\7(\2\2\u00e3\23\3\2\2\2\u00e4"+
		"\u00e5\7-\2\2\u00e5\25\3\2\2\2\u00e6\u00e7\7-\2\2\u00e7\27\3\2\2\2\u00e8"+
		"\u00ea\7\27\2\2\u00e9\u00eb\5\32\16\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb"+
		"\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\7+\2\2\u00ed\31\3\2\2\2\u00ee"+
		"\u00ef\b\16\1\2\u00ef\u00f0\5\36\20\2\u00f0\u00f1\5\32\16\17\u00f1\u0108"+
		"\3\2\2\2\u00f2\u0108\5.\30\2\u00f3\u00f4\7 \2\2\u00f4\u00f5\5\4\3\2\u00f5"+
		"\u00f6\5\32\16\2\u00f6\u00f7\7+\2\2\u00f7\u00f8\7(\2\2\u00f8\u0108\3\2"+
		"\2\2\u00f9\u00fa\5\24\13\2\u00fa\u00fb\7\"\2\2\u00fb\u00fc\5\32\16\2\u00fc"+
		"\u00fd\7*\2\2\u00fd\u0108\3\2\2\2\u00fe\u00ff\7!\2\2\u00ff\u0100\5\32"+
		"\16\2\u0100\u0101\7)\2\2\u0101\u0108\3\2\2\2\u0102\u0108\5\24\13\2\u0103"+
		"\u0108\7.\2\2\u0104\u0108\7\30\2\2\u0105\u0108\7\n\2\2\u0106\u0108\7/"+
		"\2\2\u0107\u00ee\3\2\2\2\u0107\u00f2\3\2\2\2\u0107\u00f3\3\2\2\2\u0107"+
		"\u00f9\3\2\2\2\u0107\u00fe\3\2\2\2\u0107\u0102\3\2\2\2\u0107\u0103\3\2"+
		"\2\2\u0107\u0104\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0106\3\2\2\2\u0108"+
		"\u011f\3\2\2\2\u0109\u010a\f\16\2\2\u010a\u010b\5 \21\2\u010b\u010c\5"+
		"\32\16\17\u010c\u011e\3\2\2\2\u010d\u010e\f\r\2\2\u010e\u010f\5\"\22\2"+
		"\u010f\u0110\5\32\16\16\u0110\u011e\3\2\2\2\u0111\u0112\f\f\2\2\u0112"+
		"\u0113\5$\23\2\u0113\u0114\5\32\16\r\u0114\u011e\3\2\2\2\u0115\u0116\f"+
		"\13\2\2\u0116\u0117\5&\24\2\u0117\u0118\5\32\16\f\u0118\u011e\3\2\2\2"+
		"\u0119\u011a\f\n\2\2\u011a\u011b\5(\25\2\u011b\u011c\5\32\16\13\u011c"+
		"\u011e\3\2\2\2\u011d\u0109\3\2\2\2\u011d\u010d\3\2\2\2\u011d\u0111\3\2"+
		"\2\2\u011d\u0115\3\2\2\2\u011d\u0119\3\2\2\2\u011e\u0121\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\33\3\2\2\2\u0121\u011f\3\2\2"+
		"\2\u0122\u0123\7\"\2\2\u0123\u0128\5\32\16\2\u0124\u0125\7\35\2\2\u0125"+
		"\u0127\5\32\16\2\u0126\u0124\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3"+
		"\2\2\2\u0128\u0129\3\2\2\2\u0129\u012b\3\2\2\2\u012a\u0128\3\2\2\2\u012b"+
		"\u012c\7*\2\2\u012c\u012f\3\2\2\2\u012d\u012f\5\32\16\2\u012e\u0122\3"+
		"\2\2\2\u012e\u012d\3\2\2\2\u012f\35\3\2\2\2\u0130\u0131\t\2\2\2\u0131"+
		"\37\3\2\2\2\u0132\u0133\t\3\2\2\u0133!\3\2\2\2\u0134\u0135\t\4\2\2\u0135"+
		"#\3\2\2\2\u0136\u0137\t\5\2\2\u0137%\3\2\2\2\u0138\u0139\7\3\2\2\u0139"+
		"\'\3\2\2\2\u013a\u013b\7\24\2\2\u013b)\3\2\2\2\u013c\u0140\7\17\2\2\u013d"+
		"\u0140\7\5\2\2\u013e\u0140\7\6\2\2\u013f\u013c\3\2\2\2\u013f\u013d\3\2"+
		"\2\2\u013f\u013e\3\2\2\2\u0140+\3\2\2\2\u0141\u0144\5\60\31\2\u0142\u0144"+
		"\5\62\32\2\u0143\u0141\3\2\2\2\u0143\u0142\3\2\2\2\u0144-\3\2\2\2\u0145"+
		"\u0146\5\24\13\2\u0146\u014f\7!\2\2\u0147\u014c\5\32\16\2\u0148\u0149"+
		"\7\35\2\2\u0149\u014b\5\32\16\2\u014a\u0148\3\2\2\2\u014b\u014e\3\2\2"+
		"\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c"+
		"\3\2\2\2\u014f\u0147\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151"+
		"\u0152\7)\2\2\u0152/\3\2\2\2\u0153\u0154\7\32\2\2\u0154\u0155\5\26\f\2"+
		"\u0155\u015e\7!\2\2\u0156\u015b\5\64\33\2\u0157\u0158\7\35\2\2\u0158\u015a"+
		"\5\64\33\2\u0159\u0157\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2"+
		"\u015b\u015c\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u0156"+
		"\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\7)\2\2\u0161"+
		"\u0162\5\22\n\2\u0162\61\3\2\2\2\u0163\u0164\5*\26\2\u0164\u0165\5\26"+
		"\f\2\u0165\u016e\7!\2\2\u0166\u016b\5\64\33\2\u0167\u0168\7\35\2\2\u0168"+
		"\u016a\5\64\33\2\u0169\u0167\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3"+
		"\2\2\2\u016b\u016c\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016e"+
		"\u0166\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\7)"+
		"\2\2\u0171\u0172\7 \2\2\u0172\u0173\5\4\3\2\u0173\u0174\5\30\r\2\u0174"+
		"\u0175\7(\2\2\u0175\63\3\2\2\2\u0176\u0177\5*\26\2\u0177\u0178\5\26\f"+
		"\2\u0178\65\3\2\2\2\36@BIV^u\u0082\u008e\u0093\u009c\u00b9\u00c8\u00d5"+
		"\u00de\u00ea\u0107\u011d\u011f\u0128\u012e\u013f\u0143\u014c\u014f\u015b"+
		"\u015e\u016b\u016e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}