package GUI.Login;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class LoginPage {

    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage().start());
    }

    public void start() {
        frame = new JFrame("AeroFlow");
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
        GradientPanel hero = new GradientPanel();
        hero.setLayout(new GridBagLayout());

        // ── CARD ──
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
            new LineBorder(new Color(220, 220, 220), 1, true),
            new EmptyBorder(36, 40, 32, 40)
        ));
        card.setMaximumSize(new Dimension(420, 600));
        card.setPreferredSize(new Dimension(420, 520));

        // Logo
        JLabel logoIcon = new JLabel("✈", SwingConstants.CENTER);
        logoIcon.setFont(new Font("SansSerif", Font.PLAIN, 36));
        logoIcon.setForeground(new Color(21, 101, 192));
        logoIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel logoText = new JLabel("AEROFLOW", SwingConstants.CENTER);
        logoText.setFont(new Font("SansSerif", Font.BOLD, 26));
        logoText.setForeground(new Color(21, 101, 192));
        logoText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel heading = new JLabel("Welcome back", SwingConstants.CENTER);
        heading.setFont(new Font("SansSerif", Font.BOLD, 20));
        heading.setForeground(new Color(17, 24, 39));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Email field
        JLabel emailLabel = makeLabel("Email address");
        JTextField emailField = makeTextField("you@example.com");

        // Password field
        JLabel passLabel = makeLabel("Password");
        JPasswordField passField = new JPasswordField();
        passField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        passField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        passField.setBorder(new CompoundBorder(
            new LineBorder(new Color(209, 213, 219), 1, true),
            new EmptyBorder(4, 10, 4, 10)
        ));
        passField.setBackground(new Color(249, 250, 251));

        // Forgot password
        JLabel forgot = new JLabel("Forgot password?");
        forgot.setFont(new Font("SansSerif", Font.PLAIN, 12));
        forgot.setForeground(new Color(30, 136, 229));
        forgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgot.setAlignmentX(Component.RIGHT_ALIGNMENT);

        // Login button
        JButton loginBtn = makeButton("Log In", new Color(21, 101, 192), Color.WHITE);
        loginBtn.addActionListener(e -> {
            String email = emailField.getText().trim();
            String pass  = new String(passField.getPassword()).trim();
            if (email.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // TODO: replace with real auth — opens MainContent for now
                frame.dispose();
                new GUI.MainContent().start();
            }
        });

        // Divider
        JPanel divider = makeDivider("or continue with");

        // Google button
        JButton googleBtn = makeOutlineButton("Continue with Google");

        // Register link
        JPanel regRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 0));
        regRow.setBackground(Color.WHITE);
        regRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        JLabel regText = new JLabel("Don't have an account?");
        regText.setFont(new Font("SansSerif", Font.PLAIN, 13));
        regText.setForeground(new Color(107, 114, 128));
        JLabel regLink = new JLabel("Sign up");
        regLink.setFont(new Font("SansSerif", Font.BOLD, 13));
        regLink.setForeground(new Color(30, 136, 229));
        regLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regLink.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new RegisterPage().start();
            }
            public void mouseEntered(MouseEvent e) { regLink.setText("<html><u>Sign up</u></html>"); }
            public void mouseExited(MouseEvent e)  { regLink.setText("Sign up"); }
        });
        regRow.add(regText);
        regRow.add(regLink);

        // Assemble card
        card.add(logoIcon);
        card.add(Box.createVerticalStrut(4));
        card.add(logoText);
        card.add(Box.createVerticalStrut(16));
        card.add(heading);
        card.add(Box.createVerticalStrut(20));
        card.add(emailLabel);
        card.add(Box.createVerticalStrut(4));
        card.add(emailField);
        card.add(Box.createVerticalStrut(12));
        card.add(passLabel);
        card.add(Box.createVerticalStrut(4));
        card.add(passField);
        card.add(Box.createVerticalStrut(6));
        card.add(forgot);
        card.add(Box.createVerticalStrut(16));
        card.add(loginBtn);
        card.add(Box.createVerticalStrut(14));
        card.add(divider);
        card.add(Box.createVerticalStrut(14));
        card.add(googleBtn);
        card.add(Box.createVerticalStrut(14));
        card.add(regRow);

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

    private JTextField makeTextField(String placeholder) {
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
        btn.setPreferredSize(new Dimension(340, 44));
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
        btn.setPreferredSize(new Dimension(340, 42));
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

    // Blue gradient background panel
    static class GradientPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            GradientPaint gp = new GradientPaint(
                0, 0, new Color(21, 101, 192),
                getWidth(), getHeight(), new Color(13, 71, 161)
            );
            g2.setPaint(gp);
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}