package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void createUser() {
        User user = UserFactory.createUser(
                "John",
                "Doe",
                "0821234567",
                "johndoe@gmail.com",
                "Password123!"
        );

        assertNotNull(user);
        assertNotNull(user.getUserId());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("0821234567", user.getPhoneNumber());
        assertEquals("johndoe@gmail.com", user.getEmail());
        assertEquals("Password123!", user.getPassword());

        System.out.println(user);
    }
}
