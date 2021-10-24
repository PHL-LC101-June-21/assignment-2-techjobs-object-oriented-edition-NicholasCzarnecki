package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    private final int id;
    private static int nextId = 1;
    private String value;

    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {  //I was using this to validate the values passed to the Job constructor for Employer, Location, PositionType, and CoreCompetency.
        // The commented code would set it to "Data not available" but the assignment seems to want it all done in the toString method.
//        if(value.isBlank()){
//            return "Data not available";
//        } else {
        return value;
//        }
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return getId() == jobField.getId() && getValue().equals(jobField.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue());
    }
}
