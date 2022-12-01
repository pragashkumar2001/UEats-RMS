package Views;

import Controllers.OrderController;
import Models.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class CustomerViewOrder extends JFrame {
    private JTable table1;
    private JButton viewReceiptButton;
    private JButton assignEmployeeButton;
    private JButton updateStatusButton;
    private JButton addOrderButton;
    private static CustomerViewOrder customerViewOrderUi;
    private DefaultTableModel model;
    private OrderController orderController;
    public JPanel backPanel;


    public CustomerViewOrder() {
        model = new DefaultTableModel();
        orderController = new OrderController();

        loadTable();

        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerCreateOrder customerCreateOrderUi = new CustomerCreateOrder();
//                Navigation.pageOnDispose(viewOrderUi, createOrderUi, createOrderUi.backPanel);
            }
        });
    }

    public void loadTable() {
        model.addColumn("Order Id");
        model.addColumn("Customer Name");
        model.addColumn("Date");
        model.addColumn("Event Type");
        model.addColumn("Total Amount");
        model.addColumn("Status");
        model.addColumn("Employee");
        table1.setModel(model);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFillsViewportHeight(true);

        for (Order order : orderController.getOrders()) {
            if (order.getEmpEmail() == null) {
                order.setEmpEmail("Unassigned");
            }
            model.addRow(new Object[]{order.getId(), order.getCustomerName(), order.getOrderDate(), order.getEventType(), "Rs." + order.getBillAmount(), order.getStatus(), order.getEmpEmail()});
        }

    }


    public static void main(String[] args) {
        customerViewOrderUi = new CustomerViewOrder();
        customerViewOrderUi.setContentPane(customerViewOrderUi.backPanel);
        customerViewOrderUi.setTitle("Order Manager 1.0");
        customerViewOrderUi.setSize(1000, 600);
        customerViewOrderUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerViewOrderUi.setLocationRelativeTo(null);
        customerViewOrderUi.setVisible(true);

    }
}