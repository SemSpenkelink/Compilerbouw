grammar Tabular;

@header{package pp.block3.cc.tabular;}

latex	: begin arg tabLine* end;
comment	: '%' (TEXT | '');
begin	: '\\begin{' begType '}';
begType : 'tabular';
arg		: '{' argType* '}';
argType : 'l' | 'c' | 'r';
tabLine : ((TEXT ('&' TEXT)*) | '') '\\\\';
end		: '\\end{' endType '}';
endType : 'tabular';

TEXT: [a-zA-Z0-9 \t\r]+;

WS : [\n]+ -> skip;
