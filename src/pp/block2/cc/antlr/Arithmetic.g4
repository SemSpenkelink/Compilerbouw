grammar Arithmetic;

@header{package pp.block2.cc.antlr;}

expr : <assoc=right> expr '^' expr  #pow
	| <assoc=left> expr '*' expr	#mul
	| <assoc=left> expr '/' expr	#div	
	| <assoc=left> expr '+' expr	#add
	| <assoc=left> expr '-' expr	#sub		
	| NAME							#name;
	 
NAME : '-'* DIGIT;	 
DIGIT : '0' | ('1'..'9')('0'..'9')*;

// ignore whitespace
WS : [ \t\n\r] -> skip;

// everything else is a typo
TYPO : [a-zA-Z]+;
