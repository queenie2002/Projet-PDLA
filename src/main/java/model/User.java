package model;

public class User{
    //ATTRIBUTES
    private static int idUser=0;     //we made idUser a static to be a shared attribute over the whole class, that enables us to know at what number we stopped before
    private String firstName;        
    private String lastName;
    private int type;                //the type of user: a patient is 0, a volunteer is 1 and a guarantor is 2
    private String password;   
    private String dateOfBirth;      //it's a string but in the database, it's a date

    
    //CONSTRUCTOR
    /*we use it to create a user*/
    public User (String firstName, String lastName, int type, String password, String dateOfBirth){
        idUser +=1;                //everytime we create a user, their id is incremented compared to the last user
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
