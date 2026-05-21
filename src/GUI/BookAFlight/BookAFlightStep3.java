package GUI.BookAFlight;

import javax.swing.*;
import GUI.MainContent;
import java.awt.*;
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

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setOpaque(false);

        ImageIcon rawIcon = new ImageIcon("src/images/seatdisplay.png");
        Image scaledImage = rawIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon finishedIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(finishedIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        imagePanel.setPreferredSize(new Dimension(400, 400));
        imagePanel.setOpaque(false);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        leftPanel.add(imagePanel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setOpaque(false);

        JLabel sectionTitle = new JLabel("Seat Selection");
        sectionTitle.setFont(new Font("SansSerif", Font.BOLD, 28));
        sectionTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel seatNumLabel = createFieldLabel("Seat Number");
        
        String[] seatNumbers = new String[21];
        for (int i = 0; i < 21; i++) {
            seatNumbers[i] = String.valueOf(i + 1);
        }
        JComboBox<String> seatNumBox = createDropdown(seatNumbers);

        JLabel categoryLabel = createFieldLabel("Category");
        JComboBox<String> categoryBox = createDropdown(new String[]{"A", "B", "C", "H", "J", "K"});

        JLabel typeLabel = createFieldLabel("Class");
        JComboBox<String> typeBox = createDropdown(new String[]{"FIRST CLASS", "BUSINESS CLASS", "ECONOMY CLASS"});

        rightPanel.add(sectionTitle);
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(categoryLabel);
        rightPanel.add(Box.createVerticalStrut(5));
        rightPanel.add(categoryBox);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(seatNumLabel);
        rightPanel.add(Box.createVerticalStrut(5));
        rightPanel.add(seatNumBox);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(typeLabel);
        rightPanel.add(Box.createVerticalStrut(5));
        rightPanel.add(typeBox);

        splitContainer.add(leftPanel);
        splitContainer.add(rightPanel);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonPanel.setMaximumSize(new Dimension(870, 40));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            main.showPage(BookAFlightStep2.getPanel(main,main.getBookingSession().getSelectedFlight().getRoute().getDestination().getLocationName()));
        });

        JButton submitButton = new JButton("Submit");

        String seatStr = (String) seatNumBox.getSelectedItem();
        int selectedSeatNum = (seatStr != null) ? Integer.parseInt(seatStr) : 1;

        String catStr = (String) categoryBox.getSelectedItem();
        char selectedCategory = (catStr != null && !catStr.isEmpty()) ? catStr.charAt(0) : 'A';

        String selectedClass = (String) typeBox.getSelectedItem();

        main.getBookingSession().setSelectedSeat(new Seat(selectedSeatNum, selectedCategory, selectedClass));

        main.showPage(BookAFlightStep4.getPanel((main)));



        submitButton.addActionListener(e -> {
            main.showPage(BookAFlightStep4  .getPanel(main));
            main.getBookingSession().setSelectedSeat(new Seat(selectedSeatNum,selectedCategory,selectedClass));
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