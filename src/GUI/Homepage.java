package GUI;

import javax.swing.*;
import java.awt.*;
import GUI.Builders.NavBar;


public class Homepage {

    public static JPanel getPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout());

        ImageIcon icon = new ImageIcon("src/images/homepagebg2.jpeg");
        Image img = icon.getImage();

        JPanel contentPanel = new BackgroundPanel(img);
        contentPanel.setLayout(new BorderLayout());

        mainPanel.add(contentPanel, BorderLayout.CENTER);

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