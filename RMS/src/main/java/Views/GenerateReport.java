package Views;

import Models.Enums.Month;
import Models.MonthlyReport;
import Services.IncomeService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GenerateReport extends JFrame{

    private Month selectedmonthtype;

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
    private JLabel lblMonthlyIncome;
    private JLabel lblTotalIncome;

    private JLabel lblTotalExpenses;
    public JPanel backPanel;
    private JComboBox comboBox1 ;

    public GenerateReport(){

        loadmonths();




        btntotalExpenses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double FoodCosts = Double.parseDouble(textFoodCosts.getText());
                double BeverageCosts = Double.parseDouble(textBeverageCosts.getText());
                double LabourSalaries = Double.parseDouble(textLabourSalaries.getText());
                double Rent = Double.parseDouble(textRent.getText());
                double Utilities = Double.parseDouble(textUtilities.getText());
                double Advertisements = Double.parseDouble(textAdvertisments.getText());
                double PackagingExpense = Double.parseDouble(textPackagingExpense.getText());
                double DeliveryCosts = Double.parseDouble(textDeliveryCosts.getText());
                double OtherExpenses = Double.parseDouble(textOtherExpenses.getText());

                MonthlyReport ac1=new MonthlyReport(FoodCosts,BeverageCosts,LabourSalaries,Rent,Utilities,Advertisements,PackagingExpense,DeliveryCosts,OtherExpenses);

                JOptionPane.showMessageDialog(backPanel,"Successfully Calculated the expenses!",
                        "success",0);

                lblTotalExpenses.setText("Rs. " + ac1.getTotalExpenses());
            }
        });
        btnTotalIncome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IncomeService is1=new IncomeService();
                lblMonthlyIncome.setText("Rs. " + is1.getClass());
            }
        });
    }

    private void loadmonths() {
            selectedmonthtype = Month.JANUARY;
            String months[] = Month.months();

            for (String event : months) {
                comboBox1.addItem(months);
            }
        comboBox1.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        selectedmonthtype = Month.valueOf(comboBox1.getSelectedItem().toString());
                    }
                }
            });
        }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
