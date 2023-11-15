package controller;

import model.Service;

import java.sql.*;

public class NewService {


    public static void AddNewService(Service service) throws SQLException {
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();


        /*check if service exists already*/
        String existsSql = "select exists (select * FROM service WHERE idService = " + service.getIdService() + ");";
        ResultSet res = database.doQueryDatabase(conn, existsSql); //nous renvoie 1 s'il existe un service with same id
        int serviceExists = 0;

        while (res.next()) {
            serviceExists = res.getInt(1);
        }

        //on set id volunteer a NULL au début
        //il faudra gérer quand on crée les missions si typeservice est 1 ou 0 dépendant de qui le fait
        if (serviceExists == 0) { //means that the service doesn't exist
            /*insertion*/
            String insertSql = "INSERT INTO service (idService, idPatient, idVolunteer, location, description, typeOfService, status) VALUES (" + service.getIdService() + "," + service.getIdPatient() + ", NULL, '" + /*service.getIdVolunteer()*/  service.getLocation() + "' , '" + service.getDescription() + "' ," + service.getTypeOfService() + "," + service.getStatus() + ");";
            database.doStatementDatabase(conn, insertSql);
            database.disconnectToDatabase(conn);
        } else {
            System.out.println("error: there is already a service with same id (dans NewService)");  //potentially, we could create a frame that shows this and redoes the process i guess
        }
    }

    public static void main(String[] args) throws SQLException {
        Service service1 = new Service(1, 0, "SERVICE1", "have to do this", 1, 0);
        AddNewService(service1);
        Service service2 = new Service(1, 0, "service2", "have to do this", 1, 0);
        AddNewService(service2);
    }

}
