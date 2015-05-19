package pp.block3.cc.symbol;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

import pp.block2.cc.AST;

public class SymbolTableImpl implements SymbolTable{
	
	Stack<List<String>> treeStack;
	
	public SymbolTableImpl(){
		treeStack = new Stack<List<String>>();
		treeStack.push(new ArrayList<String>());
	}
	
	@Override
	public void openScope() {
		treeStack.push(new ArrayList<String>());
	}

	@Override
	public void closeScope() {
		if(treeStack.size() <= 1){
			throw new RuntimeException("Cannot close scope.");
		}
		treeStack.pop();
	}

	@Override
	public boolean add(String id) {
		List<String> current = treeStack.peek();
		if(current.contains(id)){
			return false;
		}else{
			current.add(id);
			return true;
		}
	}

	@Override
	public boolean contains(String id) {
		for(List<String> list : treeStack){
			if(list.contains(id))
				return true;
		}
		return false;
	}

}
