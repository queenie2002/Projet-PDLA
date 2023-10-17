package controller;

import model.User;

public class NewUser {

    /*METHODS*/
    public void AddNewUser(User user) {
        /*connection*/
        /*insertion*/
        String insertSql = "INSERT INTO user (idUser, firstName, lastName, type, password, dateOfBirth) VALUES (" + String.valueOf(user.getId()) + ",'" + user.getFirstName() + "','" + user.getLastName() + "'," + String.valueOf(user.getType()) + ",'" + user.getPassword() + "','" + user.getDateOfBirth() + "') ;";
    }
}
