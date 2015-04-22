package pp.block1.cc.dfa;

import java.util.ArrayList;
import java.util.List;

public class GeneratorImplementation implements Generator{

	@Override
	public List<String> scan(State dfa, String text) {
		Checker checker = new CheckerImplementation();
		List<String> list = new ArrayList<String>();
		String tmpText = text;
		while(tmpText.length() > 0){
			while(tmpText.length() >= 0 && !checker.accepts(dfa, tmpText))
				tmpText = tmpText.substring(0, tmpText.length()-1);
			list.add(tmpText);
			
			int prevLength = 0;
			for(int index = 0; index < list.size(); index++)
				prevLength += list.get(index).length();
			
			tmpText = text.substring(prevLength, text.length());
		}
		return list;
	}
	
	

}
