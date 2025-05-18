package za.ac.cput.util;

import java.util.UUID;

public class Helper {
    //generate specified ID
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
