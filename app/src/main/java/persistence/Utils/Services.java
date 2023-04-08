package persistence.Utils;

import persistence.Utils.hsqldb.CoursePersistenceHSQLDB;
import persistence.Utils.hsqldb.SCPersistenceHSQLDB;
import persistence.Utils.hsqldb.StudentPersistenceHSQLDB;

public class Services
{
	private static StudentPersistence studentPersistence = null;
	private static CoursePersistence coursePersistence = null;
	private static SCPersistence scPersistence = null;

	public static synchronized StudentPersistence getStudentPersistence()
    {
		if (studentPersistence == null)
		{
            studentPersistence = new StudentPersistenceHSQLDB(Main.getDBPathName());
        }

        return studentPersistence;
	}

    public static synchronized CoursePersistence getCoursePersistence()
    {
        if (coursePersistence == null)
        {
            coursePersistence = new CoursePersistenceHSQLDB(Main.getDBPathName());
        }

        return coursePersistence;
    }

	public static synchronized SCPersistence getScPersistence() {
        if (scPersistence == null) {
            scPersistence = new SCPersistenceHSQLDB(Main.getDBPathName());
        }

        return scPersistence;
    }
}
