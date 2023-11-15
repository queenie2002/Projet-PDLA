package view;

import controller.UseDatabase;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowAvailableMissions {

    public ShowAvailableMissions(int idUser) throws SQLException {
        /*se connecter a la database et recupérer tous les services qui ont status=0*/
        /*connection*/
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();

        /*number of available services*/
        String numberMissions = "select count (*) from service where status=0";
        ResultSet res = database.doQueryDatabase(conn, numberMissions);

        /*available missions*/
        String mission = "select count (*) from service where status=0";
        ResultSet res_missions = database.doQueryDatabase(conn, numberMissions);
        while (res.next()) {
            String location = res.getString("location");
            String description = res.getString("description");
            /*put them on the frame*/
        }
        /*buttons*/
        for (int i=0; i<Integer.parseInt(numberMissions); i++ ) {

        }



        /*show available missions*/
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel("Available Missions", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);




    }



}
