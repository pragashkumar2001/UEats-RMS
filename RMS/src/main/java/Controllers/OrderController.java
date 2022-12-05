package Controllers;

import Models.Enums.*;
import Models.FoodItem;
import Models.Order;
import Models.OrderDetail;
import Services.EmailService;
import Services.FoodItemService;
import Services.OrderService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class OrderController {
    private FoodItemService foodItemService;
    private OrderService orderService;

    public OrderController() {
        foodItemService = new FoodItemService();
        orderService = new OrderService();
    }

    public ArrayList<Order> getOrders() {
        return orderService.getOrders();
    }

    public void updateStatus(Order order){
        orderService.updateStatus(order.getId());
        EmailService.sendMail(order);
    }

    public double getCartTotal() {
        return foodItemService.getCartTotal();
    }

    public void removeCartItem(int index) {
        foodItemService.removeCartItem(index);
    }

    public FoodItem addFoodToCart(int quantity, FoodType foodType, Size size, Topping topping, Drink drink) {
        FoodItem foodItem;
        if (!topping.equals(Topping.NONE) && !drink.equals(Drink.NONE)) {
            foodItem = foodItemService.createFoodItemWithToppingWithDrink(quantity, foodType, size, topping, drink);
        } else if (!topping.equals(Topping.NONE) && drink.equals(Drink.NONE)) {
            foodItem = foodItemService.createFoodItemWithTopping(quantity, foodType, size, topping);
        } else if (topping.equals(Topping.NONE) && !drink.equals(Drink.NONE)) {
            foodItem = foodItemService.createFoodItemWithDrink(quantity, foodType, size, drink);
        } else {
            foodItem = foodItemService.createFoodItem(quantity, foodType, size);
        }

        return foodItem;
    }

    public void proceedOrder(EventType eventType, String customerEmail) {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);

        int orderId = orderService.addOrder(new Order(date, eventType, customerEmail));

        if (orderId > 0) {
            for (FoodItem foodItem : foodItemService.getFoodItemList()) {
                int foodItemId = foodItemService.addFoodItem(foodItem);

                if (foodItemId > 0) {
                    orderService.addOrderDetail(new OrderDetail(orderId, foodItemId));
                }
            }
        }

    }
}
