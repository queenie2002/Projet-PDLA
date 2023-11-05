package view;
/*POUR RÉCUPÉRER LE USERNAME ET LE PASSWORD DE LOGIN*/

public class UserCredentialsManager {
    private static String username;
    private static String password;

    public static void setCredentials(String username, String password) {
        UserCredentialsManager.username = username;
        UserCredentialsManager.password = password;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
