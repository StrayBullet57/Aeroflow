package models;

import java.util.ArrayList;
import transactions.Booking;
// import transactions.Payment;

public class FlightBooking{

    private ArrayList<Flight> flights;
    private ArrayList<Booking> bookings;

    public FlightBooking(){ // create arraylist
        flights = new ArrayList<>();
        bookings = new ArrayList<>();
    }
    public void addFlight(Flight flight){// add flight to arraylist
        flights.add(flight);
    }
    public ArrayList<Flight> getFlights(){// return flights, pede magamit sa show flight lists
        return flights;
    }
    public Flight findFlight(String flightID){// find flight loop, katung search flightID na feature
        for (Flight f : flights) {
            if (f.getFlightID().equals(flightID)) {
                return f;
            }
        }
        return null;
    }
    public Booking createBooking(String bookingID, Flight flight, Seat seat, double amount){
        // Payment payment = new Payment("PMNT-" + bookingID, bookingID, amount);// create payment
        // Booking booking = new Booking(bookingID, flight, seat, payment);// create booking
        Booking booking = new Booking(bookingID, flight, seat);// create booking
        bookings.add(booking);// store booking
        return booking;
    }
    public ArrayList<Booking> getBookings(){// return bookings, show all bookings list, para atong booking history na feature.
        return bookings;
    }
}