grammar SBN;

number returns [ int value, boolean negative ]
	   : Sign=sign List=list { $List.position = 0;	$value=($Sign.negative) ? -$List.value : $List.value;}
	   ;
sign   returns [ boolean negative ]
	   : s0='+' 		 { $negative=false; }
	   | s0='-'			 { $negative=true;  } 
	   ;
list   returns [ int position, int value ]
	   : { $List1.position=$position+1; $Bit0.position=$position; } Bit0=bit List1=list	{ $value=$List1.value+$Bit0.value; }
	   | { $Bit1.position=$position; }								Bit1=bit			{ $value=$Bit1.value; }
	   ;
bit	   returns [ int position, int value ]
	   : b0='1' 		 { $value= (1 << $position); }
	   | b0='0'			 { $value=0; }
	   ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines 
