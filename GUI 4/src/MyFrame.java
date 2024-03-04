import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(int columns) {
        // Set the layout to GridLayout
        setLayout(new GridLayout(0, columns)); // 0 means any number of rows

        // Create panels
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.GREEN);

        // Add panels to the frame
        add(panel1);
        add(panel2);

        // Set the frame to exit on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Pack the frame
        pack();

        setSize(500, 500);

        // Set the frame to visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create a new frame with 1 column
        new MyFrame(1);
    }
}