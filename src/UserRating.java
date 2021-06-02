import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserRating extends JFrame {

    //Declaration of variables
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel sliderPanel;
    private JLabel titleLabel;
    private JSlider rateSlider;
    private JLabel instructionLabel;
    private JButton rateButton;
    private JLabel ratingIcon;

    //Constructor
    public UserRating(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(350,400);
        this.setLocationRelativeTo(null); //Set the window to the centre of the screen
        this.setVisible(true);

        //Action Listener Rate button
        //To display user feedback
        rateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null, "Thank you for rating us! " +
                        "\n Please come again!");
            }
        });

        //Key Listener where "Enter Key" can be detected
        //Provide same function as the "Rate" button
        rateSlider.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode()== KeyEvent.VK_ENTER) {
                    dispose();
                    JOptionPane.showMessageDialog(null, "Thank you for rating us! " +
                            "\n Please come again!");

                }
            }
        });
    }


}
