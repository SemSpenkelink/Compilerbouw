package finalProject.checker;

import java.util.LinkedHashMap;
import java.util.Map;

import pp.iloc.eval.Machine;

/** Class combining the information of a single scope level. */
public class Scope {
	/** Current size of this scope (in bytes). 
	 * Used to calculate offsets of newly declared variables. */
	private int size;
	/** Map from declared variables to their types. */
	private final Map<String, Type> types;
	/** Map from declared variables to their offset within the allocation
	 * record of this scope. */
	private final Map<String, Integer> offsets;
	/** Map from mutable objects. */
	private final Map<String, Boolean> mutable;

	/** Constructs a fresh, initially empty scope. */
	public Scope() {
		this.types = new LinkedHashMap<>();
		this.offsets = new LinkedHashMap<>();
		this.mutable = new LinkedHashMap<>();
	}

	/** Tests if a given identifier is declared in this scope. */
	public boolean contains(String id) {
		return this.types.containsKey(id);
	}

	/** Declares an identifier with a given type, if the identifier
	 * is not yet in this scope.
	 * @return <code>true</code> if the identifier was added;
	 * <code>false</code> if it was already declared.
	 */
	public boolean put(String id, Type type, boolean mutable) {
		boolean result = !this.types.containsKey(id);
		if (result) {
			this.types.put(id, type);
			this.offsets.put(id, this.size);
			this.mutable.put(id, mutable);
			if(type != null)
				this.size += type.size();
			else
				this.size += Machine.INT_SIZE;
		}
		return result;
	}

	/** Returns the type of a given (presumably declared) identifier.
	 */
	public Type type(String id) {
		return this.types.get(id);
	}

	/** Returns the offset of a given (presumably declared) identifier. 
	  * with respect to the beginning of this scope's activation record.
	  * Offsets are assigned in order of declaration. 
	  */
	public Integer offset(String id) {
		return this.offsets.get(id);
	}
	
	/** Returns whether a given (presumably declared) identifier is mutable.*/
	public Boolean mutable(String id) {
		return this.mutable.get(id);
	}
}