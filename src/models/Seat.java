package models;

public class Seat {

    
    private int rowNumber;
    private char seatCategory; 
    private String seatNumber; 
    private boolean isAvailable;

   
    public Seat(int rowNumber, char seatCategory, String seatClass) {
        this.rowNumber = rowNumber;
        this.seatCategory = Character.toUpperCase(seatCategory);
        this.seatNumber = rowNumber + String.valueOf(this.seatCategory);
        this.isAvailable = true; 
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

public int getRowNumber() { return rowNumber; }
    public void setRowNumber(int rowNumber) { 
        this.rowNumber = rowNumber; 
        this.seatNumber = this.rowNumber + String.valueOf(this.seatCategory);
    }

    public char getSeatCategory() { return seatCategory; }
    public void setSeatCategory(char seatCategory) { 
        this.seatCategory = Character.toUpperCase(seatCategory);
        this.seatNumber = this.rowNumber + String.valueOf(this.seatCategory);
    }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }

}