import GUI.Login.LoginPage;
import javax.swing.SwingUtilities;
public class main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage().start());
    }
} 