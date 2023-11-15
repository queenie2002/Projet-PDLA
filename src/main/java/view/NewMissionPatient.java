package view;

import controller.NewUser;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class NewMissionPatient {
    private final JTextField[] jtFields = new JTextField[2];
    public NewMissionPatient () {
        jtFields[0] = new JTextField();
        jtFields[1] = new JTextField();


        JButton button_signup = new JButton("add new mission");
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button_signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = getFirstName();
                String description = getLastName();
                int type = getType();
                String password = getPassword();
                String dateOfBirth = getDateOfBirth();
                frame.dispose();

                /*ajout du nouveau user dans la database*/
                model.User user = new User(firstName,lastName,type,password,dateOfBirth);
                try {
                    NewUser.AddNewUser(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                ShowIdUser showId = new ShowIdUser(user.getId());

            }
        });




        JLabel emptyLabel = new JLabel("Sign Up", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);

        JPanel p = new JPanel(new GridLayout(6, 2));
        p.add(new JLabel("First name"));
        p.add(jtFields[0]);
        p.add(new JLabel("Last name"));
        p.add(jtFields[1]);
        p.add(new JLabel("Patient or Volunteer"));
        p.add(jtFields[2]);
        p.add(new JLabel("New Password"));
        p.add(jtFields[3]);
        p.add(new JLabel("Date of birth"));
        p.add(jtFields[4]);


        p.add(button_signup);

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




}
