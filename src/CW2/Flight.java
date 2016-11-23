package CW2;

import org.jgrapht.graph.DefaultWeightedEdge;

@SuppressWarnings("serial")

/**
 * This class creates a subclass of the DefaultWeightedEdge called Flight. A
 * flight object contains the departure and destination vertex along with the
 * flight number, departure time, arrival time, duration of the flight, and
 * ticket price.
 * 
 * Used in parts D, E, F of the course work.
 * 
 * @author craigjduffy
 *
 */

public class Flight extends DefaultWeightedEdge {

	private String departure;
	private String destination;
	private String flightNumber;
	private String departureTime;
	private double flightDuration;
	private double ticketPrice;
	private String arrivalTime;

	public Flight() {

	}

	public Flight(String departure, String destination, String flightNumber, String departureTime,
			double flightDuration, double ticketPrice, String arivalTime) {

		super();
		this.departure = departure.toLowerCase();
		this.destination = destination.toLowerCase();
		this.flightNumber = flightNumber.toUpperCase();
		this.departureTime = departureTime;
		this.arrivalTime = arivalTime;
		this.flightDuration = flightDuration;
		this.ticketPrice = ticketPrice;
	}

	public double getFlightDuration() {
		return flightDuration;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public String getDeparture() {
		return departure;
	}

	/**
	 * Returns the arrival time of the current flight as a four digit integer.
	 * E.g. If your arrival time was 2am, this will return 0200.
	 * 
	 * @return
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}

	public String getFlightNumber() {
		return flightNumber;
	}
}
