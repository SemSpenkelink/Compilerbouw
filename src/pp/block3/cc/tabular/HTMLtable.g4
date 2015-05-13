grammar HTMLtable;
@header{package pp.block3.cc.tabular;}

doc: '<html> <body>' table '<//body><//html>';
table: '<table border= \"1\"' row* '<//table>';
row: '<tr>' entry* '<//tr>' ;
entry: '<td>' TEXT '<//td>' ;
TEXT: ([a-zA-Z0-9] | '.' | ' ' | '\t' | '')+;