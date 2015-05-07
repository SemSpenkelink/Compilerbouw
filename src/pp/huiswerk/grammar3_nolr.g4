grammar grammar3_nolr;

e : f ep;
ep: '' | ('+' | '-')f ep;
f: '(' ID ')' f | g;
g : a gp;
gp: '' | ( '[' e ']' | '.' ID) gp;
a : '(' e ')' | ID | NUM;

NUM: ('0'..'9')+;
ID: ('a'..'z' | 'A'..'Z' | '0'..'9')+;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines 
