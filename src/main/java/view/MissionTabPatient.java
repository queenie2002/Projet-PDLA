package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MissionTabPatient  {

    public MissionTabPatient(int idUser) {
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("Login", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton button1 = new JButton("Show past missions");
        JButton button2 = new JButton("Add new mission");

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NewMissionPatient tabNewMission = new NewMissionPatient(idUser);
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


