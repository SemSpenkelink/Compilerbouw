grammar Arithmetic;

@header{package pp.block2.cc.antlr;}

expr : <assoc=right> expr rightOp expr
	| <assoc=left> expr md expr			
	| <assoc=left> expr as expr			
	| NAME;

md :   '*'	#mult
	 | '/'	#div;

as :   '+'	#add
	 | '-'	#sub;
	 
rightOp : '^';
	 
NAME : '-'* DIGIT;	 
DIGIT : '0' | ('1'..'9')('0'..'9')*;

// ignore whitespace
WS : [ \t\n\r] -> skip;

// everything else is a typo
TYPO : [a-zA-Z]+;
