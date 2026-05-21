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
        Airline CP1 = airlineList.get(1);  
        

        // ROUTE
        Route SX0 = routeList.get(0);
        Route SX1 = routeList.get(1);
        FlightSchedule schedule1 = new FlightSchedule("2026-05-20", "08:00 AM", "2026-05-20", "10:00 AM");
       
        //datas
       
        Flight cp0 = new Flight("CP0", CP0, SX0, "Onboarding", schedule1);
        Flight cp1 = new Flight("CP1", CP1, SX1, "Onboarding", schedule1);
        
        flights.add(cp0);
        flights.add(cp1);
        return flights;
    }
}