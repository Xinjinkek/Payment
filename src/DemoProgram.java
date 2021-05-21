import javax.swing.*;

public class DemoProgram {
    public static void main(String[] args) {
        JFrame frame = new paymentMethod("Payment via Credit/Debit card");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 180);
        frame.setVisible(true);
    }
}
