package users;

import java.util.ArrayList;
import java.util.List;

public class UserStore {
    private static final List<User> users = new ArrayList<>();
    private static int idCounter = 1000;

    public static String generateID() {
        return "USR" + (++idCounter);
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static User findByEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) return u;
        }
        return null;
    }

    public static boolean emailExists(String email) {
        return findByEmail(email) != null;
    }
}