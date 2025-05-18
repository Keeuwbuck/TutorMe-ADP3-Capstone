package za.ac.cput.Factory;

/*  UserFactory.java
    User Factory class
    Author: Hope Ringane (221174109)
    Date: 18 May 2025
 */


import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {

    public static User createUser(String firstName, String lastName, Long idNumber, String phoneNumber, String email, String password) {


        String userId = Helper.generateId();

        return new User.Builder()
                .setUserId(userId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setIdNumber(idNumber)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setPassword(password)
                .build();
    }
}

