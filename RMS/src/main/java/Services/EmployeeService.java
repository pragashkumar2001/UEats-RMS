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

    public static void removeEmployee(int index)
    {

    }

    public ArrayList<User> getEmployee() {
        ArrayList<User> employees = new ArrayList<>();

        try {
            String query = "SELECT o.id, o.customerEmail, o.orderDate, o.eventType, o.status, SUM(fi.totalAmount) as billAmount, o.empEmail FROM orders o, order_detail od, food_item fi WHERE o.id = od.orderId AND od.foodItemId = fi.id GROUP By o.id;";
            ResultSet rs = singleConn.ExecuteGetQuery(query);

        } catch (Exception ex) {
            System.out.println("Cannot enter Employee");
        }

        return employees;
    }
}
