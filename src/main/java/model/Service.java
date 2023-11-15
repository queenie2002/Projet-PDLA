package model;


public class Service{
    //ATTRIBUTES
    private static int idService=0;
    private int idPatient;
    private int idVolunteer;
    private String location;
    private String description; 
    private int typeOfService; 
    private int status;
    
    //CONSTRUCTOR
    public Service (int idPatient, int idVolunteer, String location, String description, int typeOfService, int status){
        idService +=1;
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
