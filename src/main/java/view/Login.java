package view;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class Login {
    private static Consumer<String[]> credentialsCallback;

    public static void setCredentialsCallback(Consumer<String[]> callback) {
        credentialsCallback = callback;
    }

    private JTextField[] jtFields = new JTextField[2];

    public Login() {
        // Initialize the GUI components
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        jtFields[0] = new JTextField();
        jtFields[1] = new JTextField();

        JButton button_login = new JButton("login");
        button_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = getIdUser();
                String password = getPassword();

                // Set the credentials in the UserCredentialsManager
                UserCredentialsManager.setCredentials(username, password);

                if (credentialsCallback != null) {
                    credentialsCallback.accept(new String[]{username, password});
                }
            }
        });

        // Create and set up the window
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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