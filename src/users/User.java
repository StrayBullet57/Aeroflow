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

    public String getUserID() { return userID; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // No setter for password to keep it secure; change password should be a separate specific method
    public String getPassword() { return password; } 

    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }

    @Override
    public String toString() {
        return "User Profile Details:\n" +
               "----------------------\n" +
               "User ID:  " + userID + "\n" +
               "Name:     " + name + "\n" +
               "Email:    " + email + "\n" +
               "Profile:  " + (profile != null ? "Assigned" : "None");
    }
}