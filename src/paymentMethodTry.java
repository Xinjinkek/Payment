import javax.swing.*;
import java.awt.*;

class paymentMethodTry extends JFrame{

    //declaration
    private JPanel mainPanel;
    private JTextField cardNumberTextField;
    private JTextField expiryDateTextField;
    private JButton confirmButton;
    private JLabel validateLabel, expiryDateLabel, cardNumberLabel;

    public paymentMethodTry(String title)
    {
        super (title);
        this.setContentPane(mainPanel);
        this.pack();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
       validateLabel = new JLabel("Invalid number");
        validateLabel.setText("Invalidate");

    }



    //credit card number validation
    //base on the Luhn Checksum algorithm
    public boolean cardNumberValidation(String number)
    {
        int sum = 0;
        for(int i=0; i<number.length(); i++)
        {
            int digit = Integer.valueOf(number.substring(i, i+1));
            if(i % 2 == 0)
            {
                digit *= 2;
                sum += (digit / 10) + (digit % 10);
            }
            else
            {
                sum += digit;
            }
        }
        return (sum % 10 == 0);
    }



}
