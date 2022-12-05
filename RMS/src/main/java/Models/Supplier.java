package Models;

/*
* @author G.A.V.Parindi
* @SA_No SA22406194
 * */
public class Supplier extends BaseModel {
    private int id;

    private String supplierName;
    private String supplierEmail;
    private int materialID;
    private String materialName;
    private double cost;
    private int quantity;

public Supplier(){
}
    public Supplier(int id,String supplierName,String supplierEmail,int materialID,String materialName,double cost,int quantity){
        this.id=id;
        this.supplierName=supplierName;
        this.supplierEmail=supplierEmail;
        this.materialID=materialID;
        this.materialName=materialName;
        this.cost=cost;
        this.quantity=quantity;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }
    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
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

    public void setCost(Double cost) {
        this.cost = cost;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

