package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MissionTabVolunteer {
    public MissionTabVolunteer (int idUser) {
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("Login", JLabel.CENTER);
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelLogout = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton button1 = new JButton("Show past missions");
        JButton button2 = new JButton("Add new mission");
        JButton button3 = new JButton("Available missions");
        JButton button_logout = new JButton("Log Out");
        button_logout.setPreferredSize(new Dimension(100, 30));
        panelLogout.add(button_logout, BorderLayout.SOUTH);

        /*show available mission*/
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ShowAvailableMissions availableMissions = new ShowAvailableMissions(idUser);
                frame.dispose();
            }
        });
        /*logout*/
        button_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SignUpOrLogIn signuporlogin = new SignUpOrLogIn();
                frame.dispose();
            }
        });

        panel.setBounds(50, 100, 200, 100);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panelLogout.add(button_logout);

        frame.setLayout(new BorderLayout());
        frame.add(panel);
        frame.add(panelLogout, BorderLayout.SOUTH);


        frame.setSize(200, 300);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }


}

