package travel.management.system;

import javax.swing.*;
import java.awt.event.*;

public class AddPackage extends JFrame implements ActionListener {

    JTextField destination, days, price;
    JButton add;

    AddPackage() {
        setTitle("Add Travel Package");
        setLayout(null);

        JLabel d1 = new JLabel("Destination");
        d1.setBounds(40, 30, 100, 30);
        add(d1);

        destination = new JTextField();
        destination.setBounds(150, 30, 150, 30);
        add(destination);

        JLabel d2 = new JLabel("Days");
        d2.setBounds(40, 80, 100, 30);
        add(d2);

        days = new JTextField();
        days.setBounds(150, 80, 150, 30);
        add(days);

        JLabel d3 = new JLabel("Price");
        d3.setBounds(40, 130, 100, 30);
        add(d3);

        price = new JTextField();
        price.setBounds(150, 130, 150, 30);
        add(price);

        add = new JButton("Add");
        add.setBounds(120, 190, 100, 30);
        add.addActionListener(this);
        add(add);

        setSize(350, 280);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn c = new Conn();
            String query = "insert into packages(destination, days, price) values('" +
                    destination.getText() + "','" +
                    days.getText() + "','" +
                    price.getText() + "')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Package Added Successfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

