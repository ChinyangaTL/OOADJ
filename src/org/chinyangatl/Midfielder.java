package org.chinyangatl;

import java.awt.*;

public class Midfielder extends Player{
    private int numberOfPasses;

    public Midfielder() {
        this.setPosition("Midfielder");
    }

    public Midfielder(String firstName, String lastName, String age, String regNumber, int jerseyNumber, String position, Image profilePhoto, int yellowCards, int redCards, int numberOfPasses) {
        super(firstName, lastName, age, regNumber, jerseyNumber, position, profilePhoto, yellowCards, redCards);
        this.numberOfPasses = numberOfPasses;
    }

    public int getNumberOfPasses() {
        return numberOfPasses;
    }

    public void setNumberOfPasses(int numberOfPasses) {
        this.numberOfPasses = numberOfPasses;
    }
}
