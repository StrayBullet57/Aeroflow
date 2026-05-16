package GUI;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import GUI.Homepage.BackgroundPanel;
import GUI.Builders.NavBar;

public class TrackAFlight {
    //remove this soon

    public static JPanel getPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout());


        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new OverlayLayout(contentPanel)); // to make it overlay
        JPanel trackPanel = new JPanel();


        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        contentPanel.add(trackPanel);

        trackPanel.setMaximumSize(new Dimension(1700, 800));
        trackPanel.setPreferredSize(new Dimension(1700, 800));
        trackPanel.setBackground(Color.gray);


        contentPanel.setBackground(Color.decode("#1477b2"));

        return mainPanel;
    }

}