package za.ac.cput.domain;

/* Student.java
      Tutor POJO class
     Author: Henzley Spogter (230013309)
     Date: 11 May 2025
     */

public class Student {
    private int studentID;
    private String studentNumber;
    private String studentCourse;
    private String yearOfStudy;

    public Student() {
    }

    private Student(StudentBuilder builder) {
        this.studentID = builder.studentID;
        this.studentNumber = builder.studentNumber;
        this.studentCourse = builder.studentCourse;
        this.yearOfStudy = builder.yearOfStudy;
    }

    public int getStudentID() {
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
        return "Student{" +
                "studentID=" + studentID +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentCourse='" + studentCourse + '\'' +
                ", yearOfStudy='" + yearOfStudy + '\'' +
                '}';
    }

    public static class StudentBuilder {
        private int studentID;
        private String studentNumber;
        private String studentCourse;
        private String yearOfStudy;

        public StudentBuilder(int studentID, String studentNumber, String studentCourse, String yearOfStudy) {
            this.studentID = studentID;
            this.studentNumber = studentNumber;
            this.studentCourse = studentCourse;
            this.yearOfStudy = yearOfStudy;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
