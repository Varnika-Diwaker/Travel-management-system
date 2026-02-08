package travel.management.system;

import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton addPackage, viewPackage;

    Dashboard() {
        setTitle("Dashboard");

        setLayout(null);

        addPackage = new JButton("Add Package");
        addPackage.setBounds(50, 50, 150, 40);
        addPackage.addActionListener(this);
        add(addPackage);

        viewPackage = new JButton("View Packages");
        viewPackage.setBounds(50, 120, 150, 40);
        viewPackage.addActionListener(this);
        add(viewPackage);

        setSize(260, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPackage) {
            new AddPackage();
        } else {
            new ViewPackage();
        }
    }
}
