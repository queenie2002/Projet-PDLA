package view;

import javax.swing.*;
import java.awt.*;

public class MissionAccepted {
    public MissionAccepted() {
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        /*label that shows that a mission was accepted (by clicking on button accept)*/
        JLabel emptyLabel = new JLabel("Mission Accepted", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);

        // Make the window's dimension fit its content
        frame.pack();
        // Display the window.
        frame.setVisible(true);
    }
}
