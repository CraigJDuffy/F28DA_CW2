package CW2;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import java.util.Scanner;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
public class PartAAndPartB {

	public PartAAndPartB() {
		
	}

	public static void main(String[] args) {
		SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> flightGraph = createFlightGraph();
		
		System.out.print("The following airports are used: \n");
		System.out.println(flightGraph.vertexSet().toString());
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nPlease enter start airport: ");
		
		String startVertex = scanner.next();
		System.out.print("\nPlease enter the destination airport: ");
		
		String destinationVertex = scanner.next();
		scanner.close();
		
		DijkstraShortestPath d = new DijkstraShortestPath(flightGraph, startVertex, destinationVertex);
		String path = d.findPathBetween(flightGraph, startVertex, destinationVertex).toString();
		System.out.print("The shortest (i.e cheapest path) is as follows: " + path);
		
		Object[] pathEdgeListArray = d.getPathEdgeList().toArray();
		
		
		System.out.print("\nCost of shortest path = " );
		//System.out.println(flightGraph.toString());
	}
	
	
	private static SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> createFlightGraph() {
		
        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> flightGraph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        //Adds all the airports as vertexes in the graph
        flightGraph.addVertex("Auckland");
		flightGraph.addVertex("Dubai");
		flightGraph.addVertex("Edinburgh");
		flightGraph.addVertex("Frankfurt");
		flightGraph.addVertex("Heathrow");
		flightGraph.addVertex("Kuala Lumpur");
		flightGraph.addVertex("New York");
		flightGraph.addVertex("Rio de Janeiro");
		flightGraph.addVertex("Santiago");
		flightGraph.addVertex("Sydney");
		
		//Adds pairs of destinations
		
		DefaultWeightedEdge e = new DefaultWeightedEdge();
		
	    e = flightGraph.addEdge("Edinburgh", "Heathrow"); 
	    flightGraph.setEdgeWeight(e, 80.00);
	    e = flightGraph.addEdge("Heathrow", "Edinburgh");
	    flightGraph.setEdgeWeight(e, 80.00);
	    
	    
		e = flightGraph.addEdge("Heathrow", "Dubai");
	    flightGraph.setEdgeWeight(e, 130.00);
		e = flightGraph.addEdge("Dubai", "Heathrow");
	    flightGraph.setEdgeWeight(e, 130.00);

		e =flightGraph.addEdge("Heathrow", "Sydney");
	    flightGraph.setEdgeWeight(e, 570.00);
		e =flightGraph.addEdge("Sydney", "Heathrow");
	    flightGraph.setEdgeWeight(e, 570.00);

		
		e = flightGraph.addEdge("Dubai", "Kuala Lumpur");
	    flightGraph.setEdgeWeight(e, 170.00);
		e = flightGraph.addEdge("Kuala Lumpur", "Dubai");
	    flightGraph.setEdgeWeight(e, 170.00);
		
		flightGraph.addEdge("Dubai", "Edinburgh");
	    flightGraph.setEdgeWeight(e, 190.00);
		flightGraph.addEdge("Edinburgh", "Dubai");
	    flightGraph.setEdgeWeight(e, 190.00);

		flightGraph.addEdge("Kuala Lumpur", "Sydney");
	    flightGraph.setEdgeWeight(e, 150.00);
		flightGraph.addEdge("Sydney", "Kuala Lumpur");
	    flightGraph.setEdgeWeight(e, 150.00);

		flightGraph.addEdge("Edinburgh", "Frankfurt");
	    flightGraph.setEdgeWeight(e, 90.00);
		flightGraph.addEdge("Frankfurt", "Edinburgh");
	    flightGraph.setEdgeWeight(e, 90.00);

		flightGraph.addEdge("Sydney", "Auckland");
	    flightGraph.setEdgeWeight(e, 120.00);
		flightGraph.addEdge("Auckland", "Sydney");
	    flightGraph.setEdgeWeight(e, 120.00);

		flightGraph.addEdge("Rio de Janeiro", "New York");
	    flightGraph.setEdgeWeight(e, 430.00);
		flightGraph.addEdge("New York", "Rio de Janeiro");
	    flightGraph.setEdgeWeight(e, 430.00);

		flightGraph.addEdge("New York", "Santiago");
		flightGraph.setEdgeWeight(e, 320.00);
		flightGraph.addEdge("Rio de Janeiro", "New York");
		flightGraph.setEdgeWeight(e, 320.00);

		//Returns the Graph
		return flightGraph; 
		
	}
	
	
}
	
