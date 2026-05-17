package GUI;

import javax.swing.*;
import GUI.BookAFlight.BookAFlightStep1;
import java.awt.*;

public class Homepage {

    public static JPanel getPanel(MainContent main) {

        JPanel mainPanel = new JPanel(new BorderLayout());

        ImageIcon icon = new ImageIcon("src/images/homepagebg2.png");
        Image img = icon.getImage();

        BackgroundPanel homepage_background = new BackgroundPanel(img);
        homepage_background.setLayout(new BoxLayout(homepage_background, BoxLayout.Y_AXIS));
        homepage_background.setOpaque(false);

        ImageIcon logoIcon = new ImageIcon("src/images/AEROFLOWBNW.png");
        Image scaledLogo = logoIcon.getImage()
                .getScaledInstance(800, 350, Image.SCALE_SMOOTH);

        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoLabel.setOpaque(false);

        JPanel showcase = new JPanel();
        showcase.setLayout(new BoxLayout(showcase, BoxLayout.X_AXIS));
        showcase.setBackground(Color.decode("#dfeaeb"));
        showcase.setMaximumSize(new Dimension(Integer.MAX_VALUE, 450));
        showcase.setAlignmentX(Component.CENTER_ALIGNMENT);

        homepage_background.add(logoLabel);
        homepage_background.add(showcase);

        ImageIcon boracay = new ImageIcon("src/images/boracay.jpg");
        ImageIcon baguio = new ImageIcon("src/images/baguio.jpg");
        ImageIcon samal = new ImageIcon("src/images/samal.png");
        ImageIcon taal = new ImageIcon("src/images/taal.jpg");

        JPanel showcaseItem1 = createShowcaseItem(main, "Destination_Name", "description", boracay);
        JPanel showcaseItem2 = createShowcaseItem(main, "Destination_Name", "description", baguio);
        JPanel showcaseItem3 = createShowcaseItem(main, "Destination_Name", "description", samal);
        JPanel showcaseItem4 = createShowcaseItem(main, "Destination_Name", "description", taal);
        
        showcase.add(Box.createHorizontalGlue());
        showcase.add(showcaseItem1);
        showcase.add(Box.createHorizontalStrut(150));
        showcase.add(showcaseItem2);
        showcase.add(Box.createHorizontalStrut(150));
        showcase.add(showcaseItem3);
        showcase.add(Box.createHorizontalStrut(150));
        showcase.add(showcaseItem4);
        showcase.add(Box.createHorizontalGlue());

        mainPanel.add(homepage_background, BorderLayout.CENTER);

        return mainPanel;
    }

    static class BackgroundPanel extends JPanel {

        private final Image image;

        public BackgroundPanel(Image image) {
            this.image = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private static JPanel createShowcaseItem(MainContent main, String name, String details, ImageIcon image) {

        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        card.setPreferredSize(new Dimension(300, 400));
        card.setMinimumSize(new Dimension(300, 400));
        card.setMaximumSize(new Dimension(300, 400));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1;

        JLabel imageLabel = new JLabel(image);
        gbc.gridy = 0;
        gbc.weighty = 0.1;
        card.add(imageLabel, gbc);
        imageLabel.setMaximumSize(new Dimension(50, 50));

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = 1;
        gbc.weighty = 0;
        card.add(nameLabel, gbc);

        JLabel detailsLabel = new JLabel("<html><body style='width:150px'>" + details + "</body></html>");
        gbc.gridy = 2;
        card.add(detailsLabel, gbc);

        JButton button = new JButton("View");
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        card.add(button, gbc);

        button.addActionListener(e -> {
            // Redirects to Step 1 instead of Step 2 to avoid uninitialized workflow variables
            main.showPage(BookAFlightStep1.getPanel(main)); 
        });

        return card;
    }
}