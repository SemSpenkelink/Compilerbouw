lexer grammar Example;

@header{package pp.block1.cc.antlr;}

WHILE : 'while';             // Keyword
DO    : 'do';                // Keyword
WS    : [ \t\r\n]+ -> skip ; // At least one whitespace char; don't make token

TOKENA : 'L'('a')+(' ')*;
TOKENB : 'L'('a')+(' ')*'L'('a')+(' ')*;
TOKENC : 'L'('a')+(' ')*'L'('a')+(' ')*'L'('a')+(' ')*'L''i'(' ')*;