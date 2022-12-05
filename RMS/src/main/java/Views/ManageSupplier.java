package Views;

import javax.swing.*;

import Controllers.OrderController;
import Controllers.SupplierController;

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




}

