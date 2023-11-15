package controller;


import java.sql.Connection;

public class InitializeDatabase {


    public static String createTableUser() {   /*table person*/
        return "create table if not exists user (" +
                "idUser int primary key," +
                "firstName VARCHAR(20)," +
                "lastName VARCHAR(20)," +
                "type int," + /*si 0=patient; si 1=volunteer; si 2=guarantor*/
                "password VARCHAR(20)," +
                "dateOfBirth date" +  /*year month date*/
                ");";
    }


    public static String createTableService() { /*table service*/
        return "create table if not exists service (" +
                "idService int primary key," +
                "idPatient int references user(idUser) ON DELETE CASCADE," +
                "idVolunteer int references user(idUser) ON DELETE SET NULL," +
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


