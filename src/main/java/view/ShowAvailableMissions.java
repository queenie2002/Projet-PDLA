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

        try {
            /*se connecter a la database et recupérer tous les services qui ont status=0*/
            /*connection*/
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

                    // Add mission number to the NORTH
                    p.add(new JLabel("Mission n°" + idService), BorderLayout.NORTH);

                    // Create a new panel for location and description
                    JPanel infoPanel = new JPanel(new GridLayout(2, 2));
                    infoPanel.add(new JLabel("Location:"));
                    infoPanel.add(new JLabel(location));
                    infoPanel.add(new JLabel("Description:"));
                    infoPanel.add(new JLabel(description));

                    // Add the infoPanel to the CENTER
                    p.add(infoPanel, BorderLayout.CENTER);


                    JButton button = new JButton("Accept");
                    button.addActionListener(new ActionListener() {
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

                                // Dispose of the frame or perform any other necessary actions
                                frame.dispose();
                            } finally {
                                // Make sure to close the connection in case of an exception
                                if (finalConn != null) {
                                    try {
                                        finalConn.close();
                                    } catch (SQLException e) {
                                        e.printStackTrace(); // Handle the exception appropriately in your application
                                    }
                                }
                            }
                        }
                    });

                    // Add the button to the SOUTH
                    p.add(button, BorderLayout.SOUTH);

                    // Add the main panel to the frame
                    frame.add(p);

                    iter++;
                }


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
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }
}