//Java program
//Registration Form
//Using Java String


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Register extends JFrame {

    //Declare variable
    private JPanel Panel;
    private JLabel Title;
    private JLabel Cust_Name;
    private JLabel Cust_PhoneNo;
    private JLabel Cust_Add;
    private JTextField Username;
    private JTextField ContactNo;
    private JTextField Address;
    private JButton Register;
    private JPasswordField Password;
    private JLabel Cust_Password;
    private JPasswordField Password2;
    private JLabel Cust_Password2;

    public Register(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(Panel);
        this.pack();
        this.setVisible(true);


        Username.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = 0;

                if (Cust_Name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Name");
                }
            }
        });

        Password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Cust_Password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter your password");
                }
            }
        });

        Password2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Cust_Password2.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter your password");
                }
                if (Cust_Password2 != Cust_Password) {
                    JOptionPane.showMessageDialog(null, "Password do not match");
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

        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Register Successfully");
            }
        });
    }
}


//Code to pass the value of the name, address, contact

    /* new displayPayment(name, address, contact number);
    * will need to create a new constructor to pass the details to payment
    * hence, declaration of
    * String name = Cust_Name.getText()
    * String address = Cust_Add.getText()
    * String contact = Cust_PhoneNo.getText()*/



