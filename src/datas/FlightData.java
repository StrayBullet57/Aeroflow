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
        List<FlightSchedule> scheduleList = FlightScheduleData.getFlightSchedules();

        // AIRLINE
        Airline CP0 = airlineList.get(0);  
        Airline CP1 = airlineList.get(1);  
        Airline CP2 = airlineList.get(2);
        Airline CP3 = airlineList.get(3);
        Airline CP4 = airlineList.get(4);

        Airline PA0_air = airlineList.get(5);
        Airline PA1_air = airlineList.get(6);
        Airline PA2_air = airlineList.get(7);
        Airline PA3_air = airlineList.get(8);
        Airline PA4_air = airlineList.get(9);

        Airline AA0_air = airlineList.get(10);
        Airline AA1_air = airlineList.get(11);
        Airline AA2_air = airlineList.get(12);
        Airline AA3_air = airlineList.get(13);
        Airline AA4_air = airlineList.get(14);
        

        // ROUTE
        Route SX0 = routeList.get(0);
        Route SX1 = routeList.get(1);
        Route SX2 = routeList.get(2);
        Route SX3 = routeList.get(3);
        Route SX4 = routeList.get(4);
        Route SX5 = routeList.get(5);

        //Schedules
        
        FlightSchedule schedule1 = scheduleList.get(0);
        FlightSchedule schedule2 = scheduleList.get(1);
        FlightSchedule schedule3 = scheduleList.get(2);
        FlightSchedule schedule4 = scheduleList.get(3);
        FlightSchedule schedule5 = scheduleList.get(4);
        
        //datas
       
        Flight cp0 = new Flight("CP0", CP0, SX0, "Onboarding", schedule1);
        Flight cp1 = new Flight("CP1", CP1, SX1, "Onboarding", schedule2);
        Flight cp2 = new Flight("CP2", CP2, SX2, "Onboarding", schedule3);
        Flight cp3 = new Flight("CP3", CP3, SX3, "Onboarding", schedule4);
        Flight cp4 = new Flight("CP4", CP4, SX0, "Onboarding", schedule5);

        Flight pa0 = new Flight("PA0", PA0_air, SX4, "Onboarding", schedule1);
        Flight pa1 = new Flight("PA1", PA1_air, SX5, "Onboarding", schedule2);
        Flight pa2 = new Flight("PA2", PA2_air, SX1, "Onboarding", schedule3);
        Flight pa3 = new Flight("PA3", PA3_air, SX2, "Onboarding", schedule4);
        Flight pa4 = new Flight("PA4", PA4_air, SX3, "Onboarding", schedule5);

        Flight aa0 = new Flight("AA0", AA0_air, SX0, "Onboarding", schedule1);
        Flight aa1 = new Flight("AA1", AA1_air, SX1, "Onboarding", schedule2);
        Flight aa2 = new Flight("AA2", AA2_air, SX4, "Onboarding", schedule3);
        Flight aa3 = new Flight("AA3", AA3_air, SX5, "Onboarding", schedule4);
        Flight aa4 = new Flight("AA4", AA4_air, SX2, "Onboarding", schedule5);
        
        flights.add(cp0);
        flights.add(cp1);
        flights.add(cp2);
        flights.add(cp3);
        flights.add(cp4);

        flights.add(pa0);
        flights.add(pa1);
        flights.add(pa2);
        flights.add(pa3);
        flights.add(pa4);

        flights.add(aa0);
        flights.add(aa1);
        flights.add(aa2);
        flights.add(aa3);
        flights.add(aa4);


        return flights;
    }
}