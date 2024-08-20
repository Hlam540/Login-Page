import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}

// User class to represent a user
class User {
    private String username;
    private String password; // In a real application, use hashed passwords

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

// UserManager class to handle registration and login
class UserManager {
    private Map<String, User> users = new HashMap<>();

    // Register a new user
    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists!");
            return false;
        }
        users.put(username, new User(username, password));
        System.out.println("User registered successfully.");
        return true;
    }

    // Login an existing user
    public boolean login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Successfully logged in!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }
}
