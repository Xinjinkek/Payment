import javax.swing.*;

public class displayPayment extends JFrame {

    private JPanel mainPanel2;
    private JLabel paneTitle;
    private JLabel details;
    private JLabel displayName;
    private JLabel displayAddress;
    private JLabel customerName;
    private JLabel menuList;


    public displayPayment(String name, String n)
    {
        super(name);
        customerName.setText(n);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel2);
        this.pack();
        this.setVisible(true);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
