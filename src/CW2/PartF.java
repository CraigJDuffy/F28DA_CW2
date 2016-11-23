package CW2;

import java.util.Iterator;
import java.util.Scanner;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import CW2.PartB.MyEdge;

public class PartF {

	public static void main(String[] args) {
		int globalArivalTime = 0;
		SimpleDirectedWeightedGraph<String, Flight> flightGraph = createFlightGraph();

		System.out.print("The following airports are used: \n");
		System.out.println(flightGraph.vertexSet().toString());

		Scanner scanner = new Scanner(System.in);
		System.out.print("\nPlease enter start airport: ");

		String startVertex = scanner.nextLine().toLowerCase();
		System.out.print("\nPlease enter the destination airport: ");

		String destinationVertex = scanner.nextLine().toLowerCase();
		scanner.close();

		DijkstraShortestPath d = new DijkstraShortestPath(flightGraph, startVertex, destinationVertex);
		String path = null;
		if (d.findPathBetween(flightGraph, startVertex, destinationVertex) != null) {
			path = d.findPathBetween(flightGraph, startVertex, destinationVertex).toString();
		}

		else {
			System.out.println("No Path Found");
			System.exit(0);
		}
		System.out.print("The shortest (i.e cheapest path) is as follows: " + path);

		Iterator i = d.findPathBetween(flightGraph, startVertex, destinationVertex).listIterator();
		double sum = 0.00;
		int time = 0;
		int layoverTime = 0;
		while (i.hasNext()) {
			Flight flight = (Flight) i.next();
			sum += flight.getTicketPrice();
			time += flight.getFlightDuration();
			if (flight.getArivalTime() - flight.getDepartureTime() > 0) {
				layoverTime += flight.getDepartureTime() - globalArivalTime;

			}
			System.err.println(globalArivalTime);
			globalArivalTime = flight.getArivalTime();

		}

		System.out.println("\nCost of shortest path = " + sum);
		System.out.println("Time in air was: " + time / 60 + " Hours " + time % 60 + " Mins " + layoverTime);

	}

	/**
	 * This method creates a graph; flight graph. This graph contains all the
	 * airports in use my the program and also dictates the Flight Number of
	 * each flight, the departure time of each flight, the duration of each
	 * flight, the cost of each flight, and the arrival time of each flight.
	 * 
	 * The method returns a SimpleDirectedWeightedGraph with nodes of type
	 * String and edges of type Flight. Flight an an object created for the
	 * purposes of this program and is documented in Flight.java.
	 * 
	 * @return
	 */
	private static SimpleDirectedWeightedGraph<String, Flight> createFlightGraph() {

		SimpleDirectedWeightedGraph<String, Flight> flightGraph = new SimpleDirectedWeightedGraph<>(Flight.class);

		String[] airports = new String[] { "auckland", "dubai", "edinburgh", "frankfurt", "heathrow", "kuala lumpur",
				"new york", "rio de janeiro", "santiago", "sydney" };

		//Adds all the vertices (airports) to the graph. 
		for (int i = 0; i < airports.length; i++) {
			flightGraph.addVertex(airports[i].toLowerCase());
		}

		Flight FL001 = new Flight("FL001", 0000, 75, 80.00, 0115);
		flightGraph.addEdge("edinburgh", "heathrow", FL001);
		flightGraph.addEdge("heathrow", "edinburgh", FL001);

		Flight FL002 = new Flight("FL002", 0100, 240, 130.00, 0500);
		flightGraph.addEdge("heathrow", "dubai", FL002);
		flightGraph.addEdge("dubai", "heathrow", FL002);

		Flight FL003 = new Flight("FL003", 0200, 1440, 570.00, 0200);
		flightGraph.addEdge("heathrow", "sydney", FL003);
		flightGraph.addEdge("sydney", "heathrow", FL003);

		Flight FL004 = new Flight("FL004", 0300, 720, 170.00, 1500);
		flightGraph.addEdge("dubai", "kuala lumpur", FL004);
		flightGraph.addEdge("kuala lumpur", "dubai", FL004);

		Flight FL005 = new Flight("FL005", 0000, 240, 190.00, 0400);
		flightGraph.addEdge("dubai", "edinburgh", FL005);
		flightGraph.addEdge("edinburgh", "dubai", FL005);

		Flight FL006 = new Flight("FL006", 1230, 240, 150.00, 1630);
		flightGraph.addEdge("kuala lumpur", "sydney", FL006);
		flightGraph.addEdge("sydney", "kuala lumpur", FL006);

		Flight FL007 = new Flight("FL007", 1200, 120, 90.00, 1400);
		flightGraph.addEdge("edinburgh", "frankfurt", FL007);
		flightGraph.addEdge("frankfurt", "edinburgh", FL007);

		Flight FL008 = new Flight("FL008", 1330, 360, 120.00, 1930);
		flightGraph.addEdge("sydney", "auckland", FL008);
		flightGraph.addEdge("auckland", "sydney", FL008);

		Flight FL009 = new Flight("FL009", 1400, 480, 430.00, 2200);
		flightGraph.addEdge("rio de janeiro", "new york", FL009);
		flightGraph.addEdge("new york", "rio de janeiro", FL009);

		Flight FL010 = new Flight("FL010", 2200, 300, 320.00, 0300);
		flightGraph.addEdge("new york", "santiago", FL010);
		flightGraph.addEdge("santiago", "new york", FL010);

		return flightGraph;
	}
}