package controller;

import model.Service;
import java.sql.*;

//to create a new service and add it to the database
public class NewService {

    //to add a service
    public static void AddNewService(Service service) throws SQLException {
        
        //connection to the database
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();


        //check if service exists already
        String existsSql = "select exists (select * FROM service WHERE idService = " + service.getIdService() + ");";
        ResultSet res = database.doQueryDatabase(conn, existsSql);     //returns 1 if there already is a service with same id
        int serviceExists = 0;        //we initialize to 0

        while (res.next()) {
            serviceExists = res.getInt(1);
        }

        if (serviceExists == 0) { //if the service doesn't exist, we create a new service
            
            //insert service into database
            String insertSql = "INSERT INTO service (idService, idPatient, idVolunteer, location, description, typeOfService, status) VALUES (" + service.getIdService() + "," + service.getIdPatient() + ", NULL, '" + /*service.getIdVolunteer()*/  service.getLocation() + "' , '" + service.getDescription() + "' ," + service.getTypeOfService() + "," + service.getStatus() + ");";
            database.doStatementDatabase(conn, insertSql);
           
        } else {//if it already exists, handles the error---------------------------------------------------A FAIRE, create a frame that shows this and redoes the process
            System.out.println("error: there is already a service with same id (dans NewService)"); 
        }
        //disconnection from database
        database.disconnectToDatabase(conn);
    }
}
