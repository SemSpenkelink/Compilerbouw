grammar Eloquence;

@header{package finalProject.grammer;}

/**
 * Grammar of the Eloquence programming language.
 * @author Thijs van Ede & Anirudh Ekambaranathan 
 */
 
/** Eloquence program. The program has to have a name, followed by an opening brace
 * 	and a closing brace. The body of the program is contained between the two braces.
 */
program
    : PROGRAM ID LBRACE body RBRACE
    ;

/**
 * A body can consist of any combination of the following four rules: declarations
 * of array types, declarations of variables and or constants, statements and functions.
 */
body
	: (arrayTypeDecl | decl | stat | func)*
	;
	
/**
 * There are three types of declarations: variables, constants and arrays. For arrays there
 * there is a separate rule. It is not necessary to assign an expression to a variable.
 * This may also be done later. Several variables or constants may be declared at once. 
 */
decl
	: VAR variable (ASSIGN expression)? SEMI	#declVar
	| CONST variable ASSIGN expression SEMI		#declConstVar
	| arrayDecl SEMI							#declArray
	;

/**
 * A variable takes has to be of a certain type, and a new ID must be given to each new
 * variable. Several variables may be declared at once. 
 */
variable
	: type newID (COMMA newID)*
	;

/**
 * Declaring a type of an array. Array type declarations must bear the key word ARRAY, which 
 * is hodgepodge, a new ID, a type (char, bool or int) and the upper and lower bound. arrayElem
 * goes to determining these bounds.  
 */
arrayTypeDecl
	: ARRAY newID ASSIGN type LSQBRACKET arrayElem RSQBRACKET SEMI
	;
	
/**
 * The upper and lower bound of an array type declaration. 
 */
arrayElem
	: NUM DOT DOT NUM
	;

/**
 * Declaration of a variable and constant array, after the type has been declared before. The type 
 * is then the target. newID refers to the ID of the to be declared array. In case of constants, 
 * the array needs to be set immediately. This happens with the keyword which is indicated here 
 * by SETARRAY. The contents of an array are placed between an opening and closing brace. In case
 * of variables, it is optional to set an array.
 */
arrayDecl
	: VAR newID (COMMA newID)* ASSIGN target (SETARRAY LBRACE expression (COMMA expression)* RBRACE)?	#varArrayDecl
	| CONST newID (COMMA newID)* ASSIGN target SETARRAY LBRACE expression (COMMA expression)* RBRACE	#constArrayDecl
	;	

/**
 * Statements. Several different types of statements are possible. It is possible to assign values to
 * arrays and variables, to create a blocked statement, add a return statement, call a function and
 * create an expression. In case of arrays, two types of assignments are possible: it is possible
 * to assign a single value to an array element, or assign multiple values to an array at once. 
 */	
stat
	: (target ASSIGN)+ expression SEMI										#statAssign
	| (target LSQBRACKET expression RSQBRACKET ASSIGN)+ expression SEMI 	#statAssignArray		//Assign a single expression to an array
	| (target ASSIGN)+ LBRACE expression (COMMA expression)* RBRACE SEMI 	#statAssignArrayMult	//Assign multiple values to a n-dimensional array
	| statBlockBody															#statBlock
	| returnStat															#statReturn
	| functionID SEMI														#statVoid
	| expression SEMI														#statExpr
	;

/**
 * A blocked statement. 
 */
statBlockBody
	:	LBRACE body RBRACE
	;	

/**
 * Target ID of a variable, constant, array etc. 
 */
target
	: ID																#targetId
	;

/**
 * New ID in case a new variable, constant or array is declared. 
 */
newID
	: ID
	;	
	
/**
 * Return statement. This return statement may bear an expression.
 */
returnStat
	: RETURN (expression)? SEMI					
	;

/**
 * Expressions. An expression may be, in order of appearance, a call to a function, read in, output,
 * if statement, while statement, compound expression, unary expression, multiplication, addition,
 * subtraction, comparison, logical and, logical or, array element through indexing, parenthesized 
 * expression, target ID, number, false, true and character.
 * 
 * An if statement may take on an else part, but this is not necessary. In and out statements may 
 * take on multiple expressions. 
 */
expression
	: functionID									#exprFunc
	| IN LPAR target (COMMA target)* RPAR			#statIn
	| OUT LPAR expression (COMMA expression)* RPAR	#statOut
	| IF LPAR expression RPAR stat (ELSE stat)?		#statIf
	| WHILE LPAR expression RPAR stat				#statWhile
	| LBRACE body expression SEMI RBRACE			#exprCompound
	| unary expression								#exprUnary		
	| expression multiply expression				#exprMult
	| expression addition expression				#exprAdd
	| expression compare expression					#exprComp
	| expression and expression						#exprAnd
	| expression or expression						#exprOr
	| target LSQBRACKET expression RSQBRACKET 		#exprArray
	| LPAR expression RPAR							#exprPar
	| target										#exprId
	| NUM											#exprNum
	| TRUE											#exprTrue
	| FALSE											#exprFalse
	| CHARACTER										#exprChar
	;

/**
 * Unary operators: minus, plus and not.
 */
unary
	: MINUS
	| PLUS
	| NOT
	;
	
/**
 * Multiplication operations: multiplication, division and modulus
 */	
multiply
	: MULTIPLY
	| DIVIDE
	| MODULO
	;
	
/**
 * Addition operations: addition and minus. 
 */
addition
	: PLUS
	| MINUS
	;

/**
 * Comparison operators: (in order of appearance) less than, less than or equal to, greater than,
 * greater than or equal to, equal to and not equal to.
 */
compare
	: LT
	| LE
	| GE
	| GT
	| EQ
	| NE
	;

/**
 * Logical AND
 */
and
	: AND
	;
/**
 * Logical OR
 */	
or
	: OR
	;

/**
 * Types defined in the Eloquence programming language: integer, boolean and character.
 */
type
	: INTEGER									#typeInt
	| BOOLEAN									#typeBool
	| CHAR										#typeChar
	;

/**
 * A function may be of type void or non-void. Non-void functions are indicated by return-functions
 * since they return a possible value. 
 */

func
	: voidFunc 									#funcVoid
	| returnFunc								#funcReturn
	;

/**
 * Calling a function. The target ID of the function name must be given, together with a number of 
 * arguments, which are expressions. 
 */
functionID
	: target LPAR (expression (COMMA expression)*)? RPAR
	;
	
/**
 * Declaration of a void function. A void function does not end with a return statement.
 */
voidFunc
	: VOID newID LPAR (parameters (COMMA parameters)*)? RPAR statBlockBody
	;
	
/**
 * Declaration of a return function. These functions must end with a return statement. 
 */
returnFunc
	: type newID LPAR (parameters (COMMA parameters)*)? RPAR LBRACE body returnStat RBRACE
	;

/**
 * Two types of parameters are defined: call by value and call by reference parameters. Call
 * by reference parameters must be preceded by the keyword REF. 
 */
parameters
	: type newID		#paramVal
	| REF type newID	#paramRef
	;



/**Keywords of Eloquence.  */

AND:		A N D;
ARRAY:		H O D G E P O D G E;
BOOLEAN:	G E O R G E;
CHAR:		L E X O G R A P H I C I D E N T I F Y I N G U N I T;
CONST:		S A C R O S A N C T;
ELSE:		C O N T R A R I W I S E;
EQ:			E Q U A L T O;
FALSE:		B O G U S;
GE:			S U P E R I O R O R E Q U A L T O;
GT:			S U P E R I O R T O;
IF:			A S S U M I N G;
IN:			E X P R O P R I A T E;
INTEGER:	N U M E R I C A L D I G I T;
LE:			I N F E R I O R O R E Q U A L T O;
LT:			I N F E R I O R T O;
NE:			N O T E Q U A L T O;
NOT:		N O T;
OR:			O R;
OUT:		E X U D E;
PROGRAM: 	P R O G R A M;
REF:		R E F;
RETURN:		R E L I N Q U I S H;
TRUE:		U N F E I G N E D;
VAR:		H I G H P O W E R E D;
VOID:		G O D F O R S A K E N;
WHILE:		T H R O U G H O U T;

ASSIGN: 	'=';
COMMA:		',';
DIVIDE:		'/';
DOT:		'.';
LBRACE: 	'{';
LPAR:		'(';
LSQBRACKET: '[';
MINUS:		'-';
MODULO:		'%';
MULTIPLY:	'*';
PLUS:		'+';
QUOTE:		'\'';
RBRACE: 	'}';
RPAR:		')';
RSQBRACKET: ']';
SEMI:		';';
SETARRAY:	'<<';


/** Content-bearing token types. */

ID: LETTER (LETTER | DIGIT)*;
NUM: DIGIT (DIGIT)*;
CHARACTER: QUOTE LETTER QUOTE;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

/**  Skipped token types */
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
