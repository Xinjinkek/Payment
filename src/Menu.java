import javax.swing.*;

public class Menu extends JFrame {
    private JPanel mainPanel;
    private JPanel panelShopInfo;
    private JLabel labelShopName;
    private JLabel labelShopAddress;
    private JLabel labelShopContactNo;
    private JLabel labelShopOperatingHours;

    public Menu(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
    }
}

