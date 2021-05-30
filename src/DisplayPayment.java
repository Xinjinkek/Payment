import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DisplayPayment extends JFrame {

    private JPanel mainPanel;
    private JPanel detailsPanel;
    private JPanel menuPanel;
    private JLabel titleLabel;
    private JLabel labelNameTitle;
    private JLabel labelContact;
    private JLabel labelEmailAddress;
    private JLabel labelCard;
    private JLabel labelDisplayName;
    private JLabel labelDisplayEmail;
    private JLabel labelDisplayContact;
    private JLabel labelDisplayCard;
    private JLabel labelAddress;
    private JLabel labelDisplayAddress;
    private JTable menuDisplayTable;
    private JButton confirmOrderButton;

    public DisplayPayment(String name, String cardN)
    {
        super(name);
        labelDisplayCard.setText(cardN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(300,100,200,200);
        this.pack();
        this.setVisible(true);
        readDetails();
    }

    public void readDetails() {
        try {
            FileReader reader = new FileReader("customer.txt");
            BufferedReader br = new BufferedReader(reader);
            ArrayList<String> s = new ArrayList<String>();
            String line;
            while((line = br.readLine()) != null) {
                s.add(line);
            }
            labelDisplayName.setText(s.get(0));
            labelDisplayEmail.setText(s.get(1));
            labelDisplayContact.setText(s.get(2));
            labelDisplayAddress.setText(s.get(3));
            br.close();
        }
        catch(Exception e){
                e.printStackTrace();
            }
        }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
