package models;

public class Location {
    
    private String xCoordinate;
    private String yCoordinate;

    // Default Constructor
    public Location() {
    }

    // Parameterized Constructor
    public Location(String xCoordinate, String yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    // Getter and Setter for xCoordinate
    public String getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(String xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    // Getter and Setter for yCoordinate
    public String getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(String yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}