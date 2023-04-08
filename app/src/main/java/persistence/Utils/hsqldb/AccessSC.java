package persistence.Utils.hsqldb;

import java.util.List;

import persistence.Utils.SC;
import persistence.Utils.SCPersistence;
import persistence.Utils.Services;


public class AccessSC
{
	private SCPersistence dataAccess;
	private List<SC> elements;

	private SC studentCourse;
	private int currentSC;

	private int currentCS;

	private String gpa;

	public AccessSC()
	{
		dataAccess = Services.getScPersistence();
		elements = null;
		currentSC = 0;
		currentCS = 0;
	}

	public AccessSC(final SCPersistence scPersistence) {
	    this();
	    this.dataAccess = scPersistence;
    }
	public SC getSC(String studentID)
	{
		if (elements == null)
		{
			elements = dataAccess.getSC(studentID);
			gpa =  Calculate.gpa(elements);
			currentSC = 0;
		}
		if (currentSC < elements.size())
		{
			studentCourse = elements.get(currentSC);
			currentSC++;
		}
		else
		{
			elements = null;
			studentCourse = null;
			currentSC = 0;
		}
		return studentCourse;
	}

	public SC getCS(String courseID)
	{
		if (elements == null)
		{
			elements = dataAccess.getCS(courseID);
			gpa = Calculate.gpa(elements);
			currentCS = 0;
		}
		if (currentCS < elements.size())
		{
			studentCourse = elements.get(currentCS);
			currentCS++;
		}
		else
		{
			elements = null;
			studentCourse = null;
			currentCS = 0;
		}
		return studentCourse;
	}

	public String getGPA()
	{
		return gpa;
	}
}
