package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Profile extends JFrame {

    public Profile() {

        // FRAME SETTINGS
        setTitle("AeroFlow - Profile");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // MAIN PANEL
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(8, 18, 38));

        // ================= TOP NAVIGATION =================
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(10, 25, 55));
        topPanel.setBorder(new EmptyBorder(15, 25, 15, 25));

        JLabel logo = new JLabel("✈ AeroFlow");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("SansSerif", Font.BOLD, 28));

        JLabel title = new JLabel("Passenger Profile", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBackground(new Color(0, 153, 255));
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setFont(new Font("SansSerif", Font.BOLD, 14));

        topPanel.add(logo, BorderLayout.WEST);
        topPanel.add(title, BorderLayout.CENTER);
        topPanel.add(logoutBtn, BorderLayout.EAST);

        // ================= LEFT PROFILE PANEL =================
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(320, 650));
        leftPanel.setBackground(new Color(15, 32, 65));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(new EmptyBorder(30, 20, 30, 20));

        JLabel profileIcon = new JLabel("👤", SwingConstants.CENTER);
        profileIcon.setFont(new Font("SansSerif", Font.PLAIN, 90));
        profileIcon.setForeground(Color.WHITE);
        profileIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel userName = new JLabel("Juan Dela Cruz");
        userName.setForeground(Color.WHITE);
        userName.setFont(new Font("SansSerif", Font.BOLD, 26));
        userName.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel membership = new JLabel("Gold Member");
        membership.setForeground(new Color(0, 204, 255));
        membership.setFont(new Font("SansSerif", Font.PLAIN, 18));
        membership.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel statsPanel = new JPanel(new GridLayout(1, 2, 15, 15));
        statsPanel.setOpaque(false);
        statsPanel.setBorder(new EmptyBorder(40, 0, 20, 0));

        JPanel flightsCard = createCard("Flights", "28");
        JPanel milesCard = createCard("Miles", "58K");

        statsPanel.add(flightsCard);
        statsPanel.add(milesCard);

        JButton editBtn = new JButton("Edit Profile");
        editBtn.setMaximumSize(new Dimension(220, 45));
        editBtn.setBackground(new Color(0, 153, 255));
        editBtn.setForeground(Color.WHITE);
        editBtn.setFocusPainted(false);
        editBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
        editBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(profileIcon);
        leftPanel.add(Box.createVerticalStrut(15));
        leftPanel.add(userName);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(membership);
        leftPanel.add(statsPanel);
        leftPanel.add(Box.createVerticalStrut(30));
        leftPanel.add(editBtn);

        // ================= RIGHT DETAILS PANEL =================
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(8, 18, 38));
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBorder(new EmptyBorder(30, 30, 30, 30));

        JLabel infoTitle = new JLabel("Personal Information");
        infoTitle.setForeground(Color.WHITE);
        infoTitle.setFont(new Font("SansSerif", Font.BOLD, 28));

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 20, 20));
        formPanel.setBackground(new Color(8, 18, 38));
        formPanel.setBorder(new EmptyBorder(40, 0, 0, 0));

        formPanel.add(createLabel("Full Name"));
        formPanel.add(createTextField("Juan Dela Cruz"));

        formPanel.add(createLabel("Email Address"));
        formPanel.add(createTextField("juan@email.com"));

        formPanel.add(createLabel("Phone Number"));
        formPanel.add(createTextField("+63 912 345 6789"));

        formPanel.add(createLabel("Nationality"));
        formPanel.add(createTextField("Filipino"));

        formPanel.add(createLabel("Passport Number"));
        formPanel.add(createTextField("P12345678"));

        // UPCOMING FLIGHT CARD
        JPanel flightCard = new JPanel(new BorderLayout());
        flightCard.setBackground(new Color(15, 32, 65));
        flightCard.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel flightTitle = new JLabel("Upcoming Flight");
        flightTitle.setForeground(Color.WHITE);
        flightTitle.setFont(new Font("SansSerif", Font.BOLD, 22));

        JTextArea flightInfo = new JTextArea(
                "CEBU ✈ MANILA\n\n" +
                "Date: June 12, 2026\n" +
                "Time: 9:30 AM\n" +
                "Seat: 14A\n" +
                "Class: Business Class"
        );

        flightInfo.setEditable(false);
        flightInfo.setForeground(Color.WHITE);
        flightInfo.setBackground(new Color(15, 32, 65));
        flightInfo.setFont(new Font("SansSerif", Font.PLAIN, 18));

        flightCard.add(flightTitle, BorderLayout.NORTH);
        flightCard.add(flightInfo, BorderLayout.CENTER);

        rightPanel.add(infoTitle, BorderLayout.NORTH);
        rightPanel.add(formPanel, BorderLayout.CENTER);
        rightPanel.add(flightCard, BorderLayout.SOUTH);

        // ADD COMPONENTS
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
    }

    // CUSTOM LABEL
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("SansSerif", Font.BOLD, 16));
        return label;
    }

    // CUSTOM TEXTFIELD
    private JTextField createTextField(String text) {
        JTextField field = new JTextField(text);
        field.setBackground(new Color(25, 45, 85));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        field.setFont(new Font("SansSerif", Font.PLAIN, 15));
        return field;
    }

    // CARD DESIGN
    private JPanel createCard(String title, String value) {
        JPanel card = new JPanel();
        card.setBackground(new Color(0, 153, 255));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(new EmptyBorder(20, 15, 20, 15));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setForeground(Color.WHITE);
        valueLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(titleLabel);
        card.add(Box.createVerticalStrut(10));
        card.add(valueLabel);

        return card;
    }

    // MAIN METHOD
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Profile());
    }
}