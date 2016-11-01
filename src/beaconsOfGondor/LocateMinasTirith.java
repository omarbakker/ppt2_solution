package beaconsOfGondor;

import java.util.Set;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LocateMinasTirith {

	/**
	 * 
	 * @param numLocations
	 *            the number of cities in the kingdom, 0 < numCities < 50.
	 * @param roadNetwork
	 *            represents the roads connecting different cities in the
	 *            kingdom. roadNetwork.length( ) is equal to
	 *            numLocations*numLocations. For all i, j such that 0 <= i <
	 *            numLocations and 0 <= j < numLocations, the character at index
	 *            numLocations*i+j in this string indicates if there is a road
	 *            between cities i and j (1 if there is and 0 if there is no
	 *            road). For all i such that 0 <= numLocations < i, the
	 *            character at index numLocations*i+i is 1. <strong>The roadNetwork
	 *            represents a connected graph.</strong>
	 * @return a set of city indices with the following condition: the maximum
	 *         travel time from a city (represented by its index) is as small as
	 *         possible. The travel time from one city to another is the number
	 *         of roads to traverse to get from one to the other. For a given
	 *         city, its maximum travel time is the time to reach that city that
	 *         is farthest from it in terms of number of roads traversed.
	 */
	public static Set<Integer> getGoodLocations(int numLocations, String roadNetwork) {

		Graph cities = generateGraph(roadNetwork, numLocations);
		List<Vertex> vList = cities.getVertices();
		List<Integer> maxShortestPaths = new ArrayList<Integer>();
		Set<Integer> candidates = new HashSet<Integer>();
		
		// get all travel times (shortest paths to other cities) for a given city i
		// get the max of those times
		// return the city with the largest max n, or a list of cities if they share a max n.
		
		for (int i = 0; i < numLocations; i++){
			Vertex xi = vList.get(i);
			List<Integer> pathLengths = new ArrayList<Integer>();
			for (int j = 0; j < numLocations; j++){
				Vertex xj = vList.get(j);
				int shortestPath = shortestDistance(cities,xi,xj);
				pathLengths.add(shortestPath);
			}
			// put the max of pathlength inside 
			int max = 0;
			for (int xij:pathLengths){
				if (xij > max)
					max = xij;
			}
			maxShortestPaths.add(max);
		}
		
		// find the max of maxShortestPaths
		int min = Integer.MAX_VALUE;
		for (int xij:maxShortestPaths){
			if (xij < min)
				min = xij;
		}
		
		int index = 0;
		for (int xij:maxShortestPaths){
			if (xij == min)
				candidates.add(index);
			index++;
		}
		
		return candidates; 
	}

	public static Graph generateGraph(String roadNetwork, int n){
		Graph graph = new AdjacencyMatrixGraph();
		for (int i = 0; i < n; i++)
			graph.addVertex(new Vertex(new Integer(i).toString()));
		
		List<Vertex> vList = graph.getVertices();
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				boolean edgeExists = roadNetwork.charAt(n*i+j) == '1';
				if (edgeExists)
					graph.addEdge(vList.get(i), vList.get(j));
			}
		}
		return graph;
	}

	
	public static int shortestDistance(Graph graph, Vertex a, Vertex b) {
		Queue<Vertex> bfsQueue = new LinkedList<Vertex>();
		List<Vertex> visited = new LinkedList<Vertex>();
		List<Integer> distances = new LinkedList<Integer>(); 
		visited.add(a);
		distances.add(0);
		bfsQueue.add(a);
		
		if (a.equals(b)) return 0;
		while (!bfsQueue.isEmpty()){
			Vertex v = bfsQueue.remove();
			
			int currentDistance = distances.get(visited.indexOf(v)) + 1;
			for (Vertex neighbour:graph.getDownstreamNeighbors(v))
				if (!visited.contains(neighbour)){
					if (neighbour.equals(b)) return currentDistance;
					visited.add(neighbour);
					distances.add(currentDistance);
					bfsQueue.add(neighbour);
				}
		}
		return -1;
	}
	
}
