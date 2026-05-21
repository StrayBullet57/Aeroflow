package GUI.BookAFlight;

import GUI.MainContent;
import java.awt.*;
import javax.swing.*;

public class BookAFlightStep1 {

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

        JLabel step1 = createStepLabel("Book A Flight ");
        step1.setFont(new Font("SansSerif", Font.BOLD, 40));
        topPanel.add(step1);


       JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setOpaque(false);

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(700, 500));
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));



        JLabel title = new JLabel("Routes & Airline");
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);



        JLabel fromLabel = createFieldLabel("From");
        JComboBox<String> fromBox = new JComboBox<>(
            new String[]{"Cebu", "Manila", "Davao"}
        );

        JLabel toLabel = createFieldLabel("To");
        JComboBox<String> toBox = new JComboBox<>(
            new String[]{"Cebu", "Manila", "Davao"}
        );

        JLabel airlineLabel = createFieldLabel("Airline");
        JComboBox<String> airlineBox = new JComboBox<>(
            new String[]{"Philippine Airlines", "Cebu Pacific", "AirAsia"}
        );

        fromBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        toBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        airlineBox.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> {
            main.getBookingSession().setFrom(
                (String) fromBox.getSelectedItem()
            );
            main.getBookingSession().setTo(
                (String) toBox.getSelectedItem()
            );
            main.getBookingSession().setAirline(
                (String) airlineBox.getSelectedItem()
            );
            main.showPage(BookAFlightStep2.getPanel(main,(String) toBox.getSelectedItem()));
        });
        buttonPanel.add(nextButton);

        card.add(title);
        card.add(Box.createVerticalStrut(30));

        card.add(fromLabel);
        card.add(Box.createVerticalStrut(10));
        card.add(fromBox);

        card.add(Box.createVerticalStrut(20));

        card.add(toLabel);
        card.add(Box.createVerticalStrut(10));
        card.add(toBox);

        card.add(Box.createVerticalStrut(20));

        card.add(airlineLabel);
        card.add(Box.createVerticalStrut(10));
        card.add(airlineBox);

        card.add(Box.createVerticalGlue());
        card.add(buttonPanel);

        centerWrapper.add(card);


        bookingPanel.add(topPanel, BorderLayout.NORTH);
        bookingPanel.add(centerWrapper, BorderLayout.CENTER);

        return mainPanel;
    }

    public static JLabel createStepLabel(String text) {

        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.BOLD, 18));
        label.setForeground(Color.DARK_GRAY);

        return label;
    }

    public static JLabel createFieldLabel(String text) {

        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.PLAIN, 18));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        return label;
    }
}