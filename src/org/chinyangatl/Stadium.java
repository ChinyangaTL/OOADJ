package org.chinyangatl;

import java.util.Date;

public class Stadium {
    private String name;
    private int capacity;
    private String location;
    private Date yearOpened;
    private double pitchLength;
    private double pitchWidth;

    public Stadium(String name, int capacity, String location, Date yearOpened, double pitchLength, double pitchWidth) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
        this.yearOpened = yearOpened;
        this.pitchLength = pitchLength;
        this.pitchWidth = pitchWidth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getYearOpened() {
        return yearOpened;
    }

    public void setYearOpened(Date yearOpened) {
        this.yearOpened = yearOpened;
    }

    public double getPitchLength() {
        return pitchLength;
    }

    public void setPitchLength(double pitchLength) {
        this.pitchLength = pitchLength;
    }

    public double getPitchWidth() {
        return pitchWidth;
    }

    public void setPitchWidth(double pitchWidth) {
        this.pitchWidth = pitchWidth;
    }
}
