package Services;

import DB.DatabaseConnection;
import Models.Enums.EventType;
import Models.Order;
import Models.OrderDetail;
import Models.User;

import java.sql.ResultSet;
import java.util.ArrayList;

public class LoginService {
    private DatabaseConnection singleConn;

    public LoginService() {
        singleConn = DatabaseConnection.getSingleInstance();
    }

    public User login(String email, String password) {
        User user = null;
        try {
            String query = "SELECT * FROM `user`  WHERE `email` = '" + email + "' and `password` = '" + password + "';";
            ResultSet rs = singleConn.ExecuteGetQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setFirstName(rs.getString("firstName"));
                    user.setLastName(rs.getString("lastName"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(rs.getString("role"));
                }
            }
        } catch (Exception ex) {
            System.out.println("Cannot find any User details");
        }

        return user;

    }
}
