package GUI;

import javax.swing.*;
import java.awt.*;

import GUI.Homepage.BackgroundPanel;

public class TrackAFlight {

    public static JPanel getPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel trackPanel = new JPanel(new BorderLayout());
        trackPanel.setBackground(Color.decode("#1477b2"));

        ImageIcon icon = new ImageIcon("src/images/map.jpg");
        Image img = icon.getImage();

        BackgroundPanel map_image = new BackgroundPanel(img);

        map_image.setPreferredSize(new Dimension(600, 720));
        map_image.setMaximumSize(new Dimension(600, 720));
        map_image.setMinimumSize(new Dimension(600, 720));
        JPanel leftWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        leftWrapper.setBackground(Color.white);
        
        JPanel whiteSpace = new JPanel();
        whiteSpace.setLayout(new BoxLayout(whiteSpace, BoxLayout.Y_AXIS));
        whiteSpace.setPreferredSize(new Dimension(200,720));
        whiteSpace.setBackground(Color.white);
        

        JPanel flight_details = new JPanel();
        flight_details.setLayout(new BoxLayout(flight_details, BoxLayout.Y_AXIS));
        flight_details.setPreferredSize(new Dimension(200,720));
        flight_details.setBackground(Color.white);

        JPanel details_value = new JPanel();
        details_value.setLayout(new BoxLayout(details_value, BoxLayout.Y_AXIS));
        details_value.setPreferredSize(new Dimension(400,720));

        //to change values
        JLabel flightIDValue = createLabels("SLX091");
        JLabel destinationValue = createLabels("Manila");
        JLabel originValue = createLabels("Cebu");
        JLabel departureTimeValue = createLabels("5:00 PM");
        JLabel arrivalTimeValue = createLabels("10:00 PM");
        JLabel statusValue = createLabels("BOARDING");
        details_value.add(flightIDValue);
        details_value.add(destinationValue);
        details_value.add(originValue);
        details_value.add(departureTimeValue);
        details_value.add(arrivalTimeValue);
        details_value.add(statusValue);
        flightIDValue.setAlignmentX(Component.RIGHT_ALIGNMENT);
        destinationValue.setAlignmentX(Component.RIGHT_ALIGNMENT);
        originValue.setAlignmentX(Component.RIGHT_ALIGNMENT);
        departureTimeValue.setAlignmentX(Component.RIGHT_ALIGNMENT);
        arrivalTimeValue.setAlignmentX(Component.RIGHT_ALIGNMENT);
        statusValue.setAlignmentX(Component.RIGHT_ALIGNMENT);

        
        JLabel flightID = createLabels("Flight ID: ");
        JLabel destination = createLabels("Destination: ");
        JLabel origin = createLabels("Origin: ");
        JLabel departureTime = createLabels("Departure Time: ");
        JLabel arrivalTime = createLabels("Arrival Time: ");
        JLabel status = createLabels("Status: ");
        flight_details.add(flightID);
        flight_details.add(origin);
        flight_details.add(destination);
        flight_details.add(departureTime);
        flight_details.add(arrivalTime);
        flight_details.add(status);
        
        leftWrapper.add(map_image);
        leftWrapper.add(whiteSpace);
        leftWrapper.add(flight_details);
        leftWrapper.add(details_value);

        trackPanel.add(Box.createVerticalStrut(30), BorderLayout.NORTH);
        trackPanel.add(Box.createVerticalStrut(30), BorderLayout.SOUTH);
        trackPanel.add(leftWrapper, BorderLayout.CENTER);
        trackPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        mainPanel.add(trackPanel, BorderLayout.CENTER);

        return mainPanel;
    }

    public static JLabel createLabels (String label){
        JLabel toDisplay = new JLabel(label);
        toDisplay.setFont(new Font("SansSerif", Font.PLAIN, 20));
        toDisplay.setBorder(BorderFactory.createEmptyBorder(10, 10, 100, 10));
        toDisplay.setOpaque(false);
        return toDisplay;
    }

}
