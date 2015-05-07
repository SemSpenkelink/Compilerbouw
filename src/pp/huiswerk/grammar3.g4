grammar grammar3;

r : E;
E : F EP;
EP: '' | ('+' | '-')F EP;
F: '(' ID ')' F | G;
G : A GP;
GP: '' | ( '[' E ']' | '.' ID) GP;
A : '(' E ')' | ID | NUM;

NUM: ('0'..'9')+;
ID: ('a'..'z' | 'A'..'Z' | '0'..'9')+;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
