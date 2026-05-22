package models;

public class Location {
    
    private String locationName;
    private int xCoordinate;
    private int yCoordinate;
    
    //Empty constructor
    public Location() {
    }

    //Constructor with parameters
    public Location(String locationName, int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.locationName = locationName;
    }

    //Encapsulation
    public String getLocationName(){
        return locationName;
    }
    public void setLocationName(String locationName){
        this.locationName = locationName;
    }
    public int getXCoordinate() {
        return xCoordinate;
    }
    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
    public int getYCoordinate() {
        return yCoordinate;
    }
    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}