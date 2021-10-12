package encryptionAndDecryption;

import helpers.Constants;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class EncryptionAndDecryption {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    private static File encryptedFile;

    /**
     * This function is used to encrypt and decrypt the file
     *
     * @param mode The mode or operation you want to perform (file encryption or decryption)
     * @param key  Encryption or decryption key
     * @param file The file you want to encrypt or decrypt
     * @return True if the function can encrypt the file, false if it cannot encrypt the file
     */
    public static boolean encryptionAndDecryption(int mode, String key, File file) {
        try {
            String filePath = file.toString();
            encryptedFile = new File((mode == Cipher.ENCRYPT_MODE) ?
                    filePath + Constants.fileEncryptedExtension
                    : filePath.replace(Constants.fileEncryptedExtension, ""));

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

    public File getEncryptedFile() {
        return encryptedFile;
    }
}
