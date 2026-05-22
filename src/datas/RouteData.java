package datas;

import java.util.ArrayList;
import java.util.List;
import models.Location;
import models.Route; 

public class RouteData {

    public static List<Route> getRoutes() {
        List<Route> routes = new ArrayList<>();

        List<Location> locations = LocationData.getLocations();

        Location cebu = findLocationByName(locations, "Cebu");
        Location manila = findLocationByName(locations, "Manila");
        Location davao = findLocationByName(locations, "Davao");

        Route SX0 = new Route("SX0", cebu, manila, 0.006);
        Route SX1 = new Route("SX1", manila, cebu, 8);
        Route SX2 = new Route("SX2", cebu, davao, 5.5);
        Route SX3 = new Route("SX3", davao, cebu, 5.5);
        Route SX4 = new Route("SX4", manila, davao, 12.0);
        Route SX5 = new Route("SX5", davao, manila, 12.0);

        routes.add(SX0);
        routes.add(SX1); 
        routes.add(SX2);
        routes.add(SX3);
        routes.add(SX4);
        routes.add(SX5);

        return routes;
    }

    private static Location findLocationByName(List<Location> list, String name) {
        for (Location loc : list) {
            if (loc.getLocationName().equalsIgnoreCase(name)) {
                return loc;
            }
        }
        return null;
    }
}