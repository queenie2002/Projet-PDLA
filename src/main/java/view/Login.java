package view;
import controller.UseDatabase;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Login {

    private JTextField[] jtFields = new JTextField[2];



    public  Login() {
        jtFields[0] = new JTextField();
        jtFields[1] = new JTextField();
        // Create and set up the window
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button_login = new JButton("login");
        button_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idUser = getIdUser();
                String password = getPassword();

                UseDatabase database = new UseDatabase();
                Connection conn;
                conn = database.connectToDatabase();

                /*asks for password and user*/
                String stringSql = "select idUser, password from user where idUser = " + idUser + ";";
                ResultSet res = database.doQueryDatabase(conn, stringSql); //nous renvoie idUser et password

                int idUserDatabase = 50000;
                String passwordDatabase = "";

                while (true) {
                    try {
                        if (!res.next()) break;
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        idUserDatabase = res.getInt("idUser");
                        passwordDatabase = res.getString("password");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                if ((idUserDatabase == Integer.parseInt(idUser)) && Objects.equals(passwordDatabase, password)) {
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
                        MissionTabPatient tabPatient = new MissionTabPatient(idUserDatabase);

                    } else if (userType == 1) {
                        MissionTabVolunteer tabVolunteer = new MissionTabVolunteer(idUserDatabase);
                    } else {
                        System.out.println("problem with finding the user in the database");
                    }
                    frame.dispose();
                }
            }
        });



        JLabel emptyLabel = new JLabel("Login", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);

        JPanel p = new JPanel(new GridLayout(1, 2));
        p.add(new JLabel("ID user"));
        p.add(jtFields[0]);
        p.add(new JLabel("Password"));
        p.add(jtFields[1]);

        p.add(button_login);
        frame.add(p);

        // Make the window's dimension fit its content
        frame.pack();
        // Display the window.
        frame.setVisible(true);
    }

    public String getIdUser() {
        return this.jtFields[0].getText();
    }

    public String getPassword() {
        return this.jtFields[1].getText();
    }


}