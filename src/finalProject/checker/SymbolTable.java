package finalProject.checker;

import java.util.Stack;

public class SymbolTable {
	
	Stack<Scope> scopes;
	
	public SymbolTable(){
		scopes = new Stack<Scope>();
		scopes.push(new Scope());
	}
	
	public void openScope() {
		scopes.push(new Scope());
	}

	public void closeScope() {
		if(scopes.size() <= 1){
			throw new RuntimeException("Cannot close scope.");
		}
		scopes.pop();
	}

	public boolean add(String id, Type type) {
		Scope current = scopes.pop();
		if(current.contains(id)){
			return false;
		}else{
			current.put(id, type);
			return true;
		}
	}

	public boolean contains(String id) {
		for(Scope scope : scopes){
			if(scope.contains(id))
				return true;
		}
		return false;
	}
	
	/** Returns the type of a given (presumably declared) identifier.
	 */
	public Type type(String id) {
		for(int index = scopes.size()-1; index >= 0; index--)
			if(scopes.get(index).contains(id))
				return scopes.get(index).type(id);
		return null;
	}

	/** Returns the offset of a given (presumably declared) identifier. 
	  * with respect to the beginning of this scope's activation record.
	  * Offsets are assigned in order of declaration. 
	  */
	public Integer offset(String id) {
		for(int index = scopes.size()-1; index >= 0; index--)
			if(scopes.get(index).contains(id))
				return scopes.get(index).offset(id);
		return null;
	}

}
