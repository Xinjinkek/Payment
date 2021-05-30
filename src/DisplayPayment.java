import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private DefaultTableModel model;

    public DisplayPayment(String name, String cardN)
    {
        super(name);
        labelDisplayCard.setText(cardN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setUndecorated(false);
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
                }
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
