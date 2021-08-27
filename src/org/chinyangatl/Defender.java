package org.chinyangatl;

import java.awt.*;

public class Defender extends Player{
    private int numberOfTackles;

    public Defender() {
        this.setPosition("Defender");
    }

    public Defender(String firstName, String lastName, String age, String regNumber, int jerseyNumber, String position, Image profilePhoto, int yellowCards, int redCards, int numberOfTackles) {
        super(firstName, lastName, age, regNumber, jerseyNumber, position, profilePhoto, yellowCards, redCards);
        this.numberOfTackles = numberOfTackles;
    }

    public int getNumberOfTackles() {
        return numberOfTackles;
    }

    public void setNumberOfTackles(int numberOfTackles) {
        this.numberOfTackles = numberOfTackles;
    }
}
