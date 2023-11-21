package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

//where we start when we run the app
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

        panel.setBorder(new EmptyBorder(250, 60, 50, 50));

        frame.add(panel);

        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}


