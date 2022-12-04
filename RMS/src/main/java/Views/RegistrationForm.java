package Views;

import Controllers.RegistrationController;
import Models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JDialog{
    private JTextField txtFName;
    private JTextField txtPassword;
    private JButton btnCancel;
    private JButton btnRegister;
    private JPanel registerPanel;
    private JTextField txtEmail;
    private JTextField txtLName;

    RegistrationController registrationC;

    private static RegistrationForm RegistrationFormUi;
    public RegistrationForm(){

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fname= txtFName.getText();
                String lname= txtLName.getText();
                String email= txtEmail.getText();
                String password= txtPassword.getText();

                if (fname != null && lname!=null && email!=null && password!=null){
                    RegistrationController.addRegistrationInfoToDB(
                            new User(fname, lname,email,password, "Customer")
                    );
                    JOptionPane.showMessageDialog(registerPanel,"successfully registered to the database",
                            "success",1);
                }else{
                    JOptionPane.showMessageDialog(registerPanel,"cannot insert registered to the database",
                            "error",0);
                }


                JOptionPane.showMessageDialog(registerPanel,"successfully registered ",
                        "Info",1);
            }
        });
    }

    public static void main(String[] args) {
        RegistrationForm ui=new RegistrationForm();
        ui.setContentPane(ui.registerPanel);
        ui.setTitle("register form ");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ui.setVisible(true);
    }
}
