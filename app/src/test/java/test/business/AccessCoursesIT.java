package test.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import persistence.Utils.Course;
import persistence.Utils.CoursePersistence;
import persistence.Utils.hsqldb.AccessCourses;
import persistence.Utils.hsqldb.CoursePersistenceHSQLDB;
import test.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessCoursesIT {
    private AccessCourses accessCourses;
    private File tempDB;


    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final CoursePersistence persistence = new CoursePersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessCourses = new AccessCourses(persistence);
    }

    @Test
    public void testListCourses() {
        final Course course;

        course = accessCourses.getSequential();
        assertNotNull("first sequential course should not be null", course);

         assertTrue("COMP1010".equals(course.getCourseID()));

        System.out.println("Finished test AccessCourses"+course.getCourseID());
    }

    @Test
    public void testGetCourses() {
        final List<Course> courses = accessCourses.getCourses();
        assertEquals(14, courses.size());
    }

    @Test
    public void testDeleteCourse() {
        final Course c = accessCourses.getSequential();
        List<Course> courses = accessCourses.getCourses();
        assertEquals(14, courses.size());
        System.out.println("---------------s"+courses.size());
        accessCourses.deleteCourse(c);
        courses = accessCourses.getCourses();
        assertEquals(13, courses.size());
        System.out.println("F##############s"+courses.size());
    }

    @Test
    public void testInsertCourse() {
        final Course c = new Course("COMP1110", "AI","100");
        accessCourses.insertCourse(c);
        System.out.println("F##############s"+accessCourses.getCourses().size());
         assertEquals(15, accessCourses.getCourses().size());
    }

    @Test
    public void testUpdateCourse() {
        final Course c = accessCourses.getSequential();
        System.out.println("--------"+c.getCourseID());
        final Course u = new Course(c.getCourseID(), "A new name","100");
         accessCourses.updateCourse(u);
        System.out.println("F##############s"+accessCourses.getCourses().size());
         assertEquals(14, accessCourses.getCourses().size());
    }

    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }
}
