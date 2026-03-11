package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankSystem",
                "root",
                "Abhi@2002"
            );
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}