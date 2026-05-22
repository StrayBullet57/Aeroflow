package users;

interface Authenticatable {
    void performAction();
}

public class User implements Authenticatable{
    private String userID;
    private String name;
    private String email;
    private String password;
    private String phone;

    public User(String userID, String name, String email, String password, String phone) {
        this.userID   = userID;
        this.name     = name;
        this.email    = email;
        this.password = password;
        this.phone    = phone;
    }

    public void register() {
        System.out.println("User registered successfully.");
    }

    public boolean login(String inputEmail, String inputPassword) {
        if (this.email.equalsIgnoreCase(inputEmail) && this.password.equals(inputPassword)) {
            System.out.println("Welcome back, " + this.name + "! Login successful.");
            return true;
        }
        System.out.println("Login Failed: Invalid email or password.");
        return false;
    }

    public String getUserID()  { return userID; }

    public String getName()    { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail()   { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public String getPhone()   { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "User Profile Details:\n" +
               "----------------------\n" +
               "User ID : " + userID + "\n" +
               "Name    : " + name   + "\n" +
               "Email   : " + email  + "\n" +
               "Phone   : " + phone;
    }

    @Override
    public void performAction() {
        System.out.println("Registered user " + name + " is interacting with the flight system.");
    }
}