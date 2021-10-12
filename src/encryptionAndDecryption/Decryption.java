package encryptionAndDecryption;

import enums.To;
import files.GetFiles;

import javax.crypto.Cipher;
import java.io.File;
import java.util.ArrayList;

public class Decryption {
    /**
     * This function is used to decrypt all files inside the root folder
     * @param key Encryption key
     * @param getterFiles Getter file object
     * @param roots The roots files
     */
    public static void decryption(String key, GetFiles getterFiles, File[] roots) {
        ArrayList<File> filesInRoot;
        for (File root : roots) {
            filesInRoot = getterFiles.scanFiles(root, To.DECRYPTION, false);
            for (File file : filesInRoot) {
                if (EncryptionAndDecryption.encryptionAndDecryption(Cipher.DECRYPT_MODE, key, file))
                    file.delete();
            }
        }
    }

    /**
     * This function is used to verify the encryption key.
     * It is recommended to call this function before trying to decrypt all files to avoid errors
     * @param key The decryption key you want to test
     * @param sampleFile The file you are going to test on
     * @return true if the key is correct, false if the key is not correct
     */
    public static boolean check(String key, File sampleFile) {
        return EncryptionAndDecryption.encryptionAndDecryption(Cipher.DECRYPT_MODE, key, sampleFile);
    }
}
