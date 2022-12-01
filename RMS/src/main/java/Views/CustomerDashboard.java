package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDashboard extends JFrame {
    private JButton createOrderButton;
    private JButton bookSeatButton;
    public JPanel backPanel;

    public CustomerDashboard() {
        createOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerCreateOrder customerCreateOrderUi = new CustomerCreateOrder();
                customerCreateOrderUi.setContentPane(customerCreateOrderUi.backPanel);
                customerCreateOrderUi.setTitle("UEATS: Customer Create Order Form");
                customerCreateOrderUi.setSize(1000, 600);
                customerCreateOrderUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                customerCreateOrderUi.setLocationRelativeTo(null);
                customerCreateOrderUi.setVisible(true);
            }
        });
//        viewOrderButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CustomerViewOrder customerViewOrderUi = new CustomerViewOrder();
//                customerViewOrderUi.setContentPane(customerViewOrderUi.backPanel);
//                customerViewOrderUi.setTitle("UEATS: Customer VIew Orders");
//                customerViewOrderUi.setSize(1000, 600);
//                customerViewOrderUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                customerViewOrderUi.setLocationRelativeTo(null);
//                customerViewOrderUi.setVisible(true);
//            }
//        });
    }
}
