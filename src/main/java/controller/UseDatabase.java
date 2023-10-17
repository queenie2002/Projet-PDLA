package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UseDatabase {

  public Connection connectToDatabase() {
    Connection conn = null;
    while (conn == null) {
      try {
        String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/";
        String username = "projet_gei_002";
        String password = "Lio0Uhah";
        conn = DriverManager.getConnection(url, username, password);
        System.out.println("on s'est connecté");


        Statement stmt = conn.createStatement();
        String connectSQL = "use projet_gei_002; ";
        stmt.execute(connectSQL);

      } catch (Exception e) {
        System.out.println("erreur on n'arrive pas à se connecter dans connectToDabatase");
        e.printStackTrace();
      }
    }
    return conn;
  }

  public void doStatementDatabase(Connection conn, String toDo) {
    try {
      Statement stmt = conn.createStatement();
      stmt.execute(toDo);
    } catch (Exception e) {
      System.out.println("pas réussi à faire le SQL dans doStatementDatabase");
      e.printStackTrace();
    }
  }


  public void disconnectToDatabase(Connection conn) {
    try {
      if (conn != null) {
        conn.close();
        System.out.println("on s'est déconnecté");
      }
    } catch (Exception e) {
      System.out.println("erreur on n'arrive pas à se déconnecter de disconnectToDatabase");
      e.printStackTrace();
    }
  }
}

  

