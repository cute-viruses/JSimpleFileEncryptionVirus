package decryptionTool.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public JLabel welcome;
    public JTextField keyField;
    public JButton button;
    public MainFrame() {
        super("Decryption Tool");

        welcome = new JLabel("Welcome");
        keyField = new JTextField();
        button = new JButton("Decrypt my files");
        // Set up the frame
        Container container = getContentPane();
        GroupLayout groupLayout = new GroupLayout(container);
        setLayout(groupLayout);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        groupLayout.preferredLayoutSize(container);

        Font font = new Font("Serif", Font.PLAIN, 40);

        // Set font
        welcome.setFont(font);
        keyField.setFont(font);
        button.setFont(font);

        // Set size
        button.setSize(button.getPreferredSize());

        // Add all components to the group layout
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(welcome)
                        .addComponent(keyField)
                        .addComponent(button)
        );
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(welcome)
                        .addComponent(keyField)
                        .addComponent(button)
        );

        pack();
    }
}
