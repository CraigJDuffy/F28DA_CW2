package CW2;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.Iterator;
import java.util.Scanner;

import org.jgrapht.graph.SimpleDirectedWeightedGraph;
public class PartAAndPartB {

	public PartAAndPartB() {
		
	}
	
    public static class MyEdge extends DefaultWeightedEdge {
        
        public double getWeight2() {
            return  getWeight();
        }
    }

	public static void main(String[] args) {
		SimpleDirectedWeightedGraph<String, MyEdge> flightGraph = createFlightGraph();
		
		System.out.print("The following airports are used: \n");
		System.out.println(flightGraph.vertexSet().toString());
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nPlease enter start airport: ");
		
		String startVertex = scanner.nextLine();
		System.out.print("\nPlease enter the destination airport: ");
		
		String destinationVertex = scanner.nextLine();
		scanner.close();
		
		DijkstraShortestPath d = new DijkstraShortestPath(flightGraph, startVertex, destinationVertex);
		String path = null; 
		if ( d.findPathBetween(flightGraph, startVertex, destinationVertex)!= null){
			 path = d.findPathBetween(flightGraph, startVertex, destinationVertex).toString();
		}
		
		else{ 
			System.out.println("No Path Found");
			System.exit(0);
		}
		System.out.print("The shortest (i.e cheapest path) is as follows: " + path);
		
		Iterator i = d.findPathBetween(flightGraph, startVertex, destinationVertex).listIterator();
		Double sum = 0.00;
		while(i.hasNext()){
			MyEdge edge = (MyEdge)i.next();
			sum += edge.getWeight2();
			System.out.println("Hello World:"  + sum);
		
		}
		
		org.jgrapht.graph.DefaultWeightedEdge edge = new org.jgrapht.graph.DefaultWeightedEdge();
		//edge.setE
		
		System.out.print("\nCost of shortest path = " + sum );
		//System.out.println(flightGraph.toString());
	}
	
	
	private static SimpleDirectedWeightedGraph<String, MyEdge> createFlightGraph() {
		
        SimpleDirectedWeightedGraph<String, MyEdge> flightGraph = new SimpleDirectedWeightedGraph<>(MyEdge.class);

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
		
		MyEdge e = new MyEdge();
		
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
		
		 e= flightGraph.addEdge("Dubai", "Edinburgh");
	    flightGraph.setEdgeWeight(e, 190.00);
		 e=flightGraph.addEdge("Edinburgh", "Dubai");
	    flightGraph.setEdgeWeight(e, 190.00);

		e = flightGraph.addEdge("Kuala Lumpur", "Sydney");
	    flightGraph.setEdgeWeight(e, 150.00);
		e = flightGraph.addEdge("Sydney", "Kuala Lumpur");
	    flightGraph.setEdgeWeight(e, 150.00);

		e = flightGraph.addEdge("Edinburgh", "Frankfurt");
	    flightGraph.setEdgeWeight(e, 90.00);
		e = flightGraph.addEdge("Frankfurt", "Edinburgh");
	    flightGraph.setEdgeWeight(e, 90.00);

		e = flightGraph.addEdge("Sydney", "Auckland");
	    flightGraph.setEdgeWeight(e, 120.00);
		e = flightGraph.addEdge("Auckland", "Sydney");
	    flightGraph.setEdgeWeight(e, 120.00);

		e = flightGraph.addEdge("Rio de Janeiro", "New York");
	    flightGraph.setEdgeWeight(e, 430.00);
		e = flightGraph.addEdge("New York", "Rio de Janeiro");
	    flightGraph.setEdgeWeight(e, 430.00);

		 e = flightGraph.addEdge("New York", "Santiago");
		flightGraph.setEdgeWeight(e, 320.00);
		e = flightGraph.addEdge("Santiago", "New York");
		flightGraph.setEdgeWeight(e, 320.00);

		//Returns the Graph
		return flightGraph; 
		
	}
	
	
}
	
