package models;
import java.util.ArrayList;

public class Flight{
    private String flightID;
    private Airline airline;
    private Route route;
    private double price;
    private String status;
    private ArrayList<Seat> seats;
    private FlightSchedule schedule;

    public Flight(String flightID, Airline airline, Route route, Double price, String status, FlightSchedule schedule){
        
        this.flightID = flightID;
        this.airline = airline;
        this.route = route;
        this.price = price;
        this.status = status;
        this.schedule = schedule;
        this.seats = new ArrayList<>();
    }
    
    public ArrayList<Seat> getSeats(){
        return seats;
    }

    public void addSeat(Seat seat){
        seats.add(seat);
    }

    
    public String getFlightID(){
        return flightID;
    }

    public double getPrice(){
        return price;
    }

    public String getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return "Flight: " + flightID + "\nAirline: " + airline + "\nRoute: " + route + "\nPrice: " + price + "\nStatus: " + status;
}
}