package Services;

import DB.DatabaseConnection;
import Models.Supplier;

import java.sql.ResultSet;
import java.util.ArrayList;

/*@author G.A.V.Parindi
 * @SA_No SA22406194
* */
public class SupplierService {
    private DatabaseConnection singleConn;
    public SupplierService() {
        singleConn = DatabaseConnection.getSingleInstance();
    }
    public ArrayList<Supplier> getSupplier() {
        ArrayList<Supplier> suppliers = new ArrayList<>();

        try {
            String query = "SELECT sup.id, sup.supplierName, sup.supplierEmail, mat.materialID, mat.materialName, mat.cost, mat.quantity FROM supplier sup,material mat,supply_detail sd WHERE sup.id = sd.supId AND mat.materialID = sd.materialID GROUP By sup.id;";
            ResultSet rs = singleConn.ExecuteGetQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    Supplier supplier = new Supplier();
                    supplier.setId(rs.getInt("Supplier ID"));
                    supplier.setSupplierName(rs.getString("Supplier Name"));
                    supplier.setSupplierEmail(rs.getString("Supplier Email"));
                    supplier.setMaterialID(rs.getInt("setMaterialID"));
                    supplier.setMaterialName(rs.getString("MaterialName"));
                    supplier.setCost(rs.getDouble("Cost"));
                    supplier.setQuantity(rs.getInt("Quantity"));
                    suppliers.add(supplier);
                }
            }

        } catch (Exception ex) {
            System.out.println("Cannot insert a Supplier");
        }

        return suppliers;
    }

}
