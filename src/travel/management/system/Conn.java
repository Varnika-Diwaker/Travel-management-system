package travel.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/travel_management",
                "root",
                "varnika"   // change password if needed
            );
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}