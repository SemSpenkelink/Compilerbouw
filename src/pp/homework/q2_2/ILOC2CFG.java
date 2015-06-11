package pp.homework.q2_2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pp.iloc.Assembler;
import pp.iloc.model.Label;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Operand;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

public class ILOC2CFG {
	/** The singleton instance of this class. */
	private static final ILOC2CFG instance = new ILOC2CFG();
	 

	/** Returns the singleton instance of this class. */
	public static ILOC2CFG instance() {
		return instance;
	}

	/** Converts an ILOC file given as parameter and prints out the
	 * resulting CFG. 
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: filename");
		}
		try {
			Program prog = Assembler.instance().assemble(new File(args[0]));
			System.out.println(instance().convert(prog));
		} catch (FormatException | IOException exc) {
			exc.printStackTrace();
		}
	}

	/** Private constructor for the singleton instance. */
	private ILOC2CFG() {
		// empty by design
	}

	public Graph convert(Program prog) {
		Graph graph = new Graph();
		Node currentNode = null;
		Map <Label,Node> labels = new HashMap<Label,Node>();
		List <Operand> operands; 
		Op current;
		int size = prog.size();
		for(int index = 0; index < size; index++){
			current = prog.getOpAt(index);
			
			//Add and check label//
			if(current.hasLabel() && !labels.containsKey(current.getLabel())){
				currentNode = graph.addNode(current.getLabel().toString());
				labels.put(current.getLabel(),currentNode);
			}else if(current.hasLabel()){
				currentNode = labels.get(current.getLabel());
			}
			
			if(current.getOpCode().equals(OpCode.jumpI)){
				operands = current.getOpnds();
				Label tmp;
				for(int i = 0; i < operands.size(); i++){
					if(operands.get(i).getType().equals(Operand.Type.LABEL)){
						tmp = (Label)operands.get(i);
						if (labels.containsKey(tmp)){
							currentNode.addEdge(labels.get(tmp));
						}
						else{							
							labels.put(tmp, graph.addNode(tmp.toString()));
							currentNode.addEdge(labels.get(tmp));
						}
					}					
				}
			} else	if(current.getOpCode().equals(OpCode.cbr)){
				operands = current.getOpnds();
				Label tmp;
				for(int i = 0; i < operands.size(); i++){
					if(operands.get(i).getType().equals(Operand.Type.LABEL)){
						tmp = (Label)operands.get(i);
						if (labels.containsKey(tmp)){
							currentNode.addEdge(labels.get(tmp));
						}
						else{							
							labels.put(tmp, graph.addNode(tmp.toString()));
							currentNode.addEdge(labels.get(tmp));
						}
					}					
				}
			}

			
		}
		return graph;
		//throw new UnsupportedOperationException();
	}
}
