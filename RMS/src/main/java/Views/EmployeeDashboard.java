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
                ManageSupplier manageSupplierUi = new ManageSupplier();
                manageSupplierUi.setContentPane(manageSupplierUi.backPanel);
                manageSupplierUi.setTitle("UEATS: Manage Supplier");
                manageSupplierUi.setSize(1000, 600);
                manageSupplierUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                manageSupplierUi.setLocationRelativeTo(null);
                manageSupplierUi.setVisible(true);
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

            }
        });
    }
}
