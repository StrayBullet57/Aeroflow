package models;

public class BookingSession{ // booking workflow memory
    private String from;
    private String to;
    private String airline;
    private Flight selectedFlight;
    private Seat selectedSeat;

    public void setFrom(String from){
        this.from = from;
    }
    public void setTo(String to){
        this.to = to;
    }
    public void setAirline(String airline){
        this.airline = airline;
    }
    public void setSelectedFlight(Flight selectedFlight){
        this.selectedFlight = selectedFlight;
    }
    public void setSelectedSeat(Seat selectedSeat){
        this.selectedSeat = selectedSeat;
    }

    public String getFrom(){
        return from;
    }
    public String getTo(){
        return to;
    }
    public String getAirline(){
        return airline;
    }
    public Flight getSelectedFlight(){
        return selectedFlight;
    }
    public Seat getSelectedSeat(){
        return selectedSeat;
    }
}