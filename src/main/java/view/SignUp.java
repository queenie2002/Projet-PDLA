package view;
import controller.NewUser;
import model.User;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignUp {

  private final JTextField[] jtFields = new JTextField[4];
  private final JPasswordField jpField = new JPasswordField();



    public SignUp () {

        JFrame frame = new JFrame("Geo & Queen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel signupLabel = new JLabel("Sign Up", JLabel.CENTER);
        signupLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(signupLabel, BorderLayout.PAGE_START);


        //we create textfields for the user to fill in
        jtFields[0] = new JTextField();
        jtFields[1] = new JTextField();
        jtFields[2] = new JTextField();
        jtFields[3] = new JTextField();

        JButton button_signup = new JButton("Sign Up");
        JButton button_prev = new JButton("Previous");

        //signs up the user
        button_signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //we get the data the user filled in
                String firstName = getFirstName();
                String lastName = getLastName();
                int type = getType();
                String password = getPassword();
                String dateOfBirth = getDateOfBirth();

                //we close the frame
                frame.dispose();

                //adding the new user in the database
                model.User user = new User(firstName,lastName,type,password,dateOfBirth);
                try {
                    NewUser.AddNewUser(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                //it opens the next frame
                ShowIdUser showId = new ShowIdUser(user.getId());

            }
        });

        //goes back to previous frame
        button_prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                SignUpOrLogIn signuporlogin = new SignUpOrLogIn();
                frame.dispose();
            }
        });

        //we create a panel and add the components
        JPanel p = new JPanel(new GridLayout(6, 2));
        p.add(new JLabel("First name"));
        p.add(jtFields[0]);
        p.add(new JLabel("Last name"));
        p.add(jtFields[1]);
        p.add(new JLabel("Patient or Volunteer"));
        p.add(jtFields[2]);
        p.add(new JLabel("New Password"));
        p.add(jpField);
        p.add(new JLabel("Date of birth"));
        p.add(jtFields[3]);

        p.add(button_prev);
        p.add(button_signup);

        frame.add(p);


        frame.setSize(500, 600);
        //center frame on screen
        frame.setLocationRelativeTo(null);
        // display the window.
        frame.setVisible(true);
    }

    public String getFirstName() {
        return this.jtFields[0].getText();
    }

    public String getLastName() {
        return this.jtFields[1].getText();
    }
    public int getType() {
        //checks the type, converts "patient" string into integer, ignoring upper and lowercase
        if (this.jtFields[2].getText().equalsIgnoreCase("patient")) {
            return 0;
        } else if (this.jtFields[2].getText().equalsIgnoreCase("volunteer")) {
            return 1;
        } else if (this.jtFields[2].getText().equalsIgnoreCase("guarantor")) {
            return 2;
        } else {
            System.out.println("error: we didn't give right type (in SignUp)");
            return -1;
        }
    }

    public String getPassword() {
        return this.jpField.getText();
    }
    public String getDateOfBirth() {
        return this.jtFields[3].getText();
    }
}
