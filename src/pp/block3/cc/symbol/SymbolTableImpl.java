package pp.block3.cc.symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import pp.block2.cc.AST;

public class SymbolTableImpl implements SymbolTable{
	
	private class SymbolTree{
		private SymbolTree parent;
		private List<SymbolTree> children;
		private List<String> ids;
		
		public SymbolTree(SymbolTree parent){
			this.parent = parent;
			ids = new ArrayList<String>();
			children = new ArrayList<SymbolTableImpl.SymbolTree>();
		}
		
		public void addChild(SymbolTree child) {
			if (child != null) 
				children.add(child);
		}
		
		public List<SymbolTree> getChildren(){
			return children;
		}
		
		public SymbolTree getParent(){
			return parent;
		}
		
		public List<String> getIds(){
			return this.ids;
		}
		
		public void addId(String id){
			ids.add(id);
		}
	}
	
	Stack<SymbolTree> treeStack;
	
	public SymbolTableImpl(){
		this.treeStack = new Stack<SymbolTableImpl.SymbolTree>();
		SymbolTree tree = new SymbolTree(null);
		treeStack.push(tree);
	}
	
	@Override
	public void openScope() {
		SymbolTree current = treeStack.peek();
		SymbolTree newTree = new SymbolTree(current);
		current.addChild(newTree);
		treeStack.push(newTree);
	}

	@Override
	public void closeScope() {
		SymbolTree current = treeStack.peek();
		if(current.getParent() == null)
			throw new RuntimeException();
		treeStack.pop();
	}

	@Override
	public boolean add(String id) {
		SymbolTree current = treeStack.peek();
		if(current.getIds().contains(id))
			return false;
		else
			current.addId(id);
			return true;
	}

	@Override
	public boolean contains(String id) {
		SymbolTree current = treeStack.peek();
		while(current != null){
			if(current.getIds().contains(id))
				return true;
			else
				current = current.getParent();
		}
		return false;
	}

}
