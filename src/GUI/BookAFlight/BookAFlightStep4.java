package GUI.BookAFlight;

import javax.swing.*;
import GUI.MainContent;
import java.awt.*;
import models.Flight;
import models.Seat;
import models.FlightBooking;
import transactions.Booking;

public class BookAFlightStep4 {

    public static JPanel getPanel(MainContent main) {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.decode("#1477b2"));

        JPanel card = new JPanel();
        card.setBackground(Color.decode("#d8e6eb"));
        card.setPreferredSize(new Dimension(650, 750));
        card.setMinimumSize(new Dimension(650, 750));
        card.setMaximumSize(new Dimension(650, 750));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        Flight selectedFlight = main.getBookingSession().getSelectedFlight();
        Seat selectedSeat     = main.getBookingSession().getSelectedSeat();

        // ── Pull flight info ──────────────────────────────────────────
        String flightIDText      = "N/A";
        String originText        = "N/A";
        String destinationText   = "N/A";
        String departureDateText = "N/A";
        String departureTimeText = "N/A";
        String arrivalDateText   = "N/A";
        String arrivalTimeText   = "N/A";

        if (selectedFlight != null) {
            flightIDText      = selectedFlight.getFlightID();
            originText        = selectedFlight.getRoute().getOrigin().getLocationName();
            destinationText   = selectedFlight.getRoute().getDestination().getLocationName();
            departureDateText = selectedFlight.getSchedule().getDepartureDate();
            departureTimeText = selectedFlight.getSchedule().getDepartureTime();
            arrivalDateText   = selectedFlight.getSchedule().getArrivalDate();
            arrivalTimeText   = selectedFlight.getSchedule().getArrivalTime();
        }

        // ── Pull seat info ────────────────────────────────────────────
        String seatNumText      = "N/A";
        String seatCategoryText = "N/A";
        String seatClassText    = "N/A";

        if (selectedSeat != null) {
            seatNumText      = String.valueOf(selectedSeat.getRowNumber());
            seatCategoryText = String.valueOf(selectedSeat.getSeatCategory());
            seatClassText    = selectedSeat.getSeatClass(); // now uses real value
        }

        // ── Build summary UI ──────────────────────────────────────────
        JLabel titleLabel = new JLabel("FLIGHT SUMMARY");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.add(titleLabel);
        card.add(Box.createVerticalStrut(25));

        card.add(createFieldLabel("Flight ID"));
        card.add(createValueLabel(flightIDText));
        card.add(Box.createVerticalStrut(12));

        card.add(createFieldLabel("Route"));
        card.add(createValueLabel(originText + " → " + destinationText));
        card.add(Box.createVerticalStrut(12));

        card.add(createFieldLabel("Departure Date"));
        card.add(createValueLabel(departureDateText));
        card.add(Box.createVerticalStrut(12));

        card.add(createFieldLabel("Departure Time"));
        card.add(createValueLabel(departureTimeText));
        card.add(Box.createVerticalStrut(12));

        card.add(createFieldLabel("Arrival Date"));
        card.add(createValueLabel(arrivalDateText));
        card.add(Box.createVerticalStrut(12));

        card.add(createFieldLabel("Arrival Time"));
        card.add(createValueLabel(arrivalTimeText));
        card.add(Box.createVerticalStrut(12));

        card.add(createFieldLabel("Seat Assignment"));
        card.add(createValueLabel(
            seatNumText + " (Zone: " + seatCategoryText + " - " + seatClassText + ")"));
        card.add(Box.createVerticalStrut(30));

        // ── Buttons ───────────────────────────────────────────────────
        JPanel buttonPanel = new JPanel(new BorderLayout(20, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonPanel.setMaximumSize(new Dimension(550, 50));

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        backButton.setPreferredSize(new Dimension(120, 44));
        backButton.addActionListener(e ->
            main.showPage(BookAFlightStep3.getPanel(main))
        );

        JButton confirmButton = new JButton("Confirm Booking");
        confirmButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        confirmButton.setBackground(new Color(21, 101, 192));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setOpaque(true);
        confirmButton.setBorderPainted(false);
        confirmButton.setPreferredSize(new Dimension(200, 44));

        confirmButton.addActionListener(e -> {
            String userID = users.SessionManager.getCurrentUser().getUserID();

            String bookingID = "BK-" + selectedFlight.getFlightID()
                + "-" + selectedSeat.getSeatNumber()
                + "-" + (System.currentTimeMillis() % 10000);

            // 1. Create and confirm the booking object
            Booking booking = main.getBookingSystem()
                .createBooking(bookingID, userID, selectedFlight, selectedSeat, 0);
            booking.confirmBooking();

            // 2. CRITICAL FIX: Add the newly created booking to the global history list
            // So that Booking.getBookingsByUser(userID) can find it later!
            Booking.getBookingHistory().add(booking);

            JOptionPane.showMessageDialog(main.getFrame(),
                "Booking confirmed!\nYour booking ID is: " + bookingID,
                "Booking Confirmed",
                JOptionPane.INFORMATION_MESSAGE);

            main.getBookingSession().clear();
            main.showPage(GUI.Homepage.getPanel(main));
        });

        buttonPanel.add(backButton,    BorderLayout.WEST);
        buttonPanel.add(confirmButton, BorderLayout.EAST);
        card.add(buttonPanel);

        mainPanel.add(card);
        return mainPanel;
    }

    private static JLabel createFieldLabel(String text) {
        JLabel label = new JLabel(text.toUpperCase());
        label.setFont(new Font("SansSerif", Font.BOLD, 11));
        label.setForeground(Color.BLACK);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private static JLabel createValueLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.PLAIN, 18));
        label.setForeground(Color.BLACK);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }
}