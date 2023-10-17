package model;


public class Service{
    //ATTRIBUTES
    private int idService; 
    private int idUser;
    private String location;
    private String description; 
    private int typeOfService; 
    private int status;
    
    //CONSTRUCTOR
    public Service ( int idService, int idUser, String location, String description, int typeOfService, int status){
        this.idService=idService;
        this.idUser=idUser; 
        this.location=location;
        this.description=description;
        this.typeOfService=typeOfService;
        this.status=status;
    } 

    //METHODS
    public int getIdService() { return this.idService; }
    public int getIdUser(){ return this.idUser;}
    public String getLocation(){ return this.location;}
    public String getDescription (){ return this.description;}
    public int getTypeOfService (){ return this.typeOfService;}
    public int getStatus(){ return status;}

} 
