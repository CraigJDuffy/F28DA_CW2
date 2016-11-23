package CW2;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class PartF {

	/*
	 * Part F: Extensions
	 *
	 * This class performs the actions associated with part D of the course
	 * work.
	 *
	 * Attempted extensions being:
	 *
	 * 2. (Started) 3. (Did not start as I could not get 2 and it would be an
	 * easy implementation from a working 2). 4. (Did not Start).
	 *
	 */

	/*
	 * The main method creates a simpleDirectedWeightedGraph: flightGraph.
	 * Outputs a list of airports to the user. Takes in user input of start and
	 * end destination.
	 *
	 * Calculates the shortest path.
	 *
	 * Prints out the itinerary.
	 *
	 *
	 * Again, this absolutely should be refactored into separate methods.
	 *
	 * NB. Same as part D & E in code just attempts to determine if the flight
	 * lasted longer than one day and account for that.
	 */
	public static void main(String[] args) {

		final int globalArrivalTime = 0; // to keep track of flight arival times.

		// Create the graph
		final SimpleDirectedWeightedGraph<String, Flight> flightGraph = createFlightGraph();

		// Print out list of airports
		System.out.print("The following airports are used: \n");
		System.out.println(flightGraph.vertexSet().toString());

		// Start Taking user input
		final Scanner scanner = new Scanner(System.in);
		System.out.print("\nPlease enter start airport: ");

		final String startVertex = scanner.nextLine().toLowerCase();
		System.out.print("\nPlease enter the destination airport: ");

		final String destinationVertex = scanner.nextLine().toLowerCase();
		scanner.close();

		// Finish Taking user input.

		// Find the shortest path.
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final
		DijkstraShortestPath d = new DijkstraShortestPath(flightGraph, startVertex, destinationVertex);
		@SuppressWarnings("rawtypes")
		Iterator path = null;

		// Store shortest Path.
		final List<Flight> foundPath = DijkstraShortestPath.findPathBetween(flightGraph, startVertex, destinationVertex);
		if (foundPath != null) {

			// Create array of flight objects so that I can call getX methods on
			// them for itinerary details.
			path = d.getPathEdgeList().iterator();
			int flightArrayCounter = 0;
			final Flight[] flightArray = new Flight[foundPath.size()];

			while (path.hasNext()) {
				final Flight flight = (Flight) path.next();
				flightArray[flightArrayCounter] = flight;
				flightArrayCounter++;
			}

			// Begin printing formated Itinerary (buffer values are arbitrary
			// based on what looked quite nice).
			System.out.println("Itinerary for: " + startVertex + " to: " + destinationVertex);
			System.out.println();
			System.out.format("%-5s %-5s %-12s %-12s %-16s %-12s", "Leg", "Leave", "At", "On", "Arrive", "At");
			System.out.println();

			for (int i = 0; i < flightArray.length; i++) {
				System.out.format("%-5s %-5s %-12s %-12s %-16s %-12s", String.valueOf(i),
						String.valueOf(flightArray[i].getDepartureTime()), flightArray[i].getDeparture(),
						String.valueOf(flightArray[i].getFlightNumber()), flightArray[i].getDestination(),
						String.valueOf(flightArray[i].getArrivalTime()));

				System.out.println();
			}
		}

		if (foundPath != null) {
			// Start calculating journey cost and time in air.
			final ListIterator<Flight> i = DijkstraShortestPath.findPathBetween(flightGraph, startVertex, destinationVertex)
					.listIterator();
			double sum = 0.00;
			int time = 0;
			while (i.hasNext()) {
				final Flight flight = i.next();
				sum += flight.getTicketPrice();
				time += flight.getFlightDuration();

				// begin F extension 2.

				/*
				 * if arrival time - departureTime is less than zero then the
				 * arrival time must be less than the departure time ergo, it
				 * must have passed midnight. Would break for flights longer
				 * than 24 hours but as no direct flight realistically could be
				 * it's okay./*
				 */

				if (Integer.parseInt(flight.getArrivalTime()) - Integer.parseInt(flight.getDepartureTime()) > 0) {
					@SuppressWarnings("unused")
					int layoverTime = Integer.parseInt(flight.getDepartureTime()) - globalArrivalTime;
					/*
					 * Attempts to calculate the difference in time between the
					 * departure of the next flight and the arrival of the last.
					 * Hence, layover time.
					 */

				}
			}

			System.out.println("\nTotal Journey Cost = " + sum);
			System.out.println("Time in air was: " + time / 60 + " Hours " + time % 60 + " Mins ");
		} else {
			System.out.println("No Path Found");
			System.exit(0);
		}
	}

	// Finish printing itinerary.

	/**
	 * Creates a simpleDirectedWeightedGraph with all the vertexes specified by
	 * CW 2 and adds them to the graph. Then adds all the connections
	 * (bidirectional) indicated by the course work and uses a Flight object as
	 * the edge. This holds all the information about the flight and you can
	 * obtain this using get methods.
	 *
	 * @return SimpleDirectedWeightedGraph<String, Flight> named flightGraph.
	 */

	private static SimpleDirectedWeightedGraph<String, Flight> createFlightGraph() {

		// Create the graph.
		final SimpleDirectedWeightedGraph<String, Flight> flightGraph = new SimpleDirectedWeightedGraph<>(Flight.class);

		// Create a string array of airports
		final String[] airports = new String[] { "auckland", "dubai", "edinburgh", "frankfurt", "heathrow",
				"kuala lumpur", "new york", "rio de janeiro", "santiago", "sydney" };

		for (final String airport : airports)
			flightGraph.addVertex(airport.toLowerCase());

		// String start [] = {"edinburgh", "heathrow", "heathrow", "dubai",
		// "heathrow", "sydney", "dubai", "kuala lumpur",
		// "dubai", "edinburgh", "kuala lumpur", "sydney",
		// "edinburgh","frankfurt", "sydney", "auckland", "rio de janeiro",
		// "new york", "new york", "santiago"
		// };
		//
		// for (int i = 0; i < start.length; i++){
		//
		// Flight flight = new Flight();
		//
		// }

		final Flight FL001 = new Flight("edinburgh", "heathrow", "FL001", "0000", 75.00, 80.00, "0115");
		flightGraph.addEdge("edinburgh", "heathrow", FL001);
		flightGraph.addEdge("heathrow", "edinburgh", FL001);

		final Flight FL002 = new Flight("heathrow", "dubai", "FL002", "0100", 240, 130.00, "0500");
		flightGraph.addEdge("heathrow", "dubai", FL002);
		flightGraph.addEdge("dubai", "heathrow", FL002);

		final Flight FL003 = new Flight("heathrow", "sydney", "FL003", "0200", 1440, 570.00, "0200");
		flightGraph.addEdge("heathrow", "sydney", FL003);
		flightGraph.addEdge("sydney", "heathrow", FL003);

		final Flight FL004 = new Flight("dubai", "kuala lumpur", "FL004", "0300", 720, 170.00, "1500");
		flightGraph.addEdge("dubai", "kuala lumpur", FL004);
		flightGraph.addEdge("kuala lumpur", "dubai", FL004);

		final Flight FL005 = new Flight("dubai", "edinburgh", "FL005", "0000", 240, 190.00, "0400");
		flightGraph.addEdge("dubai", "edinburgh", FL005);
		flightGraph.addEdge("edinburgh", "dubai", FL005);

		final Flight FL006 = new Flight("kuala lumpur", "sydney", "FL006", "1230", 240, 150.00, "1630");
		flightGraph.addEdge("kuala lumpur", "sydney", FL006);
		flightGraph.addEdge("sydney", "kuala lumpur", FL006);

		final Flight FL007 = new Flight("edinburgh", "frankfurt", "FL007", "1200", 120, 90.00, "1400");
		flightGraph.addEdge("edinburgh", "frankfurt", FL007);
		flightGraph.addEdge("frankfurt", "edinburgh", FL007);

		final Flight FL008 = new Flight("sydney", "auckland", "FL008", "1330", 360, 120.00, "1930");
		flightGraph.addEdge("sydney", "auckland", FL008);
		flightGraph.addEdge("auckland", "sydney", FL008);

		final Flight FL009 = new Flight("rio de janeiro", "new york", "FL009", "1400", 480, 430.00, "2200");
		flightGraph.addEdge("rio de janeiro", "new york", FL009);
		flightGraph.addEdge("new york", "rio de janeiro", FL009);

		final Flight FL010 = new Flight("new york", "santiago", "FL010", "2200", 300, 320.00, "0300");
		flightGraph.addEdge("new york", "santiago", FL010);
		flightGraph.addEdge("santiago", "new york", FL010);

		// Return graph
		return flightGraph;
	}
}