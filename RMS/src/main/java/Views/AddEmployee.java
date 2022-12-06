package Views;

import Controllers.LoginController;
import Controllers.EmployeeController;
import Models.FoodItem;
import Models.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddEmployee extends JFrame {
    JPanel backPanel;
    private JLabel lblLastName;
    private JLabel lblFirstName;
    private JLabel lblEmail;
    private JLabel lblPassword;
    private JButton btnAddEmployee;

    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtEmail;
    private JTextField txtPassword;
    private DefaultTableModel model;

    public AddEmployee()
    {
        model = new DefaultTableModel();

        btnAddEmployee.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               String fName = txtFirstName.getText();
                String lName = txtLastName.getText();
                String email = txtEmail.getText();
                String password = txtPassword.getText();
                model.addRow(new Object[]{txtFirstName, txtLastName, txtEmail, txtPassword});
                JOptionPane.showMessageDialog(backPanel, "Emplpoyee Details Added Successfully!!!", "Success", 1);

                if (fName != null && lName != null && email != null && password != null) {
                    EmployeeController.addEmployee(new User(fName, lName, email, password, "Employee"));
                    JOptionPane.showMessageDialog(backPanel, "successfully registered to the database", "success", 1);
                } else {
                    JOptionPane.showMessageDialog(backPanel, "cannot insert registered to the database", "error", 0);
                }


            }
        });

    }

}
