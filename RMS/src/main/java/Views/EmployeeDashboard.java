package Views;

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

    public EmployeeDashboard() {
        btnManageOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageOrder manageOrderUi = new ManageOrder();
                manageOrderUi.setContentPane(manageOrderUi.backPanel);
                manageOrderUi.setTitle("UEATS: Manage Order");
                manageOrderUi.setSize(1000, 600);
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
                ManageEmployee manageEmployeeUi = new ManageEmployee();
                manageEmployeeUi.setContentPane(manageEmployeeUi.backPanel);
                manageEmployeeUi.setTitle("UEATS: Manage Employee");
                manageEmployeeUi.setSize(1000, 600);
                manageEmployeeUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                manageEmployeeUi.setLocationRelativeTo(null);
                manageEmployeeUi.setVisible(true);

            }
        });
        btnGenerateReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
