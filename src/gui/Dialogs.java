package gui;

import javax.swing.*;

public class Dialogs {
    public static void alreadyRunning(){
        JOptionPane.showMessageDialog(null,
                "The program already running !", "Warning",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void errorDialog(String message) {
        JOptionPane.showMessageDialog(null,
                message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void messageDialog(String title, String message) {
        JOptionPane.showMessageDialog(null,
                message, title,
                JOptionPane.WARNING_MESSAGE);
    }
}
