package transactions;
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
    private String paymentDate;

    public Payment(String paymentID, String bookingID, double amount, String paymentDate){
        this.paymentID = paymentID;
        this.bookingID = bookingID;
        this.amount = amount;
        this.paymentDate = paymentDate;
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