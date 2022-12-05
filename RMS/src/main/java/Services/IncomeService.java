package Services;

import DB.DatabaseConnection;
import Models.Enums.Months;
import Models.MonthlyReport;

import java.sql.ResultSet;
import java.util.ArrayList;

public class IncomeService {
    private DatabaseConnection singleConn;

    public IncomeService() {
        singleConn = DatabaseConnection.getSingleInstance();
    }

    public ArrayList<MonthlyReport> getMonths() {
        ArrayList<MonthlyReport> orders = new ArrayList<>();

        try {
            String query = "SELECT SUM(fi.totalAmount) as totalAmount FROM orders o, order_detail od, food_item fi WHERE MONTH(o.orderDate) = 11 AND o.id = od.orderId AND od.foodItemId=fi.id;";
            ResultSet mnth = singleConn.ExecuteGetQuery(query);

            if (mnth != null) {
                while (mnth.next()) {
                    MonthlyReport order = new MonthlyReport();
                    order.setId(rs.getInt("id"));
                    order.setCustomerEmail(rs.getString("customerEmail"));
                    order.setOrderDate(rs.getString("orderDate"));
                    order.setEventType(EventType.valueOf(rs.getString("eventType")));
                    order.setStatus(rs.getString("status"));
                    order.setBillAmount(rs.getDouble("billAmount"));
                    order.setEmpEmail(rs.getString("empEmail"));
                    orders.add(order);
                }
            }

        } catch (Exception ex) {
            System.out.println("Cannot insert a order");
        }

        return orders;
    }
}
