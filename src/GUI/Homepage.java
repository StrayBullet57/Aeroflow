package GUI;

import javax.swing.*;
import java.awt.*;
import GUI.Builders.NavBar;

public class Homepage {

    public void createUI() {
        JFrame frame = new JFrame("AeroFlow");

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());


        JPanel navBar = NavBar.createNavBar();

        
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



}