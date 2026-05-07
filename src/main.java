import javax.swing.SwingUtilities;

import GUI.BookAFlight;
import GUI.Homepage;
import GUI.MainContent;

public class main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainContent().start());
    }

}