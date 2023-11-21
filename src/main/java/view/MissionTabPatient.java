package view;

import controller.InitializeDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//the home tab of a patient
public class MissionTabPatient  {

    public MissionTabPatient(int idUser) {

        // create the window and set up
        JFrame frame = new JFrame("Geo & Queen");
        frame.getContentPane().setLayout(null);

        //when we close, we exit the app
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //we create a label with "add new mission" and set the size
        JLabel emptyLabel = new JLabel("Home", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));



        //we create a panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        //we create buttons
        JButton button1 = new JButton("Show Past Missions");
        JButton button2 = new JButton("Add New Mission");

        //when we click button showpastmissions
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) { //--------------------------A FAIRE
                //SHOW PAST MISSIONS
                frame.dispose();
            }
        });

        //when we click button addnewmission
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //go to the tab to add a mission and close frame
                NewMissionPatient tabNewMission = new NewMissionPatient(idUser);
                frame.dispose();
            }
        });

        //we add the buttons and label to panel
        panel.add(emptyLabel);
        panel.add(button1);
        panel.add(button2);



        //we create another panel
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        //we create another button
        JButton button3 = new JButton("Log Out");

        //when we click on button log out
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //leads us to first tab and closes tab
                SignUpOrLogIn signuporlogin = new SignUpOrLogIn();
                frame.dispose();
            }
        });

        //we add the buttons to that panel
        panel1.add(button3);

        //place the panels
        panel.setBounds(100, 30, 200, 300);
        panel1.setBounds(300, 200, 100, 50);


        //we add the panels to the frame
        frame.add(panel);
        frame.add(panel1);

        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}


