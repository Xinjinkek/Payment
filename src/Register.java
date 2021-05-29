import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


        //Action Listener RegisterJButton
        RegisterJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display message
                if(NameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() ||
                        ContactTextField.getText().isEmpty() || AddressTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Register Not Successful");
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



