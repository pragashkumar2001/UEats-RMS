package Models;

import Models.Enums.Drink;
import Models.Enums.FoodType;
import Models.Enums.Size;
import Models.Enums.Topping;
/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class FoodItem extends BaseModel {
    private FoodType foodType;
    private Size size;
    private Topping topping;
    private Drink drink;
    private int quantity;
    private double itemCost = 0;

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost += itemCost;
    }

    public double getTotalAmount() {
        return itemCost * quantity;
    }

}
