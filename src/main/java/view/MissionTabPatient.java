package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//the home tab of a patient
public class MissionTabPatient  {

    public MissionTabPatient(int idUser) {
        JFrame frame = new JFrame("Geo & Queen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("Login", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton button1 = new JButton("Show Past Missions");
        JButton button2 = new JButton("Add New Mission");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //SHOW PAST MISSIONS
                frame.dispose();
            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NewMissionPatient tabNewMission = new NewMissionPatient(idUser);
                frame.dispose();
            }
        });

        panel.add(button1);
        panel.add(button2);

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton button3 = new JButton("Log Out");


        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SignUpOrLogIn signuporlogin = new SignUpOrLogIn();
                frame.dispose();
            }
        });
        panel1.add(button3);
        panel1.setBounds(300, 200, 100, 50);
        frame.add(panel1);



        frame.getContentPane().setLayout(null);

        // Set the panel's position and size
        panel.setBounds(100, 100, 200, 100);

        frame.add(panel);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    public static void main(String[] args){
        MissionTabPatient signuporlogin1 = new MissionTabPatient(1);
    }




}


