/*package Views;

import Controllers.SupplierController;
import Models.Supplier;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ManageSupplier extends JFrame {
    public JPanel backPanel;
    private JButton button1;
    private JTable table1;
    private JButton button2;
}*/
package Views;

        import Controllers.SupplierController;
        import Models.Supplier;

        import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

/**
 * @author G.A.V.Parindi
 * @SA_No SA22406194
 */
public class ManageSupplier extends JFrame {
    private JTable table1;
    private JButton viewSupplier;
    private JButton assignSupplierButton;
    private JButton updateSupplierButton;
    private JButton addSupplierButton;
    private DefaultTableModel model;
    private ManageSupplier SupplierController;

    public JPanel backPanel;
    private JButton button1;

    public ManageSupplier() {
        model = new DefaultTableModel();
        supplierController = new ManageSupplier();

        loadTable();

        addSupplierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ManageSupplier ManageSupplierUi = new ManageSupplier();
                ManageSupplierUi.setContentPane(ManageSupplierUi.backPanel);
                ManageSupplierUi.setTitle("UEATS: Supplier Form");
                ManageSupplierUi.setSize(1000, 600);
                ManageSupplierUi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ManageSupplierUi.setLocationRelativeTo(null);
                ManageSupplierUi.setVisible(true);
            }
        });
    }

    public void loadTable() {
        model.addColumn("Supplier ID");
        model.addColumn("Supplier Name");
        model.addColumn("Supplier Email");
        model.addColumn("Su");
        model.addColumn("Total Amount");
        model.addColumn("Status");
        model.addColumn("Employee Email");
        table1.setModel(model);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFillsViewportHeight(true);

        for (Supplier supplier : supplierController.getSuppliers()) {
            if (supplier.getEmpEmail() == null) {
                supplier.setEmpEmail("Unassigned");
            }
            model.addRow(new Supplier[]{supplier.getId(), order.getCustomerEmail(), order.getOrderDate(), order.getEventType(), "Rs." + order.getBillAmount(), order.getStatus(), order.getEmpEmail()});
        }

    }
}