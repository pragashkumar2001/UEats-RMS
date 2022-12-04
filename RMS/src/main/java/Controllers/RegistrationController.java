package Controllers;

import Models.User;
import Services.RegistrationService;

public class RegistrationController {
    RegistrationService service;

    public RegistrationController() {
        service = new RegistrationService();
    }

    public boolean addRegistrationInfoToDB(User customer) {
        return service.addRegistrationInfo(customer);
    }
}
