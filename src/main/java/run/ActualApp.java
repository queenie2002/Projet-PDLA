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
        //SignUpOrLogIn signuporlogin = new SignUpOrLogIn();


        //we start up the program
        NewMissionPatient signuporlogin = new NewMissionPatient(1);





    }
}



