package controller;

import model.User;

import java.sql.Connection;

public class NewUser {

    /*METHODS*/
    public void AddNewUser(User user) {
        /*connection*/
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();
        /*insertion*/
        String insertSql = "INSERT INTO user (idUser, firstName, lastName, type, password, dateOfBirth) VALUES (" + String.valueOf(user.getId()) + ",'" + user.getFirstName() + "','" + user.getLastName() + "'," + String.valueOf(user.getType()) + ",'" + user.getPassword() + "','" + user.getDateOfBirth() + "') ;";
        database.doStatementDatabase(conn,insertSql);
        database.disconnectToDatabase(conn);
    }
}
