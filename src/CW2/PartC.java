package CW2;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import CW2.PartAAndPartB.MyEdge;

public class PartC {

	public static class flightGraphEdge extends DefaultWeightedEdge {

		public double getFlightCost() {
			return getWeight();
		}
	}

	public static void main(String[] args) {
		SimpleDirectedWeightedGraph<String, flightGraphEdge> flightGraph = createFlightGraph();

	}

	private static SimpleDirectedWeightedGraph<String, MyEdge> createFlightGraph() {

		SimpleDirectedWeightedGraph<String, MyEdge> flightGraph = new SimpleDirectedWeightedGraph<>(
				MyEdge.class);
		
		String[] airports = new String[] {"Auckland", "Dubai", "Edinburgh", "Frankfurt", "Heathrow", "Kuala Lumpur",
				"New York", "Rio de Janeiro", "Santiago", "Sydney"} ;
		
		for(int i = 0; i < airports.length; i++){ 
			flightGraph.addVertex(airports[i]);
		}
		
		
		
		return flightGraph; 
		
		}

	}
