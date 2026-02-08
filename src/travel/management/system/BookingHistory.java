package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class BookingHistory extends JFrame {

    BookingHistory(String customerName) {

        setTitle("Booking History");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Your Booking History");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBounds(120, 20, 250, 30);
        add(heading);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setBounds(30, 70, 340, 260);
        add(area);

        try {
            Conn c = new Conn();
            String query = "select * from bookings where customer_name='" + customerName + "'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                area.append(
                        "Destination : " + rs.getString("destination") + "\n" +
                        "Days        : " + rs.getInt("days") + "\n" +
                        "Price       : ₹" + rs.getInt("price") + "\n" +
                        "-----------------------------\n"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(420, 380);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

