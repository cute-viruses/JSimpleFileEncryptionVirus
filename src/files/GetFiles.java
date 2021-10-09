package files;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class GetFiles {
    private File[] drivers;

    public GetFiles(){
        drivers = scanDrivers();
    }

    private File[] scanDrivers() { // Get partitions
        return File.listRoots();
    }

    public File[] getDrivers(){
        return drivers;
    }

    public ArrayList<File> scanFiles(File drive){
        ArrayList<File> files = new ArrayList(Arrays.asList(Objects.requireNonNull(drive.listFiles())));

        int i = 0;
        boolean isEnd = false;
        boolean isDir = false;
        loo: do {
            File file = files.get(i);
            boolean canRead = file.canRead();
            while (file.isDirectory()) {
                if (!file.getName().equals("System Volume Information")
                && !file.getName().equals("$RECYCLE.BIN")) {
                    if (file.listFiles() != null) {
                        files.remove(i);
                        files.addAll(i, Arrays.asList(file.listFiles()));
                        file = files.get(i++);
                        isDir = true;
                    } else {
                        files.remove(i++);
                        file = files.get(i);
                    }
                } else {
                    files.remove(i);
                    if (i < files.size())
                        file = files.get(++i);
                    else
                        break loo;
                }
            }

            if (isDir)
                isDir = false;
            else
                i++;
            isEnd = files.size() == i;
        } while (!isEnd);

        return  files;
    }
}
