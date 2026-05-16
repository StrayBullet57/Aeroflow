package transactions;

import java.time.LocalDateTime;

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

    public boolean processPayment(){
        System.out.println("Payment Successful.");
        return true;
    }
    @Override
    public String toString(){
        return "Payment ID: " + paymentID + " Amount: " + amount;
    }
}