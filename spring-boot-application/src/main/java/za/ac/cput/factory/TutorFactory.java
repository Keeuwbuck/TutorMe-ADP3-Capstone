/* TutorFactory.java
      Tutor factory class
     Author: Henzley Spogter (230013309)
     Date: 18 May 2025
     */

package za.ac.cput.factory;

import za.ac.cput.domain.Tutor;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class TutorFactory {
    public static Tutor createTutor(String firstName,
                                    String lastName,
                                    String phoneNumber,
                                    String email,
                                    String password,
                                    double hourlyRate,
                                    String bio,
                                    double averageRating,
                                    boolean verificationStatus) {

        //generate tutorID
        String tutorID = Helper.generateId();

        // return null if user is equal to null
        User user = UserFactory.createUser(firstName, lastName, phoneNumber, email, password);
        if (user == null) {
            return null; // if the User validation fails
        }

        // check for null or empty
        if (Helper.isNullOrEmpty(bio) ||
                Helper.isNullOrEmpty(String.valueOf(hourlyRate)) ||
                Helper.isNullOrEmpty(String.valueOf(averageRating))) {
            return null;
        }

        // validate bio length
        if (!Helper.isValidBio(bio)) {
            return null;
        }


        return new Tutor.TutorBuilder()
                .setUserId(user.getUserId())        // Pass the User data
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPhoneNumber(user.getPhoneNumber())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setTutorID(tutorID)
                .setHourlyRate(hourlyRate)
                .setBio(bio)
                .setAverageRating(averageRating)
                .setVerificationStatus(verificationStatus)
                .build();
    }
}
