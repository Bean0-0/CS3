import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxAndRadioButtonFrame extends JFrame {
    private JCheckBox checkBox1, checkBox2;
    private JRadioButton radioButton1, radioButton2;
    private JLabel checkBoxLabel, radioButtonLabel;

    public CheckBoxAndRadioButtonFrame() {
        setLayout(new GridLayout(2, 1));

        JPanel checkBoxPanel = new JPanel();
        checkBox1 = new JCheckBox("Checkbox 1");
        checkBox2 = new JCheckBox("Checkbox 2");
        checkBoxLabel = new JLabel("Checkbox status");

        checkBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxLabel.setText("Checkbox 1 is " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
            }
        });

        checkBox2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxLabel.setText("Checkbox 2 is " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
            }
        });

        checkBoxPanel.add(checkBox1);
        checkBoxPanel.add(checkBox2);
        checkBoxPanel.add(checkBoxLabel);

        JPanel radioButtonPanel = new JPanel();
        radioButton1 = new JRadioButton("Radio Button 1");
        radioButton2 = new JRadioButton("Radio Button 2");
        radioButtonLabel = new JLabel("Radio Button status");

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);

        radioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                radioButtonLabel.setText("Radio Button 1 is selected");
            }
        });

        radioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                radioButtonLabel.setText("Radio Button 2 is selected");
            }
        });

        radioButtonPanel.add(radioButton1);
        radioButtonPanel.add(radioButton2);
        radioButtonPanel.add(radioButtonLabel);

        add(checkBoxPanel);
        add(radioButtonPanel);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBoxAndRadioButtonFrame();
    }
}