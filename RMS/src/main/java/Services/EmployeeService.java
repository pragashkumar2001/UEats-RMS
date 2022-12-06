package Services;

import DB.DatabaseConnection;
import Models.User;


import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author P.E.Poorvikah
 * @SA_No SA22402202
 */

public class EmployeeService
{
    private DatabaseConnection singleConn;

    public EmployeeService() {
        singleConn = DatabaseConnection.getSingleInstance();
    }

    public boolean addEmployeeInfo(User user)
    {
        try{
            String query="INSERT INTO `user` (`firstName`, `lastName`, `email`, `password`, `role`) VALUES ('" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', '" + user.getRole() + "');";
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        }catch (Exception ex)
        {
            System.out.println("Cannot insert Employee Info");
            return false;

        }
    }
    public static void removeEmployee(int index)
    {

    }

    public ArrayList<User> getEmployee() {
        ArrayList<User> employees = new ArrayList<>();

        try {
            String query = "SELECT`id`,`firstName`,`lastName`,`email`,`password` FROM `user`";
            ResultSet res = singleConn.ExecuteGetQuery(query);

            if (res != null)
            {
                while (res.next())
                {
                    User user = new User();
                    user.setFirstName(res.getString("FirstName"));
                    user.setLastName(res.getString("LastName"));
                    user.setEmail(res.getString("Email"));
                    user.setPassword(res.getString("Password"));
//                    user.setRole(res.getString("Role"));
                    employees.add(user);
                }
            }

        } catch (Exception ex) {
            System.out.println("Cannot enter Employee");
        }

        return employees;
    }
}
