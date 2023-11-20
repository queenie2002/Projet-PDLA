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

        //il faudra gérer quand on crée les missions si typeservice est 1 ou 0 dépendant de qui le fait
        if (serviceExists == 0) { //if the service doesn't exist, we create a new service
            //insert service into database
            String insertSql = "INSERT INTO service (idService, idPatient, idVolunteer, location, description, typeOfService, status) VALUES (" + service.getIdService() + "," + service.getIdPatient() + ", NULL, '" + /*service.getIdVolunteer()*/  service.getLocation() + "' , '" + service.getDescription() + "' ," + service.getTypeOfService() + "," + service.getStatus() + ");";
                                        //we set idVolunteer to NULL at first
            database.doStatementDatabase(conn, insertSql);
            database.disconnectToDatabase(conn);
        } else {//if it already exists, handles the error
            System.out.println("error: there is already a service with same id (dans NewService)");  //potentially, we could create a frame that shows this and redoes the process i guess
        }
    }
}
