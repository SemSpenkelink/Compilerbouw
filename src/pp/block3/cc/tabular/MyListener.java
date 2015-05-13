package pp.block3.cc.tabular;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;


public class MyListener extends BaseErrorListener{
	
	private List<String> errorMessages;
	BaseErrorListener baseErrListener;
	
	public MyListener(){
		errorMessages = new ArrayList<String>();
		baseErrListener = new BaseErrorListener();
	}
	
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, java.lang.Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){
		errorMessages.add("line " + line + ":" + charPositionInLine + " " + msg);
	}
	
	public List<String> getErrorMessages(){
		return this.errorMessages;
	}
}
