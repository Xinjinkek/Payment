import javax.swing.*;
import java.awt.*;

class paymentMethod extends JFrame{

    //declaration
    private JPanel mainPanel;
    private JTextField cardNumberTextField;
    private JTextField expiryDateTextField;
    private JButton confirmButton;
    private JLabel validateLabel, expiryDateLabel, cardNumberLabel;

    public paymentMethod(String title)
    {
        super (title);
        this.setContentPane(mainPanel);
        this.pack();
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
