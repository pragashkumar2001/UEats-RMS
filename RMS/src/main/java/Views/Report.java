package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Report extends JFrame{

    private JTextField textField1;
    private JTextField textFoodSales;
    private JTextField textBeverageSales;
    private JTextField textDeliveryFeeIncome;
    private JTextField textFoodCosts;
    private JTextField textBeverageCosts;
    private JTextField textLabourSalaries;
    private JTextField textRent;
    private JTextField textUtilities;
    private JTextField textAdvertisments;
    private JTextField textPackagingExpense;
    private JTextField textDeliveryCosts;
    private JButton btnTotalIncome;
    private JButton btntotalExpenses;
    private JTextField textOtherExpenses;

    public Report(){


        btnTotalIncome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int FoodSales= Integer.parseInt(textFoodSales.getText());
                int BeverageSales= Integer.parseInt(textBeverageSales.getText());
                int DeliveryFeeIncome= Integer.parseInt(textDeliveryFeeIncome.getText());

            }
        });


        btntotalExpenses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
