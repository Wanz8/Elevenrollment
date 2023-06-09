package test.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import persistence.Utils.Course;
import persistence.Utils.CoursePersistence;


public class CoursePersistenceStub implements CoursePersistence {
    private List<Course> courses;

    public CoursePersistenceStub() {
        this.courses = new ArrayList<>();

        courses.add(new Course("COMP3010", "Distributed Computing","1000"));
        courses.add(new Course("COMP3020", "Human-Computer Interaction","1000"));
        courses.add(new Course("COMP3350", "Software Engineering I","1000"));
        courses.add(new Course("COMP3380", "Databases","1000"));
    }
    @Override
    public List<Course> getCourseSequential() {
        return Collections.unmodifiableList(courses);
    }

    @Override
    public List<Course> getCourseRandom(Course currentCourse) {
        List<Course> newCourses = new ArrayList<>();
        int index;

        index = courses.indexOf(currentCourse);
        if (index >= 0)
        {
            newCourses.add(courses.get(index));
        }
        return newCourses;
    }

    @Override
    public Course insertCourse(Course currentCourse) {
        // don't bother checking for duplicates
        courses.add(currentCourse);
        return currentCourse;
    }

    @Override
    public Course updateCourse(Course currentCourse) {
        int index;

        index = courses.indexOf(currentCourse);
        if (index >= 0)
        {
            courses.set(index, currentCourse);
        }
        return currentCourse;
    }

    @Override
    public void deleteCourse(Course currentCourse) {
        int index;

        index = courses.indexOf(currentCourse);
        if (index >= 0)
        {
            courses.remove(index);
        }
    }
}
