package Services;

import DB.DatabaseConnection;
import Models.User;

public class RegistrationService {

    private DatabaseConnection singleConn;

    public RegistrationService() {
        singleConn = DatabaseConnection.getSingleInstance();
    }

    public boolean addRegistrationInfo(User user) {

        try {
            String query = "INSERT INTO `user` (`firstName`, `lastName`, `email`, `password`, `role`) VALUES ('" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', '" + user.getRole() + "');";
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        } catch (Exception ex) {
            System.out.println("Cannot insert Registration Info");
            return false;
        }
    }
}
