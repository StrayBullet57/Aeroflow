package transactions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Payment {
   
    public enum PaymentMethod {
        CREDIT_CARD, 
        DEBIT_CARD, 
        PAYPAL, 
        GCASH, 
        MAYA
    }

    public enum PaymentStatus {
        PENDING, 
        SUCCESSFUL, 
        FAILED, 
        REFUNDED
    }

    private String paymentID;
    private String bookingID;
    private double amount;
    private PaymentMethod method;
    private PaymentStatus status;
    private LocalDateTime paymentDate;

    public Payment(String paymentID, String bookingID, double amount, PaymentMethod method){
        this.paymentID = paymentID;
        this.bookingID = bookingID;
        this.amount = amount;
        this.method = method;
        this.status = PaymentStatus.PENDING;
        this.paymentDate = LocalDateTime.now();
    }

    public static Payment createPaymentFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== AEROFLOW PAYMENT TERMINAL INTERFACE ===");

        System.out.print("Enter Payment ID (e.g., PMT-101): ");
        String pID = scanner.nextLine();

        System.out.print("Enter Booking ID (e.g., BK-552): ");
        String bID = scanner.nextLine();

        System.out.print("Enter Amount to Pay: ");
        double amt = scanner.nextDouble();
        scanner.nextLine(); // Consume remaining newline

        System.out.println("\nSelect Payment Method:");
        System.out.println("[1] CREDIT_CARD\n[2] DEBIT_CARD\n[3] PAYPAL\n[4] GCASH\n[5] MAYA");
        System.out.print("Enter choice (1-5): ");
        int choice = scanner.nextInt();

        PaymentMethod selectedMethod;
        switch (choice) {
            case 1: selectedMethod = PaymentMethod.CREDIT_CARD; break;
            case 2: selectedMethod = PaymentMethod.DEBIT_CARD; break;
            case 3: selectedMethod = PaymentMethod.PAYPAL; break;
            case 4: selectedMethod = PaymentMethod.GCASH; break;
            case 5: selectedMethod = PaymentMethod.MAYA; break;
            default:
                System.out.println("Invalid choice! Defaulting to GCASH.");
                selectedMethod = PaymentMethod.GCASH;
                break;
        }
        
        System.out.println("-------------------------------------------");
        return new Payment(pID, bID, amt, selectedMethod);
    }
 
    public boolean processPayment() {
        if (amount <= 0) {
            this.status = PaymentStatus.FAILED;
            System.out.println("Payment Failed: Invalid amount ($" + amount + ").");
            return false;
        }
         this.status = PaymentStatus.SUCCESSFUL;
        System.out.println("Processing " + method + " payment of $" + amount + " for Booking " + bookingID + "...");
        System.out.println("Payment Successful! Transaction ID: " + paymentID);
        return true;
    }

    public String getPaymentID() { return paymentID; }
    public String getBookingID() { return bookingID; }
    
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public PaymentMethod getMethod() { return method; }
    public void setMethod(PaymentMethod method) { this.method = method; }

    public PaymentStatus getStatus() { return status; }
    
    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return paymentDate.format(formatter);
    }

     @Override
    public String toString() {
        return "===================================\n" +
               "         AEROFLOW RECEIPT          \n" +
               "===================================\n" +
               "Payment ID:     " + paymentID + "\n" +
               "Booking ID:     " + bookingID + "\n" +
               "Amount Paid:    $" + amount + "\n" +
               "Method:         " + method + "\n" +
               "Status:         " + status + "\n" +
               "Date/Time:      " + getFormattedDate() + "\n" +
               "===================================";
    }
}