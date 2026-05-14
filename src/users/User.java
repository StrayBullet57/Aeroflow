package users;

public class User {
    private String userID;
    private String name;
    private String email;
    private String password;
    private String profile;

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


}
