grammar SBN;

number : sign list;
sign : '+' | '-';
list : list bit | bit;
bit : '1' | '0';

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines 
