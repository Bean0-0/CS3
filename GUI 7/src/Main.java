import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        menuBar.add(fileMenu);

        JMenu colorMenu = new JMenu("Color");
        JMenuItem redItem = new JMenuItem("Red");
        JMenuItem blueItem = new JMenuItem("Blue");
        colorMenu.add(redItem);
        colorMenu.add(blueItem);
        menuBar.add(colorMenu);

        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        panel.add(label);

        frame.setJMenuBar(menuBar);
        frame.add(panel);
        frame.setVisible(true);

        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    label.setText(selectedFile.getName());
                }
            }
        });

        redItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.RED);
            }
        });

        blueItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.BLUE);
            }
        });
    }
}