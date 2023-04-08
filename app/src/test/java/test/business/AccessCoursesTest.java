package test.business;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import persistence.Utils.Course;
import persistence.Utils.CoursePersistence;
import persistence.Utils.hsqldb.AccessCourses;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class AccessCoursesTest
{
	private AccessCourses accessCourses;
	private CoursePersistence coursePersistence;

	@Before
    public void setUp() {
	    coursePersistence = mock(CoursePersistence.class);
	    accessCourses = new AccessCourses(coursePersistence);
    }

    @Test
	public void test1()
	{
		final Course course;

		System.out.println("\nStarting test AccessCourses");
        final List<Course> courses = new ArrayList<>();
        courses.add(new Course("COMP3010"));
		when(coursePersistence.getCourseSequential()).thenReturn(courses);

		course = accessCourses.getSequential();
		assertNotNull("first sequential course should not be null", course);
		assertTrue("COMP3010".equals(course.getCourseID()));

		verify(coursePersistence).getCourseSequential();

		System.out.println("Finished test AccessCourses");
	}
}