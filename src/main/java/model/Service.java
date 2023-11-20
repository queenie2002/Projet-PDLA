package model;


public class Service{
    //ATTRIBUTES
    private static int idService=0;        //we made idService a static to be a shared attribute over the whole class, that enables us to know at what number we stopped before
    private int idPatient;                 //id of the patient who asked for the service or accepted that service
    private int idVolunteer;               //id of the volunteer who offered the service or accepted to do that service
    private String location;
    private String description; 
    private int typeOfService;             //the type of service: asked by the patient is 0, offered by the volunteer is 1
    private int status;                    //status of service: waiting to be accepted is 0, accepted by someone is 1, verified by guarantor that the service was done is 2
    
    //CONSTRUCTOR
    public Service (int idPatient, int idVolunteer, String location, String description, int typeOfService, int status){
        idService +=1;                    //everytime we create a service, their id is incremented compared to the last service
        this.idPatient =  idPatient;
        this.idVolunteer = idVolunteer;
        this.location=location;
        this.description=description;
        this.typeOfService=typeOfService;  
        this.status=0; 
    } 

    //METHODS
    public int getIdService() { return idService; }
    public int getIdPatient(){ return this.idPatient;}
    public int getIdVolunteer(){ return this.idVolunteer;}
    public String getLocation(){ return this.location;}
    public String getDescription (){ return this.description;}
    public int getTypeOfService (){ return this.typeOfService;}
    public int getStatus(){ return status;}

} 
