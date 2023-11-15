package view;

import controller.UseDatabase;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class ShowAvailableMissions {

    public ShowAvailableMissions(int idUser) {
        /*se connecter a la database et recupérer tous les services qui ont status=0*/
        /*connection*/
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();

        String findType = "select * from service where status=0";
        ResultSet res = database.doQueryDatabase(conn, findType);

        /*show available missions*/
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel("Available Missions", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);


    }



}
