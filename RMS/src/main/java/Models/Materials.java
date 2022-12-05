package Models;

public class Materials {

    private String materialName;
    private double cost;
    private int quantity;

    public Materials(){}

    public Materials(String materialName,double cost,int quantity){
    this.materialName=materialName;
    this.cost=cost;
    this.quantity=quantity;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
