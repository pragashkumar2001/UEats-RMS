package Models;

import Models.Enums.EventType;

/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class Order extends BaseModel {
    private String orderDate;
    private EventType eventType;
    private String customerName;
    private double billAmount;
    private String status;
    private String empEmail;

    public Order() {
    }

    public Order(String orderDate, EventType eventType, String customerName) {
        this.orderDate = orderDate;
        this.eventType = eventType;
        this.customerName= customerName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
