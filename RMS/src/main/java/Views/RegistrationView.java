package Views;

import Controllers.RegistrationController;
import Models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationView extends JDialog {
    private JTextField txtFName;
    private JTextField txtPassword;
    private JButton btnCancel;
    private JButton btnRegister;
    public JPanel backPanel;
    private JTextField txtEmail;
    private JTextField txtLName;
    private JLabel lblUserName;
    private JLabel lblPassword;

    private RegistrationController registrationController;

    public RegistrationView() {
        registrationController = new RegistrationController();

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fName = txtFName.getText();
                String lName = txtLName.getText();
                String email = txtEmail.getText();
                String password = txtPassword.getText();

                if (fName != null && lName != null && email != null && password != null) {
                    registrationController.registerCustomer(new User(fName, lName, email, password, "Customer"));
                    JOptionPane.showMessageDialog(backPanel, "successfully registered to the database", "success", 1);
                } else {
                    JOptionPane.showMessageDialog(backPanel, "cannot insert registered to the database", "error", 0);
                }
            }
        });
    }

}
