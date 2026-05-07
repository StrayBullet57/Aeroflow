package GUI;

import javax.swing.*;
import java.awt.*;
import GUI.Builders.NavBar;


public class Homepage {

    public static JPanel getPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout());

        ImageIcon icon = new ImageIcon("src/images/homepagebg2.png");
        Image img = icon.getImage();
        ImageIcon logoIcon = new ImageIcon("src/images/AEROFLOWBNW.png");
        Image scaledLogo = logoIcon.getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH); // change size sa image

        JPanel contentPanel = new BackgroundPanel(img);
        contentPanel.setLayout(null);

        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));
        logoLabel.setBounds(5, -300, 1000, 1000);
        contentPanel.add(logoLabel);

        //for slider
        JPanel sliderContainer = new JPanel();
        sliderContainer.setLayout(new OverlayLayout(sliderContainer));
        JPanel slider = new JPanel(new GridLayout(1,3,40,0));
        
        slider.setPreferredSize(new Dimension(1850, 450));
        slider.setMaximumSize(new Dimension(1850, 450));
        slider.setAlignmentX(0.5f);
        slider.setAlignmentY(0.9f); 
        slider.setBackground(new Color(0,0,0,0));

        
        //items

        sliderContainer.add(slider);
        sliderContainer.add(contentPanel);
        mainPanel.add(sliderContainer);

        return mainPanel;
    }

    static class BackgroundPanel extends JPanel {
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