package view;

import controller.UseDatabase;

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


    }



}
