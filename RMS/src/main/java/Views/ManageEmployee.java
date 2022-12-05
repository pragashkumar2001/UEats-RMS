package Views;

import Controllers.OrderController;
import Models.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author P.E.Poorvikah
 * @SA_No SA22402202
 */

public class ManageEmployee extends JFrame
{
    private OrderController orderController;
    private DefaultTableModel model;
    public JPanel backPanel;
    private JTable table1;
    private JButton viewEmployeeButton;
    private JButton addEmployeeButton;
    private JButton updateEmployeeButton;
    private JButton deleteEmployeeButton;

    public ManageEmployee()
    {
        model = new DefaultTableModel();
        orderController = new OrderController();

        loadTable();
        
        addEmployeeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            dispose();
            ManageEmployee manageEmployeeUi = new ManageEmployee();
            manageEmployeeUi.setContentPane(manageEmployeeUi.backPanel);
            manageEmployeeUi.setTitle("UEATS: Manage Employee Form");
            manageEmployeeUi.setSize(1000, 600);
            manageEmployeeUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            manageEmployeeUi.setLocationRelativeTo(null);
            manageEmployeeUi.setVisible(true);

        }
        });
        deleteEmployeeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        
    }

    private void loadTable() {
        model.addColumn("Employee Id");
        model.addColumn("First Name");
        model.addColumn("Last Name");
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




