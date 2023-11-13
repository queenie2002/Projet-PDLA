package controller;

import model.Service;

import java.sql.Connection;

public class NewService {
    public static void AddNewService(Service service) {
        UseDatabase database = new UseDatabase();
        Connection conn;
        /*connection*/
        conn = database.connectToDatabase();
        /*insertion*/
        String insertSql = "INSERT INTO service (idService, idPatient, idVolunteer, location, description, typeOfService, status) VALUES (" + String.valueOf(service.getIdService())+ "," + String.valueOf(service.getIdPatient()) + ", " + String.valueOf(service.getIdVolunteer()) + ", '" + service.getLocation() + "' , '" + service.getDescription() + "' ," + String.valueOf(service.getTypeOfService()) + "," + String.valueOf(service.getStatus()) + ");";
        database.doStatementDatabase(conn,insertSql);
        database.disconnectToDatabase(conn);
    }

    public static void main(String[] args) {
        Service service = new Service(1, 1, 1, "hôpital", "hava to do this", 1, 0);
        AddNewService(service);
    }

}
