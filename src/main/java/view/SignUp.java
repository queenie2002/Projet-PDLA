package view;
import controller.NewUser;
import model.User;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignUp {

  private final JTextField[] jtFields = new JTextField[5];


    public SignUp () {

        jtFields[0] = new JTextField();
        jtFields[1] = new JTextField();
        jtFields[2] = new JTextField();
        jtFields[3] = new JTextField();
        jtFields[4] = new JTextField();

        JButton button_signup = new JButton("sign up");
        button_signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = getFirstName();
                String lastName = getLastName();
                int type = getType();
                String password = getPassword();
                String dateOfBirth = getDateOfBirth();

                /*ajout du nouveau user dans la database*/
                model.User user = new User(firstName,lastName,type,password,dateOfBirth);
                try {
                    NewUser.AddNewUser(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        // Create and set up the window
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

    public String getFirstName() {
        return this.jtFields[0].getText();
    }

    public String getLastName() {
        return this.jtFields[1].getText();
    }
    public int getType() {
        return Integer.parseInt(this.jtFields[2].getText());
    }

    public String getPassword() {
        return this.jtFields[3].getText();
    }
    public String getDateOfBirth() {
        return this.jtFields[4].getText();
    }


   /*public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }*/
}
