import javax.swing.*;
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
    DefaultTableModel dtm;

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
    }

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

