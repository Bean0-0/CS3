import java.awt.*;
import javax.swing.*;

public class Test {

    public static void main(String[] args) {
        // Create a new Frame
        JFrame frame = new JFrame("Color");

        // Create a new Panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(0xFAF0E6));

        // Add the Panel to the Frame
        frame.add(panel1);

        // Draw something on the Panel
        Graphics g = panel1.getGraphics();
        g.setColor(Color.RED);
        g.fillRect(0, 0, 100, 100);

        // Create a new Panel
        JPanel panel2 = new JPanel();

        // Add the Panel to the Frame
        frame.add(panel2);

        // Create a new Label
        JLabel label = new JLabel("Click one of the buttons to change the color of the panel.");

        // Add the Label to the Panel
        panel2.add(label);

        // Create two new Buttons
        JButton button1 = new JButton("Red");
        JButton button2 = new JButton("Blue");

        // Add the Buttons to the Panel
        panel2.add(button1);
        panel2.add(button2);

        // Set the size of the Frame
        frame.setSize(300, 300);

        frame.add(panel2);

        // Make the Frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}