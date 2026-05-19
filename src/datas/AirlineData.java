package datas;

import java.util.ArrayList;
import java.util.List;
import models.*;

public class AirlineData {

    public static List<Airline> getLocations() {
        List<Airline> airlines = new ArrayList<>();
        Airline CP00 = new Airline("CP00", "Cebu Pacific");
        Airline CP01 = new Airline("CP01", "Cebu Pacific");
        airlines.add(CP00);
        airlines.add(CP01);

        return airlines;
    }
}