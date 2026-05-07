package GUI;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import GUI.Homepage.BackgroundPanel;
import GUI.Builders.NavBar;

public class BookAFlight {
    //remove this soon

    public static JPanel getPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout());


        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new OverlayLayout(contentPanel)); // to make it overlay
        JPanel bookingPanel = new JPanel();


        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        contentPanel.add(bookingPanel);

        bookingPanel.setMaximumSize(new Dimension(1700, 800));
        bookingPanel.setPreferredSize(new Dimension(1700, 800));
        bookingPanel.setBackground(Color.white);


        contentPanel.setBackground(Color.decode("#c6cdcf"));

        return mainPanel;
    }

}