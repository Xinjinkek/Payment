import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DisplayPayment extends JFrame {
    private JPanel panel1;
    private JPanel detailsPanel;
    private JPanel menuPanel;
    private JPanel titlePanel;
    private JLabel labelTitle;
    private JTable menuDisplayTable;
    private JButton confirmOrderButton;
    private JLabel labelName;
    private JLabel labelDisplayName;
    private JLabel labelEmail;
    private JLabel labelDisplayEmail;
    private JLabel labelContact;
    private JLabel labelDisplayContact;
    private JLabel labelAddress;
    private JLabel labelDisplayAddress;
    private JLabel labelCard;
    private JLabel labelDisplayCard;
    private JButton cancelButton;
    private DefaultTableModel model;

    //Constructor
    public DisplayPayment(String name, String cardN)
    {
        super(name);
        labelDisplayCard.setText(cardN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        readCustDetails();

        confirmOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null,"Thank you! Please wait while we are " +
                        "preparing your order !");
                new UserRating("User Experience");
            }
        });

        confirmOrderButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode()== KeyEvent.VK_ENTER){
                    dispose();
                    JOptionPane.showMessageDialog(null,"Thank you! Please wait while we are " +
                            "preparing your order !");
                    new UserRating("User Experience");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fileName = "customer.txt";

                try {

                    Files.delete(Paths.get(fileName));
                    Files.delete(Paths.get("Order.txt"));

                }
                catch (IOException exception)
                {
                    exception.printStackTrace();
                }

                System.exit(0);
            }
        });
    }

    public void readCustDetails() {
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


    public void readOrderDetails(){
        try {
            FileReader reader = new FileReader("Order.txt");
            BufferedReader br = new BufferedReader(reader);

            DefaultTableModel tableModel = (DefaultTableModel)menuDisplayTable.getModel();
            Object[] lines = br.lines().toArray();

            for (int i = 0; i < lines.length; i++){
                String[] row = lines[i].toString().split("\t");
                tableModel.addRow(row);
            }
            br.close();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        model = new DefaultTableModel(0, 0);
        final String header[] = new String[] { "Item", "Qty", "Price"};
        model.setColumnIdentifiers(header);
        model.addRow(header);
        menuDisplayTable = new JTable();
        menuDisplayTable.setModel(model);
        readOrderDetails();
    }
}
