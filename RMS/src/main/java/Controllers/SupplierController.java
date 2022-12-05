package Controllers;

import Models.Order;
import Models.Supplier;
import Services.FoodItemService;
import Services.OrderService;
import Services.SupplierService;

import java.util.ArrayList;

public class SupplierController{
    private SupplierService supplierService;

    public SupplierController() {

        supplierService = new SupplierService();
    }
    public ArrayList<Supplier> getSuppliers() {
        return supplierService.getSupplier();
    }
}
