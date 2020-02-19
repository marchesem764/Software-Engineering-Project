import javax.swing.*;
import java.awt.*;

public class DropdownBox extends JFrame {

    public DropdownBox(){
        JFrame frame = new JFrame("Basic Dropdown Menu");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(430, 100);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        frame.add(panel);

        JLabel label = new JLabel("Select one and click OK");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(label);

        String[] choices = {"A", "B", "C"};

        final JComboBox<String> comboBox = new JComboBox<>(choices);

        comboBox.setMaximumSize(comboBox.getPreferredSize());
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(comboBox);

        JButton button = new JButton("OK");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button);

        frame.setVisible(true);
    }
}
