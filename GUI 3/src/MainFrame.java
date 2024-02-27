import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private JTextField textField;
    private JLabel label;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JPanel panel = new JPanel();
        textField = new JTextField(20);
        label = new JLabel("Enter text:");

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText(textField.getText());
            }
        });

        panel.add(label);
        panel.add(textField);

        add(panel, BorderLayout.CENTER);
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}