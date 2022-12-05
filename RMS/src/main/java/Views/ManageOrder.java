package Views;

import Controllers.OrderController;
import Models.Order;
import Services.EmailService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class ManageOrder extends JFrame {
    private JTable tblOrder;
    private JButton viewReceiptButton;
    private JButton assignEmployeeButton;
    private JButton btnReadyOrderStatus;
    private JButton addOrderButton;
    private DefaultTableModel model;
    private OrderController orderController;

    private ArrayList<String> orderIdList;

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
                customerCreateOrderUi.setSize(1200, 600);
                customerCreateOrderUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                customerCreateOrderUi.setLocationRelativeTo(null);
                customerCreateOrderUi.setVisible(true);
            }
        });
        btnReadyOrderStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int index = tblOrder.getSelectedRow();
                    for (Order order : orderController.getOrders()) {
                        if (String.valueOf(order.getId()).equals(orderIdList.get(index))) {
                            orderController.updateStatus(order);
                        }
                        model.setColumnCount(0);
                        model.setRowCount(0);
                        loadTable();
                        }
                    JOptionPane.showMessageDialog(backPanel, "Customer has been notified via Email!!!", "Email Service Manager", 1);
                } catch (IndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(backPanel, "Please select an item to update order status!!!", "Error", 0);
                }


            }
        });
        assignEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssignEmployee assignEmployeeUi = new AssignEmployee();
                assignEmployeeUi.setContentPane(assignEmployeeUi.backPanel);
                assignEmployeeUi.setTitle("UEATS: Assign Employee Form");
                assignEmployeeUi.setSize(1200, 600);
                assignEmployeeUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                assignEmployeeUi.setLocationRelativeTo(null);
                assignEmployeeUi.setVisible(true);
            }
        });
    }

    public void loadTable() {
        orderIdList = new ArrayList<>();

        model.addColumn("Order Id");
        model.addColumn("Customer Email");
        model.addColumn("Date");
        model.addColumn("Event Type");
        model.addColumn("Total Amount");
        model.addColumn("Status");
        model.addColumn("Employee Email");
        tblOrder.setModel(model);
        tblOrder.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblOrder.setFillsViewportHeight(true);

        for (Order order : orderController.getOrders()) {
            orderIdList.add(String.valueOf(order.getId()));
            model.addRow(new Object[]{order.getId(), order.getCustomerEmail(), order.getOrderDate(), order.getEventType(), "Rs." + order.getBillAmount(), order.getStatus(), order.getEmpEmail()});
        }

    }
}