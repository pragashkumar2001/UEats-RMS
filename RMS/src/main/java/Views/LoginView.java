package Views;

import Controllers.LoginController;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */

public class LoginView extends JFrame {
    private JLabel lblUserName;
    private JLabel lblPassword;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblRegisterMsg;
    private JLabel lblRegister;

    public JPanel backPanel;

    public LoginView() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txtEmail.getText();
                char[] passC = txtPassword.getPassword();
                String pass = new String(passC);
                LoginController controller = new LoginController();
                User validUser = controller.validateUser(user, pass);
                if (validUser != null) {
                    switch (validUser.getRole()) {
                        case "Employee":
                            JOptionPane.showMessageDialog(backPanel, "You have successfully logged in!!!", "Login Success", 1);
                            dispose();
                            EmployeeDashboard employeeDashboardUi = new EmployeeDashboard();
                            employeeDashboardUi.setContentPane(employeeDashboardUi.backPanel);
                            employeeDashboardUi.setTitle("UEATS: Employee Dashboard");
                            employeeDashboardUi.setSize(600, 400);
                            employeeDashboardUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            employeeDashboardUi.setLocationRelativeTo(null);
                            employeeDashboardUi.setVisible(true);
                            break;
                        case "Customer":
                            JOptionPane.showMessageDialog(backPanel, "You have successfully logged in!!!", "Login Success", 1);
                            dispose();
                            CustomerDashboard customerDashboardUi = new CustomerDashboard();
                            customerDashboardUi.setContentPane(customerDashboardUi.backPanel);
                            customerDashboardUi.setTitle("UEATS: Customer Dashboard");
                            customerDashboardUi.setSize(500, 300);
                            customerDashboardUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            customerDashboardUi.setLocationRelativeTo(null);
                            customerDashboardUi.setVisible(true);
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(backPanel, "Invalid Email or Password, Please Check Again !!!", "Login Error", 0);
                }
            }
        });

        lblRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegistrationForm RegUi = new RegistrationForm();
                RegUi.setContentPane(RegUi.registerPanel);
                RegUi.setTitle("UEATS: User Registration Form");
                RegUi.setSize(600, 600);
                RegUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                RegUi.setLocationRelativeTo(null);
                RegUi.setVisible(true);
                lblRegister.setForeground(Color.RED);
            }
        });
    }

    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Nimbus UI is not available!!!");
        }

        LoginView loginViewUi = new LoginView();
        loginViewUi.setContentPane(loginViewUi.backPanel);
        loginViewUi.setTitle("User Login Form");
        loginViewUi.setSize(400, 300);
        loginViewUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginViewUi.setLocationRelativeTo(null);
        loginViewUi.setVisible(true);
    }
}

