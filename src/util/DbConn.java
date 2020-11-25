package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConn {
    private static Connection conn;

    public static void connect() {
        System.out.println("Connecting to database ...");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://4.tcp.ngrok.io:19737/AssSix?characterEncoding=latin1&useConfigs=maxPerformance", "tripJournal", "P@ssw0rd!");
            System.out.println("Connected to Database!");
        } catch (Exception ex) {
            System.out.println("Failed to connect to Database!\nExiting program");
            System.exit(0);
        }

        System.out.print("\n\n");
    }

    public static Connection getConn() {
        return conn;
    }
}
