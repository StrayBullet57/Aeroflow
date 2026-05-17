import GUI.MainContent;
import javax.swing.SwingUtilities;
import models.Flight;
import transactions.Payment;

public class main{
    public static void main(String[] args) {

        // ========================================================
        // 💳 TEST 1: PAYMENT TESTING SECTION
        // ========================================================

        Payment userPayment = Payment.createPaymentFromInput();
        
        userPayment.processPayment();
        System.out.println(userPayment);
        System.out.println("\n=== CLOSING PAYMENT TEST, LAUNCHING SYSTEM GUI ===\n");

        // ========================================================
        // ✈️ TEST 2: ENCAPSULATED SEAT SELECTION TERMINAL
        // ========================================================

        Flight testFlight = new Flight("AF-101", null, null, 5500.00, "ON TIME", null);
        
        testFlight.startInteractiveSeatSelection(); 
        System.out.println("\n=== CLOSING SEAT TEST, LAUNCHING SYSTEM GUI ===\n");

        SwingUtilities.invokeLater(() -> new MainContent().start());
    }

}