import javax.swing.SwingUtilities;

import GUI.BookAFlight;
import GUI.Homepage;

public class main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookAFlight().createUI());
    }

}