import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainMenu extends JFrame {
    private JPanel mainPanel = new JPanel();
    public MainMenu(String title) throws IOException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(1000,1000);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        createUIComponents();
    }

    public void createUIComponents() throws IOException {
        JPanel panel = new JPanel(new BorderLayout());
        Image image = ImageIO.read(this.getClass().getResource("logo.jpg"));
        Image imageSize = image.getScaledInstance(350,300,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(imageSize);
        JLabel picture = new JLabel(icon);
        Box right = Box.createVerticalBox();
        JPanel panel1 = new JPanel();
        JLabel title = new JLabel("898 Food Restaurant");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentY(0.0f);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 18));
        title.setForeground(Color.BLUE);

        JButton button = new JButton("Order Food Now >>");
        panel1.add(button);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(picture, BorderLayout.CENTER);
        panel.add(right, BorderLayout.SOUTH);
        right.add(title);
        right.add(panel1);
        add(panel);
    }
}
