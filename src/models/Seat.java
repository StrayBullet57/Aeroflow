package models;

public class Seat {

     public enum SeatClass {
            ECONOMY,
            PREMIUM_ECONOMY,
            BUSINESS,
            FIRST_CLASS
        }
    
    private int rowNumber;
    private char seatCategory; // A, B, C, H, J, K
    private String seatNumber; // e.g., "12A"
    private SeatClass seatClass;
    private boolean isAvailable;

    // Constructor matching the exact architecture needed for automatic tracking
    public Seat(int rowNumber, char seatCategory, SeatClass seatClass) {
        this.rowNumber = rowNumber;
        this.seatCategory = Character.toUpperCase(seatCategory);
        this.seatNumber = rowNumber + String.valueOf(this.seatCategory);
        this.seatClass = seatClass;
        this.isAvailable = true; // Default to true so passengers can choose it!
    }

public boolean reserveSeat() {
        if (!isAvailable) {
            System.out.println("Seat " + seatNumber + " is already occupied.");
            return false;
        }
        this.isAvailable = false;
        System.out.println("Seat " + seatNumber + " has been successfully reserved.");
        return true;
    }

    public void cancelReservation() {
        if (isAvailable) {
            System.out.println("Seat " + seatNumber + " is already empty.");
            return;
        }
        this.isAvailable = true;
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