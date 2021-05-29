import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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
        readDetails();
    }

    public void readDetails() {
        try {
            FileReader reader = new FileReader("D:\\Github\\OOP assignment\\storage\\customer.txt");
            BufferedReader br = new BufferedReader(reader);
            ArrayList<String> s = new ArrayList<String>();
            String line;
            while((line = br.readLine()) != null) {
                s.add(line);
            }
            labelDisplayName.setText(s.get(0));
            labelDisplayContact.setText(s.get(1));
            labelDisplayAddress.setText(s.get(2));
            labelDisplayCard.setText(s.get(3));
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
