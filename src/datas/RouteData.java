package datas;

import java.util.ArrayList;
import java.util.List;
import datas.LocationData;
import models.*;
import models.Location;
import models.Route; 

public class RouteData {

    public static List<Route> getRoutes() {
        List<Route> routes = new ArrayList<>();

        List<Location> locations = LocationData.getLocations();

        Location cebu = findLocationByName(locations, "Cebu");
        Location manila = findLocationByName(locations, "Manila");
        Route SX0 = new Route("SX0", cebu, manila, 0.005);
        Route SX1 = new Route("SX1", manila, cebu, 8);
            routes.add(SX0);
            routes.add(SX1); 

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