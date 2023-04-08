package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.business.AccessCoursesIT;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessCoursesIT.class
})
public class IntegrationTests {
}
