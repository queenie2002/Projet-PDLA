package run;

import java.sql.*;

public class actualApp {

    String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/";
    String username = "projet_gei_002";
    String password = "Lio0Uhah";




    public static void main(String[] args){

        /**********************************************
         *               INITIALIZING
        ***********************************************/

        /*TO CONNECT*/
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("*************************");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*CREATE TABLES*/
        Statement statement = connection.createStatement();
        statement.execute(createTableUser);
        statement.execute(createTableVolunteer);
        statement.execute(createTablePatient);
        statement.execute(createTableGuarantor);
        statement.execute(createTableService);


        /**********************************************
         *            STARTING PROGRAM
         ***********************************************/





    }





}



