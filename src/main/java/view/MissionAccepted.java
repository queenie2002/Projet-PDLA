package view;

import javax.swing.*;
import java.awt.*;

public class MissionAccepted {
    public MissionAccepted() {
        JFrame frame = new JFrame("Geo & Queen");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        /*label that shows that a mission was accepted (by clicking on button accept)*/
        JLabel emptyLabel = new JLabel("Mission Accepted", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);

        // Make the window's dimension fit its content
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        // Display the window.
        frame.setVisible(true);
    }
    public static void main(String[] args){

        MissionAccepted signuporlogin1 = new MissionAccepted();
    }

}
