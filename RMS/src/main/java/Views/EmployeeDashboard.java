package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class EmployeeDashboard  extends JFrame{
    private JButton manageOrderButton;
    private JButton manageEmployeeButton;
    public JPanel backPanel;
    
    public EmployeeDashboard(){

        manageOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageOrder manageOrderUi = new ManageOrder();
                manageOrderUi.setContentPane(manageOrderUi.backPanel);
                manageOrderUi.setTitle("UEATS: Employee Dashboard");
                manageOrderUi.setSize(1000, 600);
                manageOrderUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                manageOrderUi.setLocationRelativeTo(null);
                manageOrderUi.setVisible(true);
            }
        });
    }
}
