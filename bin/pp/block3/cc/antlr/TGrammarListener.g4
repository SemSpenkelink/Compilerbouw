grammar TGrammarListener;
import TVocab;

t : t HAT t
	| t PLUS t
	| t EQUALS t
	| LPAR t RPAR
	| NUMBER 
	| BOOL
	| STR
	;