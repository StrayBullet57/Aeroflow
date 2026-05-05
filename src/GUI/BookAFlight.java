package GUI;
import javax.swing.*;
import java.awt.*;

import GUI.Homepage.BackgroundPanel;
import GUI.Builders.NavBar;

public class BookAFlight {

    public void createUI() {
        JFrame frame = new JFrame("AeroFlow");

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());


        JPanel navBar = NavBar.createNavBar();

        JPanel contentPanel = new JPanel();

        mainPanel.add(navBar, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

}