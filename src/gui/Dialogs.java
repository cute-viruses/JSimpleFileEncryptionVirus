package gui;

import javax.swing.*;

public class Dialogs {
    /**
     * Show the already running warning dialog
     */
    public static void alreadyRunning(){
        JOptionPane.showMessageDialog(null,
                "The program already running !", "Warning",
                JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Show the error dialog
     * @param message The error message
     */
    public static void errorDialog(String message) {
        JOptionPane.showMessageDialog(null,
                message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Show the warning message dialog
     * @param title warning title
     * @param message warning message
     */
    public static void messageDialog(String title, String message) {
        JOptionPane.showMessageDialog(null,
                message, title,
                JOptionPane.WARNING_MESSAGE);
    }
}
