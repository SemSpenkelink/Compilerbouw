package pp.s1367102.q2_2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import pp.iloc.Assembler;
import pp.iloc.model.Label;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Operand;
import pp.iloc.model.Operand.Type;
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
		/*Graph to return.*/
		Graph graph							= new Graph();
		/*List of reachable nodes, excludes dead code.*/
		List<Node> reachableNodes 			= new ArrayList<Node>();
		/*list of vertices in the form Node.toString -> List<Nodes.toString>,
		 * this adds all vertices regardless of dead code.*/
		Map<String, List<String>> vertices 	= new HashMap<String, List<String>>();
		/*Current label the program is in.*/
		Label currentLabel 					= null;
		/*Indication of boolean.*/
		boolean hasJump						= false;
		
		/*Add first node to reachableNodes.*/
		reachableNodes.add(graph.addNode(prog.getOpAt(0).getLabel().toString()));
		
		/*Iterate the program.*/
		for(int line = 0; line < prog.size(); line++){
			Op operation = prog.getOpAt(line);
			
			/*When a line is preceded by a label:*/
			if(operation.hasLabel()){
				/*If this is not the first node, and there has not been a jump, and
				 * the previous node was reachable, add an edge between the previous
				 * node and the current node.*/
				if(line > 0 && !hasJump && listContainsNodeId(reachableNodes, currentLabel.toString())){
					addVertex(vertices, currentLabel, operation.getLabel());
					reachableNodes.add(graph.addNode(operation.getLabel().toString()));
				}
				/*Set current label.*/
				currentLabel = operation.getLabel();
				/*Add new entry for current label to vertices with an empty list of destination nodes.*/
				vertices.put(operation.getLabel().toString(), new ArrayList<String>());				
				/*This part of the program does not have a jump.*/
				hasJump = false;
			}			
			
			/*If the line contains a jumpI or cbr OpCode, set hasJump to true and
			 * add the edges to the list of vertices.*/
			if(operation.getOpCode().equals(OpCode.jumpI) || operation.getOpCode().equals(OpCode.cbr)){
				hasJump = true;
				for(Label label : getLabelsFromOp(operation)){
					if(listContainsNodeId(reachableNodes, currentLabel.toString()))
					reachableNodes.add(graph.addNode(label.toString()));
					addVertex(vertices, currentLabel, label);
				}
			}
		}
		
		/*Construct the graph from reachable nodes and their vertices.*/
		for(Node node : graph.getNodes()){
			List<String> edges = vertices.get(node.getId());
			for(String edge : edges)
				node.addEdge(getNode(graph.getNodes(), edge));
		}
		
		/*Return graph.*/
		return graph;
	}
	
	/**
	 * Get method for certain node from set of Nodes which has
	 * an id equal to given parameter id.
	 * @param nodes;
	 * @param id;
	 * @return node from nodes for which node.getId().equals(id)
	 */
	private Node getNode(Set<Node> nodes, String id){
		for(Node node : nodes)
			if(node.getId().equals(id))
				return node;
		return null;
	}
	
	/**
	 * Adds a destination node to the List of destination nodes from source
	 * within the given map.
	 * @param map;
	 * @param source;
	 * @param destination;
	 * @return 
	 */
	private Map<String, List<String>> addVertex(Map<String, List<String>> map, Label source, Label destination){
		Map<String, List<String>> result = map;
		result.get(source.toString()).add(destination.toString());
		return result;
	}
	
	/**
	 * Returns a list of labels from an operand.
	 * @param operation
	 * @return
	 */
	private List<Label> getLabelsFromOp(Op operation){
		List<Label> result = new ArrayList<Label>();
		List<Operand> opnds  = operation.getOpnds();
		for(Operand op : opnds){
			if(op.getType().equals(Type.LABEL))
				result.add((Label)op);
		}
		return result;
	}
	
	/**
	 * Checks whether a list of nodes contains a node with id id.
	 * @param list
	 * @param id
	 * @return
	 */
	private boolean listContainsNodeId(List<Node> list, String id){
		for(Node node : list)
			if(node.getId().equals(id))
				return true;
		return false;
	}
}
