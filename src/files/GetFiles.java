package files;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class GetFiles {
    private File[] drivers;

    public GetFiles() {
        drivers = scanDrivers();
    }

    private File[] scanDrivers() { // Get partitions
        return File.listRoots();
    }

    public File[] getDrivers() {
        return drivers;
    }

    public ArrayList<File> scanFiles(File drive) {
        ArrayList<File> files = new ArrayList(Arrays.asList(Objects.requireNonNull(drive.listFiles())));

        int i = 0;
        boolean isEnd = false;
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

        // Delete directories and can't write files
        for (int j = 0; j < files.size(); j++)
            if (files.get(j).isDirectory() || !files.get(j).canWrite())
                files.remove(j--);
        return files;
    }
}
