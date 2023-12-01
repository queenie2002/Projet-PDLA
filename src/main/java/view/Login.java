package view;
import controller.UseDatabase;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

//to login the app
public class Login {

    //text field to get written idUser
    private JTextField jtField = new JTextField();

    //password field to get written password
    private JPasswordField jpField = new JPasswordField();



    public  Login() {

        // create the window
        JFrame frame = new JFrame("Geo & Queen");

        //when we close, we exit the app
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //we create buttons
        JButton button_login = new JButton("Login");
        JButton button_prev = new JButton("Previous");

        //when we click button login
        button_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //we get the written idUser and password
                String idUser = getIdUser();
                String password = getPassword();

                //connect to database
                UseDatabase database = new UseDatabase();
                Connection conn;
                conn = database.connectToDatabase();

                //gets the password of written iduser in the database
                String stringSql = "select idUser, password from user where idUser = " + idUser + ";";
                ResultSet res = database.doQueryDatabase(conn, stringSql);
                String passwordDatabase = "";

                //if there is such a user, we get their password from database
                while (true) {
                    try {
                        if (!res.next()) break; //if there is no next row, breaks out of the loop
                    } catch (SQLException ex) { //if there is an exception, wraps it in runtime exception
                        throw new RuntimeException(ex);
                    }
                    try { //gets password
                        passwordDatabase = res.getString("password");
                    } catch (SQLException ex) { //if there is an exception, wraps it in runtime exception
                        throw new RuntimeException(ex);
                    }
                }

                //if the password written corresponds to the password in the database, they can login and access the next tab
                if (Objects.equals(passwordDatabase, password)) {

                    //we get the user type from database
                    String findType = "select * from user where idUser = "+idUser;
                    ResultSet res1 = database.doQueryDatabase(conn, findType);
                    int userType=1000 ;

                    while (true) {
                        try {
                            if (!res1.next()) break;
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            userType = res1.getInt("type");
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }


                    if (userType == 0) {// if it's a patient, we send them to MissionTabPatient
                        MissionTabPatient tabPatient = new MissionTabPatient(Integer.parseInt(idUser));
                    }
                    else if (userType == 1) {// if it's a volunteer, we send them to MissionTabVolunteer
                        MissionTabVolunteer tabVolunteer = new MissionTabVolunteer(Integer.parseInt(idUser));
                    }
                    else if (userType == 2) {// if it's a guarantor, we send them to missiontabguarantor ?? -------------A FAIRE
                        //have to do it here
                    }
                    else {//else there was a problem with the type of the user
                        System.out.println("error: problem with finding the type of user in the database");
                    }

                    //we close the frame at the end
                    frame.dispose();
                }
                else {//if the login information is wrong: wrong password or unknown id     --------------------------A FAIRE
                    System.out.println("error: wrong login information");
                }

                //disconnection from database
                database.disconnectToDatabase(conn);
            }
        });

        //when we click button previous
        button_prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //goes back to tab signuporlogin
                SignUpOrLogIn signuporlogin = new SignUpOrLogIn();

                //closes frame
                frame.dispose();
            }
        });

        //we create a label with "login"
        JLabel loginLabel = new JLabel("Login", JLabel.CENTER);
        //set the size
        loginLabel.setPreferredSize(new Dimension(175, 100));



        //we create a panel
        JPanel p = new JPanel(new GridLayout(2, 1));

        //we add the textfields to the panel
        p.add(new JLabel("ID user"));
        p.add(jtField);
        p.add(new JLabel("Password"));
        p.add(jpField);

        p.setBorder(new EmptyBorder(50, 50, 50, 50));

        //we create another panel
        JPanel p1 = new JPanel(new GridLayout(1, 2));

        //we add the buttons to that panel
        p1.add(button_prev);
        p1.add(button_login);

        p1.setBorder(new EmptyBorder(50, 50, 50, 50));

        //we set the layout of the frame
        frame.setLayout(new GridLayout(3, 1));

        //we add the elements to the frame
        frame.add(loginLabel, BorderLayout.PAGE_START);
        frame.add(p);
        frame.add(p1);

        frame.setSize(500, 600);
        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        // Display the window.
        frame.setVisible(true);
    }


    //to get idUser from textfield
    public String getIdUser() {
        return this.jtField.getText();
    }

    //to get idUser from passwordfield
    public String getPassword() {
        return this.jpField.getText();
    }
}