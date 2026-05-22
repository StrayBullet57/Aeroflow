package users;

public class Guest extends User implements Authenticatable{
    private String sessionID;

    public Guest(String sessionID){
        super(sessionID, "Guest Traveler", "guest@system.com", "N/A", "N/A");
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

    @Override
    public void performAction() {
        System.out.println("Guest user with Session ID " + sessionID + " is browsing flights.");
    }
}