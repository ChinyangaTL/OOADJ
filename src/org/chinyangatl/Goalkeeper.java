package org.chinyangatl;

import java.awt.*;

public class Goalkeeper extends Player{
    private int numberOfSaves;

    public Goalkeeper() {
        this.setPosition("Goalkeeper");
    }

    public Goalkeeper(String firstName, String lastName, String age, String regNumber, int jerseyNumber, String position, Image profilePhoto, int yellowCards, int redCards, int numberOfSaves) {
        super(firstName, lastName, age, regNumber, jerseyNumber, position, profilePhoto, yellowCards, redCards);
        this.numberOfSaves = numberOfSaves;
    }

    public int getNumberOfSaves() {
        return numberOfSaves;
    }

    public void setNumberOfSaves(int numberOfSaves) {
        this.numberOfSaves = numberOfSaves;
    }
}
