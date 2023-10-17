package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UseDatabase {

  public Connection connectToDatabase () {
    Connection conn = null;
    while (conn = null) {
      try {
        String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/";
        String username = "projet_gei_002";
        String password = "Lio0Uhah";
        conn = DriverManager.getConnection(url, username, password);
      } catch (Exception e) {
        System.out.println("erreur on n'arrive pas à se connecter dans connectToDabatase");
        e.printStackTrace();
      }
    }
    return conn;
}

