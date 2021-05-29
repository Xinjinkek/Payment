import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu extends JFrame {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel panelShopInfo;
    private JLabel labelShopName;
    private JLabel labelShopAddress;
    private JLabel labelShopContactNo;
    private JLabel labelShopOperatingHours;
    private JTabbedPane tabbedPaneItem;
    private JPanel panelItem;
    private JPanel panelOrder;
    private JLabel labelOrder;
    private JPanel panelFood;
    private JLabel labelChickenBurger;
    private JLabel labelBeefBurger;
    private JLabel labelBenjo;
    private JLabel labelHotdog;
    private JSpinner spinnerChickenBurger;
    private JSpinner spinnerBeefBurger;
    private JSpinner spinnerBenjo;
    private JSpinner spinnerHotdog;
    private JLabel labelCoke;
    private JLabel label100Plus;
    private JLabel labelSprite;
    private JLabel labelFanta;
    private JSpinner spinnerCoke;
    private JSpinner spinnerFanta;
    private JSpinner spinner100Plus;
    private JSpinner spinnerSprite;
    private JPanel panelDrinks;
    private JLabel labelFries;
    private JLabel labelOnionRings;
    private JLabel labelSquidRings;
    private JLabel labelCurlyFries;
    private JLabel labelNuggets;
    private JLabel labelWedges;
    private JSpinner spinnerFries;
    private JSpinner spinnerOnionRings;
    private JSpinner spinnerSquidRings;
    private JSpinner spinnerCurlyFries;
    private JSpinner spinnerNuggets;
    private JPanel panelSides;
    private JSpinner spinnerWedges;
    private JLabel labelTotal;
    private JTextField textFieldTotal;
    private JButton orderButton;
    private JButton backButton;
    private JTable tableOrder;
    private JPanel panelTotal;
    public DefaultTableModel dtm;

    double f1, f2, f3, f4;
    double food1, food2, food3, food4;
    double d1, d2, d3, d4;
    double drinks1, drinks2, drinks3, drinks4;
    double s1, s2, s3, s4, s5, s6;
    double sides1, sides2, sides3, sides4, sides5, sides6;
    double total = 0;
    double totalPrice = 0;

    double foodTotal;
    double drinksTotal;
    double sidesTotal;

    final static int numberOfFoods = 4;
    final static int numberOfDrinks = 4;
    final static int numberOfSides = 6;

    final static double food1price = 4.0;
    public Menu(String title) {
        //super(title);
        frame = new JFrame(title);
        frame.setBounds(300,100,800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
        //createUIComponents();


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register register = new Register("Register");
                frame.dispose();
            }
        });
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            PaymentMethod payment = new PaymentMethod("Pay with MasterCard or Visa");
            frame.dispose();
            }
        });

        spinnerChickenBurger.addChangeListener(listener);
        spinnerBeefBurger.addChangeListener(listener);
    }

    ChangeListener listener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {

            final int quantity = (int) ((JSpinner) e.getSource()).getValue();
            final int rows = tableOrder.getRowCount();
            for (int row = 0; row < rows; row++) {
                if (dtm.getValueAt(row, 3) == e.getSource()) {
                    if (dtm.getValueAt(row, 0).equals("Chicken Burger")) {
                        dtm.setValueAt(quantity, row, 1); // obj, row, column
                        dtm.setValueAt(f1 * quantity, row, 2);
                        food1 = f1 * quantity;

                    } else if (dtm.getValueAt(row, 0).equals("Beef Burger")) {

                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(f2 * quantity, row, 2);
                        food2 = f2 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Benjo")) {

                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(f3 * quantity, row, 2);
                        food3 = f3 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Hotdog")) {

                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(f4 * quantity, row, 2);
                        food4 = f4 * quantity;
                    }

                    if (quantity == 0) {
                        dtm.removeRow(row);
                    }
                    foodTotal = food1 + food2 + food3 + food4;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    return;
                }
           }

            // there was no row with this JSpinner, so we have to add it
            for (int i = 0; i < numberOfFoods; i++) {
                // looking for the "clicked" JSpinner
                if (spinnerChickenBurger == e.getSource()) {
                    totalPrice = food1price;
                    f1 = 4.0;
                    food1 =f1;
                    foodTotal = food1 + food2 + food3 + food4;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelChickenBurger.getText(), quantity, totalPrice, spinnerChickenBurger });
                    return;
                }
                else if (spinnerBeefBurger == e.getSource()) {
                  //  totalPrice = foodprice;
                    f2 = 5.0;
                    food2 =f2;
                    foodTotal = food1 + food2 + food3 + food4;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelBeefBurger.getText(), quantity, f2*quantity, spinnerBeefBurger });
                    return;
                }


            }
        }
    };

     void createUIComponents() {
        // TODO: place custom component creation code here
        dtm = new DefaultTableModel(0, 0);
        final String header[] = new String[] { "Item", "Qty", "Price", "Spinner" };
        dtm.setColumnIdentifiers(header);
        dtm.addRow(header);
        tableOrder = new JTable();
        tableOrder.setModel(dtm);
        tableOrder.getColumnModel().getColumn(0).setPreferredWidth(80);
        tableOrder.getColumnModel().getColumn(1).setPreferredWidth(30);
        tableOrder.getColumnModel().getColumn(2).setPreferredWidth(30);
        tableOrder.getColumnModel().getColumn(3).setMinWidth(0);
        tableOrder.getColumnModel().getColumn(3).setMaxWidth(0);
        tableOrder.setShowGrid(false);

        //initialize spinner model
        spinnerChickenBurger = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        spinnerBeefBurger = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        spinnerBenjo = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        spinnerHotdog = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        spinnerCoke = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        spinner100Plus = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        spinnerSprite = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        spinnerFanta = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        spinnerFries = new JSpinner(new SpinnerNumberModel(0,0,10,1));;
        spinnerOnionRings = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        spinnerSquidRings = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        spinnerCurlyFries = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        spinnerNuggets = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        spinnerWedges = new JSpinner(new SpinnerNumberModel(0,0,10,1));


    }
}

