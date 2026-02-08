package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateDeletePackage extends JFrame implements ActionListener {

    JComboBox<String> destination;
    JTextField days, price;
    JButton update, delete;

    UpdateDeletePackage() {
        setTitle("Update / Delete Package");
        setLayout(null);

        JLabel l1 = new JLabel("Destination");
        l1.setBounds(50, 50, 100, 30);
        add(l1);

        destination = new JComboBox<>();
        destination.setBounds(160, 50, 180, 30);
        add(destination);

        JLabel l2 = new JLabel("Days");
        l2.setBounds(50, 100, 100, 30);
        add(l2);

        days = new JTextField();
        days.setBounds(160, 100, 180, 30);
        add(days);

        JLabel l3 = new JLabel("Price");
        l3.setBounds(50, 150, 100, 30);
        add(l3);

        price = new JTextField();
        price.setBounds(160, 150, 180, 30);
        add(price);

        update = new JButton("Update");
        update.setBounds(70, 220, 100, 35);
        update.addActionListener(this);
        add(update);

        delete = new JButton("Delete");
        delete.setBounds(210, 220, 100, 35);
        delete.addActionListener(this);
        add(delete);

        loadData();

        setSize(420, 330);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void loadData() {
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
            if (ae.getSource() == update) {
                c.s.executeUpdate("update packages set days='" + days.getText() +
                        "', price='" + price.getText() +
                        "' where destination='" + destination.getSelectedItem() + "'");
                JOptionPane.showMessageDialog(null, "Package Updated");
            } else {
                c.s.executeUpdate("delete from packages where destination='" +
                        destination.getSelectedItem() + "'");
                JOptionPane.showMessageDialog(null, "Package Deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
