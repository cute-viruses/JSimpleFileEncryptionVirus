package helpers;

import gui.Dialogs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FunctionsHelper {
    /**
     * Get the operating system name
     * @return operating system name
     */
    public static String getOs() {
        return System.getProperty("os.name").toLowerCase();
    }

    /**
     * Check if the program is already running
     * @return true if the program is running, false if the program is not running
     */
    public static boolean isRunning() {
        return new File (Constants.operationFileName).exists();
    }

    public static FileWriter createOperationFile() {
        FileWriter operationFile = null;
        try {
            operationFile = new FileWriter(Constants.operationFileName);
        } catch (IOException e) {
            Dialogs.errorDialog(e.getMessage());
            System.exit(1);
        }
        return operationFile;
    }

    /**
     * This function is used to delete the process file while the program is closed
     * @param operationFile The operation file
     */
    public static void deleteOperationFile(FileWriter operationFile) {
        try {
            operationFile.close();
            File file = new File(Constants.operationFileName);
            while (!file.delete() && file.exists()) {
                new Thread(() -> {
                    try {
                        Thread.sleep(300000);
                    } catch (InterruptedException ignored) {
                    }
                }).start();
            }
        } catch (IOException ignored) {
        }
    }
}
