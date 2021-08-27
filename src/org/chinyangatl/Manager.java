package org.chinyangatl;

public class Manager extends EndUser{
    private String currentClub;
    private String previousClub;
    private String coachingLicense;

    public Manager(String firstName, String lastName, String age, String currentClub, String previousClub, String coachingLicense) {
        super(firstName, lastName, age);
        this.currentClub = currentClub;
        this.previousClub = previousClub;
        this.coachingLicense = coachingLicense;
    }

    public String getCurrentClub() {
        return currentClub;
    }

    public void setCurrentClub(String currentClub) {
        this.currentClub = currentClub;
    }

    public String getPreviousClub() {
        return previousClub;
    }

    public void setPreviousClub(String previousClub) {
        this.previousClub = previousClub;
    }

    public String getCoachingLicense() {
        return coachingLicense;
    }

    public void setCoachingLicense(String coachingLicense) {
        this.coachingLicense = coachingLicense;
    }
}
