package za.ac.cput.factory;
/*  SessionFactoryTest.java
    Session Factory test class
    Author: Angelo Smidt - 230688020
    Date: 18 May 2025
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.Factory.SessionFactory;
import za.ac.cput.domain.Session;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SessionFactoryTest {
    /*@Test
    void createSession_Successful(){
        Session session = SessionFactory.createSession(12, 13, "CPUT", "Online", 25, "Under way", "None");
        assertEquals(12, session.getStartTime());
        assertEquals(13, session.getEndTime());
        assertEquals("CPUT", session.getLocation());
        assertEquals("Online", session.getMode());
        assertEquals(25, session.getCost());
        assertEquals("Under way", session.getStatus());
        assertEquals("None", session.getNotes());
    }*/
}
