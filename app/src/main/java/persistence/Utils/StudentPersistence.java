package persistence.Utils;

import java.util.List;

public interface StudentPersistence {
    List<Student> getStudentSequential();

    List<Student> getStudentRandom(final Student currentStudent);

    Student insertStudent(final Student currentStudent);

    Student updateStudent(final Student currentStudent);

    void deleteStudent(final Student currentStudent);
}
