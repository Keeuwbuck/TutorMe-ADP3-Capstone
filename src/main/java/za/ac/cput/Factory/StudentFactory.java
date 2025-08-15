/* StudentFactory.java
      Student Factory class
     Author: Henzley Spogter (230013309)
     Date: 18 May 2025
     */

package za.ac.cput.Factory;

import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {
    public static Student createStudent(int studentID, String studentNumber, String studentCourse, String yearOfStudy) {

        //Same story, validating the incoming values with the helper class
        if(Helper.isNullOrEmpty(studentNumber) || Helper.isNullOrEmpty(studentCourse) || Helper.isNullOrEmpty(yearOfStudy)) {
            return null;
        }

        return new Student.StudentBuilder()
                .setStudentID(studentID)
                .setStudentNumber(studentNumber)
                .setStudentCourse(studentCourse)
                .setYearOfStudy(yearOfStudy)
                .build();
    }
}
