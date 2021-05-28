import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
    private JLabel lebelBenjo;
    private JLabel labelHotdog;
    private JSpinner spinnerChickenBurger;
    private JSpinner spinnerBeefBurger;
    private JSpinner spinnerBenjo;
    private JSpinner spinnerHotdog;
    private JLabel labelCoke;
    private JLabel label100Plus;
    private JLabel labelSprite;
    private JLabel labelFanta;
    private JSpinner spinner1;
    private JSpinner spinnerCoke;
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
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        dtm = new DefaultTableModel(0, 0);
        final String header[] = new String[] { "Item", "Qty", "Price", "Spinner" };
        dtm.setColumnIdentifiers(header);
        dtm.addRow(header);
        tableOrder = new JTable();
        tableOrder.setModel(dtm);
        tableOrder.setBounds(475, 31, 1, 1); // int x, int y, int width, int height
        tableOrder.setSize(245, 300); // width,height
        tableOrder.getColumnModel().getColumn(0).setPreferredWidth(80);
        tableOrder.getColumnModel().getColumn(1).setPreferredWidth(30);
        tableOrder.getColumnModel().getColumn(2).setPreferredWidth(30);

        //spinner
        SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1);
        SpinnerNumberModel spnummodel1 = new SpinnerNumberModel(0, 0, 10, 1);
        SpinnerNumberModel spnummodel2 = new SpinnerNumberModel(0, 0, 10, 1);
        SpinnerNumberModel spnummodel3 = new SpinnerNumberModel(0, 0, 10, 1);


        spinnerChickenBurger = new JSpinner(spnummodel);
        spinnerBeefBurger = new JSpinner(spnummodel1);
        spinnerBenjo = new JSpinner(spnummodel2);
        spinnerHotdog = new JSpinner(spnummodel3);

    }
}

