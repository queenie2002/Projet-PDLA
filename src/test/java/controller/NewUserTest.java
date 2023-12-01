package controller;

import model.Service;
import model.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import static controller.InitializeDatabase.*;
import static org.junit.jupiter.api.Assertions.*;

public class NewUserTest {

    @Test
    public void testNewUserPatient() throws SQLException {

        //we initialize de the database
        Initialize();

        //we create a user
        String firstName = "geo";
        String lastName = "koutsodima";
        int type = 0;
        String password = "pwd";
        String dateOfBirth = "2002-12-12";

        model.User user = new User(firstName,lastName,type,password,dateOfBirth);
        controller.NewUser.AddNewUser(user);
        int idUser = user.getId();


        //connection
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();

        //we get the user with our id
        String findType = "select * from user where idUser = " + idUser + " ;";
        ResultSet res = database.doQueryDatabase(conn, findType);

        //we get all the information
        int idUserDatabase = -1;
        String firstNameDatabase = "";
        String lastNameDatabase = "";
        int typeDatabase = -1;
        String passwordDatabase = "";
        String dateOfBirthDatabase = "";


        while (true) {
            try {
                if (!res.next()) break;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                idUserDatabase = res.getInt("idUser");
                firstNameDatabase = res.getString("firstName");
                lastNameDatabase = res.getString("lastName");
                typeDatabase = res.getInt("type");
                passwordDatabase = res.getString("password");
                dateOfBirthDatabase = res.getString("dateOfBirth");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        assertEquals(idUser, idUserDatabase, "should be equal 1");
        assertEquals(firstName, firstNameDatabase, "should be equal geo");
        assertEquals(lastName, lastNameDatabase, "should be equal koutsodima");
        assertEquals(type, typeDatabase, "should be equal 0");
        assertEquals(password, passwordDatabase, "should be equal pwd");
        assertEquals(dateOfBirth, dateOfBirthDatabase, "should be equal 2002-12-12");

        //disconnection from database
        database.disconnectToDatabase(conn);
    }

    @Test
    public void testNewUserVolunteer() throws SQLException {

        //we initialize de the database
        Initialize();

        //we create a user
        String firstName = "yquynh";
        String lastName = "nguyen";
        int type = 1;
        String password = "pwd";
        String dateOfBirth = "2002-12-12";

        model.User user = new User(firstName,lastName,type,password,dateOfBirth);
        controller.NewUser.AddNewUser(user);
        int idUser = user.getId();


        //connection
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();

        //we get the user with our id
        String findType = "select * from user where idUser = " + idUser + " ;";
        ResultSet res = database.doQueryDatabase(conn, findType);

        //we get all the type
        int typeDatabase = -1;


        while (true) {
            try {
                if (!res.next()) break;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                typeDatabase = res.getInt("type");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        //we verify that the type is equal to 1 (which is the type of  volunteer)
        assertEquals(type, typeDatabase, "should be equal 1");

        //disconnection from database
        database.disconnectToDatabase(conn);
    }

}
