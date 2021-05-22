import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

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
    private JLabel validateLabel, cardNumberLabel, cardChoicesLabel;

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

    }
}
