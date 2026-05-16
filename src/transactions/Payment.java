package transactions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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