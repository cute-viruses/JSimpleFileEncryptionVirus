package encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class EncryptionAndDecryption {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    private static File encryptedFile;

    public static boolean encryptionAndDecryption(int mode, String key, File file){
        try {
            encryptedFile = new File((mode == Cipher.ENCRYPT_MODE)? file.getName() + ".anas" : file.getName().replace(".anas", ""));

            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(mode, secretKey);

            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] inputBytes = new byte[(int) file.length()];
            fileInputStream.read(inputBytes);

            byte[] outputFile = cipher.doFinal(inputBytes);

            FileOutputStream fileOutputStream = new FileOutputStream(encryptedFile);
            fileOutputStream.write(outputFile);

            // close files
            fileInputStream.close();
            fileOutputStream.close();

            return true;

        } catch (NoSuchPaddingException | NoSuchAlgorithmException |
                InvalidKeyException | IOException |
                IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public File getEncryptedFile(){
        return encryptedFile;
    }
}
