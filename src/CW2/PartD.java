package CW2;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import CW2.PartB.MyEdge;

public class PartD {

	public static void main(String[] args) {
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
		Iterator path = null; 
		if ( d.findPathBetween(flightGraph, startVertex, destinationVertex)!= null){
			path =d.getPathEdgeList().iterator();
			int flightArrayCounter = 0;
			Flight[] flightArray = null;
			while(path.hasNext()){ 
				path.next();
			    flightArrayCounter++;
				Flight flight = (Flight)path.next();
				flightArray[flightArrayCounter] = flight;
			}
			
			System.out.println("Itinerary for: " + startVertex + " to: " + destinationVertex);
			System.out.println();
			System.out.format("%s %s %s %s %s %s",  "Leg","Leave", "At", "On", "Arrive", "At" );
			for (int i1 = 0; i1 < d.findPathBetween(flightGraph, startVertex, destinationVertex).size(); i1++){ 
				String s = (String) String.valueOf(i1) + String.valueOf(flightArray[i1].getDepartureTime()) + String.valueOf(flightArray[i1].getFlightNumber()) + String.valueOf(flightArray[i1].getArivalTime());
				System.out.format("%-1i %-15s %-4i %-5s %-15s %-4i", s);
				System.out.println();
			}
		
			for (int i1 = 0; i1 < d.findPathBetween(flightGraph, startVertex, destinationVertex).size(); i1++){ 
				System.out.format("%-1i %-15s %-4i %-5s %-15s %-4i", 1, "edinburgh", 0530, "FZ002", "Sydney", 1100);
				System.out.println();
				i1++;
		
		}}
		
		else{ 
			System.out.println("No Path Found");
			System.exit(0);
		}
		System.out.print("The shortest (i.e cheapest path) is as follows: " + path);
		
		Iterator i = d.findPathBetween(flightGraph, startVertex, destinationVertex).listIterator();
		double sum = 0.00;
		while(i.hasNext()){
			Flight flight = (Flight)i.next();
			sum += flight.getTicketPrice();
		}		
		
		System.out.print("\nCost of shortest path = " + sum );

	}

	private static SimpleDirectedWeightedGraph<String, Flight> createFlightGraph() {

		SimpleDirectedWeightedGraph<String, Flight> flightGraph = new SimpleDirectedWeightedGraph<>(
				Flight.class);
		
		String[] airports = new String[] {"auckland", "dubai", "edinburgh", "frankfurt", "heathrow", "kuala lumpur",
				"new york", "rio de janeiro", "santiago", "sydney"} ;
		
		for(int i = 0; i < airports.length; i++){ 
			flightGraph.addVertex(airports[i].toLowerCase());
		}
		
			Flight FL001 = new Flight("FL001", 0000, 1.15, 80.00, 0115);
			flightGraph.addEdge("edinburgh", "heathrow", FL001);
			flightGraph.addEdge("heathrow", "edinburgh", FL001);
			
			Flight FL002 = new Flight("FL002", 0100, 4.00, 130.00, 0500);
			flightGraph.addEdge("heathrow", "dubai", FL002);
			flightGraph.addEdge("dubai", "heathrow", FL002);
			
			Flight FL003 = new Flight("FL003", 0200, 24.00, 570.00, 0200);
			flightGraph.addEdge("heathrow", "sydney", FL003);
			flightGraph.addEdge("sydney", "heathrow", FL003);
			
			Flight FL004 = new Flight("FL004", 0300, 12.00, 170.00, 1500);
			flightGraph.addEdge("dubai", "kuala lumpur", FL004);
			flightGraph.addEdge("kuala lumpur", "dubai", FL004);
			
			Flight FL005 = new Flight("FL005", 0000, 4.00, 190.00, 0400);
			flightGraph.addEdge("dubai", "edinburgh", FL005);
			flightGraph.addEdge("edinburgh", "dubai", FL005);
			
			Flight FL006 = new Flight("FL006", 1230, 4.00, 150.00, 1630);
			flightGraph.addEdge("kuala lumpur", "sydney", FL006);
			flightGraph.addEdge("sydney", "kuala lumpur", FL006);
			
			Flight FL007 = new Flight("FL007", 1200, 2.00,90.00, 1400);
			flightGraph.addEdge("edinburgh", "frankfurt", FL007);
			flightGraph.addEdge("frankfurt", "edinburgh", FL007);
			
			Flight FL008 = new Flight("FL008", 1330, 6.00, 120.00, 1930);
			flightGraph.addEdge("sydney", "auckland", FL008);
			flightGraph.addEdge("auckland", "sydney", FL008);
			
			Flight FL009 = new Flight("FL009", 1400, 8.00, 430.00, 2200);
			flightGraph.addEdge("rio de janeiro", "new york", FL009);
			flightGraph.addEdge("new york", "rio de janeiro", FL009);
			
			Flight FL010 = new Flight("FL010", 2200, 5.00, 320.00, 0300);
			flightGraph.addEdge("new york", "santiago", FL010);
			flightGraph.addEdge("santiago", "new york", FL010);
		
		return flightGraph;
	}
}