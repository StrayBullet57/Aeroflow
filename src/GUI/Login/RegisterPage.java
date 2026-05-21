package GUI.Login;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPage {

    private JFrame frame;

    public void start() {
        frame = new JFrame("AeroFlow – Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        // ── NAVBAR ──
        JPanel navBar = new JPanel(new GridLayout(1, 4));
        navBar.setBackground(new Color(17, 24, 39));
        navBar.setPreferredSize(new Dimension(0, 60));
        String[] navItems = {"Home", "Book", "Flights", "Profile"};
        for (String item : navItems) {
            JLabel lbl = new JLabel(item, SwingConstants.CENTER);
            lbl.setForeground(new Color(229, 231, 235));
            lbl.setFont(new Font("SansSerif", Font.BOLD, 14));
            lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lbl.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) { lbl.setForeground(new Color(96, 165, 250)); }
                public void mouseExited(MouseEvent e)  { lbl.setForeground(new Color(229, 231, 235)); }
            });
            navBar.add(lbl);
        }
        frame.add(navBar, BorderLayout.NORTH);

        // ── HERO BACKGROUND ──
        LoginPage.GradientPanel hero = new LoginPage.GradientPanel();
        hero.setLayout(new GridBagLayout());

        // ── CARD ──
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
            new LineBorder(new Color(220, 220, 220), 1, true),
            new EmptyBorder(32, 40, 28, 40)
        ));
        card.setPreferredSize(new Dimension(460, 640));
        card.setMaximumSize(new Dimension(460, 700));

        // Logo
        JLabel logoIcon = new JLabel("✈", SwingConstants.CENTER);
        logoIcon.setFont(new Font("SansSerif", Font.PLAIN, 30));
        logoIcon.setForeground(new Color(21, 101, 192));
        logoIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel logoText = new JLabel("AEROFLOW", SwingConstants.CENTER);
        logoText.setFont(new Font("SansSerif", Font.BOLD, 24));
        logoText.setForeground(new Color(21, 101, 192));
        logoText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel heading = new JLabel("Create your account", SwingConstants.CENTER);
        heading.setFont(new Font("SansSerif", Font.BOLD, 20));
        heading.setForeground(new Color(17, 24, 39));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        // First + Last name row
        JPanel nameRow = new JPanel(new GridLayout(1, 2, 12, 0));
        nameRow.setBackground(Color.WHITE);
        nameRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        nameRow.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel fnameCol = new JPanel();
        fnameCol.setLayout(new BoxLayout(fnameCol, BoxLayout.Y_AXIS));
        fnameCol.setBackground(Color.WHITE);
        fnameCol.add(makeLabel("First name"));
        fnameCol.add(Box.createVerticalStrut(4));
        JTextField fnameField = makePlainTextField("Juan");
        fnameCol.add(fnameField);

        JPanel lnameCol = new JPanel();
        lnameCol.setLayout(new BoxLayout(lnameCol, BoxLayout.Y_AXIS));
        lnameCol.setBackground(Color.WHITE);
        lnameCol.add(makeLabel("Last name"));
        lnameCol.add(Box.createVerticalStrut(4));
        JTextField lnameField = makePlainTextField("Dela Cruz");
        lnameCol.add(lnameField);

        nameRow.add(fnameCol);
        nameRow.add(lnameCol);

        // Email
        JLabel emailLabel = makeLabel("Email address");
        JTextField emailField = makePlainTextField("you@example.com");

        // Phone
        JLabel phoneLabel = makeLabel("Phone number");
        JTextField phoneField = makePlainTextField("+63 912 345 6789");

        // Password
        JLabel passLabel = makeLabel("Password");
        JPasswordField passField = makePasswordField();

        // Strength bar
        JProgressBar strengthBar = new JProgressBar(0, 4);
        strengthBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 5));
        strengthBar.setPreferredSize(new Dimension(0, 5));
        strengthBar.setBorderPainted(false);
        strengthBar.setBackground(new Color(229, 231, 235));
        strengthBar.setForeground(new Color(239, 68, 68));
        strengthBar.setValue(0);

        JLabel strengthHint = new JLabel("Use letters, numbers, and symbols.");
        strengthHint.setFont(new Font("SansSerif", Font.PLAIN, 11));
        strengthHint.setForeground(new Color(156, 163, 175));
        strengthHint.setAlignmentX(Component.LEFT_ALIGNMENT);

        passField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String p = new String(passField.getPassword());
                int score = 0;
                if (p.length() >= 8) score++;
                if (p.matches(".*[A-Z].*")) score++;
                if (p.matches(".*[0-9].*")) score++;
                if (p.matches(".*[^A-Za-z0-9].*")) score++;
                strengthBar.setValue(score);
                Color[] colors = {
                    new Color(229, 231, 235),
                    new Color(239, 68, 68),
                    new Color(245, 158, 11),
                    new Color(59, 130, 246),
                    new Color(34, 197, 94)
                };
                String[] hints = {
                    "Use letters, numbers, and symbols.",
                    "Weak – try adding numbers or symbols.",
                    "Fair – add uppercase letters.",
                    "Good – almost there!",
                    "Strong password ✓"
                };
                strengthBar.setForeground(colors[score]);
                strengthHint.setText(hints[score]);
            }
        });

        // Confirm password
        JLabel confirmLabel = makeLabel("Confirm password");
        JPasswordField confirmField = makePasswordField();

        // Terms checkbox
        JPanel termsRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        termsRow.setBackground(Color.WHITE);
        termsRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        JCheckBox termsBox = new JCheckBox();
        termsBox.setBackground(Color.WHITE);
        JLabel termsText = new JLabel("<html>I agree to the <font color='#1e88e5'>Terms of Service</font> and <font color='#1e88e5'>Privacy Policy</font></html>");
        termsText.setFont(new Font("SansSerif", Font.PLAIN, 12));
        termsRow.add(termsBox);
        termsRow.add(termsText);

        // Register button
        JButton registerBtn = makeButton("Create Account", new Color(21, 101, 192), Color.WHITE);
        registerBtn.addActionListener(e -> {
            String fname   = fnameField.getText().trim();
            String lname   = lnameField.getText().trim();
            String email   = emailField.getText().trim();
            String phone   = phoneField.getText().trim();
            String pass    = new String(passField.getPassword()).trim();
            String confirm = new String(confirmField.getPassword()).trim();

            if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!pass.equals(confirm)) {
                JOptionPane.showMessageDialog(frame, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!termsBox.isSelected()) {
                JOptionPane.showMessageDialog(frame, "Please agree to the Terms of Service.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(frame, "Account created successfully! Please log in.", "Success", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            new LoginPage().start();
        });

        // Divider
        JPanel divider = makeDivider("or sign up with");

        // Google button
        JButton googleBtn = makeOutlineButton("Continue with Google");

        // Login link
        JPanel loginRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 0));
        loginRow.setBackground(Color.WHITE);
        loginRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        JLabel loginText = new JLabel("Already have an account?");
        loginText.setFont(new Font("SansSerif", Font.PLAIN, 13));
        loginText.setForeground(new Color(107, 114, 128));
        JLabel loginLink = new JLabel("Log in");
        loginLink.setFont(new Font("SansSerif", Font.BOLD, 13));
        loginLink.setForeground(new Color(30, 136, 229));
        loginLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLink.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new LoginPage().start();
            }
            public void mouseEntered(MouseEvent e) { loginLink.setText("<html><u>Log in</u></html>"); }
            public void mouseExited(MouseEvent e)  { loginLink.setText("Log in"); }
        });
        loginRow.add(loginText);
        loginRow.add(loginLink);

        // Assemble card
        card.add(logoIcon);
        card.add(Box.createVerticalStrut(4));
        card.add(logoText);
        card.add(Box.createVerticalStrut(12));
        card.add(heading);
        card.add(Box.createVerticalStrut(18));
        card.add(nameRow);
        card.add(Box.createVerticalStrut(12));
        card.add(emailLabel);
        card.add(Box.createVerticalStrut(4));
        card.add(emailField);
        card.add(Box.createVerticalStrut(10));
        card.add(phoneLabel);
        card.add(Box.createVerticalStrut(4));
        card.add(phoneField);
        card.add(Box.createVerticalStrut(10));
        card.add(passLabel);
        card.add(Box.createVerticalStrut(4));
        card.add(passField);
        card.add(Box.createVerticalStrut(6));
        card.add(strengthBar);
        card.add(Box.createVerticalStrut(4));
        card.add(strengthHint);
        card.add(Box.createVerticalStrut(10));
        card.add(confirmLabel);
        card.add(Box.createVerticalStrut(4));
        card.add(confirmField);
        card.add(Box.createVerticalStrut(10));
        card.add(termsRow);
        card.add(Box.createVerticalStrut(14));
        card.add(registerBtn);
        card.add(Box.createVerticalStrut(12));
        card.add(divider);
        card.add(Box.createVerticalStrut(12));
        card.add(googleBtn);
        card.add(Box.createVerticalStrut(12));
        card.add(loginRow);

        hero.add(card);
        frame.add(hero, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // ── HELPERS ──

    private JLabel makeLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("SansSerif", Font.BOLD, 13));
        lbl.setForeground(new Color(55, 65, 81));
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        return lbl;
    }

    private JTextField makePlainTextField(String placeholder) {
        JTextField tf = new JTextField();
        tf.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tf.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        tf.setBorder(new CompoundBorder(
            new LineBorder(new Color(209, 213, 219), 1, true),
            new EmptyBorder(4, 10, 4, 10)
        ));
        tf.setBackground(new Color(249, 250, 251));
        tf.setForeground(new Color(156, 163, 175));
        tf.setText(placeholder);
        tf.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (tf.getText().equals(placeholder)) {
                    tf.setText("");
                    tf.setForeground(new Color(17, 24, 39));
                }
            }
            public void focusLost(FocusEvent e) {
                if (tf.getText().isEmpty()) {
                    tf.setText(placeholder);
                    tf.setForeground(new Color(156, 163, 175));
                }
            }
        });
        return tf;
    }

    private JPasswordField makePasswordField() {
        JPasswordField pf = new JPasswordField();
        pf.setFont(new Font("SansSerif", Font.PLAIN, 14));
        pf.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        pf.setBorder(new CompoundBorder(
            new LineBorder(new Color(209, 213, 219), 1, true),
            new EmptyBorder(4, 10, 4, 10)
        ));
        pf.setBackground(new Color(249, 250, 251));
        pf.setAlignmentX(Component.LEFT_ALIGNMENT);
        return pf;
    }

    private JButton makeButton(String text, Color bg, Color fg) {
        JButton btn = new JButton(text) {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getModel().isRollover() ? bg.brighter() : bg);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setForeground(fg);
        btn.setFont(new Font("SansSerif", Font.BOLD, 15));
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));
        return btn;
    }

    private JButton makeOutlineButton(String text) {
        JButton btn = new JButton(text) {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getModel().isRollover() ? new Color(243, 244, 246) : Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                g2.setColor(new Color(209, 213, 219));
                g2.setStroke(new BasicStroke(1.5f));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 8, 8);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setForeground(new Color(55, 65, 81));
        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        return btn;
    }

    private JPanel makeDivider(String text) {
        JPanel p = new JPanel(new BorderLayout(8, 0));
        p.setBackground(Color.WHITE);
        p.setMaximumSize(new Dimension(Integer.MAX_VALUE, 24));
        JSeparator left  = new JSeparator(); left.setForeground(new Color(229, 231, 235));
        JSeparator right = new JSeparator(); right.setForeground(new Color(229, 231, 235));
        JLabel lbl = new JLabel(text, SwingConstants.CENTER);
        lbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lbl.setForeground(new Color(156, 163, 175));
        p.add(left,  BorderLayout.WEST);
        p.add(lbl,   BorderLayout.CENTER);
        p.add(right, BorderLayout.EAST);
        return p;
    }
}