package org.chinyangatl;

import java.awt.*;

public class Midfielder extends Player{
    private int numberOfPasses;

    public Midfielder() {
        this.setPosition(PlayerPositions.MIDFIELDER);
    }

    public Midfielder(String firstName, String lastName, String age, String regNumber, int jerseyNumber, Image profilePhoto, int yellowCards, int redCards, int numberOfPasses) {
        super(firstName, lastName, age, regNumber, jerseyNumber, profilePhoto, yellowCards, redCards);
        this.numberOfPasses = numberOfPasses;
        this.position =  PlayerPositions.MIDFIELDER;
    }

    public int getNumberOfPasses() {
        return numberOfPasses;
    }

    public void setNumberOfPasses(int numberOfPasses) {
        this.numberOfPasses = numberOfPasses;
    }
}
