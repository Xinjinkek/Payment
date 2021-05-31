import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserRating extends JFrame{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel sliderPanel;
    private JLabel titleLabel;
    private JSlider rateSlider;
    private JLabel instructionLabel;
    private JButton rateButton;

    public UserRating(String title)
    {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(350,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        rateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null, "Thank you for rating us " +
                        rateSlider.getValue() + "/10!");
            }
        });

        rateButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode()== KeyEvent.VK_ENTER){
                    dispose();
                    JOptionPane.showMessageDialog(null, "Thank you for rating us " +
                            rateSlider.getValue() + "/10!");
                }
            }
        });
    }
}
