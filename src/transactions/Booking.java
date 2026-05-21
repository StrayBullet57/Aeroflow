package transactions;

import java.util.ArrayList;
import models.Flight;
import models.Seat;

public class Booking{
    private String bookingID;
    private Flight flight;
    private Seat seat;
    // private Payment payment;
    private String status;

    private static ArrayList<Booking> bookingHistory = new ArrayList<>();

    // public Booking(String bookingID, Flight flight, Seat seat, Payment payment){
    public Booking(String bookingID, Flight flight, Seat seat){
        this.bookingID = bookingID;
        this.flight = flight;
        this.seat = seat;
        // this.payment = payment;
        this.status = "Pending";
    }

    public void confirmBooking(){
        // if(seat.isAvailable() && payment.processPayment()){
        if(seat.isAvailable()){
            seat.reserveSeat();
            status = "Confirmed";
            bookingHistory.add(this);
            System.out.println("Booking Confirmed.");
        } else{
            status = "Failed";
            System.err.println("Booking Failed.");
        }
    }


    // TO CONSIDER
    
    public static void viewHistory(){
        System.out.println("Booking History");

        for(Booking booking : bookingHistory){
            System.out.println(booking);
            System.out.println();
        }
    }
//comment try try
    @Override
    public String toString(){
        return "Booking ID: " + bookingID + "\nFlight: " + flight.getFlightID() + "\nSeat: " + seat.getSeatNumber() + "\nStatus: " + status;        
    }
}