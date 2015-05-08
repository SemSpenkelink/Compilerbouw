grammar TGrammarListener;

t : t HAT t
	| t PLUS t
	| t EQUALS t
	| LPAR t RPAR
	;
t : NUMBER 
	| BOOL
	| STRING
	;