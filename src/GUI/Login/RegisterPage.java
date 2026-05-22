package GUI.Login;

import users.User;
import users.UserStore;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import users.SessionManager;
public class RegisterPage {

    private JFrame frame;

    public void start() {

        frame = new JFrame("AeroFlow – Register");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        LoginPage.GradientPanel hero = new LoginPage.GradientPanel();
        hero.setLayout(new GridBagLayout());

        JPanel card = new JPanel(new GridBagLayout());

        card.setBackground(Color.WHITE);

        card.setBorder(new CompoundBorder(
            new LineBorder(new Color(220, 220, 220), 1, true),
            new EmptyBorder(32, 40, 28, 40)
        ));

        card.setPreferredSize(new Dimension(460, 760));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 0);

        // LOGO
        ImageIcon logoIcon = new ImageIcon("src/images/AEROFLOWBNW.png");

        Image rawImg = logoIcon.getImage();

        int baseWidth = 340;

        int baseHeight = rawImg.getHeight(null);

        if (rawImg.getWidth(null) > 0) {

            baseHeight = (int) (
                baseHeight *
                ((double) baseWidth / rawImg.getWidth(null))
            );

        } else {

            baseHeight = 150;
        }

        BufferedImage tintedImg = new BufferedImage(
            baseWidth,
            baseHeight,
            BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D g2d = tintedImg.createGraphics();

        g2d.setRenderingHint(
            RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR
        );

        g2d.drawImage(rawImg, 0, 0, baseWidth, baseHeight, null);

        g2d.dispose();

        int targetRGB = new Color(0x14, 0x77, 0xB2)
            .getRGB() & 0x00FFFFFF;

        for (int y = 0; y < tintedImg.getHeight(); y++) {

            for (int x = 0; x < tintedImg.getWidth(); x++) {

                int argb = tintedImg.getRGB(x, y);

                int a = (argb >> 24) & 0xFF;
                int r = (argb >> 16) & 0xFF;
                int g = (argb >> 8) & 0xFF;
                int b = argb & 0xFF;

                int brightness = (r + g + b) / 3;

                if (brightness > 30) {

                    int alphaOut = (int) (
                        a * (brightness / 255.0)
                    );

                    tintedImg.setRGB(
                        x,
                        y,
                        (alphaOut << 24) | targetRGB
                    );
                }
            }
        }

        JLabel logoLabel = new JLabel(new ImageIcon(tintedImg));

        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        card.add(logoLabel, gbc);

        gbc.gridy++;

        // HEADING
        gbc.insets = new Insets(10, 0, 0, 0);

        JLabel heading = new JLabel(
            "Create your account",
            SwingConstants.CENTER
        );

        heading.setFont(new Font("SansSerif", Font.BOLD, 20));

        heading.setForeground(new Color(17, 24, 39));

        card.add(heading, gbc);

        gbc.gridy++;

        // FIRST + LAST NAME
        gbc.insets = new Insets(16, 0, 0, 0);

        gbc.gridwidth = 1;
        gbc.weightx = 0.5;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;

        card.add(makeLabel("First name"), gbc);

        gbc.gridx = 1;

        gbc.insets = new Insets(16, 8, 0, 0);

        card.add(makeLabel("Last name"), gbc);

        gbc.gridy++;

        gbc.insets = new Insets(4, 0, 0, 0);

        gbc.gridx = 0;

        JTextField fnameField = makeTextField("Juan");

        card.add(fnameField, gbc);

        gbc.gridx = 1;

        gbc.insets = new Insets(4, 8, 0, 0);

        JTextField lnameField = makeTextField("Dela Cruz");

        card.add(lnameField, gbc);

        gbc.gridy++;

        // FULL WIDTH AGAIN
        gbc.gridx = 0;

        gbc.gridwidth = 2;
        gbc.weightx = 1.0;

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // EMAIL
        gbc.insets = new Insets(12, 0, 4, 0);

        card.add(makeLabel("Email address"), gbc);

        gbc.gridy++;

        gbc.insets = new Insets(0, 0, 0, 0);

        JTextField emailField = makeTextField("you@example.com");

        card.add(emailField, gbc);

        gbc.gridy++;

        // PHONE
        gbc.insets = new Insets(10, 0, 4, 0);

        card.add(makeLabel("Phone number"), gbc);

        gbc.gridy++;

        gbc.insets = new Insets(0, 0, 0, 0);

        JTextField phoneField = makeTextField("+63 912 345 6789");

        card.add(phoneField, gbc);

        gbc.gridy++;

        // PASSWORD
        gbc.insets = new Insets(10, 0, 4, 0);

        card.add(makeLabel("Password"), gbc);

        gbc.gridy++;

        gbc.insets = new Insets(0, 0, 0, 0);

        JPasswordField passField = makePasswordField();

        card.add(passField, gbc);

        gbc.gridy++;

        // STRENGTH BAR
        gbc.insets = new Insets(6, 0, 0, 0);

        JProgressBar strengthBar = new JProgressBar(0, 4);

        strengthBar.setPreferredSize(new Dimension(0, 5));

        strengthBar.setBorderPainted(false);

        strengthBar.setBackground(new Color(229, 231, 235));

        strengthBar.setForeground(new Color(239, 68, 68));

        strengthBar.setValue(0);

        card.add(strengthBar, gbc);

        gbc.gridy++;

        gbc.insets = new Insets(4, 0, 0, 0);

        JLabel strengthHint = new JLabel(
            "Use letters, numbers, and symbols."
        );

        strengthHint.setFont(new Font("SansSerif", Font.PLAIN, 11));

        strengthHint.setForeground(new Color(156, 163, 175));

        card.add(strengthHint, gbc);

        gbc.gridy++;

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
                    new Color(229,231,235),
                    new Color(239,68,68),
                    new Color(245,158,11),
                    new Color(59,130,246),
                    new Color(34,197,94)
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

        // CONFIRM PASSWORD
        gbc.insets = new Insets(10, 0, 4, 0);

        card.add(makeLabel("Confirm password"), gbc);

        gbc.gridy++;

        gbc.insets = new Insets(0, 0, 0, 0);

        JPasswordField confirmField = makePasswordField();

        card.add(confirmField, gbc);

        gbc.gridy++;

        // CREATE ACCOUNT BUTTON
        gbc.insets = new Insets(16, 0, 0, 0);

        JButton registerBtn = makeButton(
            "Create Account",
            new Color(21, 101, 192),
            Color.WHITE
        );

        registerBtn.addActionListener(e -> {

            String fname   = fnameField.getText().trim();
            String lname   = lnameField.getText().trim();

            String email   = emailField.getText().trim();
            String phone   = phoneField.getText().trim();

            String pass    = new String(
                passField.getPassword()
            ).trim();

            String confirm = new String(
                confirmField.getPassword()
            ).trim();

            if (fname.isEmpty() ||
                fname.equals("Juan") ||

                lname.isEmpty() ||
                lname.equals("Dela Cruz") ||

                email.isEmpty() ||
                email.equals("you@example.com") ||

                phone.isEmpty() ||
                phone.equals("+63 912 345 6789") ||

                pass.isEmpty()) {

                JOptionPane.showMessageDialog(
                    frame,
                    "Please fill in all required fields.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            if (!pass.equals(confirm)) {

                JOptionPane.showMessageDialog(
                    frame,
                    "Passwords do not match.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            if (UserStore.emailExists(email)) {

                JOptionPane.showMessageDialog(
                    frame,
                    "An account with that email already exists.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            String fullName = fname + " " + lname;

            User newUser = new User(
                UserStore.generateID(),
                fullName,
                email,
                pass,
                phone
            );

            newUser.register();

            UserStore.addUser(newUser);

            SessionManager.login(newUser);
            
            JOptionPane.showMessageDialog(
                frame,
                "Account created! Welcome, " +
                fullName +
                ". Please log in.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
            );

            frame.dispose();

            new LoginPage().start();
        });

        card.add(registerBtn, gbc);

        gbc.gridy++;

        // DIVIDER
        gbc.insets = new Insets(14, 0, 14, 0);

        card.add(makeDivider("or"), gbc);

        gbc.gridy++;

        // GUEST BUTTON
        gbc.insets = new Insets(0, 0, 0, 0);

        JButton guestBtn = makeOutlineButton(
            "Continue as Guest"
        );

        guestBtn.addActionListener(e -> {

            frame.dispose();

            new GUI.MainContent().start();
        });

        card.add(guestBtn, gbc);

        gbc.gridy++;

        // LOGIN ROW
        gbc.insets = new Insets(12, 0, 0, 0);

        gbc.fill = GridBagConstraints.NONE;

        gbc.anchor = GridBagConstraints.CENTER;

        JPanel loginRow = new JPanel(
            new FlowLayout(FlowLayout.CENTER, 4, 0)
        );

        loginRow.setBackground(Color.WHITE);

        JLabel loginText = new JLabel(
            "Already have an account?"
        );

        loginText.setFont(
            new Font("SansSerif", Font.PLAIN, 13)
        );

        loginText.setForeground(
            new Color(107, 114, 128)
        );

        JButton loginLink = new JButton("Log in");

        loginLink.setFont(
            new Font("SansSerif", Font.BOLD, 13)
        );

        loginLink.setForeground(
            new Color(30, 136, 229)
        );

        loginLink.setContentAreaFilled(false);

        loginLink.setBorderPainted(false);

        loginLink.setFocusPainted(false);

        loginLink.setCursor(
            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        loginLink.setMargin(new Insets(0, 0, 0, 0));

        loginLink.addActionListener(e -> {

            frame.dispose();

            new LoginPage().start();
        });

        loginRow.add(loginText);

        loginRow.add(loginLink);

        card.add(loginRow, gbc);

        // SCROLL
        JScrollPane scroll = new JScrollPane(card);

        scroll.setBorder(null);

        scroll.setOpaque(false);

        scroll.getViewport().setOpaque(false);

        scroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        scroll.getVerticalScrollBar().setUnitIncrement(12);

        scroll.setPreferredSize(new Dimension(480, 700));

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

        pf.setPreferredSize(new Dimension(0, 40));

        pf.setBorder(new CompoundBorder(
            new LineBorder(new Color(209, 213, 219), 1, true),
            new EmptyBorder(4, 10, 4, 10)
        ));

        pf.setBackground(new Color(249, 250, 251));

        return pf;
    }

    private JButton makeButton(
        String text,
        Color bg,
        Color fg
    ) {

        JButton btn = new JButton(text) {

            protected void paintComponent(Graphics g) {

                Graphics2D g2 = (Graphics2D) g.create();

                g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
                );

                g2.setColor(bg);

                g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    8,
                    8
                );

                g2.dispose();

                super.paintComponent(g);
            }
        };

        btn.setForeground(fg);

        btn.setFont(new Font("SansSerif", Font.BOLD, 15));

        btn.setContentAreaFilled(false);

        btn.setBorderPainted(false);

        btn.setFocusPainted(false);

        btn.setCursor(
            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        btn.setPreferredSize(new Dimension(0, 44));

        return btn;
    }

    private JButton makeOutlineButton(String text) {

        JButton btn = new JButton(text) {

            protected void paintComponent(Graphics g) {

                Graphics2D g2 = (Graphics2D) g.create();

                g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
                );

                g2.setColor(Color.WHITE);

                g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    8,
                    8
                );

                g2.setColor(new Color(209, 213, 219));

                g2.setStroke(new BasicStroke(1.5f));

                g2.drawRoundRect(
                    0,
                    0,
                    getWidth() - 1,
                    getHeight() - 1,
                    8,
                    8
                );

                g2.dispose();

                super.paintComponent(g);
            }
        };

        btn.setForeground(new Color(55, 65, 81));

        btn.setFont(new Font("SansSerif", Font.BOLD, 14));

        btn.setContentAreaFilled(false);

        btn.setBorderPainted(false);

        btn.setFocusPainted(false);

        btn.setCursor(
            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        btn.setPreferredSize(new Dimension(0, 42));

        return btn;
    }

    private JPanel makeDivider(String text) {

        JPanel p = new JPanel(new BorderLayout(8, 0));

        p.setBackground(Color.WHITE);

        JSeparator left = new JSeparator();

        left.setForeground(new Color(229, 231, 235));

        JSeparator right = new JSeparator();

        right.setForeground(new Color(229, 231, 235));

        JLabel lbl = new JLabel(
            text,
            SwingConstants.CENTER
        );

        lbl.setFont(new Font("SansSerif", Font.PLAIN, 12));

        lbl.setForeground(new Color(156, 163, 175));

        p.add(left, BorderLayout.WEST);

        p.add(lbl, BorderLayout.CENTER);

        p.add(right, BorderLayout.EAST);

        return p;
    }
}