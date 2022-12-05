package Controllers;

import Models.Order;
import Models.User;
import Services.RegistrationService;

import java.util.ArrayList;


public class RegistrationController {
    private RegistrationService RagService;

    public RegistrationController() {
        RagService = new RegistrationService();
    }

//    public boolean addRegistrationInfoToDB(User customer) {
//        return RagService.addRegistrationInfo(customer);
//    }

    public ArrayList<User> getUsers() {
        return RagService.getUsers();
    }
}
