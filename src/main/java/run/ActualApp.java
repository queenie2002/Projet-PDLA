package run;
import controller.*;
import model.*;

import java.sql.*;
import view.*;

public class ActualApp  {

    public static void main(String[] args){

        //we initialize the database
        InitializeDatabase.Initialize();

        //we start up the program
        Login signuporlogin = new Login();

    }
}



