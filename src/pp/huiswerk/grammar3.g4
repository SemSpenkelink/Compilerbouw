grammar grammar3;

r : E;
E : E ('+' | '-') F | F;
F: '(' ID ')' F | G;
G : G ( '[' E ']' | '.' ID) | A;
A : '(' E ')' | ID | NUM;

NUM: ('0'..'9')+;
ID: ('a'..'z' | 'A'..'Z' | '0'..'9')+;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
