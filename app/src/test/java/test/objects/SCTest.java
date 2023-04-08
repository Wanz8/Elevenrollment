package test.objects;

import org.junit.Test;

import persistence.Utils.Course;
import persistence.Utils.SC;
import persistence.Utils.Student;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SCTest
{
	@Test
	public void testSC1()
	{
		SC sc;

		System.out.println("\nStarting testSC");

		final Student s = new Student("123", "Joe", "123 Fake Street","1000");
		final Course c = new Course("12345", "Software Engineering I","1000");
		sc = new SC(s, c, "A");
		assertNotNull(sc);
		assertTrue("123".equals(sc.getStudentID()));
		assertTrue("12345".equals(sc.getCourseID()));
		assertTrue("Joe".equals(sc.getStudentName()));
		assertTrue("Software Engineering I".equals(sc.getCourseName()));
		assertTrue("A".equals(sc.getGrade()));

		System.out.println("Finished testSC");
	}
}