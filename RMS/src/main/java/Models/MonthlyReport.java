package Models;

public class MonthlyReport {


    public MonthlyReport() {

    }

    public class Expences{
         int FoodCosts;
         int BeverageCosts;
         int LabourSalaries;
         int Rent;
         int Utilities;
         int Advertisements;
         int PackagingExpense;
         int DeliveryCosts;

         int OtherExpenses;

        public Expences(int foodCosts, int beverageCosts, int labourSalaries, int rent, int utilities, int advertisements, int packagingExpense, int deliveryCosts, int otherExpenses) {
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




    private double getTotalExpences() {
        double FoodCosts = 0;
        double BeverageCosts = 0;
        double LabourSalaries = 0;
        double Rent = 0;
        double Utilities = 0;
        double Advertisements = 0;
        double PackagingExpense = 0;
        double DeliveryCosts = 0;
        double OtherExpenses = 0;
        return FoodCosts + BeverageCosts + LabourSalaries + Rent + Utilities + Advertisements + PackagingExpense + DeliveryCosts + OtherExpenses;
    }
    public double profit(){
        return ()-getTotalExpences();
    }
}
