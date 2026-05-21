package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ProfilePage {

    public static JPanel getPanel(MainContent main) {

        Color backgroundColor = new Color(245, 247, 250);
        Color cardColor = Color.WHITE;
        Color primaryBlue = new Color(34, 87, 171);
        Color textDark = new Color(40, 40, 40);
        Color textLight = new Color(120, 120, 120);

        JPanel root = new JPanel();
        root.setLayout(null);
        root.setBackground(backgroundColor);

        // Title
        JLabel title = new JLabel("Profile Settings");
        title.setFont(new Font("SansSerif", Font.BOLD, 34));
        title.setForeground(textDark);
        title.setBounds(80, 40, 400, 40);

        JLabel subtitle = new JLabel("Manage your personal information");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 16));
        subtitle.setForeground(textLight);
        subtitle.setBounds(82, 80, 300, 25);

        // CARD
        JPanel profileCard = new JPanel();
        profileCard.setLayout(null);
        profileCard.setBounds(80, 130, 820, 420);
        profileCard.setBackground(cardColor);
        profileCard.setBorder(new CompoundBorder(
                new LineBorder(new Color(230, 230, 230), 1, true),
                new EmptyBorder(20, 20, 20, 20)
        ));

        // LEFT PANEL
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBackground(new Color(248, 250, 252));
        leftPanel.setBounds(0, 0, 250, 420);

        JLabel profileImage = new JLabel("A");
        profileImage.setBounds(75, 40, 100, 100);
        profileImage.setOpaque(true);
        profileImage.setBackground(primaryBlue);
        profileImage.setForeground(Color.WHITE);
        profileImage.setHorizontalAlignment(SwingConstants.CENTER);
        profileImage.setFont(new Font("SansSerif", Font.BOLD, 42));
        profileImage.setBorder(new LineBorder(primaryBlue, 2, true));

        JLabel userName = new JLabel("AeroFlow User");
        userName.setBounds(45, 165, 180, 30);
        userName.setFont(new Font("SansSerif", Font.BOLD, 20));
        userName.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel userRole = new JLabel("Premium Traveler");
        userRole.setBounds(45, 195, 180, 25);
        userRole.setForeground(textLight);
        userRole.setFont(new Font("SansSerif", Font.PLAIN, 14));
        userRole.setHorizontalAlignment(SwingConstants.CENTER);

        JButton uploadBtn = new JButton("Upload Photo");
        uploadBtn.setBounds(55, 260, 140, 40);
        uploadBtn.setFocusPainted(false);
        uploadBtn.setBackground(Color.WHITE);
        uploadBtn.setForeground(primaryBlue);
        uploadBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        uploadBtn.setBorder(new LineBorder(primaryBlue, 1, true));

        leftPanel.add(profileImage);
        leftPanel.add(userName);
        leftPanel.add(userRole);
        leftPanel.add(uploadBtn);

        // RIGHT PANEL
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBounds(250, 0, 570, 420);

        JLabel infoTitle = new JLabel("Personal Information");
        infoTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        infoTitle.setForeground(textDark);
        infoTitle.setBounds(40, 35, 300, 30);

        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setBounds(40, 95, 120, 20);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        JTextField nameField = createStyledField();
        nameField.setBounds(40, 120, 220, 42);

        JLabel emailLabel = new JLabel("Email Address");
        emailLabel.setBounds(300, 95, 120, 20);
        emailLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        JTextField emailField = createStyledField();
        emailField.setBounds(300, 120, 220, 42);

        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setBounds(40, 190, 120, 20);
        phoneLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        JTextField phoneField = createStyledField();
        phoneField.setBounds(40, 215, 220, 42);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(300, 190, 120, 20);
        passwordLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(300, 215, 220, 42);
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        passwordField.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1, true),
                new EmptyBorder(5, 10, 5, 10)
        ));

        JButton updateBtn = new JButton("Save Changes");
        updateBtn.setBounds(360, 330, 160, 45);
        updateBtn.setFocusPainted(false);
        updateBtn.setBackground(primaryBlue);
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setFont(new Font("SansSerif", Font.BOLD, 15));
        updateBtn.setBorder(new EmptyBorder(10, 10, 10, 10));

        rightPanel.add(infoTitle);
        rightPanel.add(nameLabel);
        rightPanel.add(nameField);
        rightPanel.add(emailLabel);
        rightPanel.add(emailField);
        rightPanel.add(phoneLabel);
        rightPanel.add(phoneField);
        rightPanel.add(passwordLabel);
        rightPanel.add(passwordField);
        rightPanel.add(updateBtn);

        // assemble
        profileCard.add(leftPanel);
        profileCard.add(rightPanel);

        root.add(title);
        root.add(subtitle);
        root.add(profileCard);

        return root;
    }

    private static JTextField createStyledField() {

        JTextField field = new JTextField();
        field.setFont(new Font("SansSerif", Font.PLAIN, 14));
        field.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1, true),
                new EmptyBorder(5, 10, 5, 10)
        ));
        return field;
    }
}