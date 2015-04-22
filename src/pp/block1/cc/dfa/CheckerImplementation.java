package pp.block1.cc.dfa;

public class CheckerImplementation implements Checker{
	
	@Override
	public boolean accepts(State start, String word) {
		State ID6_DFA = State.ID6_DFA;
		for(int index = 0; index < word.length(); index++)
			ID6_DFA = ID6_DFA.getNext(word.charAt(index));
		return ID6_DFA.isAccepting();
	}

}
