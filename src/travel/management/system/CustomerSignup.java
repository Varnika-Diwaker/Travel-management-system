package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerSignup extends JFrame implements ActionListener {

    JTextField name, username;
    JPasswordField password;
    JButton signup;

    CustomerSignup() {
        setTitle("Customer Signup");
        getContentPane().setBackground(new Color(230, 240, 255));
        setLayout(null);

        JLabel heading = new JLabel("Customer Signup");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(120, 20, 200, 30);
        add(heading);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(50, 80, 100, 30);
        add(l1);

        name = new JTextField();
        name.setBounds(160, 80, 180, 30);
        add(name);

        JLabel l2 = new JLabel("Username");
        l2.setBounds(50, 130, 100, 30);
        add(l2);

        username = new JTextField();
        username.setBounds(160, 130, 180, 30);
        add(username);

        JLabel l3 = new JLabel("Password");
        l3.setBounds(50, 180, 100, 30);
        add(l3);

        password = new JPasswordField();
        password.setBounds(160, 180, 180, 30);
        add(password);

        signup = new JButton("Signup");
        signup.setBounds(140, 240, 120, 35);
        signup.addActionListener(this);
        add(signup);

        setSize(420, 340);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn c = new Conn();
            String query = "insert into customers(name, username, password) values('" +
                    name.getText() + "','" +
                    username.getText() + "','" +
                    password.getText() + "')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Signup Successful");
            setVisible(false);
            new CustomerLogin();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

