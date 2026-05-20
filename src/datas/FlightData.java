package datas;

import java.util.ArrayList;
import java.util.List;
import models.*;

public class FlightData {

    // 1. Rename to getFlights and remove the parameter restrictions
    public static List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<>();
        
        // 2. Fetch the required data directly from your other data files
        List<Airline> airlineList = AirlineData.getAirlines(); // Make sure this matches your Airline data class name!
        List<Route> routeList = RouteData.getRoutes();

        // AIRLINE
        Airline CP0 = airlineList.get(0);  

        // ROUTE
        Route SX0 = routeList.get(0);
        FlightSchedule schedule1 = new FlightSchedule("2026-05-20", "08:00 AM", "2026-05-20", "10:00 AM");
       
        //datas
       
        Flight cp0 = new Flight("CP0", CP0, SX0, "Onboarding", schedule1);
        
        flights.add(cp0);
        return flights;
    }
}