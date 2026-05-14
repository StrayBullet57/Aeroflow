package models;

public class Route{
    private String routeID;
    private String origin;
    private String destination;
    private int duration;

    public Route(String routeID, String origin, String destination, int duration){
        this.routeID = routeID;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
    }

    public String getRouteID(){
        return routeID;
    }

    public String getOrigin(){
        return origin;
    }

    public String getDestination(){
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
