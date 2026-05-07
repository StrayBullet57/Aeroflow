package GUI;

import javax.swing.*;
import java.awt.*;

import GUI.Builders.NavBar;

public class MainContent {

    private JFrame frame;
    private JPanel contentPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainContent().start());
    }

    public void start() {
        frame = new JFrame("AeroFlow");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        contentPanel = new JPanel(new BorderLayout());

        JPanel navBar = NavBar.createNavBar(this);
        mainPanel.add(navBar, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        frame.setContentPane(mainPanel);

        // load first page
        showPage(Homepage.getPanel());

        frame.setVisible(true);
    }

    public void showPage(JPanel page) {
        contentPanel.removeAll();
        contentPanel.add(page, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}