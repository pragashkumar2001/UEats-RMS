package Views;

import Controllers.LoginController;
import Controllers.EmployeeController;
import Models.FoodItem;

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
    private JLabel lblDOB;
    private JLabel lblRole;
    private JTable tblEmployee;
    private JButton btnAddEmployee;

    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtDOB;
    private JTextField txtEmail;
    private JTextField txtPassword;
    private JTextField txtRole;
    private DefaultTableModel model;

    public AddEmployee()
    {
        model = new DefaultTableModel();

        btnAddEmployee.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
//                int quantity = Integer.parseInt(spnQuantity.getValue().toString());
//                FoodItem foodItem = orderController.addFoodToCart(quantity, selectedFoodType, selectedSize, selectedTopping, selectedDrink);
//                model.addRow(new Object[]{selectedFoodType, selectedSize, selectedTopping, selectedDrink, quantity, "Rs." + foodItem.getItemCost(), "Rs." + foodItem.getTotalAmount()});
//                JOptionPane.showMessageDialog(backPanel, "Item Added Successfully!!!", "Success", 1);


            }
        });

    }

}
