package controller;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseDatabaseTest {

    @Test
    //connection test
    public void ConnectToDatabaseTest () {
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();
        if (conn != null) {
            System.out.println("the connection worked");
        }
        else {
            System.out.println("problem with connection");
        }

        //disconnection from database
        database.disconnectToDatabase(conn);
    }

    @Test
    //disconnection test
    public void disconnectToDatabaseTest () throws SQLException {
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase(); //connection
        database.disconnectToDatabase(conn); //disconnection
        assertTrue(conn.isClosed());
    }

}
