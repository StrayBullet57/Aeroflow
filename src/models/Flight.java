package models;
import java.util.ArrayList;

public class Flight{
    private String flightID;
    private Airline airline;
    private Route route;
    private double price;
    private String status;
    private ArrayList<Seat> seats;
    private FlightSchedule schedule;

    public Flight(String flightID, Airline airline, Route route, Double price, String status, FlightSchedule schedule){
        
        this.flightID = flightID;
        this.airline = airline;
        this.route = route;
        this.price = price;
        this.status = status;
        this.schedule = schedule;
        this.seats = new ArrayList<>();

        initializeAircraftSeats();
    }

    private void initializeAircraftSeats() {
        char[] columns = {'A', 'B', 'C', 'H', 'J', 'K'};

        for (int row = 1; row <= 4; row++) {
            for (char col : columns) {
                seats.add(new Seat(row, col, Seat.SeatClass.FIRST_CLASS));
            }
        }

        for (int row = 2; row <= 5; row++) {
            for (char col : columns) {
                seats.add(new Seat(row, col, Seat.SeatClass.BUSINESS));
            }
        }

        for (int row = 10; row <= 21; row++) {
            for (char col : columns) {
                seats.add(new Seat(row, col, Seat.SeatClass.ECONOMY));
            }
        }
    }

    public int getFreeSeatsCount() {
        int count = 0;
        for (Seat s : seats) {
            if (s.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    public int getOccupiedSeatsCount() {
        int count = 0;
        for (Seat s : seats) {
            if (!s.isAvailable()) {
                count++;
            }
        }
        return count;
    }
    
    public ArrayList<Seat> getSeats(){
        return seats;
    }

    public void addSeat(Seat seat){
        seats.add(seat);
    }

    
    public String getFlightID(){
        return flightID;
    }

    public double getPrice(){
        return price;
    }

    public String getStatus(){
        return status;
    }

public void startInteractiveSeatSelection() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("\n=============================================");
            System.out.println("          AEROFLOW LIVE SEAT MAP             ");
            System.out.println("        [ ] = Available   [X] = Occupied     ");
            System.out.println("=============================================");
            
            // Print First Class Section
            System.out.println("\n--- FIRST CLASS ---");
            System.out.println("    A   B   C       H   J   K");
            for (int r = 1; r <= 4; r++) {
                System.out.print(r + "  ");
                int colCount = 0;
                for (Seat s : this.seats) {
                    if (s.getRowNumber() == r && s.getSeatClass() == Seat.SeatClass.FIRST_CLASS) {
                        System.out.print(s.isAvailable() ? "[ ] " : "[X] ");
                        colCount++;
                        if (colCount == 3) System.out.print("    ");
                    }
                }
                System.out.println();
            }

            // Print Business Class Section
            System.out.println("\n--- BUSINESS CLASS ---");
            System.out.println("    A   B   C       H   J   K");
            for (int r = 2; r <= 5; r++) {
                System.out.print(r + "  ");
                int colCount = 0;
                for (Seat s : this.seats) {
                    if (s.getRowNumber() == r && s.getSeatClass() == Seat.SeatClass.BUSINESS) {
                        System.out.print(s.isAvailable() ? "[ ] " : "[X] ");
                        colCount++;
                        if (colCount == 3) System.out.print("    ");
                    }
                }
                System.out.println();
            }

            // Print Economy Class Section
            System.out.println("\n--- ECONOMY CLASS ---");
            System.out.println("    A   B   C       H   J   K");
            for (int r = 10; r <= 21; r++) {
                System.out.print(r + (r < 10 ? "  " : " "));
                int colCount = 0;
                for (Seat s : this.seats) {
                    if (s.getRowNumber() == r && s.getSeatClass() == Seat.SeatClass.ECONOMY) {
                        System.out.print(s.isAvailable() ? "[ ] " : "[X] ");
                        colCount++;
                        if (colCount == 3) System.out.print("    ");
                    }
                }
                System.out.println();
            }

            System.out.println("\n---------------------------------------------");
            System.out.println("Flight Metrics: " + getFreeSeatsCount() + " Seats Free | " + getOccupiedSeatsCount() + " Seats Occupied");
            System.out.print("\nEnter seat number to book (e.g., 1A, 12H) or 'exit' to launch GUI: ");
            String inputSeat = scanner.nextLine().trim().toUpperCase();

            if (inputSeat.equalsIgnoreCase("EXIT")) {
                running = false;
                break;
            }

            Seat targetSeat = null;
            for (Seat s : this.seats) {
                if (s.getSeatNumber().equalsIgnoreCase(inputSeat)) {
                    targetSeat = s;
                    break;
                }
            }

            System.out.println("\n[SYSTEM NOTICE]:");
            if (targetSeat != null) {
                targetSeat.reserveSeat(); 
            } else {
                System.out.println("Invalid seat location layout coordinates entered! Please check the chart options.");
            }
        }
    }


    @Override
    public String toString(){
        return "Flight: " + flightID + "\nAirline: " + airline + "\nRoute: " + route + "\nPrice: " + price + "\nStatus: " + status;
}
}