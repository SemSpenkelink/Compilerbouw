grammar grammar3;

r : e;
e : e ('+' | '-') f | f;
f: '(' ID ')' f | g;
g : g ( '[' e ']' | '.' ID) | a;
a : '(' e ')' | ID | NUM;

NUM: ('0'..'9')+;
ID: ('a'..'z' | 'A'..'Z' | '0'..'9')+;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
