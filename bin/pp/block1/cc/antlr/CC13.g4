lexer grammar CC13;

@header{package pp.block1.cc.antlr;}

STRING : '"'(~('"') | '""')*'"';

//TOKENA : 'L'('a')+(' ')*;
//TOKENB : 'L'('a')+(' ')*'L'('a')+(' ')*;
//TOKENC : 'L'('a')+(' ')*'L'('a')+(' ')*'L'('a')+(' ')*'L''i'(' ')*;
