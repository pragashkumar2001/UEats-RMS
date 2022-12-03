package Views;

import Controllers.registrationController;
import Models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Models.User.*;

public class RegistrationForm extends JDialog{
    private JTextField txtFName;
    private JTextField txtPhoneNumber;
    private JTextField txtPassword;
    private JButton btnCancel;
    private JButton btnRegister;
    private JPanel registerPanel;
    private JTextField txtEmail;
    private JTextField txtLName;

    registrationController registrationC;

    private static RegistrationForm RegistrationFormUi;
    public RegistrationForm(){

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });

        setVisible(true);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fname= txtFName.getText();
                String lname= txtLName.getText();
                String email= txtEmail.getText();
                String phone= txtPhoneNumber.getText();
                String password= txtPassword.getText();

                if (registrationC.addRegistrationInfoToDB()){
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
