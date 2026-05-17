package GUI;

import javax.swing.*;
import java.awt.*;

public class TrackAFlight_InputFlightID {

    public static JPanel getPanel(MainContent main) {

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel trackPanel = new JPanel(new BorderLayout());
        trackPanel.setBackground(Color.decode("#1477b2"));
        trackPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        ImageIcon logoIcon = new ImageIcon("src/images/AEROFLOWBNW.png");
        Image scaledLogo = logoIcon.getImage().getScaledInstance(400, 175, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("Track A Flight");
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField trackField = new JTextField();
        trackField.setMaximumSize(new Dimension(300, 40));
        trackField.setFont(new Font("SansSerif", Font.PLAIN, 18));

        JButton trackButton = new JButton("Track Flight");
        trackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        trackButton.setPreferredSize(new Dimension(200, 40));

        trackButton.addActionListener(e -> {
            main.showPage(TrackAFlight.getPanel());
        });

        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(logoLabel);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(title);
        centerPanel.add(Box.createVerticalStrut(30));
        centerPanel.add(trackField);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(trackButton);
        centerPanel.add(Box.createVerticalGlue());

        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setOpaque(false);
        wrapper.add(centerPanel);

        trackPanel.add(wrapper, BorderLayout.CENTER);

        mainPanel.add(trackPanel, BorderLayout.CENTER);

        return mainPanel;
    }
}