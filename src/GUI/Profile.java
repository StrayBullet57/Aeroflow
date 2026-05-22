package GUI;

import users.SessionManager;
import users.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Profile extends JPanel {

    private JTextField fullNameField;
    private JTextField emailField;
    private JTextField phoneField;

    private JLabel displayName;
    private JLabel displayEmail;
    private JLabel displayPhone;

    public Profile() {

        // ================= GET USER =================
        User currentUser = SessionManager.getCurrentUser();

        String fullName = "Guest User";
        String email = "No Email";
        String phone = "No Phone";

        if (currentUser != null) {

            fullName = currentUser.getName();
            email = currentUser.getEmail();
            phone = currentUser.getPhone();
        }

        // ================= PANEL =================
        setLayout(new BorderLayout());
        setBackground(new Color(8, 18, 38));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(8, 18, 38));

        // ================= TITLE =================
        JLabel title = new JLabel("Passenger Profile");

        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 30));
        title.setBorder(new EmptyBorder(25, 35, 15, 35));

        // ================= CONTENT =================
        JPanel contentWrapper = new JPanel(new GridLayout(1, 2, 30, 0));

        contentWrapper.setOpaque(false);
        contentWrapper.setBorder(new EmptyBorder(20, 35, 35, 35));

        // =====================================================
        // LEFT PANEL
        // =====================================================

        JPanel profileCard = new JPanel();

        profileCard.setLayout(new BoxLayout(profileCard, BoxLayout.Y_AXIS));

        profileCard.setBackground(new Color(15, 32, 65));

        profileCard.setBorder(new EmptyBorder(30, 30, 30, 30));

        JLabel icon = new JLabel("✈");

        icon.setFont(new Font("SansSerif", Font.PLAIN, 80));

        icon.setForeground(new Color(0, 153, 255));

        icon.setAlignmentX(Component.CENTER_ALIGNMENT);

        displayName = createDisplayLabel(fullName, 28);
        displayEmail = createDisplayLabel(email, 16);
        displayPhone = createDisplayLabel(phone, 16);

        profileCard.add(icon);
        profileCard.add(Box.createVerticalStrut(20));
        profileCard.add(displayName);

        profileCard.add(Box.createVerticalStrut(30));

        profileCard.add(createInfoTitle("Email"));
        profileCard.add(displayEmail);

        profileCard.add(Box.createVerticalStrut(15));

        profileCard.add(createInfoTitle("Phone"));
        profileCard.add(displayPhone);

        // =====================================================
        // RIGHT PANEL
        // =====================================================

        JPanel formCard = new JPanel(new BorderLayout());

        formCard.setBackground(new Color(15, 32, 65));

        formCard.setBorder(new EmptyBorder(30, 30, 30, 30));

        JLabel editTitle = new JLabel("Edit Information");

        editTitle.setForeground(Color.WHITE);

        editTitle.setFont(new Font("SansSerif", Font.BOLD, 24));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 20, 20));

        formPanel.setOpaque(false);

        formPanel.setBorder(new EmptyBorder(40, 0, 0, 0));

        fullNameField = createTextField(fullName);
        emailField = createTextField(email);
        phoneField = createTextField(phone);

        formPanel.add(createLabel("Full Name"));
        formPanel.add(fullNameField);

        formPanel.add(createLabel("Email"));
        formPanel.add(emailField);

        formPanel.add(createLabel("Phone"));
        formPanel.add(phoneField);

        JButton saveBtn = new JButton("Save Information");

        saveBtn.setBackground(new Color(0, 153, 255));

        saveBtn.setForeground(Color.WHITE);

        saveBtn.setFont(new Font("SansSerif", Font.BOLD, 16));

        saveBtn.addActionListener(e -> {

            String updatedName = fullNameField.getText();
            String updatedEmail = emailField.getText();
            String updatedPhone = phoneField.getText();

            // UPDATE DISPLAY
            displayName.setText(updatedName);
            displayEmail.setText(updatedEmail);
            displayPhone.setText(updatedPhone);

            // UPDATE SESSION USER
            if (currentUser != null) {

                currentUser.setName(updatedName);
                currentUser.setEmail(updatedEmail);
                currentUser.setPhone(updatedPhone);
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Profile Updated Successfully!",
                    "Saved",
                    JOptionPane.INFORMATION_MESSAGE
            );

        });

        formPanel.add(new JLabel(""));
        formPanel.add(saveBtn);

        formCard.add(editTitle, BorderLayout.NORTH);
        formCard.add(formPanel, BorderLayout.CENTER);

        // ================= ADD =================

        contentWrapper.add(profileCard);
        contentWrapper.add(formCard);

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(contentWrapper, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);
    }

    // ================= LABEL =================

    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);

        label.setForeground(Color.WHITE);

        label.setFont(new Font("SansSerif", Font.BOLD, 16));

        return label;
    }

    // ================= DISPLAY LABEL =================

    private JLabel createDisplayLabel(String text, int size) {

        JLabel label = new JLabel(text);

        label.setForeground(Color.WHITE);

        label.setFont(new Font("SansSerif", Font.PLAIN, size));

        return label;
    }

    // ================= INFO TITLE =================

    private JLabel createInfoTitle(String text) {

        JLabel label = new JLabel(text);

        label.setForeground(new Color(0, 153, 255));

        label.setFont(new Font("SansSerif", Font.BOLD, 15));

        return label;
    }

    // ================= TEXTFIELD =================

    private JTextField createTextField(String text) {

        JTextField field = new JTextField(text);

        field.setBackground(new Color(25, 45, 85));

        field.setForeground(Color.WHITE);

        field.setCaretColor(Color.WHITE);

        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 153, 255), 1),
                BorderFactory.createEmptyBorder(12, 12, 12, 12)
        ));

        field.setFont(new Font("SansSerif", Font.PLAIN, 15));

        return field;
    }
}