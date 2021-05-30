import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;

public class Register extends JFrame {
    //Declare variable
    private JPanel Panel;
    private JLabel Title;
    private JLabel NameLabel, EmailLabel, ContactNumberLabel, AddressLabel;
    private JButton RegisterJButton;
    private JTextField NameTextField;
    private JTextField emailTextField;
    private JTextField ContactTextField;
    private JTextField AddressTextField;

    public Register(String title) {

        super(title);
        this.setContentPane(Panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        //Name input validation
        //Only allow alphabet to be entered
        NameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c))
                {
                    NameTextField.setEditable(true);
                }
                else
                {
                    NameTextField.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Please Enter Alphabet Only");
                }
            }
        });

        //Contact number input validation
        //Only allow numbers to be entered
        ContactTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String phoneNumber = ContactTextField.getText();
                int length = phoneNumber.length();
                super.keyTyped(e);
                char c = e.getKeyChar();

                if(Character.isLetter(c))
                {
                    ContactTextField.setEditable(false);
                    JOptionPane.showMessageDialog(null,"Please Enter Number Only");
                }
                else
                {
                    if(length < 11)
                    {
                        ContactTextField.setEditable(true);
                    }
                    else
                    {
                        ContactTextField.setEditable(false);
                        JOptionPane.showMessageDialog(null, "You've already exceed the number");
                    }

                }

            }
        });

        //Action Listener RegisterJButton
        //To display message of successful or failure of registration
        //To save information of registration into text file
        RegisterJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //To save info into text file
                String name = NameTextField.getText();
                String email = emailTextField.getText();
                String contact = ContactTextField.getText();
                String address = AddressTextField.getText();

                try {

                    FileWriter Writer = new FileWriter("customer.txt");
                    Writer.write(name + "\n" + email + "\n" + contact + "\n" + address);
                    Writer.close();

                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }

                // To display message
                if(NameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() ||
                        ContactTextField.getText().isEmpty() || AddressTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please Fill in the empty Space");
                }
                else
                {
                    //Display Register Successful Message
                    JOptionPane.showMessageDialog(null, "Register Successful!");

                    //Move to menu Window
                    new Menu("Main Menu").setVisible(true);

                    //Dispose old Window
                    dispose();
                }

            }
        });



    }


    //Custom Create Component from .form
    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}


//Code to pass the value of the name, address, contact

    /* new displayPayment(name, address, contact number);
    * will need to create a new constructor to pass the details to payment
    * hence, declaration of
    * String name = NameLabel.getText()
    * String address = AddressLabel.getText()
    * String contact = ContactNumberLabel.getText()*/



