package Services;

import DB.DatabaseConnection;
import Models.Enums.Months;
import Models.MonthlyReport;

import java.sql.ResultSet;
import java.time.Month;
import java.util.ArrayList;

import static Models.Enums.Months.JANUARY;

public class IncomeService {
    private DatabaseConnection singleConn;
    private Enum<Months> Month;

    public IncomeService() {
        singleConn = DatabaseConnection.getSingleInstance();
    }

    public void getMonthReport(int month) {
        String query = null;
        if (Month == JANUARY) {
        }
            query = "SELECT SUM(fi.totalAmount) as totalAmount FROM orders o, order_detail od, food_item fi WHERE MONTH(o.orderDate) = '" + month + "' AND o.id = od.orderId AND od.foodItemId=fi.id;";
        ResultSet rs = singleConn.ExecuteGetQuery(query);

    }

}
