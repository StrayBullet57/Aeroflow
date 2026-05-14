<<<<<<< HEAD
package transactions;

import java.util.ArrayList;
import models.Flight;
import models.Seat;

public class Booking{
    private String bookingID;
    private Flight flight;
    private Seat seat;
    private Payment payment;
    private String status;

    private static ArrayList<Booking> bookingHistory = new ArrayList<>();

    public Booking(String bookingID, Flight flight, Seat seat, Payment payment){
        this.bookingID = bookingID;
        this.flight = flight;
        this.seat = seat;
        this.payment = payment;
        this.status = "Pending";
    }

    public void confirmBooking(){
        if(seat.isAvailable() && payment.processPayment()){
            seat.bookSeat();
            status = "Confirmed";
            bookingHistory.add(this);
            System.out.println("Booking Confirmed.");
        } else{
            status = "Failed";
            System.err.println("Booking Failed.");
        }
    }

    public static void viewHistory(){
        System.out.println("Booking History");

        for(Booking booking : bookingHistory){
            System.out.println(booking);
            System.out.println();
        }
    }

    @Override
    public String toString(){
        return "Booking ID: " + bookingID + "\nFlight: " + flight.getFlightID() + "\nSeat: " + seat.getSeatNumber() + "\nStatus: " + status;
=======
package Transactions;
public class Booking{
    private String bookingID;
    private String bookingDate;
    private String status;
    private Boolean totalPrice;

    public void cancel(){

    }
    
    public void confirm(){
>>>>>>> 540294a1a4c1be6e868896e36bb9198ac6ef2bd2
    }
}