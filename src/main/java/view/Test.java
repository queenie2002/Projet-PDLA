package view;

public class Test {

    public static void main(String[] args) {
        Login.main(args);


        String user = Login.getUsername();
        String pwd = Login.getPassword();
        System.out.println(user);
        System.out.println(pwd);

    }
}
