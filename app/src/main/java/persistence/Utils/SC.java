package persistence.Utils;

import java.util.Objects;

public class SC
{
	private final Student student;
	private final Course course;
	private final String grade;

    public SC(final Student student, final Course course, final String grade)
    {
        this.student = student;
        this.course = course;
        this.grade = grade; // incomplete, course is in progress
    }

	public String getStudentID()
	{
		return (student.getStudentID());
	}

	public String getStudentName()
	{
		return (student.getStudentName());
	}

	public String getCourseID()
	{
		return (course.getCourseID());
	}

	public String getCourseName()
	{
		return (course.getCourseName());
	}

	public String getGrade()
	{
		return grade;
	}

	public String toString()
	{
		return String.format("SC: %s %s %s", student.getStudentID(), course.getCourseID(), grade);
	}

	public int hashCode()
	{
    	return Objects.hash(student, course, grade);
	}

	public boolean equals(final SC o)
	{
		return Objects.equals(this.student, o.student) &&
				Objects.equals(this.course, o.course) &&
				Objects.equals(this.grade, o.grade);
	}
}
