package encryption;

import javax.crypto.Cipher;
import java.io.File;
import java.util.ArrayList;

public class Encryption {
    public static void encrypt(ArrayList<File> files, String key){
        for (File file : files) {
            EncryptionAndDecryption.encryptionAndDecryption(Cipher.ENCRYPT_MODE, key, file);
            // Delete original file
            file.delete();
        }
    }
}
