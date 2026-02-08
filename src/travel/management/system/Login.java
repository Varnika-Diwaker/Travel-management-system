package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton login;

    Login() {
        setTitle("Travel Management System - Login");

        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40, 30, 100, 30);
        add(user);

        username = new JTextField();
        username.setBounds(150, 30, 150, 30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 80, 100, 30);
        add(pass);

        password = new JPasswordField();
        password.setBounds(150, 80, 150, 30);
        add(password);

        login = new JButton("Login");
        login.setBounds(120, 140, 100, 30);
        login.addActionListener(this);
        add(login);

        setSize(350, 230);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn c = new Conn();
            String u = username.getText();
            String p = password.getText();

            String query = "select * from admin where username='" + u + "' and password='" + p + "'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                setVisible(false);
                new Dashboard();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Login");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
