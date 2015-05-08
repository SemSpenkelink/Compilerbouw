lexer grammar TVocab;

@header{package pp.block3.cc.antlr;}

HAT    : '^';
PLUS   : '+';
EQUALS : '=';
LPAR   : '(';
RPAR   : ')';

NUMBER : [0-9]+;
BOOL   : 'true' | 'false';
STR	   : ([a-z] | [A-Z])+;

// ignore whitespace
WS : [ \t\n\r] -> skip;
