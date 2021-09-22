package org.chinyangatl;

import java.awt.*;

public abstract class Player extends EndUser{
    protected String regNumber;
    protected int jerseyNumber;
    protected PlayerPositions position;
    protected Image profilePhoto;
    protected int yellowCards;
    protected int redCards;

    public enum PlayerPositions {
        GOALKEEPER,
        DEFENDER,
        MIDFIELDER,
        STRIKER
    }

    public Player() {
    }

    public Player(String firstName, String lastName, String age, String regNumber, int jerseyNumber, Image profilePhoto, int yellowCards, int redCards) {
        super(firstName, lastName, age);
        this.regNumber = regNumber;
        this.jerseyNumber = jerseyNumber;
        this.position = position;
        this.profilePhoto = profilePhoto;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
    }

//    TODO MAYBE USE ENUMS FOR POSITION INSTEAD OF STRINGS ?

    @Override
    public void login() {
        System.out.println("Player login");
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
        return position.toString();
    }

    public void setPosition(PlayerPositions position) {
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
