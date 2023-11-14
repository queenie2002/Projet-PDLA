package model;

public class User{
    //ATTRIBUTES
    private static int idUser=0;
    private String firstName;
    private String lastName;
    private int type; /* patient 0, volunteer 1, guarantoe 2 ecrit qq part*/
    private String password; 
    private String dateOfBirth;
    
    //CONSTRUCTOR
    public User (String firstName, String lastName, int type, String password, String dateOfBirth){
        idUser +=1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type=type;
        this.password=password;
        this.dateOfBirth=dateOfBirth;
    } 

    //METHODS
    public int getId() { return idUser; }
    public String getFirstName (){ return this.firstName;}
    public String getLastName(){ return this.lastName;}
    public int getType (){ return this.type;}
    public String getPassword (){ return this.password;}
    public String getDateOfBirth (){ return dateOfBirth;}

} 
