package controller;

import model.Service;
import model.User;
import java.sql.*;


public class NewUser {

    /*METHODS*/
    public static void AddNewUser(User user) throws SQLException {

        /*connection*/
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();


        /*check if user exists already*/
        String existsSql = "select exists (select * FROM user WHERE idUser = 1);";
        ResultSet res = database.doQueryDatabase(conn, existsSql); //nous renvoie 1 s'il existe un user with same id
        int userExists = 0;

        while (res.next()) {
            userExists = res.getInt(1);
        }

        System.out.print("user id: " + user.getId());

        if (userExists == 0) { //means that the user doesn't exist

            /*insertion into user*/
            String insertSql = "INSERT INTO user (idUser, firstName, lastName, type, password, dateOfBirth) VALUES (" + String.valueOf(user.getId()) + ",'" + user.getFirstName() + "','" + user.getLastName() + "'," + String.valueOf(user.getType()) + ",'" + user.getPassword() + "','" + user.getDateOfBirth() + "') ;";
            database.doStatementDatabase(conn, insertSql);

            if (user.getType() == 0) {
                String insertSql1 = "INSERT INTO patient (idPatient) VALUES (" + String.valueOf(user.getId()) + ")  ;";
                database.doStatementDatabase(conn, insertSql1);
            } else if (user.getType() == 1) {
                String insertSql1 = "INSERT INTO volunteer (idVolunteer) VALUES (" + String.valueOf(user.getId()) + ")  ;";
                database.doStatementDatabase(conn, insertSql1);
            } else if (user.getType() == 2) {
                String insertSql1 = "INSERT INTO guarantor (idGuarantor) VALUES (" + String.valueOf(user.getId()) + ")  ;";
                database.doStatementDatabase(conn, insertSql1);
            } else {
                System.out.println("error: didn't put a proper type for user (dans NewUser)");
            }
            database.disconnectToDatabase(conn);

        } else {
            System.out.print("user id: " + user.getId());
            System.out.print("error: there is already a user with same id (dans NewUser)");
        }

    }


    public static void main(String[] args) throws SQLException {
        User user1 = new User("Patient", "Nguyen", 0, "pwd", "2002-03-25");
        AddNewUser(user1);
        User user2 = new User("Volunteer", "Nguyen", 1, "pwd", "2002-03-25");
        AddNewUser(user2);
    }
}
