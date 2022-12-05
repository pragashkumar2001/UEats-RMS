package Controllers;

import Models.User;
import Services.RegistrationService;

public class RegistrationController {
    private RegistrationService registrationService;

    public RegistrationController() {
        registrationService = new RegistrationService();
    }

    public boolean registerCustomer(User customer) {
        return registrationService.addRegistrationInfo(customer);
    }

}
