package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.business.AccessCoursesTest;
import test.business.AccessSCTest;
import test.business.AccessStudentsTest;
import test.business.CalculateGPATest;
import test.objects.CourseTest;
import test.objects.SCTest;
import test.objects.StudentTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        StudentTest.class,
        CourseTest.class,
        SCTest.class,
        CalculateGPATest.class,
        AccessCoursesTest.class,
        AccessStudentsTest.class,
        AccessSCTest.class
})
public class AllTests
{
}
