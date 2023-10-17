package run;
import controller.DesignDatabase;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ActualApp  {

    static String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/";
    static String username = "projet_gei_002";
    static String password = "Lio0Uhah";




    public static void main(String[] args){

        /**********************************************
         *               INITIALIZING
        ***********************************************/

        /*TO CONNECT*/
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*CREATE TABLES*/
        try {

            Statement statement = connection.createStatement();
            statement.execute(DesignDatabase.createTableUser());
            statement.execute(DesignDatabase.createTableVolunteer());
            statement.execute(DesignDatabase.createTablePatient());
            statement.execute(DesignDatabase.createTableGuarantor());
            statement.execute(DesignDatabase.createTableService());
        }
        catch (SQLException e) {
            System.out.println("problem");
        }



        /**********************************************
         *            STARTING PROGRAM
         ***********************************************/





    }





}



