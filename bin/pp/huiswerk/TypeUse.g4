grammar TypeUse;

program : '(' series ')' ;
series : unit * ;
unit : decl | assign | '(' series ')' ;
decl : ID ':' ID ';' ;
assign : ID ':=' ID ';' ;

ID : [a-zA-z]+;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines 
