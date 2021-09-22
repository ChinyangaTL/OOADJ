package org.chinyangatl;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Club {
    private String name;
    private String address;
    private ArrayList<String> owners;
    private Image logo;
    private Stadium stadium;
    private TeamAdmin teamAdmin;
    private List<Player> players;
    private Manager manager;
    private int points;

    public Club(String name, String address, Stadium stadium) {
        this.name = name;
        this.address = address;
        this.stadium = stadium;
    }

    public Club(String name, String address, ArrayList<String> owners, Image logo, Stadium stadium, TeamAdmin teamAdmin, Manager manager, int points) {
        this.name = name;
        this.address = address;
        this.owners = owners;
        this.logo = logo;
        this.stadium = stadium;
        this.teamAdmin = teamAdmin;
        this.players = new ArrayList<>();;
        this.manager = manager;
        this.points = points;
    }

    public void buyPlayer(Player player, int numOfPlayers) {
    }

    public void sellPlayer(Player player) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<String> getOwners() {
        return owners;
    }

    public void setOwners(ArrayList<String> owners) {
        this.owners = owners;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public TeamAdmin getTeamAdmin() {
        return teamAdmin;
    }

    public void setTeamAdmin(TeamAdmin teamAdmin) {
        this.teamAdmin = teamAdmin;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void printPlayers() {
        for (Player player : players) {
            System.out.println(player);
        }
    }
}
