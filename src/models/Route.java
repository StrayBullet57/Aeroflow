package models;

public class Route{
    private String routeID; // make ups / to implement
    private Location origin; // done
    private Location destination; // done
    private double duration; // make up // should be per hour!!!


    //Constructor
    public Route(String routeID, Location origin, Location destination, double duration){
        this.routeID = routeID;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
    }

    //Encapsulation
    public String getRouteID(){
        return routeID;
    }
    public Location getOrigin(){
        return origin;
    }
    public Location getDestination(){
        return destination;
    }
    public double getDuration(){
        return duration;
    }
    @Override
    public String toString(){
        return origin + " -> " + destination + " (" + duration + " hour/s)";
    }
}