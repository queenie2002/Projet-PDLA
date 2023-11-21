package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

//the home tab of a volunteer
public class MissionTabVolunteer {

    public MissionTabVolunteer (int idUser) {

        JFrame frame = new JFrame("Geo & Queen");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel homeLabel = new JLabel("Home", JLabel.CENTER);
        homeLabel.setPreferredSize(new Dimension(175, 100));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton button1 = new JButton("Show past missions");
        JButton button2 = new JButton("Add new mission");
        JButton button3 = new JButton("Available missions");

        //add new mission
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NewMissionVolunteer tabNewMission = new NewMissionVolunteer(idUser);
                frame.dispose();
            }
        });

        //show available mission
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ShowAvailableMissions availableMissions = new ShowAvailableMissions(idUser);
                frame.dispose();
            }
        });

        panel.add(homeLabel);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);






        JPanel panelLogout = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton button_logout = new JButton("Log Out");

        panelLogout.add(button_logout, BorderLayout.SOUTH);

        //logout
        button_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SignUpOrLogIn signuporlogin = new SignUpOrLogIn();
                frame.dispose();
            }
        });

        panelLogout.add(button_logout);




        panel.setBounds(50, 100, 200, 100);

        frame.add(panel);
        frame.add(panelLogout, BorderLayout.SOUTH);

        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}

