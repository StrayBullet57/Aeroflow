package GUI.Builders;

import javax.swing.*;
import java.awt.*;

public class NavBar{

    public static JPanel createNavBar(){
        JPanel navBar = new JPanel();
        navBar.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));
        navBar.setBackground(new Color(30, 30, 30));
        navBar.setPreferredSize(new Dimension(0, 80));

        navBar.add(createNavButton("Home"));
        navBar.add(createNavButton("Flights"));
        navBar.add(createNavButton("Booking"));
        navBar.add(createNavButton("Profile"));
        navBar.add(createNavButton("Log Out"));
        return navBar;
    }

    private static JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setFocusPainted(false);
        button.setBackground(new Color(50, 50, 50));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }

}