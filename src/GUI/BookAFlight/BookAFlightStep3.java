package GUI.BookAFlight;

import javax.swing.*;
import GUI.MainContent;
import java.awt.*;
import java.util.ArrayList;
import models.Flight;
import models.Seat;

public class BookAFlightStep3 {

    public static JPanel getPanel(MainContent main) {

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new OverlayLayout(contentPanel));

        JPanel bookingPanel = new JPanel();
        bookingPanel.setLayout(new BorderLayout());

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.add(bookingPanel);

        bookingPanel.setMaximumSize(new Dimension(1700, 800));
        bookingPanel.setPreferredSize(new Dimension(1700, 800));
        bookingPanel.setBackground(Color.decode("#d8e6eb"));
        contentPanel.setBackground(Color.decode("#1477b2"));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        topPanel.setOpaque(false);

        JLabel title = new JLabel("Choose Your Seat");
        title.setFont(new Font("SansSerif", Font.BOLD, 40));
        title.setForeground(Color.DARK_GRAY);
        topPanel.add(title);

        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setOpaque(false);

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(950, 550));
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JPanel splitContainer = new JPanel(new GridLayout(1, 2, 40, 0));
        splitContainer.setOpaque(false);
        splitContainer.setAlignmentX(Component.LEFT_ALIGNMENT);

        // ── Left: seat diagram image ──────────────────────────────────
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setOpaque(false);

        ImageIcon rawIcon = new ImageIcon("src/images/seatdisplay.png");
        Image scaledImage = rawIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        imagePanel.setPreferredSize(new Dimension(400, 400));
        imagePanel.setOpaque(false);
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        leftPanel.add(imagePanel, BorderLayout.CENTER);

        // ── Right: seat selection controls ────────────────────────────
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setOpaque(false);

        JLabel sectionTitle = new JLabel("Seat Selection");
        sectionTitle.setFont(new Font("SansSerif", Font.BOLD, 28));
        sectionTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Get the actual flight so we can check real seat availability
        Flight selectedFlight = main.getBookingSession().getSelectedFlight();
        ArrayList<Seat> flightSeats = selectedFlight.getSeats();

        // Class dropdown
        JLabel typeLabel = createFieldLabel("Class");
        JComboBox<String> typeBox = createDropdown(
            new String[]{"FIRST CLASS", "BUSINESS CLASS", "ECONOMY CLASS"});

        // Category dropdown
        JLabel categoryLabel = createFieldLabel("Category");
        JComboBox<String> categoryBox = createDropdown(
            new String[]{"A", "B", "C", "H", "J", "K"});

        // Seat number dropdown — populated dynamically based on class
        JLabel seatNumLabel = createFieldLabel("Seat Number");
        JComboBox<String> seatNumBox = new JComboBox<>();
        seatNumBox.setFont(new Font("SansSerif", Font.BOLD, 16));
        seatNumBox.setMaximumSize(new Dimension(400, 40));
        seatNumBox.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Status label — shows if a seat is taken
        JLabel seatStatusLabel = new JLabel(" ");
        seatStatusLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        seatStatusLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // ── Refresh seat numbers based on selected class ──────────────
        Runnable refreshSeatNumbers = () -> {
            String cls = (String) typeBox.getSelectedItem();
            seatNumBox.removeAllItems();

            int start, end;
            if ("FIRST CLASS".equals(cls)) {
                start = 1; end = 4;
            } else if ("BUSINESS CLASS".equals(cls)) {
                start = 2; end = 5;
            } else {
                start = 10; end = 21;
            }
            for (int i = start; i <= end; i++) {
                seatNumBox.addItem(String.valueOf(i));
            }
        };

        // ── Check if selected seat is available ───────────────────────
        Runnable checkSeatAvailability = () -> {
            String catStr = (String) categoryBox.getSelectedItem();
            String numStr = (String) seatNumBox.getSelectedItem();

            if (catStr == null || numStr == null) return;

            // Seat ID is stored as e.g. "1A", "10B"
            String seatID = numStr + catStr;

            boolean taken = false;
            for (Seat s : flightSeats) {
                if (s.getSeatNumber().equals(seatID) && !s.isAvailable()) {
                    taken = true;
                    break;
                }
            }

            if (taken) {
                seatStatusLabel.setText("⚠ This seat is already taken!");
                seatStatusLabel.setForeground(new Color(200, 0, 0));
            } else {
                seatStatusLabel.setText("✓ Seat is available");
                seatStatusLabel.setForeground(new Color(0, 150, 0));
            }
        };

        // Wire up listeners
        typeBox.addActionListener(e -> {
            refreshSeatNumbers.run();
            checkSeatAvailability.run();
        });
        categoryBox.addActionListener(e -> checkSeatAvailability.run());
        seatNumBox.addActionListener(e -> checkSeatAvailability.run());

        // Initial population
        refreshSeatNumbers.run();
        checkSeatAvailability.run();

        rightPanel.add(sectionTitle);
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(typeLabel);
        rightPanel.add(Box.createVerticalStrut(5));
        rightPanel.add(typeBox);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(categoryLabel);
        rightPanel.add(Box.createVerticalStrut(5));
        rightPanel.add(categoryBox);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(seatNumLabel);
        rightPanel.add(Box.createVerticalStrut(5));
        rightPanel.add(seatNumBox);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(seatStatusLabel);

        splitContainer.add(leftPanel);
        splitContainer.add(rightPanel);

        // ── Buttons ───────────────────────────────────────────────────
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonPanel.setMaximumSize(new Dimension(870, 40));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e ->
            main.showPage(BookAFlightStep2.getPanel(main,
                main.getBookingSession().getSelectedFlight()
                    .getRoute().getDestination().getLocationName(), 
                    main.getBookingSession().getSelectedFlight()
                    .getRoute().getOrigin().getLocationName()))
        );

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String catStr = (String) categoryBox.getSelectedItem();
            String numStr = (String) seatNumBox.getSelectedItem();
            String cls    = (String) typeBox.getSelectedItem();

            if (catStr == null || numStr == null || cls == null) return;

            // Seat ID is e.g. "1A", "10B"
            String seatID = numStr + catStr;

            // Find the matching seat on the actual flight object
            Seat matchedSeat = null;
            for (Seat s : flightSeats) {
                if (s.getSeatNumber().equals(seatID)) {
                    matchedSeat = s;
                    break;
                }
            }

            // Block if seat is taken or doesn't exist
            if (matchedSeat == null || !matchedSeat.isAvailable()) {
                JOptionPane.showMessageDialog(main.getFrame(),
                    "Seat " + seatID + " is already taken.\nPlease choose another seat.",
                    "Seat Unavailable",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Mark seat as taken using the existing reserveSeat() method
            matchedSeat.reserveSeat();

            // Save to booking session and proceed
            main.getBookingSession().setSelectedSeat(matchedSeat);
            main.showPage(BookAFlightStep4.getPanel(main));
        });

        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.add(submitButton, BorderLayout.EAST);

        card.add(splitContainer);
        card.add(Box.createVerticalGlue());
        card.add(buttonPanel);

        centerWrapper.add(card);

        bookingPanel.add(topPanel, BorderLayout.NORTH);
        bookingPanel.add(centerWrapper, BorderLayout.CENTER);

        return mainPanel;
    }

    private static JLabel createFieldLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label.setForeground(Color.GRAY);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private static JComboBox<String> createDropdown(String[] items) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setFont(new Font("SansSerif", Font.BOLD, 16));
        comboBox.setMaximumSize(new Dimension(400, 40));
        comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        return comboBox;
    }
}