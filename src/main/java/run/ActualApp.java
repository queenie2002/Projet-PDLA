package run;
import controller.*;
import model.*;

import java.sql.*;
import view.*;

public class ActualApp  {
    static String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_002";
    static String username = "projet_gei_002";
    static String password = "Lio0Uhah";









    public static void main(String[] args){

        /**********************************************
                        INITIALIZING
        ***********************************************/

        InitializeDatabase.Initialize();

        /**********************************************
                     STARTING PROGRAM
         ***********************************************/
        SignUpOrLogIn login1 = new SignUpOrLogIn();









    }





}



