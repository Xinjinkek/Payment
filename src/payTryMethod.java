import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class payTryMethod extends JFrame {

    private JPanel main;
    private JTextField cardNumber;
    private JComboBox cardChoice;
    private JLabel cardChoicesLabel;
    private JLabel cardNumberLabel;
    private JButton confirmButton;
    private JLabel validateLabel;
    private JLabel expiryLabel;
    private JComboBox expiryMonth;
    private JComboBox expiryYear;

    public payTryMethod(String title) {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(main);
        this.pack();
        this.setVisible(true);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = cardNumber.getText();
                String name = (String) cardChoice.getSelectedItem();

                cardValidate card = new cardValidate(name);
                if (card.validate(number))
                {
                    validateLabel.setText("Card is valid, we will process in short");
                    new displayPayment("Order Summary", number).setVisible(true); //make the new Frame Visible

                    dispose(); //dispose the previous Frame
                }
                else
                {
                    validateLabel.setText("Card is invalid, please enter a valid card number.");
                }
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        String[] card = {"MasterCard", "Visa"};
        cardChoice = new JComboBox(card);
        cardChoice.setSelectedIndex(0);

        String[] month = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        expiryMonth = new JComboBox(month);
        expiryMonth.setSelectedIndex(0);

        String[] year = {"2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};
        expiryYear = new JComboBox(year);
        expiryYear.setSelectedIndex(0);


    }
}
