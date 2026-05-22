package datas;

import java.util.ArrayList;
import java.util.List;
import models.*;

public class AirlineData {

    public static List<Airline> getAirlines() {
        List<Airline> airlines = new ArrayList<>();

        //Cebu Pacific (CP00 - CP04)
        Airline CP00 = new Airline("CP00", "Cebu Pacific");
        Airline CP01 = new Airline("CP01", "Cebu Pacific");
        Airline CP02 = new Airline("CP02", "Cebu Pacific");
        Airline CP03 = new Airline("CP03", "Cebu Pacific");
        Airline CP04 = new Airline("CP04", "Cebu Pacific");
        airlines.add(CP00);
        airlines.add(CP01);
        airlines.add(CP02);
        airlines.add(CP03);
        airlines.add(CP04);
       
        //Philippine Airline (PA00 - PA04)
        Airline PA00 = new Airline("PA00", "Philippine Airline");
        Airline PA01 = new Airline("PA01", "Philippine Airline");
        Airline PA02 = new Airline("PA02", "Philippine Airline");
        Airline PA03 = new Airline("PA03", "Philippine Airline");
        Airline PA04 = new Airline("PA04", "Philippine Airline");
        airlines.add(PA00);
        airlines.add(PA01);
        airlines.add(PA02);
        airlines.add(PA03);
        airlines.add(PA04);

        //Air Asia (AA00 - AA04)
        Airline AA00 = new Airline("AA00", "Air Asia");
        Airline AA01 = new Airline("AA01", "Air Asia");
        Airline AA02 = new Airline("AA02", "Air Asia");
        Airline AA03 = new Airline("AA03", "Air Asia");
        Airline AA04 = new Airline("AA04", "Air Asia");
        airlines.add(AA00);
        airlines.add(AA01);
        airlines.add(AA02);
        airlines.add(AA03);
        airlines.add(AA04);
        
        return airlines;
    }
}