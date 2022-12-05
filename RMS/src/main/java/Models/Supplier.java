package Models;

/*
* @author G.A.V.Parindi
* @SA_No SA22406194
 * */
public class Supplier extends BaseModel {

    private String supplierName;
    private String supplierEmail;


public Supplier(){
}
    public Supplier(String supplierName,String supplierEmail){
        this.supplierName=supplierName;
        this.supplierEmail=supplierEmail;
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
}

