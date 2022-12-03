package Controllers;

import Models.User;
import Services.registrationService;

import java.security.PublicKey;

public class registrationController {
    User userObj;
    registrationService service;

//    public  User addRider(String firstName,String lastName,String email,String role,String Password)
//    {
//        userObj=new User(firstName,lastName,email,role,Password);
//        return  userObj;
//    }

public registrationController(){
    service=new registrationService();
}
        public boolean addRegistrationInfoToDB(){
    return service.addRegistrationInfo(userObj);
        }
}
