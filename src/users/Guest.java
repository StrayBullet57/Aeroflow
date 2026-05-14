<<<<<<< HEAD
package users;
=======
package Users;
>>>>>>> 540294a1a4c1be6e868896e36bb9198ac6ef2bd2

public class Guest{
    private String sessionID;

<<<<<<< HEAD
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
=======
    public String getSessionID(){
        return sessionID;
    }
    
    public void viewFlight(){

    }
    public void checkPrice(){

    }

>>>>>>> 540294a1a4c1be6e868896e36bb9198ac6ef2bd2
}