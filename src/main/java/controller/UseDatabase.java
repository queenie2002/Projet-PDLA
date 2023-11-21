package controller;

import java.sql.*;

/*
  to exchange with the database,
  we have methods to connect, disconnect, do statement and do query
*/

public class UseDatabase {

  //to connect to database
  public Connection connectToDatabase() {

    Connection conn = null;

    //we loop until we get a connection
    while (conn == null) {
      
      try {
        
        //our database's login information
        String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_002";
        String username = "projet_gei_002";
        String password = "Lio0Uhah";

        //we get the connection
        conn = DriverManager.getConnection(url, username, password);

        //we get into the right project
        Statement stmt = conn.createStatement();
        String connectSQL = "use projet_gei_002; ";
        stmt.execute(connectSQL);
        stmt.close();

      } catch (Exception e) { //if we can't connect to database, handles error ----------------------------------------- A FAIRE
        System.out.println("error: couldn't connect to database");
        e.printStackTrace();
      }
    }
    return conn;
  }

  //to do something in database
  public void doStatementDatabase(Connection conn, String toDo) {
    
    try {

      //we create a statement, execute it then close it
      Statement stmt = conn.createStatement();
      stmt.execute(toDo);
      stmt.close(); //-----------------------------------------------------------------IS THAT NEEDED
      
    } catch (Exception e) { //if we can't execute the statement in database, handles error ----------------------------------------- A FAIRE
      System.out.println("error: couldn't execute statement in database");
      e.printStackTrace();
    }
  }

  //to get information from database
  public ResultSet doQueryDatabase(Connection conn, String toDo) {
    
    try {
      
      //we create a statement and execute it
      Statement stmt = conn.createStatement();
        return stmt.executeQuery(toDo);
      
    } catch (Exception e) {  //if we can't execute the query in database, handles error ----------------------------------------- A FAIRE
      System.out.println("error: couldn't execute query in database");
      e.printStackTrace();
      return null;
    }
  }

  //to disconnect from database
  public void disconnectToDatabase(Connection conn) {
    
    try {
      
      if (conn != null) { //if connection exists, we close it
        conn.close();
      }
    } catch (Exception e) { //if the connection wasn't properly done, 't execute the query in database, handles error ----------------------------------------- A FAIRE
      System.out.println("error: couldn't disconnect from database");
      e.printStackTrace();
    }
  }
}

  

