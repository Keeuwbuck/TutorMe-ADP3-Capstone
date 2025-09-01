/* StudentFactory.java
      Student Factory class
     Author: Henzley Spogter (230013309)
     Date: 18 May 2025
     */

package za.ac.cput.factory;

import za.ac.cput.domain.Student;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.util.Helper;

public class StudentFactory {
    public static Student createStudent(String firstName,
                                        String lastName,
                                        String phoneNumber,
                                        String email,
                                        String password,
                                        String studentNumber,
                                        String studentCourse,
                                        String yearOfStudy) {

        // generate unique studentID
        String studentID = Helper.generateId();

        // return null if user is equal to null
        User user = UserFactory.createUser(firstName, lastName, phoneNumber, email, password);
        if (user == null) {
            return null; // if the User validation fails
        }

        // check for null or empty
        if (Helper.isNullOrEmpty(studentNumber) ||
                Helper.isNullOrEmpty(studentCourse) ||
                Helper.isNullOrEmpty(yearOfStudy)) {
            return null;
        }

        //validate studentNumber
        if (!Helper.isValidStudentNumber(studentNumber)) {
            return null;
        }

        // validate studentCourse
        if (!Helper.isValidStudentCourse(studentCourse)) {
            return null;
        }

        // validate yearOfStudy
        if (!Helper.isValidYearOfStudy(yearOfStudy)) {
            return null;
        }

        return new Student.StudentBuilder()
                .setUserId(user.getUserId())        // Pass the User data
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPhoneNumber(user.getPhoneNumber())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setStudentId(studentID)
                .setStudentNumber(studentNumber)
                .setStudentCourse(studentCourse)
                .setYearOfStudy(yearOfStudy)
                .build();
    }
}
