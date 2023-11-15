package run;
import controller.*;
import model.*;

import java.sql.*;
import view.*;

public class ActualApp  {
    static String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_002";
    static String username = "projet_gei_002";
    static String password = "Lio0Uhah";









    public static void main(String[] args){

        /**********************************************
                        INITIALIZING
        ***********************************************/

        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();

        //we drop all the tables
        database.doStatementDatabase(conn,InitializeDatabase.dropTableGuarantor());
        database.doStatementDatabase(conn,InitializeDatabase.dropTableVolunteer());
        database.doStatementDatabase(conn,InitializeDatabase.dropTablePatient());
        database.doStatementDatabase(conn,InitializeDatabase.dropTableUser());
        database.doStatementDatabase(conn,InitializeDatabase.dropTableService());



        database.doStatementDatabase(conn,InitializeDatabase.createTableUser());
        database.doStatementDatabase(conn,InitializeDatabase.createTableVolunteer());
        database.doStatementDatabase(conn,InitializeDatabase.createTablePatient());
        database.doStatementDatabase(conn,InitializeDatabase.createTableGuarantor());
        database.doStatementDatabase(conn,InitializeDatabase.createTableService());
        database.disconnectToDatabase(conn);

        /**********************************************
                     STARTING PROGRAM
         ***********************************************/
        //Login login = new Login();







    }





}



