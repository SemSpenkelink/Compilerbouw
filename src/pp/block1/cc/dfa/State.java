package pp.block1.cc.dfa;

import java.util.Map;
import java.util.TreeMap;

/**
 * State of a DFA.
 */
public class State {
	/**
	 * Constructs a new, possibly accepting state with a given number. The
	 * number is meant to identify the state, but there is no check for
	 * uniqueness.
	 */
	public State(int nr, boolean accepting) {
		this.next = new TreeMap<>();
		this.nr = nr;
		this.accepting = accepting;
	}

	/** Returns the state number. */
	public int getNumber() {
		return nr;
	}

	/** State number */
	private final int nr;

	/** Indicates if the state is accepting. */
	public boolean isAccepting() {
		return accepting;
	}

	/** Flag indicating if this state is accepting. */
	private final boolean accepting;

	/**
	 * Adds an outgoing transition to a next state. This overrides any previous
	 * transition for that character.
	 */
	public void addNext(Character c, State next) {
		this.next.put(c, next);
	}

	/** Indicates if there is a next state for a given character. */
	public boolean hasNext(Character c) {
		return getNext(c) != null;
	}

	/**
	 * Returns the (possibly <code>null</code>) next state for a given
	 * character.
	 */
	public State getNext(Character c) {
		return next.get(c);
	}

	/** Mapping to next states. */
	private final Map<Character, State> next;

	@Override
	public String toString() {
		String trans = "";
		for (Map.Entry<Character, State> out : next.entrySet()) {
			if (!trans.isEmpty()) {
				trans += ", ";
			}
			trans += "--" + out.getKey() + "-> " + out.getValue().getNumber();
		}
		return String.format("State %d (%s) with outgoing transitions %s", nr,
				accepting ? "accepting" : "not accepting", trans);
	}

	static final public State ID6_DFA;
	static {
		ID6_DFA = new State(0, false);
		State id61 = new State(1, false);
		State id62 = new State(2, false);
		State id63 = new State(3, false);
		State id64 = new State(4, false);
		State id65 = new State(5, false);
		State id66 = new State(5, true);
		State[] states = { ID6_DFA, id61, id62, id63, id64, id65, id66 };
		for (char c = 'a'; c < 'z'; c++) {
			for (int s = 0; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
		for (char c = 'A'; c < 'Z'; c++) {
			for (int s = 0; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
		for (char c = '0'; c < '9'; c++) {
			for (int s = 1; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
	}
	
	static final public State DFA_LALA;
	static{
		DFA_LALA = new State(0, false);
		State la01 = new State(1, false);
		State la02 = new State(2, true);
		State la03 = new State(3, true);
		State la04 = new State(4, false);
		State la05 = new State(5, true);
		State la06 = new State(6, true);
		State la07 = new State(7, false);
		State la08 = new State(8, false);
		State la09 = new State(9, false);
		State la10 = new State(10, false);
		State la11 = new State(11, true);

		DFA_LALA.addNext('L', la01);
		la01.addNext('a', la02);
		la02.addNext('a', la02);
		la02.addNext(' ', la03);
		la02.addNext('L', la04);
		la03.addNext(' ', la03);
		la03.addNext('L', la04);
		la04.addNext('a', la05);
		la05.addNext('a', la05);
		la05.addNext(' ', la06);
		la05.addNext('L', la07);
		la06.addNext(' ', la06);
		la06.addNext('L', la07);
		la07.addNext('a', la08);
		la08.addNext('a', la08);
		la08.addNext(' ', la09);
		la08.addNext('L', la10);
		la09.addNext(' ', la09);
		la09.addNext('L', la10);
		la10.addNext('i', la11);
		la11.addNext(' ', la11);
	}
}
