package GUI;

import javax.swing.*;
import java.awt.*;

import GUI.Homepage.BackgroundPanel;
import models.Flight;

public class TrackAFlight {

    public static JPanel getPanel(Flight passedFlight) {

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel trackPanel = new JPanel(new BorderLayout());
        trackPanel.setBackground(Color.decode("#1477b2"));

        ImageIcon icon = new ImageIcon("src/images/map.jpg");
        Image img = icon.getImage();

        BackgroundPanel map_image = new BackgroundPanel(img);


        // map panel

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 720));

        Image plane_img = new ImageIcon("src/images/plane_silhouette.png").getImage();
        Image scaled = plane_img.getScaledInstance(40,40,Image.SCALE_SMOOTH);
        JLabel plane = new JLabel(new ImageIcon(scaled));
        plane.setSize(30, 30);


        // PLACEMENT OF AIRPLANE AND FOR ANIMATIONS


        // set ni sya sa x coordinate sa origin location
        int startX = passedFlight.getRoute().getOrigin().getXCoordinate();
        int startY = passedFlight.getRoute().getOrigin().getYCoordinate();

         // kani kay sa destination
        int targetX = passedFlight.getRoute().getDestination().getXCoordinate();
        int targetY = passedFlight.getRoute().getDestination().getYCoordinate();

       // to study
        final double duration = 1000.0; 
        final int frameDelayMs = 15;
        final long startTime = System.currentTimeMillis();
        final double routeDuration = passedFlight.getRoute().getDuration();
        // 4. Create and start the animation loop

        
        Timer flightTimer = new Timer(frameDelayMs, null);
        flightTimer.addActionListener(e -> {
            long elapsed = System.currentTimeMillis() - startTime;
            double newDuration = duration*(routeDuration*60*60);

                // set speed = 20.11 km/h
            double progress = elapsed / newDuration;

            if (progress >= 1.0) {
                progress = 1.0;
                flightTimer.stop(); 
            }

            // Linear interpolation formula: start + (target - start) * progress
            int currentX = (int) (startX + (targetX - startX) * progress);
            int currentY = (int) (startY + (targetY - startY) * progress);

            plane.setLocation(currentX, currentY);
            
            // Forces the panel containing the plane to visually refresh its layout
            plane.getParent().repaint(); 
        });

        flightTimer.start();
        


        //END OF ANIMATIONS


        map_image.setPreferredSize(new Dimension(600, 720));
        map_image.setMaximumSize(new Dimension(600, 720));
        map_image.setMinimumSize(new Dimension(600, 720));
        map_image.setBounds(0, 0, 600, 720);
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

        JPanel durationHours_value = new JPanel();
        details_value.setLayout(new BoxLayout(details_value, BoxLayout.Y_AXIS));
        details_value.setPreferredSize(new Dimension(400,720));

        //to change values
        JLabel flightIDValue = createLabels(passedFlight.getFlightID());
        JLabel originValue = createLabels(passedFlight.getRoute().getOrigin().getLocationName());
        JLabel destinationValue = createLabels(passedFlight.getRoute().getDestination().getLocationName());
        JLabel departureTimeValue = createLabels(passedFlight.getSchedule().getDepartureTime());
        JLabel arrivalTimeValue = createLabels(passedFlight.getSchedule().getArrivalTime());
        JLabel statusValue = createLabels("BOARDING"+ " (Duration: " + routeDuration + " Hours)");
        details_value.add(flightIDValue);
        details_value.add(destinationValue);
        details_value.add(originValue);
        details_value.add(departureTimeValue);
        details_value.add(arrivalTimeValue);
        details_value.add(statusValue);
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
        JLabel durationHours = createLabels("Duration: ");
        flight_details.add(flightID);
        flight_details.add(origin);
        flight_details.add(destination);
        flight_details.add(departureTime);
        flight_details.add(arrivalTime);
        flight_details.add(status);
        flight_details.add(durationHours);
        
        layeredPane.add(map_image,Integer.valueOf(0));
        layeredPane.add(plane,Integer.valueOf(1));

        // animation



        leftWrapper.add(layeredPane);
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