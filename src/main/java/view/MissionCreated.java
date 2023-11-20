package view;

import javax.swing.*;
import java.awt.*;

public class MissionCreated {
    public MissionCreated() {
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        /*label that shows that a mission was created (by clicking on button create)*/
        JLabel emptyLabel = new JLabel("Mission Created", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);

        // Make the window's dimension fit its content
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        // Display the window.
        frame.setVisible(true);
    }
}
