lexer grammar L;

@header{package pp.block2.cc.ll;}

L : R'a' | Q'ba';
R : 'aba'S | 'caba'S ;
S : 'bc'S | '' ;
Q : 'b'U ;
U : 'bc' | 'c' ;

// ignore whitespace
WS : [ \t\n\r] -> skip;

// everything else is a typo
TYPO : (~(' ' | '\t' | '\n' | '\r'))+;
