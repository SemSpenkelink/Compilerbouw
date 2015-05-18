package pp.s1367102.q1_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SymbolTableImplHW implements SymbolTable{

	Stack<List<String>> name;
	Stack<List<String>> type;
	
	public SymbolTableImplHW(){
		name = new Stack<List<String>>();
		type = new Stack<List<String>>();
		name.push(new ArrayList<String>());
		type.push(new ArrayList<String>());
	}
	
	@Override
	public void openScope() {
		name.push(new ArrayList<String>());
		type.push(new ArrayList<String>());
	}

	@Override
	public void closeScope() {
		if(name.size() <= 1){
			throw new RuntimeException();
		}
		name.pop();
		type.pop();
	}

	@Override
	public boolean add(String id) {
		String[] nameType = id.substring(0, id.length()-1).split(":");
		if(!name.peek().contains(nameType[0])){
			name.peek().add(nameType[0]);
			type.peek().add(nameType[1]);
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(String id) {
		for(List<String> list : name){
			if(list.contains(id))
				return true;
		}
		return false;
	}
	
	public String getType(String name){
		List<List<String>> stackList = new ArrayList<List<String>>();
		for(List<String> list : this.name){
			stackList.add(list);
		}
		for(int index = stackList.size()-1; index >= 0; index--){
			if(stackList.get(index).contains(name)){
				List<String> tmp = stackList.get(index);
				for(int index_2 = 0; index_2 < tmp.size(); index_2++){
					if(tmp.get(index_2).equals(name))
						return type.get(index).get(index_2);
				}
			}
		}
		return null;
	}
}
