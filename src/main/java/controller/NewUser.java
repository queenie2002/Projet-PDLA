package controller;

import model.*;
import java.sql.*;

//to create a new user and add it to the database
public class NewUser {

    //to add a user
    public static void AddNewUser(User user) throws SQLException {

        //connection to the database
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();


        //check if user exists already
        
        //asks for information from database
        String existsSql = "select exists (select * FROM user WHERE idUser = " + String.valueOf(user.getId()) + ");";
        ResultSet res = database.doQueryDatabase(conn, existsSql); //returns 1 if there already is a user with same id
        int userExists = 0;   //we initialize to 0

        //treats the result
        while (res.next()) {
            userExists = res.getInt(1);
        }

        if (userExists == 0) {  //if the user doesn't exist, we create a new user

            //insert user into table user of database
            String insertSql = "INSERT INTO user (idUser, firstName, lastName, type, password, dateOfBirth) VALUES (" + String.valueOf(user.getId()) + ",'" + user.getFirstName() + "','" + user.getLastName() + "'," + String.valueOf(user.getType()) + ",'" + user.getPassword() + "','" + user.getDateOfBirth() + "') ;";
            database.doStatementDatabase(conn, insertSql);

            //according to type (patient, volunteer, guarantor), we insert into table
            
            if (user.getType() == 0) { //if the user is a patient
                String insertSql1 = "INSERT INTO patient (idPatient) VALUES (" + String.valueOf(user.getId()) + ")  ;";
                database.doStatementDatabase(conn, insertSql1);
            } 
            else if (user.getType() == 1) { //if the user is a volunteer
                String insertSql1 = "INSERT INTO volunteer (idVolunteer) VALUES (" + String.valueOf(user.getId()) + ")  ;";
                database.doStatementDatabase(conn, insertSql1);
            } 
            else if (user.getType() == 2) { //if the user is a guarantor
                String insertSql1 = "INSERT INTO guarantor (idGuarantor) VALUES (" + String.valueOf(user.getId()) + ")  ;";
                database.doStatementDatabase(conn, insertSql1);
            } 
            else { //else there was a problem of type, handles error ----------------------------------------------------A FAIRE
                System.out.println("error: didn't put a proper type for user (dans NewUser)");
            }

        } else { //if the user already exists, handles the error---------------------------------------------------A FAIRE, create a frame that shows this and redoes the process
            System.out.println("error: there is already a user with same id (dans NewUser)");  //potentially, we could create a frame that showss this and redoes the process i guess
        }
        
        //disconnection from database
        database.disconnectToDatabase(conn);
    }
}
