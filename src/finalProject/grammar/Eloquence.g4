grammar Eloquence;

@header{package pp.block5.cc.pascal;}

/** Pascal program. */
program
    : PROGRAM ID LBRACE body RBRACE
    ;

/**  */
body
	: (decl | stat | func)*
	;
	
decl
	: VAR variable (ASSIGN expression)? SEMI	#declVar
	| CONST variable ASSIGN expression SEMI		#declConstVar
	| arrayDecl SEMI							#declArray
	| CONST arrayDecl SEMI						#declConstArray
	;
	
variable
	: type ID (COMMA ID)*
	;
	
arrayDecl
	: type ID LSQBRACKET NUM RSQBRACKET (ASSIGN LBRACE expression (COMMA expression)* RBRACE)?
	;
	
stat
	: returnStat								#statReturn
	| IF LPAR expression RPAR stat (ELSE stat)?	#statIf
	| WHILE LPAR expression RPAR stat			#statWhile
	| ID ASSIGN expression SEMI					#statAssign
	| ID LSQBRACKET expression RSQBRACKET ASSIGN expression SEMI #statAssignArray
	| LBRACE body RBRACE						#statBlock
	;
	
returnStat
	: RETURN (expression)? SEMI					
	;
	
expression
	: functionID								#exprFunc
	| unary expression							#exprUnary		
	| expression multiply expression			#exprMult
	| expression addition expression			#exprAdd
	| expression compare expression				#exprComp
	| expression and expression					#exprAnd
	| expression or expression					#exprOr
	| ID LSQBRACKET expression RSQBRACKET		#exprArray
	| ID										#exprId
	| NUM										#exprNum
	| TRUE										#exprTrue
	| FALSE										#exprFalse
	| CHAR										#exprChar
	;
	
unary
	: MINUS										#unaryMin
	| PLUS										#unaryPlus
	| NOT										#unaryNot
	;
	
multiply
	: MULTIPLY									#unaryMult
	| DIVIDE									#unaryDiv
	| MODULO									#unaryMod
	;
	
addition
	: PLUS										#addPlus
	| MINUS										#addMin
	;
	
compare
	: LT										#compLess
	| LE										#compLessEq
	| GE										#compGreatEq
	| GT										#compGreat
	| EQ										#compEq
	| NE										#compNotEq
	;
	
and
	: AND
	;
	
or
	: OR
	;

type
	: INTEGER									#typeInt
	| BOOLEAN									#typeBool
	| CHAR										#typeChar
	;
	
func
	: voidFunc 
	| returnFunc
	;
	
functionID
	: ID LPAR (ID (COMMA ID)*)? RPAR LBRACE body RBRACE
	;
	
voidFunc
	: VOID ID LPAR (type ID (COMMA type ID)*)? RPAR LBRACE body RBRACE
	;
	
returnFunc
	: type ID LPAR (type ID (COMMA type ID)*)? RPAR LBRACE body returnStat RBRACE
	;






AND:		A N D;
BOOLEAN:	G E O R G E;
CHAR:		L E X O G R A P H I C I D E N T I F Y I N G U N I T;
CONST:		S A C R O S A N C T;
ELSE:		C O N T R A R I W I S E;
EQ:			E Q U A L T O;
FALSE:		B O G U S;
GE:			S U P E R I O R O R E Q U A L T O;
GT:			S U P E R I O R T O;
IF:			A S S U M I N G;
INTEGER:	N U M E R I C A L D I G I T;
LE:			I N F E R I O R O R E Q U A L T O;
LT:			I N F E R I O R T O;
NE:			N O T E Q U A L T O;
NOT:		N O T;
OR:			O R;
PROGRAM: 	P R O G R A M;
RETURN:		R E L I N Q U I S H;
TRUE:		U N F E I G N E D;
VAR:		H I G H P O W E R E D;
VOID:		G O D F O R S A K E N;
WHILE:		T H R O U G H O U T;

ASSIGN: 	'=';
COMMA:		',';
DIVIDE:		'/';
LBRACE: 	'{';
LPAR:		'(';
LSQBRACKET: '[';
MINUS:		'-';
MODULO:		'%';
MULTIPLY:	'*';
PLUS:		'+';
RBRACE: 	'}';
RPAR:		')';
RSQBRACKET: ']';
SEMI:		';';


// Content-bearing token types
ID: LETTER (LETTER | DIGIT)*;
NUM: DIGIT (DIGIT)*;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

// Skipped token types
COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;

fragment A: [aA];
fragment B: [bB];
fragment C: [cC];
fragment D: [dD];
fragment E: [eE];
fragment F: [fF];
fragment G: [gG];
fragment H: [hH];
fragment I: [iI];
fragment J: [jJ];
fragment K: [kK];
fragment L: [lL];
fragment M: [mM];
fragment N: [nN];
fragment O: [oO];
fragment P: [pP];
fragment Q: [qQ];
fragment R: [rR];
fragment S: [sS];
fragment T: [tT];
fragment U: [uU];
fragment V: [vV];
fragment W: [wW];
fragment X: [xX];
fragment Y: [yY];
fragment Z: [zZ];
