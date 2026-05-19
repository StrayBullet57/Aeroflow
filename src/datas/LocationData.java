package models;

import java.util.ArrayList;
import java.util.List;

public class LocationData {

    public static List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        Location Cebu = new Location("Cebu", 5,10);
        Location Manila = new Location("Cebu", 5,10);
        locations.add(Cebu);
        locations.add(Manila);

        return locations;
    }
}