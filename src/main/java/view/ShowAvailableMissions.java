package view;

import controller.UseDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowAvailableMissions {

    public ShowAvailableMissions(int idUser) {

        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel emptyLabel = new JLabel("Show Available Missions", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);

        JPanel panelLogout = new JPanel(new FlowLayout(FlowLayout.CENTER));

        try {
            /*connect to database and get all the services that have a status equal to 0*/
            UseDatabase database = new UseDatabase();
            Connection conn = null;

            try {
                conn = database.connectToDatabase();

                /*number of available services*/
                String insertNumberMissions = "SELECT COUNT(*) FROM service WHERE status = 0";
                ResultSet res = database.doQueryDatabase(conn, insertNumberMissions);

                int nbMissions = 0;

                if (res.next()) {
                    nbMissions = res.getInt(1);
                    System.out.println("nb de missions " + nbMissions);
                } else {
                    System.out.println("No available missions");
                }


                int iter = 0;
                /*available missions*/
                String mission = "select * from service where status = 0";
                ResultSet res_missions = database.doQueryDatabase(conn, mission);

                while (res_missions.next()) {
                    System.out.println("Processing mission: " + iter);

                    int idService = res_missions.getInt("idService");
                    String location = res_missions.getString("location");
                    String description = res_missions.getString("description");

                    System.out.println("ID: " + idService + ", Location: " + location + ", Description: " + description);

                    JPanel p = new JPanel(new BorderLayout());

                    p.add(new JLabel("Mission n°" + idService), BorderLayout.NORTH);

                    // New panel for location and description
                    JPanel infoPanel = new JPanel(new GridLayout(2, 2));
                    infoPanel.add(new JLabel("Location:"));
                    infoPanel.add(new JLabel(location));
                    infoPanel.add(new JLabel("Description:"));
                    infoPanel.add(new JLabel(description));

                    p.add(infoPanel, BorderLayout.CENTER);


                    JButton button_accept = new JButton("Accept");

                    button_accept.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            Connection finalConn = null;
                            try {
                                // Connect to the database
                                UseDatabase database = new UseDatabase();
                                finalConn = database.connectToDatabase();

                                // Perform the update operation
                                String insertSql = "update service set idVolunteer = " + idUser + " , status = " + 1 + " where idService = " + idService;
                                database.doStatementDatabase(finalConn, insertSql);


                                // Close the connection
                                database.disconnectToDatabase(finalConn);

                                // Show message : Mission Accepted
                                MissionAccepted message = new MissionAccepted();

                            } finally {
                                if (finalConn != null) {
                                    try {
                                        finalConn.close();
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    });


                    p.add(button_accept, BorderLayout.SOUTH);
                    frame.add(p);


                    iter++;
                }
                JButton button_logout = new JButton("Log Out");
                JButton button_previous = new JButton("Previous");
                button_logout.setPreferredSize(new Dimension(100, 30));
                panelLogout.add(button_logout, BorderLayout.SOUTH);
                button_logout.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        SignUpOrLogIn signuporlogin = new SignUpOrLogIn();
                        frame.dispose();
                    }
                });

                button_previous.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        MissionTabVolunteer tabVolunteer = new MissionTabVolunteer(idUser);
                        frame.dispose();
                    }
                });

                panelLogout.add(button_previous);
                frame.add(panelLogout);

                frame.setLocationRelativeTo(null); // Center the frame on the screen
                /*show available missions*/
                // Make the window's dimension fit its content
                frame.pack();
                // Display the window.
                frame.setVisible(true);

            } finally {
                if (conn != null) {
                    database.disconnectToDatabase(conn);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}