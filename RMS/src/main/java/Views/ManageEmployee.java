package Views;

import Controllers.EmployeeController;
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

public class ManageEmployee extends JFrame {
    private OrderController orderController;
    private DefaultTableModel model;

    public JPanel backPanel;
    private JTable tblEmployee;
    private JButton addEmployeeButton;
    private JButton updateEmployeeButton;
    private JButton deleteEmployeeButton;

    public ManageEmployee() {
        model = new DefaultTableModel();
        orderController = new OrderController();

        loadTable();

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddEmployee addEmployeeUi = new AddEmployee();
                addEmployeeUi.setContentPane(addEmployeeUi.backPanel);
                addEmployeeUi.setTitle("UEATS: Add Employee Form");
                addEmployeeUi.setSize(400, 400);
                addEmployeeUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addEmployeeUi.setLocationRelativeTo(null);
                addEmployeeUi.setVisible(true);
            }
        });

        deleteEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = tblEmployee.getSelectedRow();
                    model.removeRow(index);
                    EmployeeController.removeEmployee(index);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(backPanel, "Please select a record to clear!!!", "Error", 0);
                }
            }
        });
        updateEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddEmployee addEmployeeUi = new AddEmployee();
                addEmployeeUi.setContentPane(addEmployeeUi.backPanel);
                addEmployeeUi.setTitle("UEATS: Update Employee Form");
                addEmployeeUi.setSize(400, 400);
                addEmployeeUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addEmployeeUi.setLocationRelativeTo(null);
                addEmployeeUi.setVisible(true);
            }
        });
    }

    private void loadTable() {
        model.addColumn("Employee Id");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Employee Email");
        model.addColumn("Password");

        tblEmployee.setModel(model);
        tblEmployee.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblEmployee.setFillsViewportHeight(true);

        for (Order order : orderController.getOrders()) {
            if (order.getEmpEmail() == null) {
                order.setEmpEmail("Unassigned");
            }
            model.addRow(new Object[]{order.getId(), order.getCustomerEmail(), order.getOrderDate(), order.getEventType(), "Rs." + order.getBillAmount(), order.getStatus(), order.getEmpEmail()});
        }

    }
}




