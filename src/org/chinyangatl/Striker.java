package org.chinyangatl;

import java.awt.*;

public class Striker extends Player{
    private int numberOfGoals;

    public Striker() {
        this.setPosition(PlayerPositions.STRIKER);
    }

    public Striker(String firstName, String lastName, String age, String regNumber, int jerseyNumber, Image profilePhoto, int yellowCards, int redCards, int numberOfGoals) {
        super(firstName, lastName, age, regNumber, jerseyNumber, profilePhoto, yellowCards, redCards);
        this.numberOfGoals = numberOfGoals;
        this.position = PlayerPositions.STRIKER
    }

    public int getNumberOfGoals() {
        return numberOfGoals;
    }

    public void setNumberOfGoals(int numberOfGoals) {
        this.numberOfGoals = numberOfGoals;
    }
}
