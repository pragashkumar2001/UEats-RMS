package Views;

import Controllers.LoginController;
import Models.Enums.Role;
import Models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JPanel backPanel;

    private static LoginView loginViewUi;

    public LoginView() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txtEmail.getText();
                char[] passC = txtPassword.getPassword();
                String pass = new String(passC);
                User u = new User(user, pass);
                LoginController controller = new LoginController();
                User validUser = controller.validateUser(u);
                if (validUser != null) {
                    switch (validUser.getRole()) {
                        case "Employee":
                            loginViewUi.dispose();
                            EmployeeDashboard employeeDashboardUi = new EmployeeDashboard();
                            employeeDashboardUi.setContentPane(employeeDashboardUi.backPanel);
                            employeeDashboardUi.setTitle("UEATS: Employee Dashboard");
                            employeeDashboardUi.setSize(400, 300);
                            employeeDashboardUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            employeeDashboardUi.setLocationRelativeTo(null);
                            employeeDashboardUi.setVisible(true);
                            break;
                        case "Customer":
                            loginViewUi.dispose();
                            CustomerDashboard customerDashboardUi = new CustomerDashboard();
                            customerDashboardUi.setContentPane(customerDashboardUi.backPanel);
                            customerDashboardUi.setTitle("UEATS: Customer Dashboard");
                            customerDashboardUi.setSize(400, 300);
                            customerDashboardUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            customerDashboardUi.setLocationRelativeTo(null);
                            customerDashboardUi.setVisible(true);
                            break;
                    }
                } else {
                    System.out.println("Invalid Email or Password");
                }
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

        loginViewUi = new LoginView();
        loginViewUi.setContentPane(loginViewUi.backPanel);
        loginViewUi.setTitle("User Login 1.0");
        loginViewUi.setSize(400, 300);
        loginViewUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginViewUi.setLocationRelativeTo(null);
        loginViewUi.setVisible(true);
    }
}

