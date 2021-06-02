import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainMenu extends JFrame {

    //Declaration of variable
    JPanel mainPanel;

    //Constructor
    public MainMenu(String title) throws IOException {
        super(title);
        createUIComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(350,450);
        //Set the window to the centre of the screen
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void createUIComponents() throws IOException {

        //Create a new JPanel
        //Specify the layout of the JPanel
        //Create a new icon for the label
        //Set the size of image
        //Create label, panel and button
        //Specify the background colour, title and font
        //Add the component to the main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.decode("#EDBB99"));
        Image image = ImageIO.read(getClass().getResource("mainlogo.png"));
        Image imageSize = image.getScaledInstance(350,300,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(imageSize);
        JLabel picture = new JLabel(icon);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel(new BorderLayout());
        panel1.setBackground(Color.decode("#EDBB99"));
        panel2.setBackground(Color.decode("#EDBB99"));
        JLabel title = new JLabel("Ramly.Jr House");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("INK FREE", Font.BOLD, 18));
        title.setForeground(Color.BLACK);

        JButton button = new JButton("Order Now");
        panel1.add(button);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);

        mainPanel.add(picture, BorderLayout.CENTER);
        mainPanel.add(panel2, BorderLayout.SOUTH);
        panel2.add(title, BorderLayout.NORTH);
        panel2.add(panel1, BorderLayout.SOUTH);
        add(mainPanel);

        //Action Listener "Order Now" button to enter registration window
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Register("Register");
                dispose();
            }
        });

        //Key Listener where "Enter Key" can be detected
        //Provide same function as the "Order Now" button
        button.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()== KeyEvent.VK_ENTER){
                    new Register("Register");
                    dispose();
                }
            }
        });

    }


}
