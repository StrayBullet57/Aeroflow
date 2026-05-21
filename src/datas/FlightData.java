package datas;

import java.util.ArrayList;
import java.util.List;
import models.*;

public class FlightData {

    // FIX: Completely parameter-free method signature
    public static List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<>();

        // 1. Fetch data directly from your static data sources internally
        List<Airline> airlineList = AirlineData.getAirlines();  
        List<Route> routeList = RouteData.getRoutes(); // Assumes you have a RouteData class structured like AirlineData

        // Safety check to ensure data sources aren't empty
        if (airlineList == null || airlineList.isEmpty() || routeList == null || routeList.isEmpty()) {
            return flights;
        }

        // 2. Grab the specific airline object safely using its unique identifier code
        Airline cebuPacific = findAirlineByID(airlineList, "CP00");
        
        // Fallback: If "CP00" target search fails, fall back safely to the initial element
        if (cebuPacific == null) {
            cebuPacific = airlineList.get(0);
        }

        // 3. Grab the active route structural data mapping
        Route routeSX0 = routeList.get(0);

        // 4. Create your supporting calendar objects
        FlightSchedule schedule1 = new FlightSchedule("07/05/2026", "08:00 AM", "07/05/2026", "10:30 AM");

        // 5. Build your flight object using your components
        Flight cp01 = new Flight("CP01", cebuPacific, routeSX0, "Onboarding", schedule1);
        
        flights.add(cp01);
        return flights;
    }

    // FIX: Cleaned up logic parameters to search accurately by ID string fields
    private static Airline findAirlineByID(List<Airline> list, String airlineID) {
        if (list == null || airlineID == null) return null;
        
        for (Airline airline : list) {
            // NOTE: Ensure your Airline model contains the 'getAirlineID()' getter method
            if (airline.getAirlineID().equalsIgnoreCase(airlineID)) {
                return airline;
            }
        }
        return null;
    }
}