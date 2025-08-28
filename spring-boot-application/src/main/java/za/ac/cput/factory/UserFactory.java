package za.ac.cput.factory;

/*  UserFactory.java
    User Factory class
    Author: Hope Ringane (221174109)
    Date: 18 May 2025
 */


import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {

    public static User createUser(String firstName,
                                  String lastName,
                                  String phoneNumber,
                                  String email,
                                  String password) {

        // generate unique userId
        String userId = Helper.generateId();

        // check if values are null or empty
        if (Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(phoneNumber) ||
                Helper.isNullOrEmpty(email) ||
                Helper.isNullOrEmpty(password)) {
            return null;
        }

        // check if firstName is valid
        if (!Helper.isValidFirstName(firstName)) {
            return null;
        }

        // check if lastName is valid
        if (!Helper.isValidLastName(lastName)) {
            return null;
        }

        // check if phoneNumber is valid
        if (!Helper.isValidPhone(phoneNumber)) {
            return null;
        }

        // check if email is valid
        if (!Helper.isValidEmail(email)) {
            return null;
        }

        // check if password is valid
        if (!Helper.isValidPassword(password)) {
            return null;
        }

        return new User.UserBuilder()
                .setUserId(userId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setPassword(password)
                .build();
    }
}

