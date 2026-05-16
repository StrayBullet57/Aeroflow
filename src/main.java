import GUI.MainContent;
import javax.swing.SwingUtilities;
import transactions.Payment;

public class main{
    public static void main(String[] args) {

        Payment userPayment = Payment.createPaymentFromInput();
        
        userPayment.processPayment();
        System.out.println(userPayment);
        System.out.println("\n=== CLOSING PAYMENT TEST, LAUNCHING SYSTEM GUI ===\n");

        SwingUtilities.invokeLater(() -> new MainContent().start());
    }

}