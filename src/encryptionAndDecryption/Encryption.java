package encryptionAndDecryption;

import javax.crypto.Cipher;
import java.io.File;
import java.util.ArrayList;

public class Encryption {
    /**
     * This machine is used to encrypt files
     * @param files The files you want to encrypt
     * @param key The encryption key
     */
    public static void encryption(ArrayList<File> files, String key){
        for (File file : files) {
            EncryptionAndDecryption.encryptionAndDecryption(Cipher.ENCRYPT_MODE, key, file);
            // Delete original file
            file.delete();
        }
    }
}
