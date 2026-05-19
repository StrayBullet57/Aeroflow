package datas;

import java.util.ArrayList;
import java.util.List;
import models.*;

public class AirlineData {

    public static List<Airline> getLocations() {
        List<Airline> airlines = new ArrayList<>();
        Airline CP01 = new Airline("CP01", "Cebu Pacific");
        Airline CP02 = new Airline("CP02", "Cebu Pacific");
        airlines.add(CP01);
        airlines.add(CP02);

        return airlines;
    }
}