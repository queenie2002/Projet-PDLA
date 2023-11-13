package controller;

import model.Service;
import model.User;

import java.sql.Connection;

public class NewUser {

    /*METHODS*/
    public static void AddNewUser(User user) {
        /*connection*/
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();
        /*insertion*/
        String insertSql = "INSERT INTO user (idUser, firstName, lastName, type, password, dateOfBirth) VALUES (" + String.valueOf(user.getId()) + ",'" + user.getFirstName() + "','" + user.getLastName() + "'," + String.valueOf(user.getType()) + ",'" + user.getPassword() + "','" + user.getDateOfBirth() + "') ;";
        database.doStatementDatabase(conn,insertSql);
        database.disconnectToDatabase(conn);
    }


    public static void main(String[] args) {
        User user = new User(1, "Y-QUynh", "Nguyen", 0, "pwd", "2002-03-25");
        AddNewUser(user);
    }
}
