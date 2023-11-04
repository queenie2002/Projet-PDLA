package view;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login {

    private static void createAndShowGUI () {
        JTextField[] jtFields = new JTextField[3];
        jtFields[0] = new JTextField();
        jtFields[1] = new JTextField();

        JButton button_login = new JButton("login");
        button_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                /*get text and verify that the password corresponds to the username*/
                String username = jtFields[0].getText();
                String password = jtFields[1].getText();
                System.out.println(username);
                System.out.println(password);

            }
        });

        //create and set up window
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("Login", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);

        JPanel p = new JPanel(new GridLayout(1,2));
        p.add(new JLabel("Username"));
        p.add(jtFields[0]);
        p.add(new JLabel("Password"));
        p.add(jtFields[1]);

        p.add(button_login, p);
        frame.add(p);


        // make window's dimension fit its content
        frame.pack();
        // Display the window.
        frame.setVisible(true);
        
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
