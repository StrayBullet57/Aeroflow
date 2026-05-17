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

        initializeAircraftSeats();
    }

    private void initializeAircraftSeats() {
        char[] columns = {'A', 'B', 'C', 'H', 'J', 'K'};

        for (int row = 1; row <= 4; row++) {
            for (char col : columns) {
                seats.add(new Seat(row, col, Seat.SeatClass.FIRST_CLASS));
            }
        }

        for (int row = 2; row <= 5; row++) {
            for (char col : columns) {
                seats.add(new Seat(row, col, Seat.SeatClass.BUSINESS));
            }
        }

        for (int row = 10; row <= 21; row++) {
            for (char col : columns) {
                seats.add(new Seat(row, col, Seat.SeatClass.ECONOMY));
            }
        }
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