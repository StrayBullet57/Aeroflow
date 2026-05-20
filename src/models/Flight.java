package models;
import java.util.ArrayList;

public class Flight{
    private String flightID;
    private Airline airline;
    private Route route; 
    private String status;
    private ArrayList<Seat> seats;
    private FlightSchedule schedule;

    public Flight(String flightID, Airline airline, Route route, String status, FlightSchedule schedule){
        
        this.flightID = flightID;
        this.airline = airline;
        this.route = route;
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
    public void addSeat(Seat seat){
        seats.add(seat);
    }
    public String getFlightID(){
        return flightID;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;;
    }
}