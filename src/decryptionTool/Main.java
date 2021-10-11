package decryptionTool;

import encryptionAndDecryption.Decryption;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Decryption Tool");
        // Set up the frame
        Container container = frame.getContentPane();
        GroupLayout groupLayout = new GroupLayout(container);
        frame.setLayout(groupLayout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        groupLayout.preferredLayoutSize(container);

        Font font = new Font("Serif", Font.PLAIN, 40);

        JLabel welcome = new JLabel("Welcome");
        JTextField keyField = new JTextField();
        JButton button = new JButton("Decrypt my files");

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

        // Button action listener
        button.addActionListener(listener -> Decryption.decryption(keyField.getText()));

        frame.pack();
        frame.setVisible(true);
    }
}
