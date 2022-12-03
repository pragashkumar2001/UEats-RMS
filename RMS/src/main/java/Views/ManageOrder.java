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
public class ManageOrder extends JFrame {
    private JTable table1;
    private JButton viewReceiptButton;
    private JButton assignEmployeeButton;
    private JButton updateStatusButton;
    private JButton addOrderButton;
    private DefaultTableModel model;
    private OrderController orderController;

    public JPanel backPanel;

    public ManageOrder() {
        model = new DefaultTableModel();
        orderController = new OrderController();

        loadTable();

        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CustomerCreateOrder customerCreateOrderUi = new CustomerCreateOrder();
                customerCreateOrderUi.setContentPane(customerCreateOrderUi.backPanel);
                customerCreateOrderUi.setTitle("UEATS: Employee Create Order Form");
                customerCreateOrderUi.setSize(1000, 600);
                customerCreateOrderUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                customerCreateOrderUi.setLocationRelativeTo(null);
                customerCreateOrderUi.setVisible(true);
            }
        });
    }

    public void loadTable() {
        model.addColumn("Order Id");
        model.addColumn("Customer Email");
        model.addColumn("Date");
        model.addColumn("Event Type");
        model.addColumn("Total Amount");
        model.addColumn("Status");
        model.addColumn("Employee Email");
        table1.setModel(model);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFillsViewportHeight(true);

        for (Order order : orderController.getOrders()) {
            if (order.getEmpEmail() == null) {
                order.setEmpEmail("Unassigned");
            }
            model.addRow(new Object[]{order.getId(), order.getCustomerEmail(), order.getOrderDate(), order.getEventType(), "Rs." + order.getBillAmount(), order.getStatus(), order.getEmpEmail()});
        }

    }
}