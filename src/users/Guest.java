package users;

public class Guest{
    private String sessionID;

    public Guest(String sessionID){
        this.sessionID = sessionID;
    }

    public String getSessionID(){
        return sessionID;
    }

    public void viewFlight(){
        System.out.println("Available Flights:");//Show flights?
    }
    
    public void checkPrice(){
        System.out.println("Flight Prices: ");//Flight prices? could be merged with flights list.
    }
}