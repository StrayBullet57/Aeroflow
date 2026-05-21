package datas;

import java.util.ArrayList;
import java.util.List;
import models.Location;

public class LocationData {

    public static List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        Location Cebu = new Location("Cebu", 395,420);
        Location Manila = new Location("Manila", 245,230);
        locations.add(Cebu);
        locations.add(Manila);

        return locations;
    }
}