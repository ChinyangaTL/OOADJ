package org.chinyangatl;

public class TeamAdmin extends EndUser {
    public TeamAdmin() {
    }

    public TeamAdmin(String firstName, String lastName, String age) {
        super(firstName, lastName, age);
    }

    public void updateStadiumInfo(Stadium stadium){}

    public void updatePlayerInfo(Player player){}

    public void updateManagerInfo(Manager manager) {}

    public void updateClubInfo(Club club) {}
}
