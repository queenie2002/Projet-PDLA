package view;

public class Test {

    public static void main(String[] args) {
        Login login = new Login();

        // Register a callback to handle credentials
        login.setCredentialsCallback(credentials -> {
            String username = credentials[0];
            String password = credentials[1];

            // Use username and password as needed
            System.out.println("Username in Test: " + username);
            System.out.println("Password in Test: " + password);
        });


    }
}