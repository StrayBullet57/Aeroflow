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
        this.flightID = flightID;
        this.airline = airline;
        this.route = route;
        this.price = price;
        this.status = status;
    }
    
    public String getFlightID(){
        return flightID;
    }

    public Double getPrice(){
        return price;
    }

    public String getStatus(){
        return status;
    }

}
