package controller;
import java.awt.*;
import javax.swing.*;
public class Login {

    private static void createGUI () {
        //create and set up window
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("Sign Up");
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.START);
        
    }

}
