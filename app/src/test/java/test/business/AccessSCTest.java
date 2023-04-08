package test.business;


import org.junit.Before;
import org.junit.Test;

import persistence.Utils.SC;
import persistence.Utils.hsqldb.AccessSC;
import test.persistence.SCPersistenceStub;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessSCTest
{
	private AccessSC accessSC;

	@Before
    public void setUp() {
	    this.accessSC = new AccessSC(new SCPersistenceStub());
    }

    @Test
	public void test1()
	{
		System.out.println("\nStarting test AccessSC");

		final SC sc = accessSC.getCS("COMP3350");
		assertNotNull(sc);
		assertTrue("100".equals(sc.getStudentID()));

		System.out.println("Finished test AccessSC");
	}
}