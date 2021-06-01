import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;

public class Register extends JFrame {

    //Declaration of variables
    private JPanel Panel;
    private JLabel Title;
    private JLabel NameLabel, EmailLabel, ContactNumberLabel, AddressLabel;
    private JButton RegisterJButton;
    private JTextField NameTextField;
    private JTextField emailTextField;
    private JTextField ContactTextField;
    private JTextField AddressTextField;

    //Constructor
    public Register(String title) {

        //Declaration of variables
        super(title);
        this.setContentPane(Panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        //Key Listener for the Name input validation
        //Only allow alphabet to be entered
        NameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
                    NameTextField.setEditable(true);
                }
                else {
                    NameTextField.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Please Enter Alphabet Only");
                }
            }
        });

        //Key Listener for the Contact number input validation
        //Only allow numbers to be entered
        ContactTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                String phoneNumber = ContactTextField.getText();
                int length = phoneNumber.length();
                char c = e.getKeyChar();

                if(Character.isLetter(c)) {
                    ContactTextField.setEditable(false);
                    JOptionPane.showMessageDialog(null,"Please Enter Number Only");
                }
                else {
                    ContactTextField.setEditable(true);

                }
            }
        });



        //Action Listener Register button
        //To display message of successful or failure of registration
        //To save information of registration into text file
        RegisterJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //To save info into text file
                //Info is retrieved from the user input
                String name = NameTextField.getText();
                String email = emailTextField.getText();
                String contact = ContactTextField.getText();
                String address = AddressTextField.getText();
                String phoneNumber = ContactTextField.getText();
                int length = phoneNumber.length();
                EmailValidate status = new EmailValidate();

                try {
                    FileWriter Writer = new FileWriter("Customer.txt");
                    Writer.write(name + "\n" + email + "\n" + contact + "\n" + address);
                    Writer.close();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }

                // To display message
                if(NameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() ||
                        ContactTextField.getText().isEmpty() || AddressTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Fill in the Empty Space");
                }
                else if(length != 10 && length!= 11 ) {
                    JOptionPane.showMessageDialog(null, "Contact number invalid");
                }
                else if(status.eValidate(email) == false)
                {
                    JOptionPane.showMessageDialog(null, "Email Error!");
                }
                else {
                    //Display Register Successful Message
                    JOptionPane.showMessageDialog(null, "Register Successful!");

                    //Move to menu Window
                    new Menu("Main Menu").setVisible(true);

                    //Dispose old Window
                    dispose();
                }


            }
        });


        //Key Listener where "Enter Key" can be detected
        //Provide same function as the "Register" button
        AddressTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()== KeyEvent.VK_ENTER) {
                    //To save info into text file
                    //Info is retrieved from the user input
                    String name = NameTextField.getText();
                    String email = emailTextField.getText();
                    String contact = ContactTextField.getText();
                    String address = AddressTextField.getText();
                    String phoneNumber = ContactTextField.getText();
                    EmailValidate status = new EmailValidate();
                    int length = phoneNumber.length();

                    try {
                        FileWriter Writer = new FileWriter("Customer.txt");
                        Writer.write(name + "\n" + email + "\n" + contact + "\n" + address);
                        Writer.close();
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    // To display message
                    if(NameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() ||
                            ContactTextField.getText().isEmpty() || AddressTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Fill in the Empty Space");
                    }
                    else if(length != 10 && length!= 11 ) {
                        JOptionPane.showMessageDialog(null, "Contact number invalid");
                    }
                    else if(status.eValidate(email) == false) {
                        JOptionPane.showMessageDialog(null, "Email Error!");
                    }
                    else {
                        //Display Register Successful Message
                        JOptionPane.showMessageDialog(null, "Register Successful!");

                        //Move to menu Window
                        new Menu("Main Menu").setVisible(true);

                        //Dispose old Window
                        dispose();
                    }
                }
            }
        });
    }

}



