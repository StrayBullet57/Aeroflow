package datas;

import java.util.ArrayList;
import java.util.List;
import models.*;

public class FlightData {

    public static List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<>();
        
        List<Airline> airlineList = AirlineData.getAirlines(); 
        List<Route> routeList = RouteData.getRoutes();

        // OBTAIN AIRLINE DATA
        Airline CP0 = airlineList.get(0);  
        Airline CP1 = airlineList.get(1);  
        

        // OBTAIN ROUTE DATA
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