package za.ac.cput.util;

import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {
    //generate specified ID
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    //helper method to check for nulls and proper inputs
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    //valid email format
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    //helper method to check if email is valid
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();


    }

    public static boolean isValidspesializedRate(double spesializedRate) {
        if (spesializedRate >=0.00|| spesializedRate <=10.00) {
            return false;
        }
        return true;

    }
}



