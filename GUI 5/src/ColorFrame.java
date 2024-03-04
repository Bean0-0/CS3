import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorFrame extends JFrame {
    private JButton yellowButton, cyanButton, magentaButton;

    public ColorFrame() {
        yellowButton = new JButton("Yellow");
        cyanButton = new JButton("Cyan");
        magentaButton = new JButton("Magenta");

        ButtonListener listener = new ButtonListener();

        yellowButton.addActionListener(listener);
        cyanButton.addActionListener(listener);
        magentaButton.addActionListener(listener);

        setLayout(new FlowLayout());
        add(yellowButton);
        add(cyanButton);
        add(magentaButton);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == yellowButton) {
                getContentPane().setBackground(Color.YELLOW);
            } else if (e.getSource() == cyanButton) {
                getContentPane().setBackground(Color.CYAN);
            } else if (e.getSource() == magentaButton) {
                getContentPane().setBackground(Color.MAGENTA);
            }
        }
    }

    public static void main(String[] args) {
        new ColorFrame();
    }
}