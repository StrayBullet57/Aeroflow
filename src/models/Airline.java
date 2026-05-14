package models;

public class Airline{
    private String airlineID;
    private String name;
    private String country;

    public Airline(String airlineID, String name, String country){
        this.airlineID = airlineID;
        this.name = name;
        this.country = country;
    }

    public String getAirlineID(){
        return airlineID;
    }

    public String getName(){
        return name;
    }

    public String getCountry(){
        return country;
    }

    @Override
    public String toString(){
        return name + " (" + country + ")";
    }

}
