package models;

public class Seat {

    private int rowNumber; //1, 2, 3
    private char seatCategory; //A, B, C, D or column
    private String seatNumber; //1A, 1B
    private String seatClass; //Economy, Business, First Class
    private boolean isAvailable; //set this to true(empty or walay sulod)


    //Constructor
    public Seat(int rowNumber, char seatCategory, String seatClass) {
        this.rowNumber = rowNumber;
        this.seatCategory = Character.toUpperCase(seatCategory);
        this.seatNumber = rowNumber + String.valueOf(this.seatCategory);
        this.seatClass = seatClass; 
        this.isAvailable = true;
    }


    //Methods
    public boolean reserveSeat() {
        if (!isAvailable) {
            System.out.println("Seat " + seatNumber + " is already occupied."); //Seat is already taken
            return false;
        }
        this.isAvailable = false;
        System.out.println("Seat " + seatNumber + " has been successfully reserved."); // Booking successful
        return true;
    }


    public void cancelReservation() {
        if (isAvailable) {
            System.out.println("Seat " + seatNumber + " is already empty."); //seat is already empty, there is nothing to cancel here
            return;
        }
        this.isAvailable = true;
        System.out.println("Reservation for seat " + seatNumber + " has been cancelled."); //If you have already a seat(!available), change its status back to true to  become empty again.
    }

    public int getRowNumber()    { return rowNumber; }
    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
        this.seatNumber = this.rowNumber + String.valueOf(this.seatCategory);
    }

    public char getSeatCategory() { return seatCategory; }
    public void setSeatCategory(char seatCategory) {
        this.seatCategory = Character.toUpperCase(seatCategory);
        this.seatNumber = this.rowNumber + String.valueOf(this.seatCategory);
    }

    public String getSeatNumber()  { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public String getSeatClass()   { return seatClass; } 
    public void setSeatClass(String seatClass) { this.seatClass = seatClass; } 

    public boolean isAvailable()   { return isAvailable; }
    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }
}