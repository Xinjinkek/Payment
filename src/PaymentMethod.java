import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentMethod extends JFrame {

    //Declaration
    private JPanel main;
    private JTextField cardNumber;
    private JComboBox cardChoice;
    private JLabel cardChoicesLabel;
    private JLabel cardNumberLabel;
    private JButton confirmButton;
    private JLabel expiryLabel;
    private JComboBox expiryMonth;
    private JComboBox expiryYear;
    private JLabel titleLabel;

    public PaymentMethod(String title) {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(main);
        this.pack();
        this.setVisible(true);

        //Action Listener confirm Button to Validate card for payment
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = cardNumber.getText();
                String name = (String) cardChoice.getSelectedItem();

                cardValidate card = new cardValidate(name);
                if (card.validate(number))
                {
                    //Display validation correct for card input
                    JOptionPane.showMessageDialog(null, "You may Proceed to Order Summary");

                    //Visible the frame in Order Summary
                    new displayPayment("Order Summary", number).setVisible(true);

                    //To dispose the previous JFrame
                    dispose();
                }
                else
                {
                    //Display Error message and request user to re-input
                    JOptionPane.showMessageDialog(null, "Card Invalid, Please Retype!");

                }
            }
        });
    }


    //Custom Create Component from .form
    private void createUIComponents() {
        // TODO: place custom component creation code here

        //Credit Card ComboBox declaration
        String[] card = {"MasterCard", "Visa"};
        cardChoice = new JComboBox(card);
        cardChoice.setSelectedIndex(0);

        //Expiry Month ComboBox declaration
        String[] month = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        expiryMonth = new JComboBox(month);
        expiryMonth.setSelectedIndex(0);

        //Expiry Year ComboBox declaration
        String[] year = {"2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};
        expiryYear = new JComboBox(year);
        expiryYear.setSelectedIndex(0);


    }
}
