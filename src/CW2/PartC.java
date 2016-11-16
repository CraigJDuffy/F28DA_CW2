package CW2;

import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class PartC {

	public static void main(String[] args) {
		SimpleDirectedWeightedGraph<String, Flight> flightGraph = createFlightGraph();

	}

	private static SimpleDirectedWeightedGraph<String, Flight> createFlightGraph() {

		SimpleDirectedWeightedGraph<String, Flight> flightGraph = new SimpleDirectedWeightedGraph<>(
				Flight.class);
		
		String[] airports = new String[] {"Auckland", "Dubai", "Edinburgh", "Frankfurt", "Heathrow", "Kuala Lumpur",
				"New York", "Rio de Janeiro", "Santiago", "Sydney"} ;
		
		for(int i = 0; i < airports.length; i++){ 
			flightGraph.addVertex(airports[i]);
		}
		
		    return flightGraph;
		}

	}
