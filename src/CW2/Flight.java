package CW2;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Flight extends DefaultWeightedEdge {
	
	private String departure; 
	private String destination;
	private String flightNumber;
	private int departureTime;
	private double flightDuration;
	private double ticketPrice;
	private int arivalTime;
	
	public Flight(){ 
		
	}

	public Flight(String departure, String destination, String flightNumber,
			int departureTime, double flightDuration, double ticketPrice,
			int arivalTime) {

		super();
		this.departure = departure.toLowerCase();
		this.destination = destination.toLowerCase();
		this.flightNumber = flightNumber.toUpperCase();
		this.departureTime = departureTime;
		this.arivalTime = arivalTime;
		this.flightDuration = flightDuration;
		this.ticketPrice = ticketPrice;
	}

	public double getFlightDuration() {
		return flightDuration;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public int getDepartureTime() {
		return departureTime;
	}
	
	public String getDestination(){ 
		return destination; 
	}
	
	public String getDeparture(){ 
		return departure;
	}
	
	/**
	 * Returns the arrival time of the current flight as 
	 * a four digit integer. E.g. If your arrival time was
	 * 2am, this will return 0200.
	 * @return
	 */
	public int getArivalTime(){
		return arivalTime;
	}
	
	public String getFlightNumber(){
		return flightNumber;
	}
}

