package org.chinyangatl;

import java.awt.*;

public class Goalkeeper extends Player{
    private int numberOfSaves;

    public Goalkeeper() {
        this.setPosition(PlayerPositions.GOALKEEPER);
    }

    public Goalkeeper(String firstName, String lastName, String age, String regNumber, int jerseyNumber, Image profilePhoto, int yellowCards, int redCards, int numberOfSaves) {
        super(firstName, lastName, age, regNumber, jerseyNumber, profilePhoto, yellowCards, redCards);
        this.numberOfSaves = numberOfSaves;
        this.position = PlayerPositions.GOALKEEPER;
    }

    public int getNumberOfSaves() {
        return numberOfSaves;
    }

    public void setNumberOfSaves(int numberOfSaves) {
        this.numberOfSaves = numberOfSaves;
    }
}
