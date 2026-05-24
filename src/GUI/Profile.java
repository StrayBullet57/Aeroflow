package GUI;

import users.SessionManager;
import users.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Profile extends JPanel {

    private JTextField fullNameField;
    private JTextField emailField;
    private JTextField phoneField;

    private JLabel displayName;
    private JLabel displayEmail;
    private JLabel displayPhone;

    public Profile() {

        User currentUser = SessionManager.getCurrentUser();

        String fullName = "Guest User";
        String email = "No Email";
        String phone = "No Phone";

        if (currentUser != null) {

            fullName = currentUser.getName();
            email = currentUser.getEmail();
            phone = currentUser.getPhone();
        }

        setLayout(new BorderLayout());

        setBackground(new Color(8, 18, 38));

        setPreferredSize(new Dimension(1200, 700));

        setFocusable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());

        mainPanel.setBackground(new Color(8, 18, 38));

        // ================= TITLE =================

        JLabel title = new JLabel("✈ Passenger Profile");

        title.setForeground(new Color(0, 153, 255));

        title.setFont(new Font("SansSerif", Font.BOLD, 30));

        title.setBorder(new EmptyBorder(25, 35, 15, 35));

        // ================= CONTENT WRAPPER =================

        JPanel contentWrapper = new JPanel(
                new GridLayout(1, 2, 20, 20)
        );

        contentWrapper.setOpaque(false);

        contentWrapper.setBorder(
                new EmptyBorder(20, 35, 35, 35)
        );

        // ================= PROFILE CARD =================

        JPanel profileCard = new JPanel();

        profileCard.setLayout(
                new BoxLayout(profileCard, BoxLayout.Y_AXIS)
        );

        profileCard.setBackground(new Color(15, 32, 65));

        profileCard.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(30, new Color(0, 153, 255)),
                new EmptyBorder(30, 30, 30, 30)
        ));

        // ================= PROFILE IMAGE =================

        JLabel profilePic = new JLabel();

        URL imageURL = getClass().getResource("/images/profile.png");

        Image image = null;

        if (imageURL != null) {

            ImageIcon imageIcon = new ImageIcon(imageURL);

            image = imageIcon.getImage();
        }

        // ================= TOP SECTION =================

        JPanel topSection = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 15, 10)
        );

        topSection.setOpaque(false);

        if (image != null) {

            Image smallImage = image.getScaledInstance(
                    90,
                    90,
                    Image.SCALE_SMOOTH
            );

            Image roundedSmallImage = makeRoundedImage(
                    smallImage,
                    90
            );

            profilePic.setIcon(new ImageIcon(roundedSmallImage));
        }

        displayName = createDisplayLabel(fullName, 28);

        displayName.setAlignmentY(Component.CENTER_ALIGNMENT);

        topSection.add(profilePic);

        topSection.add(displayName);

        profileCard.add(topSection);

        profileCard.add(Box.createVerticalStrut(30));

        // ================= EMAIL =================

        displayEmail = createDisplayLabel(email, 16);

        profileCard.add(createInfoTitle("Email"));

        profileCard.add(displayEmail);

        profileCard.add(Box.createVerticalStrut(15));

        // ================= PHONE =================

        displayPhone = createDisplayLabel(phone, 16);

        profileCard.add(createInfoTitle("Phone"));

        profileCard.add(displayPhone);

        // ================= FORM CARD =================

        JPanel formCard = new JPanel(new BorderLayout());

        formCard.setBackground(new Color(15, 32, 65));

        formCard.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(30, new Color(0, 153, 255)),
                new EmptyBorder(30, 30, 30, 30)
        ));

        JLabel editTitle = new JLabel("Edit Information");

        editTitle.setForeground(Color.WHITE);

        editTitle.setFont(new Font("SansSerif", Font.BOLD, 24));

        JPanel formPanel = new JPanel(
                new GridLayout(4, 2, 20, 20)
        );

        formPanel.setOpaque(false);

        formPanel.setBorder(
                new EmptyBorder(40, 0, 0, 0)
        );

        fullNameField = createTextField(fullName);

        emailField = createTextField(email);

        phoneField = createTextField(phone);

        formPanel.add(createLabel("Full Name"));

        formPanel.add(fullNameField);

        formPanel.add(createLabel("Email"));

        formPanel.add(emailField);

        formPanel.add(createLabel("Phone"));

        formPanel.add(phoneField);

        // ================= SAVE BUTTON =================

        JButton saveBtn = new JButton("Save Information");

        saveBtn.setBackground(new Color(0, 153, 255));

        saveBtn.setForeground(Color.WHITE);

        saveBtn.setFont(new Font("SansSerif", Font.BOLD, 16));

        saveBtn.setFocusPainted(false);

        saveBtn.setBorder(new RoundedButtonBorder(20));

        saveBtn.addActionListener(e -> {

            String updatedName = fullNameField.getText();

            String updatedEmail = emailField.getText();

            String updatedPhone = phoneField.getText();

            displayName.setText(updatedName);

            displayEmail.setText(updatedEmail);

            displayPhone.setText(updatedPhone);

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

        // ================= MAIN LAYOUT =================

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

    // ================= TEXT FIELD =================

    private JTextField createTextField(String text) {

        JTextField field = new JTextField(text);

        field.setBackground(new Color(25, 45, 85));

        field.setForeground(Color.WHITE);

        field.setCaretColor(Color.WHITE);

        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(0, 153, 255),
                        1
                ),
                BorderFactory.createEmptyBorder(
                        12,
                        12,
                        12,
                        12
                )
        ));

        field.setFont(new Font("SansSerif", Font.PLAIN, 15));

        return field;
    }

    // ================= ROUND IMAGE =================

    private Image makeRoundedImage(Image image, int size) {

        BufferedImage output = new BufferedImage(
                size,
                size,
                BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D g2 = output.createGraphics();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setClip(new Ellipse2D.Float(
                0,
                0,
                size,
                size
        ));

        g2.drawImage(
                image,
                0,
                0,
                size,
                size,
                null
        );

        g2.dispose();

        return output;
    }
}

// ================= ROUNDED CARD BORDER =================

class RoundedBorder implements javax.swing.border.Border {

    private int radius;

    private Color color;

    RoundedBorder(int radius, Color color) {

        this.radius = radius;

        this.color = color;
    }

    @Override
    public Insets getBorderInsets(Component c) {

        return new Insets(
                radius + 1,
                radius + 1,
                radius + 1,
                radius + 1
        );
    }

    @Override
    public boolean isBorderOpaque() {

        return false;
    }

    @Override
    public void paintBorder(
            Component c,
            Graphics g,
            int x,
            int y,
            int width,
            int height
    ) {

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(color);

        g2.setStroke(new BasicStroke(2));

        g2.drawRoundRect(
                x + 1,
                y + 1,
                width - 3,
                height - 3,
                radius,
                radius
        );
    }
}

// ================= ROUNDED BUTTON BORDER =================

class RoundedButtonBorder implements javax.swing.border.Border {

    private int radius;

    RoundedButtonBorder(int radius) {

        this.radius = radius;
    }

    @Override
    public Insets getBorderInsets(Component c) {

        return new Insets(10, 20, 10, 20);
    }

    @Override
    public boolean isBorderOpaque() {

        return true;
    }

    @Override
    public void paintBorder(
            Component c,
            Graphics g,
            int x,
            int y,
            int width,
            int height
    ) {

        g.drawRoundRect(
                x,
                y,
                width - 1,
                height - 1,
                radius,
                radius
        );
    }
}