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

        assertEquals(fullJob.getName(), "Product tester");
        assertEquals(fullJob.getEmployer().getValue(), "ACME");
        assertEquals(fullJob.getLocation().getValue(), "Desert");
        assertEquals(fullJob.getPositionType().getValue(), "Quality control");
        assertEquals(fullJob.getCoreCompetency().getValue(), "Persistence");

        assertTrue(fullJob.getName() instanceof String);
        assertTrue(fullJob.getEmployer() instanceof Employer);
        assertTrue(fullJob.getLocation() instanceof Location);
        assertTrue(fullJob.getPositionType() instanceof PositionType);
        assertTrue(fullJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job fullJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job fullJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(fullJob1.equals(fullJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job fullJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        int lastChar = fullJob.toString().charAt(fullJob.toString().length()-1);

        assertEquals(fullJob.toString().charAt(0), '\n');
        assertEquals(lastChar, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job fullJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(fullJob.toString(), "\nID: " + fullJob.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n");
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job emptyJob = new Job("Data not available", new Employer("Data not available"), new Location("Data not available"), new PositionType("Data not available"), new CoreCompetency("Data not available"));

        assertEquals(emptyJob.toString(), "\nID: " + emptyJob.getId() + "\n" +
                "Name: Data not available\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available\n");
    }
}
