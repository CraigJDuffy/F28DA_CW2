package CW2;

import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class PartC {

	public static void main(String[] args) {
		createFlightGraph();

	}

	private static SimpleDirectedWeightedGraph<String, Flight> createFlightGraph() {

		final SimpleDirectedWeightedGraph<String, Flight> flightGraph = new SimpleDirectedWeightedGraph<>(Flight.class);

		final String[] airports = new String[] { "auckland", "dubai", "edinburgh", "frankfurt", "heathrow",
				"kuala lumpur", "new york", "rio de janeiro", "santiago", "sydney" };

		for (final String airport : airports)
			flightGraph.addVertex(airport.toLowerCase());

		final Flight FL001 = new Flight("FL001", 0000, 1.15, 80.00, 0115);
		flightGraph.addEdge("edinburgh", "heathrow", FL001);
		flightGraph.addEdge("heathrow", "edinburgh", FL001);

		final Flight FL002 = new Flight("FL002", 0100, 4.00, 130.00, 0500);
		flightGraph.addEdge("heathrow", "dubai", FL002);
		flightGraph.addEdge("dubai", "heathrow", FL002);

		final Flight FL003 = new Flight("FL003", 0200, 24.00, 570.00, 0200);
		flightGraph.addEdge("heathrow", "sydney", FL003);
		flightGraph.addEdge("sydney", "heathrow", FL003);

		final Flight FL004 = new Flight("FL004", 0300, 12.00, 170.00, 1500);
		flightGraph.addEdge("dubai", "kuala lumpur", FL004);
		flightGraph.addEdge("kuala lumpur", "dubai", FL004);

		final Flight FL005 = new Flight("FL005", 0000, 4.00, 190.00, 0400);
		flightGraph.addEdge("dubai", "edinburgh", FL005);
		flightGraph.addEdge("edinburgh", "dubai", FL005);

		final Flight FL006 = new Flight("FL006", 1230, 4.00, 150.00, 1630);
		flightGraph.addEdge("kuala lumpur", "sydney", FL006);
		flightGraph.addEdge("sydney", "kuala lumpur", FL006);

		final Flight FL007 = new Flight("FL007", 1200, 2.00, 90.00, 1400);
		flightGraph.addEdge("edinburgh", "frankfurt", FL007);
		flightGraph.addEdge("frankfurt", "edinburgh", FL007);

		final Flight FL008 = new Flight("FL008", 1330, 6.00, 120.00, 1930);
		flightGraph.addEdge("sydney", "auckland", FL008);
		flightGraph.addEdge("auckland", "sydney", FL008);

		final Flight FL009 = new Flight("FL009", 1400, 8.00, 430.00, 2200);
		flightGraph.addEdge("rio de janeiro", "new york", FL009);
		flightGraph.addEdge("new york", "rio de janeiro", FL009);

		final Flight FL010 = new Flight("FL010", 2200, 5.00, 320.00, 0300);
		flightGraph.addEdge("new york", "santiago", FL010);
		flightGraph.addEdge("santiago", "new york", FL010);

		return flightGraph;
	}
}