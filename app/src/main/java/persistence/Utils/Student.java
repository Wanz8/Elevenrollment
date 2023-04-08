package persistence.Utils;

import java.util.Objects;

public class Student {
    private final String studentID;
    private final String studentName;
    private final String studentAddress;
    private final String studentPrice;

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentPrice='" + studentPrice + '\'' +
                '}';
    }

    public Student(final String newID) {
        this.studentID = newID;
        this.studentName = null;
        this.studentAddress = null;
        this.studentPrice = null;
    }

    public Student(final String newID, final String newStudentName, final String newStudentAddress, String studentPrice) {
        this.studentID = newID;
        this.studentName = newStudentName;
        this.studentAddress = newStudentAddress;
        this.studentPrice = studentPrice;
    }


    public String getStudentID() {
        return (studentID);
    }

    public String getStudentName() {
        return (studentName);
    }

    public String getStudentAddress() {
        return (studentAddress);
    }

    public String getStudentPrice() {
        return (studentPrice);
    }

    public int hashCode() {
        return Objects.hash(studentID, studentName, studentAddress, studentPrice);
    }

    public boolean equals(Object other) {
        boolean equals = false;

        if (other instanceof Student) {
            final Student otherStudent = (Student) other;
            equals = Objects.equals(this.studentID, otherStudent.studentID);
        }

        return equals;
    }
}
