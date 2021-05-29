import javax.swing.*;

public class displayPayment extends JFrame {

    private JPanel mainPanel;
    private JPanel detailsPanel;
    private JPanel menuPanel;
    private JTable menuDisplayTable;
    private JLabel titleLabel;
    private JLabel labelNameTitle;
    private JLabel labelContact;
    private JLabel labelAddress;
    private JLabel labelCard;
    private JLabel labelDisplayName;
    private JLabel labelDisplayContact;
    private JLabel labelDisplayAddress;
    private JLabel labelDisplayCard;

    public displayPayment(String name, String cardN)
    {
        super(name);
        labelDisplayCard.setText(cardN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
    }



    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
