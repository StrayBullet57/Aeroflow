package datas;

import java.util.ArrayList;
import java.util.List;
import models.*;

public class FlightData {

    // Pass the existing airline list into this method
    public static List<Flight> getLocations(List<Airline> airlineList, List<Route> routeList) {
        List<Flight> flights = new ArrayList<>();

        // 1. Grab the specific airline you need from the list using its index
        // (e.g., index 0 if Cebu Pacific is the first item in that list)
        Airline CP00 = airlineList.get(0);  // CP00

        // 2. Create your supporting objects
        Route SX0 = routeList.get(0);
        FlightSchedule schedule1 = new FlightSchedule("07/05/2026","08:00 AM","07/05/2026","10:30");

        // 3. Create the flight object using the airline you grabbed
        Flight cp01 = new Flight("CP00", CP00, SX0, "Onboarding", schedule1);
        
        flights.add(cp01);
        return flights;
    }
}