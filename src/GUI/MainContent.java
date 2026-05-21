package GUI;

import GUI.Builders.NavBar;
import datas.FlightData;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import models.BookingSession;
import models.Flight;
import models.FlightBooking;

public class MainContent {
    private FlightBooking bookingSystem;
    private BookingSession bookingSession;
    
    private JFrame frame;
    private JPanel contentPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainContent().start());
    }

    public void start() {
        bookingSystem = new FlightBooking();
        bookingSession = new BookingSession();

        List<Flight> flights = FlightData.getFlights();

        for (Flight f : flights){
            bookingSystem.addFlight(f);
        }

        frame = new JFrame("AeroFlow");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        contentPanel = new JPanel(new BorderLayout());

        JPanel navBar = NavBar.createNavBar(this);
        mainPanel.add(navBar, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        frame.setContentPane(mainPanel);

        showPage(Homepage.getPanel(this));

        frame.setVisible(true);
    }

    public void showPage(JPanel page) {
        contentPanel.removeAll();
        contentPanel.add(page, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public FlightBooking getBookingSystem(){
        return bookingSystem;
    }
    public BookingSession getBookingSession(){
        return bookingSession;
    }
}