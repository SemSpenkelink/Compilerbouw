grammar TGram;

import TVocab;

@members {
    private int getValue(String text) {
        return Integer.parseInt(text);
    }
    
    private boolean getBoolValue(String text){
    	if(text.equals("true"))
    		return true;
    	return false;
    }
}

t returns [ Type type, int intVal, boolean boolVal, String strVal ]
	: t0=t HAT t1=t		{$type = $t0.type,  $val = }
	| t0=t PLUS t1=t	{$type = $t0.type,  $val = }
	| t0=t EQUALS t1=t	{$type = Type.BOOL, $boolVal = ($t0.type == $t1.type) ? true : false}
	| LPAR t0=t RPAR	{$type = $t0.type,  if($t0.type == Type.NUM){
												$intVal = $t0.intVal
											}else if($t0.type == Type.BOOL)
												$boolVal = $t0.boolVal}
	| NUMBER			{$type = Type.NUM,  $intVal  = getValue(NUMBER.text)}
	| BOOL				{$type = Type.BOOL, $boolVal = getBoolValue(BOOL.text)}
	| STR				{$type = Type.STR,  $strVal  = STR.text}
	;
	
/*expr returns [ int val ]
     : { System.out.println("minus expr"); }
       MINUS e0=expr
       { $val = -1*$e0.val }
     | e0=expr TIMES e1=expr
       { $val = $e0.val * $e1.val; }
     | e0=expr PLUS e1=expr
       { $val = $e0.val + $e1.val; }
     | LPAR e=expr RPAR
       { $val = $e.val; }
     | { System.out.println("Evaluating NUMBER"); }
       NUMBER
       { $val = getValue($NUMBER.text); }
     ;*/
