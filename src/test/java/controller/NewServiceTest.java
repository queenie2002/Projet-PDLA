package controller;

import model.Service;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import static controller.InitializeDatabase.*;
import static org.junit.jupiter.api.Assertions.*;

public class NewServiceTest {

    @Test
    public void testNewService() throws SQLException {

        //we initialize de the database
        Initialize();


        //we create a service
        int idPatient = 1;
        int idVolunteer = 0;
        String location = "location";
        String description = "description";
        int typeOfService = 0;
        int status = 0;

        model.Service service = new Service(idPatient,idVolunteer,location,description,typeOfService,status);
        controller.NewService.AddNewService(service);

        int idService = service.getIdService();

        //connection
        UseDatabase database = new UseDatabase();
        Connection conn;
        conn = database.connectToDatabase();

        //we get the service with our id
        String findType = "select * from service where idService = " + idService + " ;";
        ResultSet res = database.doQueryDatabase(conn, findType);

        //we get all the information
        int idServiceDatabase = -1;
        int idPatientDatabase = -1;
        int idVolunteerDatabase = -1;
        String locationDatabase = "";
        String descriptionDatabase = "";
        int typeOfServiceDatabase = -1;
        int statusDatabase = -1;



        while (true) {
            try {
                if (!res.next()) break;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                idServiceDatabase = res.getInt("idService");
                idPatientDatabase = res.getInt("idPatient");
                idVolunteerDatabase = res.getInt("idVolunteer");
                locationDatabase = res.getString("location");
                descriptionDatabase = res.getString("description");
                typeOfServiceDatabase = res.getInt("typeOfService");
                statusDatabase = res.getInt("status");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        assertEquals(idService, idServiceDatabase, "should be equal 1");
        assertEquals(idPatient, idPatientDatabase, "should be equal 0");
        assertEquals(idVolunteer, idVolunteerDatabase, "should be equal 1");
        assertEquals(location, locationDatabase, "should be equal location");
        assertEquals(description, descriptionDatabase, "should be equal description");
        assertEquals(typeOfService, typeOfServiceDatabase, "should be equal 0");
        assertEquals(status, statusDatabase, "should be equal 0");

    }



}
