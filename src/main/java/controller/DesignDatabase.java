package controller;


public class DesignDatabase {


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


    public String createTableService() { /*table service*/
        String createService = "create table if not exists service (" +
                "idService int primary key," +
                "idUser int references user(idUser) ON DELETE CASCADE," +
                "location VARCHAR(20)," +
                "description VARCHAR(255)," +
                "typeOfService int," + /*si 0=offered; si 1=provided*/
                "status int" + /*si 0=en attente; si 1=validé; si 2=réalisé*/
                ");";
        return createService;
    }

    public String createTablePatient() {   /*table patient*/
        String createPatient = "create table if not exists patient (" +
                "idPatient int references user(idUser) ON DELETE CASCADE primary key) inherits (user);";
        return createPatient;
    }

    public String createTableVolunteer() {   /*table volunteer*/
        String createVolunteer = "create table if not exists volunteer (" +
                "idVolunteer int references user(idUser) ON DELETE CASCADE primary key) inherits (user);";
        return createVolunteer;
    }

    public String createTableGuarantor() {   /*table guanrantor*/
        String createGuarantor = "create table if not exists guarantor (" +
                "idGuarantor int references user(idUser) ON DELETE CASCADE primary key) inherits (user);";
        return createGuarantor;
    }


    public String insertTableUser(int idUser, String firstName, String lastName, int type, String password, String dateOfBirth) {    /*ATTENTION DONNER DOB EN STRING*/
        String insertSql = "INSERT INTO user (idUser, firstName, lastName, type, password, dateOfBirth) VALUES (" + String.valueOf(idUser) + ",'" + firstName + "','" + lastName + "'," + String.valueOf(type) + ",'" + password + "','" + dateOfBirth + "') ;";
        return insertSql;
    }

    public String insertTableService(int idService, int idUser, String location, String description, int typeOfService, int status) {
        String insertSql = "INSERT INTO service (idService, idUser, location, description, typeOfService, status) VALUES (" + String.valueOf(idService)+ "," + String.valueOf(idUser) + ", '" + location + "' , '" + description + "' ," + String.valueOf(typeOfService) + "," + String.valueOf(status) + ");";
        return insertSql;
    }
    public String insertTablePatient (int idPatient){
        String insertSql = "INSERT INTO patient (idPatient) VALUES (" + String.valueOf(idPatient) + ");";
        return insertSql;
    } 
    
    public String insertTableVolunteer (int idVolunteer){
        String insertSql = "INSERT INTO volunteer (idVolunteer) VALUES (" + String.valueOf(idVolunteer) + ");";
        return insertSql;
    }
    
    public String insertTableGuarantor(int idGuarantor){
        String insertSql = "INSERT INTO guarantor (idGuarantor) VALUES (" + String.valueOf(idGuarantor) + ");";
        return insertSql;
    } 

//change whataoevnaeo


}


