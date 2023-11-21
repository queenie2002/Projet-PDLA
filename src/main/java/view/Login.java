package view;
import controller.UseDatabase;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;


public class Login {

    //text field to get written idUser
    private JTextField jtField = new JTextField();

    //password field to get written password
    private JPasswordField jpField = new JPasswordField();



    public  Login() {

        // Create and set up the window
        JFrame frame = new JFrame("Geo & Queen");
        frame.setLayout(new FlowLayout());

        //when we close, we exit the app
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //we create buttons
        JButton button_login = new JButton("Login");
        JButton button_prev = new JButton("Previous");

        //add action listeners
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
                        if (!res.next()) break;
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        passwordDatabase = res.getString("password");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                if (Objects.equals(passwordDatabase, password)) {
                    //accéder à la database pour récupérer le type du user pour savoir si c'est un Patient ou un Volunteer
                    /*connection*/

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
                    if (userType == 0) {
                        MissionTabPatient tabPatient = new MissionTabPatient(Integer.parseInt(idUser));

                    } else if (userType == 1) {
                        MissionTabVolunteer tabVolunteer = new MissionTabVolunteer(Integer.parseInt(idUser));
                    } else {
                        System.out.println("problem with finding the user in the database");
                    }
                    frame.dispose();
                }
            }
        });

        button_prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SignUpOrLogIn signuporlogin = new SignUpOrLogIn();
                frame.dispose();
            }
        });


        JLabel emptyLabel = new JLabel("Login", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);

        JPanel p = new JPanel(new GridLayout(2, 1));
        p.add(new JLabel("ID user"));
        p.add(jtField);
        p.add(new JLabel("Password"));
        p.add(jpField);

        JPanel p1 = new JPanel(new GridLayout(1, 2));
        p1.add(button_prev);
        p1.add(button_login);

        frame.setLayout(new GridLayout(3, 1));
        frame.add(emptyLabel, BorderLayout.PAGE_START);
        frame.add(p);
        frame.add(p1);

        // Make the window's dimension fit its content
        frame.pack();
        // Center the frame on the screen
        frame.setLocationRelativeTo(null);  // Center the frame on the screen
        // Display the window.
        frame.setVisible(true);
    }

    public String getIdUser() {
        return this.jtField.getText();
    }

    public String getPassword() {
        return this.jpField.getText();
    }


}