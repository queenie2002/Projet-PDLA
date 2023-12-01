package view;

import controller.NewService;
import model.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class NewMissionVolunteer {

    private final JTextField[] jtFields = new JTextField[2];
    public NewMissionVolunteer (int idUser) {
        JFrame frame = new JFrame("Geo & Queen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel addMissionLabel = new JLabel("New Mission", JLabel.CENTER);
        addMissionLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(addMissionLabel, BorderLayout.PAGE_START);

        jtFields[0] = new JTextField();
        jtFields[1] = new JTextField();

        JButton button_newmission = new JButton("Add");
        JButton button_logout = new JButton("Log Out");
        JButton button_prev = new JButton("Previous");

        button_newmission.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = getLocation();
                String description = getDescription();

                //we add the new service to database with typeofservice = 1 because a volunteer is creating that service
                model.Service service = new Service(0, idUser, location, description, 1, 0);
                try {
                    NewService.AddNewService(service);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                PopUpTab popup = new PopUpTab("Mission Created");
                MissionTabVolunteer missionVolunteer = new MissionTabVolunteer(idUser);
                frame.dispose();

            }
        });

        button_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SignUpOrLogIn signuporlogin = new SignUpOrLogIn();
                frame.dispose();
            }
        });

        button_prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MissionTabVolunteer tabPatient = new MissionTabVolunteer(idUser);
                frame.dispose();
            }
        });


        JPanel p = new JPanel(new GridLayout(6, 2));
        p.add(new JLabel("Location : "));
        p.add(jtFields[0]);
        p.add(new JLabel("Description : "));
        p.add(jtFields[1]);

        p.add(button_newmission);
        p.add(button_prev);
        p.add(button_logout);

        frame.add(p);


        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

        public String getLocation() {
            return this.jtFields[0].getText();
        }

        public String getDescription() {
            return this.jtFields[1].getText();
        }
}
