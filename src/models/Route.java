package models;

public class Route{
    private String routeID;
    private Location origin;
    private Location destination;
    private int duration;

    public Route(String routeID, Location origin, Location destination, int duration){
        this.routeID = routeID;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
    }

    public String getRouteID(){
        return routeID;
    }

    public Location getOrigin(){
        return origin;
    }

    public Location getDestination(){
        return destination;
    }

    public int getDuration(){
        return duration;
    }

    public void select(){

    }

    @Override
    public String toString(){
        return origin + " -> " + destination +
               " (" + duration + " mins)";
    }
}
