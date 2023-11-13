package view;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
public class SignUp {
    private static Consumer<String[]> credentialsCallback;

    public static void setCredentialsCallback(Consumer<String[]> callback) {
        credentialsCallback = callback;
    }
  private JTextField[] jtFields = new JTextField[4];
    public SignUp() {
        // Initialize the GUI components
        createAndShowGUI();
    }

    private void createAndShowGUI() {

        jtFields[0] = new JTextField();
        jtFields[1] = new JTextField();
        jtFields[2] = new JTextField();
        jtFields[3] = new JTextField();

        JButton button_signup = new JButton("sign up");
        button_signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = getFirstName();
                String lastName = getLastName();
                String type = getType();
                String password = getPassword();

                // Set the credentials in the UserCredentialsManager
                UserCredentialsManager.setCredentials(firstName, lastName,type, password);

               // if (credentialsCallback != null) {
              //      credentialsCallback.accept(new String[]{username, password});
            }
        });

        // Create and set up the window
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("Sign Up", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);

        JPanel p = new JPanel(new GridLayout(5, 2));
        p.add(new JLabel("First name"));
        p.add(jtFields[0]);
        p.add(new JLabel("Last name"));
        p.add(jtFields[1]);
        p.add(new JLabel("Patient or Volunteer"));
        p.add(jtFields[2]);
        p.add(new JLabel("New Password"));
        p.add(jtFields[3]);

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
    public String getType() {
        return this.jtFields[2].getText();
    }

    public String getPassword() {
        return this.jtFields[3].getText();
    }


    /*public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }*/
}
