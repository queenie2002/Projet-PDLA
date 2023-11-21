package view;

import controller.NewService;
import model.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

//to add a mission, as a patient
public class NewMissionPatient {

    //2 textfields to write in location and description
    private final JTextField[] jtFields = new JTextField[2];


    public NewMissionPatient (int idUser) {

        JFrame frame = new JFrame("Geo & Queen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //we initialize the textfields
        jtFields[0] = new JTextField();
        jtFields[1] = new JTextField();


        JButton button_newmission = new JButton("Add");
        JButton button_logout = new JButton("Log Out");
        JButton button_prev = new JButton("Previous");

        //add the mission
        button_newmission.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //to get the written location and description
                String location = getLocation();
                String description = getDescription();

                //we insert service into database
                model.Service service = new Service(idUser,0,location,description,0,0);

                try {
                    NewService.AddNewService(service);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                PopUpTab popup = new PopUpTab("Mission Created");
                MissionTabPatient missiontabpatient = new MissionTabPatient(idUser);
                frame.dispose();
            }
        });

        //logout
        button_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SignUpOrLogIn signuporlogin = new SignUpOrLogIn();
                frame.dispose();
            }
        });

        //to go back to previous tab
        button_prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MissionTabPatient tabPatient = new MissionTabPatient(idUser);
                frame.dispose();
            }
        });


        JLabel emptyLabel = new JLabel("New Mission", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));

        JLabel emptyLabel1 = new JLabel();


        JPanel p = new JPanel(new GridLayout(6, 2));
        p.add(new JLabel("Location : "));
        p.add(jtFields[0]);
        p.add(new JLabel("Description : "));
        p.add(jtFields[1]);

        p.add(emptyLabel1);
        p.add(button_newmission);
        p.add(button_prev);
        p.add(button_logout);

        frame.add(p);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);//center frame on screen
        // Display the window.
        frame.setVisible(true);
    }

    public String getLocation() {
        return this.jtFields[0].getText();
    }

    public String getDescription() {
        return this.jtFields[1].getText();
    }
}
