package GUI.BookAFlight;

import GUI.MainContent;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import models.Flight;

public class BookAFlightStep2 {

    public static JPanel getPanel(MainContent main, String destination) {

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

        JLabel title = new JLabel("Select Flight");
        title.setFont(new Font("SansSerif", Font.BOLD, 40));
        title.setForeground(Color.DARK_GRAY); 
        topPanel.add(title);

        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setOpaque(false);

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(700, 500)); 
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel sectionTitle = new JLabel("Available Flights");
        sectionTitle.setFont(new Font("SansSerif", Font.BOLD, 28));
        sectionTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setOpaque(false);
        listPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        listPanel = displayFlightList(main, destination);

        listPanel.add(Box.createVerticalStrut(15)); 

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); 
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false); 
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        scrollPane.setPreferredSize(new Dimension(620, 300));
        scrollPane.setMaximumSize(new Dimension(620, 300));
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonPanel.setMaximumSize(new Dimension(620, 40)); 

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            main.showPage(BookAFlightStep1.getPanel(main)); 
        });

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> {
            main.showPage(BookAFlightStep3.getPanel(main)); 
        });

        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.add(nextButton, BorderLayout.EAST);

        card.add(sectionTitle);
        card.add(Box.createVerticalStrut(25));
        card.add(scrollPane); 
        card.add(Box.createVerticalGlue()); 
        card.add(buttonPanel);

        centerWrapper.add(card);

        bookingPanel.add(topPanel, BorderLayout.NORTH);
        bookingPanel.add(centerWrapper, BorderLayout.CENTER);

        return mainPanel;
    }

    private static JPanel createFlightCard(Flight flight, MainContent main){
        JPanel flightCard = new JPanel(new BorderLayout());
        flightCard.setMaximumSize(new Dimension(600, 120)); 
        flightCard.setBackground(new Color(235, 245, 255));
        flightCard.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        flightCard.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel flightName = new JLabel(
            flight.getFlightID() + " • " +
            flight.getRoute().getOrigin().getLocationName() + " → " +
            flight.getRoute().getDestination().getLocationName()
        );

        flightName.setFont(new Font("SansSerif", Font.BOLD, 20));

        JLabel airline = new JLabel(flight.getStatus());

        airline.setFont(new Font("SansSerif", Font.PLAIN, 16));

        JButton selectButton = new JButton("Select");

        selectButton.addActionListener(e -> {
            main.getBookingSession().setSelectedFlight(flight);
            System.out.println("Selected flight: " + flight.getFlightID());
            main.showPage(BookAFlightStep3.getPanel(main)); 
        });

        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        left.add(flightName);
        left.add(Box.createVerticalStrut(5));
        left.add(airline);

        flightCard.add(left, BorderLayout.WEST);
        flightCard.add(selectButton, BorderLayout.EAST);

        return flightCard;
    }

    private static JPanel displayFlightList(MainContent main, String destination) {
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setOpaque(false);
        listPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        List<Flight> allFlights = main.getBookingSystem().getFlights();
        boolean foundFlights = false;

        if (allFlights != null) {
            for (Flight flight : allFlights) {
                if (flight.getRoute().getDestination().getLocationName().equalsIgnoreCase(destination)) {
                    JPanel flightCard = createFlightCard(flight, main);
                    listPanel.add(flightCard);
                    listPanel.add(Box.createVerticalStrut(10)); 
                    foundFlights = true;
                }
            }
        }

        if (!foundFlights) {
            JLabel noFlightLabel = new JLabel("No flights found heading to " + destination);
            noFlightLabel.setFont(new Font("SansSerif", Font.ITALIC, 16));
            noFlightLabel.setForeground(Color.GRAY);
            listPanel.add(noFlightLabel);
        }

        return listPanel;
    }
}