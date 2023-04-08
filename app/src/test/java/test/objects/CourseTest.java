package test.objects;

import org.junit.Test;

import persistence.Utils.Course;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CourseTest
{
	@Test
	public void testCourse1()
	{
		Course course;

		System.out.println("\nStarting testCourse");

		course = new Course("12345", "Software Development","100");
		assertNotNull(course);
		assertTrue("12345".equals(course.getCourseID()));
		assertTrue("Software Development".equals(course.getCourseName()));
		assertTrue("100".equals(course.getCoursePrice()));

		System.out.println("Finished testCourse");
	}
}