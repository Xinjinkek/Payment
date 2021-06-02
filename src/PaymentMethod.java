import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PaymentMethod extends JFrame {

    //Declaration of variables
    private JPanel main;
    private JTextField textFieldCardNumber;
    private JComboBox comboBoxCardChoice;
    private JLabel cardChoicesLabel;
    private JLabel cardNumberLabel;
    private JButton confirmButton;
    private JLabel titleLabel;

    //Constructor
    public PaymentMethod(String title) {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(main);
        this.setSize(350,200);
        this.setLocationRelativeTo(null); //Set the window to the centre of the screen
        this.setVisible(true);


        //Action Listener confirm Button to Validate card for payment
        //Will display error message if the input of credit card type is faulty
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = textFieldCardNumber.getText();
                String name = (String) comboBoxCardChoice.getSelectedItem();
                String cardNumber = textFieldCardNumber.getText();
                int length = cardNumber.length();

                CardValidate card = new CardValidate(name);
                if (card.validateNumber(number)) {
                    if(length != 16) {
                        JOptionPane.showMessageDialog(null, "Card Invalid, Please Retype!");
                    }
                    else {
                        //Display validation correct for card input
                        JOptionPane.showMessageDialog(null, "You may Proceed to Order Summary");

                        //Visible the frame in Order Summary
                        new DisplayPayment("Order Summary", number).setVisible(true);

                        //To dispose the previous JFrame
                        dispose();
                    }

                }
                else {
                    //Display Error message and request user to re-input
                    JOptionPane.showMessageDialog(null, "Card Invalid, Please Retype!");
                }
            }
        });

        //Key Listener for the verification of credit card
        //Only accepts numeric number
        textFieldCardNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();

                if(Character.isLetter(c)) {
                    textFieldCardNumber.setEditable(false);
                    JOptionPane.showMessageDialog(null,"Only Numeric are applicable");
                }
                else {
                    textFieldCardNumber.setEditable(true);
                }

            }
        });

        //Key Listener where "Enter Key" can be detected
        //Will able to display error message if the input is wrong after pressing "Enter"
        textFieldCardNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()== KeyEvent.VK_ENTER){
                    String number = textFieldCardNumber.getText();
                    String name = (String) comboBoxCardChoice.getSelectedItem();
                    String cardNumber = textFieldCardNumber.getText();
                    int length = cardNumber.length();

                    CardValidate card = new CardValidate(name);
                    if (card.validateNumber(number)) {
                        if(length != 16) {
                            JOptionPane.showMessageDialog(null, "Card Invalid, Please Retype!");
                        }
                        else {
                            //Display validation correct for card input
                            JOptionPane.showMessageDialog(null, "You may Proceed to Order Summary");

                            //Visible the frame in Order Summary
                            new DisplayPayment("Order Summary", number).setVisible(true);

                            //To dispose the previous JFrame
                            dispose();
                        }

                    }
                    else {
                        //Display Error message and request user to re-input
                        JOptionPane.showMessageDialog(null, "Card Invalid, Please Retype!");
                    }

                }
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        //Credit Card ComboBox declaration
        String[] card = {"MasterCard", "Visa"};
        comboBoxCardChoice = new JComboBox(card);
        comboBoxCardChoice.setSelectedIndex(0);

        textFieldCardNumber = new JTextField(16);

    }
}
