package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testUser() {
        User user1 = new User("Y-Quynh", "Nguyen", 0, "pwd", "2002-12-12");
        User user2 = new User("Y-Quynh", "Nguyen", 0, "pwd", "2002-12-12");
        //assertEquals(user2,user1, "should be the same");

        int id = user1.getId();
        int id2 = user2.getId();
        String firstname = user1.getFirstName();
        String lastname = user1.getLastName();
        int type = user1.getType();
        String password = user1.getPassword();
        String birthday = user1.getDateOfBirth();



        assertEquals(1, id, "id should be 1");
        assertEquals(2, id2, "id2 should be 2");

        assertEquals("Y-Quynh", firstname, "firstname should be Y-Quynh");
        assertEquals("Nguyen", lastname, "lastname should be Nguyen");
        assertEquals(0, type, "type should be 0");
        assertEquals("pwd", password, "password should be pwd");
        assertEquals("2002-12-12", birthday, "birthday should be 2002-12-12");

    }
}
