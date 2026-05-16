package models;

public class Seat {

     public enum SeatClass {
            ECONOMY,
            PREMIUM_ECONOMY,
            BUSINESS,
            FIRST_CLASS
        }
    
    private String seatNumber;
    private SeatClass seatClass;
    private boolean isAvailable;

    public Seat(String seatNumber, SeatClass seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.isAvailable = false; // Default to taken, can be set to true when creating seats for a flight
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void bookSeat(){
        isAvailable = false;
    }

    public String getSeatNumber(){
        return seatNumber;
    }

    @Override
    public String toString(){
        return seatNumber + " - " + seatClass + (isAvailable ? " (Available)" : " (Taken)");
    }
}