package GUI.Login;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

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

        // HERO
        GradientPanel hero = new GradientPanel();
        hero.setLayout(new GridBagLayout());

        // CARD
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
            new LineBorder(new Color(220, 220, 220), 1, true),
            new EmptyBorder(36, 40, 32, 40)
        ));
        card.setPreferredSize(new Dimension(420, 440)); // reduced height since forgot pw removed

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 0, 0, 0);

        // Logo
        JLabel logoIcon = new JLabel("✈", SwingConstants.CENTER);
        logoIcon.setFont(new Font("SansSerif", Font.PLAIN, 36));
        logoIcon.setForeground(new Color(21, 101, 192));
        card.add(logoIcon, gbc); gbc.gridy++;

        gbc.insets = new Insets(4, 0, 0, 0);
        JLabel logoText = new JLabel("AEROFLOW", SwingConstants.CENTER);
        logoText.setFont(new Font("SansSerif", Font.BOLD, 26));
        logoText.setForeground(new Color(21, 101, 192));
        card.add(logoText, gbc); gbc.gridy++;

        gbc.insets = new Insets(14, 0, 0, 0);
        JLabel heading = new JLabel("Welcome back", SwingConstants.CENTER);
        heading.setFont(new Font("SansSerif", Font.BOLD, 20));
        heading.setForeground(new Color(17, 24, 39));
        card.add(heading, gbc); gbc.gridy++;

        // Email label
        gbc.insets = new Insets(20, 0, 4, 0);
        JLabel emailLabel = makeLabel("Email address");
        card.add(emailLabel, gbc); gbc.gridy++;

        // Email field
        gbc.insets = new Insets(0, 0, 0, 0);
        JTextField emailField = makeTextField("you@example.com");
        card.add(emailField, gbc); gbc.gridy++;

        // Password label
        gbc.insets = new Insets(12, 0, 4, 0);
        JLabel passLabel = makeLabel("Password");
        card.add(passLabel, gbc); gbc.gridy++;

        // Password field
        gbc.insets = new Insets(0, 0, 0, 0);
        JPasswordField passField = makePasswordField();
        card.add(passField, gbc); gbc.gridy++;

        // ── "Forgot password?" REMOVED ──

        // Login button
        gbc.insets = new Insets(14, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton loginBtn = makeButton("Log In", new Color(21, 101, 192), Color.WHITE);
        loginBtn.addActionListener(e -> {
            String email = emailField.getText().trim();
            String pass  = new String(passField.getPassword()).trim();
            if (email.isEmpty() || email.equals("you@example.com") || pass.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                frame.dispose();
                new GUI.MainContent().start();
            }
        });
        card.add(loginBtn, gbc); gbc.gridy++;

        // Divider
        gbc.insets = new Insets(14, 0, 14, 0);
        card.add(makeDivider("or"), gbc); gbc.gridy++;

        // Guest button
        gbc.insets = new Insets(0, 0, 0, 0);
        JButton guestBtn = makeOutlineButton("Continue as Guest");
        guestBtn.addActionListener(e -> { frame.dispose(); new GUI.MainContent().start(); });
        card.add(guestBtn, gbc); gbc.gridy++;

        // Sign up row — FIX: use a JButton styled as a link for reliable clicks
        gbc.insets = new Insets(14, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel regRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 0));
        regRow.setBackground(Color.WHITE);

        JLabel regText = new JLabel("Don't have an account?");
        regText.setFont(new Font("SansSerif", Font.PLAIN, 13));
        regText.setForeground(new Color(107, 114, 128));

        // Use a borderless JButton instead of JLabel for reliable click detection
        JButton regLink = new JButton("Sign up");
        regLink.setFont(new Font("SansSerif", Font.BOLD, 13));
        regLink.setForeground(new Color(30, 136, 229));
        regLink.setContentAreaFilled(false);
        regLink.setBorderPainted(false);
        regLink.setFocusPainted(false);
        regLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regLink.setMargin(new Insets(0, 0, 0, 0));
        regLink.addActionListener(e -> { frame.dispose(); new RegisterPage().start(); });
        regRow.add(regText);
        regRow.add(regLink);
        card.add(regRow, gbc);

        // Scroll wrapper
        JScrollPane scroll = new JScrollPane(card);
        scroll.setBorder(null);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUnitIncrement(12);
        scroll.setPreferredSize(new Dimension(440, 480));

        hero.add(scroll);
        frame.add(hero, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JLabel makeLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("SansSerif", Font.BOLD, 13));
        lbl.setForeground(new Color(55, 65, 81));
        return lbl;
    }

    private JTextField makeTextField(String placeholder) {
        JTextField tf = new JTextField();
        tf.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tf.setPreferredSize(new Dimension(0, 40));
        tf.setBorder(new CompoundBorder(
            new LineBorder(new Color(209, 213, 219), 1, true),
            new EmptyBorder(4, 10, 4, 10)
        ));
        tf.setBackground(new Color(249, 250, 251));
        tf.setForeground(new Color(156, 163, 175));
        tf.setText(placeholder);
        tf.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (tf.getText().equals(placeholder)) { tf.setText(""); tf.setForeground(new Color(17, 24, 39)); }
            }
            public void focusLost(FocusEvent e) {
                if (tf.getText().isEmpty()) { tf.setText(placeholder); tf.setForeground(new Color(156, 163, 175)); }
            }
        });
        return tf;
    }

    private JPasswordField makePasswordField() {
        JPasswordField pf = new JPasswordField();
        pf.setFont(new Font("SansSerif", Font.PLAIN, 14));
        pf.setPreferredSize(new Dimension(0, 40));
        pf.setBorder(new CompoundBorder(
            new LineBorder(new Color(209, 213, 219), 1, true),
            new EmptyBorder(4, 10, 4, 10)
        ));
        pf.setBackground(new Color(249, 250, 251));
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
        btn.setPreferredSize(new Dimension(0, 44));
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
        btn.setPreferredSize(new Dimension(0, 42));
        return btn;
    }

    private JPanel makeDivider(String text) {
        JPanel p = new JPanel(new BorderLayout(8, 0));
        p.setBackground(Color.WHITE);
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

    static class GradientPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            GradientPaint gp = new GradientPaint(0, 0, new Color(21, 101, 192), getWidth(), getHeight(), new Color(13, 71, 161));
            g2.setPaint(gp);
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}