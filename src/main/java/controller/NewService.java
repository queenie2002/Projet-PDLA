package controller;

import model.Service;
import view.PopUpTab;

import java.sql.*;

//to create a new service and add it to the database
public class NewService {

    //to add a service
    public static void AddNewService(Service service) throws SQLException {
        
        //connection to the database
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();

        //to check if we manage to create the service, else loops back
        boolean created = false;

        while(!created) {

            //check if service exists already

            //asks for information from database
            String existsSql = "select exists (select * FROM service WHERE idService = " + service.getIdService() + ");";
            ResultSet res = database.doQueryDatabase(conn, existsSql);     //returns 1 if there already is a service with same id
            int serviceExists = 0;        //we initialize to 0

            //treats the result
            while (res.next()) {
                serviceExists = res.getInt(1);
            }

            if (serviceExists == 0) { //if the service doesn't exist, we create a new service
                created = true;
                //insert service into database
                String insertSql = "INSERT INTO service (idService, idPatient, idVolunteer, location, description, typeOfService, status) VALUES (" + service.getIdService() + "," + service.getIdPatient() + "," + service.getIdVolunteer() + ", '" + service.getLocation() + "' , '" + service.getDescription() + "' ," + service.getTypeOfService() + "," + service.getStatus() + ");";
                database.doStatementDatabase(conn, insertSql);
            } else {//if the service already exists, tries again with an idService incremented
                Service.incrementIdService();
                System.out.println("error: there is already a service with same id");
            }
        }
        
        //disconnection from database
        database.disconnectToDatabase(conn);
    }
}
