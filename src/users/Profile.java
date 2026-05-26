package users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Profile {

    public enum MembershipLevel {

        REGULAR,

        SILVER,

        GOLD,

        PLATINUM
    }

   

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    private String address;

    private String nationality;

    private String preferredLanguage;

    private List<String> bookingHistory;

    private MembershipLevel membershipLevel;

    private int loyaltyPoints;

    private LocalDate accountCreationDate;

    private String securityQuestion;

    private String securityAnswer;

    private boolean isAccountActive;




    
    public Profile() {

        this.firstName = "Not Specified";

        this.lastName = "Not Specified";

        this.emailAddress = "unknown@aeroflow.com";

        this.phoneNumber = "000-000-0000";

        this.dateOfBirth = LocalDate.of(2000, 1, 1);
        
        this.address = "Not Provided";

        this.nationality = "Not Provided";

        this.preferredLanguage = "English";

        this.bookingHistory = new ArrayList<>();

        this.membershipLevel = MembershipLevel.REGULAR;

        this.loyaltyPoints = 0;

        this.accountCreationDate = LocalDate.now();

        this.securityQuestion = "What is your favorite city?";

        this.securityAnswer = "Cebu";

        this.isAccountActive = true;

    }

   


    public Profile(String firstName, String lastName, String emailAddress, 

                   String phoneNumber, LocalDate dateOfBirth) {

        this.firstName = firstName;


        this.lastName = lastName;


        this.setEmailAddress(emailAddress); 

        
        this.phoneNumber = phoneNumber;


        this.dateOfBirth = dateOfBirth;


        this.address = "Not Provided";


        this.nationality = "Not Provided";


        this.preferredLanguage = "English";


        this.bookingHistory = new ArrayList<>();


        this.membershipLevel = MembershipLevel.REGULAR;


        this.loyaltyPoints = 0;


        this.accountCreationDate = LocalDate.now();


        this.securityQuestion = "None";



        this.securityAnswer = "None";


        this.isAccountActive = true;


    }

   



    public void addBookingToHistory(String bookingReference) {

        if (bookingReference != null && !bookingReference.trim().isEmpty()) {

            this.bookingHistory.add(bookingReference);

            this.addLoyaltyPoints(100);

            this.evaluateMembershipTier();

        }

    }

    

    public void evaluateMembershipTier() {

        if (this.loyaltyPoints >= 1000) {

            this.membershipLevel = MembershipLevel.PLATINUM;



        } else if (this.loyaltyPoints >= 500) {

            this.membershipLevel = MembershipLevel.GOLD;

        } else if (this.loyaltyPoints >= 200) {

            this.membershipLevel = MembershipLevel.SILVER;

        } else {

            this.membershipLevel = MembershipLevel.REGULAR;

        }
    }

    

    public void addLoyaltyPoints(int points) {

        if (points > 0) {

            this.loyaltyPoints += points;

        }
    }

 

    public boolean redeemPoints(int points) {

        if (points > 0 && this.loyaltyPoints >= points) {

            this.loyaltyPoints -= points;

            this.evaluateMembershipTier();

            return true;

        }
        return false;

    }

   

    public boolean verifySecurityAnswer(String inputAnswer) {

        if (this.securityAnswer == null || inputAnswer == null) {

            return false;

        }
        return this.securityAnswer.equalsIgnoreCase(inputAnswer.trim());

    }

   

    public void deactivateAccount() {

        this.isAccountActive = false;

    }

    
    public void activateAccount() {

        this.isAccountActive = true;

    }

    
    public String getFirstName() {

        return firstName;

    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;

    }

    public String getLastName() {

        return lastName;

    }

    public void setLastName(String lastName) {

        this.lastName = lastName;

    }

    public String getFullName() {

        return firstName + " " + lastName;

    }

    public String getEmailAddress() {

        return emailAddress;

    }

    
    
    public void setEmailAddress(String emailAddress) 
    {

        if (emailAddress != null && emailAddress.contains("@") && emailAddress.contains(".")) {
           
            this.emailAddress = emailAddress;

        } 
        else
             {

            this.emailAddress = "invalid-format@aeroflow.com";
       
        }

    }

    public String getPhoneNumber() 
    {

        return phoneNumber;

    }

    public void setPhoneNumber(String phoneNumber) 
    {

        this.phoneNumber = phoneNumber;

    }

    public LocalDate getDateOfBirth()
     {

        return dateOfBirth;

    }

    public void setDateOfBirth(LocalDate dateOfBirth) 
    {

        this.dateOfBirth = dateOfBirth;

    }

    public String getAddress()
     {

        return address;

    }

    public void setAddress(String address) 
    {

        this.address = address;

    }

    public String getNationality()
     {

        return nationality;

    }

    public void setNationality(String nationality) {


        this.nationality = nationality;


    }

    public String getPreferredLanguage() {


        return preferredLanguage;


    }

    public void setPreferredLanguage(String preferredLanguage) {


        this.preferredLanguage = preferredLanguage;


    }

    public MembershipLevel getMembershipLevel() {


        return membershipLevel;


    }

    public int getLoyaltyPoints() {


        return loyaltyPoints;


    }

    public LocalDate getAccountCreationDate() {


        return accountCreationDate;


    }

    public String getSecurityQuestion() {


        return securityQuestion;


    }

    public void setSecurityQuestion(String securityQuestion, String securityAnswer) {


        this.securityQuestion = securityQuestion;


        this.securityAnswer = securityAnswer;


    }

    public boolean isAccountActive() {


        return isAccountActive;


    }

   

    public List<String> getBookingHistory() {

        return new ArrayList<>(this.bookingHistory);

    }

   
   

    @Override

    public String toString() {


        StringBuilder sb = new StringBuilder();


        sb.append("========================================\n");


        sb.append("         AEROFLOW USER PROFILE          \n");


        sb.append("========================================\n");


        sb.append("Account Status   : ").append(isAccountActive ? "ACTIVE" : "SUSPENDED").append("\n");
        
        
        sb.append("Full Name        : ").append(getFullName()).append("\n");
        
        
        sb.append("Email Address    : ").append(emailAddress).append("\n");
       
       
        sb.append("Phone Number     : ").append(phoneNumber).append("\n");
        
        
        sb.append("Date of Birth    : ").append(dateOfBirth).append("\n");
        
        
        sb.append("Nationality      : ").append(nationality).append("\n");
       
       
        sb.append("Address          : ").append(address).append("\n");
        
        
        sb.append("Language Pref    : ").append(preferredLanguage).append("\n");
       
       
        sb.append("----------------------------------------\n");
        
        
        sb.append("Membership Tier  : ").append(membershipLevel).append("\n");
        
        
        sb.append("Loyalty Points   : ").append(loyaltyPoints).append(" PTS\n");
       
        
        sb.append("Total Bookings   : ").append(bookingHistory.size()).append("\n");
       
       
        sb.append("Member Since     : ").append(accountCreationDate).append("\n");
       
       
        sb.append("========================================");
        
        
        return sb.toString();
    }


}