package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import transactions.Booking;
import users.SessionManager;

public class MyBookingsPage {

    public static JPanel getPanel(MainContent main) {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.decode("#1477b2"));

        // ── Title bar ─────────────────────────────────────────────────
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        topPanel.setOpaque(false);
        JLabel title = new JLabel("My Bookings");
        title.setFont(new Font("SansSerif", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        topPanel.add(title);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // ── Fetch this user's bookings ─────────────────────────────────
        String userID = SessionManager.getCurrentUser().getUserID();
        ArrayList<Booking> myBookings = Booking.getBookingsByUser(userID);

        // ── Scrollable list of booking cards ──────────────────────────
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(Color.decode("#1477b2"));
        listPanel.setBorder(new EmptyBorder(10, 60, 30, 60));

        if (myBookings.isEmpty()) {
            JLabel empty = new JLabel("You have no bookings yet.");
            empty.setFont(new Font("SansSerif", Font.PLAIN, 20));
            empty.setForeground(Color.WHITE);
            empty.setAlignmentX(Component.CENTER_ALIGNMENT);
            listPanel.add(Box.createVerticalStrut(60));
            listPanel.add(empty);
        } else {
            for (Booking b : myBookings) {
                listPanel.add(createBookingCard(b, main, listPanel));
                listPanel.add(Box.createVerticalStrut(16));
            }
        }

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        return mainPanel;
    }

    private static JPanel createBookingCard(Booking b, MainContent main, JPanel listPanel) {
        JPanel card = new JPanel(new BorderLayout(20, 0));
        card.setBackground(Color.WHITE);
        card.setBorder(new EmptyBorder(20, 24, 20, 24));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 140));
        card.setAlignmentX(Component.LEFT_ALIGNMENT);

        // ── Left: booking info ─────────────────────────────────────
        JPanel infoPanel = new JPanel(new GridLayout(4, 1, 0, 4));
        infoPanel.setOpaque(false);

        String flightID   = b.getFlight().getFlightID();
        String origin     = b.getFlight().getRoute().getOrigin().getLocationName();
        String dest       = b.getFlight().getRoute().getDestination().getLocationName();
        String depDate    = b.getFlight().getSchedule().getDepartureDate();
        String depTime    = b.getFlight().getSchedule().getDepartureTime();
        String seatID     = b.getSeat().getSeatNumber();
        String seatClass  = b.getSeat().getSeatClass();

        JLabel bookingIDLabel = new JLabel("Booking ID: " + b.getBookingID());
        bookingIDLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        bookingIDLabel.setForeground(new Color(107, 114, 128));

        JLabel routeLabel = new JLabel(origin + "  →  " + dest);
        routeLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        routeLabel.setForeground(new Color(17, 24, 39));

        JLabel flightLabel = new JLabel("Flight: " + flightID
            + "   |   Departs: " + depDate + " at " + depTime);
        flightLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        flightLabel.setForeground(new Color(55, 65, 81));

        JLabel seatLabel = new JLabel("Seat: " + seatID + "  ·  " + seatClass);
        seatLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        seatLabel.setForeground(new Color(55, 65, 81));

        infoPanel.add(bookingIDLabel);
        infoPanel.add(routeLabel);
        infoPanel.add(flightLabel);
        infoPanel.add(seatLabel);

        // ── Right: cancel button ───────────────────────────────────
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setFont(new Font("SansSerif", Font.BOLD, 13));
        cancelBtn.setForeground(new Color(200, 0, 0));
        cancelBtn.setBackground(Color.WHITE);
        cancelBtn.setBorder(BorderFactory.createLineBorder(new Color(200, 0, 0), 1, true));
        cancelBtn.setFocusPainted(false);
        cancelBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cancelBtn.setPreferredSize(new Dimension(100, 36));
        cancelBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(main.getFrame(),
                "Cancel booking " + b.getBookingID() + "?\nSeat " + seatID + " will be freed.",
                "Confirm Cancellation",
                JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Free the seat back up
                b.getSeat().cancelReservation();
                // Remove from history
                Booking.getBookingHistory().remove(b);
                // Refresh the page
                main.showPage(MyBookingsPage.getPanel(main));
            }
        });

        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setOpaque(false);
        rightPanel.add(cancelBtn);

        card.add(infoPanel,  BorderLayout.CENTER);
        card.add(rightPanel, BorderLayout.EAST);

        return card;
    }
}