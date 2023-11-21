package view;

import controller.UseDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ShowIdUser  {

    //private int newId;

    public ShowIdUser(int newId) {
        JFrame frame = new JFrame("Geo & Queen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("ID USER", JLabel.CENTER);
        JLabel textLabel = new JLabel("Your user ID is : "+ newId , JLabel.CENTER);


        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton button = new JButton("Next");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //close frame when we click on button
                frame.dispose();
                // connect to database to get the type to see if it's a Patient or a Volunteer
                /*connection*/
                UseDatabase database = new UseDatabase();
                Connection conn;
                conn = database.connectToDatabase();
                String findType = "select * from user where idUser = "+newId;
                ResultSet res = database.doQueryDatabase(conn, findType);
                int userType=1000 ;
                while (true) {
                    try {
                        if (!res.next()) break;
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        userType = res.getInt("type");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (userType == 0) {
                    MissionTabPatient tabPatient = new MissionTabPatient(newId);
                } else if (userType == 1) {
                    MissionTabVolunteer tabVolunteer = new MissionTabVolunteer(newId);
                } else {
                    System.out.println("problem with finding the user in the database");
                }

            }
        });

        panel.add(button);
        frame.getContentPane().add(panel, BorderLayout.PAGE_END);
        frame.setLocationRelativeTo(null);//center frame on screen

        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
