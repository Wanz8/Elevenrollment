package test.objects;

import org.junit.Test;

import persistence.Utils.Student;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class StudentTest
{
	@Test
	public void testStudent1()
	{
		Student student;
		
		System.out.println("\nStarting testStudent");
		
		student = new Student("123", "Joe", "12 Street","1000");
		assertNotNull(student);
		assertTrue("123".equals(student.getStudentID()));
		assertTrue("Joe".equals(student.getStudentName()));
		assertTrue("12 Street".equals(student.getStudentAddress()));
		assertTrue("1000".equals(student.getStudentPrice()));
		
		System.out.println("Finished testStudent");
	}
}