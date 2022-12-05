package Views;

import Controllers.LoginController;
import Controllers.OrderController;
import Models.Enums.*;
import Models.FoodItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class
CustomerCreateOrder extends JFrame {
    private JTable tblCart;
    private JComboBox cbFoodType;
    private JComboBox cbSize;
    private JComboBox cbEventType;
    private JComboBox cbTopping;
    private JButton btnAddItem;
    private JButton btnPlaceOrder;
    private JComboBox cbDrink;
    private JLabel lblFoodType;
    private JLabel lblEventType;
    private JLabel lblSize;
    private JLabel lblTopping;
    private JLabel lblDrink;
    private JLabel lblQuantity;
    private JSpinner spnQuantity;
    private DefaultTableModel model;
    private OrderController orderController;
    private FoodType selectedFoodType;
    private EventType selectedEventType;
    private Size selectedSize;
    private Topping selectedTopping;
    private Drink selectedDrink;

    public JPanel backPanel;
    private JLabel lblTotalAmount;
    private JButton btnClearItem;

    public CustomerCreateOrder() {
        orderController = new OrderController();
        model = new DefaultTableModel();
        spnQuantity.setModel(new SpinnerNumberModel(1, 1, 50, 1));
        loadTable();
        loadFoodTypes();
        loadEventTypes();
        loadSizes();
        loadTopping();
        loadDrink();
        addToCart();
        proceedOrder();

        btnClearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    int index = tblCart.getSelectedRow();
                    model.removeRow(index);
                    orderController.removeCartItem(index);
                    lblTotalAmount.setText("Rs. " + orderController.getCartTotal());
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(backPanel, "Please select an item to clear!!!", "Error", 0);
                }
            }
        });
    }

    public void loadTable() {
        model.addColumn("Food Type");
        model.addColumn("Size");
        model.addColumn("Topping");
        model.addColumn("Drink");
        model.addColumn("Quantity");
        model.addColumn("Item Cost");
        model.addColumn("Total Amount");
        tblCart.setModel(model);
        tblCart.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblCart.setFillsViewportHeight(true);
    }


    public void loadFoodTypes() {
        selectedFoodType = FoodType.PIZZA;

        String items[] = FoodType.items();

        for (String item : items) {
            cbFoodType.addItem(item);
        }

        cbFoodType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    selectedFoodType = FoodType.valueOf(cbFoodType.getSelectedItem().toString());
                }
            }
        });
    }

    public void loadEventTypes() {
        selectedEventType = EventType.BIRTHDAY;
        String events[] = EventType.events();

        for (String event : events) {
            cbEventType.addItem(event);
        }
        cbEventType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    selectedEventType = EventType.valueOf(cbEventType.getSelectedItem().toString());
                }
            }
        });
    }

    public void loadSizes() {
        selectedSize = Size.SMALL;
        String sizes[] = Size.sizes();

        for (String size : sizes) {
            cbSize.addItem(size);
        }
        cbSize.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    selectedSize = Size.valueOf(cbSize.getSelectedItem().toString());
                }
            }
        });
    }

    public void loadTopping() {
        selectedTopping = Topping.NONE;
        String toppings[] = Topping.toppings();

        for (String topping : toppings) {
            cbTopping.addItem(topping);
        }
        cbTopping.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    selectedTopping = Topping.valueOf(cbTopping.getSelectedItem().toString());
                }
            }
        });
    }

    public void loadDrink() {
        selectedDrink = Drink.NONE;
        String drinks[] = Drink.drinks();

        for (String drink : drinks) {
            cbDrink.addItem(drink);
        }
        cbDrink.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    selectedDrink = Drink.valueOf(cbDrink.getSelectedItem().toString());
                }
            }
        });
    }

    public void addToCart() {
        btnAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(spnQuantity.getValue().toString());
                FoodItem foodItem = orderController.addFoodToCart(quantity, selectedFoodType, selectedSize, selectedTopping, selectedDrink);
                model.addRow(new Object[]{selectedFoodType, selectedSize, selectedTopping, selectedDrink, quantity, "Rs." + foodItem.getItemCost(), "Rs." + foodItem.getTotalAmount()});
                JOptionPane.showMessageDialog(backPanel, "Item Added Successfully!!!", "Success", 1);
                lblTotalAmount.setText("Rs. " + orderController.getCartTotal());
            }
        });
    }

    public void proceedOrder() {
        btnPlaceOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderController.proceedOrder(selectedEventType, LoginController.currentUser.getEmail());
                JOptionPane.showMessageDialog(backPanel, "Order Placed Successfully!!!", "Success", 1);
                dispose();
            }
        });
    }
}
