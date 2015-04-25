lexer grammar CC14;

@header{package pp.block1.cc.antlr;}

fragment LA : 'L'('a')+(' ')*;
fragment LI : 'L''i'(' ')*;
TOKENA : LA;
TOKENB : LA LA;
TOKENC : LA LA LA LI;