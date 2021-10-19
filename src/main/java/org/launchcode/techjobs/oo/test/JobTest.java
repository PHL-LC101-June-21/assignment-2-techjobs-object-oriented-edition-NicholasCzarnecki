package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
    Job fullJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    assertEquals(1,fullJob.getId());
    assertEquals("Product tester",fullJob.getName());
    assertEquals("ACME",fullJob.getEmployer().toString());
    assertEquals("Desert",fullJob.getLocation().toString());
    assertEquals("Quality control",fullJob.getPositionType().toString());
    assertEquals("Persistence",fullJob.getCoreCompetency().toString());

    assertTrue(fullJob instanceof Job);
    assertTrue(fullJob.getEmployer() instanceof Employer);
    assertTrue(fullJob.getLocation() instanceof Location);
    assertTrue(fullJob.getPositionType() instanceof PositionType);
    assertTrue(fullJob.getCoreCompetency() instanceof CoreCompetency);

    }

}
