package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/* Student.java
      Tutor POJO class
     Author: Henzley Spogter (230013309)
     Date: 11 May 2025
     */
@Entity
public class Student extends User {
    @Id
    private String studentID;
    private String studentNumber;
    private String studentCourse;
    private String yearOfStudy;

    public Student() {
        super();
    }

    private Student(StudentBuilder builder) {

        // to construct User object
        super(new UserBuilder()
                .setUserId(builder.userId)
                .setFirstName(builder.firstName)
                .setLastName(builder.lastName)
                .setPhoneNumber(builder.phoneNumber)
                .setEmail(builder.email)
                .setPassword(builder.password));

        this.studentID = builder.studentID;
        this.studentNumber = builder.studentNumber;
        this.studentCourse = builder.studentCourse;
        this.yearOfStudy = builder.yearOfStudy;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    @Override
    public String toString() {
        // add User toString() method
        return super.toString() +
                "Student [studentID=" + studentID + "," +
                " studentNumber=" + studentNumber + "," +
                " studentCourse=" + studentCourse + "," +
                " yearOfStudy=" + yearOfStudy + "]";

    }

    //Implementation of the builder class
    public static class StudentBuilder extends UserBuilder {

        private String studentID;
        private String studentNumber;
        private String studentCourse;
        private String yearOfStudy;


        public StudentBuilder(String studentID,
                              String studentNumber,
                              String studentCourse,
                              String yearOfStudy) {
            this.studentID = studentID;
            this.studentNumber = studentNumber;
            this.studentCourse = studentCourse;
            this.yearOfStudy = yearOfStudy;
        }

        public StudentBuilder() {
        }

        @Override
        public StudentBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        @Override
        public StudentBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public StudentBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public StudentBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        @Override
        public StudentBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public StudentBuilder setStudentID(String studentID) {
            this.studentID = studentID;
            return this;
        }

        public StudentBuilder setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public StudentBuilder setStudentCourse(String studentCourse) {
            this.studentCourse = studentCourse;
            return this;
        }

        public StudentBuilder setYearOfStudy(String yearOfStudy) {
            this.yearOfStudy = yearOfStudy;
            return this;
        }

        public StudentBuilder copy(Student student) {
            this.studentID = student.studentID;
            this.studentNumber = student.studentNumber;
            this.studentCourse = student.studentCourse;
            this.yearOfStudy = student.yearOfStudy;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
