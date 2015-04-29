lexer grammar CC12;

@header{package pp.block1.cc.antlr;}

<<<<<<< HEAD
LETTER : ('a'..'z'|'A'..'Z');
ALPHANUMERIC : ('0'..'9' | LETTER);
VALUE : LETTER ALPHANUMERIC ALPHANUMERIC ALPHANUMERIC ALPHANUMERIC ALPHANUMERIC;// Keyword
WS    : [ \t\r\n]+ -> skip ;

=======
fragment ALPHA_CHAR : ('a'..'z' | 'A'..'Z');
fragment DIGIT : ('0'..'9');
fragment ALP_DIG : (ALPHA_CHAR | DIGIT);

TOKEN : ALPHA_CHAR ALP_DIG ALP_DIG ALP_DIG ALP_DIG ALP_DIG;
>>>>>>> origin/master
