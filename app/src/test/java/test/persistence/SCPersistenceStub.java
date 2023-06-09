package test.persistence;

import java.util.ArrayList;
import java.util.List;

import persistence.Utils.Course;
import persistence.Utils.SC;
import persistence.Utils.SCPersistence;
import persistence.Utils.Student;

public class SCPersistenceStub implements SCPersistence {

    private List<SC> scs;

    public SCPersistenceStub() {
        this.scs = new ArrayList<>();
        final Course comp3010 = new Course("COMP3010", "Distributed Computing","1000");
        final Course comp3020 = new Course("COMP3020", "Human-Computer Interaction","1000");
        final Course comp3350 = new Course("COMP3350", "Software Engineering I","1000");
        final Course comp3380 = new Course("COMP3380", "Databases","1000");

        final Student gary = new Student("100", "Gary Chalmers", "Management","1000");
        final Student selma = new Student("200", "Selma Bouvier", "University Centre","1000");
        final Student arnie = new Student("300", "Arnie Pye", "Frank Kennedy","1000");
        final Student mary = new Student("400", "Mary Bailey", "Off Campus","1000");

        this.scs.add(new SC(gary, comp3010, "C+"));
        this.scs.add(new SC(selma, comp3020, "A+"));
        this.scs.add(new SC(gary, comp3350, "A"));
        this.scs.add(new SC(arnie, comp3380, "B"));
        this.scs.add(new SC(gary, comp3020, "A"));
        this.scs.add(new SC(mary, comp3010, "B"));

    }

    @Override
    public List<SC> getSC(String studentID) {
        List<SC> newSCs;
        SC sc;
        int counter;

        // get the SC objects with the same studentID as currentSC
        newSCs = new ArrayList<>();
        for (counter=0; counter<scs.size(); counter++)
        {
            sc = scs.get(counter);
            if (sc.getStudentID().equals(studentID))
            {
                newSCs.add(scs.get(counter));
            }
        }
        return newSCs;
    }

    @Override
    public List<SC> getCS(String courseID) {
        List<SC> newSCs;
        SC cs;
        int counter;

        // get the SC objects with the same courseID as currentSC
        newSCs = new ArrayList<>();
        for (counter=0; counter<scs.size(); counter++)
        {
            cs = scs.get(counter);
            if (cs.getCourseID().equals(courseID))
            {
                newSCs.add(scs.get(counter));
            }
        }
        return newSCs;
    }
}
