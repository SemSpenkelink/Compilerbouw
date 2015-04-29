lexer grammar CC12;

@header{package pp.block1.cc.antlr;}

LETTER : ('a'..'z'|'A'..'Z');
ALPHANUMERIC : ('0'..'9' | LETTER);
VALUE : LETTER ALPHANUMERIC ALPHANUMERIC ALPHANUMERIC ALPHANUMERIC ALPHANUMERIC;// Keyword
WS    : [ \t\r\n]+ -> skip ;

