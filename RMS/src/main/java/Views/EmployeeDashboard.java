package Views;

import Controllers.LoginController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class EmployeeDashboard extends JFrame {
    private JButton btnManageOrder;
    private JButton btnManageEmployee;
    public JPanel backPanel;
    private JButton btnManageSupplier;
    private JButton btnGenerateReport;
    private JButton btnLogout;

    public EmployeeDashboard() {
        btnManageOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageOrder manageOrderUi = new ManageOrder();
                manageOrderUi.setContentPane(manageOrderUi.backPanel);
                manageOrderUi.setTitle("UEATS: Manage Order Form");
                manageOrderUi.setSize(1200, 600);
                manageOrderUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                manageOrderUi.setLocationRelativeTo(null);
                manageOrderUi.setVisible(true);
            }
        });
        btnManageSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnManageEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnGenerateReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenerateReport generateReportUi = new GenerateReport();
                generateReportUi.setContentPane(generateReportUi.backPanel);
                generateReportUi.setTitle("UEATS: Generate Report Form");
                generateReportUi.setSize(1200, 600);
                generateReportUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                generateReportUi.setLocationRelativeTo(null);
                generateReportUi.setVisible(true);
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
