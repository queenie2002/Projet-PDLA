package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpOrLogIn  {

    public SignUpOrLogIn(   ) {
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton button1 = new JButton("Sign Up ?");
        JButton button2 = new JButton("Log In ?");

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


