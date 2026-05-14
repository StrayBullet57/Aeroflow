<<<<<<< HEAD
package models;
import java.util.ArrayList;

public class Flight{
    private String flightID;
    private Airline airline;
    private Route route;
    private double price;
    private String status;
    private ArrayList<Seat> seats;

    public Flight(String flightID, Airline airline, Route route, double price, String status){
=======
//flightID: String
//airline: String
//origin: String
//destination: String
//price: Double
//status: String
package models;

public class Flight{
    private String flightID = "123abc";
    private Airline airline;
    private Route route;
    private Double price;
    private String status;

    public Flight(String flightID, Airline airline, Route route, Double price, String status){
>>>>>>> 540294a1a4c1be6e868896e36bb9198ac6ef2bd2
        this.flightID = flightID;
        this.airline = airline;
        this.route = route;
        this.price = price;
        this.status = status;
<<<<<<< HEAD
        this.seats = new ArrayList<>();
    }
    
    public ArrayList<Seat> getSeats(){
        return seats;
    }

    public void addSeat(Seat seat){
        seats.add(seat);
    }

=======
    }
    
>>>>>>> 540294a1a4c1be6e868896e36bb9198ac6ef2bd2
    public String getFlightID(){
        return flightID;
    }

<<<<<<< HEAD
    public double getPrice(){
=======
    public Double getPrice(){
>>>>>>> 540294a1a4c1be6e868896e36bb9198ac6ef2bd2
        return price;
    }

    public String getStatus(){
        return status;
    }
<<<<<<< HEAD
    @Override
    public String toString(){
        return "Flight: " + flightID + "\nAirline: " + airline + "\nRoute: " + route + "\nPrice: " + price + "\nStatus: " + status;
    }
}
=======

}
>>>>>>> 540294a1a4c1be6e868896e36bb9198ac6ef2bd2
