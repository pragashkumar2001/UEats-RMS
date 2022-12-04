package Views;

import Controllers.LoginController;
import Services.LoginService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class CustomerDashboard extends JFrame {
    private JButton createOrderButton;
    private JButton bookSeatButton;

    public JPanel backPanel;
    private JButton btnLogout;

    public CustomerDashboard() {
        createOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerCreateOrder customerCreateOrderUi = new CustomerCreateOrder();
                customerCreateOrderUi.setContentPane(customerCreateOrderUi.backPanel);
                customerCreateOrderUi.setTitle("UEATS: Customer Create Order Form");
                customerCreateOrderUi.setSize(1200, 600);
                customerCreateOrderUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                customerCreateOrderUi.setLocationRelativeTo(null);
                customerCreateOrderUi.setVisible(true);
            }
        });
        bookSeatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController.logout();
                dispose();
                LoginView loginViewUi = new LoginView();
                loginViewUi.setContentPane(loginViewUi.backPanel);
                loginViewUi.setTitle("User Login Form");
                loginViewUi.setSize(400, 300);
                loginViewUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginViewUi.setLocationRelativeTo(null);
                loginViewUi.setVisible(true);
            }
        });
    }
}
