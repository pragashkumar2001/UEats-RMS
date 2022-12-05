package Controllers;

import Models.Enums.Role;
import Models.User;
import Services.FoodItemService;
import Services.LoginService;
import Services.OrderService;

import java.util.ArrayList;

/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class LoginController {
    public static User currentUser;
    private LoginService loginService;

    public LoginController() {
        loginService = new LoginService();
    }

    public static void logout() {
        currentUser = null;
    }

    public User validateUser(String email, String password) {
        currentUser = loginService.login(email, password);
        return currentUser;
    }
}
