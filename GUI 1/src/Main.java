import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
public class Main {

    public static void main(String[] args) {
        // Create the Frame
        JFrame frame = new JFrame("Text Display");

        // Create a colored Panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0xFAF0E6));

        //rainbow
        Color[] colors = new Color[]{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE};
        int colorIndex = 0;


        // Add text with different fonts
        JLabel label1 = new JLabel("Font 1: Sans Serif");
        label1.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel label2 = new JLabel("Font 2: Serif");
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        JLabel label3 = new JLabel("Font 3: Monospaced");
        label3.setFont(new Font("Courier New", Font.BOLD, 14));

        JLabel label4 = new JLabel("Font 4: Italicized");
        label4.setFont(new Font("Dialog", Font.ITALIC, 20));

        // Timer to update text color
        label1.setForeground(colors[colorIndex+1]);
        label2.setForeground(colors[colorIndex+2]);
        label3.setForeground(colors[colorIndex+3]);
        label4.setForeground(colors[colorIndex+4]);

        // Add labels to the Panel
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);

        // Add the Panel to the Frame
        frame.add(panel);

        // Set closing behavior and display the Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
