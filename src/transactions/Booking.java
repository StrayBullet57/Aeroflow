package transactions;

import java.util.ArrayList;
import models.Flight;
import models.Seat;

public class Booking {
    private String bookingID;
    private Flight flight;
    private Seat seat;

    private static ArrayList<Booking> bookingHistory = new ArrayList<>();

    public Booking(String bookingID, Flight flight, Seat seat) {
        this.bookingID = bookingID;
        this.flight = flight;
        this.seat = seat;
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

    public static ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }

    public static void addHistoricalBooking(Booking b) {
        bookingHistory.add(b);
    }

    public static void viewHistory() {
        System.out.println("Booking History");
        for (Booking booking : bookingHistory) {
            System.out.println(booking);
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingID + "\nFlight: " + flight.getFlightID() + "\nSeat: " + seat.getSeatNumber();        
    }
}