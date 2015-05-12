grammar SBN;

number returns [ int val, int pos, boolean neg ]
	   : s0=sign l0=list { $pos = 0;	$val=($s0.neg) ? -$l0.val : $l0.val;}
	   ;
sign   returns [ boolean neg ]
	   : s0='+' 		 { $neg=false; }
	   | s0='-'			 { $neg=true;  }
	   ;
list   returns [ int pos, int val ]
	   : l0=list b0=bit  { $l0.pos=$pos+1; $b0.pos=$pos; $val=$l0.val+$b0.val; }
	   | b0=bit			 { $b0.pos=$pos; $val=$b0.val; }
	   ;
bit	   returns [ int pos, int val ]
	   : b0='1' 		 { $val= (1 << $pos); }
	   | b0='0'			 { $val=0; }
	   ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines 
