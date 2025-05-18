package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Factory.UserFactory;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void createUser() {
        User user = UserFactory.createUser(
                "John",
                "Doe",
                9001234567890L,
                "0821234567",
                "john.doe@example.com",
                "password123"
        );

        assertNotNull(user);
        assertNotNull(user.getUserId());
        assertEquals("John", user.getUserName());
        assertEquals("Doe", user.getUserSurname());
        assertEquals(9001234567890L, user.getIdNumber());
        assertEquals("0821234567", user.getPhoneNumber());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());

        System.out.println(user);
    }
}
