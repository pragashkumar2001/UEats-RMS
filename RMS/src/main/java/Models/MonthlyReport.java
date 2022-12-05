package Models;

import Models.Enums.Months;

public class MonthlyReport {

    private Months months;
    private double FoodCosts;
    private double BeverageCosts;
    private double LabourSalaries;
    private double Rent;
    private double Utilities;
    private double Advertisements;
    private double PackagingExpense;
    private double DeliveryCosts;
    private double OtherExpenses;

    public MonthlyReport(Months months) {
        this.months = months;
    }

    public Months getMonths() {
        return months;
    }

    public void setMonths(Months months) {
        this.months = months;
    }

    public MonthlyReport(double foodCosts, double beverageCosts, double labourSalaries, double rent, double utilities, double advertisements, double packagingExpense, double deliveryCosts, double otherExpenses) {

    }

    public class Expenses{
        double FoodCosts;
        double BeverageCosts;
        double LabourSalaries;
        double Rent;
        double Utilities;
        double Advertisements;
        double PackagingExpense;
        double DeliveryCosts;
        double OtherExpenses;

        public Expenses(double foodCosts, double beverageCosts, double labourSalaries, double rent, double utilities, double advertisements, double packagingExpense, double deliveryCosts, double otherExpenses) {
            FoodCosts = foodCosts;
            BeverageCosts = beverageCosts;
            LabourSalaries = labourSalaries;
            Rent = rent;
            Utilities = utilities;
            Advertisements = advertisements;
            PackagingExpense = packagingExpense;
            DeliveryCosts = deliveryCosts;
            OtherExpenses = otherExpenses;


        }

    }




    public double getTotalExpenses() {
        return FoodCosts + BeverageCosts + LabourSalaries + Rent + Utilities + Advertisements + PackagingExpense + DeliveryCosts + OtherExpenses;
    }
    public double profit(){
        return getTotalExpenses();
    }

}
