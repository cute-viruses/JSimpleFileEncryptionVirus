package decryptionTool;

import decryptionTool.gui.MainFrame;
import encryptionAndDecryption.Decryption;
import enums.To;
import files.GetFiles;
import gui.Dialogs;
import helpers.Constants;
import helpers.FunctionsHelper;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Get os
        String os = FunctionsHelper.getOs();
        
        // Check already run
        if (FunctionsHelper.isRunning()) {
            Dialogs.alreadyRunning();
            System.exit(0);
        }
        // Create operation file
        FileWriter operationFile = FunctionsHelper.createOperationFile();

        // Create main frame
        MainFrame mainFrame = new MainFrame();
        // Show main frame
        mainFrame.setVisible(true);

        // Button action listener
        mainFrame.button.addActionListener(listener -> {
            String key = mainFrame.keyField.getText();
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
                File[] roots = getFiles.getRoots();
                ArrayList<File> tempFiles = getFiles.scanFiles(roots[0], To.DECRYPTION, true);
                if (tempFiles.size() == 0) {
                    Dialogs.messageDialog("There is no encrypted file", "We did not find any encrypted file");
                    // Delete operation file
                    FunctionsHelper.deleteOperationFile(operationFile);
                    System.exit(1);
                } else {
                    File sampleFile = tempFiles.get(0);
                    // Verify that the key is correct
                    if (Decryption.check(key, sampleFile)) {
                        // Disable button
                        mainFrame.button.setEnabled(false);
                        // Decryption all files
                        Decryption.decryption(key, getFiles, roots);
                    } else {
                        Dialogs.messageDialog("Invalid key",
                                "The decryption key is incorrect, make sure you copied correctly and try again");
                    }
                }
            }
        });

        mainFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                // Delete operation file
                FunctionsHelper.deleteOperationFile(operationFile);
                // Exit
                System.exit(0);
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }
}
