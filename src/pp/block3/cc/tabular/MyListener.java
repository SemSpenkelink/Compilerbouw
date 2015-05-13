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
		try {
			PipedOutputStream pipeOut = new PipedOutputStream();
			PipedInputStream pipeIn = new PipedInputStream(pipeOut);
			System.setErr(new PrintStream(pipeOut));
			baseErrListener.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
			String output = "";
			int nextChar;
			while((nextChar = pipeIn.read()) != -1){
				output += (char) nextChar;				
			}
			errorMessages.add(output);
			pipeIn.close();
			pipeOut.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public List<String> getErrorMessages(){
		return this.errorMessages;
	}
}
