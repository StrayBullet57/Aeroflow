package models;

public class Seat {

     public enum SeatClass {
            ECONOMY,
            PREMIUM_ECONOMY,
            BUSINESS,
            FIRST_CLASS
        }
    
    private String seatID;
    private String seatNumber;
    private String seatClass;
    private boolean isAvailable;

    public Seat(String seatID, String seatNumber, String seatClass) {
        this.seatID = seatID;
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.isAvailable = true;
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