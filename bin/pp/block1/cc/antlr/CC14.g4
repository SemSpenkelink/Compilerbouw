lexer grammar CC14;

@header{package pp.block1.cc.antlr;}

TOKENA : 'L'('a')+(' ')*;
TOKENB : 'L'('a')+(' ')*'L'('a')+(' ')*;
TOKENC : 'L'('a')+(' ')*'L'('a')+(' ')*'L'('a')+(' ')*'L''i'(' ')*;


