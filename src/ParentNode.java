import java.util.LinkedList;

public class ParentNode {
	public ParentNode(int value, LinkedList<Integer> vertices) {
		this.value = value;
		this.edges = vertices;
	}

	public ParentNode() {
		edges = null;
		 value = 0;
	}

	LinkedList<Integer> edges = null;
	int value = 0;

	//Returns all the edges for this particular vertex
	public LinkedList<Integer> getEdges() {
		return edges;
	}

	//Set  a linked list of edges to this vertex
	public void setEdges(LinkedList<Integer> edges) {
		this.edges = edges;
	}
	
	//Returns the vertex number
	public int getValue() {
		return value;
	}

	//Sets the vertex number
	public void setValue(int value) {
		this.value = value;
	}
}
