import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel1 = new JPanel();
        String[] colors = {"Red", "Blue", "Green", "Yellow", "Orange", "Pink", "Cyan", "Magenta", "Gray", "Black"};
        JComboBox<String> comboBox = new JComboBox<>(colors);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (comboBox.getSelectedItem().toString()) {
                    case "Red":
                        panel1.setBackground(Color.RED);
                        break;
                    case "Blue":
                        panel1.setBackground(Color.BLUE);
                        break;
                    // Add cases for other colors...
                }
            }
        });
        panel1.add(comboBox);
        frame.add(panel1, BorderLayout.NORTH);

        JPanel panel2 = new JPanel();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (int i = 1; i <= 50; i++) {
            listModel.addElement("Item " + i);
        }
        JList<String> list = new JList<>(listModel);
        list.setVisibleRowCount(10);
        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                System.out.println(list.getSelectedValuesList());
            }
        });
        JScrollPane scrollPane = new JScrollPane(list);
        panel2.add(scrollPane);
        frame.add(panel2, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}