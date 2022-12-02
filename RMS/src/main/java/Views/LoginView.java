package Views;

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
    private JTextField txtUserName;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JPanel backPanel;

    private static LoginView loginViewUi;

    public LoginView() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginViewUi.dispose();

                switch (txtUserName.getText().toLowerCase()) {
                    case "e":
                        EmployeeDashboard employeeDashboardUi = new EmployeeDashboard();
                        employeeDashboardUi.setContentPane(employeeDashboardUi.backPanel);
                        employeeDashboardUi.setTitle("UEATS: Employee Dashboard");
                        employeeDashboardUi.setSize(400, 300);
                        employeeDashboardUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        employeeDashboardUi.setLocationRelativeTo(null);
                        employeeDashboardUi.setVisible(true);
                        break;
                    case "c":
                        CustomerDashboard customerDashboardUi = new CustomerDashboard();
                        customerDashboardUi.setContentPane(customerDashboardUi.backPanel);
                        customerDashboardUi.setTitle("UEATS: Customer Dashboard");
                        customerDashboardUi.setSize(400, 300);
                        customerDashboardUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        customerDashboardUi.setLocationRelativeTo(null);
                        customerDashboardUi.setVisible(true);
                        break;
                }


//                String user=txtUserName.getText();
//                char[] pass=txtPassword.getPassword();
//                String passT=new String(pass);
//                User u=new User(user,passT,null);
//                LoginController controller=new LoginController();
//                User valid=controller.validateUser(u);
//                if(valid!=null)
//                {
//                    switch (valid.getType())
//                    {
//                        case "admin":
//                            DashboardView ui=new DashboardView();
//                            ui.setContentPane(ui.backPanel);
//                            ui.setTitle("Group Project 1.0");
//                            ui.lblWelcome.setText("Welcome "+valid.getUserName());
//                            ui.setSize(600,600);
//                            ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                            ui.setVisible(true);
//                            break;
//                        case "rider":
//                            RiderView ui2=new RiderView();
//                            ui2.setContentPane(ui2.backPanel);
//                            ui2.setTitle("Rider Manager 1.0");
//                            ui2.setSize(600,600);
//                            ui2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                            ui2.setVisible(true);
//                            break;
//                        case "bike":
//                            BicycleView ui3=new BicycleView();
//                            ui3.setContentPane(ui3.backPanel);
//                            ui3.setTitle("Bicycle Manager 1.0");
//                            ui3.setSize(600,600);
//                            ui3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                            ui3.setVisible(true);
//                            break;
//                        case "bank":
//                            SavingsAccountView ui4=new SavingsAccountView();
//                            ui4.setContentPane(ui4.backPanel);
//                            ui4.setTitle("Account Manager 1.0");
//                            ui4.setSize(600,600);
//                            ui4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                            ui4.setVisible(true);
//                            break;
//
//                    }
//                }else {
//                    JOptionPane.showMessageDialog(backPanel, "Incorrect username or password", "Error", 0);
//                }
//            }
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
            // If Nimbus is not available, you can set the GUI to another look and feel.
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

