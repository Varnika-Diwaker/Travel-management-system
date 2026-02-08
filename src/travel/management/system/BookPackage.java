package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {

    JComboBox<String> destination;
    JTextField days, price;
    String customerName;
    JButton book, history, logout;

    BookPackage(String name) {
        customerName = name;

        setTitle("Book Travel Package");
        getContentPane().setBackground(new Color(240, 255, 240));
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBounds(120, 20, 250, 30);
        add(heading);

        JLabel l1 = new JLabel("Destination");
        l1.setBounds(50, 80, 100, 30);
        add(l1);

        destination = new JComboBox<>();
        destination.setBounds(160, 80, 180, 30);
        add(destination);

        JLabel l2 = new JLabel("Days");
        l2.setBounds(50, 130, 100, 30);
        add(l2);

        days = new JTextField();
        days.setBounds(160, 130, 180, 30);
        add(days);

        JLabel l3 = new JLabel("Price");
        l3.setBounds(50, 180, 100, 30);
        add(l3);

        price = new JTextField();
        price.setBounds(160, 180, 180, 30);
        add(price);

        book = new JButton("Book Package");
        book.setBounds(130, 240, 150, 35);
        book.addActionListener(this);
        add(book);

        loadPackages();

        setSize(420, 330);
        setLocationRelativeTo(null);
        setVisible(true);
        history = new JButton("Booking History");
        history.setBounds(30, 290, 160, 30);
        history.addActionListener(this);
        add(history);

        logout = new JButton("Logout");
        logout.setBounds(220, 290, 120, 30);
        logout.addActionListener(this);
        add(logout);
    }

    void loadPackages() {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from packages");
            while (rs.next()) {
                destination.addItem(rs.getString("destination"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn c = new Conn();
            String query = "insert into bookings(customer_name, destination, days, price) values('" +
                    customerName + "','" +
                    destination.getSelectedItem() + "','" +
                    days.getText() + "','" +
                    price.getText() + "')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Booking Successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
    }


