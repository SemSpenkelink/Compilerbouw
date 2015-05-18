grammar SBN2;

number: sign list;
sign: 	'+' 	#plus
		| '-' 	#min ;
list: 	list bit #listBit
		| bit	#onlyBit ; 
bit: 	'0' 	#zero
		| '1' 	#one;