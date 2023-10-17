package controller;

import model.Service;

public class NewService {
    public void AddNewService(Service service) {
        /*connection*/
        /*insertion*/
        String insertSql = "INSERT INTO service (idService, idUser, location, description, typeOfService, status) VALUES (" + String.valueOf(service.getIdService())+ "," + String.valueOf(service.getIdUser()) + ", '" + service.getLocation() + "' , '" + service.getDescription() + "' ," + String.valueOf(service.getTypeOfService()) + "," + String.valueOf(service.getStatus()) + ");";
    }
}
