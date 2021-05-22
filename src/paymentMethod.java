import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

class cardValidate {

    //declaration of variable
    private boolean validation = false;
    private String cardName;
    private long cardNum; 

    //Constructor
    cardValidate(String cn)
    {
        cardName = cn;
    }

    //Card Validity
    public boolean validate(String cardNum)
    {
        int sum = 0;
        boolean conditionA = false, conditionB = false;

        for (int i = 1; i < cardNum.length(); i += 2)
        {
            int digit = Integer.valueOf(cardNum.substring(i, i+1));
            if (i % 2 == 0)
            {
                digit *= 2;
                sum += (digit / 10) + (digit % 10);
            }
            else
            {
                sum += digit;
            }
        }
        conditionA = true;

        if (cardNum.startsWith("4") && cardName == "Visa")
        {
            conditionB = true;
        }
        else if (cardNum.startsWith("5") && cardName == "MasterCard")
        {
            conditionB = true;
        }
        else
        {
            conditionB = false;
        }

        if (conditionA && conditionB)
        {
            validation = true;
        }

        return validation;

    }
}

public class paymentMethod extends JPanel implements ActionListener {

    //declaration of variables
    private final int WIDTH = 400;
    private final int HEIGHT = 100;

    private JFrame frame;
    private JPanel panel;
    private JComboBox cardChoice;
    private JTextField cardNumber;
    //private JTextField expiryDateTextField;
    private JButton confirmButton = new JButton("Press to confirm");
    private JLabel validateLabel = new JLabel("Pending");
    private JLabel cardNumberLabel, cardChoicesLabel;

    //Constructor
    public paymentMethod()
    {
        //menu
        String[] cardName = {"MasterCard", "Visa"};
        cardChoice = new JComboBox(cardName);
        cardChoice.setSelectedIndex(0);

        cardNumber = new JTextField(16);

        cardChoicesLabel = new JLabel("Please pick a card type");
        cardNumberLabel = new JLabel("Please insert your card number");

        //Set panel
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.add(cardChoicesLabel);
        panel.add(cardChoice);
        panel.add(cardNumber);
        panel.add(confirmButton);
        panel.add(validateLabel);
        confirmButton.addActionListener(this);

        //Set frame
        frame = new JFrame("Selection Payment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String number = cardNumber.getText();
        String name = (String) cardChoice.getSelectedItem();

        cardValidate card = new cardValidate(name);
        if (card.validate(number))
        {
            validateLabel.setText("Card is valid, we will process in short");
        }
        else
        {
            validateLabel.setText("Card is invalid");
        }

    }
}
