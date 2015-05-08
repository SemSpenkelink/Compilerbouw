grammar TGrammarListener;
import TVocab;

t : t HAT t			#hat
	| t PLUS t		#plus
	| t EQUALS t	#equals
	| LPAR t RPAR	#par
	| NUMBER 		#num
	| BOOL			#bool
	| STR			#str
	;