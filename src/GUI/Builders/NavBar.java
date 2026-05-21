package GUI.Builders;

import GUI.BookAFlight.BookAFlightStep1;
import GUI.Homepage;
import GUI.MainContent;
import GUI.MyBookingsPage;
import GUI.ProfilePage;
import GUI.TrackAFlight_InputFlightID;
import users.SessionManager;
import java.awt.*;
import javax.swing.*;

public class NavBar {

    public static JPanel createNavBar(MainContent main) {
        JPanel navBar = new JPanel();
        navBar.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 20));
        navBar.setBackground(new Color(30, 30, 30));
        navBar.setPreferredSize(new Dimension(0, 80));

        JButton home           = createNavButton("Home");
        JButton book_a_flight  = createNavButton("Book");
        JButton track_a_flight = createNavButton("Flights");
        JButton my_bookings    = createNavButton("My Bookings");
        JButton profile        = createNavButton("Profile");
        JButton logout         = createNavButton("Logout");

        navBar.add(home);
        navBar.add(book_a_flight);
        navBar.add(track_a_flight);
        navBar.add(my_bookings);
        navBar.add(profile);
        navBar.add(logout);

        home.addActionListener(e ->
            main.showPage(Homepage.getPanel(main)));

        book_a_flight.addActionListener(e ->
            main.showPage(BookAFlightStep1.getPanel(main)));

        track_a_flight.addActionListener(e ->
            main.showPage(TrackAFlight_InputFlightID.getPanel(main)));

        my_bookings.addActionListener(e ->
            main.showPage(MyBookingsPage.getPanel(main)));

        profile.addActionListener(e ->
            main.showPage(ProfilePage.getPanel(main)));

        logout.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to log out?",
                "Logout",
                JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                SessionManager.logout();
                main.getFrame().dispose();
                new GUI.Login.LoginPage().start();
            }
        });

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
        Color hover  = new Color(60, 60, 60);
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) { btn.setBackground(hover); }
            public void mouseExited(java.awt.event.MouseEvent e)  { btn.setBackground(normal); }
        });
    }
}