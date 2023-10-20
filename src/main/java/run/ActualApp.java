package run;
import controller.*;
import model.*;

import java.sql.*;

public class ActualApp  {
    static String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/";
    static String username = "projet_gei_002";
    static String password = "Lio0Uhah";




    public static void main(String[] args){

        /**********************************************
         *               INITIALIZING
        ***********************************************/

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            statement.execute(InitializeDatabase.createTableUser());
            statement.execute(InitializeDatabase.createTableVolunteer());
            statement.execute(InitializeDatabase.createTablePatient());
            statement.execute(InitializeDatabase.createTableGuarantor());
            statement.execute(InitializeDatabase.createTableService());
        } catch (SQLException e) {
            System.out.println("problem");
        }

        /*
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();
        
        database.doStatementDatabase(conn,InitializeDatabase.createTableUser());
        database.doStatementDatabase(conn,InitializeDatabase.createTableVolunteer());
        database.doStatementDatabase(conn,InitializeDatabase.createTablePatient());
        database.doStatementDatabase(conn,InitializeDatabase.createTableGuarantor());
        database.doStatementDatabase(conn,InitializeDatabase.createTableService());
        database.disconnectToDatabase(conn);*/

        /**********************************************
         *            STARTING PROGRAM
         ***********************************************/





    }





}



