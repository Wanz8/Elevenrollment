package persistence.Utils.hsqldb;

import java.util.Collections;
import java.util.List;

import persistence.Utils.Services;
import persistence.Utils.Student;
import persistence.Utils.StudentPersistence;

public class AccessStudents
{
	private StudentPersistence studentPersistence;
	private List<Student> students;
	private Student student;
	private int currentStudent;

	public AccessStudents()
	{
		studentPersistence = Services.getStudentPersistence();
		students = null;
		student = null;
		currentStudent = 0;
	}

	public AccessStudents(final StudentPersistence studentPersistence) {
	    this();
	    this.studentPersistence = studentPersistence;
    }
    public List<Student> getStudents()
    {
        students = studentPersistence.getStudentSequential();
        return Collections.unmodifiableList(students);
    }

    public Student getSequential()
    {
        if (students == null)
        {
            students = studentPersistence.getStudentSequential();
            currentStudent = 0;
        }
        if (currentStudent < students.size())
        {
            student = students.get(currentStudent);
            currentStudent++;
        }
        else
        {
            students = null;
            student = null;
            currentStudent = 0;
        }
        return student;
    }

	public Student getRandom(String studentID)
	{
		student = null;
		if (studentID.trim().equals(""))
		{
			//System.out.println("*** Invalid student number");
		}
		else
		{
			students = studentPersistence.getStudentRandom(new Student(studentID));
			if (students.size()==1)
			{
				student = (Student) students.get(0);
			}
		}
		return student;
	}

	public Student insertStudent(Student currentStudent)
	{
		return studentPersistence.insertStudent(currentStudent);
	}

	public Student updateStudent(Student currentStudent)
	{
		return studentPersistence.updateStudent(currentStudent);
	}

	public void deleteStudent(Student currentStudent)
	{
		studentPersistence.deleteStudent(currentStudent);
	}
}
