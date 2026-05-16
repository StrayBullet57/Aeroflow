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

public boolean reserveSeat() {
        if (isAvailable) {
            System.out.println("Seat " + seatNumber + " is already occupied.");
            return false;
        }
        this.isAvailable = true;
        System.out.println("Seat " + seatNumber + " has been successfully reserved.");
        return true;
    }

    public void cancelReservation() {
        if (!isAvailable) {
            System.out.println("Seat " + seatNumber + " is already empty.");
            return;
        }
        this.isAvailable = false;
        System.out.println("Reservation for seat " + seatNumber + " has been cancelled.");
    }


    public String getSeatNumber(){
        return seatNumber;
    }

    public SeatClass getSeatClass(){
        return seatClass;
    }
    public void setSeatClass(SeatClass seatClass){
        this.seatClass = seatClass;
    }

    public boolean isAvailable(){
        return isAvailable; 
    }

    @Override
    public String toString(){
        return seatNumber + " - " + seatClass + (isAvailable ? " (Available)" : " (Taken)");
    }
}