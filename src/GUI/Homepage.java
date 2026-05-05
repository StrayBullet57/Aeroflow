package src.GUI;

import javax.swing.*;
import java.awt.*;

public class Homepage {

    public void createUI() {
        JFrame frame = new JFrame("AeroFlow");

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        //navbar
        JPanel navBar = new JPanel();
        navBar.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));
        navBar.setBackground(new Color(30, 30, 30));
        navBar.setPreferredSize(new Dimension(0, 80));

        navBar.add(createNavButton("Home"));
        navBar.add(createNavButton("Flights"));
        navBar.add(createNavButton("Booking"));
        navBar.add(createNavButton("Profile"));
        navBar.add(createNavButton("Log Out"));


        ImageIcon icon = new ImageIcon("src/images/homepagebg2.jpeg");
        Image img = icon.getImage();

        JPanel contentPanel = new BackgroundPanel(img);
        contentPanel.setLayout(new BorderLayout());

        mainPanel.add(navBar, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }



    class BackgroundPanel extends JPanel {

        private Image image;

        public BackgroundPanel(Image image) {
            this.image = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }



    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setFocusPainted(false);
        button.setBackground(new Color(50, 50, 50));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }
}