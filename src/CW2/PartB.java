package CW2;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.ListIterator;
import java.util.Scanner;

import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class PartB {

	/*
	 * Part B: Least Cost Connections
	 *
	 * This class performs the actions associated with part B of the course
	 * work.
	 *
	 */
	public PartB() {

	}

	/**
	 * MyEdge is a subclass of DefaultWeightedEdge.
	 * 
	 * It was created as getWeight() can only be called on subclasses of
	 * DefaultWeightedEdge. This was replaced by a Flight object in later
	 * versions of the program.
	 **/
	@SuppressWarnings("serial")
	public static class MyEdge extends DefaultWeightedEdge {
		public double getWeight2() {
			return getWeight();
		}
	}

	/*
	 * The main method creates a new SimpleDirectedWeightedGraph called
	 * flightGraph and then outputs the list of airports to the user. It then
	 * takes in the users input of where they wish to visit (case sensitive) and
	 * prints out the shortest path between the two destinations along with the
	 * flight cost.
	 * 
	 * This really should have been refactored into different methods.
	 * 
	 */
	public static void main(String[] args) {

		// Create graph
		SimpleDirectedWeightedGraph<String, MyEdge> flightGraph = createFlightGraph();

		// Begin Taking User Input
		System.out.print("The following airports are used: \n");
		System.out.println(flightGraph.vertexSet().toString());

		Scanner scanner = new Scanner(System.in);
		System.out.print("\nPlease enter start airport: ");

		String startVertex = scanner.nextLine();
		System.out.print("\nPlease enter the destination airport: ");

		String destinationVertex = scanner.nextLine();
		scanner.close();
		// Finish Taking User input

		// Calculate Shortest Path
		String path = null;
		if (DijkstraShortestPath.findPathBetween(flightGraph, startVertex, destinationVertex) != null) {
			path = DijkstraShortestPath.findPathBetween(flightGraph, startVertex, destinationVertex).toString();
		} else {
			System.out.println("No Path Found");
			System.exit(0);
		}
		// Print shortest path to user
		System.out.print("The shortest (i.e cheapest path) is as follows: " + path);

		// Create an iterator for summing weights
		ListIterator<MyEdge> i = DijkstraShortestPath.findPathBetween(flightGraph, startVertex, destinationVertex)
				.listIterator();
		Double sum = 0.00;
		while (i.hasNext()) {
			MyEdge edge = (MyEdge) i.next();
			sum += edge.getWeight2();

		}
		// print the sum of all the edge weights = cost.
		System.out.print("\nCost of shortest path = " + sum);
	}

	/**
	 * Creates a simpleDirectedWeightedGraph with all the vertexes specified by
	 * CW 2 and adds them to the graph. Then adds all the connections
	 * (bidirectional) indicated by the course work and uses the weight of the
	 * edge as the price.
	 * 
	 * @return SimpleDirectedWeightedGraph<String, MyEdge> named flightGraph.
	 */

	private static SimpleDirectedWeightedGraph<String, MyEdge> createFlightGraph() {

		SimpleDirectedWeightedGraph<String, MyEdge> flightGraph = new SimpleDirectedWeightedGraph<>(MyEdge.class);

		// Adds all the airports as vertexes in the graph
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

		// Adds pairs of destinations

		MyEdge e = new MyEdge();

		e = flightGraph.addEdge("Edinburgh", "Heathrow");
		flightGraph.setEdgeWeight(e, 80.00);
		e = flightGraph.addEdge("Heathrow", "Edinburgh");
		flightGraph.setEdgeWeight(e, 80.00);

		e = flightGraph.addEdge("Heathrow", "Dubai");
		flightGraph.setEdgeWeight(e, 130.00);
		e = flightGraph.addEdge("Dubai", "Heathrow");
		flightGraph.setEdgeWeight(e, 130.00);

		e = flightGraph.addEdge("Heathrow", "Sydney");
		flightGraph.setEdgeWeight(e, 570.00);
		e = flightGraph.addEdge("Sydney", "Heathrow");
		flightGraph.setEdgeWeight(e, 570.00);

		e = flightGraph.addEdge("Dubai", "Kuala Lumpur");
		flightGraph.setEdgeWeight(e, 170.00);
		e = flightGraph.addEdge("Kuala Lumpur", "Dubai");
		flightGraph.setEdgeWeight(e, 170.00);

		e = flightGraph.addEdge("Dubai", "Edinburgh");
		flightGraph.setEdgeWeight(e, 190.00);
		e = flightGraph.addEdge("Edinburgh", "Dubai");
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

		// Returns the Graph
		return flightGraph;

	}

}
