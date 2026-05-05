package GUI;
import javax.swing.*;
import java.awt.*;

public class BookAFlight extends JFrame {

    public BookAFlight() {

        // Window setup
        setTitle("Book a Flight");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // THIS makes it resizable (default is true, but we set it explicitly)
        setResizable(true);

        // Layout manager (important for resizing)
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Components
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);

        JLabel fromLabel = new JLabel("From:");
        JTextField fromField = new JTextField(15);

        JLabel toLabel = new JLabel("To:");
        JTextField toField = new JTextField(15);

        JLabel dateLabel = new JLabel("Date:");
        JTextField dateField = new JTextField(15);

        JButton bookButton = new JButton("Book Flight");

        // Row 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        add(nameField, gbc);

        // Row 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(fromLabel, gbc);

        gbc.gridx = 1;
        add(fromField, gbc);

        // Row 3
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(toLabel, gbc);

        gbc.gridx = 1;
        add(toField, gbc);

        // Row 4
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(dateLabel, gbc);

        gbc.gridx = 1;
        add(dateField, gbc);

        // Button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(bookButton, gbc);

        // Window size
        setSize(400, 250);

        // Center screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BookAFlight();
    }
}