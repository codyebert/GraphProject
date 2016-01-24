import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;


public class Grapher {

	static int curIndex = 0;
	//static int tempIndex = 0;
	static boolean newGraph = true;
	String delims = "[ ]+";
	static Graph[] Graphs = null;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		System.out.println("Please enter the file of your desired file: ");
		Scanner textDoc = new Scanner(System.in);
		String fileName = textDoc.nextLine();
		textDoc.close();
		
		File file = new File(fileName);
		System.out.println(fileName);
		Scanner input = new Scanner(file);
		int numOfGraphs = 0;
		String delims = " ";
	
		//Gets text file and parse it//
		//Gets first number and saves as number of graphs
		numOfGraphs = Integer.parseInt(input.nextLine());
		Graphs = new Graph[numOfGraphs];
		
		//Loops through text file, separating graphs, edges, vertices
		while(input.hasNext()){
			
		    String nextLine = input.nextLine();
		    String[] tokens = nextLine.split(delims);  
		
		    
		    if(tokens.length == 1){
		    	
		    	if(curIndex < numOfGraphs){
		    		Graphs[curIndex] = new Graph(Integer.parseInt(tokens[0]), Integer.parseInt(input.nextLine()), null, null);	
		    		newGraph = true;	
		    	}	
		    }
		    //Grabs a node and its edge
		    else if(tokens.length > 1)
		    {	    	
		    	//Add vertex to graph//
		    	
		    	//If new graph
		    	if(newGraph == true){
		    		createGraph(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]));
		    	}
		    	else if(newGraph == false){
		    		//If still same parent vertex
		    		if(Graphs[curIndex-1].curVertex.getValue() == Integer.parseInt(tokens[0])){
		    			//Add item to sublist
		    			Graphs[curIndex-1].curVertex.edges.add(Integer.parseInt(tokens[1]));
		    			
		    		}
		    		else if(Graphs[curIndex-1].curVertex.getValue() != Integer.parseInt(tokens[0])){
		    			
		    			LinkedList<Integer> newEdges = new LinkedList<Integer>();
		    			int val =Integer.parseInt(tokens[0]);
		    			newEdges.add(Integer.parseInt(tokens[1]));
		    			
		    			ParentNode newVertex = new ParentNode();
		    			newVertex.setValue(Integer.parseInt(tokens[0]));
		    			
		    			
		    			Graphs[curIndex-1].setCurVertex(newVertex);
		    			Graphs[curIndex-1].getCurVertex().setEdges(newEdges);
		    			Graphs[curIndex-1].vertexList.add(newVertex);
		    			Graphs[curIndex-1].vertexKeys[val] = newVertex;

		    			
		    		}
		    	}
		    }    
		}

		input.close();
		//curIndex = 0;

		//Traverse and output values
		for(int tempIndex = 0; tempIndex < numOfGraphs; tempIndex++){
			
			if(Graphs[tempIndex] != null)
			{
				traverse(Graphs[tempIndex].vertexKeys[1], 0, tempIndex);
				int num = tempIndex+1;
				System.out.println("Graph number: " + num);
				System.out.println("Number of paths:" + Graphs[tempIndex].numberOfPaths);
				System.out.println("Shortest Path: " + Graphs[tempIndex].shortest);
				System.out.println("Longest Path: " + Graphs[tempIndex].longest + "\n");
			}
		}
	}
	
//Creates a graph using initial vertex and edge
static boolean createGraph(int vertex, int edge){
	
		LinkedList<Integer> vertices = new LinkedList<Integer>();
		vertices.add(edge);
		ParentNode newNode = new ParentNode(vertex, vertices);
		LinkedList<ParentNode> vertexList = new LinkedList<ParentNode>();
		vertexList.add(newNode);
		Graphs[curIndex].setKeyIndex(1);
		Graphs[curIndex].vertexKeys[1] = newNode;
		Graphs[curIndex].setVertexList(vertexList);
		Graphs[curIndex].curVertex = newNode;
		
		curIndex++;

		newGraph = false;
		return true;
}

//Traverses a graph
static ParentNode traverse(ParentNode n, int count, int tempIndex)
{
	int counter = count +1;
	
	//Create iterator and iterate through linked sublist
	for(Iterator j = n.edges.iterator(); j.hasNext();)
	{
		int num = (int)j.next();
		//All vertices between 1 and n
		if(num < Graphs[tempIndex].numVertices)
		{
			
			traverse(Graphs[tempIndex].vertexKeys[num], counter, tempIndex);
			
		}
		//Last vertex in sequence
		else if (num == Graphs[tempIndex].numVertices)
		{
			//set graph variables: shortest,longest, etc
			numberOfPaths(Graphs[tempIndex]);
			shortest(counter, tempIndex);
			longest(counter, tempIndex);		
		}
	}
	return null;
}

//Finds shortest path
static void shortest(int count, int tempIndex)
{
	if(count < Graphs[tempIndex].shortest)
	{
		Graphs[tempIndex].shortest = count;
	}
	
}

//Finds longest path
static void longest(int count, int tempIndex)
{
	if(count > Graphs[tempIndex].longest)
	{
		Graphs[tempIndex].longest = count;
	}
}

//Finds number of paths(done)
static void numberOfPaths(Graph g)
{
	g.numberOfPaths = g.numberOfPaths+1;
}

}