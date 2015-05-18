grammar grammar3_ll1;

e : f ep;
ep: '' | ('+' | '-')f ep;
f : '(' fp | g;
fp: ID ')' f | ap gp;
g : a gp;
gp: '' | ('[' e ']' | '.'ID) gp;
a : NUM | ID;
ap: e ')';

NUM: ('0'..'9')+;
ID: ('a'..'z' | 'A'..'Z' | '0'..'9')+;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines 
