import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	//Constructor//
	public Graph(int numVertices, int numEdges, LinkedList<ParentNode> vertexList,
			LinkedList<Integer> vertices) {
		super();
		this.numEdges = numEdges;
		this.numVertices = numVertices;
		this.vertexList = vertexList;
		this.vertexKeys  = new ParentNode[numVertices+1];
		
	}
	//Variables//
	int numEdges = 0;
	int numVertices = 0;
	//The parent nodes
	LinkedList<ParentNode> vertexList = null;
	ParentNode curVertex = null;
	ParentNode[] vertexKeys = null;
	int keyIndex = 0;
	int shortest = Integer.MAX_VALUE;
	int longest = -1;
	int numberOfPaths = 0;
	
	
	
	//Getters/Setters//
	public void addToList(ParentNode node)
	{
		vertexList.add(node);
		vertexKeys[keyIndex] = node;
		curVertex = node;	
	}
	public ParentNode[] getVertexKeys() {
		return vertexKeys;
	}
	public void setVertexKeys(ParentNode[] vertexKeys) {
		this.vertexKeys = vertexKeys;
	}
	public int getKeyIndex() {
		return keyIndex;
	}
	public void setKeyIndex(int keyIndex) {
		this.keyIndex = keyIndex;
	}
	public int getNumEdges() {
		return numEdges;
	}
	public void setNumEdges(int numEdges) {
		this.numEdges = numEdges;
	}
	public int getNumVertices() {
		return numVertices;
	}
	public void setNumVertices(int numVertices) {
		this.numVertices = numVertices;
	}
	public LinkedList<ParentNode> getVertexList() {
		return vertexList;
	}
	public void setVertexList(LinkedList<ParentNode> vertexList) {
		this.vertexList = vertexList;
	}
	public ParentNode getCurVertex() {
		return curVertex;
	}
	public void setCurVertex(ParentNode curVertex) {
		this.curVertex = curVertex;
	}
	
	
	

	
	
	
	
	
	
	
	
}
