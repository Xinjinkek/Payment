import javax.swing.*;

public class displayPayment extends JFrame {

    private JPanel mainPanel2;
    private JLabel paneTitle;
    private JLabel details;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel cardNumberLabel;
    private JLabel displayCardNumLabel;
    private JLabel displayCustomerNameLabel;
    private JLabel displayAddressLabel;

    public displayPayment(String name) //String cardN)
    {
        super(name);
        //displayCardNumLabel.setText(cardN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel2);
        this.pack();
        this.setVisible(true);
    }



    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
