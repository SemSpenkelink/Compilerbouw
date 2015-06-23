package pp.s1366432.q2_2;

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
		Graph graph = new Graph();								//Graph to be returned
		Map <Label,Node> labels = new HashMap<Label,Node>();	//Keeping track of which label is attached to which node
		Node currentNode = null; 			//Keeping track of which node we are currently in
		Node previousNode = null;				//Keeping track of the previous node
		List <Operand> operands = null; 			//List all operands.
		Op current = null;							//The current Op
		boolean jumped = false;			//Keeping track of whether the previous block has jumped.
		int size = prog.size();		//The number of lines of the program. 
		
		for(int index = 0; index < size; index++){			//Looping once over all the instructions of the program.
			current = prog.getOpAt(index);					//Get the Op at the line current iteration
			if(current.hasLabel() && !jumped && index >= 1){	
				previousNode = currentNode;
			}				
			//Add and check label//
			if(current.hasLabel() && !labels.containsKey(current.getLabel())){	//If the current Op has a label and we haven't added this yet
				currentNode = graph.addNode(current.getLabel().toString());		//add a new node to the graph
				labels.put(current.getLabel(),currentNode);						//and set a new label
			}else if(current.hasLabel()){					
				currentNode = labels.get(current.getLabel());					//Otherwise the node is already added. Get the node corresponding to that label
			}
			
			if(current.hasLabel() && !jumped && index >= 1){
				previousNode.addEdge(currentNode);					//Add an edge from the previous node to the currentNode
			}
			
			if(current.getOpCode().equals(OpCode.jumpI)){		//In case of jumpI instructions
				jumped = true;									//This node has jumped.
				operands = current.getOpnds();					//Retrieve the operands
				Label tmp;
				for(int i = 0; i < operands.size(); i++){		//Iterate over operands
					if(operands.get(i).getType().equals(Operand.Type.LABEL)){	
						tmp = (Label)operands.get(i);			//Retrieve the labels associated with this Op
						if (labels.containsKey(tmp)){			//If this label is already added before, create an edge to the corresponding node
							currentNode.addEdge(labels.get(tmp));
						}
						else{									//else a new node must be created and an edge to that node must be added
							labels.put(tmp, graph.addNode(tmp.toString()));
							currentNode.addEdge(labels.get(tmp));
						}
					}					
				}
			} else	if(current.getOpCode().equals(OpCode.cbr)){		//Exactly the same applies to a cbr instruction
				jumped = true;
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
	}
}
