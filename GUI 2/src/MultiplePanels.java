import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultiplePanels extends JFrame {

    private JPanel panel1, panel2, panel3;
    private JButton button1, button2;
    private JLabel label;

    public MultiplePanels() {
        super("Multiple Panels");
        setLayout(new FlowLayout());

        // Create panels
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        // Add panel2 to the frame
        add(panel2);

        // Draw on panel2
        panel2.setBackground(Color.WHITE); // Set background for better contrast
        panel2.setPreferredSize(new Dimension(200, 100)); // Set preferred size
        panel2.paintImmediately(panel2.getBounds()); // Trigger immediate painting

        // Create label and buttons
        label = new JLabel("Click a button to change color:");
        button1 = new JButton("Red");
        button2 = new JButton("Blue");

        // Add elements to panel3
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS)); // Use vertical layout
        panel3.add(label);
        panel3.add(button1);
        panel3.add(button2);

        // Add action listeners to buttons
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel3.setBackground(Color.RED);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel3.setBackground(Color.BLUE);
            }
        });

        // Add panel3 to the frame
        add(panel3);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);
        g.drawLine(10, 10, 190, 90);
    }

    public static void main(String[] args) {
        new MultiplePanels();
    }
}
