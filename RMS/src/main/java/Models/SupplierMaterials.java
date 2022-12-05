package Models;

public class SupplierMaterials {
    private int id;
    private int materialID;

    public SupplierMaterials(){

    }
    public SupplierMaterials(int id,int materialID){
        this.id=id;
        this.materialID=materialID;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }
}


