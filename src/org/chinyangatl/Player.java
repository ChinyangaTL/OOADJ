package org.chinyangatl;

import java.awt.*;

public abstract class Player extends EndUser{
    private String regNumber;
    private int jerseyNumber;
    private String position;
    private Image profilePhoto;
    private int yellowCards;
    private int redCards;

    public Player() {
    }

    public Player(String firstName, String lastName, String age, String regNumber, int jerseyNumber, String position, Image profilePhoto, int yellowCards, int redCards) {
        super(firstName, lastName, age);
        this.regNumber = regNumber;
        this.jerseyNumber = jerseyNumber;
        this.position = position;
        this.profilePhoto = profilePhoto;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
    }

    public boolean missesNextGame(int yellowCards) {
        return false;
    }

    public boolean missesNextTwoGames() {
        return false;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Image getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(Image profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }
}
