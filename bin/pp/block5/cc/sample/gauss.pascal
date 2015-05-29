Program gauss;

Function upperBound(n: Integer): Integer;
    Begin
    	Var x := 1
    	Var upperBound := 0
    	While x <= n Do
    	Begin
    		upperBound := upperBound + x
    		x := x + 1
    	End;
    End;

Var arg, result: Integer;
Begin
    In("Argument? ", arg);
    result := upperBound(arg);
    Out("Result: ", result)
End.
