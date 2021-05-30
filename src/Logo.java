import javax.swing.*;
import java.awt.*;

public class Logo extends JFrame {
    private JPanel mainPanel;
    private JLabel logoDisplay;

    public Logo(String title) {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
