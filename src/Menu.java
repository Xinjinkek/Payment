import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Menu extends JFrame {
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
    private JButton buttonReset;
    private JScrollPane scrollPaneOrder;
    public DefaultTableModel dtm;

    double food1, food2, food3, food4;
    double totalFood1, totalFood2, totalFood3, totalFood4;
    double drinks1, drinks2, drinks3, drinks4;
    double totalDrinks1, totalDrinks2, totalDrinks3, totalDrinks4;
    double sides1, sides2, sides3, sides4, sides5, sides6;
    double totalSides1, totalSides2, totalSides3, totalSides4, totalSides5, totalSides6;
    double total = 0;

    double foodTotal;
    double drinksTotal;
    double sidesTotal;

    final static int numberOfFoods = 4;
    final static int numberOfDrinks = 4;
    final static int numberOfSides = 6;

    final static double food1price = 4.0;
    public Menu(String title) {
        super(title);
        this.setBounds(300,100,800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setVisible(true);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register("Register");
                dispose();
            }
        });
       orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //go to payment
                new PaymentMethod("Pay with MasterCard or Visa");
                dispose();

                //save Order detail into a file
                try {
                    FileWriter writer = new FileWriter("Order.txt");
                    BufferedWriter bw = new BufferedWriter(writer);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });

        spinnerChickenBurger.addChangeListener(foodListener);
        spinnerBeefBurger.addChangeListener(foodListener);
        spinnerBenjo.addChangeListener(foodListener);
        spinnerHotdog.addChangeListener(foodListener);

        spinnerCoke.addChangeListener(drinksListener);
        spinner100Plus.addChangeListener(drinksListener);
        spinnerSprite.addChangeListener(drinksListener);
        spinnerFanta.addChangeListener(drinksListener);

        spinnerFries.addChangeListener(sidesListener);
        spinnerOnionRings.addChangeListener(sidesListener);
        spinnerSquidRings.addChangeListener(sidesListener);
        spinnerCurlyFries.addChangeListener(sidesListener);
        spinnerNuggets.addChangeListener(sidesListener);
        spinnerWedges.addChangeListener(sidesListener);

        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu("Main Menu");
                dispose();
            }
        });
    }

    ChangeListener foodListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {

            final int quantity = (int) ((JSpinner) e.getSource()).getValue();
            final int rows = tableOrder.getRowCount();
            for (int row = 0; row < rows; row++) {
                if (dtm.getValueAt(row, 3) == e.getSource()) {
                    if (dtm.getValueAt(row, 0).equals("Chicken Burger")) {
                        dtm.setValueAt(quantity, row, 1); // obj, row, column
                        dtm.setValueAt(food1 * quantity, row, 2);
                        totalFood1 = food1 * quantity;

                    } else if (dtm.getValueAt(row, 0).equals("Beef Burger")) {

                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(food2 * quantity, row, 2);
                        totalFood2 = food2 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Benjo")) {

                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(food3 * quantity, row, 2);
                        totalFood3 = food3 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Hotdog")) {

                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(food4 * quantity, row, 2);
                        totalFood4 = food4 * quantity;
                    }

                    if (quantity == 0) {
                        dtm.removeRow(row);
                    }
                    foodTotal = totalFood1 + totalFood2 + totalFood3 + totalFood4;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    return;
                }
           }

            for (int i = 0; i < numberOfFoods; i++) {
                if (spinnerChickenBurger == e.getSource()) {
                    food1 = 10.00;
                    totalFood1 = food1;
                    foodTotal = totalFood1 + totalFood2 + totalFood3 + totalFood4;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelChickenBurger.getText(), quantity, food1, spinnerChickenBurger });
                    return;
                }
                else if (spinnerBeefBurger == e.getSource()) {
                    food2 = 12.00;
                    totalFood2 = food2;
                    foodTotal = totalFood1 + totalFood2 + totalFood3 + totalFood4;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelBeefBurger.getText(), quantity, food2, spinnerBeefBurger });
                    return;
                }
                else if (spinnerBenjo == e.getSource()) {
                    food3 = 5.00;
                    totalFood3 = food3;
                    foodTotal = totalFood1 + totalFood2 + totalFood3 + totalFood4;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelBenjo.getText(), quantity, food3, spinnerBenjo });
                    return;
                }
                else if (spinnerHotdog == e.getSource()) {
                    food4 = 7.00;
                    totalFood4 = food4;
                    foodTotal = totalFood1 + totalFood2 + totalFood3 + totalFood4;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelHotdog.getText(), quantity, food4, spinnerHotdog });
                    return;
                }

            }
        }
    };
    ChangeListener drinksListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {

            final int quantity = (int) ((JSpinner) e.getSource()).getValue();
            final int rows = tableOrder.getRowCount();
            for (int row = 0; row < rows; row++) {
                if (dtm.getValueAt(row, 3) == e.getSource()) {
                    if (dtm.getValueAt(row, 0).equals("Coke")) {
                        dtm.setValueAt(quantity, row, 1); // obj, row, column
                        dtm.setValueAt(drinks1 * quantity, row, 2);
                        totalDrinks1 = drinks1 * quantity;

                    } else if (dtm.getValueAt(row, 0).equals("100 Plus")) {

                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(drinks2 * quantity, row, 2);
                        totalDrinks2 = drinks2 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Sprite")) {

                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(drinks3 * quantity, row, 2);
                        totalDrinks3 = drinks3 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Fanta")) {

                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(drinks4 * quantity, row, 2);
                        totalDrinks4 = drinks4 * quantity;
                    }

                    if (quantity == 0) {
                        dtm.removeRow(row);
                    }
                    drinksTotal = totalDrinks1 + totalDrinks2 + totalDrinks3 + totalDrinks4;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    return;
                }
            }

            for (int i = 0; i < numberOfSides; i++) {
                if (spinnerCoke == e.getSource()) {
                    drinks1 = 3.00;
                    totalDrinks1 = drinks1;
                    drinksTotal = totalDrinks1 + totalDrinks2 + totalDrinks3 + totalDrinks4;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelCoke.getText(), quantity, drinks1, spinnerCoke});
                    return;
                }
                else if (spinner100Plus == e.getSource()) {
                    drinks2 = 3.00;
                    totalDrinks2 = drinks2;
                    drinksTotal = totalDrinks1 + totalDrinks2 + totalDrinks3 + totalDrinks4;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { label100Plus.getText(), quantity, drinks2, spinner100Plus});
                    return;
                }
                else if (spinnerSprite == e.getSource()) {
                    drinks3 = 3.00;
                    totalDrinks3 = drinks3;
                    drinksTotal = totalDrinks1 + totalDrinks2 + totalDrinks3 + totalDrinks4;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelSprite.getText(), quantity, drinks3, spinnerSprite});
                    return;
                }
                else if (spinnerFanta == e.getSource()) {
                    drinks4 = 3.00;
                    totalDrinks4 = drinks4;
                    drinksTotal = totalDrinks1 + totalDrinks2 + totalDrinks3 + totalDrinks4;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelFanta.getText(), quantity, drinks4, spinnerFanta});
                    return;
                }

            }
        }
    };

    ChangeListener sidesListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {

            final int quantity = (int) ((JSpinner) e.getSource()).getValue();
            final int rows = tableOrder.getRowCount();
            for (int row = 0; row < rows; row++) {
                if (dtm.getValueAt(row, 3) == e.getSource()) {
                    if (dtm.getValueAt(row, 0).equals("Fries")) {
                        dtm.setValueAt(quantity, row, 1); // obj, row, column
                        dtm.setValueAt(sides1 * quantity, row, 2);
                        totalSides1 = sides1 * quantity;

                    } else if (dtm.getValueAt(row, 0).equals("Onion Rings")) {

                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(sides2 * quantity, row, 2);
                        totalSides2 = sides2 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Squid Rings")) {

                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(sides3 * quantity, row, 2);
                        totalSides3 = sides3 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Curly Fries")) {

                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(sides4 * quantity, row, 2);
                        totalSides4 = sides4 * quantity;
                    }else if (dtm.getValueAt(row, 0).equals("Nuggets")) {

                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(sides5 * quantity, row, 2);
                        totalSides5 = sides5 * quantity;
                    }else if (dtm.getValueAt(row, 0).equals("Wedges")) {

                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(sides6 * quantity, row, 2);
                        totalSides6 = sides6 * quantity;
                    }

                    if (quantity == 0) {
                        dtm.removeRow(row);
                    }
                    sidesTotal = totalSides1 + totalSides2 + totalSides3 + totalSides4 + totalSides5 + totalSides6;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    return;
                }
            }

            for (int i = 0; i < numberOfDrinks; i++) {
                if (spinnerFries == e.getSource()) {
                    sides1 = 5.00;
                    totalSides1 = sides1;
                    sidesTotal = totalSides1 + totalSides2 + totalSides3 + totalSides4 + totalSides5 + totalSides6;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelFries.getText(), quantity, sides1, spinnerFries});
                    return;
                }
                else if (spinnerOnionRings == e.getSource()) {
                    sides2 = 7.00;
                    totalSides2 = sides2;
                    sidesTotal = totalSides1 + totalSides2 + totalSides3 + totalSides4 + totalSides5 + totalSides6;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelOnionRings.getText(), quantity, sides2, spinnerOnionRings});
                    return;
                }
                else if (spinnerSquidRings == e.getSource()) {
                    sides3 = 7.00;
                    totalSides3 =  sides3;
                    sidesTotal = totalSides1 + totalSides2 + totalSides3 + totalSides4 + totalSides5 + totalSides6;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelSquidRings.getText(), quantity, sides3, spinnerSquidRings});
                    return;
                }
                else if (spinnerCurlyFries == e.getSource()) {
                    sides4 = 7.00;
                    totalSides4 = sides4;
                    sidesTotal = totalSides1 + totalSides2 + totalSides3 + totalSides4 + totalSides5 + totalSides6;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelCurlyFries.getText(), quantity, sides4, spinnerCurlyFries});
                    return;
                }
                else if (spinnerNuggets == e.getSource()) {
                    sides5 = 8.00;
                    totalSides5 = sides5;
                    sidesTotal = totalSides1 + totalSides2 + totalSides3 + totalSides4 + totalSides5 + totalSides6;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelNuggets.getText(), quantity, sides5, spinnerNuggets});
                    return;
                }
                else if (spinnerWedges == e.getSource()) {
                    sides6 = 7.00;
                    totalSides6 = sides6;
                    sidesTotal = totalSides1 + totalSides2 + totalSides3 + totalSides4 + totalSides5 + totalSides6;
                    total = foodTotal + drinksTotal + sidesTotal;
                    textFieldTotal.setText(total + "");
                    dtm.addRow(new Object[] { labelWedges.getText(), quantity, sides6, spinnerWedges});
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
         tableOrder = new JTable();
         tableOrder.setModel(dtm);
         tableOrder.getColumnModel().getColumn(0).setPreferredWidth(80);
         tableOrder.getColumnModel().getColumn(1).setPreferredWidth(30);
         tableOrder.getColumnModel().getColumn(2).setPreferredWidth(30);
         tableOrder.getColumnModel().getColumn(3).setMinWidth(0);
         tableOrder.getColumnModel().getColumn(3).setMaxWidth(0);
         tableOrder.setShowGrid(false);
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
         centerRenderer.setHorizontalAlignment( JLabel.CENTER );
         tableOrder.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
         tableOrder.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
         tableOrder.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );



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

