import GUI.MainContent;
import javax.swing.SwingUtilities;
import transactions.Payment;

public class main{
    public static void main(String[] args) {

        System.out.println("--- RUNNING AEROFLOW PAYMENT TEST ---");

        Payment testPayment1 = new Payment("PMT-001", "BK-9982", 4500.50, Payment.PaymentMethod.GCASH);

        testPayment1.processPayment();

        System.out.println(testPayment1);
        System.out.println();

        Payment testPayment2 = new Payment("PMT-002", "BK-1104", -50.0, Payment.PaymentMethod.CREDIT_CARD);
        testPayment2.processPayment();
        System.out.println(testPayment2);

        System.out.println("--- END OF PAYMENT TEST, LAUNCHING GUI ---\n");

        SwingUtilities.invokeLater(() -> new MainContent().start());
    }

}