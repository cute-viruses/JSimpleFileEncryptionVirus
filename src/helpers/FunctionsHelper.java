package helpers;

import java.io.File;

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
}
