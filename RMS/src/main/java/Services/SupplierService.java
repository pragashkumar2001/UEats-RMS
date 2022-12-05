package Services;

import DB.DatabaseConnection;
import Models.Enums.EventType;
import Models.Order;
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


}
