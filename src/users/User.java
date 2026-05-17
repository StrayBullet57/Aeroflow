package users;

public class User {
    private String userID;
    private String name;
    private String email;
    private String password;
    private Profile profile;

    public User(String userID, String name, String email, String password, Profile profile){
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public void register(){
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
}