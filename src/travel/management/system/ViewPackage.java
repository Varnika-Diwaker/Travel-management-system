package travel.management.system;

import javax.swing.*;
import java.sql.*;

public class ViewPackage extends JFrame {

    ViewPackage() {
        setTitle("View Packages");
        setLayout(null);

        JTextArea area = new JTextArea();
        area.setBounds(20, 20, 340, 300);
        add(area);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from packages");

            while (rs.next()) {
                area.append(
                        "ID: " + rs.getInt("id") +
                        " | Destination: " + rs.getString("destination") +
                        " | Days: " + rs.getInt("days") +
                        " | Price: " + rs.getInt("price") + "\n"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(400, 380);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

