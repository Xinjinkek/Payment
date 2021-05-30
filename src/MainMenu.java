import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainMenu extends JFrame {
    JPanel mainPanel = new JPanel();
    public MainMenu(String title) throws IOException {
        super(title);
        createUIComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(350,450);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void createUIComponents() throws IOException {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.decode("#EDBB99"));
        Image image = ImageIO.read(getClass().getResource("mainlogo.png"));
        Image imageSize = image.getScaledInstance(350,300,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(imageSize);
        JLabel picture = new JLabel(icon);
        Box box = Box.createVerticalBox();
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.decode("#EDBB99"));
        JLabel title = new JLabel("Ramly.Jr House");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("INK FREE", Font.BOLD, 18));
        title.setForeground(Color.BLACK);

        JButton button = new JButton("Order Food Now >>");
        panel1.add(button);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);

        mainPanel.add(picture, BorderLayout.CENTER);
        mainPanel.add(box, BorderLayout.SOUTH);
        box.add(title);
        box.add(panel1);
        add(mainPanel);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Register("Register");
                dispose();
            }
        });
    }
}
