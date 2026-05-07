package GUI.Builders;

import javax.swing.*;

import GUI.BookAFlight;
import GUI.Homepage;
import GUI.MainContent;

import java.awt.*;

public class NavBar{

    public static JPanel createNavBar(MainContent main){
        JPanel navBar = new JPanel();
        navBar.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));
        navBar.setBackground(new Color(30, 30, 30));
        navBar.setPreferredSize(new Dimension(0, 80));
        JButton home = createNavButton("Home");
        JButton flights = createNavButton("Flights");
        JButton booking = createNavButton("Booking");
        JButton profile = createNavButton("Profile");
        JButton logout = createNavButton("Logout");

        navBar.add(home);
        navBar.add(flights);
        navBar.add(booking);
        navBar.add(profile);
        navBar.add(logout);
        

        //life ni 
        home.addActionListener(e -> {
            main.showPage(Homepage.getPanel());
        });

        flights.addActionListener(e -> {
            main.showPage(BookAFlight.getPanel());
        });

        /*booking.addActionListener(e -> {
            frame.dispose();
            new BookingPage().createUI();
        });

        profile.addActionListener(e -> {
            frame.dispose();
            new ProfilePage().createUI();
        });*/

        return navBar;
    }

        private static JButton createNavButton(String text) {

        JButton button = new JButton(text);

        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setForeground(Color.WHITE);

        button.setBackground(new Color(30, 30, 30));

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(true);
        button.setOpaque(true);

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.setPreferredSize(new Dimension(120, 40));

        addHoverEffect(button);

        return button;
    }

    public static void addHoverEffect(JButton btn) {

        Color normal = new Color(30, 30, 30);
        Color hover = new Color(60, 60, 60);

        btn.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(hover);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(normal);
            }
        });
    }

    

}