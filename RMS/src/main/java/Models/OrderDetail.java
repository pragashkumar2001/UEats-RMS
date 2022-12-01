package Models;
/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class OrderDetail {
    private int orderId;
    private int foodItemId;

    public OrderDetail(int orderId, int foodItemId) {
        this.orderId = orderId;
        this.foodItemId = foodItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

}
