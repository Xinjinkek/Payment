import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    //Declare variable
    private JPanel Panel;
    private JLabel Title;
    private JLabel Cust_Name, Cust_email, Cust_PhoneNo, Cust_Add;
    private JTextField Name, ContactNo, Address, Address2, Email;
    private JButton Register;

    public Register(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(Panel);
        this.pack();
        this.setVisible(true);


        Name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Cust_Name.equals("")) {
                }
                JOptionPane.showMessageDialog(null, "Enter your Name");

            }
        });

        Email.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Cust_email.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter your Email");
                }
            }
        });

        ContactNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Cust_PhoneNo.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter contact Number");
                }
            }
        });

        Address.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Cust_Add.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Address");
                }
            }
        });

        Address2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Cust_Add.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Address");
                }
            }
        });
        //Action Listener Register
        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display message
                JOptionPane.showMessageDialog(null, "Register Successfully");
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
    * String name = Cust_Name.getText()
    * String address = Cust_Add.getText()
    * String contact = Cust_PhoneNo.getText()*/



