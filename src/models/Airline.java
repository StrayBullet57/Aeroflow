package models;

public class Airline{
    private String airlineID;
    private String name;

    //Constructor
    public Airline(String airlineID, String name){
        this.airlineID = airlineID;
        this.name = name;
    }

    //Encapsulation
    public String getAirlineID(){
        return airlineID;
    }
    public String getName(){
        return name;
    }
}