package main;

import files.GetFiles;
import genrators.GenerateID;
import genrators.GenerateKey;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GenerateID idGenerator = new GenerateID(20);
        GenerateKey keyGenerator = new GenerateKey(16);

        GetFiles files = new GetFiles();

        for (File dir : files.getDrivers())
            System.out.println(dir);
        ArrayList<File> filesU = files.scanFiles(files.getDrivers()[1]);

        for ( File f : filesU)
            System.out.println(f);
    }
}
