package org.chinyangatl;

import java.util.Date;

public class Fixture {
    private Stadium venue;
    private Date date;
    private Club homeTeam;
    private Club awayTeam;
    private int homeTeamGoals;
    private int awayTeamGoals;

    public Fixture(Stadium venue, Date date, Club homeTeam, Club awayTeam) {
        this.venue = venue;
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Fixture(Stadium venue, Date date, Club homeTeam, Club awayTeam, int homeTeamGoals, int awayTeamGoals) {
        this.venue = venue;
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamGoals = awayTeamGoals;
    }

    public void distributePoints(Club homeTeam, int homeGoals, Club awayTeam, int awayTeamGoals) {

    }
}
