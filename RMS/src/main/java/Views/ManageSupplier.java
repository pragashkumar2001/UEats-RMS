package Views;

import javax.swing.*;

import Controllers.OrderController;
import Controllers.SupplierController;
import Models.Order;
import Models.Supplier;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * @author G.A.V.Parindi
 * @SA_No SA22406194
 * */
public class ManageSupplier extends JFrame {
    public JPanel backPanel;
    private JTable tblSupplier;
    private JTextField txtSupName;
    private JTextField txtSupId;
    private JTextField txtSupEmail;
    private JTextField txtMId;
    private JTextField txtMName;
    private JTextField txtCost;
    private JTextField txtQuantity;
    private JButton Btnsearch;
    private JButton Btnadd;
    private JButton Btnupdate;
    private JButton Btndelete;
    private JButton Btnback;

    private DefaultTableModel model;

    private SupplierController supplierController;

    private ArrayList<String> SupplierIdList;



    public void loadTable() {
        model.addColumn("Supplier ID");
        model.addColumn("Supplier Name");
        model.addColumn("Supplier Email");
        model.addColumn("Material ID");
        model.addColumn("Material Name");
        model.addColumn("Material Cost");
        model.addColumn("Quantity");
        tblSupplier.setModel(model);
        tblSupplier.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblSupplier.setFillsViewportHeight(true);

        for (Supplier supplier : supplierController.getSuppliers()) {
            SupplierIdList.add(String.valueOf(supplier.getId()));
            model.addRow(new Object[]{supplier.getId(), supplier.getSupplierName(), supplier.getSupplierEmail(), supplier.getMaterialID(), supplier.getMaterialName(), "Rs." + supplier.getCost(), supplier.getQuantity()});
        }
    }
}

