package Controllers;

import Models.Enums.Role;
import Models.User;

import java.util.ArrayList;

/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class LoginController {
    public static User currentUser;
    ArrayList<User> userDB;

    public LoginController() {
        userDB = new ArrayList<>();
        CreateDB();
    }

    private void CreateDB() {
        userDB.add(new User("Pragashkumar", "Srikanthan", "pragash@gmail.com", "123","Employee"));
        userDB.add(new User("Kumara", "Kanianthra", "kumara@gmail.com", "123", "Customer"));
    }

    public User validateUser(User currentU) {
        currentUser = null;
        for (User user : userDB) {
            if (user.getEmail().equals(currentU.getEmail()) && user.getPassword().equals(currentU.getPassword())) {
                currentUser =  user;
            }
        }
        return currentUser;
    }

}
