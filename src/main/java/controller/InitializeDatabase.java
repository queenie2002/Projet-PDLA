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
                "typeOfService int," + /*si 0=offered; si 1=provided*/
                "status int" + /*si 0=en attente; si 1=validé; si 2=réalisé*/
                ");";
    }

    public static String createTablePatient() {   /*table patient*/
        return "create table if not exists patient (" +
                "idPatient int," +
                "foreign key (idPatient) references user(idUser) ON DELETE CASCADE );";
    }

    public static String createTableVolunteer() {   /*table volunteer*/
        return "create table if not exists volunteer (" +
                "idVolunteer int," +
                "foreign key (idVolunteer) references user(idUser) ON DELETE CASCADE );";
    }

    public static String createTableGuarantor() {   /*table guanrantor*/
        return "create table if not exists guarantor (" +
                "idGuarantor int," +
                "foreign key (idGuarantor) references user(idUser) ON DELETE CASCADE );";
    }

    public static String dropTableUser() {
        return "drop table user;";
    }

    public static String dropTableService() {
        return "drop table service;";
    }

    public static String dropTablePatient() {
        return "drop table patient;";
    }

    public static String dropTableGuarantor() {
        return "drop table guarantor;";
    }

    public static String dropTableVolunteer() {
        return "drop table volunteer;";
    }

    public static void Initialize() {
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();

        //we drop all the tables
        database.doStatementDatabase(conn,dropTableGuarantor());
        database.doStatementDatabase(conn,dropTableVolunteer());
        database.doStatementDatabase(conn,dropTablePatient());
        database.doStatementDatabase(conn,dropTableUser());
        database.doStatementDatabase(conn,dropTableService());

        //we create all tables
        database.doStatementDatabase(conn,createTableUser());
        database.doStatementDatabase(conn,createTableVolunteer());
        database.doStatementDatabase(conn,createTablePatient());
        database.doStatementDatabase(conn,createTableGuarantor());
        database.doStatementDatabase(conn,createTableService());
        database.disconnectToDatabase(conn);
    }

}


