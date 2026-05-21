package GUI.BookAFlight;

import javax.swing.*;
import GUI.MainContent;
import java.awt.*;
import models.Flight;
import models.Seat;

public class BookAFlightStep4 {

    public static JPanel getPanel(MainContent main) {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.decode("#d8e6eb"));

        JPanel redSquare = new JPanel();
        redSquare.setBackground(Color.RED);
        redSquare.setPreferredSize(new Dimension(600, 600));
        redSquare.setMinimumSize(new Dimension(600, 600));
        redSquare.setMaximumSize(new Dimension(600, 600));
        redSquare.setLayout(new BoxLayout(redSquare, BoxLayout.Y_AXIS));
        redSquare.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        Flight selectedFlight = main.getBookingSession().getSelectedFlight();
        Seat selectedSeat = main.getBookingSession().getSelectedSeat();

        String flightIDText = "N/A";
        String originText = "N/A";
        String destinationText = "N/A";
        String departureText = "N/A";
        String arrivalText = "N/A";
        
        String seatNumText = "N/A";
        String seatCategoryText = "N/A";
        String seatClassText = "N/A";

        if (selectedFlight != null) {
            flightIDText = selectedFlight.getFlightID();
            originText = selectedFlight.getRoute().getOrigin().getLocationName();
            destinationText = selectedFlight.getRoute().getDestination().getLocationName();
            departureText = selectedFlight.getSchedule().getDepartureTime();
            arrivalText = selectedFlight.getSchedule().getArrivalTime();
        }

        if (selectedSeat != null) {
            seatNumText = String.valueOf(selectedSeat.getRowNumber());
            seatCategoryText = String.valueOf(selectedSeat.getSeatCategory());
            seatClassText = "ECONOMY CLASS"; 
        }

        JLabel titleLabel = new JLabel("FLIGHT SUMMARY");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        redSquare.add(titleLabel);
        redSquare.add(Box.createVerticalStrut(30));

        redSquare.add(createFieldLabel("Flight ID"));
        redSquare.add(createValueLabel(flightIDText));
        redSquare.add(Box.createVerticalStrut(15));

        redSquare.add(createFieldLabel("Route"));
        redSquare.add(createValueLabel(originText + " → " + destinationText));
        redSquare.add(Box.createVerticalStrut(15));

        redSquare.add(createFieldLabel("Departure"));
        redSquare.add(createValueLabel(departureText));
        redSquare.add(Box.createVerticalStrut(15));

        redSquare.add(createFieldLabel("Arrival"));
        redSquare.add(createValueLabel(arrivalText));
        redSquare.add(Box.createVerticalStrut(15));

        redSquare.add(createFieldLabel("Seat Assignment"));
        redSquare.add(createValueLabel(seatNumText + " (Zone: " + seatCategoryText + " - " + seatClassText + ")"));

        mainPanel.add(redSquare);

        return mainPanel;
    }

    private static JLabel createFieldLabel(String text) {
        JLabel label = new JLabel(text.toUpperCase());
        label.setFont(new Font("SansSerif", Font.BOLD, 12));
        label.setForeground(Color.LIGHT_GRAY);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private static JLabel createValueLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }
}