package models;
import java.util.ArrayList;

public class Flight{
    private String flightID; // unique identifier
    private Airline airline; // stores airline id, airline name
    private Route route;  // stores origin,destination. } Locations (stores coordinates)
    private String status; // basta status 
    private ArrayList<Seat> seats; // 
    private FlightSchedule schedule; //schedule sa flight

    //Constructor
    public Flight(String flightID, Airline airline, Route route, String status, FlightSchedule schedule){
        
        this.flightID = flightID;
        this.airline = airline;
        this.route = route;
        this.status = status;
        this.schedule = schedule;
        this.seats = new ArrayList<>();

        initializeAircraftSeats();
    }

    //Logic for seats
    private void initializeAircraftSeats() {
        char[] columns = {'A', 'B', 'C', 'H', 'J', 'K'};

        for (int row = 1; row <= 4; row++) {
            for (char col : columns) {
                seats.add(new Seat(row, col, "FIRST CLASS"));
            }
        }
        for (int row = 2; row <= 5; row++) {
            for (char col : columns) {
                seats.add(new Seat(row, col, "BUSINESS CLASS"));
            }
        }
        for (int row = 10; row <= 21; row++) {
            for (char col : columns) {
                seats.add(new Seat(row, col, "ECONOMY CLASS"));
            }
        }
    }

    //Encapsulation
    public int getFreeSeatsCount() {
        int count = 0;
        for (Seat s : seats) {
            if (s.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    public int getOccupiedSeatsCount() {
        int count = 0;
        for (Seat s : seats) {
            if (!s.isAvailable()) {
                count++;
            }
        }
        return count;
    }
    
    public ArrayList<Seat> getSeats(){
        return seats;
    }
    public String getFlightID(){
        return flightID;
    }
    public String getStatus(){
        return status;
    }
    public Route getRoute(){
        return route;
    }
    public Airline getAirline(){
        return airline;
    }
    public FlightSchedule getSchedule(){
        return schedule;
    }
    public void addSeat(Seat seat){
        seats.add(seat);
    }
    public void setStatus(String status){
        this.status = status;;
    }
}