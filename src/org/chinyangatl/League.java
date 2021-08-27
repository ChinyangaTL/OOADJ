package org.chinyangatl;

import java.util.ArrayList;

public class League {
    private ArrayList<Club> teams;

    public League(ArrayList<Club> teams) {
        this.teams = teams;
    }

    public void crownChampion(Club club) {}

    public void relegateLastPlace(Club club) {}

    public void promoteTeam(Club club) {}

    public ArrayList<Club> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Club> teams) {
        this.teams = teams;
    }
}
