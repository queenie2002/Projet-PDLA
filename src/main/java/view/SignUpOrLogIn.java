package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignUpOrLogIn  {

    public SignUpOrLogIn() {
        JFrame frame = new JFrame("Geo & Queen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton button1 = new JButton("Sign Up");
        JButton button2 = new JButton("Log In");


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SignUp signup = new SignUp();
                frame.dispose();
            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Login login = new Login();
                frame.dispose();
            }
        });


        panel.add(button1);
        panel.add(button2);




       frame.getContentPane().setLayout(null); // Manually position the panel



        // Set the panel's position and size
        panel.setBounds(100, 100, 200, 100);
        frame.add(panel);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}


