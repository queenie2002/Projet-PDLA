package controller;

import model.Service;
import model.User;
import java.sql.*;

import static controller.UseDatabase.*;

public class NewUser {

    /*METHODS*/
    public static void AddNewUser(User user) throws SQLException {
        /*connection*/
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();

        /*
        /*check if user exists already

        String existsSql = "select exists (select * FROM user WHERE idUser = 1);";
        ResultSet res = doQueryDatabase(conn, existsSql); //nous renvoie 1 s'il existe un user avec mm id
        int userExists = 0; //on initialise pour qu'il soit content but not supposed to

        while (res.next()) {
            userExists = res.getInt("EXISTS (SELECT * FROM user WHERE idUser = 1) ");
            System.out.println(res);
        }

        System.out.println(res);
        if (userExists == 0) {

         */
            /*insertion into user*/
            String insertSql = "INSERT INTO user (idUser, firstName, lastName, type, password, dateOfBirth) VALUES (" + String.valueOf(user.getId()) + ",'" + user.getFirstName() + "','" + user.getLastName() + "'," + String.valueOf(user.getType()) + ",'" + user.getPassword() + "','" + user.getDateOfBirth() + "') ;";
            database.doStatementDatabase(conn, insertSql);


            if (user.getType() == 0) {
                String insertSql1 = "INSERT INTO patient (idPatient) VALUES (" + String.valueOf(user.getId()) + ") ) ;";
                database.doStatementDatabase(conn, insertSql1);
            } else if (user.getType() == 1) {
                String insertSql1 = "INSERT INTO volunteer (idVolunteer) VALUES (" + String.valueOf(user.getId()) + ") ) ;";
                database.doStatementDatabase(conn, insertSql1);
            } else if (user.getType() == 2) {
                String insertSql1 = "INSERT INTO guarantor (idGuarantor) VALUES (" + String.valueOf(user.getId()) + ") ) ;";
                database.doStatementDatabase(conn, insertSql1);
            } else {
                System.out.println("error: didn't put a proper type for user (dans NewUser)");
            }
            database.disconnectToDatabase(conn);
            /*
        } else {
            System.out.print("error: there is already a user with same id (dans NewUser)");
        }
        */
    }


    public static void main(String[] args) throws SQLException {
        User user1 = new User("Y-Quynh", "Nguyen", 0, "pwd", "2002-03-25");
        AddNewUser(user1);
        User user2 = new User("Y-Quynh", "Nguyen", 1, "pwd", "2002-03-25");
        AddNewUser(user2);
    }
}
