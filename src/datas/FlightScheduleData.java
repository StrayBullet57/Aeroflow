package datas;

import java.util.ArrayList;
import java.util.List;

import models.FlightSchedule;

public class FlightScheduleData {

    public static List<FlightSchedule> getFlightSchedules() {
        List<FlightSchedule> schedules = new ArrayList<>();
        FlightSchedule schedule1 = new FlightSchedule("2026-06-02", "06:30 AM", "2026-06-02", "09:15 AM");
        FlightSchedule schedule2 = new FlightSchedule("2026-06-15", "11:00 AM", "2026-06-15", "01:45 PM");
        FlightSchedule schedule3 = new FlightSchedule("2026-07-04", "03:15 PM", "2026-07-04", "05:30 PM");
        FlightSchedule schedule4 = new FlightSchedule("2026-07-22", "08:45 PM", "2026-07-23", "01:15 AM"); // Overnight flight
        FlightSchedule schedule5 = new FlightSchedule("2026-08-11", "10:20 AM", "2026-08-11", "02:10 PM");
                
        schedules.add(schedule1);
        schedules.add(schedule2);
        schedules.add(schedule3);
        schedules.add(schedule4);
        schedules.add(schedule5);
        return schedules;
    }
}