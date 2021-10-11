package helpers;

import java.io.File;

public class FunctionsHelper {
    public static String getOs() {
        return System.getProperty("os.name").toLowerCase();
    }
    public static boolean isRunning() {
        return new File (Constants.operationFileName).exists();
    }
}
