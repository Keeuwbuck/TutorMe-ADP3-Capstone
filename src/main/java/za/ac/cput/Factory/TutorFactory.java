/* TutorFactory.java
      Tutor factory class
     Author: Henzley Spogter (230013309)
     Date: 18 May 2025
     */

package za.ac.cput.Factory;

import za.ac.cput.domain.Tutor;
import za.ac.cput.util.Helper;

public class TutorFactory {
    public static Tutor createTutor(int tutorID, double hourlyRate, String bio, double averageRating, boolean verificationStatus) {

        //Now we check if the incoming values are valid
        //With the help of the 'helper' class (pun intended)

        if (Helper.isNullOrEmpty(bio)) {
            return null;
        }
        return new Tutor.TutorBuilder()
                .setTutorID(tutorID)
                .setHourlyRate(hourlyRate)
                .setBio(bio)
                .setAverageRating(averageRating)
                .setVerificationStatus(verificationStatus)
                .build();
    }
}
