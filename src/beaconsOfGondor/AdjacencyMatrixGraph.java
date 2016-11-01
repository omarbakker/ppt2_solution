package beaconsOfGondor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class AdjacencyMatrixGraph implements Graph {

	private List <List <Boolean>> adjacencyMatrix;
	private List <Vertex> vertices;

	public AdjacencyMatrixGraph(){
		adjacencyMatrix = new LinkedList<List<Boolean>>();
		vertices = new LinkedList<Vertex>();
	}

	@Override
	public void addVertex(Vertex v){
		// Add the vertex to the internal list
		vertices.add(v);

		// update the adjacency matrix to contain zero/false in the indeces [0:n-1][n-1]
		// these zeros mean that the new vertex does not have any edges connecting it to other vertices
		for (List<Boolean> edgeList:adjacencyMatrix)
			edgeList.add(false);

		// add a new boolean list to the adjacencyMatrix for the new vertexes outgoing edges
		ArrayList <Boolean> newEdgeList = new ArrayList<Boolean>();
		while (newEdgeList.size() < vertices.size()) newEdgeList.add(false);
		adjacencyMatrix.add(vertices.size() - 1, newEdgeList);

		assert repInvariant();
	}

	@Override
	public void addEdge(Vertex v1, Vertex v2){
		int i1 = vertices.indexOf(v1);
		int i2 = vertices.indexOf(v2);
		if (i1 == -1 || i2 == -1)
			throw new IllegalArgumentException();
		adjacencyMatrix.get(i1).set(i2,true);

		assert repInvariant();
	}

	@Override
	public boolean edgeExists(Vertex v1, Vertex v2){
		int i1 = vertices.indexOf(v1);
		int i2 = vertices.indexOf(v2);
		if (i1 == -1 || i2 == -1)
			throw new IllegalArgumentException();
		return adjacencyMatrix.get(i1).get(i2);
	}

	@Override
	public List<Vertex> getDownstreamNeighbors(Vertex v){
		List <Vertex> neighbors = new LinkedList<Vertex>();
		int indexOfV = vertices.indexOf(v);
		if (indexOfV == -1)
			throw new IllegalArgumentException();
		List <Boolean> downStreamEdjesList = adjacencyMatrix.get(indexOfV);
		for (int i = 0; i < downStreamEdjesList.size(); i++){
			boolean hasEdge = downStreamEdjesList.get(i);
			if (hasEdge)
				neighbors.add(vertices.get(i)); //TODO: should I defensive copy the vertices
		}
		return neighbors;
	}

	@Override
	public List<Vertex> getUpstreamNeighbors(Vertex v){

		List <Vertex> neighbors = new LinkedList<Vertex>();
		int indexOfV = vertices.indexOf(v);
		if (indexOfV == -1)
			throw new IllegalArgumentException();
		for (int i = 0; i < adjacencyMatrix.size(); i++){
			List <Boolean> vertexEdgesList = adjacencyMatrix.get(i);
			if (vertexEdgesList.get(indexOfV))
				neighbors.add(vertices.get(i));
		}		
		return neighbors;
	}

	@Override
	public List<Vertex> getVertices(){
		List <Vertex> vertexListCopy = new LinkedList<Vertex>(vertices);
		return vertexListCopy;
	}

	private boolean repInvariant(){
		return (vertices.size() == adjacencyMatrix.size());
	}


}
