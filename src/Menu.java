import javax.swing.*;

public class Menu extends JFrame {
    private JPanel mainPanel;
    private JPanel panelShopInfo;
    private JLabel labelShopName;
    private JLabel labelShopAddress;
    private JLabel labelShopContactNo;
    private JLabel labelShopOperatingHours;
    private JPanel panelBurger;
    private JPanel panelSoftDrinks;
    private JPanel panelSideDishes;
    private JLabel labelChickenBurger;
    private JLabel labelBeefBurger;
    private JLabel labelBenjo;
    private JLabel labelHotDog;
    private JLabel labelFoodQuantity;
    private JTextField textFieldChickenBurge;
    private JTextField textFieldBeefBurger;
    private JTextField textFieldBenjo;
    private JTextField textFieldHotdog;
    private JLabel labelDrinksCoke;
    private JLabel labelDrinks100plus;
    private JLabel labelDrinksSprite;
    private JLabel labelDrinksFanta;
    private JLabel labelDrinksQuantity;
    private JTextField textFieldCoke;
    private JTextField textField100Plus;
    private JTextField textFieldSprite;
    private JTextField textFieldFanta;
    private JLabel labelSideDishesFries;
    private JLabel labelSideDishesOnionRing;
    private JLabel labelSideDishesSquidRing;
    private JLabel labelSideDishesCurlyFries;
    private JLabel labelSideDishesNuggets;
    private JLabel labelSideDishesWedges;
    private JLabel labelSideDishesQuantity;
    private JTextField textField1;

    public Menu(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
    }
}

