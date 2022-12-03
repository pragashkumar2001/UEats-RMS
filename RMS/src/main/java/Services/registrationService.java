package Services;

import DB.DatabaseConnection;
import Models.FoodItem;
import Models.User;

public class registrationService {

    private DatabaseConnection singleConn;
    public registrationService(){
        singleConn=DatabaseConnection.getSingleInstance();
    }

    public boolean addRegistrationInfo(User registration)
    {

        try {
            String query = "INSERT INTO `user` (`firstName`, `lastName`, `email`, `password`, `role`) VALUES ('" + User.firstName + "', '" + User.lastName + "', '" + User.email + "',, '" + User.password + "', '" + User.role + "');";
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        } catch (Exception ex) {
            System.out.println("Cannot insert Registration Info");
            return false;
        }
    }
}
