package datas;

import java.util.ArrayList;
import java.util.List;
import models.Location;

public class LocationData {

    public static List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        Location Cebu = new Location("Cebu", 5,10);
        Location Manila = new Location("Manila", 5,10);
        Location Davao = new Location("Davao",5,10);
        locations.add(Cebu);
        locations.add(Manila);
        locations.add(Davao);

        return locations;
    }
}