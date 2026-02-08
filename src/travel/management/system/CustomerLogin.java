package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CustomerLogin extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton login, signup;

    CustomerLogin() {
        setTitle("Customer Login");
        getContentPane().setBackground(new Color(255, 245, 230));
        setLayout(null);

        JLabel heading = new JLabel("Customer Login");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(130, 20, 200, 30);
        add(heading);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(60, 80, 100, 30);
        add(l1);

        username = new JTextField();
        username.setBounds(160, 80, 180, 30);
        add(username);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(60, 130, 100, 30);
        add(l2);

        password = new JPasswordField();
        password.setBounds(160, 130, 180, 30);
        add(password);

        login = new JButton("Login");
        login.setBounds(80, 200, 100, 35);
        login.addActionListener(this);
        add(login);

        signup = new JButton("Signup");
        signup.setBounds(220, 200, 100, 35);
        signup.addActionListener(this);
        add(signup);

        setSize(420, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signup) {
            setVisible(false);
            new CustomerSignup();
        } else {
            try {
                Conn c = new Conn();
                String query = "select * from customers where username='" +
                        username.getText() + "' and password='" +
                        password.getText() + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new BookPackage(rs.getString("name"));
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

