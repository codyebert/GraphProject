import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;


public class Grapher {

	static int curIndex = 0;
	static int tempIndex = 1;
	static boolean newGraph = true;
	String delims = "[ ]+";
	static Graph[] Graphs = null;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Hello World!");
		File file = new File("inBig.txt");
		System.out.println();
		Scanner input = new Scanner(file);
		int numOfGraphs = 0;
		int numOfEdges = 0;
		int numOfVertices = 0;
		ParentNode curVertex = null;
		String delims = " ";
	
		
		
		//Gets text file and parse it//
		//Gets first number and saves as number of graphs
		numOfGraphs = Integer.parseInt(input.nextLine());
		Graphs = new Graph[numOfGraphs];
		//System.out.println(numOfGraphs);
		
		
		//Loops through text file, separating graphs, edges, vertices
		while(input.hasNext()) {
			
		    String nextLine = input.nextLine();
		    String[] tokens = nextLine.split(delims);  
		
		    
		    if(tokens.length == 1){
		    	
		    	if(curIndex < numOfGraphs)
		    	{
		    		Graphs[curIndex] = new Graph(Integer.parseInt(tokens[0]), Integer.parseInt(input.nextLine()), null, null);	
		    		newGraph = true;	
		    	}
		    	
		    }
		    //Grabs a node and its edge
		    else if(tokens.length > 1)
		    {
		    	//System.out.println(tokens[0]);
		    	
		    	//Add vertex to graph//
		    	//If new graph
		    	if(newGraph == true)
		    	{
		    		createGraph(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]));
		    	}
		    	else if(newGraph == false)
		    	{
		    		//If still same parent vertex
		    		if(Graphs[curIndex-1].curVertex.getValue() == Integer.parseInt(tokens[0]))
		    		{
		    			//Add item to sublist
		    			Graphs[curIndex-1].curVertex.edges.add(Integer.parseInt(tokens[1]));
		    			
		    		}
		    		else if(Graphs[curIndex-1].curVertex.getValue() != Integer.parseInt(tokens[0]))
		    		{
		    			
		    			LinkedList<Integer> newEdges = new LinkedList<Integer>();
		    			int val =Integer.parseInt(tokens[0]);
		    			newEdges.add(Integer.parseInt(tokens[1]));
		    			
		    			ParentNode newVertex = new ParentNode();
		    			newVertex.setValue(Integer.parseInt(tokens[0]));
		    			
		    			
		    			Graphs[curIndex-1].setCurVertex(newVertex);
		    			Graphs[curIndex-1].getCurVertex().setVertices(newEdges);
		    			Graphs[curIndex-1].vertexList.add(newVertex);
		    			Graphs[curIndex-1].vertexKeys[val] = newVertex;

		    			
		    		}
		    	}
		    	
		    	
		    
		    	
		    }
		    //Grabs data for a new graph
		    
		    
		}

		input.close();
		
		
		curIndex = 0;
		//Test
//		for(int i = 0; i < numOfGraphs; i++)
//		{
//			int h = 0;
//			for(Iterator j = Graphs[i].vertexList.iterator(); j.hasNext();)	
//			{ 	h++;
//				ParentNode node = (ParentNode) j.next();
//				//System.out.println(node.value);
//				//System.out.println(Graphs[i].vertexKeys[h]);
//				for(Iterator k = node.edges.iterator(); k.hasNext();)
//				{
//					int num = (int) k.next();
//					//System.out.println(num);
//					
//				}
//			}
//			 
//		}
		//Traverse and output values
		traverse(Graphs[tempIndex].vertexKeys[1], 0);
		System.out.println(Graphs[tempIndex].numberOfPaths);
		System.out.println(Graphs[tempIndex].shortest);
    	System.out.println(Graphs[tempIndex].longest);
	}
	
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
static ParentNode traverse(ParentNode n, int count)
{
	int counter = count +1;
	
	for(Iterator j = n.edges.iterator(); j.hasNext();)
	{
		int num = (int)j.next();
		//System.out.println(num);
		if(num < Graphs[tempIndex].numVertices)
		{
			
			traverse(Graphs[tempIndex].vertexKeys[num], counter);
			
		}
		else if (num == Graphs[tempIndex].numVertices)
		{
			//set graph variables: shortest,longest, etc
			
			numberOfPaths(Graphs[tempIndex]);
			shortest(counter);
			longest(counter);
			
			
			
		}
	}
	return null;
}
static //Finds shortest path
void shortest(int count)
{
	if(count < Graphs[tempIndex].shortest)
	{
		Graphs[tempIndex].shortest = count;
	}
	
}
//Finds longest path
static void longest(int count)
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