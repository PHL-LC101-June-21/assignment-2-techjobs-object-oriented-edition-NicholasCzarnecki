package org.launchcode.techjobs.oo;

import java.util.ArrayList;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;


    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        //I was using this to validate the name and set it to "Data not available" if the field was blank
        // but the assignment seems to want it all done in the toString method
//        if(name.isBlank()) {
//            this.name = "Data not available";
//        } else {
            this.name = name;
//        }

        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString(){

        int blankFieldCount = 0;

        ArrayList<String> jobEntries = new ArrayList<String>();
        jobEntries.add(name);
        jobEntries.add(employer.getValue());
        jobEntries.add(location.getValue());
        jobEntries.add(positionType.getValue());
        jobEntries.add(coreCompetency.getValue());

        for (int i = 0; i < jobEntries.size(); i++ ){
            if (jobEntries.get(i).isBlank()){
                jobEntries.set(i, "Data not available");
                blankFieldCount++;
            }
        }

        if (blankFieldCount == 5){
            return "OOPS! This job does not seem to exist";
        } else {
            return "\nID: " + id + "\n" +
                    "Name: " + jobEntries.get(0) + "\n" +
                    "Employer: " + jobEntries.get(1) + "\n" +
                    "Location: " + jobEntries.get(2) + "\n" +
                    "Position Type: " + jobEntries.get(3) + "\n" +
                    "Core Competency: " + jobEntries.get(4) + "\n";
        }
        //If all the validation for empty fields was getting done through the getValue method in JobField I would use the code below
//        return "\nID: " + id + "\n" +
//                "Name: " + name + "\n" +
//                "Employer: " + employer.getValue() + "\n" +
//                "Location: " + location.getValue() + "\n" +
//                "Position Type: " + positionType.getValue() + "\n" +
//                "Core Competency: " + coreCompetency.getValue() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }
}
