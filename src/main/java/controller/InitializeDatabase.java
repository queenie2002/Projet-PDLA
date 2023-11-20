package controller;


import java.sql.Connection;

/*
to initialize the database
we have the methods to create and drop the tables

first, we drop them to create them anew with no past information
*/

public class InitializeDatabase {

    //METHODS

    //to create a user table
    public static String createTableUser() { 
        return "create table if not exists user (" +
                "idUser int primary key," +    //idUser is primary key because that's the identifier we'll use to get back the other informations
                "firstName VARCHAR(20)," +
                "lastName VARCHAR(20)," +
                "type int," + 
                "password VARCHAR(20)," +
                "dateOfBirth date" +           //needs a birthday under format YYYY-MM-DD
                ");";
    }

    //to create a service table
    public static String createTableService() {
        return "create table if not exists service (" +
                "idService int primary key," +    //idService is primary key because that's the identifier we'll use to get back the other informations
                "idPatient int references user(idUser) ON DELETE SET NULL," +    //idPatient references idUser of a user, if the user with idUser is deleted, we put idPatient to null
                                                                                 //if it was offered by patient, we manually delete the service    
                "idVolunteer int references user(idUser) ON DELETE SET NULL," +  //idVolunteer references idUser of a user, if the user with idUser is deleted, we put idVolunteer to null
                                                                                 //if it was provided by idVolunteer, we manually delete the service   
                "location VARCHAR(20)," +
                "description VARCHAR(255)," +    
                "typeOfService int," + 
                "status int" +
                ");";
    }

    //to create a patient table
    public static String createTablePatient() {   
        return "create table if not exists patient (" +
                "idPatient int," +
                "foreign key (idPatient) references user(idUser) ON DELETE CASCADE );"; //idPatient references idUser of a user, if the user with idUser is deleted, we delete the patient                                            
    }

    //to create a volunteer table
    public static String createTableVolunteer() {   
        return "create table if not exists volunteer (" +
                "idVolunteer int," +
                "foreign key (idVolunteer) references user(idUser) ON DELETE CASCADE );"; //idVolunteer references idUser of a user, if the user with idUser is deleted, we delete the volunteer                                            
    }

    //to create a guarantor table
    public static String createTableGuarantor() {   
        return "create table if not exists guarantor (" +
                "idGuarantor int," +
                "foreign key (idGuarantor) references user(idUser) ON DELETE CASCADE );"; //idGuarantor references idUser of a user, if the user with idUser is deleted, we delete the guarantor          
    }

    //to drop user table
    public static String dropTableUser() {
        return "drop table user;";
    }

    //to drop service table
    public static String dropTableService() {
        return "drop table service;";
    }

    //to drop patient table
    public static String dropTablePatient() {
        return "drop table patient;";
    }

    //to drop guarantor table
    public static String dropTableGuarantor() {
        return "drop table guarantor;";
    }

    //to drop volunteer table
    public static String dropTableVolunteer() {
        return "drop table volunteer;";
    }

    //we want a new, empty database so we recreate all the tables
    public static void Initialize() {
        //connection
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();

        //drop all the tables
        database.doStatementDatabase(conn,dropTableGuarantor());
        database.doStatementDatabase(conn,dropTableVolunteer());
        database.doStatementDatabase(conn,dropTablePatient());
        database.doStatementDatabase(conn,dropTableUser());
        database.doStatementDatabase(conn,dropTableService());

        //create all tables
        database.doStatementDatabase(conn,createTableUser());
        database.doStatementDatabase(conn,createTableVolunteer());
        database.doStatementDatabase(conn,createTablePatient());
        database.doStatementDatabase(conn,createTableGuarantor());
        database.doStatementDatabase(conn,createTableService());
        database.disconnectToDatabase(conn);
    }

}


