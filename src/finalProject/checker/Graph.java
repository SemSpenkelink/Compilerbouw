package finalProject.checker;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Graph class, used for CFGs.
 * @author Arend Rensink
 */
public class Graph implements Iterable<Node> {
	/** Set of nodes in this graph. */
	protected final Set<Node> nodes;

	/** Constructs an initially empty graph. */
	public Graph() {
		this.nodes = new LinkedHashSet<>();
	}

	/** Adds a new node to this graph and returns it.
	 * The new node number equals the number of nodes at the
	 * time of invocation.
	 */
	public Node addNode(ParseTree context) {
		Node result = new Node(this.nodes.size(), context);
		this.nodes.add(result);
		return result;
	}

	/** Adds a new node to this graph with a given ID and returns it.
	 * The new node number equals the number of nodes at the
	 * time of invocation.
	 */
	public Node addNode(String id, ParseTree context) {
		Node result = new Node(this.nodes.size(), id, context);
		this.nodes.add(result);
		return result;
	}

	/** Returns the set of nodes in this graph. */
	public Set<Node> getNodes() {
		return this.nodes;
	}

	/** Returns an iterator over the nodes in this graph. */
	@Override
	public Iterator<Node> iterator() {
		return this.nodes.iterator();
	}

	/** Returns the number of nodes in this graph. */
	public int size() {
		return this.nodes.size();
	}
	
	/** Returns the set of nodes comprising the given context. */
	public Set<Node> getNodes(ParseTree context){
		Set<Node> result = new LinkedHashSet<Node>();
		for(Node node : nodes){
			if(node.getContext().equals(context))
				result.add(node);
		}
		return result;
	}
	
	/** Returns the set of nodes edging to other contexts. */
	public Set<Node> getExitNodes(ParseTree context){
		Set<Node> contextNodes = getNodes(context);
		Set<Node> exitNodes = new LinkedHashSet<Node>();
		for(Node node : contextNodes){
			Set<Node> edges = node.getEdges();
			for(Node edge : edges)
				if(!edge.getContext().equals(context))
					exitNodes.add(node);
		}
		return exitNodes;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("Graph with %d nodes%n", size()));
		for (Node node : this) {
			result.append(node.toString());
			result.append('\n');
		}
		return result.toString();
	}

	@Override
	public int hashCode() {
		return this.nodes.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Graph)) {
			return false;
		}
		Graph other = (Graph) obj;
		if (!this.nodes.equals(other.nodes)) {
			return false;
		}
		return true;
	}
}
