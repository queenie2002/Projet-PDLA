package view;

import controller.NewService;
import controller.NewUser;
import model.Service;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class NewMissionPatient {
    private final JTextField[] jtFields = new JTextField[2];
    public NewMissionPatient (int idUser) {
        jtFields[0] = new JTextField();
        jtFields[1] = new JTextField();


        JButton button_newmission = new JButton("add new mission");
        JButton button_logout = new JButton("Log Out");

        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button_newmission.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = getLocation();
                String description = getDescription();

                /*ajout du nouveau service dans la database*/
                model.Service service = new Service(idUser,0,location,description,0,0);
                try {
                    NewService.AddNewService(service);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                SignUpOrLogIn signuporlogin = new SignUpOrLogIn();
                frame.dispose();

            }
        });


        button_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                frame.dispose();
            }
        });



        JLabel emptyLabel = new JLabel("New Mission", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);

        JPanel p = new JPanel(new GridLayout(6, 2));
        p.add(new JLabel("Location : "));
        p.add(jtFields[0]);
        p.add(new JLabel("Description : "));
        p.add(jtFields[1]);



        p.add(button_newmission);
        p.add(button_logout);

        frame.add(p);
        // Make the window's dimension fit its content
        frame.pack();
        // Display the window.
        frame.setVisible(true);
    }

    public String getLocation() {
        return this.jtFields[0].getText();
    }

    public String getDescription() {
        return this.jtFields[1].getText();
    }





}
