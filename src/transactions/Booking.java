package transactions;

import java.util.ArrayList;
import models.Flight;
import models.Seat;

public class Booking {
    private String bookingID;
    private String userID;     
    private Flight flight;
    private Seat seat;

    private static ArrayList<Booking> bookingHistory = new ArrayList<>();

    public Booking(String bookingID, String userID, Flight flight, Seat seat) { // ADD userID param
        this.bookingID = bookingID;
        this.userID    = userID;  
        this.flight    = flight;
        this.seat      = seat;
    }

    public void confirmBooking() {
        if (seat.isAvailable()) {
            seat.reserveSeat();
            bookingHistory.add(this);
            System.out.println("Booking Confirmed.");
        } else {
            System.err.println("Booking Failed. Seat unavailable.");
        }
    }

    public String getBookingID() { return bookingID; }
    public String getUserID()    { return userID; }   
    public Flight getFlight()    { return flight; }
    public Seat getSeat()        { return seat; }

    public static ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }

    public static ArrayList<Booking> getBookingsByUser(String userID) { 
        ArrayList<Booking> result = new ArrayList<>();
        for (Booking b : bookingHistory) {
            if (b.userID.equals(userID)) {
                result.add(b);
            }
        }
        return result;
    }

    public static void addHistoricalBooking(Booking b) {
        bookingHistory.add(b);
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingID + "\nFlight: " + flight.getFlightID() + "\nSeat: " + seat.getSeatNumber();
    }
}