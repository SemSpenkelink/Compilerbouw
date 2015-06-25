package finalProject.checker;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SymbolTable {
	
	Stack<Set<String>> scopes;
	
	public SymbolTable(){
		scopes = new Stack<Set<String>>();
		scopes.push(new HashSet<String>());
	}
	
	public void openScope() {
		scopes.push(new HashSet<String>());
	}

	public void closeScope() {
		if(scopes.size() <= 1){
			throw new RuntimeException("Cannot close scope.");
		}
		scopes.pop();
	}

	public boolean add(String id) {
		Set<String> current = scopes.pop();
		if(current.contains(id)){
			return false;
		}else{
			current.add(id);
			scopes.push(current);
			return true;
		}
	}

	public boolean contains(String id) {
		for(Set<String> scope : scopes){
			if(scope.contains(id))
				return true;
		}
		return false;
	}

}
