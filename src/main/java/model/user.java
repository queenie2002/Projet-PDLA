package model;

public class user{
    //ATTRIBUTES
    private int idUser; 
    private String firstName;
    private String lastName;
    private int type; 
    private String password; 
    private String dateOfBirth;
    
    //CONSTRUCTOR
    public user (int idUser, String firstName, String lastName, int type, String password, String dateOfBirth){
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type=type;
        this.password=password;
        this.dateOfBirth=dateOfBirth;
    } 

    //METHODS
    public int getId() { return this.idUser; }
    public String getFirstName (){ return this.firstName;}
    public String getLastName(){ return this.lastName;}
    public int getType (){ return this.type;}
    public String getPassword (){ return this.password;}
    public String getDateOfBirth (){ return dateOfBirth;}

} 
