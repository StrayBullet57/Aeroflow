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

<<<<<<< HEAD
    @Override
    public String toString(){
        return name + " (" + country + ")";
    }

=======
>>>>>>> 540294a1a4c1be6e868896e36bb9198ac6ef2bd2
}
