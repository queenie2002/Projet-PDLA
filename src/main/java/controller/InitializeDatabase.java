package controller;


public class InitializeDatabase {


    public static String createTableUser() {   /*table person*/
        String createUser = "create table if not exists user (" +
                "idUser int primary key," +
                "firstName VARCHAR(20)," +
                "lastName VARCHAR(20)," +
                "type int," + /*si 0=patient; si 1=volunteer; si 2=guarantor*/
                "password VARCHAR(20)," +
                "dateOfBirth date" +  /*year month date*/
                ");";
        return createUser;
    }


    public static String createTableService() { /*table service*/
        String createService = "create table if not exists service (" +
                "idService int primary key," +
                "idPatient int references user(idUser) ON DELETE CASCADE," +
                "idVolunteer int references user(idUser) ON DELETE CASCADE," +
                "location VARCHAR(20)," +
                "description VARCHAR(255)," +
                "typeOfService int," + /*si 0=offered; si 1=provided*/
                "status int" + /*si 0=en attente; si 1=validé; si 2=réalisé*/
                ");";
        return createService;
    }

    public static String createTablePatient() {   /*table patient*/
        String createPatient = "create table if not exists patient (" +
                "idPatient int primary key references user(idUser) ON DELETE CASCADE );";
        return createPatient;
    }

    public static String createTableVolunteer() {   /*table volunteer*/
        String createVolunteer = "create table if not exists volunteer (" +
                "idVolunteer int primary key references user(idUser) ON DELETE CASCADE );";
        return createVolunteer;
    }

    public static String createTableGuarantor() {   /*table guanrantor*/
        String createGuarantor = "create table if not exists guarantor (" +
                "idGuarantor int primary key references user(idUser) ON DELETE CASCADE );";
        return createGuarantor;
    }

}


