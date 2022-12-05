package Services;

import DB.DatabaseConnection;
import Models.Enums.EventType;
import Models.Order;
import Models.User;

import java.sql.ResultSet;
import java.util.ArrayList;

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

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

        try {
            String query = "SELECT o.id, o.customerEmail, o.orderDate, o.eventType, o.status, SUM(fi.totalAmount) as billAmount, o.empEmail FROM orders o, order_detail od, food_item fi WHERE o.id = od.orderId AND od.foodItemId = fi.id GROUP By o.id;";
            ResultSet rs = singleConn.ExecuteGetQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    User user = new User();
                    user.setFirstName(rs.getString("FirstName"));
                    user.setLastName(rs.getString("LastName"));
                    user.setEmail(rs.getString("Email"));
                    user.setPassword(rs.getString("Password"));
                    user.setRole(rs.getString("Role"));
                    users.add(user);
                }
            }

        } catch (Exception ex) {
            System.out.println("Cannot insert a order");
        }

        return users;
    }
}
