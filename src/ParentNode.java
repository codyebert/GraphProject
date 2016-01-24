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
	int shortest = Integer.MAX_VALUE;
	int longest = -1;
	int count = 0;
	
	public LinkedList<Integer> getEdges() {
		return edges;
	}

	public void setEdges(LinkedList<Integer> edges) {
		this.edges = edges;
	}

	public int getShortest() {
		return shortest;
	}

	public void setShortest(int shortest) {
		this.shortest = shortest;
	}

	public int getLongest() {
		return longest;
	}

	public void setLongest(int longest) {
		this.longest = longest;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public LinkedList<Integer> getVertices() {
		return edges;
	}

	public void setVertices(LinkedList<Integer> vertices) {
		this.edges = vertices;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
