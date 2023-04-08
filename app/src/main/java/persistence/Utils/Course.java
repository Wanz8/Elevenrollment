package persistence.Utils;

import java.util.Objects;

public class Course {
    private final String courseID;
    private final String courseName;
    private final String coursePrice;

    public Course(final String newID) {
        courseID = newID;
        this.courseName = null;
        this.coursePrice = null;
    }

    public Course(final String newID, final String newCourseName, String studentPrice) {
        courseID = newID;
        courseName = newCourseName;
        this.coursePrice = studentPrice;
    }

    public String getCourseID() {
        return (courseID);
    }

    public String getCourseName() {
        return (courseName);
    }
    public String getCoursePrice() {
        return (coursePrice);
    }

    public String toString() {
        return String.format("Course: %s %s", courseID, courseName);
    }

    public int hashCode() {
        return Objects.hash(courseID, courseName);
    }

    public boolean equals(Object other) {
        boolean equals = false;
        if (other instanceof Course) {

            final Course otherCourse = (Course) other;
            equals = Objects.equals(this.courseID, otherCourse.courseID);

        }

        return equals;
    }
}
