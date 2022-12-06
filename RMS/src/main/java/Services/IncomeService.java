package Services;

import DB.DatabaseConnection;
import Models.Enums.Month;

import java.sql.ResultSet;


public class IncomeService {
    private DatabaseConnection singleConn;

    public IncomeService() {
        singleConn = DatabaseConnection.getSingleInstance();
    }

    public void getMonthReport(Month month) {
        String query = null;

        int selectedMonth = 0;

        query = "SELECT SUM(fi.totalAmount) as totalAmount FROM orders o, order_detail od, food_item fi WHERE MONTH(o.orderDate) = '" + selectedMonth + "' AND o.id = od.orderId AND od.foodItemId=fi.id;";
        ResultSet rs = singleConn.ExecuteGetQuery(query);

    }

}
