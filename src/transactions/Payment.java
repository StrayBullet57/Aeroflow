package transactions;
public class Payment {
   
    private String paymentID;
    private String bookingID;
    private double amount;
    //private PaymentMethod method;
    //private PaymentStatus status;
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