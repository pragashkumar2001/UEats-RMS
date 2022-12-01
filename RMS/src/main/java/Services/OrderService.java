package Services;

import DB.DatabaseConnection;
import Models.Enums.EventType;
import Models.Order;
import Models.OrderDetail;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class OrderService {

    private DatabaseConnection singleConn;

    public OrderService() {
        singleConn = DatabaseConnection.getSingleInstance();
    }

    public ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            String query = "SELECT o.id, o.customerName, o.orderDate, o.eventType, o.status, SUM(fi.totalAmount) as billAmount, o.empEmail FROM orders o, order_detail od, food_item fi WHERE o.id = od.orderId AND od.foodItemId = fi.id GROUP By o.id;";
            ResultSet rs = singleConn.ExecuteGetQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setCustomerName(rs.getString("customerName"));
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

    public int addOrder(Order order) {
        try {
            String query = "INSERT INTO `orders` (`orderDate`, `customerName`, `eventType`, `empEmail`) VALUES ('" + order.getOrderDate() + "', '" + order.getCustomerName() + "', '" + order.getEventType() + "', '" + order.getEmpEmail() + "');";
            int id = singleConn.InsertQueryReturnInt(query);
            return id;
        } catch (Exception ex) {
            System.out.println("Cannot insert a order");
            return -1;
        }
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        try {
            String query = "INSERT INTO `order_detail` (`orderId`, `foodItemId`) VALUES ('" + orderDetail.getOrderId() + "', '" + orderDetail.getFoodItemId() + "');";
            singleConn.ExecuteQuery(query);
        } catch (Exception ex) {
            System.out.println("Cannot insert a order detail");
        }
    }


}
