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

            routes.add(new Route("SX1", cebu, manila,3));
            
            routes.add(new Route("SX2", manila, cebu,8)); 

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