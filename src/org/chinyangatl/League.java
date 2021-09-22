package org.chinyangatl;

import java.util.ArrayList;

public class League {
    private ArrayList<Club> teams;
    private LeagueAdmin leagueAdmin;

    public League(LeagueAdmin leagueAdmin) {
        this.leagueAdmin = leagueAdmin;
        this.teams = new ArrayList<>();
    }

    public void crownChampion(Club club) {}

    public void relegateLastPlace(Club club) {}

    public void promoteTeam(Club club) {}

    // TODO ADD METHOD TO SHOW LEAGUE TABLE

    public ArrayList<Club> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Club> teams) {
        this.teams = teams;
    }
}
