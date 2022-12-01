package Services;

import DB.DatabaseConnection;
import Models.FoodItem;
import Models.Enums.Drink;
import Models.Enums.FoodType;
import Models.Enums.Size;
import Models.Enums.Topping;

import java.util.ArrayList;
/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class FoodItemService {
    private ArrayList<FoodItem> foodItemList;
    private DatabaseConnection singleConn;

    public FoodItemService() {
        foodItemList = new ArrayList<>();
        singleConn = DatabaseConnection.getSingleInstance();
    }

    public ArrayList<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    public double getCartTotal() {
        double totalAmount = 0;
        for (FoodItem foodItem : foodItemList) {
            totalAmount += foodItem.getTotalAmount();
        }

        return totalAmount;
    }

    public void removeCartItem(int index) {
        foodItemList.remove(index);
    }

    public FoodItem createFoodItem(int quantity, FoodType foodType, Size size) {
        FoodBuilderService service = new FoodBuilderService(quantity);
        FoodItem foodItem = service.setFoodType(foodType)
                .withSize(size)
                .build();
        foodItemList.add(foodItem);
        return foodItem;
    }

    public FoodItem createFoodItemWithTopping(int quantity, FoodType foodType, Size size, Topping topping) {
        FoodBuilderService service = new FoodBuilderService(quantity);
        FoodItem foodItem = service.setFoodType(foodType)
                .withSize(size)
                .withTopping(topping)
                .build();
        foodItemList.add(foodItem);
        return foodItem;
    }

    public FoodItem createFoodItemWithDrink(int quantity, FoodType foodType, Size size, Drink drink) {
        FoodBuilderService service = new FoodBuilderService(quantity);
        FoodItem foodItem = service.setFoodType(foodType)
                .withSize(size)
                .withDrink(drink)
                .build();
        foodItemList.add(foodItem);
        return foodItem;
    }

    public FoodItem createFoodItemWithToppingWithDrink(int quantity, FoodType foodType, Size size, Topping topping, Drink drink) {
        FoodBuilderService service = new FoodBuilderService(quantity);
        FoodItem foodItem = service.setFoodType(foodType)
                .withSize(size)
                .withTopping(topping)
                .withDrink(drink)
                .build();
        foodItemList.add(foodItem);
        return foodItem;
    }

    public int addFoodItem(FoodItem foodItem) {

        try {
            String query = "INSERT INTO `food_item` (`foodType`, `size`, `topping`, `drink`, `quantity`, `itemCost`, `totalAmount`) VALUES ('" + foodItem.getFoodType() + "', '" + foodItem.getSize() + "', '" + foodItem.getTopping() + "', '" + foodItem.getDrink() + "', '" + foodItem.getQuantity() + "', '" + foodItem.getItemCost() + "', '" + foodItem.getTotalAmount() + "');";
            int id = singleConn.InsertQueryReturnInt(query);
            return id;
        } catch (Exception ex) {
            System.out.println("Cannot insert the food items");
            return -1;
        }
    }
}


interface FoodBuilderServiceInterface {
    FoodBuilderService setFoodType(FoodType foodType);

    FoodBuilderService withSize(Size size);

    FoodBuilderService withTopping(Topping topping);

    FoodBuilderService withDrink(Drink drink);

    FoodItem build();

    double calculatePrice();
}

class FoodBuilderService implements FoodBuilderServiceInterface {
    private FoodItem foodItem;

    public FoodBuilderService(int quantity) {
        foodItem = new FoodItem();
        foodItem.setTopping(Topping.NONE);
        foodItem.setDrink(Drink.NONE);
        foodItem.setQuantity(quantity);
    }

    @Override
    public FoodBuilderService setFoodType(FoodType foodType) {
        foodItem.setFoodType(foodType);
        foodItem.setItemCost(foodType.getCost());
        return this;
    }

    @Override
    public FoodBuilderService withSize(Size size) {
        foodItem.setSize(size);
        foodItem.setItemCost(size.getCost());
        return this;
    }

    @Override
    public FoodBuilderService withTopping(Topping topping) {
        foodItem.setTopping(topping);
        foodItem.setItemCost(topping.getCost());
        return this;
    }

    @Override
    public FoodBuilderService withDrink(Drink drink) {
        foodItem.setDrink(drink);
        foodItem.setItemCost(drink.getCost());
        return this;
    }

    @Override
    public FoodItem build() {
        return foodItem;
    }

    @Override
    public double calculatePrice() {
        return foodItem.getTotalAmount();
    }
}


