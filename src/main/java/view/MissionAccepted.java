package view;

import javax.swing.*;
import java.awt.*;

//when we accept a mission, this tab pops-up
public class MissionAccepted {
    public MissionAccepted() {

        // create the window
        JFrame frame = new JFrame("Geo & Queen");

        //when we close, we just close the frame and keep running the app, it's a pop-up
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //we set the layout
        frame.setLayout(new FlowLayout());

        //we create and set a label
        JLabel emptyLabel = new JLabel("Mission Accepted", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));

        //we add it to the frame
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);

        // Make the window's dimension fit its content
        frame.pack();
        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        // Display the window.
        frame.setVisible(true);
    }

}
